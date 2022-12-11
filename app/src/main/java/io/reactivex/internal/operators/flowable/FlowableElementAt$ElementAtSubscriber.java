package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableElementAt$ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements s51<T> {
    public static final long serialVersionUID = 4066607327284737757L;
    public long count;
    public final T defaultValue;
    public boolean done;
    public final long index;

    /* renamed from: s */
    public t51 f4367s;

    public FlowableElementAt$ElementAtSubscriber(s51<? super T> s51Var, long j, T t) {
        super(s51Var);
        this.index = j;
        this.defaultValue = t;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4367s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            T t = this.defaultValue;
            if (t == null) {
                this.actual.onComplete();
            } else {
                complete(t);
            }
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.count;
        if (j != this.index) {
            this.count = j + 1;
            return;
        }
        this.done = true;
        this.f4367s.cancel();
        complete(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4367s, t51Var)) {
            this.f4367s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
