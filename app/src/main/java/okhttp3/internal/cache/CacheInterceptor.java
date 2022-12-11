package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.hx0;
import me.tvspark.ii0;
import me.tvspark.kx0;
import me.tvspark.mx0;
import me.tvspark.nk0;
import me.tvspark.nx0;
import me.tvspark.r40;
import me.tvspark.uw0;
import me.tvspark.vw0;
import me.tvspark.ww0;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

@ef0
/* loaded from: classes4.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    public final Cache cache;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String name = headers.name(i);
                String value = headers.value(i);
                if ((!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Warning", name, true) || !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(value, "1", false, 2)) && (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String name2 = headers2.name(i2);
                if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                    builder.addLenient$okhttp(name2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Length", str, true) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Encoding", str, true) || nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Content-Type", str, true);
        }

        private final boolean isEndToEnd(String str) {
            return !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Connection", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Keep-Alive", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Proxy-Authenticate", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Proxy-Authorization", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TE", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Trailers", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Transfer-Encoding", str, true) && !nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Upgrade", str, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Response stripBody(Response response) {
            return (response != null ? response.body() : null) != null ? response.newBuilder().body(null).build() : response;
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        kx0 body = cacheRequest.body();
        ResponseBody body2 = response.body();
        if (body2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        final ww0 source = body2.source();
        final vw0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(body);
        mx0 mx0Var = new mx0() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            public boolean cacheRequestClosed;

            @Override // me.tvspark.mx0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                ww0.this.close();
            }

            public final boolean getCacheRequestClosed() {
                return this.cacheRequestClosed;
            }

            @Override // me.tvspark.mx0
            public long read(uw0 uw0Var, long j) throws IOException {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uw0Var, "sink");
                try {
                    long read = ww0.this.read(uw0Var, j);
                    if (read != -1) {
                        uw0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getBuffer(), uw0Var.Wwwwwwwwwwwwwwwwwwwwwww - read, read);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        return read;
                    }
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public final void setCacheRequestClosed(boolean z) {
                this.cacheRequestClosed = z;
            }

            @Override // me.tvspark.mx0
            public nx0 timeout() {
                return ww0.this.timeout();
            }
        };
        String header$default = Response.header$default(response, "Content-Type", null, 2, null);
        long contentLength = response.body().contentLength();
        Response.Builder newBuilder = response.newBuilder();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mx0Var, "$receiver");
        return newBuilder.body(new RealResponseBody(header$default, contentLength, new hx0(mx0Var))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody body;
        ResponseBody body2;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        Cache cache = this.cache;
        Response response = cache != null ? cache.get$okhttp(chain.request()) : null;
        CacheStrategy compute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = compute.getNetworkRequest();
        Response cacheResponse = compute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(compute);
        }
        if (response != null && cacheResponse == null && (body2 = response.body()) != null) {
            Util.closeQuietly(body2);
        }
        if (networkRequest == null && cacheResponse == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (networkRequest == null) {
            if (cacheResponse != null) {
                return cacheResponse.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).build();
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }
        try {
            Response proceed = chain.proceed(networkRequest);
            if (proceed == null && response != null && body != null) {
            }
            if (cacheResponse != null) {
                if (proceed != null && proceed.code() == 304) {
                    Response build = cacheResponse.newBuilder().headers(Companion.combine(cacheResponse.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(Companion.stripBody(cacheResponse)).networkResponse(Companion.stripBody(proceed)).build();
                    ResponseBody body3 = proceed.body();
                    if (body3 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    body3.close();
                    Cache cache3 = this.cache;
                    if (cache3 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        throw null;
                    }
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, build);
                    return build;
                }
                ResponseBody body4 = cacheResponse.body();
                if (body4 != null) {
                    Util.closeQuietly(body4);
                }
            }
            if (proceed == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            Response build2 = proceed.newBuilder().cacheResponse(Companion.stripBody(cacheResponse)).networkResponse(Companion.stripBody(proceed)).build();
            if (this.cache != null) {
                if (HttpHeaders.promisesBody(build2) && CacheStrategy.Companion.isCacheable(build2, networkRequest)) {
                    return cacheWritingResponse(this.cache.put$okhttp(build2), build2);
                }
                if (HttpMethod.INSTANCE.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null && (body = response.body()) != null) {
                Util.closeQuietly(body);
            }
        }
    }
}
