package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.f70;
import me.tvspark.l80;
import me.tvspark.q70;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements s51<T>, l80<R>, t51 {
    public static final long serialVersionUID = -3511336836796789179L;
    public volatile boolean active;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final int limit;
    public final f70<? super T, ? extends r51<? extends R>> mapper;
    public final int prefetch;
    public t70<T> queue;

    /* renamed from: s */
    public t51 f4362s;
    public int sourceMode;
    public final FlowableConcatMap$ConcatMapInner<R> inner = new FlowableConcatMap$ConcatMapInner<>(this);
    public final AtomicThrowable errors = new AtomicThrowable();

    public FlowableConcatMap$BaseConcatMapSubscriber(f70<? super T, ? extends r51<? extends R>> f70Var, int i) {
        this.mapper = f70Var;
        this.prefetch = i;
        this.limit = i - (i >> 2);
    }

    public abstract void drain();

    @Override // me.tvspark.l80
    public final void innerComplete() {
        this.active = false;
        drain();
    }

    @Override // me.tvspark.s51
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public final void onNext(T t) {
        if (this.sourceMode == 2 || this.queue.offer(t)) {
            drain();
            return;
        }
        this.f4362s.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    @Override // me.tvspark.s51
    public final void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4362s, t51Var)) {
            this.f4362s = t51Var;
            if (t51Var instanceof q70) {
                q70 q70Var = (q70) t51Var;
                int requestFusion = q70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    this.done = true;
                    subscribeActual();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = q70Var;
                    subscribeActual();
                    t51Var.request(this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            t51Var.request(this.prefetch);
        }
    }

    public abstract void subscribeActual();
}
