package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class CompletableUsing$UsingObserver<R> extends AtomicReference<Object> implements u50, p60 {
    public static final long serialVersionUID = -674404550052917487L;
    public final u50 actual;

    /* renamed from: d */
    public p60 f4355d;
    public final x60<? super R> disposer;
    public final boolean eager;

    public CompletableUsing$UsingObserver(u50 u50Var, R r, x60<? super R> x60Var, boolean z) {
        super(r);
        this.actual = u50Var;
        this.disposer = x60Var;
        this.eager = z;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4355d.dispose();
        this.f4355d = DisposableHelper.DISPOSED;
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
        return this.f4355d.isDisposed();
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        this.f4355d = DisposableHelper.DISPOSED;
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

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.f4355d = DisposableHelper.DISPOSED;
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

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4355d, p60Var)) {
            this.f4355d = p60Var;
            this.actual.onSubscribe(this);
        }
    }
}
