package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes4.dex */
public class HttpService {
    public volatile ConnectionReuseStrategy connStrategy;
    public volatile HttpExpectationVerifier expectationVerifier;
    public volatile HttpRequestHandlerMapper handlerMapper;
    public volatile HttpParams params;
    public volatile HttpProcessor processor;
    public volatile HttpResponseFactory responseFactory;

    @Deprecated
    /* loaded from: classes4.dex */
    public static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        public final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        @Override // org.apache.http.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        return ((httpRequest != null && "HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }

    public void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler lookup = this.handlerMapper != null ? this.handlerMapper.lookup(httpRequest) : null;
        if (lookup != null) {
            lookup.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(501);
        }
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleException(HttpException httpException, HttpResponse httpResponse) {
        httpResponse.setStatusCode(httpException instanceof MethodNotSupportedException ? 501 : httpException instanceof UnsupportedHttpVersionException ? 505 : httpException instanceof ProtocolException ? 400 : 500);
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpRequest httpRequest;
        HttpException e;
        HttpEntityEnclosingRequest httpEntityEnclosingRequest;
        httpContext.setAttribute("http.connection", httpServerConnection);
        HttpResponse httpResponse = null;
        try {
            httpRequest = httpServerConnection.receiveRequestHeader();
        } catch (HttpException e2) {
            httpRequest = null;
            e = e2;
        }
        try {
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) httpRequest).expectContinue()) {
                    HttpResponse newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(httpRequest, newHttpResponse, httpContext);
                        } catch (HttpException e3) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            handleException(e3, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
                    } else {
                        httpResponse = newHttpResponse;
                    }
                } else {
                    httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
                }
                httpServerConnection.receiveRequestEntity(httpEntityEnclosingRequest);
            }
            httpContext.setAttribute("http.request", httpRequest);
            if (httpResponse == null) {
                httpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                this.processor.process(httpRequest, httpContext);
                doService(httpRequest, httpResponse, httpContext);
            }
            if (httpRequest instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) httpRequest).getEntity());
            }
        } catch (HttpException e4) {
            e = e4;
            HttpResponse newHttpResponse3 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            handleException(e, newHttpResponse3);
            httpResponse = newHttpResponse3;
            httpContext.setAttribute("http.response", httpResponse);
            this.processor.process(httpResponse, httpContext);
            httpServerConnection.sendResponseHeader(httpResponse);
            if (canResponseHaveBody(httpRequest, httpResponse)) {
            }
            httpServerConnection.flush();
            if (this.connStrategy.keepAlive(httpResponse, httpContext)) {
            }
        }
        httpContext.setAttribute("http.response", httpResponse);
        this.processor.process(httpResponse, httpContext);
        httpServerConnection.sendResponseHeader(httpResponse);
        if (canResponseHaveBody(httpRequest, httpResponse)) {
            httpServerConnection.sendResponseEntity(httpResponse);
        }
        httpServerConnection.flush();
        if (this.connStrategy.keepAlive(httpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }
}
