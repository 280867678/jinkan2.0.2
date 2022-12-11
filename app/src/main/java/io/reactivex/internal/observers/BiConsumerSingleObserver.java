package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s60;

/* loaded from: classes4.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = 4943102778943297569L;
    public final s60<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(s60<? super T, ? super Throwable> s60Var) {
        this.onCallback = s60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        try {
            this.onCallback.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null, th);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        try {
            this.onCallback.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, null);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
