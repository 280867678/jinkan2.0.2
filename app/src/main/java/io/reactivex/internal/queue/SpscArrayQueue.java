package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.r40;
import me.tvspark.s70;

/* loaded from: classes4.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements s70<E> {
    public static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public static final long serialVersionUID = -1296597691183856449L;
    public final int lookAheadStep;
    public long producerLookAhead;
    public final int mask = length() - 1;
    public final AtomicLong producerIndex = new AtomicLong();
    public final AtomicLong consumerIndex = new AtomicLong();

    public SpscArrayQueue(int i) {
        super(r40.Wwwwwwwwwwwwwwwwwwwwwwwww(i));
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    public int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // me.tvspark.t70
    public void clear() {
        while (true) {
            if (mo4868poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i) {
        return get(i);
    }

    @Override // me.tvspark.t70
    public boolean offer(E e) {
        if (e != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = this.lookAheadStep + j;
                if (lvElement(calcElementOffset(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(calcElementOffset, e);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public boolean offer(E e, E e2) {
        return offer(e) && offer(e2);
    }

    @Override // me.tvspark.s70, me.tvspark.t70
    /* renamed from: poll */
    public E mo4868poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    public void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    public void soElement(int i, E e) {
        lazySet(i, e);
    }

    public void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }
}
