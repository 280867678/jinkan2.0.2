package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements s51<T>, t51 {
    public static final long serialVersionUID = 7240042530241604978L;
    public final s51<? super T> actual;
    public volatile boolean cancelled;
    public final int count;
    public volatile boolean done;

    /* renamed from: s */
    public t51 f4401s;
    public final AtomicLong requested = new AtomicLong();
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableTakeLast$TakeLastSubscriber(s51<? super T> s51Var, int i) {
        this.actual = s51Var;
        this.count = i;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.cancelled = true;
        this.f4401s.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            s51<? super T> s51Var = this.actual;
            long j = this.requested.get();
            while (!this.cancelled) {
                if (this.done) {
                    long j2 = 0;
                    while (j2 != j) {
                        if (this.cancelled) {
                            return;
                        }
                        Object obj = (T) poll();
                        if (obj == null) {
                            s51Var.onComplete();
                            return;
                        } else {
                            s51Var.onNext(obj);
                            j2++;
                        }
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        j = this.requested.addAndGet(-j2);
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.count == size()) {
            poll();
        }
        offer(t);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4401s, t51Var)) {
            this.f4401s = t51Var;
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
