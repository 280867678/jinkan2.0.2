package org.eclipse.jetty.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import me.tvspark.ae0;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.continuation.ContinuationThrowable;
import org.eclipse.jetty.http.EncodedHttpURI;
import org.eclipse.jetty.http.Generator;
import org.eclipse.jetty.http.HttpBuffers;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpException;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpGenerator;
import org.eclipse.jetty.http.HttpHeaderValues;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.Parser;
import org.eclipse.jetty.p059io.AbstractConnection;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferCache;
import org.eclipse.jetty.p059io.Buffers;
import org.eclipse.jetty.p059io.Connection;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.EofException;
import org.eclipse.jetty.p059io.RuntimeIOException;
import org.eclipse.jetty.p059io.UncheckedPrintWriter;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.nio.NIOConnector;
import org.eclipse.jetty.server.ssl.SslConnector;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: classes4.dex */
public abstract class AbstractHttpConnection extends AbstractConnection {
    public static final int UNKNOWN = -2;
    public Object _associatedObject;
    public String _charset;
    public final Connector _connector;
    public final Generator _generator;
    public volatile ServletInputStream _in;
    public int _include;
    public volatile Output _out;
    public final Parser _parser;
    public volatile PrintWriter _printWriter;
    public final Request _request;
    public final HttpFields _requestFields;
    public int _requests;
    public final Response _response;
    public final HttpFields _responseFields;
    public final Server _server;
    public final HttpURI _uri;
    public volatile OutputWriter _writer;
    public static final Logger LOG = Log.getLogger(AbstractHttpConnection.class);
    public static final ThreadLocal<AbstractHttpConnection> __currentConnection = new ThreadLocal<>();
    public int _version = -2;
    public boolean _expect = false;
    public boolean _expect100Continue = false;
    public boolean _expect102Processing = false;
    public boolean _head = false;
    public boolean _host = false;
    public boolean _delayedHandling = false;
    public boolean _earlyEOF = false;

    /* loaded from: classes4.dex */
    public class Output extends HttpOutput {
        public Output() {
            super(AbstractHttpConnection.this);
        }

