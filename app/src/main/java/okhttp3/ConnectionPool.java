package okhttp3;

import java.util.concurrent.TimeUnit;
import me.tvspark.ef0;
import me.tvspark.ii0;
import okhttp3.internal.connection.RealConnectionPool;

@ef0
/* loaded from: classes4.dex */
public final class ConnectionPool {
    public final RealConnectionPool delegate;

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "timeUnit");
        this.delegate = new RealConnectionPool(i, j, timeUnit);
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }
}
