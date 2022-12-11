package io.reactivex.internal.observers;

import me.tvspark.j60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    public static final int DISPOSED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int TERMINATED = 2;
    public static final long serialVersionUID = -5502432239815349361L;
    public final j60<? super T> actual;
    public T value;

    public DeferredScalarDisposable(j60<? super T> j60Var) {
        this.actual = j60Var;
    }

    @Override // me.tvspark.t70
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.actual.onComplete();
    }

    public final void complete(T t) {
        int i;
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        if (i2 == 8) {
            this.value = t;
            i = 16;
        } else {
            i = 2;
        }
        lazySet(i);
        j60<? super T> j60Var = this.actual;
        j60Var.onNext(t);
        if (get() == 4) {
            return;
        }
        j60Var.onComplete();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        lazySet(2);
        this.actual.onError(th);
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public final T mo4868poll() throws Exception {
        if (get() == 16) {
            T t = this.value;
            this.value = null;
            lazySet(32);
            return t;
        }
        return null;
    }

    @Override // me.tvspark.p70
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }
}
