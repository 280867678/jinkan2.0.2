package okhttp3;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;

@ef0
/* loaded from: classes4.dex */
public interface Authenticator {
    public static final Companion Companion = new Companion(null);
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator$Companion$NONE$1
        @Override // okhttp3.Authenticator
        public Request authenticate(Route route, Response response) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(response, "response");
            return null;
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

    Request authenticate(Route route, Response response) throws IOException;
}