        @Override // org.eclipse.jetty.server.HttpOutput, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (isClosed()) {
                return;
            }
            if (AbstractHttpConnection.this.isIncluding() || this._generator.isCommitted()) {
                AbstractHttpConnection.this.flushResponse();
            } else {
                AbstractHttpConnection.this.commitResponse(true);
            }
            super.close();
        }

        @Override // org.eclipse.jetty.server.HttpOutput, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            if (!this._generator.isCommitted()) {
                AbstractHttpConnection.this.commitResponse(false);
            }
            super.flush();
        }

        @Override // org.eclipse.jetty.server.HttpOutput, javax.servlet.ServletOutputStream
        public void print(String str) throws IOException {
            if (!isClosed()) {
                AbstractHttpConnection.this.getPrintWriter(null).print(str);
                return;
            }
            throw new IOException("Closed");
        }

        public void sendContent(Object obj) throws IOException {
            HttpFields httpFields;
            Buffer buffer;
            StringBuilder sb;
            if (!isClosed()) {
                if (this._generator.isWritten()) {
                    throw new IllegalStateException("!empty");
                }
                Resource resource = null;
                if (obj instanceof HttpContent) {
                    HttpContent httpContent = (HttpContent) obj;
                    Buffer contentType = httpContent.getContentType();
                    if (contentType != null && !AbstractHttpConnection.this._responseFields.containsKey(HttpHeaders.CONTENT_TYPE_BUFFER)) {
                        String setCharacterEncoding = AbstractHttpConnection.this._response.getSetCharacterEncoding();
                        if (setCharacterEncoding == null) {
                            AbstractHttpConnection.this._responseFields.add(HttpHeaders.CONTENT_TYPE_BUFFER, contentType);
                        } else {
                            if (contentType instanceof BufferCache.CachedBuffer) {
                                BufferCache.CachedBuffer associate = ((BufferCache.CachedBuffer) contentType).getAssociate(setCharacterEncoding);
                                if (associate != null) {
                                    AbstractHttpConnection.this._responseFields.put(HttpHeaders.CONTENT_TYPE_BUFFER, associate);
                                } else {
                                    httpFields = AbstractHttpConnection.this._responseFields;
                                    buffer = HttpHeaders.CONTENT_TYPE_BUFFER;
                                    sb = new StringBuilder();
                                }
                            } else {
                                httpFields = AbstractHttpConnection.this._responseFields;
                                buffer = HttpHeaders.CONTENT_TYPE_BUFFER;
                                sb = new StringBuilder();
                            }
                            sb.append(contentType);
                            sb.append(";charset=");
                            sb.append(QuotedStringTokenizer.quoteIfNeeded(setCharacterEncoding, ";= "));
                            httpFields.put(buffer, sb.toString());
                        }
                    }
                    if (httpContent.getContentLength() > 0) {
                        AbstractHttpConnection.this._responseFields.putLongField(HttpHeaders.CONTENT_LENGTH_BUFFER, httpContent.getContentLength());
                    }
                    Buffer lastModified = httpContent.getLastModified();
                    long lastModified2 = httpContent.getResource().lastModified();
                    if (lastModified != null) {
                        AbstractHttpConnection.this._responseFields.put(HttpHeaders.LAST_MODIFIED_BUFFER, lastModified);
                    } else if (httpContent.getResource() != null && lastModified2 != -1) {
                        AbstractHttpConnection.this._responseFields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, lastModified2);
                    }
                    Buffer eTag = httpContent.getETag();
                    if (eTag != null) {
                        AbstractHttpConnection.this._responseFields.put(HttpHeaders.ETAG_BUFFER, eTag);
                    }
                    Connector connector = AbstractHttpConnection.this._connector;
                    Buffer directBuffer = (connector instanceof NIOConnector) && ((NIOConnector) connector).getUseDirectBuffers() && !(AbstractHttpConnection.this._connector instanceof SslConnector) ? httpContent.getDirectBuffer() : httpContent.getIndirectBuffer();
                    obj = directBuffer == null ? httpContent.getInputStream() : directBuffer;
                } else if (obj instanceof Resource) {
                    resource = (Resource) obj;
                    AbstractHttpConnection.this._responseFields.putDateField(HttpHeaders.LAST_MODIFIED_BUFFER, resource.lastModified());
                    obj = resource.getInputStream();
                }
                if (obj instanceof Buffer) {
                    this._generator.addContent((Buffer) obj, true);
                    AbstractHttpConnection.this.commitResponse(true);
                    return;
                } else if (!(obj instanceof InputStream)) {
                    throw new IllegalArgumentException("unknown content type?");
                } else {
                    InputStream inputStream = (InputStream) obj;
                    try {
                        int prepareUncheckedAddContent = this._generator.prepareUncheckedAddContent();
                        Buffer uncheckedBuffer = this._generator.getUncheckedBuffer();
                        while (uncheckedBuffer.readFrom(inputStream, prepareUncheckedAddContent) >= 0 && !AbstractHttpConnection.this._endp.isOutputShutdown()) {
                            this._generator.completeUncheckedAddContent();
                            AbstractHttpConnection.this._out.flush();
                            prepareUncheckedAddContent = this._generator.prepareUncheckedAddContent();
                            uncheckedBuffer = this._generator.getUncheckedBuffer();
                        }
                        this._generator.completeUncheckedAddContent();
                        AbstractHttpConnection.this._out.flush();
                        if (resource != null) {
                            resource.release();
                            return;
                        } else {
                            inputStream.close();
                            return;
                        }
                    } catch (Throwable th) {
                        if (resource != null) {
                            resource.release();
                        } else {
                            inputStream.close();
                        }
                        throw th;
                    }
                }
            }
            throw new IOException("Closed");
        }

        public void sendResponse(Buffer buffer) throws IOException {
            ((HttpGenerator) this._generator).sendResponse(buffer);
        }
    }

    /* loaded from: classes4.dex */
    public class OutputWriter extends HttpWriter {
        public OutputWriter() {
            super(AbstractHttpConnection.this._out);
        }
    }

    /* loaded from: classes4.dex */
    public class RequestHandler extends HttpParser.EventHandler {
        public RequestHandler() {
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void content(Buffer buffer) throws IOException {
            AbstractHttpConnection.this.content(buffer);
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void earlyEOF() {
            AbstractHttpConnection.this.earlyEOF();
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void headerComplete() throws IOException {
            AbstractHttpConnection.this.headerComplete();
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void messageComplete(long j) throws IOException {
            AbstractHttpConnection.this.messageComplete(j);
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void parsedHeader(Buffer buffer, Buffer buffer2) throws IOException {
            AbstractHttpConnection.this.parsedHeader(buffer, buffer2);
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void startRequest(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
            AbstractHttpConnection.this.startRequest(buffer, buffer2, buffer3);
        }

        @Override // org.eclipse.jetty.http.HttpParser.EventHandler
        public void startResponse(Buffer buffer, int i, Buffer buffer2) {
            if (AbstractHttpConnection.LOG.isDebugEnabled()) {
                Logger logger = AbstractHttpConnection.LOG;
                logger.debug("Bad request!: " + buffer + StringUtils.SPACE + i + StringUtils.SPACE + buffer2, new Object[0]);
            }
        }
    }

    public AbstractHttpConnection(Connector connector, EndPoint endPoint, Server server) {
        super(endPoint);
        this._uri = "UTF-8".equals(URIUtil.__CHARSET) ? new HttpURI() : new EncodedHttpURI(URIUtil.__CHARSET);
        this._connector = connector;
        HttpBuffers httpBuffers = (HttpBuffers) connector;
        this._parser = newHttpParser(httpBuffers.getRequestBuffers(), endPoint, new RequestHandler());
        this._requestFields = new HttpFields();
        this._responseFields = new HttpFields();
        this._request = new Request(this);
        this._response = new Response(this);
        HttpGenerator newHttpGenerator = newHttpGenerator(httpBuffers.getResponseBuffers(), endPoint);
        this._generator = newHttpGenerator;
        newHttpGenerator.setSendServerVersion(server.getSendServerVersion());
        this._server = server;
    }

    public AbstractHttpConnection(Connector connector, EndPoint endPoint, Server server, Parser parser, Generator generator, Request request) {
        super(endPoint);
        this._uri = URIUtil.__CHARSET.equals("UTF-8") ? new HttpURI() : new EncodedHttpURI(URIUtil.__CHARSET);
        this._connector = connector;
        this._parser = parser;
        this._requestFields = new HttpFields();
        this._responseFields = new HttpFields();
        this._request = request;
        this._response = new Response(this);
        this._generator = generator;
        generator.setSendServerVersion(server.getSendServerVersion());
        this._server = server;
    }

    public static AbstractHttpConnection getCurrentConnection() {
        return __currentConnection.get();
    }

    public static void setCurrentConnection(AbstractHttpConnection abstractHttpConnection) {
        __currentConnection.set(abstractHttpConnection);
    }

    public void commitResponse(boolean z) throws IOException {
        if (!this._generator.isCommitted()) {
            this._generator.setResponse(this._response.getStatus(), this._response.getReason());
            try {
                if (this._expect100Continue && this._response.getStatus() != 100) {
                    this._generator.setPersistent(false);
                }
                this._generator.completeHeader(this._responseFields, z);
            } catch (RuntimeException e) {
                Logger logger = LOG;
                logger.warn("header full: " + e, new Object[0]);
                this._response.reset();
                this._generator.reset();
                this._generator.setResponse(500, null);
                this._generator.completeHeader(this._responseFields, true);
                this._generator.complete();
                throw new HttpException(500);
            }
        }
        if (z) {
            this._generator.complete();
        }
    }

    public void completeResponse() throws IOException {
        if (!this._generator.isCommitted()) {
            this._generator.setResponse(this._response.getStatus(), this._response.getReason());
            try {
                this._generator.completeHeader(this._responseFields, true);
            } catch (RuntimeException e) {
                Logger logger = LOG;
                logger.warn("header full: " + e, new Object[0]);
                LOG.debug(e);
                this._response.reset();
                this._generator.reset();
                this._generator.setResponse(500, null);
                this._generator.completeHeader(this._responseFields, true);
                this._generator.complete();
                throw new HttpException(500);
            }
        }
        this._generator.complete();
    }

    public void content(Buffer buffer) throws IOException {
        if (this._delayedHandling) {
            this._delayedHandling = false;
            handleRequest();
        }
    }

    public void earlyEOF() {
        this._earlyEOF = true;
    }

    public void flushResponse() throws IOException {
        try {
            commitResponse(false);
            this._generator.flushBuffer();
        } catch (IOException e) {
            if (!(e instanceof EofException)) {
                throw new EofException(e);
            }
        }
    }

    public Object getAssociatedObject() {
        return this._associatedObject;
    }

    public Connector getConnector() {
        return this._connector;
    }

    public Generator getGenerator() {
        return this._generator;
    }

    public ServletInputStream getInputStream() throws IOException {
        if (this._expect100Continue) {
            if (((HttpParser) this._parser).getHeaderBuffer() == null || ((HttpParser) this._parser).getHeaderBuffer().length() < 2) {
                if (this._generator.isCommitted()) {
                    throw new IllegalStateException("Committed before 100 Continues");
                }
                ((HttpGenerator) this._generator).send1xx(100);
            }
            this._expect100Continue = false;
        }
        if (this._in == null) {
            this._in = new HttpInput(this);
        }
        return this._in;
    }

    public int getMaxIdleTime() {
        return (!this._connector.isLowResources() || this._endp.getMaxIdleTime() != this._connector.getMaxIdleTime()) ? this._endp.getMaxIdleTime() > 0 ? this._endp.getMaxIdleTime() : this._connector.getMaxIdleTime() : this._connector.getLowResourceMaxIdleTime();
    }

    public ServletOutputStream getOutputStream() {
        if (this._out == null) {
            this._out = new Output();
        }
        return this._out;
    }

    public Parser getParser() {
        return this._parser;
    }

    public PrintWriter getPrintWriter(String str) {
        getOutputStream();
        if (this._writer == null) {
            this._writer = new OutputWriter();
            this._printWriter = this._server.isUncheckedPrintWriter() ? new UncheckedPrintWriter(this._writer) : new PrintWriter(this._writer) { // from class: org.eclipse.jetty.server.AbstractHttpConnection.1
                @Override // java.io.PrintWriter, java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (((PrintWriter) this).lock) {
                        try {
                            ((PrintWriter) this).out.close();
                        } catch (IOException unused) {
                            setError();
                        }
                    }
                }
            };
        }
        this._writer.setCharacterEncoding(str);
        return this._printWriter;
    }

    public Request getRequest() {
        return this._request;
    }

    public HttpFields getRequestFields() {
        return this._requestFields;
    }

    public int getRequests() {
        return this._requests;
    }

    public boolean getResolveNames() {
        return this._connector.getResolveNames();
    }

    public Response getResponse() {
        return this._response;
    }

    public HttpFields getResponseFields() {
        return this._responseFields;
    }

    public Server getServer() {
        return this._server;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public abstract Connection handle() throws IOException;

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0461, code lost:
        if (r16._generator.isComplete() == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x03cd, code lost:
        if (r16._generator.isComplete() == false) goto L292;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x036d A[Catch: all -> 0x0376, TryCatch #9 {all -> 0x0376, blocks: (B:151:0x034b, B:153:0x0353, B:140:0x035c, B:142:0x036d, B:144:0x0373, B:145:0x0375), top: B:150:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRequest() throws IOException {
        Throwable th;
        String str;
        EofException eofException;
        boolean z;
        String name;
        boolean z2;
        RuntimeIOException runtimeIOException;
        boolean z3;
        boolean z4;
        HttpException httpException;
        ContinuationThrowable continuationThrowable;
        String str2;
        Throwable th2;
        String str3;
        String decodedPath;
        String errorPage;
        try {
            if (LOG.isDebugEnabled()) {
                try {
                    name = Thread.currentThread().getName();
                    try {
                        Thread.currentThread().setName(name + " - " + this._uri);
                    } catch (Throwable th3) {
                        th = th3;
                        str = name;
                        eofException = null;
                        z = false;
                        if (str != null) {
                        }
                        if (this._request._async.isUncompleted()) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    eofException = null;
                    z = false;
                    if (str != null) {
                    }
                    if (this._request._async.isUncompleted()) {
                    }
                    throw th;
                }
            } else {
                name = null;
            }
            try {
                Server server = this._server;
                boolean isContinuation = this._request._async.isContinuation();
                if (this._request._async.handling() && server != null) {
                    if (server.isRunning()) {
                        z2 = true;
                        eofException = null;
                        z = false;
                        while (z2) {
                            try {
                                this._request.setHandled(false);
                                int i = 400;
                                try {
                                    try {
                                        try {
                                            try {
                                                try {
                                                    this._uri.getPort();
                                                    try {
                                                        decodedPath = this._uri.getDecodedPath();
                                                    } catch (Exception e) {
                                                        LOG.warn("Failed UTF-8 decode for request path, trying ISO-8859-1", new Object[0]);
                                                        LOG.ignore(e);
                                                        decodedPath = this._uri.getDecodedPath("ISO-8859-1");
                                                    }
                                                    str2 = URIUtil.canonicalPath(decodedPath);
                                                    if (str2 == null) {
                                                        try {
                                                            if (!this._request.getMethod().equals(HttpMethods.CONNECT)) {
                                                                if (decodedPath != null || this._uri.getScheme() == null || this._uri.getHost() == null) {
                                                                    throw new HttpException(400);
                                                                    break;
                                                                } else {
                                                                    str2 = "/";
                                                                    this._request.setRequestURI("");
                                                                }
                                                            }
                                                        } catch (Throwable th5) {
                                                            runtimeIOException = th5;
                                                            try {
                                                                LOG.warn(String.valueOf(this._uri), runtimeIOException);
                                                                try {
                                                                    this._request.setHandled(true);
                                                                    Generator generator = this._generator;
                                                                    if (str2 == null) {
                                                                        str3 = null;
                                                                    } else {
                                                                        str3 = null;
                                                                        i = 500;
                                                                    }
                                                                    generator.sendError(i, str3, str3, true);
                                                                    try {
                                                                        if (this._request.isAsyncStarted()) {
                                                                            this._request.getAsyncContinuation().errorComplete();
                                                                        }
                                                                        z4 = this._request._async.isContinuation();
                                                                        z3 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                                                        eofException = runtimeIOException;
                                                                        z2 = z3;
                                                                        z = true;
                                                                        isContinuation = z4;
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        eofException = runtimeIOException;
                                                                        str = name;
                                                                        z = true;
                                                                        if (str != null) {
                                                                        }
                                                                        if (this._request._async.isUncompleted()) {
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } catch (Throwable th7) {
                                                                    th2 = th7;
                                                                    z = true;
                                                                    if (z) {
                                                                    }
                                                                    this._request._async.isContinuation();
                                                                    if (!this._request._async.unhandle()) {
                                                                    }
                                                                    throw th2;
                                                                }
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                th2 = th;
                                                                if (z) {
                                                                }
                                                                this._request._async.isContinuation();
                                                                if (!this._request._async.unhandle()) {
                                                                }
                                                                throw th2;
                                                            }
                                                        }
                                                    }
                                                    this._request.setPathInfo(str2);
                                                    if (this._out != null) {
                                                        this._out.reopen();
                                                    }
                                                    if (this._request._async.isInitial()) {
                                                        this._request.setDispatcherType(DispatcherType.REQUEST);
                                                        this._connector.customize(this._endp, this._request);
                                                        server.handle(this);
                                                    } else {
                                                        if (!this._request._async.isExpired() || isContinuation) {
                                                            this._request.setDispatcherType(DispatcherType.ASYNC);
                                                        } else {
                                                            Throwable th9 = (Throwable) this._request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
                                                            try {
                                                                this._response.setStatus(500, th9 == null ? "Async Timeout" : "Async Exception");
                                                                this._request.setAttribute(RequestDispatcher.ERROR_STATUS_CODE, new Integer(500));
                                                                this._request.setAttribute(RequestDispatcher.ERROR_MESSAGE, this._response.getReason());
                                                                this._request.setDispatcherType(DispatcherType.ERROR);
                                                                ErrorHandler errorHandler = this._request._async.getContextHandler().getErrorHandler();
                                                                if ((errorHandler instanceof ErrorHandler.ErrorPageMapper) && (errorPage = ((ErrorHandler.ErrorPageMapper) errorHandler).getErrorPage((ae0) this._request._async.getRequest())) != null) {
                                                                    this._request._async.getAsyncEventState().setPath(errorPage);
                                                                }
                                                                eofException = th9;
                                                            } catch (ContinuationThrowable e2) {
                                                                continuationThrowable = e2;
                                                                eofException = th9;
                                                                LOG.ignore(continuationThrowable);
                                                                if (z && this._request.isAsyncStarted()) {
                                                                    this._request.getAsyncContinuation().errorComplete();
                                                                }
                                                                z4 = this._request._async.isContinuation();
                                                                z2 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                                                isContinuation = z4;
                                                            } catch (HttpException e3) {
                                                                httpException = e3;
                                                                eofException = th9;
                                                                try {
                                                                    LOG.debug(httpException);
                                                                    try {
                                                                        this._request.setHandled(true);
                                                                        this._response.sendError(httpException.getStatus(), httpException.getReason());
                                                                        try {
                                                                            if (this._request.isAsyncStarted()) {
                                                                                this._request.getAsyncContinuation().errorComplete();
                                                                            }
                                                                            z4 = this._request._async.isContinuation();
                                                                            z2 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                                                            z = true;
                                                                            isContinuation = z4;
                                                                        } catch (Throwable th10) {
                                                                            th = th10;
                                                                            str = name;
                                                                            z = true;
                                                                            if (str != null) {
                                                                            }
                                                                            if (this._request._async.isUncompleted()) {
                                                                            }
                                                                            throw th;
                                                                        }
                                                                    } catch (Throwable th11) {
                                                                        th2 = th11;
                                                                        runtimeIOException = eofException;
                                                                        z = true;
                                                                        if (z) {
                                                                            try {
                                                                                if (this._request.isAsyncStarted()) {
                                                                                    this._request.getAsyncContinuation().errorComplete();
                                                                                }
                                                                            } catch (Throwable th12) {
                                                                                th = th12;
                                                                                eofException = runtimeIOException;
                                                                                str = name;
                                                                                if (str != null) {
                                                                                }
                                                                                if (this._request._async.isUncompleted()) {
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        }
                                                                        this._request._async.isContinuation();
                                                                        if (!this._request._async.unhandle() && server.isRunning()) {
                                                                            Server server2 = this._server;
                                                                        }
                                                                        throw th2;
                                                                    }
                                                                } catch (Throwable th13) {
                                                                    th2 = th13;
                                                                    runtimeIOException = eofException;
                                                                    if (z) {
                                                                    }
                                                                    this._request._async.isContinuation();
                                                                    if (!this._request._async.unhandle()) {
                                                                    }
                                                                    throw th2;
                                                                }
                                                            }
                                                        }
                                                        server.handleAsync(this);
                                                    }
                                                    if (z && this._request.isAsyncStarted()) {
                                                        this._request.getAsyncContinuation().errorComplete();
                                                    }
                                                    z4 = this._request._async.isContinuation();
                                                    z2 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                                } catch (ContinuationThrowable e4) {
                                                    continuationThrowable = e4;
                                                }
                                            } catch (Throwable th14) {
                                                runtimeIOException = th14;
                                                str2 = null;
                                            }
                                        } catch (ContinuationThrowable e5) {
                                            continuationThrowable = e5;
                                        }
                                    } catch (HttpException e6) {
                                        httpException = e6;
                                    }
                                } catch (EofException e7) {
                                    LOG.debug(e7);
                                    this._request.setHandled(true);
                                    if (!this._response.isCommitted()) {
                                        this._generator.sendError(500, null, null, true);
                                    }
                                    if (this._request.isAsyncStarted()) {
                                        this._request.getAsyncContinuation().errorComplete();
                                    }
                                    boolean isContinuation2 = this._request._async.isContinuation();
                                    z2 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                    eofException = e7;
                                    z4 = isContinuation2;
                                    z = true;
                                    isContinuation = z4;
                                } catch (RuntimeIOException e8) {
                                    try {
                                        LOG.debug(e8);
                                        try {
                                            this._request.setHandled(true);
                                            try {
                                                if (this._request.isAsyncStarted()) {
                                                    this._request.getAsyncContinuation().errorComplete();
                                                }
                                                boolean isContinuation3 = this._request._async.isContinuation();
                                                z3 = !this._request._async.unhandle() && server.isRunning() && this._server != null;
                                                eofException = e8;
                                                z4 = isContinuation3;
                                                z2 = z3;
                                                z = true;
                                                isContinuation = z4;
                                            } catch (Throwable th15) {
                                                eofException = e8;
                                                str = name;
                                                z = true;
                                                th = th15;
                                                if (str != null) {
                                                    Thread.currentThread().setName(str);
                                                }
                                                if (this._request._async.isUncompleted()) {
                                                    this._request._async.doComplete(eofException);
                                                    if (this._expect100Continue) {
                                                        LOG.debug("100 continues not sent", new Object[0]);
                                                        this._expect100Continue = false;
                                                        if (!this._response.isCommitted()) {
                                                            this._generator.setPersistent(false);
                                                        }
                                                    }
                                                    if (this._endp.isOpen()) {
                                                        if (z) {
                                                            this._endp.shutdownOutput();
                                                            this._generator.setPersistent(false);
                                                        } else {
                                                            if (!this._response.isCommitted() && !this._request.isHandled()) {
                                                                this._response.sendError(404);
                                                            }
                                                            this._response.complete();
                                                            if (this._generator.isPersistent()) {
                                                                this._connector.persist(this._endp);
                                                            }
                                                        }
                                                        this._request.setHandled(true);
                                                    }
                                                    this._response.complete();
                                                    this._request.setHandled(true);
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                            runtimeIOException = e8;
                                            z = true;
                                            th2 = th;
                                            if (z) {
                                            }
                                            this._request._async.isContinuation();
                                            if (!this._request._async.unhandle()) {
                                                Server server22 = this._server;
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th17) {
                                        th = th17;
                                        runtimeIOException = e8;
                                    }
                                }
                                isContinuation = z4;
                            } catch (Throwable th18) {
                                th = th18;
                            }
                        }
                        if (name != null) {
                            Thread.currentThread().setName(name);
                        }
                        if (this._request._async.isUncompleted()) {
                            return;
                        }
                        this._request._async.doComplete(eofException);
                        if (this._expect100Continue) {
                            LOG.debug("100 continues not sent", new Object[0]);
                            this._expect100Continue = false;
                            if (!this._response.isCommitted()) {
                                this._generator.setPersistent(false);
                            }
                        }
                        if (this._endp.isOpen()) {
                            if (z) {
                                this._endp.shutdownOutput();
                                this._generator.setPersistent(false);
                            } else {
                                if (!this._response.isCommitted() && !this._request.isHandled()) {
                                    this._response.sendError(404);
                                }
                                this._response.complete();
                                if (this._generator.isPersistent()) {
                                    this._connector.persist(this._endp);
                                }
                            }
                            this._request.setHandled(true);
                            return;
                        }
                        this._response.complete();
                        this._request.setHandled(true);
                        return;
                    }
                }
                z2 = false;
                eofException = null;
                z = false;
                while (z2) {
                }
                if (name != null) {
                }
                if (this._request._async.isUncompleted()) {
                }
            } catch (Throwable th19) {
                th = th19;
                str = name;
                eofException = null;
                z = false;
                if (str != null) {
                }
                if (this._request._async.isUncompleted()) {
                }
                throw th;
            }
        } catch (Throwable th20) {
            th = th20;
            str = null;
            eofException = null;
        }
    }

    public void headerComplete() throws IOException {
        if (this._endp.isOutputShutdown()) {
            this._endp.close();
            return;
        }
        this._requests++;
        this._generator.setVersion(this._version);
        int i = this._version;
        if (i == 10) {
            this._generator.setHead(this._head);
            if (this._parser.isPersistent()) {
                this._responseFields.add(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.KEEP_ALIVE_BUFFER);
                this._generator.setPersistent(true);
            } else if (HttpMethods.CONNECT.equals(this._request.getMethod())) {
                this._generator.setPersistent(true);
                this._parser.setPersistent(true);
                Parser parser = this._parser;
                if (parser instanceof HttpParser) {
                    ((HttpParser) parser).setState(0);
                }
            }
            if (this._server.getSendDateHeader()) {
                this._generator.setDate(this._request.getTimeStampBuffer());
            }
        } else if (i == 11) {
            this._generator.setHead(this._head);
            if (!this._parser.isPersistent()) {
                this._responseFields.add(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                this._generator.setPersistent(false);
            }
            if (this._server.getSendDateHeader()) {
                this._generator.setDate(this._request.getTimeStampBuffer());
            }
            if (!this._host) {
                LOG.debug("!host {}", this);
                this._generator.setResponse(400, null);
                this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                this._generator.completeHeader(this._responseFields, true);
                this._generator.complete();
                return;
            } else if (this._expect) {
                LOG.debug("!expectation {}", this);
                this._generator.setResponse(417, null);
                this._responseFields.put(HttpHeaders.CONNECTION_BUFFER, HttpHeaderValues.CLOSE_BUFFER);
                this._generator.completeHeader(this._responseFields, true);
                this._generator.complete();
                return;
            }
        }
        String str = this._charset;
        if (str != null) {
            this._request.setCharacterEncodingUnchecked(str);
        }
        if ((((HttpParser) this._parser).getContentLength() > 0 || ((HttpParser) this._parser).isChunking()) && !this._expect100Continue) {
            this._delayedHandling = true;
        } else {
            handleRequest();
        }
    }

    public void include() {
        this._include++;
    }

    public void included() {
        this._include--;
        if (this._out != null) {
            this._out.reopen();
        }
    }

    public boolean isConfidential(Request request) {
        Connector connector = this._connector;
        return connector != null && connector.isConfidential(request);
    }

    public boolean isEarlyEOF() {
        return this._earlyEOF;
    }

    public boolean isExpecting100Continues() {
        return this._expect100Continue;
    }

    public boolean isExpecting102Processing() {
        return this._expect102Processing;
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isIdle() {
        return this._generator.isIdle() && (this._parser.isIdle() || this._delayedHandling);
    }

    public boolean isIncluding() {
        return this._include > 0;
    }

    public boolean isIntegral(Request request) {
        Connector connector = this._connector;
        return connector != null && connector.isIntegral(request);
    }

    public boolean isResponseCommitted() {
        return this._generator.isCommitted();
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public boolean isSuspended() {
        return this._request.getAsyncContinuation().isSuspended();
    }

    public void messageComplete(long j) throws IOException {
        if (this._delayedHandling) {
            this._delayedHandling = false;
            handleRequest();
        }
    }

    public HttpGenerator newHttpGenerator(Buffers buffers, EndPoint endPoint) {
        return new HttpGenerator(buffers, endPoint);
    }

    public HttpParser newHttpParser(Buffers buffers, EndPoint endPoint, HttpParser.EventHandler eventHandler) {
        return new HttpParser(buffers, endPoint, eventHandler);
    }

    @Override // org.eclipse.jetty.p059io.Connection
    public void onClose() {
        LOG.debug("closed {}", this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r0 != 40) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parsedHeader(Buffer buffer, Buffer buffer2) throws IOException {
        int ordinal = HttpHeaders.CACHE.getOrdinal(buffer);
        if (ordinal != 16) {
            if (ordinal != 21) {
                if (ordinal != 24) {
                    if (ordinal == 27) {
                        this._host = true;
                    }
                } else if (this._version >= 11) {
                    buffer2 = HttpHeaderValues.CACHE.lookup(buffer2);
                    int ordinal2 = HttpHeaderValues.CACHE.getOrdinal(buffer2);
                    if (ordinal2 == 6) {
                        this._expect100Continue = this._generator instanceof HttpGenerator;
                    } else if (ordinal2 != 7) {
                        String[] split = buffer2.toString().split(",");
                        for (int i = 0; split != null && i < split.length; i++) {
                            BufferCache.CachedBuffer cachedBuffer = HttpHeaderValues.CACHE.get(split[i].trim());
                            if (cachedBuffer != null) {
                                int ordinal3 = cachedBuffer.getOrdinal();
                                if (ordinal3 == 6) {
                                    this._expect100Continue = this._generator instanceof HttpGenerator;
                                } else if (ordinal3 == 7) {
                                    this._expect102Processing = this._generator instanceof HttpGenerator;
                                }
                            }
                            this._expect = true;
                        }
                    } else {
                        this._expect102Processing = this._generator instanceof HttpGenerator;
                    }
                }
            }
            buffer2 = HttpHeaderValues.CACHE.lookup(buffer2);
        } else {
            buffer2 = MimeTypes.CACHE.lookup(buffer2);
            this._charset = MimeTypes.getCharsetFromContentType(buffer2);
        }
        this._requestFields.add(buffer, buffer2);
    }

    public void reset() {
        this._parser.reset();
        this._parser.returnBuffers();
        this._requestFields.clear();
        this._request.recycle();
        this._generator.reset();
        this._generator.returnBuffers();
        this._responseFields.clear();
        this._response.recycle();
        this._uri.clear();
        this._writer = null;
        this._earlyEOF = false;
    }

    public void setAssociatedObject(Object obj) {
        this._associatedObject = obj;
    }

    public void startRequest(Buffer buffer, Buffer buffer2, Buffer buffer3) throws IOException {
        Buffer asImmutableBuffer = buffer2.asImmutableBuffer();
        this._host = false;
        this._expect = false;
        this._expect100Continue = false;
        this._expect102Processing = false;
        this._delayedHandling = false;
        this._charset = null;
        if (this._request.getTimeStamp() == 0) {
            this._request.setTimeStamp(System.currentTimeMillis());
        }
        this._request.setMethod(buffer.toString());
        try {
            this._head = false;
            int ordinal = HttpMethods.CACHE.getOrdinal(buffer);
            if (ordinal == 3) {
                this._head = true;
                this._uri.parse(asImmutableBuffer.array(), asImmutableBuffer.getIndex(), asImmutableBuffer.length());
            } else if (ordinal != 8) {
                this._uri.parse(asImmutableBuffer.array(), asImmutableBuffer.getIndex(), asImmutableBuffer.length());
            } else {
                this._uri.parseConnect(asImmutableBuffer.array(), asImmutableBuffer.getIndex(), asImmutableBuffer.length());
            }
            this._request.setUri(this._uri);
            if (buffer3 == null) {
                this._request.setProtocol("");
                this._version = 9;
                return;
            }
            BufferCache.CachedBuffer cachedBuffer = HttpVersions.CACHE.get(buffer3);
            if (cachedBuffer == null) {
                throw new HttpException(400, null);
            }
            int ordinal2 = HttpVersions.CACHE.getOrdinal(cachedBuffer);
            this._version = ordinal2;
            if (ordinal2 <= 0) {
                this._version = 10;
            }
            this._request.setProtocol(cachedBuffer.toString());
        } catch (Exception e) {
            LOG.debug(e);
            if (!(e instanceof HttpException)) {
                throw new HttpException(400, null, e);
            }
            throw ((HttpException) e);
        }
    }

    @Override // org.eclipse.jetty.p059io.AbstractConnection
    public String toString() {
        return String.format("%s,g=%s,p=%s,r=%d", super.toString(), this._generator, this._parser, Integer.valueOf(this._requests));
    }
}
