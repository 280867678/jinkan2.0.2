package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.k60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public abstract class FlowableObserveOn$BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements Runnable, s51<T> {
    public static final long serialVersionUID = -8241002408341274697L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public boolean outputFused;
    public final int prefetch;
    public long produced;
    public t70<T> queue;
    public final AtomicLong requested = new AtomicLong();

    /* renamed from: s */
    public t51 f4377s;
    public int sourceMode;
    public final k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(k60.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, boolean z, int i) {
        this.worker = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.delayError = z;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // me.tvspark.t51
    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.f4377s.cancel();
        this.worker.dispose();
        if (getAndIncrement() != 0) {
            return;
        }
        this.queue.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r3 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var) {
        Throwable th;
        if (this.cancelled) {
            clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!this.delayError) {
                th = this.error;
                if (th != null) {
                    clear();
                    s51Var.onError(th);
                } else {
                    if (!z2) {
                        return false;
                    }
                    s51Var.onComplete();
                }
            } else if (!z2) {
                return false;
            } else {
                th = this.error;
            }
            this.worker.dispose();
            return true;
        }
    }

    @Override // me.tvspark.t70
    public final void clear() {
        this.queue.clear();
    }

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // me.tvspark.s51
    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            trySchedule();
        }
    }

    @Override // me.tvspark.s51
    public final void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.error = th;
        this.done = true;
        trySchedule();
    }

    @Override // me.tvspark.s51
    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (this.sourceMode == 2) {
            trySchedule();
            return;
        }
        if (!this.queue.offer(t)) {
            this.f4377s.cancel();
            this.error = new MissingBackpressureException("Queue is full?!");
            this.done = true;
        }
        trySchedule();
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            trySchedule();
        }
    }

    @Override // me.tvspark.p70
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.outputFused) {
            runBackfused();
        } else if (this.sourceMode == 1) {
            runSync();
        } else {
            runAsync();
        }
    }

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        if (getAndIncrement() != 0) {
            return;
        }
        this.worker.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}
