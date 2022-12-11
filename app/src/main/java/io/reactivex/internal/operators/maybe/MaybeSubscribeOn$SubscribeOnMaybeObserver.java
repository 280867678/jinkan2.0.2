package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeSubscribeOn$SubscribeOnMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = 8571289934935992137L;
    public final a60<? super T> actual;
    public final SequentialDisposable task = new SequentialDisposable();

    public MaybeSubscribeOn$SubscribeOnMaybeObserver(a60<? super T> a60Var) {
        this.actual = a60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
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
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
