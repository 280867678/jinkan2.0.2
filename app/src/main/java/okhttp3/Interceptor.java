package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.ih0;
import me.tvspark.ii0;
import okhttp3.Interceptor;

@ef0
/* loaded from: classes4.dex */
public interface Interceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    @ef0
    /* loaded from: classes4.dex */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public final Interceptor invoke(final ih0<? super Chain, Response> ih0Var) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ih0Var, "block");
            return new Interceptor() { // from class: okhttp3.Interceptor$Companion$invoke$1
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
                    return (Response) ih0.this.mo4916invoke(chain);
                }
            };
        }
    }

    Response intercept(Chain chain) throws IOException;
}
