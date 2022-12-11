package me.tvspark;

import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class pd0<T> {
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public pd0(T t, long j, TimeUnit timeUnit) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = t;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = timeUnit;
    }

    public boolean equals(Object obj) {
        if (obj instanceof pd0) {
            pd0 pd0Var = (pd0) obj;
            return l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, pd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == pd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, pd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    public int hashCode() {
        T t = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31);
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Timed[time=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", unit=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", value=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
