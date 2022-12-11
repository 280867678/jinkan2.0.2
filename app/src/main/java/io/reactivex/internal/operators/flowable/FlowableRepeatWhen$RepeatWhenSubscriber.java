package io.reactivex.internal.operators.flowable;

import me.tvspark.nd0;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableRepeatWhen$RepeatWhenSubscriber<T> extends FlowableRepeatWhen$WhenSourceSubscriber<T, Object> {
    public static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(s51<? super T> s51Var, nd0<Object> nd0Var, t51 t51Var) {
        super(s51Var, nd0Var, t51Var);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        again(0);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.receiver.cancel();
        ((FlowableRepeatWhen$WhenSourceSubscriber) this).actual.onError(th);
    }
}
