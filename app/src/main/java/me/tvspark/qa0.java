package me.tvspark;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class qa0 implements Callable<gd0<T>> {
    public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ d60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public qa0(d60 d60Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = d60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.replay(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
