package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.sc0;

/* loaded from: classes4.dex */
public final class FlowableCombineLatest$CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
    public static final long serialVersionUID = -5082275438355852221L;
    public final s51<? super R> actual;
    public volatile boolean cancelled;
    public final f70<? super Object[], ? extends R> combiner;
    public int completedSources;
    public final boolean delayErrors;
    public volatile boolean done;
    public final AtomicReference<Throwable> error;
    public final Object[] latest;
    public int nonEmptySources;
    public boolean outputFused;
    public final sc0<Object> queue;
    public final AtomicLong requested;
    public final FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(s51<? super R> s51Var, f70<? super Object[], ? extends R> f70Var, int i, int i2, boolean z) {
        this.actual = s51Var;
        this.combiner = f70Var;
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = new FlowableCombineLatest$CombineLatestInnerSubscriber[i];
        for (int i3 = 0; i3 < i; i3++) {
            flowableCombineLatest$CombineLatestInnerSubscriberArr[i3] = new FlowableCombineLatest$CombineLatestInnerSubscriber<>(this, i3, i2);
        }
        this.subscribers = flowableCombineLatest$CombineLatestInnerSubscriberArr;
        this.latest = new Object[i];
        this.queue = new sc0<>(i2);
        this.requested = new AtomicLong();
        this.error = new AtomicReference<>();
        this.delayErrors = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        cancelAll();
    }

    public void cancelAll() {
        for (FlowableCombineLatest$CombineLatestInnerSubscriber<T> flowableCombineLatest$CombineLatestInnerSubscriber : this.subscribers) {
            flowableCombineLatest$CombineLatestInnerSubscriber.cancel();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, s51<?> s51Var, sc0<?> sc0Var) {
        if (this.cancelled) {
            cancelAll();
            sc0Var.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (this.delayErrors) {
                if (!z2) {
                    return false;
                }
                Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    s51Var.onComplete();
                } else {
                    s51Var.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
                return true;
            }
            Throwable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                cancelAll();
                sc0Var.clear();
                s51Var.onError(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                return true;
            } else if (!z2) {
                return false;
            } else {
                cancelAll();
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
            drainOutput();
        } else {
            drainAsync();
        }
    }

    public void drainAsync() {
        int i;
        s51<? super R> s51Var = this.actual;
        sc0<?> sc0Var = this.queue;
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
                Object mo4868poll = sc0Var.mo4868poll();
                boolean z2 = mo4868poll == null;
                if (checkTerminated(z, z2, s51Var, sc0Var)) {
                    return;
                }
                if (z2) {
                    break;
                }
                try {
                    Object obj = (R) this.combiner.apply((Object[]) sc0Var.mo4868poll());
                    l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, "The combiner returned a null value");
                    s51Var.onNext(obj);
                    ((FlowableCombineLatest$CombineLatestInnerSubscriber) mo4868poll).requestOne();
                    j2++;
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    cancelAll();
                    ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th);
                    s51Var.onError(ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error));
                    return;
                }
            }
            if (i == 0 && checkTerminated(this.done, sc0Var.isEmpty(), s51Var, sc0Var)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    public void drainOutput() {
        s51<? super R> s51Var = this.actual;
        sc0<Object> sc0Var = this.queue;
        int i = 1;
        while (!this.cancelled) {
            Throwable th = this.error.get();
            if (th != null) {
                sc0Var.clear();
                s51Var.onError(th);
                return;
            }
            boolean z = this.done;
            boolean isEmpty = sc0Var.isEmpty();
            if (!isEmpty) {
                s51Var.onNext(null);
            }
            if (z && isEmpty) {
                s51Var.onComplete();
                return;
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        sc0Var.clear();
    }

    public void innerComplete(int i) {
        int i2;
        synchronized (this) {
            Object[] objArr = this.latest;
            if (objArr[i] != null && (i2 = this.completedSources + 1) != objArr.length) {
                this.completedSources = i2;
                return;
            }
            this.done = true;
            drain();
        }
    }

    public void innerError(int i, Throwable th) {
        if (!ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.error, th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        } else if (this.delayErrors) {
            innerComplete(i);
        } else {
            cancelAll();
            this.done = true;
            drain();
        }
    }

    public void innerValue(int i, T t) {
        boolean z;
        synchronized (this) {
            Object[] objArr = this.latest;
            int i2 = this.nonEmptySources;
            if (objArr[i] == null) {
                i2++;
                this.nonEmptySources = i2;
            }
            objArr[i] = t;
            if (objArr.length == i2) {
                this.queue.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.subscribers[i], objArr.clone());
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.subscribers[i].requestOne();
        } else {
            drain();
        }
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public R mo4868poll() throws Exception {
        Object mo4868poll = this.queue.mo4868poll();
        if (mo4868poll == null) {
            return null;
        }
        R apply = this.combiner.apply((Object[]) this.queue.mo4868poll());
        ((FlowableCombineLatest$CombineLatestInnerSubscriber) mo4868poll).requestOne();
        return apply;
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
        boolean z = false;
        if ((i & 4) != 0) {
            return 0;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            z = true;
        }
        this.outputFused = z;
        return i2;
    }

    public void subscribe(r51<? extends T>[] r51VarArr, int i) {
        FlowableCombineLatest$CombineLatestInnerSubscriber<T>[] flowableCombineLatest$CombineLatestInnerSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < i && !this.done && !this.cancelled; i2++) {
            r51VarArr[i2].subscribe(flowableCombineLatest$CombineLatestInnerSubscriberArr[i2]);
        }
    }
}
