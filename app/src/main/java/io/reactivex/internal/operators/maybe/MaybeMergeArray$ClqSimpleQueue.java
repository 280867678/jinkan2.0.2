package io.reactivex.internal.operators.maybe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.w80;

/* loaded from: classes4.dex */
public final class MaybeMergeArray$ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements w80<T> {
    public static final long serialVersionUID = -4025173261791142821L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    @Override // me.tvspark.w80
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // me.tvspark.w80
    public void drop() {
        mo4868poll();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, me.tvspark.t70
    public boolean offer(T t) {
        this.producerIndex.getAndIncrement();
        return super.offer(t);
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, me.tvspark.w80, me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        T t = (T) super.poll();
        if (t != null) {
            this.consumerIndex++;
        }
        return t;
    }

    @Override // me.tvspark.w80
    public int producerIndex() {
        return this.producerIndex.get();
    }
}
