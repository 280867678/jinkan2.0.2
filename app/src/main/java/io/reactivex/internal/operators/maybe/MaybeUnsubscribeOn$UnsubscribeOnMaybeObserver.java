package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60, Runnable {
    public static final long serialVersionUID = 3256698449646456986L;
    public final a60<? super T> actual;

    /* renamed from: ds */
    public p60 f4420ds;
    public final k60 scheduler;

    public MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(a60<? super T> a60Var, k60 k60Var) {
        this.actual = a60Var;
        this.scheduler = k60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        p60 andSet = getAndSet(DisposableHelper.DISPOSED);
        if (andSet != DisposableHelper.DISPOSED) {
            this.f4420ds = andSet;
            this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        }
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
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4420ds.dispose();
    }
}
