package io.reactivex.internal.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.q70;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements q70<T> {
    public static final int CANCELLED = 2;
    public static final int NO_REQUEST = 0;
    public static final int REQUESTED = 1;
    public static final long serialVersionUID = -3830916580126663321L;
    public final s51<? super T> subscriber;
    public final T value;

    public ScalarSubscription(s51<? super T> s51Var, T t) {
        this.subscriber = s51Var;
        this.value = t;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        lazySet(2);
    }

    @Override // me.tvspark.t70
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // me.tvspark.t70
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            s51<? super T> s51Var = this.subscriber;
            s51Var.onNext((T) this.value);
            if (get() == 2) {
                return;
            }
            s51Var.onComplete();
        }
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        return i & 1;
    }
}
