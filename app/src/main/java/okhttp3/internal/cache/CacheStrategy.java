package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@ef0
/* loaded from: classes4.dex */
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    public final Response cacheResponse;
    public final Request networkRequest;

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final boolean isCacheable(Response response, Request request) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            int code = response.code();
            if (code != 200 && code != 410 && code != 414 && code != 501 && code != 203 && code != 204) {
                if (code != 307) {
                    if (code != 308 && code != 404 && code != 405) {
                        switch (code) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                    return false;
                }
            }
            return !response.cacheControl().noStore() && !request.cacheControl().noStore();
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Factory {
        public int ageSeconds;
        public final Response cacheResponse;
        public String etag;
        public Date expires;
        public Date lastModified;
        public String lastModifiedString;
        public final long nowMillis;
        public long receivedResponseMillis;
        public final Request request;
        public long sentRequestMillis;
        public Date servedDate;
        public String servedDateString;

        public Factory(long j, Request request, Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = response;
            this.ageSeconds = -1;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
                Headers headers = this.cacheResponse.headers();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String name = headers.name(i);
                    String value = headers.value(i);
                    if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Date", true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Expires", true)) {
                        this.expires = DatesKt.toHttpDateOrNull(value);
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Last-Modified", true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "ETag", true)) {
                        this.etag = value;
                    } else if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(name, "Age", true)) {
                        this.ageSeconds = Util.toNonNegativeInt(value, -1);
                    }
                }
            }
        }

        private final long cacheResponseAge() {
            Date date = this.servedDate;
            long j = 0;
            if (date != null) {
                j = Math.max(0L, this.receivedResponseMillis - date.getTime());
            }
            int i = this.ageSeconds;
            if (i != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis(i));
            }
            long j2 = this.receivedResponseMillis;
            return j + (j2 - this.sentRequestMillis) + (this.nowMillis - j2);
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if ((!this.request.isHttps() || this.cacheResponse.handshake() != null) && CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                CacheControl cacheControl = this.request.cacheControl();
                if (cacheControl.noCache() || hasConditions(this.request)) {
                    return new CacheStrategy(this.request, null);
                }
                CacheControl cacheControl2 = this.cacheResponse.cacheControl();
                long cacheResponseAge = cacheResponseAge();
                long computeFreshnessLifetime = computeFreshnessLifetime();
                if (cacheControl.maxAgeSeconds() != -1) {
                    computeFreshnessLifetime = Math.min(computeFreshnessLifetime, TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()));
                }
                long j = 0;
                long millis = cacheControl.minFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(cacheControl.minFreshSeconds()) : 0L;
                if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                    j = TimeUnit.SECONDS.toMillis(cacheControl.maxStaleSeconds());
                }
                if (!cacheControl2.noCache()) {
                    long j2 = millis + cacheResponseAge;
                    if (j2 < j + computeFreshnessLifetime) {
                        Response.Builder newBuilder = this.cacheResponse.newBuilder();
                        if (j2 >= computeFreshnessLifetime) {
                            newBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (cacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                            newBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new CacheStrategy(null, newBuilder.build());
                    }
                }
                String str = this.etag;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.lastModified != null) {
                    str = this.lastModifiedString;
                } else if (this.servedDate == null) {
                    return new CacheStrategy(this.request, null);
                } else {
                    str = this.servedDateString;
                }
                Headers.Builder newBuilder2 = this.request.headers().newBuilder();
                if (str != null) {
                    newBuilder2.addLenient$okhttp(str2, str);
                    return new CacheStrategy(this.request.newBuilder().headers(newBuilder2.build()).build(), this.cacheResponse);
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            if (response == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                throw null;
            }
            CacheControl cacheControl = response.cacheControl();
            if (cacheControl.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time <= 0) {
                    return 0L;
                }
                return time;
            } else if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            } else {
                Date date3 = this.servedDate;
                long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
                Date date4 = this.lastModified;
                if (date4 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                long time3 = time2 - date4.getTime();
                if (time3 <= 0) {
                    return 0L;
                }
                return time3 / 10;
            }
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            if (response != null) {
                return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
            }
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            throw null;
        }

        public final CacheStrategy compute() {
            CacheStrategy computeCandidate = computeCandidate();
            return (computeCandidate.getNetworkRequest() == null || !this.request.cacheControl().onlyIfCached()) ? computeCandidate : new CacheStrategy(null, null);
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }
}
