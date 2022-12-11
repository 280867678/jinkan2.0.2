package me.tvspark;

import io.reactivex.internal.operators.observable.ObservableRefCount;

/* loaded from: classes4.dex */
public class sb0 implements Runnable {
    public final /* synthetic */ ObservableRefCount Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ o60 Wwwwwwwwwwwwwwwwwwwwwwww;

    public sb0(ObservableRefCount observableRefCount, o60 o60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = observableRefCount;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = o60Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.lock();
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.decrementAndGet() == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.dispose();
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = new o60();
            }
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.unlock();
        }
    }
}
