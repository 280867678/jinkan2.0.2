package me.tvspark;

import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class pa0 implements Callable<gd0<T>> {
    public final /* synthetic */ d60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public pa0(d60 d60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = d60Var;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.replay();
    }
}
