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
public final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements s51<T>, t51 {
    public static final long serialVersionUID = -9102637559663639004L;
    public final s51<? super T> actual;
    public boolean done;
    public volatile long index;

    /* renamed from: s */
    public t51 f4366s;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(s51<? super T> s51Var, long j, TimeUnit timeUnit, k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.actual = s51Var;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        DisposableHelper.dispose(this.timer);
        this.worker.dispose();
        this.f4366s.cancel();
    }

    public void emit(long j, T t, FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter) {
        if (j == this.index) {
            if (get() == 0) {
                cancel();
                this.actual.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return;
            }
            this.actual.onNext(t);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
            flowableDebounceTimed$DebounceEmitter.dispose();
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        p60 p60Var = this.timer.get();
        if (DisposableHelper.isDisposed(p60Var)) {
            return;
        }
        FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = (FlowableDebounceTimed$DebounceEmitter) p60Var;
        if (flowableDebounceTimed$DebounceEmitter != null) {
            flowableDebounceTimed$DebounceEmitter.emit();
        }
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
        if (this.done) {
            return;
        }
        long j = this.index + 1;
        this.index = j;
        p60 p60Var = this.timer.get();
        if (p60Var != null) {
            p60Var.dispose();
        }
        FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = new FlowableDebounceTimed$DebounceEmitter(t, j, this);
        if (!this.timer.replace(flowableDebounceTimed$DebounceEmitter)) {
            return;
        }
        flowableDebounceTimed$DebounceEmitter.setResource(this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableDebounceTimed$DebounceEmitter, this.timeout, this.unit));
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4366s, t51Var)) {
            this.f4366s = t51Var;
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
}
