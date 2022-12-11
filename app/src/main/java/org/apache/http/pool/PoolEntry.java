package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import me.tvspark.outline;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes4.dex */
public abstract class PoolEntry<T, C> {
    public final C conn;
    public final long created;
    public long expiry;

    /* renamed from: id */
    public final String f4580id;
    public final T route;
    public volatile Object state;
    public long updated;
    public final long validityDeadline;

    public PoolEntry(String str, T t, C c) {
        this(str, t, c, 0L, TimeUnit.MILLISECONDS);
    }

    public PoolEntry(String str, T t, C c, long j, TimeUnit timeUnit) {
        Args.notNull(t, "Route");
        Args.notNull(c, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.f4580id = str;
        this.route = t;
        this.conn = c;
        long currentTimeMillis = System.currentTimeMillis();
        this.created = currentTimeMillis;
        this.updated = currentTimeMillis;
        long j2 = Long.MAX_VALUE;
        if (j > 0) {
            long millis = timeUnit.toMillis(j) + currentTimeMillis;
            if (millis > 0) {
                j2 = millis;
            }
        }
        this.validityDeadline = j2;
        this.expiry = this.validityDeadline;
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.f4580id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j) {
        return j >= this.expiry;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[id:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f4580id);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][route:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.route);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("][state:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.state);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public synchronized void updateExpiry(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long currentTimeMillis = System.currentTimeMillis();
        this.updated = currentTimeMillis;
        this.expiry = Math.min(j > 0 ? currentTimeMillis + timeUnit.toMillis(j) : Long.MAX_VALUE, this.validityDeadline);
    }
}
