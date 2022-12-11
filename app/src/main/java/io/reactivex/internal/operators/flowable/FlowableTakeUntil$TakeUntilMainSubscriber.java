package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTakeUntil$TakeUntilMainSubscriber<T> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = -4945480365982832967L;
    public final s51<? super T> actual;
    public final AtomicLong requested = new AtomicLong();

    /* renamed from: s */
    public final AtomicReference<t51> f4404s = new AtomicReference<>();
    public final FlowableTakeUntil$TakeUntilMainSubscriber<T>.OtherSubscriber other = new OtherSubscriber();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes4.dex */
    public final class OtherSubscriber extends AtomicReference<t51> implements s51<Object> {
        public static final long serialVersionUID = -3592821756711087922L;

        public OtherSubscriber() {
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.f4404s);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(flowableTakeUntil$TakeUntilMainSubscriber.actual, flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            SubscriptionHelper.cancel(FlowableTakeUntil$TakeUntilMainSubscriber.this.f4404s);
            FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = FlowableTakeUntil$TakeUntilMainSubscriber.this;
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((s51<?>) flowableTakeUntil$TakeUntilMainSubscriber.actual, th, (AtomicInteger) flowableTakeUntil$TakeUntilMainSubscriber, flowableTakeUntil$TakeUntilMainSubscriber.error);
        }

        @Override // me.tvspark.s51
        public void onNext(Object obj) {
            SubscriptionHelper.cancel(this);
            onComplete();
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.setOnce(this, t51Var)) {
                t51Var.request(Long.MAX_VALUE);
            }
        }
    }

    public FlowableTakeUntil$TakeUntilMainSubscriber(s51<? super T> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.f4404s);
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
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, t, this, this.error);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this.f4404s, this.requested, t51Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.f4404s, this.requested, j);
    }
}
