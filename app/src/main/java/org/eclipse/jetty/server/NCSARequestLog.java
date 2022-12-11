package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.http.Cookie;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.util.B64Code;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.RolloverFileOutputStream;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class NCSARequestLog extends AbstractLifeCycle implements RequestLog {
    public static final Logger LOG = Log.getLogger(NCSARequestLog.class);
    public static ThreadLocal<StringBuilder> _buffers = new ThreadLocal<StringBuilder>() { // from class: org.eclipse.jetty.server.NCSARequestLog.1
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder(256);
        }
    };
    public boolean _closeOut;
    public transient OutputStream _fileOut;
    public String _filename;
    public transient PathMap _ignorePathMap;
    public String[] _ignorePaths;
    public transient DateCache _logDateCache;
    public transient OutputStream _out;
    public boolean _preferProxiedForAddress;
    public transient Writer _writer;
    public String _logDateFormat = "dd/MMM/yyyy:HH:mm:ss Z";
    public String _filenameDateFormat = null;
    public Locale _logLocale = Locale.getDefault();
    public String _logTimeZone = "GMT";
    public boolean _logLatency = false;
    public boolean _logCookies = false;
    public boolean _logServer = false;
    public boolean _logDispatch = false;
    public boolean _extended = true;
    public boolean _append = true;
    public int _retainDays = 31;

    public NCSARequestLog() {
    }

    public NCSARequestLog(String str) {
        setFilename(str);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        if (this._logDateFormat != null) {
            DateCache dateCache = new DateCache(this._logDateFormat, this._logLocale);
            this._logDateCache = dateCache;
            dateCache.setTimeZoneID(this._logTimeZone);
        }
        if (this._filename != null) {
            this._fileOut = new RolloverFileOutputStream(this._filename, this._append, this._retainDays, TimeZone.getTimeZone(this._logTimeZone), this._filenameDateFormat, null);
            this._closeOut = true;
            Logger logger = LOG;
            logger.info("Opened " + getDatedFilename(), new Object[0]);
        } else {
            this._fileOut = System.err;
        }
        this._out = this._fileOut;
        if (this._ignorePaths == null || this._ignorePaths.length <= 0) {
            this._ignorePathMap = null;
        } else {
            this._ignorePathMap = new PathMap();
            for (int i = 0; i < this._ignorePaths.length; i++) {
                this._ignorePathMap.put(this._ignorePaths[i], this._ignorePaths[i]);
            }
        }
        synchronized (this) {
            this._writer = new OutputStreamWriter(this._out);
        }
        super.doStart();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            super.doStop();
            try {
                if (this._writer != null) {
                    this._writer.flush();
                }
            } catch (IOException e) {
                LOG.ignore(e);
            }
            if (this._out != null && this._closeOut) {
                try {
                    this._out.close();
                } catch (IOException e2) {
                    LOG.ignore(e2);
                }
            }
            this._out = null;
            this._fileOut = null;
            this._closeOut = false;
            this._logDateCache = null;
            this._writer = null;
        }
    }

    public String getDatedFilename() {
        OutputStream outputStream = this._fileOut;
        if (outputStream instanceof RolloverFileOutputStream) {
            return ((RolloverFileOutputStream) outputStream).getDatedFilename();
        }
        return null;
    }

    public String getFilename() {
        return this._filename;
    }

    public String getFilenameDateFormat() {
        return this._filenameDateFormat;
    }

    public String[] getIgnorePaths() {
        return this._ignorePaths;
    }

    public boolean getLogCookies() {
        return this._logCookies;
    }

    public String getLogDateFormat() {
        return this._logDateFormat;
    }

    public boolean getLogLatency() {
        return this._logLatency;
    }

    public Locale getLogLocale() {
        return this._logLocale;
    }

    public boolean getLogServer() {
        return this._logServer;
    }

    public String getLogTimeZone() {
        return this._logTimeZone;
    }

    public boolean getPreferProxiedForAddress() {
        return this._preferProxiedForAddress;
    }

    public int getRetainDays() {
        return this._retainDays;
    }

    public boolean isAppend() {
        return this._append;
    }

    public boolean isExtended() {
        return this._extended;
    }

    public boolean isLogDispatch() {
        return this._logDispatch;
    }

    @Override // org.eclipse.jetty.server.RequestLog
    public void log(Request request, Response response) {
        try {
            if ((this._ignorePathMap != null && this._ignorePathMap.getMatch(request.getRequestURI()) != null) || this._fileOut == null) {
                return;
            }
            StringBuilder sb = _buffers.get();
            sb.setLength(0);
            if (this._logServer) {
                sb.append(request.getServerName());
                sb.append(TokenParser.f4579SP);
            }
            String str = null;
            if (this._preferProxiedForAddress) {
                str = request.getHeader(HttpHeaders.X_FORWARDED_FOR);
            }
            if (str == null) {
                str = request.getRemoteAddr();
            }
            sb.append(str);
            sb.append(" - ");
            Authentication authentication = request.getAuthentication();
            if (authentication instanceof Authentication.User) {
                sb.append(((Authentication.User) authentication).getUserIdentity().getUserPrincipal().getName());
            } else {
                sb.append(" - ");
            }
            sb.append(" [");
            sb.append(this._logDateCache != null ? this._logDateCache.format(request.getTimeStamp()) : request.getTimeStampBuffer().toString());
            sb.append("] \"");
            sb.append(request.getMethod());
            sb.append(TokenParser.f4579SP);
            sb.append(request.getUri().toString());
            sb.append(TokenParser.f4579SP);
            sb.append(request.getProtocol());
            sb.append("\" ");
            if (request.getAsyncContinuation().isInitial()) {
                int status = response.getStatus();
                if (status <= 0) {
                    status = 404;
                }
                sb.append((char) (((status / 100) % 10) + 48));
                sb.append((char) (((status / 10) % 10) + 48));
                sb.append((char) ((status % 10) + 48));
            } else {
                sb.append("Async");
            }
            long contentCount = response.getContentCount();
            if (contentCount >= 0) {
                sb.append(TokenParser.f4579SP);
                if (contentCount > 99999) {
                    sb.append(contentCount);
                } else {
                    if (contentCount > 9999) {
                        sb.append((char) (((contentCount / 10000) % 10) + 48));
                    }
                    if (contentCount > 999) {
                        sb.append((char) (((contentCount / 1000) % 10) + 48));
                    }
                    if (contentCount > 99) {
                        sb.append((char) (((contentCount / 100) % 10) + 48));
                    }
                    if (contentCount > 9) {
                        sb.append((char) (((contentCount / 10) % 10) + 48));
                    }
                    sb.append((char) ((contentCount % 10) + 48));
                }
                sb.append(TokenParser.f4579SP);
            } else {
                sb.append(" - ");
            }
            if (this._extended) {
                logExtended(request, response, sb);
            }
            if (this._logCookies) {
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length != 0) {
                    sb.append(" \"");
                    for (int i = 0; i < cookies.length; i++) {
                        if (i != 0) {
                            sb.append(BasicHeaderValueParser.PARAM_DELIMITER);
                        }
                        sb.append(cookies[i].getName());
                        sb.append(B64Code.__pad);
                        sb.append(cookies[i].getValue());
                    }
                    sb.append('\"');
                }
                sb.append(" -");
            }
            if (this._logDispatch || this._logLatency) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this._logDispatch) {
                    long dispatchTime = request.getDispatchTime();
                    sb.append(TokenParser.f4579SP);
                    if (dispatchTime == 0) {
                        dispatchTime = request.getTimeStamp();
                    }
                    sb.append(currentTimeMillis - dispatchTime);
                }
                if (this._logLatency) {
                    sb.append(TokenParser.f4579SP);
                    sb.append(currentTimeMillis - request.getTimeStamp());
                }
            }
            sb.append(StringUtil.__LINE_SEPARATOR);
            write(sb.toString());
        } catch (IOException e) {
            LOG.warn(e);
        }
    }

    public void logExtended(Request request, Response response, StringBuilder sb) throws IOException {
        String header = request.getHeader("Referer");
        if (header == null) {
            sb.append("\"-\" ");
        } else {
            sb.append('\"');
            sb.append(header);
            sb.append("\" ");
        }
        String header2 = request.getHeader("User-Agent");
        if (header2 == null) {
            sb.append("\"-\" ");
            return;
        }
        sb.append('\"');
        sb.append(header2);
        sb.append('\"');
    }

    public void setAppend(boolean z) {
        this._append = z;
    }

    public void setExtended(boolean z) {
        this._extended = z;
    }

    public void setFilename(String str) {
        if (str != null) {
            str = str.trim();
            if (str.length() == 0) {
                str = null;
            }
        }
        this._filename = str;
    }

    public void setFilenameDateFormat(String str) {
        this._filenameDateFormat = str;
    }

    public void setIgnorePaths(String[] strArr) {
        this._ignorePaths = strArr;
    }

    public void setLogCookies(boolean z) {
        this._logCookies = z;
    }

    public void setLogDateFormat(String str) {
        this._logDateFormat = str;
    }

    public void setLogDispatch(boolean z) {
        this._logDispatch = z;
    }

    public void setLogLatency(boolean z) {
        this._logLatency = z;
    }

    public void setLogLocale(Locale locale) {
        this._logLocale = locale;
    }

    public void setLogServer(boolean z) {
        this._logServer = z;
    }

    public void setLogTimeZone(String str) {
        this._logTimeZone = str;
    }

    public void setPreferProxiedForAddress(boolean z) {
        this._preferProxiedForAddress = z;
    }

    public void setRetainDays(int i) {
        this._retainDays = i;
    }

    public void write(String str) throws IOException {
        synchronized (this) {
            if (this._writer == null) {
                return;
            }
            this._writer.write(str);
            this._writer.flush();
        }
    }
}
