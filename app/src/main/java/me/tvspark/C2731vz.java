package me.tvspark;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* renamed from: me.tvspark.vz */
/* loaded from: classes4.dex */
public class C2731vz<V> extends FutureTask<V> implements AbstractFutureC2691uz<V> {
    public final C2505pz Wwwwwwwwwwwwwwwwwwwwwwww = new C2505pz();

    public C2731vz(Callable<V> callable) {
        super(callable);
    }

    @Override // me.tvspark.AbstractFutureC2691uz
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Runnable runnable, Executor executor) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
