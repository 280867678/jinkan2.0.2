package me.tvspark;

import io.reactivex.internal.operators.observable.ObservableRefCount;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class rb0 implements x60<p60> {
    public final /* synthetic */ ObservableRefCount Wwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ AtomicBoolean Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ j60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public rb0(ObservableRefCount observableRefCount, j60 j60Var, AtomicBoolean atomicBoolean) {
        this.Wwwwwwwwwwwwwwwwwwwwww = observableRefCount;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = atomicBoolean;
    }

    @Override // me.tvspark.x60
    public void accept(p60 p60Var) throws Exception {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.unlock();
            this.Wwwwwwwwwwwwwwwwwwwwwww.set(false);
        }
    }
}
