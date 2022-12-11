package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import me.tvspark.l80;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableConcatMap$ConcatMapInner<R> extends SubscriptionArbiter implements s51<R> {
    public static final long serialVersionUID = 897683679971470653L;
    public final l80<R> parent;
    public long produced;

    public FlowableConcatMap$ConcatMapInner(l80<R> l80Var) {
        this.parent = l80Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        long j = this.produced;
        if (j != 0) {
            this.produced = 0L;
            produced(j);
        }
        this.parent.innerError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(R r) {
        this.produced++;
        this.parent.innerNext(r);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        setSubscription(t51Var);
    }
}
