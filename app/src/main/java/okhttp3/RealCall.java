package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import me.tvspark.ef0;
import me.tvspark.gi0;
import me.tvspark.ii0;
import me.tvspark.nx0;
import me.tvspark.outline;
import me.tvspark.pf0;
import me.tvspark.r40;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;

@ef0
/* loaded from: classes4.dex */
public final class RealCall implements Call {
    public static final Companion Companion = new Companion(null);
    public final OkHttpClient client;
    public boolean executed;
    public final boolean forWebSocket;
    public final Request originalRequest;
    public Transmitter transmitter;

    @ef0
    /* loaded from: classes4.dex */
    public final class AsyncCall implements Runnable {
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final Callback responseCallback;
        public final /* synthetic */ RealCall this$0;

        public AsyncCall(RealCall realCall, Callback callback) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callback, "responseCallback");
            this.this$0 = realCall;
            this.responseCallback = callback;
        }

        public final AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        public final void executeOn(ExecutorService executorService) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(executorService, "executorService");
            boolean z = !Thread.holdsLock(this.this$0.getClient().dispatcher());
            if (!pf0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
                try {
                    try {
                        executorService.execute(this);
                        return;
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        RealCall.access$getTransmitter$p(this.this$0).noMoreExchanges(interruptedIOException);
                        this.responseCallback.onFailure(this.this$0, interruptedIOException);
                        this.this$0.getClient().dispatcher().finished$okhttp(this);
                        return;
                    }
                } catch (Throwable th) {
                    this.this$0.getClient().dispatcher().finished$okhttp(this);
                    throw th;
                }
            }
            throw new AssertionError("Assertion failed");
        }

        public final RealCall get() {
            return this.this$0;
        }

        public final String host() {
            return this.this$0.getOriginalRequest().url().host();
        }

        public final Request request() {
            return this.this$0.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            OkHttpClient client;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("OkHttp ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.this$0.redactedUrl());
            String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            Thread currentThread = Thread.currentThread();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(sb);
            try {
                RealCall.access$getTransmitter$p(this.this$0).timeoutEnter();
                try {
                    z = true;
                    try {
                        this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain());
                        client = this.this$0.getClient();
                    } catch (IOException e) {
                        e = e;
                        if (z) {
                            Platform platform = Platform.Companion.get();
                            platform.log(4, "Callback failure for " + this.this$0.toLoggableString(), e);
                        } else {
                            this.responseCallback.onFailure(this.this$0, e);
                        }
                        client = this.this$0.getClient();
                        client.dispatcher().finished$okhttp(this);
                    }
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                client.dispatcher().finished$okhttp(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    @ef0
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(gi0 gi0Var) {
            this();
        }

        public final RealCall newRealCall(OkHttpClient okHttpClient, Request request, boolean z) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(okHttpClient, "client");
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(request, "originalRequest");
            RealCall realCall = new RealCall(okHttpClient, request, z, null);
            realCall.transmitter = new Transmitter(okHttpClient, realCall);
            return realCall;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
    }

    public /* synthetic */ RealCall(OkHttpClient okHttpClient, Request request, boolean z, gi0 gi0Var) {
        this(okHttpClient, request, z);
    }

    public static final /* synthetic */ Transmitter access$getTransmitter$p(RealCall realCall) {
        Transmitter transmitter = realCall.transmitter;
        if (transmitter != null) {
            return transmitter;
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
        throw null;
    }

    @Override // okhttp3.Call
    public void cancel() {
        Transmitter transmitter = this.transmitter;
        if (transmitter != null) {
            transmitter.cancel();
        } else {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
            throw null;
        }
    }

    @Override // okhttp3.Call
    /* renamed from: clone */
    public RealCall mo5088clone() {
        return Companion.newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callback, "responseCallback");
        synchronized (this) {
            if (!(!this.executed)) {
                throw new IllegalStateException("Already Executed".toString());
            }
            this.executed = true;
        }
        Transmitter transmitter = this.transmitter;
        if (transmitter == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
            throw null;
        }
        transmitter.callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
    }

    @Override // okhttp3.Call
    public Response execute() {
        synchronized (this) {
            if (!(!this.executed)) {
                throw new IllegalStateException("Already Executed".toString());
            }
            this.executed = true;
        }
        Transmitter transmitter = this.transmitter;
        if (transmitter == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
            throw null;
        }
        transmitter.timeoutEnter();
        Transmitter transmitter2 = this.transmitter;
        if (transmitter2 == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
            throw null;
        }
        transmitter2.callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final boolean getExecuted() {
        return this.executed;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response getResponseWithInterceptorChain() throws IOException {
        ArrayList arrayList = new ArrayList();
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, (Iterable) this.client.interceptors());
        arrayList.add(new RetryAndFollowUpInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar()));
        arrayList.add(new CacheInterceptor(this.client.cache()));
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Collection) arrayList, (Iterable) this.client.networkInterceptors());
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Transmitter transmitter = this.transmitter;
        if (transmitter == null) {
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
            throw null;
        }
        boolean z = false;
        try {
            Response proceed = new RealInterceptorChain(arrayList, transmitter, null, 0, this.originalRequest, this, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            Transmitter transmitter2 = this.transmitter;
            if (transmitter2 == null) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
                throw null;
            } else if (transmitter2.isCanceled()) {
                Util.closeQuietly(proceed);
                throw new IOException("Canceled");
            } else {
                Transmitter transmitter3 = this.transmitter;
                if (transmitter3 != null) {
                    transmitter3.noMoreExchanges(null);
                    return proceed;
                }
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
                throw null;
            }
        } catch (IOException e) {
            try {
                Transmitter transmitter4 = this.transmitter;
                if (transmitter4 == null) {
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
                    throw null;
                }
                IOException noMoreExchanges = transmitter4.noMoreExchanges(e);
                if (noMoreExchanges != null) {
                    throw noMoreExchanges;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    Transmitter transmitter5 = this.transmitter;
                    if (transmitter5 == null) {
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
                        throw null;
                    }
                    transmitter5.noMoreExchanges(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
            }
            throw th;
        }
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        Transmitter transmitter = this.transmitter;
        if (transmitter != null) {
            return transmitter.isCanceled();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
        throw null;
    }

    @Override // okhttp3.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public final String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    public final void setExecuted(boolean z) {
        this.executed = z;
    }

    @Override // okhttp3.Call
    public nx0 timeout() {
        Transmitter transmitter = this.transmitter;
        if (transmitter != null) {
            return transmitter.timeout();
        }
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("transmitter");
        throw null;
    }

    public final String toLoggableString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "canceled " : "");
        sb.append(this.forWebSocket ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(redactedUrl());
        return sb.toString();
    }
}
