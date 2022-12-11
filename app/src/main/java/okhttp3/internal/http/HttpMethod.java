package okhttp3.internal.http;

import com.just.agentweb.JsCallJava;
import me.tvspark.ef0;
import me.tvspark.ii0;
import org.eclipse.jetty.http.HttpMethods;

@ef0
/* loaded from: classes4.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    public static final boolean permitsRequestBody(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        return !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "GET") && !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "HEAD");
    }

    public static final boolean requiresRequestBody(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "POST") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PUT") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PATCH") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PROPPATCH") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "REPORT");
    }

    public final boolean invalidatesCache(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "POST") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PATCH") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PUT") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "DELETE") || ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) HttpMethods.MOVE);
    }

    public final boolean redirectsToGet(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        return !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, JsCallJava.KEY_METHOD);
        return ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) str, (Object) "PROPFIND");
    }
}
