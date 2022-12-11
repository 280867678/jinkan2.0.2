package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.j60;
import me.tvspark.o70;

/* loaded from: classes4.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements o70<T>, Runnable {
    public static final int FUSED = 1;
    public static final int ON_COMPLETE = 3;
    public static final int ON_NEXT = 2;
    public static final int START = 0;
    public static final long serialVersionUID = 3880992722410194083L;
    public final j60<? super T> observer;
    public final T value;

    public ObservableScalarXMap$ScalarDisposable(j60<? super T> j60Var, T t) {
        this.observer = j60Var;
        this.value = t;
    }

    @Override // me.tvspark.t70
    public void clear() {
        lazySet(3);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        set(3);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == 3;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return get() != 1;
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
    public T mo4868poll() throws Exception {
        if (get() == 1) {
            lazySet(3);
            return this.value;
        }
        return null;
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        if ((i & 1) != 0) {
            lazySet(1);
            return 1;
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != 0 || !compareAndSet(0, 2)) {
            return;
        }
        this.observer.onNext((T) this.value);
        if (get() != 2) {
            return;
        }
        lazySet(3);
        this.observer.onComplete();
    }
}
