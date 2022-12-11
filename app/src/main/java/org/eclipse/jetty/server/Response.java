package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import me.tvspark.ce0;
import me.tvspark.ee0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.ByteArrayISO8859Writer;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class Response implements ce0 {
    public static final String HTTP_ONLY_COMMENT = "__HTTP_ONLY__";
    public static final Logger LOG = Log.getLogger(Response.class);
    public static final int NONE = 0;
    public static final String SET_INCLUDE_HEADER_PREFIX = "org.eclipse.jetty.server.include.";
    public static final int STREAM = 1;
    public static final int WRITER = 2;
    public static final int __MIN_BUFFER_SIZE = 1;
    public BufferCache.CachedBuffer _cachedMimeType;
    public String _characterEncoding;
    public final AbstractHttpConnection _connection;
    public String _contentType;
    public boolean _explicitEncoding;
    public Locale _locale;
    public String _mimeType;
    public volatile int _outputState;
    public String _reason;
    public int _status = 200;
    public PrintWriter _writer;

    /* loaded from: classes4.dex */
    public static class NullOutput extends ServletOutputStream {
        @Override // javax.servlet.ServletOutputStream
        public void print(String str) throws IOException {
        }

        @Override // javax.servlet.ServletOutputStream
        public void println(String str) throws IOException {
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
        }
    }

    public Response(AbstractHttpConnection abstractHttpConnection) {
        this._connection = abstractHttpConnection;
    }

    public static Response getResponse(ce0 ce0Var) {
        return ce0Var instanceof Response ? (Response) ce0Var : AbstractHttpConnection.getCurrentConnection().getResponse();
    }

    @Override // me.tvspark.ce0
    public void addCookie(Cookie cookie) {
        String str;
        boolean z;
        String comment = cookie.getComment();
        if (comment == null || comment.indexOf(HTTP_ONLY_COMMENT) < 0) {
            str = comment;
            z = false;
        } else {
            String trim = comment.replace(HTTP_ONLY_COMMENT, "").trim();
            if (trim.length() == 0) {
                trim = null;
            }
            str = trim;
            z = true;
        }
        this._connection.getResponseFields().addSetCookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getMaxAge(), str, cookie.getSecure(), z || cookie.isHttpOnly(), cookie.getVersion());
    }

    public void addCookie(HttpCookie httpCookie) {
        this._connection.getResponseFields().addSetCookie(httpCookie);
    }

    @Override // me.tvspark.ce0
    public void addDateHeader(String str, long j) {
        if (!this._connection.isIncluding()) {
            this._connection.getResponseFields().addDateField(str, j);
        }
    }

    @Override // me.tvspark.ce0
    public void addHeader(String str, String str2) {
        if (this._connection.isIncluding()) {
            if (!str.startsWith(SET_INCLUDE_HEADER_PREFIX)) {
                return;
            }
            str = str.substring(33);
        }
        if ("Content-Type".equalsIgnoreCase(str)) {
            setContentType(str2);
            return;
        }
        this._connection.getResponseFields().add(str, str2);
        if (!"Content-Length".equalsIgnoreCase(str)) {
            return;
        }
        this._connection._generator.setContentLength(Long.parseLong(str2));
    }

    @Override // me.tvspark.ce0
    public void addIntHeader(String str, int i) {
        if (!this._connection.isIncluding()) {
            long j = i;
            this._connection.getResponseFields().addLongField(str, j);
            if (!"Content-Length".equalsIgnoreCase(str)) {
                return;
            }
            this._connection._generator.setContentLength(j);
        }
    }

    public void complete() throws IOException {
        this._connection.completeResponse();
    }

    @Override // me.tvspark.ce0
    public boolean containsHeader(String str) {
        return this._connection.getResponseFields().containsKey(str);
    }

    @Override // me.tvspark.ce0
    public String encodeRedirectURL(String str) {
        return encodeURL(str);
    }

    @Override // me.tvspark.ce0
    @Deprecated
    public String encodeRedirectUrl(String str) {
        return encodeRedirectURL(str);
    }

    @Override // me.tvspark.ce0
    public String encodeURL(String str) {
        HttpURI httpURI;
        Request request = this._connection.getRequest();
        SessionManager sessionManager = request.getSessionManager();
        if (sessionManager == null) {
            return str;
        }
        String str2 = "";
        if (!sessionManager.isCheckingRemoteSessionIdEncoding() || !URIUtil.hasScheme(str)) {
            httpURI = null;
        } else {
            httpURI = new HttpURI(str);
            String path = httpURI.getPath();
            if (path == null) {
                path = str2;
            }
            int port = httpURI.getPort();
            if (port < 0) {
                port = "https".equalsIgnoreCase(httpURI.getScheme()) ? 443 : 80;
            }
            if (!request.getServerName().equalsIgnoreCase(httpURI.getHost()) || request.getServerPort() != port || !path.startsWith(request.getContextPath())) {
                return str;
            }
        }
        String sessionIdPathParameterNamePrefix = sessionManager.getSessionIdPathParameterNamePrefix();
        if (sessionIdPathParameterNamePrefix == null) {
            return str;
        }
        if (str == null) {
            return null;
        }
        if ((sessionManager.isUsingCookies() && request.isRequestedSessionIdFromCookie()) || !sessionManager.isUsingURLs()) {
            int indexOf = str.indexOf(sessionIdPathParameterNamePrefix);
            if (indexOf == -1) {
                return str;
            }
            int indexOf2 = str.indexOf("?", indexOf);
            if (indexOf2 < 0) {
                indexOf2 = str.indexOf("#", indexOf);
            }
            if (indexOf2 <= indexOf) {
                return str.substring(0, indexOf);
            }
            return str.substring(0, indexOf) + str.substring(indexOf2);
        }
        ee0 session = request.getSession(false);
        if (session == null || !sessionManager.isValid(session)) {
            return str;
        }
        String nodeId = sessionManager.getNodeId(session);
        if (httpURI == null) {
            httpURI = new HttpURI(str);
        }
        int indexOf3 = str.indexOf(sessionIdPathParameterNamePrefix);
        if (indexOf3 != -1) {
            int indexOf4 = str.indexOf("?", indexOf3);
            if (indexOf4 < 0) {
                indexOf4 = str.indexOf("#", indexOf3);
            }
            if (indexOf4 <= indexOf3) {
                return str.substring(0, sessionIdPathParameterNamePrefix.length() + indexOf3) + nodeId;
            }
            return str.substring(0, sessionIdPathParameterNamePrefix.length() + indexOf3) + nodeId + str.substring(indexOf4);
        }
        int indexOf5 = str.indexOf(63);
        if (indexOf5 < 0) {
            indexOf5 = str.indexOf(35);
        }
        if (indexOf5 < 0) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            if (("https".equalsIgnoreCase(httpURI.getScheme()) || "http".equalsIgnoreCase(httpURI.getScheme())) && httpURI.getPath() == null) {
                str2 = "/";
            }
            return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str2, sessionIdPathParameterNamePrefix, nodeId);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, indexOf5));
        if (("https".equalsIgnoreCase(httpURI.getScheme()) || "http".equalsIgnoreCase(httpURI.getScheme())) && httpURI.getPath() == null) {
            str2 = "/";
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, str2, sessionIdPathParameterNamePrefix, nodeId);
        sb.append(str.substring(indexOf5));
        return sb.toString();
    }

    @Override // me.tvspark.ce0
    @Deprecated
    public String encodeUrl(String str) {
        return encodeURL(str);
    }

    @Override // javax.servlet.ServletResponse
    public void flushBuffer() throws IOException {
        this._connection.flushResponse();
    }

    public void fwdReset() {
        resetBuffer();
        this._writer = null;
        this._outputState = 0;
    }

    @Override // javax.servlet.ServletResponse
    public int getBufferSize() {
        return this._connection.getGenerator().getContentBufferSize();
    }

    @Override // javax.servlet.ServletResponse
    public String getCharacterEncoding() {
        if (this._characterEncoding == null) {
            this._characterEncoding = "ISO-8859-1";
        }
        return this._characterEncoding;
    }

    public long getContentCount() {
        AbstractHttpConnection abstractHttpConnection = this._connection;
        if (abstractHttpConnection == null || abstractHttpConnection.getGenerator() == null) {
            return -1L;
        }
        return this._connection.getGenerator().getContentWritten();
    }

    @Override // javax.servlet.ServletResponse
    public String getContentType() {
        return this._contentType;
    }

    @Override // me.tvspark.ce0
    public String getHeader(String str) {
        return this._connection.getResponseFields().getStringField(str);
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaderNames() {
        return this._connection.getResponseFields().getFieldNamesCollection();
    }

    @Override // me.tvspark.ce0
    public Collection<String> getHeaders(String str) {
        Collection<String> valuesCollection = this._connection.getResponseFields().getValuesCollection(str);
        return valuesCollection == null ? Collections.EMPTY_LIST : valuesCollection;
    }

    public HttpFields getHttpFields() {
        return this._connection.getResponseFields();
    }

    @Override // javax.servlet.ServletResponse
    public Locale getLocale() {
        Locale locale = this._locale;
        return locale == null ? Locale.getDefault() : locale;
    }

    @Override // javax.servlet.ServletResponse
    public ServletOutputStream getOutputStream() throws IOException {
        if (this._outputState == 0 || this._outputState == 1) {
            ServletOutputStream outputStream = this._connection.getOutputStream();
            this._outputState = 1;
            return outputStream;
        }
        throw new IllegalStateException("WRITER");
    }

    public String getReason() {
        return this._reason;
    }

    public String getSetCharacterEncoding() {
        return this._characterEncoding;
    }

    @Override // me.tvspark.ce0
    public int getStatus() {
        return this._status;
    }

    @Override // javax.servlet.ServletResponse
    public PrintWriter getWriter() throws IOException {
        if (this._outputState == 0 || this._outputState == 2) {
            if (this._writer == null) {
                String str = this._characterEncoding;
                if (str == null) {
                    BufferCache.CachedBuffer cachedBuffer = this._cachedMimeType;
                    if (cachedBuffer != null) {
                        str = MimeTypes.getCharsetFromContentType(cachedBuffer);
                    }
                    if (str == null) {
                        str = "ISO-8859-1";
                    }
                    setCharacterEncoding(str);
                }
                this._writer = this._connection.getPrintWriter(str);
            }
            this._outputState = 2;
            return this._writer;
        }
        throw new IllegalStateException("STREAM");
    }

    @Override // javax.servlet.ServletResponse
    public boolean isCommitted() {
        return this._connection.isResponseCommitted();
    }

    public boolean isOutputing() {
        return this._outputState != 0;
    }

    public boolean isWriting() {
        return this._outputState == 2;
    }

    public void recycle() {
        this._status = 200;
        this._reason = null;
        this._locale = null;
        this._mimeType = null;
        this._cachedMimeType = null;
        this._characterEncoding = null;
        this._explicitEncoding = false;
        this._contentType = null;
        this._writer = null;
        this._outputState = 0;
    }

    @Override // javax.servlet.ServletResponse
    public void reset() {
        Buffer buffer;
        String str;
        resetBuffer();
        fwdReset();
        this._status = 200;
        this._reason = null;
        HttpFields responseFields = this._connection.getResponseFields();
        responseFields.clear();
        String stringField = this._connection.getRequestFields().getStringField(HttpHeaders.CONNECTION_BUFFER);
        if (stringField != null) {
            String[] split = stringField.split(",");
            for (int i = 0; split != null && i < split.length; i++) {
                BufferCache.CachedBuffer cachedBuffer = HttpHeaderValues.CACHE.get(split[0].trim());
                if (cachedBuffer != null) {
                    int ordinal = cachedBuffer.getOrdinal();
                    if (ordinal == 1) {
                        responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                    } else if (ordinal != 5) {
                        if (ordinal == 8) {
                            buffer = HttpHeaders.CONNECTION_BUFFER;
                            str = "TE";
                            responseFields.put(buffer, str);
                        }
                    } else if (HttpVersions.HTTP_1_0.equalsIgnoreCase(this._connection.getRequest().getProtocol())) {
                        buffer = HttpHeaders.CONNECTION_BUFFER;
                        str = "keep-alive";
                        responseFields.put(buffer, str);
                    }
                }
            }
        }
    }

    public void reset(boolean z) {
        if (!z) {
            reset();
            return;
        }
        HttpFields responseFields = this._connection.getResponseFields();
        ArrayList arrayList = new ArrayList(5);
        Enumeration<String> values = responseFields.getValues(HttpHeaders.SET_COOKIE);
        while (values.hasMoreElements()) {
            arrayList.add(values.nextElement());
        }
        reset();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            responseFields.add(HttpHeaders.SET_COOKIE, (String) it.next());
        }
    }

    @Override // javax.servlet.ServletResponse
    public void resetBuffer() {
        if (!isCommitted()) {
            this._connection.getGenerator().resetBuffer();
            return;
        }
        throw new IllegalStateException("Committed");
    }

    @Override // me.tvspark.ce0
    public void sendError(int i) throws IOException {
        if (i == -1) {
            this._connection.getEndPoint().close();
        } else if (i != 102) {
            sendError(i, null);
        } else {
            sendProcessing();
        }
    }

    @Override // me.tvspark.ce0
    public void sendError(int i, String str) throws IOException {
        if (this._connection.isIncluding()) {
            return;
        }
        if (isCommitted()) {
            Logger logger = LOG;
            logger.warn("Committed before " + i + StringUtils.SPACE + str, new Object[0]);
        }
        resetBuffer();
        this._characterEncoding = null;
        setHeader("Expires", null);
        setHeader("Last-Modified", null);
        setHeader("Cache-Control", null);
        setHeader("Content-Type", null);
        setHeader("Content-Length", null);
        this._outputState = 0;
        setStatus(i, str);
        if (str == null) {
            str = HttpStatus.getMessage(i);
        }
        if (i != 204 && i != 304 && i != 206 && i >= 200) {
            Request request = this._connection.getRequest();
            ContextHandler.Context context = request.getContext();
            ErrorHandler errorHandler = context != null ? context.getContextHandler().getErrorHandler() : null;
            if (errorHandler == null) {
                errorHandler = (ErrorHandler) this._connection.getConnector().getServer().getBean(ErrorHandler.class);
            }
            if (errorHandler != null) {
                request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, new Integer(i));
                request.setAttribute(RequestDispatcher.ERROR_MESSAGE, str);
                request.setAttribute(RequestDispatcher.ERROR_REQUEST_URI, request.getRequestURI());
                request.setAttribute(RequestDispatcher.ERROR_SERVLET_NAME, request.getServletName());
                errorHandler.handle(null, this._connection.getRequest(), this._connection.getRequest(), this);
            } else {
                setHeader("Cache-Control", "must-revalidate,no-cache,no-store");
                setContentType(MimeTypes.TEXT_HTML_8859_1);
                ByteArrayISO8859Writer byteArrayISO8859Writer = new ByteArrayISO8859Writer(2048);
                if (str != null) {
                    str = StringUtil.replace(StringUtil.replace(StringUtil.replace(str, "&", "&amp;"), "<", "&lt;"), ">", "&gt;");
                }
                String requestURI = request.getRequestURI();
                if (requestURI != null) {
                    requestURI = StringUtil.replace(StringUtil.replace(StringUtil.replace(requestURI, "&", "&amp;"), "<", "&lt;"), ">", "&gt;");
                }
                byteArrayISO8859Writer.write("<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=ISO-8859-1\"/>\n");
                byteArrayISO8859Writer.write("<title>Error ");
                byteArrayISO8859Writer.write(Integer.toString(i));
                byteArrayISO8859Writer.write(TokenParser.f4579SP);
                if (str == null) {
                    str = HttpStatus.getMessage(i);
                }
                byteArrayISO8859Writer.write(str);
                byteArrayISO8859Writer.write("</title>\n</head>\n<body>\n<h2>HTTP ERROR: ");
                byteArrayISO8859Writer.write(Integer.toString(i));
                byteArrayISO8859Writer.write("</h2>\n<p>Problem accessing ");
                byteArrayISO8859Writer.write(requestURI);
                byteArrayISO8859Writer.write(". Reason:\n<pre>    ");
                byteArrayISO8859Writer.write(str);
                byteArrayISO8859Writer.write("</pre>");
                byteArrayISO8859Writer.write("</p>\n");
                if (this._connection.getServer().getSendServerVersion()) {
                    byteArrayISO8859Writer.write("<hr /><i><small>Powered by Jetty:// ");
                    byteArrayISO8859Writer.write(Server.getVersion());
                    byteArrayISO8859Writer.write("</small></i>");
                }
                for (int i2 = 0; i2 < 20; i2++) {
                    byteArrayISO8859Writer.write("\n                                                ");
                }
                byteArrayISO8859Writer.write("\n</body>\n</html>\n");
                byteArrayISO8859Writer.flush();
                setContentLength(byteArrayISO8859Writer.size());
                byteArrayISO8859Writer.writeTo(getOutputStream());
                byteArrayISO8859Writer.destroy();
            }
        } else if (i != 206) {
            this._connection.getRequestFields().remove(HttpHeaders.CONTENT_TYPE_BUFFER);
            this._connection.getRequestFields().remove(HttpHeaders.CONTENT_LENGTH_BUFFER);
            this._characterEncoding = null;
            this._mimeType = null;
            this._cachedMimeType = null;
        }
        complete();
    }

    public void sendProcessing() throws IOException {
        if (!this._connection.isExpecting102Processing() || isCommitted()) {
            return;
        }
        ((HttpGenerator) this._connection.getGenerator()).send1xx(102);
    }

    @Override // me.tvspark.ce0
    public void sendRedirect(String str) throws IOException {
        String canonicalPath;
        if (this._connection.isIncluding()) {
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (!URIUtil.hasScheme(str)) {
            StringBuilder rootURL = this._connection.getRequest().getRootURL();
            if (str.startsWith("/")) {
                canonicalPath = URIUtil.canonicalPath(str);
            } else {
                String requestURI = this._connection.getRequest().getRequestURI();
                if (!requestURI.endsWith("/")) {
                    requestURI = URIUtil.parentPath(requestURI);
                }
                canonicalPath = URIUtil.canonicalPath(URIUtil.addPaths(requestURI, str));
                if (!canonicalPath.startsWith("/")) {
                    rootURL.append('/');
                }
            }
            if (canonicalPath == null) {
                throw new IllegalStateException("path cannot be above root");
            }
            rootURL.append(canonicalPath);
            str = rootURL.toString();
        }
        resetBuffer();
        setHeader("Location", str);
        setStatus(302);
        complete();
    }

    @Override // javax.servlet.ServletResponse
    public void setBufferSize(int i) {
        if (isCommitted() || getContentCount() > 0) {
            throw new IllegalStateException("Committed or content written");
        }
        if (i <= 0) {
            i = 1;
        }
        this._connection.getGenerator().increaseContentBufferSize(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    @Override // javax.servlet.ServletResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setCharacterEncoding(String str) {
        int i;
        int indexOf;
        String str2;
        BufferCache.CachedBuffer associate;
        String str3;
        if (!this._connection.isIncluding() && this._outputState == 0 && !isCommitted()) {
            this._explicitEncoding = true;
            if (str != null) {
                this._characterEncoding = str;
                String str4 = this._contentType;
                if (str4 == null) {
                    return;
                }
                int indexOf2 = str4.indexOf(59);
                if (indexOf2 < 0) {
                    this._contentType = null;
                    BufferCache.CachedBuffer cachedBuffer = this._cachedMimeType;
                    if (cachedBuffer != null && (associate = cachedBuffer.getAssociate(this._characterEncoding)) != null) {
                        this._contentType = associate.toString();
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, associate);
                    }
                    if (this._contentType != null) {
                        return;
                    }
                    str2 = this._mimeType + ";charset=" + QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= ");
                } else {
                    int indexOf3 = this._contentType.indexOf("charset=", indexOf2);
                    if (indexOf3 < 0) {
                        str2 = this._contentType + ";charset=" + QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= ");
                    } else {
                        if (this._contentType.indexOf(StringUtils.SPACE, indexOf3 + 8) < 0) {
                            str2 = this._contentType.substring(0, i) + QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= ");
                        } else {
                            str2 = this._contentType.substring(0, i) + QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= ") + this._contentType.substring(indexOf);
                        }
                    }
                }
                this._contentType = str2;
            } else if (this._characterEncoding == null) {
                return;
            } else {
                this._characterEncoding = null;
                BufferCache.CachedBuffer cachedBuffer2 = this._cachedMimeType;
                if (cachedBuffer2 != null) {
                    str3 = cachedBuffer2.toString();
                } else {
                    str3 = this._mimeType;
                    if (str3 == null) {
                        this._contentType = null;
                        if (this._contentType == null) {
                            this._connection.getResponseFields().remove(HttpHeaders.CONTENT_TYPE_BUFFER);
                            return;
                        }
                    }
                }
                this._contentType = str3;
                if (this._contentType == null) {
                }
            }
            this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setContentLength(int i) {
        if (isCommitted() || this._connection.isIncluding()) {
            return;
        }
        long j = i;
        this._connection._generator.setContentLength(j);
        if (i <= 0) {
            return;
        }
        this._connection.getResponseFields().putLongField("Content-Length", j);
        if (!this._connection._generator.isAllContentWritten()) {
            return;
        }
        if (this._outputState == 2) {
            this._writer.close();
        } else if (this._outputState != 1) {
        } else {
            try {
                getOutputStream().close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setContentType(String str) {
        StringBuilder sb;
        BufferCache.CachedBuffer associate;
        StringBuilder sb2;
        String quoteIfNeeded;
        BufferCache.CachedBuffer associate2;
        if (isCommitted() || this._connection.isIncluding()) {
            return;
        }
        if (str == null) {
            if (this._locale == null) {
                this._characterEncoding = null;
            }
            this._mimeType = null;
            this._cachedMimeType = null;
            this._contentType = null;
            this._connection.getResponseFields().remove(HttpHeaders.CONTENT_TYPE_BUFFER);
            return;
        }
        int indexOf = str.indexOf(59);
        if (indexOf > 0) {
            String trim = str.substring(0, indexOf).trim();
            this._mimeType = trim;
            this._cachedMimeType = MimeTypes.CACHE.get(trim);
            int i = indexOf + 1;
            int indexOf2 = str.indexOf("charset=", i);
            if (indexOf2 >= 0) {
                this._explicitEncoding = true;
                int i2 = indexOf2 + 8;
                int indexOf3 = str.indexOf(32, i2);
                if (this._outputState == 2) {
                    if ((indexOf2 != i || indexOf3 >= 0) && !(indexOf2 == indexOf + 2 && indexOf3 < 0 && str.charAt(i) == ' ')) {
                        sb = new StringBuilder();
                        if (indexOf3 < 0) {
                            str = str.substring(0, indexOf2);
                        } else {
                            sb.append(str.substring(0, indexOf2));
                            str = str.substring(indexOf3);
                        }
                        sb.append(str);
                        sb.append(";charset=");
                        sb.append(QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= "));
                        str = sb.toString();
                    } else {
                        BufferCache.CachedBuffer cachedBuffer = this._cachedMimeType;
                        if (cachedBuffer != null) {
                            associate = cachedBuffer.getAssociate(this._characterEncoding);
                            if (associate == null) {
                                sb2 = new StringBuilder();
                            }
                            this._contentType = associate.toString();
                            this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, associate);
                            return;
                        }
                        sb2 = new StringBuilder();
                        sb2.append(this._mimeType);
                        sb2.append(";charset=");
                        quoteIfNeeded = this._characterEncoding;
                        sb2.append(quoteIfNeeded);
                        str = sb2.toString();
                    }
                } else if ((indexOf2 != i || indexOf3 >= 0) && !(indexOf2 == indexOf + 2 && indexOf3 < 0 && str.charAt(i) == ' ')) {
                    this._characterEncoding = QuotedStringTokenizer.unquote(indexOf3 > 0 ? str.substring(i2, indexOf3) : str.substring(i2));
                } else {
                    this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
                    String unquote = QuotedStringTokenizer.unquote(str.substring(i2));
                    this._characterEncoding = unquote;
                    BufferCache.CachedBuffer cachedBuffer2 = this._cachedMimeType;
                    if (cachedBuffer2 != null && (associate2 = cachedBuffer2.getAssociate(unquote)) != null) {
                        this._contentType = associate2.toString();
                        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, associate2);
                        return;
                    }
                }
            } else {
                this._cachedMimeType = null;
                if (this._characterEncoding != null) {
                    sb = new StringBuilder();
                    sb.append(str);
                    sb.append(";charset=");
                    sb.append(QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= "));
                    str = sb.toString();
                }
            }
        } else {
            this._mimeType = str;
            BufferCache.CachedBuffer cachedBuffer3 = MimeTypes.CACHE.get(str);
            this._cachedMimeType = cachedBuffer3;
            String str2 = this._characterEncoding;
            if (str2 != null) {
                if (cachedBuffer3 != null) {
                    associate = cachedBuffer3.getAssociate(str2);
                    if (associate == null) {
                        sb2 = new StringBuilder();
                        sb2.append(this._mimeType);
                        sb2.append(";charset=");
                        quoteIfNeeded = QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= ");
                        sb2.append(quoteIfNeeded);
                        str = sb2.toString();
                    }
                    this._contentType = associate.toString();
                    this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, associate);
                    return;
                }
                sb = new StringBuilder();
                sb.append(str);
                sb.append(";charset=");
                sb.append(QuotedStringTokenizer.quoteIfNeeded(this._characterEncoding, ";= "));
                str = sb.toString();
            } else if (cachedBuffer3 != null) {
                this._contentType = cachedBuffer3.toString();
                this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._cachedMimeType);
                return;
            }
        }
        this._contentType = str;
        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
    }

    @Override // me.tvspark.ce0
    public void setDateHeader(String str, long j) {
        if (!this._connection.isIncluding()) {
            this._connection.getResponseFields().putDateField(str, j);
        }
    }

    @Override // me.tvspark.ce0
    public void setHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            setContentType(str2);
            return;
        }
        if (this._connection.isIncluding()) {
            if (!str.startsWith(SET_INCLUDE_HEADER_PREFIX)) {
                return;
            }
            str = str.substring(33);
        }
        this._connection.getResponseFields().put(str, str2);
        if (!"Content-Length".equalsIgnoreCase(str)) {
            return;
        }
        this._connection._generator.setContentLength(str2 == null ? -1L : Long.parseLong(str2));
    }

    @Override // me.tvspark.ce0
    public void setIntHeader(String str, int i) {
        if (!this._connection.isIncluding()) {
            long j = i;
            this._connection.getResponseFields().putLongField(str, j);
            if (!"Content-Length".equalsIgnoreCase(str)) {
                return;
            }
            this._connection._generator.setContentLength(j);
        }
    }

    @Override // javax.servlet.ServletResponse
    public void setLocale(Locale locale) {
        String localeEncoding;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (locale == null || isCommitted() || this._connection.isIncluding()) {
            return;
        }
        this._locale = locale;
        this._connection.getResponseFields().put(HttpHeaders.CONTENT_LANGUAGE_BUFFER, locale.toString().replace('_', '-'));
        if (this._explicitEncoding || this._outputState != 0 || this._connection.getRequest().getContext() == null || (localeEncoding = this._connection.getRequest().getContext().getContextHandler().getLocaleEncoding(locale)) == null || localeEncoding.length() <= 0) {
            return;
        }
        this._characterEncoding = localeEncoding;
        String contentType = getContentType();
        if (contentType == null) {
            return;
        }
        this._characterEncoding = localeEncoding;
        int indexOf = contentType.indexOf(59);
        if (indexOf < 0) {
            this._mimeType = contentType;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(contentType, ";charset=", localeEncoding);
        } else {
            this._mimeType = contentType.substring(0, indexOf);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder(), this._mimeType, ";charset=", localeEncoding);
            this._mimeType = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        this._contentType = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this._cachedMimeType = MimeTypes.CACHE.get(this._mimeType);
        this._connection.getResponseFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, this._contentType);
    }

    public void setLongContentLength(long j) {
        if (isCommitted() || this._connection.isIncluding()) {
            return;
        }
        this._connection._generator.setContentLength(j);
        this._connection.getResponseFields().putLongField("Content-Length", j);
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i) {
        setStatus(i, null);
    }

    @Override // me.tvspark.ce0
    public void setStatus(int i, String str) {
        if (i > 0) {
            if (this._connection.isIncluding()) {
                return;
            }
            this._status = i;
            this._reason = str;
            return;
        }
        throw new IllegalArgumentException();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("HTTP/1.1 ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._status);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
        String str = this._reason;
        if (str == null) {
            str = "";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(System.getProperty("line.separator"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._connection.getResponseFields().toString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
