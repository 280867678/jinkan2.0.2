package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableToList$ToListSubscriber<T, U extends Collection<? super T>> extends DeferredScalarSubscription<U> implements s51<T>, t51 {
    public static final long serialVersionUID = -8134157938864266736L;

    /* renamed from: s */
    public t51 f4406s;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowableToList$ToListSubscriber(s51<? super U> s51Var, U u) {
        super(s51Var);
        this.value = u;
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.f4406s.cancel();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        complete(this.value);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        ((Collection) this.value).add(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4406s, t51Var)) {
            this.f4406s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
