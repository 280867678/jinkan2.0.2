package me.tvspark;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class tb0<T, R> extends d60<R> {
    public final f70<? super T, ? extends h60<? extends R>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final T Wwwwwwwwwwwwwwwwwwwwwwww;

    public tb0(T t, f70<? super T, ? extends h60<? extends R>> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        try {
            h60<? extends R> apply = this.Wwwwwwwwwwwwwwwwwwwwwww.apply((T) this.Wwwwwwwwwwwwwwwwwwwwwwww);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null ObservableSource");
            h60<? extends R> h60Var = apply;
            if (!(h60Var instanceof Callable)) {
                h60Var.subscribe(j60Var);
                return;
            }
            try {
                Object call = ((Callable) h60Var).call();
                if (call == null) {
                    EmptyDisposable.complete(j60Var);
                    return;
                }
                ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(j60Var, call);
                j60Var.onSubscribe(observableScalarXMap$ScalarDisposable);
                observableScalarXMap$ScalarDisposable.run();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                EmptyDisposable.error(th, j60Var);
            }
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, j60Var);
        }
    }
}
