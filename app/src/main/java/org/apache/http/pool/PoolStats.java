package org.apache.http.pool;

import java.io.Serializable;
import me.tvspark.outline;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes4.dex */
public class PoolStats implements Serializable {
    public static final long serialVersionUID = -2807686144795228544L;
    public final int available;
    public final int leased;
    public final int max;
    public final int pending;

    public PoolStats(int i, int i2, int i3, int i4) {
        this.leased = i;
        this.pending = i2;
        this.available = i3;
        this.max = i4;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[leased: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.leased);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; pending: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.pending);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; available: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.available);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; max: ");
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.max, "]");
    }
}
