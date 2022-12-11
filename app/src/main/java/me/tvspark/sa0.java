package me.tvspark;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class sa0 implements Callable<gd0<T>> {
    public final /* synthetic */ k60 Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ d60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public sa0(d60 d60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = d60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.replay(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww);
    }
}
