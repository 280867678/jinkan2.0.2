package okhttp3.internal.connection;

import java.io.IOException;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;

@ef0
/* loaded from: classes4.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.request();
        Transmitter transmitter = realInterceptorChain.transmitter();
        return realInterceptorChain.proceed(request, transmitter, transmitter.newExchange$okhttp(chain, !ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) request.method(), (Object) "GET")));
    }
}
