package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.p80;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableGroupJoin$LeftRightSubscriber extends AtomicReference<t51> implements s51<Object>, p60 {
    public static final long serialVersionUID = 1883890389173668373L;
    public final boolean isLeft;
    public final p80 parent;

    public FlowableGroupJoin$LeftRightSubscriber(p80 p80Var, boolean z) {
        this.parent = p80Var;
        this.isLeft = z;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(get());
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        this.parent.innerValue(this.isLeft, obj);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
