package me.tvspark;

import io.reactivex.internal.operators.observable.ObservablePublish;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class qb0 implements h60<T> {
    public final /* synthetic */ AtomicReference Wwwwwwwwwwwwwwwwwwwwwwww;

    public qb0(AtomicReference atomicReference) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
    }

    @Override // me.tvspark.h60
    public void subscribe(j60<? super T> j60Var) {
        boolean z;
        ObservablePublish.InnerDisposable innerDisposable = new ObservablePublish.InnerDisposable(j60Var);
        j60Var.onSubscribe(innerDisposable);
        while (true) {
            ObservablePublish.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (ObservablePublish.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isDisposed()) {
                ObservablePublish.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new ObservablePublish.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                if (!this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    continue;
                } else {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                }
            }
            while (true) {
                ObservablePublish.InnerDisposable[] innerDisposableArr = (ObservablePublish.InnerDisposable[]) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.get();
                z = false;
                if (innerDisposableArr != ObservablePublish.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww) {
                    int length = innerDisposableArr.length;
                    ObservablePublish.InnerDisposable[] innerDisposableArr2 = new ObservablePublish.InnerDisposable[length + 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                    innerDisposableArr2[length] = innerDisposable;
                    if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                innerDisposable.setParent(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
        }
    }
}
