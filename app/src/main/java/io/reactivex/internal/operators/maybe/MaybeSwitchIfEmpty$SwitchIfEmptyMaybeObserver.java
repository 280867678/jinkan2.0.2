package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = -2223459372976438024L;
    public final a60<? super T> actual;
    public final b60<? extends T> other;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements a60<T> {
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwww;
        public final a60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var, AtomicReference<p60> atomicReference) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = a60Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        }

        @Override // me.tvspark.a60
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.a60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.a60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this.Wwwwwwwwwwwwwwwwwwwwwww, p60Var);
        }

        @Override // me.tvspark.a60
        public void onSuccess(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(a60<? super T> a60Var, b60<? extends T> b60Var) {
        this.actual = a60Var;
        this.other = b60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        p60 p60Var = get();
        if (p60Var == DisposableHelper.DISPOSED || !compareAndSet(p60Var, null)) {
            return;
        }
        this.other.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, this));
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
