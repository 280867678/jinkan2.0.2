package io.reactivex.subjects;

import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.sd0;

/* loaded from: classes4.dex */
public final class ReplaySubject<T> extends sd0<T> {
    public static final Object[] Wwwwwwwwwwwwwwwwwwwwwwww = new Object[0];

    /* loaded from: classes4.dex */
    public static final class Node<T> extends AtomicReference<Node<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ReplayDisposable<T> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = 466549804534799122L;
        public final j60<? super T> actual;
        public volatile boolean cancelled;
        public Object index;
        public final ReplaySubject<T> state;

        public ReplayDisposable(j60<? super T> j60Var, ReplaySubject<T> replaySubject) {
            this.actual = j60Var;
            this.state = replaySubject;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                throw null;
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: classes4.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> {
        public static final long serialVersionUID = -8056260896137901749L;
        public volatile boolean done;
        public volatile TimedNode<Object> head;
        public final long maxAge;
        public final int maxSize;
        public final k60 scheduler;
        public int size;
        public TimedNode<Object> tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, k60 k60Var) {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "maxSize");
            this.maxSize = i;
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, "maxAge");
            this.maxAge = j;
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit, "unit is null");
            this.unit = timeUnit;
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k60Var, "scheduler is null");
            this.scheduler = k60Var;
            TimedNode<Object> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
        }

        public void add(T t) {
            TimedNode<Object> timedNode = new TimedNode<>(t, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        public T getValue() {
            TimedNode<Object> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<T> timedNode3 = timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            T t = (T) timedNode.value;
            if (t == null) {
                return null;
            }
            return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) timedNode2.value : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T[] getValues(T[] tArr) {
            TimedNode<T> timedNode = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    timedNode = timedNode.get();
                    tArr[i] = timedNode.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            j60<? super T> j60Var = replayDisposable.actual;
            TimedNode<T> timedNode = (TimedNode) replayDisposable.index;
            if (timedNode == null) {
                timedNode = this.head;
                if (!this.done) {
                    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
                    TimedNode<Object> timedNode2 = timedNode.get();
                    while (timedNode2 != null && timedNode2.time <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        TimedNode<Object> timedNode3 = timedNode2;
                        timedNode2 = timedNode2.get();
                        timedNode = timedNode3;
                    }
                }
            }
            int i = 1;
            while (true) {
                timedNode = timedNode;
                if (replayDisposable.cancelled) {
                    replayDisposable.index = null;
                    return;
                }
                while (!replayDisposable.cancelled) {
                    TimedNode<T> timedNode4 = timedNode.get();
                    if (timedNode4 != null) {
                        Object obj = (T) timedNode4.value;
                        if (this.done && timedNode4.get() == null) {
                            if (NotificationLite.isComplete(obj)) {
                                j60Var.onComplete();
                            } else {
                                j60Var.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        j60Var.onNext(obj);
                        timedNode = timedNode4;
                    } else if (timedNode.get() == null) {
                        replayDisposable.index = timedNode;
                        i = replayDisposable.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
                return;
            }
        }

        public int size() {
            TimedNode<Object> timedNode = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    Object obj = timedNode.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                timedNode = timedNode2;
            }
            return i;
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 != null && timedNode2.time <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        public void trimFinal() {
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2.get() != null && timedNode2.time <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }
    }

    /* loaded from: classes4.dex */
    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> {
        public static final long serialVersionUID = 1107649250281456395L;
        public volatile boolean done;
        public volatile Node<Object> head;
        public final int maxSize;
        public int size;
        public Node<Object> tail;

        public SizeBoundReplayBuffer(int i) {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "maxSize");
            this.maxSize = i;
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        public void add(T t) {
            Node<Object> node = new Node<>(t);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            this.done = true;
        }

        public T getValue() {
            Node<Object> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<T> node3 = node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = (T) node.value;
            if (t == null) {
                return null;
            }
            return (NotificationLite.isComplete(t) || NotificationLite.isError(t)) ? (T) node2.value : t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T[] getValues(T[] tArr) {
            Node<T> node = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i = 0; i != size; i++) {
                    node = node.get();
                    tArr[i] = node.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            j60<? super T> j60Var = replayDisposable.actual;
            Node<T> node = (Node) replayDisposable.index;
            if (node == null) {
                node = this.head;
            }
            int i = 1;
            while (!replayDisposable.cancelled) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    Object obj = (T) node2.value;
                    if (this.done && node2.get() == null) {
                        if (NotificationLite.isComplete(obj)) {
                            j60Var.onComplete();
                        } else {
                            j60Var.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    j60Var.onNext(obj);
                    node = node2;
                } else if (node.get() != null) {
                    continue;
                } else {
                    replayDisposable.index = node;
                    i = replayDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        public int size() {
            Node<Object> node = this.head;
            int i = 0;
            while (i != Integer.MAX_VALUE) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    Object obj = node.value;
                    return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i - 1 : i;
                }
                i++;
                node = node2;
            }
            return i;
        }

        public void trim() {
            int i = this.size;
            if (i > this.maxSize) {
                this.size = i - 1;
                this.head = this.head.get();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    /* loaded from: classes4.dex */
    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> {
        public static final long serialVersionUID = -733876083048047795L;
        public final List<Object> buffer;
        public volatile boolean done;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, "capacityHint");
            this.buffer = new ArrayList(i);
        }

        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        public T getValue() {
            int i = this.size;
            if (i != 0) {
                List<Object> list = this.buffer;
                T t = (T) list.get(i - 1);
                if (!NotificationLite.isComplete(t) && !NotificationLite.isError(t)) {
                    return t;
                }
                if (i != 1) {
                    return (T) list.get(i - 2);
                }
                return null;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T[] getValues(T[] tArr) {
            int i = this.size;
            if (i == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
            }
            for (int i2 = 0; i2 < i; i2++) {
                tArr[i2] = list.get(i2);
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            int i;
            if (replayDisposable.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            j60<? super T> j60Var = replayDisposable.actual;
            Integer num = (Integer) replayDisposable.index;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                replayDisposable.index = 0;
            }
            int i3 = 1;
            while (!replayDisposable.cancelled) {
                int i4 = this.size;
                while (i4 != i2) {
                    if (replayDisposable.cancelled) {
                        replayDisposable.index = null;
                        return;
                    }
                    Object obj = list.get(i2);
                    if (this.done && (i = i2 + 1) == i4 && i == (i4 = this.size)) {
                        if (NotificationLite.isComplete(obj)) {
                            j60Var.onComplete();
                        } else {
                            j60Var.onError(NotificationLite.getError(obj));
                        }
                        replayDisposable.index = null;
                        replayDisposable.cancelled = true;
                        return;
                    }
                    j60Var.onNext(obj);
                    i2++;
                }
                if (i2 == this.size) {
                    replayDisposable.index = Integer.valueOf(i2);
                    i3 = replayDisposable.addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
            }
            replayDisposable.index = null;
        }

        public int size() {
            int i = this.size;
            if (i != 0) {
                int i2 = i - 1;
                Object obj = this.buffer.get(i2);
                return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i2 : i;
            }
            return 0;
        }
    }
}
