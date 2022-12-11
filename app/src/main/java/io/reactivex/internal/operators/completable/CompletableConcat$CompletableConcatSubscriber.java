package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.q70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.sc0;
import me.tvspark.t51;
import me.tvspark.t70;
import me.tvspark.u50;
import me.tvspark.v50;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class CompletableConcat$CompletableConcatSubscriber extends AtomicInteger implements s51<v50>, p60 {
    public static final long serialVersionUID = 9032184911934499404L;
    public volatile boolean active;
    public final u50 actual;
    public int consumed;
    public volatile boolean done;
    public final int limit;
    public final int prefetch;
    public t70<v50> queue;

    /* renamed from: s */
    public t51 f4351s;
    public int sourceFused;
    public final ConcatInnerObserver inner = new ConcatInnerObserver(this);
    public final AtomicBoolean once = new AtomicBoolean();

    /* loaded from: classes4.dex */
    public static final class ConcatInnerObserver extends AtomicReference<p60> implements u50 {
        public static final long serialVersionUID = -5454794857847146511L;
        public final CompletableConcat$CompletableConcatSubscriber parent;

        public ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber completableConcat$CompletableConcatSubscriber) {
            this.parent = completableConcat$CompletableConcatSubscriber;
        }

        @Override // me.tvspark.u50
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // me.tvspark.u50
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // me.tvspark.u50
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.replace(this, p60Var);
        }
    }

    public CompletableConcat$CompletableConcatSubscriber(u50 u50Var, int i) {
        this.actual = u50Var;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4351s.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        while (!isDisposed()) {
            if (!this.active) {
                boolean z = this.done;
                try {
                    v50 mo4868poll = this.queue.mo4868poll();
                    boolean z2 = mo4868poll == null;
                    if (z && z2) {
                        if (!this.once.compareAndSet(false, true)) {
                            return;
                        }
                        this.actual.onComplete();
                        return;
                    } else if (!z2) {
                        this.active = true;
                        mo4868poll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.inner);
                        request();
                    }
                } catch (Throwable th) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                    innerError(th);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
    }

    public void innerComplete() {
        this.active = false;
        drain();
    }

    public void innerError(Throwable th) {
        if (!this.once.compareAndSet(false, true)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.f4351s.cancel();
        this.actual.onError(th);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.inner.get());
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.once.compareAndSet(false, true)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        DisposableHelper.dispose(this.inner);
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(v50 v50Var) {
        if (this.sourceFused != 0 || this.queue.offer(v50Var)) {
            drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4351s, t51Var)) {
            this.f4351s = t51Var;
            int i = this.prefetch;
            long j = i == Integer.MAX_VALUE ? Long.MAX_VALUE : i;
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceFused = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    this.actual.onSubscribe(this);
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceFused = requestFusion;
                    this.queue = q70Var;
                    this.actual.onSubscribe(this);
                    t51Var.request(j);
                    return;
                }
            }
            this.queue = this.prefetch == Integer.MAX_VALUE ? new sc0<>(x50.Wwwwwwwwwwwwwwwwwwwwwwww) : new SpscArrayQueue<>(this.prefetch);
            this.actual.onSubscribe(this);
            t51Var.request(j);
        }
    }

    public void request() {
        if (this.sourceFused != 1) {
            int i = this.consumed + 1;
            if (i != this.limit) {
                this.consumed = i;
                return;
            }
            this.consumed = 0;
            this.f4351s.request(i);
        }
    }
}
