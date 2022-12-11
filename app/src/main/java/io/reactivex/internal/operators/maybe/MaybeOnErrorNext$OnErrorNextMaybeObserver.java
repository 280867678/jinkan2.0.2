package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = 2026620218879969836L;
    public final a60<? super T> actual;
    public final boolean allowFatal;
    public final f70<? super Throwable, ? extends b60<? extends T>> resumeFunction;

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

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(a60<? super T> a60Var, f70<? super Throwable, ? extends b60<? extends T>> f70Var, boolean z) {
        this.actual = a60Var;
        this.resumeFunction = f70Var;
        this.allowFatal = z;
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
        this.actual.onComplete();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        if (!this.allowFatal && !(th instanceof Exception)) {
            this.actual.onError(th);
            return;
        }
        try {
            b60<? extends T> apply = this.resumeFunction.apply(th);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The resumeFunction returned a null MaybeSource");
            b60<? extends T> b60Var = apply;
            DisposableHelper.replace(this, null);
            b60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, this));
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
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
