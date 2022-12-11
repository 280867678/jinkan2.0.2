package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.q70;

/* loaded from: classes4.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements q70<T> {
    public static final long serialVersionUID = -6671519529404341862L;

    @Override // me.tvspark.t70
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
