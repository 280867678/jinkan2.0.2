package io.reactivex.internal.operators.flowable;

import me.tvspark.nd0;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRetryWhen$RetryWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Throwable> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(s51<? super T> s51Var, nd0<Throwable> nd0Var, t51 t51Var) {
        super(s51Var, nd0Var, t51Var);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.receiver.cancel();
        ((FlowableRepeatWhen$WhenSourceSubscriber) this).actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        again(th);
    }
}
