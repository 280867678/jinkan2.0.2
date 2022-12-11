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
public final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = -5677354903406201275L;
    public final s51<? super T> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final sc0<Object> queue;
    public final AtomicLong requested = new AtomicLong();

    /* renamed from: s */
    public t51 f4397s;
    public final k60 scheduler;
    public final long time;
    public final TimeUnit unit;

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(s51<? super T> s51Var, long j, TimeUnit timeUnit, k60 k60Var, int i, boolean z) {
        this.actual = s51Var;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = k60Var;
        this.queue = new sc0<>(i);
        this.delayError = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f4397s.cancel();
            if (getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<? super T> s51Var, boolean z3) {
        if (this.cancelled) {
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

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        s51<? super T> s51Var = this.actual;
        sc0<Object> sc0Var = this.queue;
        boolean z = this.delayError;
        TimeUnit timeUnit = this.unit;
        k60 k60Var = this.scheduler;
        long j = this.time;
        int i = 1;
        do {
            long j2 = this.requested.get();
            long j3 = 0;
            while (j3 != j2) {
                boolean z2 = this.done;
                Long l = (Long) sc0Var.peek();
                boolean z3 = l == null;
                boolean z4 = (z3 || l.longValue() <= k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(timeUnit) - j) ? z3 : true;
                if (checkTerminated(z2, z4, s51Var, z)) {
                    return;
                }
                if (z4) {
                    break;
                }
                sc0Var.mo4868poll();
                s51Var.onNext(sc0Var.mo4868poll());
                j3++;
            }
            if (j3 != 0) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j3);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Long.valueOf(this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.unit)), t);
        drain();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4397s, t51Var)) {
            this.f4397s = t51Var;
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
}
