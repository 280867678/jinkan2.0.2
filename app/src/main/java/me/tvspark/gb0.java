package me.tvspark;

import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;

/* loaded from: classes4.dex */
public final class gb0<T> extends d60<T> implements r70<T> {
    public final T Wwwwwwwwwwwwwwwwwwwwwwww;

    public gb0(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
    }

    @Override // me.tvspark.r70, java.util.concurrent.Callable
    public T call() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(observableScalarXMap$ScalarDisposable);
        observableScalarXMap$ScalarDisposable.run();
    }
}
