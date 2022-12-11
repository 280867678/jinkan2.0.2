package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<p60> implements j60<T>, p60 {
    public static final long serialVersionUID = -8612022020200669122L;
    public final j60<? super T> actual;
    public final AtomicReference<p60> subscription = new AtomicReference<>();

    public ObserverResourceWrapper(j60<? super T> j60Var) {
        this.actual = j60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this.subscription);
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.subscription.get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        dispose();
        this.actual.onComplete();
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        dispose();
        this.actual.onError(th);
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        this.actual.onNext(t);
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this.subscription, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.set(this, p60Var);
    }
}
