package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.l70;
import me.tvspark.w80;

/* loaded from: classes4.dex */
public final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements w80<T> {
    public static final long serialVersionUID = -7969063454040569579L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int i) {
        super(i);
    }

    @Override // me.tvspark.t70
    public void clear() {
        while (mo4868poll() != null && !isEmpty()) {
        }
    }

    @Override // me.tvspark.w80
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // me.tvspark.w80
    public void drop() {
        int i = this.consumerIndex;
        lazySet(i, null);
        this.consumerIndex = i + 1;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.consumerIndex == producerIndex();
    }

    @Override // me.tvspark.t70
    public boolean offer(T t) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "value is null");
        int andIncrement = this.producerIndex.getAndIncrement();
        if (andIncrement < length()) {
            lazySet(andIncrement, t);
            return true;
        }
        return false;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    @Override // me.tvspark.w80
    public T peek() {
        int i = this.consumerIndex;
        if (i == length()) {
            return null;
        }
        return get(i);
    }

    @Override // me.tvspark.w80, java.util.Queue, me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        int i = this.consumerIndex;
        if (i == length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            T t = get(i);
            if (t != null) {
                this.consumerIndex = i + 1;
                lazySet(i, null);
                return t;
            }
        } while (atomicInteger.get() != i);
        return null;
    }

    @Override // me.tvspark.w80
    public int producerIndex() {
        return this.producerIndex.get();
    }
}
