package me.tvspark;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class zw0 extends nx0 {
    public nx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public zw0(nx0 nx0Var) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(nx0Var, "delegate");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = nx0Var;
    }

    @Override // me.tvspark.nx0
    public nx0 clearDeadline() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearDeadline();
    }

    @Override // me.tvspark.nx0
    public nx0 clearTimeout() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clearTimeout();
    }

    @Override // me.tvspark.nx0
    public long deadlineNanoTime() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.deadlineNanoTime();
    }

    @Override // me.tvspark.nx0
    public nx0 deadlineNanoTime(long j) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.deadlineNanoTime(j);
    }

    @Override // me.tvspark.nx0
    public boolean hasDeadline() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hasDeadline();
    }

    @Override // me.tvspark.nx0
    public void throwIfReached() throws IOException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.throwIfReached();
    }

    @Override // me.tvspark.nx0
    public nx0 timeout(long j, TimeUnit timeUnit) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit");
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.timeout(j, timeUnit);
    }

    @Override // me.tvspark.nx0
    public long timeoutNanos() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.timeoutNanos();
    }
}
