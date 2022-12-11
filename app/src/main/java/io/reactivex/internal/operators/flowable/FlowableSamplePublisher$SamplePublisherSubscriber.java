package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.s80;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSamplePublisher$SamplePublisherSubscriber<T> extends AtomicReference<T> implements s51<T>, t51 {
    public static final long serialVersionUID = -3517602651313910099L;
    public final s51<? super T> actual;

    /* renamed from: s */
    public t51 f4389s;
    public final r51<?> sampler;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicReference<t51> other = new AtomicReference<>();

    public FlowableSamplePublisher$SamplePublisherSubscriber(s51<? super T> s51Var, r51<?> r51Var) {
        this.actual = s51Var;
        this.sampler = r51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.f4389s.cancel();
    }

    public void complete() {
        cancel();
        this.actual.onComplete();
    }

    public void emit() {
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

    public void error(Throwable th) {
        cancel();
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        lazySet(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4389s, t51Var)) {
            this.f4389s = t51Var;
            this.actual.onSubscribe(this);
            if (this.other.get() != null) {
                return;
            }
            this.sampler.subscribe(new s80(this));
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
        }
    }

    public boolean setOther(t51 t51Var) {
        return SubscriptionHelper.setOnce(this.other, t51Var);
    }
}
