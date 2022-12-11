package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.k60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements s51<T>, t51, Runnable {
    public static final long serialVersionUID = -3517602651313910099L;
    public final s51<? super T> actual;
    public final long period;

    /* renamed from: s */
    public t51 f4390s;
    public final k60 scheduler;
    public final TimeUnit unit;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable timer = new SequentialDisposable();

    public FlowableSampleTimed$SampleTimedSubscriber(s51<? super T> s51Var, long j, TimeUnit timeUnit, k60 k60Var) {
        this.actual = s51Var;
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = k60Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        cancelTimer();
        this.f4390s.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        cancelTimer();
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        cancelTimer();
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        lazySet(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4390s, t51Var)) {
            this.f4390s = t51Var;
            this.actual.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            k60 k60Var = this.scheduler;
            long j = this.period;
            sequentialDisposable.replace(k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.unit));
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        T andSet = getAndSet(null);
        if (andSet != null) {
            if (this.requested.get() != 0) {
                this.actual.onNext(andSet);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, 1L);
                return;
            }
            cancel();
            this.actual.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }
    }
}
