package io.reactivex.internal.subscriptions;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    public static final int CANCELLED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public static final long serialVersionUID = -2151279923272604993L;
    public final s51<? super T> actual;
    public T value;

    public DeferredScalarSubscription(s51<? super T> s51Var) {
        this.actual = s51Var;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // me.tvspark.t70
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i = get();
        while (i != 8) {
            if ((i & (-3)) != 0) {
                return;
            }
            if (i == 2) {
                lazySet(3);
                s51<? super T> s51Var = this.actual;
                s51Var.onNext(t);
                if (get() == 4) {
                    return;
                }
                s51Var.onComplete();
                return;
            }
            this.value = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i = get();
            if (i == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t;
        lazySet(16);
        s51<? super T> s51Var2 = this.actual;
        s51Var2.onNext(t);
        if (get() != 4) {
            s51Var2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public final T mo4868poll() {
        if (get() == 16) {
            lazySet(32);
            T t = this.value;
            this.value = null;
            return t;
        }
        return null;
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        T t;
        if (SubscriptionHelper.validate(j)) {
            do {
                int i = get();
                if ((i & (-2)) != 0) {
                    return;
                }
                if (i == 1) {
                    if (!compareAndSet(1, 3) || (t = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    s51<? super T> s51Var = this.actual;
                    s51Var.onNext(t);
                    if (get() == 4) {
                        return;
                    }
                    s51Var.onComplete();
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // me.tvspark.p70
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
