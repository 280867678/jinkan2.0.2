package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.k60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = -5677354903406201275L;
    public final s51<? super T> actual;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final sc0<Object> queue;
    public final AtomicLong requested = new AtomicLong();

    /* renamed from: s */
    public t51 f4403s;
    public final k60 scheduler;
    public final long time;
    public final TimeUnit unit;

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(s51<? super T> s51Var, long j, long j2, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
        this.actual = s51Var;
        this.count = j;
        this.time = j2;
        this.unit = timeUnit;
        this.scheduler = k60Var;
        this.queue = new sc0<>(i);
        this.delayError = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f4403s.cancel();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, s51<? super T> s51Var, boolean z2) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (z2) {
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                s51Var.onError(th);
            } else {
                s51Var.onComplete();
            }
            return true;
        } else {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                s51Var.onError(th2);
                return true;
            } else if (!z) {
                return false;
            } else {
                s51Var.onComplete();
                return true;
            }
        }
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        s51<? super T> s51Var = this.actual;
        sc0<Object> sc0Var = this.queue;
        boolean z = this.delayError;
        int i = 1;
        do {
            if (this.done) {
                if (checkTerminated(sc0Var.isEmpty(), s51Var, z)) {
                    return;
                }
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    if (checkTerminated(sc0Var.peek() == null, s51Var, z)) {
                        return;
                    }
                    if (j != j2) {
                        sc0Var.mo4868poll();
                        s51Var.onNext(sc0Var.mo4868poll());
                        j2++;
                    } else if (j2 != 0) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j2);
                    }
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        trim(this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit), this.queue);
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.delayError) {
            trim(this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit), this.queue);
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        sc0<Object> sc0Var = this.queue;
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit);
        sc0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), t);
        trim(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sc0Var);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4403s, t51Var)) {
            this.f4403s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            drain();
        }
    }

    public void trim(long j, sc0<Object> sc0Var) {
        long j2 = this.time;
        long j3 = this.count;
        boolean z = j3 == Long.MAX_VALUE;
        while (!sc0Var.isEmpty()) {
            if (((Long) sc0Var.peek()).longValue() >= j - j2 && (z || (sc0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >> 1) <= j3)) {
                return;
            }
            sc0Var.mo4868poll();
            sc0Var.mo4868poll();
        }
    }
}
