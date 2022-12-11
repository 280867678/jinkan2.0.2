package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.gd0;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.pd0;
import me.tvspark.r40;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class ObservableReplay<T> extends gd0<T> {
    public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public final h60<T> Wwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwww<T>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final h60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public static final long serialVersionUID = 2346567790059478686L;
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        public final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        public final void collect(Collection<? super T> collection) {
            Node node = get();
            while (true) {
                node = node.get();
                if (node != null) {
                    Object leaveTransform = leaveTransform(node.value);
                    if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                        return;
                    }
                    collection.add((Object) NotificationLite.getValue(leaveTransform));
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public final void complete() {
            addLast(new Node(enterTransform(NotificationLite.complete())));
            truncateFinal();
        }

        public Object enterTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public final void error(Throwable th) {
            addLast(new Node(enterTransform(NotificationLite.error(th))));
            truncateFinal();
        }

        public boolean hasCompleted() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isComplete(leaveTransform(obj));
        }

        public boolean hasError() {
            Object obj = this.tail.value;
            return obj != null && NotificationLite.isError(leaveTransform(obj));
        }

        public Object leaveTransform(Object obj) {
            return obj;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public final void next(T t) {
            addLast(new Node(enterTransform(NotificationLite.next(t))));
            truncate();
        }

        public final void removeFirst() {
            this.size--;
            setFirst(get().get());
        }

        public final void removeSome(int i) {
            Node node = get();
            while (i > 0) {
                node = node.get();
                i--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int i = 1;
            do {
                Node node = (Node) innerDisposable.index();
                if (node == null) {
                    node = get();
                    innerDisposable.index = node;
                }
                while (!innerDisposable.isDisposed()) {
                    Node node2 = node.get();
                    if (node2 == null) {
                        innerDisposable.index = node;
                        i = innerDisposable.addAndGet(-i);
                    } else if (NotificationLite.accept(leaveTransform(node2.value), innerDisposable.child)) {
                        innerDisposable.index = null;
                        return;
                    } else {
                        node = node2;
                    }
                }
                return;
            } while (i != 0);
        }

        public final void setFirst(Node node) {
            set(node);
        }

        public abstract void truncate();

        public void truncateFinal() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements p60 {
        public static final long serialVersionUID = 2728361546769921047L;
        public volatile boolean cancelled;
        public final j60<? super T> child;
        public Object index;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwww<T> parent;

        public InnerDisposable(Wwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwww, j60<? super T> j60Var) {
            this.parent = wwwwwwwwwwwwwwwwwwwwwwwwww;
            this.child = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            }
        }

        public <U> U index() {
            return (U) this.index;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Node extends AtomicReference<Node> {
        public static final long serialVersionUID = 245354315435971818L;
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    /* loaded from: classes4.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = 3457957419649567404L;
        public final int limit;
        public final long maxAge;
        public final k60 scheduler;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, k60 k60Var) {
            this.scheduler = k60Var;
            this.limit = i;
            this.maxAge = j;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object enterTransform(Object obj) {
            return new pd0(obj, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public Object leaveTransform(Object obj) {
            return ((pd0) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            Node node;
            int i;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
            Node node2 = get();
            Node node3 = node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || ((i = this.size) <= this.limit && ((pd0) node2.value).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    break;
                }
                i2++;
                this.size = i - 1;
                node3 = node2.get();
            }
            if (i2 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void truncateFinal() {
            int i;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit) - this.maxAge;
            Node node = get();
            Node node2 = node.get();
            int i2 = 0;
            while (true) {
                Node node3 = node2;
                Node node4 = node;
                node = node3;
                if (node == null || (i = this.size) <= 1 || ((pd0) node.value).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    break;
                }
                i2++;
                this.size = i - 1;
                node2 = node.get();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public static final long serialVersionUID = -5898283885385201806L;
        public final int limit;

        public SizeBoundReplayBuffer(int i) {
            this.limit = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BoundedReplayBuffer
        public void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public static final long serialVersionUID = 7063189396499112664L;
        public volatile int size;

        public UnboundedReplayBuffer(int i) {
            super(i);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwww
        public void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            j60<? super T> j60Var = innerDisposable.child;
            int i = 1;
            while (!innerDisposable.isDisposed()) {
                int i2 = this.size;
                Integer num = (Integer) innerDisposable.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i2) {
                    if (NotificationLite.accept(get(intValue), j60Var) || innerDisposable.isDisposed()) {
                        return;
                    }
                    intValue++;
                }
                innerDisposable.index = Integer.valueOf(intValue);
                i = innerDisposable.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwww<T> implements j60<T>, p60 {
        public volatile p60 Wwwwwwwwwwwwwwwwwwww;
        public boolean Wwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> Wwwwwwwwwwwwwwwwwwwwwwww;
        public static final InnerDisposable[] Wwwwwwwwwwwwwwwwwww = new InnerDisposable[0];
        public static final InnerDisposable[] Wwwwwwwwwwwwwwwwww = new InnerDisposable[0];
        public final AtomicReference<InnerDisposable[]> Wwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>(Wwwwwwwwwwwwwwwwwww);
        public final AtomicBoolean Wwwwwwwwwwwwwwwwwwwww = new AtomicBoolean();

        public Wwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            for (InnerDisposable<T> innerDisposable : this.Wwwwwwwwwwwwwwwwwwwwww.getAndSet(Wwwwwwwwwwwwwwwwww)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.replay(innerDisposable);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            for (InnerDisposable<T> innerDisposable : this.Wwwwwwwwwwwwwwwwwwwwww.get()) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.replay(innerDisposable);
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.Wwwwwwwwwwwwwwwwwwwwww.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = Wwwwwwwwwwwwwwwwwww;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwww.set(Wwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwww.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwww.get() == Wwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.complete();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.error(th);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.next(t);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.Wwwwwwwwwwwwwwwwwwww, p60Var)) {
                this.Wwwwwwwwwwwwwwwwwwww = p60Var;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> call();
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements h60<T> {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ AtomicReference Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference atomicReference, Wwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
            this.Wwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.h60
        public void subscribe(j60<? super T> j60Var) {
            Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww;
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            while (true) {
                wwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwww) this.Wwwwwwwwwwwwwwwwwwwwwwww.get();
                if (wwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    break;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww.call());
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww.compareAndSet(null, wwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                    wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwww2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(wwwwwwwwwwwwwwwwwwwwwwwwww, j60Var);
            j60Var.onSubscribe(innerDisposable);
            do {
                innerDisposableArr = wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.get();
                if (innerDisposableArr == Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww) {
                    break;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww.compareAndSet(innerDisposableArr, innerDisposableArr2));
            if (innerDisposable.isDisposed()) {
                wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerDisposable);
            } else {
                wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public final /* synthetic */ k60 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ TimeUnit Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j, TimeUnit timeUnit, k60 k60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = timeUnit;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k60Var;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww<T> call() {
            return new SizeBoundReplayBuffer(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends gd0<T> {
        public final /* synthetic */ d60 Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ gd0 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gd0 gd0Var, d60 d60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = gd0Var;
            this.Wwwwwwwwwwwwwwwwwwwwwww = d60Var;
        }

        @Override // me.tvspark.gd0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60<? super p60> x60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60Var);
        }

        @Override // me.tvspark.d60
        public void subscribeActual(j60<? super T> j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends d60<R> {
        public final /* synthetic */ f70 Wwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ Callable Wwwwwwwwwwwwwwwwwwwwwwww;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements x60<p60> {
            public final /* synthetic */ ObserverResourceWrapper Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ObserverResourceWrapper observerResourceWrapper) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = observerResourceWrapper;
            }

            @Override // me.tvspark.x60
            public void accept(p60 p60Var) throws Exception {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.setResource(p60Var);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Callable callable, f70 f70Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = callable;
            this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        }

        @Override // me.tvspark.d60
        public void subscribeActual(j60<? super R> j60Var) {
            try {
                gd0 gd0Var = (gd0) this.Wwwwwwwwwwwwwwwwwwwwwwww.call();
                h60 h60Var = (h60) this.Wwwwwwwwwwwwwwwwwwwwwww.apply(gd0Var);
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(j60Var);
                h60Var.subscribe(observerResourceWrapper);
                gd0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, observerResourceWrapper));
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                EmptyDisposable.error(th, j60Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwww {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.Wwwwwwwwwwwwwwwwwwwwwwwwwwww
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    public ObservableReplay(h60<T> h60Var, h60<T> h60Var2, AtomicReference<Wwwwwwwwwwwwwwwwwwwwwwwwww<T>> atomicReference, Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwww = h60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = h60Var2;
        this.Wwwwwwwwwwwwwwwwwwwwwww = atomicReference;
        this.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static <U, R> d60<R> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Callable<? extends gd0<U>> callable, f70<? super d60<U>, ? extends h60<R>> f70Var) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(callable, f70Var);
    }

    public static <T> gd0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gd0<T> gd0Var, k60 k60Var) {
        return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gd0Var, gd0Var.observeOn(k60Var));
    }

    public static <T> gd0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, int i) {
        if (i == Integer.MAX_VALUE) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, Wwwwwwwwwwwwwwwwwwww);
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
    }

    public static <T> gd0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var, int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, j, timeUnit, k60Var));
    }

    public static <T> gd0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        AtomicReference atomicReference = new AtomicReference();
        return new ObservableReplay(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(atomicReference, wwwwwwwwwwwwwwwwwwwwwwwwwwww), h60Var, atomicReference, wwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.gd0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x60<? super p60> x60Var) {
        Wwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwww;
        while (true) {
            wwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.get();
            if (wwwwwwwwwwwwwwwwwwwwwwwwww != null && !wwwwwwwwwwwwwwwwwwwwwwwwww.isDisposed()) {
                break;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwww<T> wwwwwwwwwwwwwwwwwwwwwwwwww2 = new Wwwwwwwwwwwwwwwwwwwwwwwwww<>(this.Wwwwwwwwwwwwwwwwwwwwww.call());
            if (this.Wwwwwwwwwwwwwwwwwwwwwww.compareAndSet(wwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                wwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwww2;
                break;
            }
        }
        boolean z = !wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.get() && wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.compareAndSet(false, true);
        try {
            x60Var.accept(wwwwwwwwwwwwwwwwwwwwwwwwww);
            if (!z) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(wwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (Throwable th) {
            if (z) {
                wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww.compareAndSet(true, false);
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
    }

    public static <T> gd0<T> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h60Var, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MAX_VALUE, j, timeUnit, k60Var));
    }
}
