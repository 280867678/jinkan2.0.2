package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.p80;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableGroupJoin$LeftRightEndSubscriber extends AtomicReference<t51> implements s51<Object>, p60 {
    public static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final p80 parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(p80 p80Var, boolean z, int i) {
        this.parent = p80Var;
        this.isLeft = z;
        this.index = i;
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
        this.parent.innerClose(this.isLeft, this);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.parent.innerCloseError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
        if (SubscriptionHelper.cancel(this)) {
            this.parent.innerClose(this.isLeft, this);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
