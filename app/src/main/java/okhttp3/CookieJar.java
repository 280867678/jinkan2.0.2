package okhttp3;

import java.util.List;
import kotlin.collections.EmptyList;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public interface CookieJar {
    public static final Companion Companion = new Companion(null);
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: okhttp3.CookieJar$Companion$NO_COOKIES$1
        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            return EmptyList.INSTANCE;
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(httpUrl, "url");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "cookies");
        }
    };

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = null;

        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
