package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t60;

/* loaded from: classes4.dex */
public final class FlowableWithLatestFrom$WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements s51<T>, t51 {
    public static final long serialVersionUID = -312246233408980075L;
    public final s51<? super R> actual;
    public final t60<? super T, ? super U, ? extends R> combiner;

    /* renamed from: s */
    public final AtomicReference<t51> f4412s = new AtomicReference<>();
    public final AtomicReference<t51> other = new AtomicReference<>();

    public FlowableWithLatestFrom$WithLatestFromSubscriber(s51<? super R> s51Var, t60<? super T, ? super U, ? extends R> t60Var) {
        this.actual = s51Var;
        this.combiner = t60Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4412s.get().cancel();
        SubscriptionHelper.cancel(this.other);
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
        U u = get();
        if (u != null) {
            try {
                this.actual.onNext(this.combiner.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, u));
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                cancel();
                this.actual.onError(th);
            }
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this.f4412s, t51Var)) {
            this.actual.onSubscribe(this);
        }
    }

    public void otherError(Throwable th) {
        if (this.f4412s.compareAndSet(null, SubscriptionHelper.CANCELLED)) {
            EmptySubscription.error(th, this.actual);
        } else if (this.f4412s.get() == SubscriptionHelper.CANCELLED) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else {
            cancel();
            this.actual.onError(th);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        this.f4412s.get().request(j);
    }

    public boolean setOther(t51 t51Var) {
        return SubscriptionHelper.setOnce(this.other, t51Var);
    }
}
