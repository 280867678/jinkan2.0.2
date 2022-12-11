package me.tvspark;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class ra0 implements Callable<gd0<T>> {
    public final /* synthetic */ k60 Wwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ TimeUnit Wwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ d60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public ra0(d60 d60Var, int i, long j, TimeUnit timeUnit, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = d60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.replay(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
    }
}
