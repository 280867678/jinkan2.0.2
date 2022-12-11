package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.ii0;
import me.tvspark.outline;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.Transmitter;

@ef0
/* loaded from: classes4.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    public final Call call;
    public int calls;
    public final int connectTimeout;
    public final Exchange exchange;
    public final int index;
    public final List<Interceptor> interceptors;
    public final int readTimeout;
    public final Request request;
    public final Transmitter transmitter;
    public final int writeTimeout;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(List<? extends Interceptor> list, Transmitter transmitter, Exchange exchange, int i, Request request, Call call, int i2, int i3, int i4) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list, "interceptors");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "transmitter");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, NotificationCompat.CATEGORY_CALL);
        this.interceptors = list;
        this.transmitter = transmitter;
        this.exchange = exchange;
        this.index = i;
        this.request = request;
        this.call = call;
        this.connectTimeout = i2;
        this.readTimeout = i3;
        this.writeTimeout = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.connection();
        }
        return null;
    }

    public final Exchange exchange() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        throw null;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        return proceed(request, this.transmitter, this.exchange);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response proceed(Request request, Transmitter transmitter, Exchange exchange) throws IOException {
        boolean z;
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "request");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(transmitter, "transmitter");
        if (this.index < this.interceptors.size()) {
            boolean z2 = true;
            this.calls++;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                RealConnection connection = exchange2.connection();
                if (connection == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    throw null;
                } else if (!connection.supportsUrl(request.url())) {
                    z = false;
                    if (z) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("network interceptor ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.interceptors.get(this.index - 1));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" must retain the same host and port");
                        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString().toString());
                    }
                    if (!(this.exchange == null || this.calls <= 1)) {
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("network interceptor ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.interceptors.get(this.index - 1));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" must call proceed() exactly once");
                        throw new IllegalStateException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString().toString());
                    }
                    RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter, exchange, this.index + 1, request, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
                    Interceptor interceptor = this.interceptors.get(this.index);
                    Response intercept = interceptor.intercept(realInterceptorChain);
                    if (intercept == null) {
                        throw new NullPointerException("interceptor " + interceptor + " returned null");
                    }
                    if (!(exchange == null || this.index + 1 >= this.interceptors.size() || realInterceptorChain.calls == 1)) {
                        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
                    }
                    if (intercept.body() == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return intercept;
                    }
                    throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
                }
            }
            z = true;
            if (z) {
            }
        } else {
            throw new AssertionError();
        }
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    public final Transmitter transmitter() {
        return this.transmitter;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", i, timeUnit), this.readTimeout, this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", i, timeUnit), this.writeTimeout);
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }
}
