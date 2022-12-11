package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class MaybeUsing$UsingObserver<T, D> extends AtomicReference<Object> implements a60<T>, p60 {
    public static final long serialVersionUID = -674404550052917487L;
    public final a60<? super T> actual;

    /* renamed from: d */
    public p60 f4421d;
    public final x60<? super D> disposer;
    public final boolean eager;

    public MaybeUsing$UsingObserver(a60<? super T> a60Var, D d, x60<? super D> x60Var, boolean z) {
        super(d);
        this.actual = a60Var;
        this.disposer = x60Var;
        this.eager = z;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4421d.dispose();
        this.f4421d = DisposableHelper.DISPOSED;
        disposeResourceAfter();
    }

    public void disposeResourceAfter() {
        Object andSet = getAndSet(this);
        if (andSet != this) {
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.f4421d.isDisposed();
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.f4421d = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
                return;
            }
        }
        this.actual.onComplete();
        if (!this.eager) {
            disposeResourceAfter();
        }
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.f4421d = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                th = new CompositeException(th, th2);
            }
        }
        this.actual.onError(th);
        if (!this.eager) {
            disposeResourceAfter();
        }
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4421d, p60Var)) {
            this.f4421d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.f4421d = DisposableHelper.DISPOSED;
        if (this.eager) {
            Object andSet = getAndSet(this);
            if (andSet == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.actual.onError(th);
                return;
            }
        }
        this.actual.onSuccess(t);
        if (!this.eager) {
            disposeResourceAfter();
        }
    }
}
