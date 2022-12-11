package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.h60;
import me.tvspark.hd0;
import me.tvspark.j60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.sc0;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableGroupBy<T, K, V> extends x80<T, hd0<K, V>> {
    public final boolean Wwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends V> Wwwwwwwwwwwwwwwwwwwwww;
    public final f70<? super T, ? extends K> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements j60<T>, p60 {
        public static final Object NULL_KEY = new Object();
        public static final long serialVersionUID = -3688291656102519502L;
        public final j60<? super hd0<K, V>> actual;
        public final int bufferSize;
        public final boolean delayError;
        public final f70<? super T, ? extends K> keySelector;

        /* renamed from: s */
        public p60 f4433s;
        public final f70<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final Map<Object, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(j60<? super hd0<K, V>> j60Var, f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, int i, boolean z) {
            this.actual = j60Var;
            this.keySelector = f70Var;
            this.valueSelector = f70Var2;
            this.bufferSize = i;
            this.delayError = z;
            lazySet(1);
        }

        public void cancel(K k) {
            if (k == null) {
                k = (K) NULL_KEY;
            }
            this.groups.remove(k);
            if (decrementAndGet() == 0) {
                this.f4433s.dispose();
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled.compareAndSet(false, true) || decrementAndGet() != 0) {
                return;
            }
            this.f4433s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next()).Wwwwwwwwwwwwwwwwwwwwwww.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) it.next()).Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            try {
                K apply = this.keySelector.apply(t);
                Object obj = apply != null ? apply : NULL_KEY;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, V> wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.groups.get(obj);
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<>(apply, new State(this.bufferSize, this, apply, this.delayError));
                    this.groups.put(obj, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    getAndIncrement();
                    this.actual.onNext(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                V apply2 = this.valueSelector.apply(t);
                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply2, "The value supplied is null");
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.onNext(apply2);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.f4433s.dispose();
                onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4433s, p60Var)) {
                this.f4433s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class State<T, K> extends AtomicInteger implements p60, h60<T> {
        public static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupByObserver<?, K, T> parent;
        public final sc0<T> queue;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicReference<j60<? super T>> actual = new AtomicReference<>();

        public State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new sc0<>(i);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        public boolean checkTerminated(boolean z, boolean z2, j60<? super T> j60Var, boolean z3) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                this.actual.lazySet(null);
                return true;
            } else if (!z) {
                return false;
            } else {
                if (z3) {
                    if (!z2) {
                        return false;
                    }
                    Throwable th = this.error;
                    this.actual.lazySet(null);
                    if (th != null) {
                        j60Var.onError(th);
                    } else {
                        j60Var.onComplete();
                    }
                    return true;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    this.actual.lazySet(null);
                    j60Var.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.actual.lazySet(null);
                    j60Var.onComplete();
                    return true;
                }
            }
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (!this.cancelled.compareAndSet(false, true) || getAndIncrement() != 0) {
                return;
            }
            this.actual.lazySet(null);
            this.parent.cancel(this.key);
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            sc0<T> sc0Var = this.queue;
            boolean z = this.delayError;
            j60<? super T> j60Var = this.actual.get();
            int i = 1;
            while (true) {
                if (j60Var != null) {
                    while (true) {
                        boolean z2 = this.done;
                        Object obj = (T) sc0Var.mo4868poll();
                        boolean z3 = obj == null;
                        if (checkTerminated(z2, z3, j60Var, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        j60Var.onNext(obj);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (j60Var == null) {
                    j60Var = this.actual.get();
                }
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // me.tvspark.h60
        public void subscribe(j60<? super T> j60Var) {
            if (!this.once.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), j60Var);
                return;
            }
            j60Var.onSubscribe(this);
            this.actual.lazySet(j60Var);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                drain();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<K, T> extends hd0<K, T> {
        public final State<T, K> Wwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(K k, State<T, K> state) {
            super(k);
            this.Wwwwwwwwwwwwwwwwwwwwwww = state;
        }

        @Override // me.tvspark.d60
        public void subscribeActual(j60<? super T> j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(j60Var);
        }
    }

    public ObservableGroupBy(h60<T> h60Var, f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, int i, boolean z) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = f70Var2;
        this.Wwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super hd0<K, V>> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new GroupByObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww));
    }
}
