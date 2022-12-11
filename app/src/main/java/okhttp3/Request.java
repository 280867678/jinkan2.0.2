package okhttp3;

import androidx.core.net.MailTo;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.just.agentweb.JsCallJava;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.nk0;
import me.tvspark.outline;
import me.tvspark.r40;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.eclipse.jetty.util.URIUtil;

@ef0
/* loaded from: classes4.dex */
public final class Request {
    public final RequestBody body;
    public final Headers headers;
    public CacheControl lazyCacheControl;
    public final String method;
    public final Map<Class<?>, Object> tags;
    public final HttpUrl url;

    @ef0
    /* loaded from: classes4.dex */
    public static class Builder {
        public RequestBody body;
        public Headers.Builder headers;
        public String method;
        public Map<Class<?>, Object> tags;
        public HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request request) {
            LinkedHashMap linkedHashMap;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                linkedHashMap = new LinkedHashMap();
            } else {
                Map<Class<?>, Object> tags$okhttp = request.getTags$okhttp();
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(tags$okhttp, "$this$toMutableMap");
                linkedHashMap = new LinkedHashMap(tags$okhttp);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers().newBuilder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public Builder addHeader(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cacheControl, "cacheControl");
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str2, "value");
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
            if (str.length() > 0) {
                if (requestBody == null) {
                    if (!(!HttpMethod.requiresRequestBody(str))) {
                        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("method ", str, " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("method ", str, " must not have a request body.").toString());
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public Builder patch(RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(requestBody, MailTo.BODY);
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "type");
            if (t == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T cast = cls.cast(t);
                if (cast == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                map.put(cls, cast);
            }
            return this;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(String str) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i;
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "url");
            if (!nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "ws:", true)) {
                if (nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "wss:", true)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URIUtil.HTTPS_COLON);
                    i = 4;
                }
                return url(HttpUrl.Companion.get(str));
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(URIUtil.HTTP_COLON);
            i = 3;
            String substring = str.substring(i);
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) substring, "(this as java.lang.String).substring(startIndex)");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(substring);
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            return url(HttpUrl.Companion.get(str));
        }

        public Builder url(URL url) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url2 = url.toString();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) url2, "url.toString()");
            return url(companion.get(url2));
        }

        public Builder url(HttpUrl httpUrl) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            this.url = httpUrl;
            return this;
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(headers, IOptionConstant.headers);
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(map, "tags");
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m5089deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m5090deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m5091deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m5092deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m5093deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl == null) {
            CacheControl parse = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = parse;
            return parse;
        }
        return cacheControl;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        return this.headers.get(str);
    }

    public final List<String> headers(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "name");
        return this.headers.values(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> cls) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, "type");
        return cls.cast(this.tags.get(cls));
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Request{method=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.method);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", url=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.url);
        if (this.headers.size() != 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i > 0) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(component1);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(':');
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(component2);
                i = i2;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(']');
        }
        if (!this.tags.isEmpty()) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", tags=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.tags);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append('}');
        String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    public final HttpUrl url() {
        return this.url;
    }
}
