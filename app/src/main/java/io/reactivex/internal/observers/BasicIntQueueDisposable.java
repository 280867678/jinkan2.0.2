package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.o70;

/* loaded from: classes4.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements o70<T> {
    public static final long serialVersionUID = -1001730202384742097L;

    @Override // me.tvspark.t70
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
