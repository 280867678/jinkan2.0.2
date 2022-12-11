package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.s70;

/* loaded from: classes4.dex */
public final class MpscLinkedQueue<T> implements s70<T> {
    public final AtomicReference<LinkedQueueNode<T>> Wwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
    public final AtomicReference<LinkedQueueNode<T>> Wwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();

    /* loaded from: classes4.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        public static final long serialVersionUID = 2404266111789071508L;
        public E value;

        public LinkedQueueNode() {
        }

        public LinkedQueueNode(E e) {
            spValue(e);
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e) {
            this.value = e;
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(linkedQueueNode);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndSet(linkedQueueNode);
    }

    @Override // me.tvspark.t70
    public void clear() {
        while (mo4868poll() != null && !isEmpty()) {
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.get() == this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
    }

    @Override // me.tvspark.t70
    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.getAndSet(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // me.tvspark.s70, me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        LinkedQueueNode<T> linkedQueueNode = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
        LinkedQueueNode<T> lvNext = linkedQueueNode.lvNext();
        if (lvNext != null) {
            T andNullValue = lvNext.getAndNullValue();
            this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(lvNext);
            return andNullValue;
        } else if (linkedQueueNode == this.Wwwwwwwwwwwwwwwwwwwwwwww.get()) {
            return null;
        } else {
            do {
                lvNext = linkedQueueNode.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            this.Wwwwwwwwwwwwwwwwwwwwwww.lazySet(lvNext);
            return andNullValue2;
        }
    }
}
