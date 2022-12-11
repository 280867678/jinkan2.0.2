package org.eclipse.jetty.server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import me.tvspark.ae0;
import me.tvspark.ce0;
import me.tvspark.ee0;
import me.tvspark.me0;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeaders;
import org.eclipse.jetty.http.HttpParser;
import org.eclipse.jetty.http.HttpURI;
import org.eclipse.jetty.http.HttpVersions;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.p059io.Buffer;
import org.eclipse.jetty.p059io.BufferUtil;
import org.eclipse.jetty.p059io.ByteArrayBuffer;
import org.eclipse.jetty.p059io.EndPoint;
import org.eclipse.jetty.p059io.nio.DirectNIOBuffer;
import org.eclipse.jetty.p059io.nio.IndirectNIOBuffer;
import org.eclipse.jetty.server.AbstractHttpConnection;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.AttributesMap;
import org.eclipse.jetty.util.C3009IO;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.MultiPartInputStream;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.UrlEncoded;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: classes4.dex */
public class Request implements ae0 {
    public static final int _STREAM = 1;
    public static final String __ASYNC_FWD = "org.eclipse.asyncfwd";
    public static final String __MULTIPART_CONFIG_ELEMENT = "org.eclipse.multipartConfig";
    public static final String __MULTIPART_CONTEXT = "org.eclipse.multiPartContext";
    public static final String __MULTIPART_INPUT_STREAM = "org.eclipse.multiPartInputStream";
    public static final int __NONE = 0;
    public static final int __READER = 2;
    public volatile Attributes _attributes;
    public Authentication _authentication;
    public MultiMap<String> _baseParameters;
    public String _characterEncoding;
    public AbstractHttpConnection _connection;
    public ContextHandler.Context _context;
    public String _contextPath;
    public CookieCutter _cookies;
    public long _dispatchTime;
    public DispatcherType _dispatcherType;
    public EndPoint _endp;
    public String _method;
    public MultiPartInputStream _multiPartInputStream;
    public boolean _newContext;
    public MultiMap<String> _parameters;
    public boolean _paramsExtracted;
    public String _pathInfo;
    public int _port;
    public String _queryEncoding;
    public String _queryString;
    public BufferedReader _reader;
    public String _readerEncoding;
    public String _remoteAddr;
    public String _remoteHost;
    public Object _requestAttributeListeners;
    public String _requestURI;
    public String _requestedSessionId;
    public Map<Object, ee0> _savedNewSessions;
    public UserIdentity.Scope _scope;
    public String _serverName;
    public String _servletPath;
    public ee0 _session;
    public SessionManager _sessionManager;
    public long _timeStamp;
    public Buffer _timeStampBuffer;
    public HttpURI _uri;
    public static final Logger LOG = Log.getLogger(Request.class);
    public static final Collection __defaultLocale = Collections.singleton(Locale.getDefault());
    public final AsyncContinuation _async = new AsyncContinuation();
    public boolean _asyncSupported = true;
    public boolean _cookiesExtracted = false;
    public boolean _dns = false;
    public boolean _handled = false;
    public int _inputState = 0;
    public String _protocol = HttpVersions.HTTP_1_1;
    public boolean _requestedSessionIdFromCookie = false;
    public String _scheme = "http";

    /* loaded from: classes4.dex */
    public static class MultiPartCleanerListener implements ServletRequestListener {
        @Override // javax.servlet.ServletRequestListener
        public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
            MultiPartInputStream multiPartInputStream = (MultiPartInputStream) servletRequestEvent.getServletRequest().getAttribute(Request.__MULTIPART_INPUT_STREAM);
            if (multiPartInputStream == null || ((ContextHandler.Context) servletRequestEvent.getServletRequest().getAttribute(Request.__MULTIPART_CONTEXT)) != servletRequestEvent.getServletContext()) {
                return;
            }
            try {
                multiPartInputStream.deleteParts();
            } catch (MultiException e) {
                servletRequestEvent.getServletContext().log("Errors deleting multipart tmp files", e);
            }
        }

