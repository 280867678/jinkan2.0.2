package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements s51<T>, t51, Runnable {
    public static final long serialVersionUID = -9102637559663639004L;
    public final s51<? super T> actual;
    public boolean done;
    public volatile boolean gate;

    /* renamed from: s */
    public t51 f4405s;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(s51<? super T> s51Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.actual = s51Var;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        DisposableHelper.dispose(this.timer);
        this.worker.dispose();
        this.f4405s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        DisposableHelper.dispose(this.timer);
        this.worker.dispose();
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        DisposableHelper.dispose(this.timer);
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (!this.done && !this.gate) {
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return;
            }
            this.actual.onNext(t);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
            p60 p60Var = this.timer.get();
            if (p60Var != null) {
                p60Var.dispose();
            }
            this.timer.replace(this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.timeout, this.unit));
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4405s, t51Var)) {
            this.f4405s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.gate = false;
    }
}
