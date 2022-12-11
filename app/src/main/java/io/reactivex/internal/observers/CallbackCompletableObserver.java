package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r60;
import me.tvspark.u50;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class CallbackCompletableObserver extends AtomicReference<p60> implements u50, p60, x60<Throwable> {
    public static final long serialVersionUID = -4361286194466301354L;
    public final r60 onComplete;
    public final x60<? super Throwable> onError;

    public CallbackCompletableObserver(r60 r60Var) {
        this.onError = this;
        this.onComplete = r60Var;
    }

    public CallbackCompletableObserver(x60<? super Throwable> x60Var, r60 r60Var) {
        this.onError = x60Var;
        this.onComplete = r60Var;
    }

    @Override // me.tvspark.x60
    public void accept(Throwable th) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        try {
            this.onComplete.run();
            lazySet(DisposableHelper.DISPOSED);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            onError(th);
        }
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }
}