        @Override // javax.servlet.ServletRequestListener
        public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        }
    }

    public Request() {
    }

    public Request(AbstractHttpConnection abstractHttpConnection) {
        setConnection(abstractHttpConnection);
    }

    public static Request getRequest(ae0 ae0Var) {
        return ae0Var instanceof Request ? (Request) ae0Var : AbstractHttpConnection.getCurrentConnection().getRequest();
    }

    public void addEventListener(EventListener eventListener) {
        if (eventListener instanceof ServletRequestAttributeListener) {
            this._requestAttributeListeners = LazyList.add(this._requestAttributeListeners, eventListener);
        }
        if (!(eventListener instanceof ContinuationListener)) {
            if (eventListener instanceof AsyncListener) {
                throw new IllegalArgumentException(eventListener.getClass().toString());
            }
            return;
        }
        throw new IllegalArgumentException(eventListener.getClass().toString());
    }

    @Override // me.tvspark.ae0
    public boolean authenticate(ce0 ce0Var) throws IOException, ServletException {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) authentication).authenticate(this, ce0Var));
            return !(this._authentication instanceof Authentication.ResponseSent);
        }
        ce0Var.sendError(401);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void extractParameters() {
        Logger logger;
        ServletException servletException;
        int contentLength;
        int i;
        int i2;
        MultiMap<String> multiMap;
        if (this._baseParameters == null) {
            this._baseParameters = new MultiMap<>(16);
        }
        if (this._paramsExtracted) {
            if (multiMap != null) {
                return;
            }
            return;
        }
        this._paramsExtracted = true;
        try {
            if (this._uri != null && this._uri.hasQuery()) {
                if (this._queryEncoding == null) {
                    this._uri.decodeQueryTo(this._baseParameters);
                } else {
                    try {
                        this._uri.decodeQueryTo(this._baseParameters, this._queryEncoding);
                    } catch (UnsupportedEncodingException e) {
                        if (LOG.isDebugEnabled()) {
                            LOG.warn(e);
                        } else {
                            LOG.warn(e.toString(), new Object[0]);
                        }
                    }
                }
            }
            String characterEncoding = getCharacterEncoding();
            String contentType = getContentType();
            if (contentType != null && contentType.length() > 0) {
                contentType = HttpFields.valueParameters(contentType, null);
                if ("application/x-www-form-urlencoded".equalsIgnoreCase(contentType) && this._inputState == 0 && (("POST".equals(getMethod()) || "PUT".equals(getMethod())) && (contentLength = getContentLength()) != 0)) {
                    try {
                        int i3 = -1;
                        if (this._context != null) {
                            i = this._context.getContextHandler().getMaxFormContentSize();
                            i2 = this._context.getContextHandler().getMaxFormKeys();
                        } else {
                            i = -1;
                            i2 = -1;
                        }
                        if (i < 0) {
                            Object attribute = this._connection.getConnector().getServer().getAttribute("org.eclipse.jetty.server.Request.maxFormContentSize");
                            if (attribute == null) {
                                i = 200000;
                            } else if (attribute instanceof Number) {
                                i = ((Number) attribute).intValue();
                            } else if (attribute instanceof String) {
                                i = Integer.valueOf((String) attribute).intValue();
                            }
                        }
                        if (i2 < 0) {
                            Object attribute2 = this._connection.getConnector().getServer().getAttribute("org.eclipse.jetty.server.Request.maxFormKeys");
                            if (attribute2 == null) {
                                i2 = 1000;
                            } else if (attribute2 instanceof Number) {
                                i2 = ((Number) attribute2).intValue();
                            } else if (attribute2 instanceof String) {
                                i2 = Integer.valueOf((String) attribute2).intValue();
                            }
                        }
                        if (contentLength > i && i > 0) {
                            throw new IllegalStateException("Form too large " + contentLength + ">" + i);
                        }
                        ServletInputStream inputStream = getInputStream();
                        MultiMap<String> multiMap2 = this._baseParameters;
                        if (contentLength < 0) {
                            i3 = i;
                        }
                        UrlEncoded.decodeTo(inputStream, multiMap2, characterEncoding, i3, i2);
                    } catch (IOException e2) {
                        if (LOG.isDebugEnabled()) {
                            LOG.warn(e2);
                        } else {
                            LOG.warn(e2.toString(), new Object[0]);
                        }
                    }
                }
            }
            if (this._parameters == null) {
                this._parameters = this._baseParameters;
            } else if (this._parameters != this._baseParameters) {
                for (Map.Entry<String, Object> entry : this._baseParameters.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    for (int i4 = 0; i4 < LazyList.size(value); i4++) {
                        this._parameters.add(key, LazyList.get(value, i4));
                    }
                }
            }
            if (contentType != null && contentType.length() > 0 && contentType.startsWith("multipart/form-data") && getAttribute(__MULTIPART_CONFIG_ELEMENT) != null) {
                try {
                    getParts();
                } catch (IOException e3) {
                    if (LOG.isDebugEnabled()) {
                        servletException = e3;
                        logger = LOG;
                        logger.warn(servletException);
                    } else {
                        LOG.warn(e3.toString(), new Object[0]);
                    }
                } catch (ServletException e4) {
                    if (LOG.isDebugEnabled()) {
                        servletException = e4;
                        logger = LOG;
                        logger.warn(servletException);
                    } else {
                        LOG.warn(e4.toString(), new Object[0]);
                    }
                }
            }
            if (this._parameters != null) {
                return;
            }
            this._parameters = this._baseParameters;
        } finally {
            if (this._parameters == null) {
                this._parameters = this._baseParameters;
            }
        }
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext getAsyncContext() {
        if (!this._async.isInitial() || this._async.isAsyncStarted()) {
            return this._async;
        }
        throw new IllegalStateException(this._async.getStatusString());
    }

    public AsyncContinuation getAsyncContinuation() {
        return this._async;
    }

    @Override // javax.servlet.ServletRequest
    public Object getAttribute(String str) {
        if ("org.eclipse.jetty.io.EndPoint.maxIdleTime".equalsIgnoreCase(str)) {
            return new Long(getConnection().getEndPoint().getMaxIdleTime());
        }
        Object attribute = this._attributes == null ? null : this._attributes.getAttribute(str);
        return (attribute != null || !Continuation.ATTRIBUTE.equals(str)) ? attribute : this._async;
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration getAttributeNames() {
        return this._attributes == null ? Collections.enumeration(Collections.EMPTY_LIST) : AttributesMap.getAttributeNamesCopy(this._attributes);
    }

    public Attributes getAttributes() {
        if (this._attributes == null) {
            this._attributes = new AttributesMap();
        }
        return this._attributes;
    }

    @Override // me.tvspark.ae0
    public String getAuthType() {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) authentication).authenticate(this));
        }
        Authentication authentication2 = this._authentication;
        if (authentication2 instanceof Authentication.User) {
            return ((Authentication.User) authentication2).getAuthMethod();
        }
        return null;
    }

    public Authentication getAuthentication() {
        return this._authentication;
    }

    @Override // javax.servlet.ServletRequest
    public String getCharacterEncoding() {
        return this._characterEncoding;
    }

    public AbstractHttpConnection getConnection() {
        return this._connection;
    }

    @Override // javax.servlet.ServletRequest
    public int getContentLength() {
        return (int) this._connection.getRequestFields().getLongField(HttpHeaders.CONTENT_LENGTH_BUFFER);
    }

    public long getContentRead() {
        AbstractHttpConnection abstractHttpConnection = this._connection;
        if (abstractHttpConnection == null || abstractHttpConnection.getParser() == null) {
            return -1L;
        }
        return ((HttpParser) this._connection.getParser()).getContentRead();
    }

    @Override // javax.servlet.ServletRequest
    public String getContentType() {
        return this._connection.getRequestFields().getStringField(HttpHeaders.CONTENT_TYPE_BUFFER);
    }

    public ContextHandler.Context getContext() {
        return this._context;
    }

    @Override // me.tvspark.ae0
    public String getContextPath() {
        return this._contextPath;
    }

    @Override // me.tvspark.ae0
    public Cookie[] getCookies() {
        if (this._cookiesExtracted) {
            CookieCutter cookieCutter = this._cookies;
            if (cookieCutter != null) {
                return cookieCutter.getCookies();
            }
            return null;
        }
        this._cookiesExtracted = true;
        Enumeration<String> values = this._connection.getRequestFields().getValues(HttpHeaders.COOKIE_BUFFER);
        if (values != null) {
            if (this._cookies == null) {
                this._cookies = new CookieCutter();
            }
            while (values.hasMoreElements()) {
                this._cookies.addCookieField(values.nextElement());
            }
        }
        CookieCutter cookieCutter2 = this._cookies;
        if (cookieCutter2 != null) {
            return cookieCutter2.getCookies();
        }
        return null;
    }

    @Override // me.tvspark.ae0
    public long getDateHeader(String str) {
        return this._connection.getRequestFields().getDateField(str);
    }

    public long getDispatchTime() {
        return this._dispatchTime;
    }

    @Override // javax.servlet.ServletRequest
    public DispatcherType getDispatcherType() {
        return this._dispatcherType;
    }

    @Override // me.tvspark.ae0
    public String getHeader(String str) {
        return this._connection.getRequestFields().getStringField(str);
    }

    @Override // me.tvspark.ae0
    public Enumeration getHeaderNames() {
        return this._connection.getRequestFields().getFieldNames();
    }

    @Override // me.tvspark.ae0
    public Enumeration getHeaders(String str) {
        Enumeration<String> values = this._connection.getRequestFields().getValues(str);
        return values == null ? Collections.enumeration(Collections.EMPTY_LIST) : values;
    }

    public int getInputState() {
        return this._inputState;
    }

    @Override // javax.servlet.ServletRequest
    public ServletInputStream getInputStream() throws IOException {
        int i = this._inputState;
        if (i == 0 || i == 1) {
            this._inputState = 1;
            return this._connection.getInputStream();
        }
        throw new IllegalStateException("READER");
    }

    @Override // me.tvspark.ae0
    public int getIntHeader(String str) {
        return (int) this._connection.getRequestFields().getLongField(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalAddr() {
        EndPoint endPoint = this._endp;
        if (endPoint == null) {
            return null;
        }
        return endPoint.getLocalAddr();
    }

    @Override // javax.servlet.ServletRequest
    public String getLocalName() {
        EndPoint endPoint = this._endp;
        if (endPoint == null) {
            return null;
        }
        if (this._dns) {
            return endPoint.getLocalHost();
        }
        String localAddr = endPoint.getLocalAddr();
        return (localAddr == null || localAddr.indexOf(58) < 0) ? localAddr : outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[", localAddr, "]");
    }

    @Override // javax.servlet.ServletRequest
    public int getLocalPort() {
        EndPoint endPoint = this._endp;
        if (endPoint == null) {
            return 0;
        }
        return endPoint.getLocalPort();
    }

    @Override // javax.servlet.ServletRequest
    public Locale getLocale() {
        String str;
        Enumeration<String> values = this._connection.getRequestFields().getValues("Accept-Language", HttpFields.__separators);
        if (values == null || !values.hasMoreElements()) {
            return Locale.getDefault();
        }
        List qualityList = HttpFields.qualityList(values);
        if (qualityList.size() != 0 && qualityList.size() > 0) {
            String valueParameters = HttpFields.valueParameters((String) qualityList.get(0), null);
            int indexOf = valueParameters.indexOf(45);
            if (indexOf > -1) {
                str = valueParameters.substring(indexOf + 1).trim();
                valueParameters = valueParameters.substring(0, indexOf).trim();
            } else {
                str = "";
            }
            return new Locale(valueParameters, str);
        }
        return Locale.getDefault();
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration getLocales() {
        Collection collection;
        String str;
        Enumeration<String> values = this._connection.getRequestFields().getValues("Accept-Language", HttpFields.__separators);
        if (values != null && values.hasMoreElements()) {
            List qualityList = HttpFields.qualityList(values);
            if (qualityList.size() != 0) {
                int size = qualityList.size();
                Object obj = null;
                for (int i = 0; i < size; i++) {
                    String valueParameters = HttpFields.valueParameters((String) qualityList.get(i), null);
                    int indexOf = valueParameters.indexOf(45);
                    if (indexOf > -1) {
                        str = valueParameters.substring(indexOf + 1).trim();
                        valueParameters = valueParameters.substring(0, indexOf).trim();
                    } else {
                        str = "";
                    }
                    obj = LazyList.add(LazyList.ensureSize(obj, size), new Locale(valueParameters, str));
                }
                if (LazyList.size(obj) != 0) {
                    collection = LazyList.getList(obj);
                    return Collections.enumeration(collection);
                }
            }
        }
        collection = __defaultLocale;
        return Collections.enumeration(collection);
    }

    @Override // me.tvspark.ae0
    public String getMethod() {
        return this._method;
    }

    @Override // javax.servlet.ServletRequest
    public String getParameter(String str) {
        if (!this._paramsExtracted) {
            extractParameters();
        }
        return (String) this._parameters.getValue(str, 0);
    }

    @Override // javax.servlet.ServletRequest
    public Map getParameterMap() {
        if (!this._paramsExtracted) {
            extractParameters();
        }
        return Collections.unmodifiableMap(this._parameters.toStringArrayMap());
    }

    @Override // javax.servlet.ServletRequest
    public Enumeration getParameterNames() {
        if (!this._paramsExtracted) {
            extractParameters();
        }
        return Collections.enumeration(this._parameters.keySet());
    }

    @Override // javax.servlet.ServletRequest
    public String[] getParameterValues(String str) {
        if (!this._paramsExtracted) {
            extractParameters();
        }
        List values = this._parameters.getValues(str);
        if (values == null) {
            return null;
        }
        return (String[]) values.toArray(new String[values.size()]);
    }

    public MultiMap<String> getParameters() {
        return this._parameters;
    }

    @Override // me.tvspark.ae0
    public me0 getPart(String str) throws IOException, ServletException {
        getParts();
        return this._multiPartInputStream.getPart(str);
    }

    @Override // me.tvspark.ae0
    public Collection<me0> getParts() throws IOException, ServletException {
        if (getContentType() == null || !getContentType().startsWith("multipart/form-data")) {
            throw new ServletException("Content-Type != multipart/form-data");
        }
        if (this._multiPartInputStream == null) {
            this._multiPartInputStream = (MultiPartInputStream) getAttribute(__MULTIPART_INPUT_STREAM);
        }
        if (this._multiPartInputStream == null) {
            MultipartConfigElement multipartConfigElement = (MultipartConfigElement) getAttribute(__MULTIPART_CONFIG_ELEMENT);
            if (multipartConfigElement == null) {
                throw new IllegalStateException("No multipart config for servlet");
            }
            ServletInputStream inputStream = getInputStream();
            String contentType = getContentType();
            ContextHandler.Context context = this._context;
            ByteArrayOutputStream byteArrayOutputStream = null;
            MultiPartInputStream multiPartInputStream = new MultiPartInputStream(inputStream, contentType, multipartConfigElement, context != null ? (File) context.getAttribute(ServletContext.TEMPDIR) : null);
            this._multiPartInputStream = multiPartInputStream;
            setAttribute(__MULTIPART_INPUT_STREAM, multiPartInputStream);
            setAttribute(__MULTIPART_CONTEXT, this._context);
            Iterator<me0> it = this._multiPartInputStream.getParts().iterator();
            while (it.hasNext()) {
                MultiPartInputStream.MultiPart multiPart = (MultiPartInputStream.MultiPart) it.next();
                if (multiPart.getContentDispositionFilename() == null) {
                    String charsetFromContentType = multiPart.getContentType() != null ? MimeTypes.getCharsetFromContentType(new ByteArrayBuffer(multiPart.getContentType())) : null;
                    InputStream inputStream2 = multiPart.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            C3009IO.copy(inputStream2, byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            if (charsetFromContentType == null) {
                                charsetFromContentType = "UTF-8";
                            }
                            String str = new String(byteArray, charsetFromContentType);
                            getParameter("");
                            getParameters().add(multiPart.getName(), str);
                            C3009IO.close((OutputStream) byteArrayOutputStream2);
                            C3009IO.close(inputStream2);
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            C3009IO.close((OutputStream) byteArrayOutputStream);
                            C3009IO.close(inputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        return this._multiPartInputStream.getParts();
    }

    @Override // me.tvspark.ae0
    public String getPathInfo() {
        return this._pathInfo;
    }

    @Override // me.tvspark.ae0
    public String getPathTranslated() {
        ContextHandler.Context context;
        String str = this._pathInfo;
        if (str == null || (context = this._context) == null) {
            return null;
        }
        return context.getRealPath(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getProtocol() {
        return this._protocol;
    }

    public String getQueryEncoding() {
        return this._queryEncoding;
    }

    @Override // me.tvspark.ae0
    public String getQueryString() {
        HttpURI httpURI;
        if (this._queryString == null && (httpURI = this._uri) != null) {
            String str = this._queryEncoding;
            this._queryString = str == null ? httpURI.getQuery() : httpURI.getQuery(str);
        }
        return this._queryString;
    }

    @Override // javax.servlet.ServletRequest
    public BufferedReader getReader() throws IOException {
        int i = this._inputState;
        if (i == 0 || i == 2) {
            if (this._inputState == 2) {
                return this._reader;
            }
            String characterEncoding = getCharacterEncoding();
            if (characterEncoding == null) {
                characterEncoding = "ISO-8859-1";
            }
            if (this._reader == null || !characterEncoding.equalsIgnoreCase(this._readerEncoding)) {
                final ServletInputStream inputStream = getInputStream();
                this._readerEncoding = characterEncoding;
                this._reader = new BufferedReader(new InputStreamReader(inputStream, characterEncoding)) { // from class: org.eclipse.jetty.server.Request.1
                    @Override // java.io.BufferedReader, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        inputStream.close();
                    }
                };
            }
            this._inputState = 2;
            return this._reader;
        }
        throw new IllegalStateException("STREAMED");
    }

    @Override // javax.servlet.ServletRequest
    public String getRealPath(String str) {
        ContextHandler.Context context = this._context;
        if (context == null) {
            return null;
        }
        return context.getRealPath(str);
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteAddr() {
        String str = this._remoteAddr;
        if (str != null) {
            return str;
        }
        EndPoint endPoint = this._endp;
        if (endPoint != null) {
            return endPoint.getRemoteAddr();
        }
        return null;
    }

    @Override // javax.servlet.ServletRequest
    public String getRemoteHost() {
        if (this._dns) {
            String str = this._remoteHost;
            if (str != null) {
                return str;
            }
            EndPoint endPoint = this._endp;
            if (endPoint != null) {
                return endPoint.getRemoteHost();
            }
            return null;
        }
        return getRemoteAddr();
    }

    @Override // javax.servlet.ServletRequest
    public int getRemotePort() {
        EndPoint endPoint = this._endp;
        if (endPoint == null) {
            return 0;
        }
        return endPoint.getRemotePort();
    }

    @Override // me.tvspark.ae0
    public String getRemoteUser() {
        Principal userPrincipal = getUserPrincipal();
        if (userPrincipal == null) {
            return null;
        }
        return userPrincipal.getName();
    }

    @Override // javax.servlet.ServletRequest
    public RequestDispatcher getRequestDispatcher(String str) {
        String compactPath = URIUtil.compactPath(str);
        if (compactPath == null || this._context == null) {
            return null;
        }
        String str2 = "/";
        if (!compactPath.startsWith(str2)) {
            String addPaths = URIUtil.addPaths(this._servletPath, this._pathInfo);
            int lastIndexOf = addPaths.lastIndexOf(str2);
            if (lastIndexOf > 1) {
                str2 = addPaths.substring(0, lastIndexOf + 1);
            }
            compactPath = URIUtil.addPaths(str2, compactPath);
        }
        return this._context.getRequestDispatcher(compactPath);
    }

    @Override // me.tvspark.ae0
    public String getRequestURI() {
        HttpURI httpURI;
        if (this._requestURI == null && (httpURI = this._uri) != null) {
            this._requestURI = httpURI.getPathAndParam();
        }
        return this._requestURI;
    }

    @Override // me.tvspark.ae0
    public StringBuffer getRequestURL() {
        StringBuffer stringBuffer = new StringBuffer(48);
        synchronized (stringBuffer) {
            String scheme = getScheme();
            int serverPort = getServerPort();
            stringBuffer.append(scheme);
            stringBuffer.append("://");
            stringBuffer.append(getServerName());
            if (this._port > 0 && ((scheme.equalsIgnoreCase("http") && serverPort != 80) || (scheme.equalsIgnoreCase("https") && serverPort != 443))) {
                stringBuffer.append(':');
                stringBuffer.append(this._port);
            }
            stringBuffer.append(getRequestURI());
        }
        return stringBuffer;
    }

    @Override // me.tvspark.ae0
    public String getRequestedSessionId() {
        return this._requestedSessionId;
    }

    public UserIdentity getResolvedUserIdentity() {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.User) {
            return ((Authentication.User) authentication).getUserIdentity();
        }
        return null;
    }

    public Response getResponse() {
        return this._connection._response;
    }

    public StringBuilder getRootURL() {
        StringBuilder sb = new StringBuilder(48);
        String scheme = getScheme();
        int serverPort = getServerPort();
        sb.append(scheme);
        sb.append("://");
        sb.append(getServerName());
        if (serverPort > 0 && ((scheme.equalsIgnoreCase("http") && serverPort != 80) || (scheme.equalsIgnoreCase("https") && serverPort != 443))) {
            sb.append(':');
            sb.append(serverPort);
        }
        return sb;
    }

    @Override // javax.servlet.ServletRequest
    public String getScheme() {
        return this._scheme;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r5._serverName == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
        if (r5._port >= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
        return r5._serverName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
        r5._serverName = org.eclipse.jetty.p059io.BufferUtil.to8859_1_String(r0);
        r5._port = 0;
     */
    @Override // javax.servlet.ServletRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getServerName() {
        String str = this._serverName;
        if (str != null) {
            return str;
        }
        HttpURI httpURI = this._uri;
        if (httpURI == null) {
            throw new IllegalStateException("No uri");
        }
        this._serverName = httpURI.getHost();
        this._port = this._uri.getPort();
        String str2 = this._serverName;
        if (str2 != null) {
            return str2;
        }
        Buffer buffer = this._connection.getRequestFields().get(HttpHeaders.HOST_BUFFER);
        if (buffer == null) {
            if (this._connection != null) {
                this._serverName = getLocalName();
                this._port = getLocalPort();
                String str3 = this._serverName;
                if (str3 != null && !StringUtil.ALL_INTERFACES.equals(str3)) {
                    return this._serverName;
                }
            }
            try {
                this._serverName = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                LOG.ignore(e);
            }
            return this._serverName;
        }
        int putIndex = buffer.putIndex();
        while (true) {
            int i = putIndex - 1;
            if (putIndex <= buffer.getIndex()) {
                break;
            }
            char peek = (char) (buffer.peek(i) & 255);
            if (peek == ':') {
                this._serverName = BufferUtil.to8859_1_String(buffer.peek(buffer.getIndex(), i - buffer.getIndex()));
                try {
                    try {
                        this._port = BufferUtil.toInt(buffer.peek(i + 1, (buffer.putIndex() - i) - 1));
                    } catch (IOException e2) {
                        throw new RuntimeException(e2);
                    }
                } catch (NumberFormatException unused) {
                    if (this._connection != null) {
                        this._connection._generator.sendError(400, "Bad Host header", null, true);
                    }
                }
                return this._serverName;
            } else if (peek == ']') {
                break;
            } else {
                putIndex = i;
            }
        }
    }

    @Override // javax.servlet.ServletRequest
    public int getServerPort() {
        int localPort;
        HttpURI httpURI;
        if (this._port <= 0) {
            if (this._serverName == null) {
                getServerName();
            }
            if (this._port <= 0) {
                if (this._serverName == null || (httpURI = this._uri) == null) {
                    EndPoint endPoint = this._endp;
                    localPort = endPoint == null ? 0 : endPoint.getLocalPort();
                } else {
                    localPort = httpURI.getPort();
                }
                this._port = localPort;
            }
        }
        int i = this._port;
        return i <= 0 ? getScheme().equalsIgnoreCase("https") ? 443 : 80 : i;
    }

    @Override // javax.servlet.ServletRequest
    public ServletContext getServletContext() {
        return this._context;
    }

    public String getServletName() {
        UserIdentity.Scope scope = this._scope;
        if (scope != null) {
            return scope.getName();
        }
        return null;
    }

    @Override // me.tvspark.ae0
    public String getServletPath() {
        if (this._servletPath == null) {
            this._servletPath = "";
        }
        return this._servletPath;
    }

    public ServletResponse getServletResponse() {
        return this._connection.getResponse();
    }

    @Override // me.tvspark.ae0
    public ee0 getSession() {
        return getSession(true);
    }

    @Override // me.tvspark.ae0
    public ee0 getSession(boolean z) {
        ee0 ee0Var = this._session;
        if (ee0Var != null) {
            SessionManager sessionManager = this._sessionManager;
            if (sessionManager == null || sessionManager.isValid(ee0Var)) {
                return this._session;
            }
            this._session = null;
        }
        if (!z) {
            return null;
        }
        SessionManager sessionManager2 = this._sessionManager;
        if (sessionManager2 == null) {
            throw new IllegalStateException("No SessionManager");
        }
        ee0 newHttpSession = sessionManager2.newHttpSession(this);
        this._session = newHttpSession;
        HttpCookie sessionCookie = this._sessionManager.getSessionCookie(newHttpSession, getContextPath(), isSecure());
        if (sessionCookie != null) {
            this._connection.getResponse().addCookie(sessionCookie);
        }
        return this._session;
    }

    public SessionManager getSessionManager() {
        return this._sessionManager;
    }

    public long getTimeStamp() {
        return this._timeStamp;
    }

    public Buffer getTimeStampBuffer() {
        if (this._timeStampBuffer == null) {
            long j = this._timeStamp;
            if (j > 0) {
                this._timeStampBuffer = HttpFields.__dateCache.formatBuffer(j);
            }
        }
        return this._timeStampBuffer;
    }

    public HttpURI getUri() {
        return this._uri;
    }

    public UserIdentity getUserIdentity() {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) authentication).authenticate(this));
        }
        Authentication authentication2 = this._authentication;
        if (authentication2 instanceof Authentication.User) {
            return ((Authentication.User) authentication2).getUserIdentity();
        }
        return null;
    }

    public UserIdentity.Scope getUserIdentityScope() {
        return this._scope;
    }

    @Override // me.tvspark.ae0
    public Principal getUserPrincipal() {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) authentication).authenticate(this));
        }
        Authentication authentication2 = this._authentication;
        if (authentication2 instanceof Authentication.User) {
            return ((Authentication.User) authentication2).getUserIdentity().getUserPrincipal();
        }
        return null;
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncStarted() {
        return this._async.isAsyncStarted();
    }

    @Override // javax.servlet.ServletRequest
    public boolean isAsyncSupported() {
        return this._asyncSupported;
    }

    public boolean isHandled() {
        return this._handled;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromCookie() {
        return this._requestedSessionId != null && this._requestedSessionIdFromCookie;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromURL() {
        return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdFromUrl() {
        return this._requestedSessionId != null && !this._requestedSessionIdFromCookie;
    }

    @Override // me.tvspark.ae0
    public boolean isRequestedSessionIdValid() {
        ee0 session;
        return (this._requestedSessionId == null || (session = getSession(false)) == null || !this._sessionManager.getSessionIdManager().getClusterId(this._requestedSessionId).equals(this._sessionManager.getClusterId(session))) ? false : true;
    }

    @Override // javax.servlet.ServletRequest
    public boolean isSecure() {
        return this._connection.isConfidential(this);
    }

    @Override // me.tvspark.ae0
    public boolean isUserInRole(String str) {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.Deferred) {
            setAuthentication(((Authentication.Deferred) authentication).authenticate(this));
        }
        Authentication authentication2 = this._authentication;
        if (authentication2 instanceof Authentication.User) {
            return ((Authentication.User) authentication2).isUserInRole(this._scope, str);
        }
        return false;
    }

    @Override // me.tvspark.ae0
    public void login(String str, String str2) throws ServletException {
        Authentication authentication = this._authentication;
        if (!(authentication instanceof Authentication.Deferred)) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Authenticated as ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._authentication);
            throw new ServletException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        Authentication login = ((Authentication.Deferred) authentication).login(str, str2, this);
        this._authentication = login;
        if (login == null) {
            throw new ServletException();
        }
    }

    @Override // me.tvspark.ae0
    public void logout() throws ServletException {
        Authentication authentication = this._authentication;
        if (authentication instanceof Authentication.User) {
            ((Authentication.User) authentication).logout();
        }
        this._authentication = Authentication.UNAUTHENTICATED;
    }

    public void mergeQueryString(String str) {
        boolean z;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        MultiMap<String> multiMap = new MultiMap<>();
        UrlEncoded.decodeTo(str, multiMap, "UTF-8");
        if (!this._paramsExtracted) {
            extractParameters();
        }
        MultiMap<String> multiMap2 = this._parameters;
        if (multiMap2 == null || multiMap2.size() <= 0) {
            z = false;
        } else {
            z = false;
            for (Map.Entry<String, Object> entry : this._parameters.entrySet()) {
                String key = entry.getKey();
                if (multiMap.containsKey(key)) {
                    z = true;
                }
                Object value = entry.getValue();
                for (int i = 0; i < LazyList.size(value); i++) {
                    multiMap.add(key, LazyList.get(value, i));
                }
            }
        }
        String str2 = this._queryString;
        if (str2 != null && str2.length() > 0) {
            if (z) {
                StringBuilder sb = new StringBuilder();
                MultiMap multiMap3 = new MultiMap();
                UrlEncoded.decodeTo(this._queryString, multiMap3, getQueryEncoding());
                MultiMap multiMap4 = new MultiMap();
                UrlEncoded.decodeTo(str, multiMap4, "UTF-8");
                for (Map.Entry entry2 : multiMap3.entrySet()) {
                    String str3 = (String) entry2.getKey();
                    if (!multiMap4.containsKey(str3)) {
                        Object value2 = entry2.getValue();
                        for (int i2 = 0; i2 < LazyList.size(value2); i2++) {
                            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, "&", str3, "=");
                            sb.append(LazyList.get(value2, i2));
                        }
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new StringBuilder();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((Object) sb);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "&");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this._queryString);
            }
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        setParameters(multiMap);
        setQueryString(str);
    }

    public ee0 recoverNewSession(Object obj) {
        Map<Object, ee0> map = this._savedNewSessions;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public void recycle() {
        if (this._inputState == 2) {
            try {
                BufferedReader bufferedReader = this._reader;
                while (bufferedReader.read() != -1) {
                    bufferedReader = this._reader;
                }
            } catch (Exception e) {
                LOG.ignore(e);
                this._reader = null;
            }
        }
        setAuthentication(Authentication.NOT_CHECKED);
        this._async.recycle();
        this._asyncSupported = true;
        this._handled = false;
        if (this._context == null) {
            if (this._attributes != null) {
                this._attributes.clearAttributes();
            }
            this._characterEncoding = null;
            this._contextPath = null;
            CookieCutter cookieCutter = this._cookies;
            if (cookieCutter != null) {
                cookieCutter.reset();
            }
            this._cookiesExtracted = false;
            this._context = null;
            this._serverName = null;
            this._method = null;
            this._pathInfo = null;
            this._port = 0;
            this._protocol = HttpVersions.HTTP_1_1;
            this._queryEncoding = null;
            this._queryString = null;
            this._requestedSessionId = null;
            this._requestedSessionIdFromCookie = false;
            this._session = null;
            this._sessionManager = null;
            this._requestURI = null;
            this._scope = null;
            this._scheme = "http";
            this._servletPath = null;
            this._timeStamp = 0L;
            this._timeStampBuffer = null;
            this._uri = null;
            MultiMap<String> multiMap = this._baseParameters;
            if (multiMap != null) {
                multiMap.clear();
            }
            this._parameters = null;
            this._paramsExtracted = false;
            this._inputState = 0;
            Map<Object, ee0> map = this._savedNewSessions;
            if (map != null) {
                map.clear();
            }
            this._savedNewSessions = null;
            this._multiPartInputStream = null;
            return;
        }
        throw new IllegalStateException("Request in context!");
    }

    @Override // javax.servlet.ServletRequest
    public void removeAttribute(String str) {
        Object attribute = this._attributes == null ? null : this._attributes.getAttribute(str);
        if (this._attributes != null) {
            this._attributes.removeAttribute(str);
        }
        if (attribute == null || this._requestAttributeListeners == null) {
            return;
        }
        ServletRequestAttributeEvent servletRequestAttributeEvent = new ServletRequestAttributeEvent(this._context, this, str, attribute);
        int size = LazyList.size(this._requestAttributeListeners);
        for (int i = 0; i < size; i++) {
            ServletRequestAttributeListener servletRequestAttributeListener = (ServletRequestAttributeListener) LazyList.get(this._requestAttributeListeners, i);
            if (servletRequestAttributeListener instanceof ServletRequestAttributeListener) {
                servletRequestAttributeListener.attributeRemoved(servletRequestAttributeEvent);
            }
        }
    }

    public void removeEventListener(EventListener eventListener) {
        this._requestAttributeListeners = LazyList.remove(this._requestAttributeListeners, eventListener);
    }

    public void saveNewSession(Object obj, ee0 ee0Var) {
        if (this._savedNewSessions == null) {
            this._savedNewSessions = new HashMap();
        }
        this._savedNewSessions.put(obj, ee0Var);
    }

    public void setAsyncSupported(boolean z) {
        this._asyncSupported = z;
    }

    @Override // javax.servlet.ServletRequest
    public void setAttribute(String str, Object obj) {
        String str2 = null;
        Object attribute = this._attributes == null ? null : this._attributes.getAttribute(str);
        if (str.startsWith("org.eclipse.jetty.")) {
            if ("org.eclipse.jetty.server.Request.queryEncoding".equals(str)) {
                if (obj != null) {
                    str2 = obj.toString();
                }
                setQueryEncoding(str2);
            } else if ("org.eclipse.jetty.server.sendContent".equals(str)) {
                try {
                    ((AbstractHttpConnection.Output) getServletResponse().getOutputStream()).sendContent(obj);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if ("org.eclipse.jetty.server.ResponseBuffer".equals(str)) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) obj;
                    synchronized (byteBuffer) {
                        ((AbstractHttpConnection.Output) getServletResponse().getOutputStream()).sendResponse(byteBuffer.isDirect() ? new DirectNIOBuffer(byteBuffer, true) : new IndirectNIOBuffer(byteBuffer, true));
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } else if ("org.eclipse.jetty.io.EndPoint.maxIdleTime".equalsIgnoreCase(str)) {
                try {
                    getConnection().getEndPoint().setMaxIdleTime(Integer.valueOf(obj.toString()).intValue());
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        if (this._attributes == null) {
            this._attributes = new AttributesMap();
        }
        this._attributes.setAttribute(str, obj);
        if (this._requestAttributeListeners != null) {
            ServletRequestAttributeEvent servletRequestAttributeEvent = new ServletRequestAttributeEvent(this._context, this, str, attribute == null ? obj : attribute);
            int size = LazyList.size(this._requestAttributeListeners);
            for (int i = 0; i < size; i++) {
                ServletRequestAttributeListener servletRequestAttributeListener = (ServletRequestAttributeListener) LazyList.get(this._requestAttributeListeners, i);
                if (servletRequestAttributeListener instanceof ServletRequestAttributeListener) {
                    if (attribute == null) {
                        servletRequestAttributeListener.attributeAdded(servletRequestAttributeEvent);
                    } else if (obj == null) {
                        servletRequestAttributeListener.attributeRemoved(servletRequestAttributeEvent);
                    } else {
                        servletRequestAttributeListener.attributeReplaced(servletRequestAttributeEvent);
                    }
                }
            }
        }
    }

    public void setAttributes(Attributes attributes) {
        this._attributes = attributes;
    }

    public void setAuthentication(Authentication authentication) {
        this._authentication = authentication;
    }

    @Override // javax.servlet.ServletRequest
    public void setCharacterEncoding(String str) throws UnsupportedEncodingException {
        if (this._inputState != 0) {
            return;
        }
        this._characterEncoding = str;
        if (StringUtil.isUTF8(str)) {
            return;
        }
        "".getBytes(str);
    }

    public void setCharacterEncodingUnchecked(String str) {
        this._characterEncoding = str;
    }

    public final void setConnection(AbstractHttpConnection abstractHttpConnection) {
        this._connection = abstractHttpConnection;
        this._async.setConnection(abstractHttpConnection);
        this._endp = abstractHttpConnection.getEndPoint();
        this._dns = abstractHttpConnection.getResolveNames();
    }

    public void setContentType(String str) {
        this._connection.getRequestFields().put(HttpHeaders.CONTENT_TYPE_BUFFER, str);
    }

    public void setContext(ContextHandler.Context context) {
        this._newContext = this._context != context;
        this._context = context;
    }

    public void setContextPath(String str) {
        this._contextPath = str;
    }

    public void setCookies(Cookie[] cookieArr) {
        if (this._cookies == null) {
            this._cookies = new CookieCutter();
        }
        this._cookies.setCookies(cookieArr);
    }

    public void setDispatchTime(long j) {
        this._dispatchTime = j;
    }

    public void setDispatcherType(DispatcherType dispatcherType) {
        this._dispatcherType = dispatcherType;
    }

    public void setHandled(boolean z) {
        this._handled = z;
    }

    public void setMethod(String str) {
        this._method = str;
    }

    public void setParameters(MultiMap<String> multiMap) {
        if (multiMap == null) {
            multiMap = this._baseParameters;
        }
        this._parameters = multiMap;
        if (!this._paramsExtracted || multiMap != null) {
            return;
        }
        throw new IllegalStateException();
    }

    public void setPathInfo(String str) {
        this._pathInfo = str;
    }

    public void setProtocol(String str) {
        this._protocol = str;
    }

    public void setQueryEncoding(String str) {
        this._queryEncoding = str;
        this._queryString = null;
    }

    public void setQueryString(String str) {
        this._queryString = str;
        this._queryEncoding = null;
    }

    public void setRemoteAddr(String str) {
        this._remoteAddr = str;
    }

    public void setRemoteHost(String str) {
        this._remoteHost = str;
    }

    public void setRequestURI(String str) {
        this._requestURI = str;
    }

    public void setRequestedSessionId(String str) {
        this._requestedSessionId = str;
    }

    public void setRequestedSessionIdFromCookie(boolean z) {
        this._requestedSessionIdFromCookie = z;
    }

    public void setScheme(String str) {
        this._scheme = str;
    }

    public void setServerName(String str) {
        this._serverName = str;
    }

    public void setServerPort(int i) {
        this._port = i;
    }

    public void setServletPath(String str) {
        this._servletPath = str;
    }

    public void setSession(ee0 ee0Var) {
        this._session = ee0Var;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this._sessionManager = sessionManager;
    }

    public void setTimeStamp(long j) {
        this._timeStamp = j;
    }

    public void setUri(HttpURI httpURI) {
        this._uri = httpURI;
    }

    public void setUserIdentityScope(UserIdentity.Scope scope) {
        this._scope = scope;
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync() throws IllegalStateException {
        if (this._asyncSupported) {
            this._async.startAsync();
            return this._async;
        }
        throw new IllegalStateException("!asyncSupported");
    }

    @Override // javax.servlet.ServletRequest
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        if (this._asyncSupported) {
            this._async.startAsync(this._context, servletRequest, servletResponse);
            return this._async;
        }
        throw new IllegalStateException("!asyncSupported");
    }

    public boolean takeNewContext() {
        boolean z = this._newContext;
        this._newContext = false;
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._handled ? "[" : "(");
        sb.append(getMethod());
        sb.append(StringUtils.SPACE);
        sb.append(this._uri);
        sb.append(this._handled ? "]@" : ")@");
        sb.append(hashCode());
        sb.append(StringUtils.SPACE);
        sb.append(super.toString());
        return sb.toString();
    }
}
