package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.o80;
import me.tvspark.q60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableGroupBy$GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<q60<K, V>> implements s51<T> {
    public static final Object NULL_KEY = new Object();
    public static final long serialVersionUID = -3688291656102519502L;
    public final s51<? super q60<K, V>> actual;
    public final int bufferSize;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final f70<? super T, ? extends K> keySelector;
    public boolean outputFused;
    public final sc0<q60<K, V>> queue;

    /* renamed from: s */
    public t51 f4376s;
    public final f70<? super T, ? extends V> valueSelector;
    public final AtomicBoolean cancelled = new AtomicBoolean();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger groupCount = new AtomicInteger(1);
    public final Map<Object, o80<K, V>> groups = new ConcurrentHashMap();

    public FlowableGroupBy$GroupBySubscriber(s51<? super q60<K, V>> s51Var, f70<? super T, ? extends K> f70Var, f70<? super T, ? extends V> f70Var2, int i, boolean z) {
        this.actual = s51Var;
        this.keySelector = f70Var;
        this.valueSelector = f70Var2;
        this.bufferSize = i;
        this.delayError = z;
        this.queue = new sc0<>(i);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled.compareAndSet(false, true) || this.groupCount.decrementAndGet() != 0) {
            return;
        }
        this.f4376s.cancel();
    }

    public void cancel(K k) {
        if (k == null) {
            k = (K) NULL_KEY;
        }
        this.groups.remove(k);
        if (this.groupCount.decrementAndGet() == 0) {
            this.f4376s.cancel();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var, sc0<?> sc0Var) {
        if (this.cancelled.get()) {
            sc0Var.clear();
            return true;
        } else if (this.delayError) {
            if (!z || !z2) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                s51Var.onError(th);
            } else {
                s51Var.onComplete();
            }
            return true;
        } else if (!z) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                sc0Var.clear();
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
        sc0<q60<K, V>> sc0Var = this.queue;
        s51<? super q60<K, V>> s51Var = this.actual;
        int i = 1;
        while (!this.cancelled.get()) {
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
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        sc0Var.clear();
    }

    public void drainNormal() {
        int i;
        sc0<q60<K, V>> sc0Var = this.queue;
        s51<? super q60<K, V>> s51Var = this.actual;
        int i2 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                }
                boolean z = this.done;
                q60<K, V> mo4868poll = sc0Var.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (checkTerminated(z, z2, s51Var, sc0Var)) {
                    return;
                }
                if (z2) {
                    break;
                }
                s51Var.onNext(mo4868poll);
                j2++;
            }
            if (i == 0 && checkTerminated(this.done, sc0Var.isEmpty(), s51Var, sc0Var)) {
                return;
            }
            if (j2 != 0) {
                if (j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                this.f4376s.request(j2);
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.done) {
            for (o80<K, V> o80Var : this.groups.values()) {
                o80Var.Wwwwwwwwwwwwwwwwwwwwww.onComplete();
            }
            this.groups.clear();
            this.done = true;
            drain();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        for (o80<K, V> o80Var : this.groups.values()) {
            o80Var.Wwwwwwwwwwwwwwwwwwwwww.onError(th);
        }
        this.groups.clear();
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        sc0<q60<K, V>> sc0Var = this.queue;
        try {
            K apply = this.keySelector.apply(t);
            boolean z = false;
            Object obj = apply != null ? apply : NULL_KEY;
            o80<K, V> o80Var = this.groups.get(obj);
            if (o80Var == null) {
                if (this.cancelled.get()) {
                    return;
                }
                o80Var = o80.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, this.bufferSize, this, this.delayError);
                this.groups.put(obj, o80Var);
                this.groupCount.getAndIncrement();
                z = true;
            }
            V apply2 = this.valueSelector.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply2, "The valueSelector returned null");
            o80Var.Wwwwwwwwwwwwwwwwwwwwww.onNext(apply2);
            if (!z) {
                return;
            }
            sc0Var.offer(o80Var);
            drain();
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4376s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4376s, t51Var)) {
            this.f4376s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(this.bufferSize);
        }
    }

    @Override // me.tvspark.t70
    /* renamed from: poll  reason: collision with other method in class */
    public q60<K, V> mo4868poll() {
        return this.queue.mo4868poll();
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
}
