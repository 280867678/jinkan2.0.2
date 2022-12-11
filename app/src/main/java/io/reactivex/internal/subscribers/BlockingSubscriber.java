package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class BlockingSubscriber<T> extends AtomicReference<t51> implements s51<T>, t51 {
    public static final Object TERMINATED = new Object();
    public static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingSubscriber(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (SubscriptionHelper.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.setOnce(this, t51Var)) {
            this.queue.offer(NotificationLite.subscription(this));
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        get().request(j);
    }
}
