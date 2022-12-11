package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class SingleUsing$UsingSingleObserver<T, U> extends AtomicReference<Object> implements m60<T>, p60 {
    public static final long serialVersionUID = -5331524057054083935L;
    public final m60<? super T> actual;

    /* renamed from: d */
    public p60 f4472d;
    public final x60<? super U> disposer;
    public final boolean eager;

    public SingleUsing$UsingSingleObserver(m60<? super T> m60Var, U u, boolean z, x60<? super U> x60Var) {
        super(u);
        this.actual = m60Var;
        this.eager = z;
        this.disposer = x60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4472d.dispose();
        this.f4472d = DisposableHelper.DISPOSED;
        disposeAfter();
    }

    public void disposeAfter() {
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
        return this.f4472d.isDisposed();
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.f4472d = DisposableHelper.DISPOSED;
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
            disposeAfter();
        }
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4472d, p60Var)) {
            this.f4472d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.f4472d = DisposableHelper.DISPOSED;
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
            disposeAfter();
        }
    }
}
