package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSkipUntil$SkipUntilMainSubscriber<T> extends AtomicInteger implements m70<T>, t51 {
    public static final long serialVersionUID = -6270983465606289181L;
    public final s51<? super T> actual;
    public volatile boolean gate;

    /* renamed from: s */
    public final AtomicReference<t51> f4398s = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final FlowableSkipUntil$SkipUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes4.dex */
    public final class OtherSubscriber extends AtomicReference<t51> implements s51<Object> {
        public static final long serialVersionUID = -5592042965931999169L;

        public OtherSubscriber() {
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(FlowableSkipUntil$SkipUntilMainSubscriber.this.f4398s);
            FlowableSkipUntil$SkipUntilMainSubscriber flowableSkipUntil$SkipUntilMainSubscriber = FlowableSkipUntil$SkipUntilMainSubscriber.this;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((s51<?>) flowableSkipUntil$SkipUntilMainSubscriber.actual, th, (AtomicInteger) flowableSkipUntil$SkipUntilMainSubscriber, flowableSkipUntil$SkipUntilMainSubscriber.error);
        }

        @Override // me.tvspark.s51
        public void onNext(Object obj) {
            FlowableSkipUntil$SkipUntilMainSubscriber.this.gate = true;
            get().cancel();
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.setOnce(this, t51Var)) {
                t51Var.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableSkipUntil$SkipUntilMainSubscriber(s51<? super T> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.f4398s);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, this, this.error);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((s51<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (!tryOnNext(t)) {
            this.f4398s.get().request(1L);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this.f4398s, this.requested, t51Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.f4398s, this.requested, j);
    }

    @Override // me.tvspark.m70
    public boolean tryOnNext(T t) {
        if (this.gate) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, t, this, this.error);
            return true;
        }
        return false;
    }
}
