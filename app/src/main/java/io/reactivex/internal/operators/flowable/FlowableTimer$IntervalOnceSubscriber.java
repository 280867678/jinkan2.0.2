package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTimer$IntervalOnceSubscriber extends AtomicReference<p60> implements t51, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final s51<? super Long> actual;
    public volatile boolean requested;

    public FlowableTimer$IntervalOnceSubscriber(s51<? super Long> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.requested = true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            if (this.requested) {
                this.actual.onNext(0L);
                this.actual.onComplete();
            } else {
                this.actual.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
            }
            lazySet(EmptyDisposable.INSTANCE);
        }
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }
}
