package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.k60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements s51<T>, t51 {
    public static final long serialVersionUID = 1015244841293359600L;
    public final s51<? super T> actual;

    /* renamed from: s */
    public t51 f4407s;
    public final k60 scheduler;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlowableUnsubscribeOn$UnsubscribeSubscriber.this.f4407s.cancel();
        }
    }

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(s51<? super T> s51Var, k60 k60Var) {
        this.actual = s51Var;
        this.scheduler = k60Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (compareAndSet(false, true)) {
            this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!get()) {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (get()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else {
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (!get()) {
            this.actual.onNext(t);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4407s, t51Var)) {
            this.f4407s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        this.f4407s.request(j);
    }
}
