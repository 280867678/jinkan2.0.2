package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.sc0;

/* loaded from: classes4.dex */
public final class FlowableGroupBy$State<T, K> extends BasicIntQueueSubscription<T> implements r51<T> {
    public static final long serialVersionUID = -3852313036005250360L;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final K key;
    public boolean outputFused;
    public final FlowableGroupBy$GroupBySubscriber<?, K, T> parent;
    public int produced;
    public final sc0<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicReference<s51<? super T>> actual = new AtomicReference<>();
    public final AtomicBoolean once = new AtomicBoolean();

    public FlowableGroupBy$State(int i, FlowableGroupBy$GroupBySubscriber<?, K, T> flowableGroupBy$GroupBySubscriber, K k, boolean z) {
        this.queue = new sc0<>(i);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = k;
        this.delayError = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            this.parent.cancel(this.key);
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<? super T> s51Var, boolean z3) {
        if (this.cancelled.get()) {
            this.queue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.error;
                if (th != null) {
                    s51Var.onError(th);
                } else {
                    s51Var.onComplete();
                }
                return true;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                s51Var.onError(th2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                s51Var.onComplete();
                return true;
            }
        }
    }

    @Override // me.tvspark.t70
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void drainFused() {
        Throwable th;
        sc0<T> sc0Var = this.queue;
        s51<? super T> s51Var = this.actual.get();
        int i = 1;
        while (true) {
            if (s51Var != null) {
                if (this.cancelled.get()) {
                    sc0Var.clear();
                    return;
                }
                boolean z = this.done;
                if (z && !this.delayError && (th = this.error) != null) {
                    sc0Var.clear();
                    s51Var.onError(th);
                    return;
                }
                s51Var.onNext(null);
                if (z) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        s51Var.onError(th2);
                        return;
                    } else {
                        s51Var.onComplete();
                        return;
                    }
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
            if (s51Var == null) {
                s51Var = this.actual.get();
            }
        }
    }

    public void drainNormal() {
        int i;
        sc0<T> sc0Var = this.queue;
        boolean z = this.delayError;
        s51<? super T> s51Var = this.actual.get();
        int i2 = 1;
        while (true) {
            if (s51Var != null) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z2 = this.done;
                    Object obj = (T) sc0Var.mo4868poll();
                    boolean z3 = obj == null;
                    if (checkTerminated(z2, z3, s51Var, z)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    s51Var.onNext(obj);
                    j2++;
                }
                if (i == 0 && checkTerminated(this.done, sc0Var.isEmpty(), s51Var, z)) {
                    return;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    this.parent.f4376s.request(j2);
                }
            }
            i2 = addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
            if (s51Var == null) {
                s51Var = this.actual.get();
            }
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.queue.isEmpty();
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

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() {
        T mo4868poll = this.queue.mo4868poll();
        if (mo4868poll != null) {
            this.produced++;
            return mo4868poll;
        }
        int i = this.produced;
        if (i == 0) {
            return null;
        }
        this.produced = 0;
        this.parent.f4376s.request(i);
        return null;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    @Override // me.tvspark.r51
    public void subscribe(s51<? super T> s51Var) {
        if (!this.once.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("Only one Subscriber allowed!"), s51Var);
            return;
        }
        s51Var.onSubscribe(this);
        this.actual.lazySet(s51Var);
        drain();
    }
}
