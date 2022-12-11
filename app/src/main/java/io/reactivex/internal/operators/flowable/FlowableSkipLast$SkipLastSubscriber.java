package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableSkipLast$SkipLastSubscriber<T> extends ArrayDeque<T> implements s51<T>, t51 {
    public static final long serialVersionUID = -3807491841935125653L;
    public final s51<? super T> actual;

    /* renamed from: s */
    public t51 f4396s;
    public final int skip;

    public FlowableSkipLast$SkipLastSubscriber(s51<? super T> s51Var, int i) {
        super(i);
        this.actual = s51Var;
        this.skip = i;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4396s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.skip == size()) {
            this.actual.onNext((T) poll());
        } else {
            this.f4396s.request(1L);
        }
        offer(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4396s, t51Var)) {
            this.f4396s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        this.f4396s.request(j);
    }
}
