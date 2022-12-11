package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class LambdaObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
    public static final long serialVersionUID = -7251123623727029452L;
    public final r60 onComplete;
    public final x60<? super Throwable> onError;
    public final x60<? super T> onNext;
    public final x60<? super p60> onSubscribe;

    public LambdaObserver(x60<? super T> x60Var, x60<? super Throwable> x60Var2, r60 r60Var, x60<? super p60> x60Var3) {
        this.onNext = x60Var;
        this.onError = x60Var2;
        this.onComplete = r60Var;
        this.onSubscribe = x60Var3;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        if (!isDisposed()) {
            dispose();
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
        }
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (!isDisposed()) {
            dispose();
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
            }
        }
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                onError(th);
            }
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                onError(th);
            }
        }
    }
}
