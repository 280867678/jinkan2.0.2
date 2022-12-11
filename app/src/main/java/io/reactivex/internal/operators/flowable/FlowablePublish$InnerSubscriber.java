package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowablePublish$InnerSubscriber<T> extends AtomicLong implements t51 {
    public static final long serialVersionUID = -4453897557930727610L;
    public final s51<? super T> child;
    public volatile FlowablePublish$PublishSubscriber<T> parent;

    public FlowablePublish$InnerSubscriber(s51<? super T> s51Var) {
        this.child = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (flowablePublish$PublishSubscriber = this.parent) == null) {
            return;
        }
        flowablePublish$PublishSubscriber.remove(this);
        flowablePublish$PublishSubscriber.dispatch();
    }

    public long produced(long j) {
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            FlowablePublish$PublishSubscriber<T> flowablePublish$PublishSubscriber = this.parent;
            if (flowablePublish$PublishSubscriber == null) {
                return;
            }
            flowablePublish$PublishSubscriber.dispatch();
        }
    }
}
