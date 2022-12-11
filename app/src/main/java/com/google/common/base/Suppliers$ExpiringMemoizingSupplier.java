package com.google.common.base;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import me.tvspark.AbstractC2684ut;
import me.tvspark.C2536qt;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public class Suppliers$ExpiringMemoizingSupplier<T> implements AbstractC2684ut<T>, Serializable {
    public static final long serialVersionUID = 0;
    public final AbstractC2684ut<T> delegate;
    public final long durationNanos;
    public volatile transient long expirationNanos;
    public volatile transient T value;

    public Suppliers$ExpiringMemoizingSupplier(AbstractC2684ut<T> abstractC2684ut, long j, TimeUnit timeUnit) {
        if (abstractC2684ut != null) {
            this.delegate = abstractC2684ut;
            this.durationNanos = timeUnit.toNanos(j);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
            return;
        }
        throw null;
    }

    @Override // me.tvspark.AbstractC2684ut
    /* renamed from: get */
    public T mo4804get() {
        long j = this.expirationNanos;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2536qt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (j == 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - j >= 0) {
            synchronized (this) {
                if (j == this.expirationNanos) {
                    T mo4804get = this.delegate.mo4804get();
                    this.value = mo4804get;
                    long j2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + this.durationNanos;
                    if (j2 == 0) {
                        j2 = 1;
                    }
                    this.expirationNanos = j2;
                    return mo4804get;
                }
            }
        }
        return this.value;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Suppliers.memoizeWithExpiration(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.delegate);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.durationNanos, ", NANOS)");
    }
}
