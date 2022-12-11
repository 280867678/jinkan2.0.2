package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements s51<T>, t51 {
    public static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    public static final long serialVersionUID = -3491074160481096299L;
    public final s51<? super R> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final f70<? super T, ? extends r51<? extends R>> mapper;

    /* renamed from: s */
    public t51 f4400s;
    public volatile long unique;
    public final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final AtomicThrowable error = new AtomicThrowable();

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = new FlowableSwitchMap$SwitchMapInnerSubscriber<>(null, -1L, 1);
        CANCELLED = flowableSwitchMap$SwitchMapInnerSubscriber;
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(s51<? super R> s51Var, f70<? super T, ? extends r51<? extends R>> f70Var, int i, boolean z) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.bufferSize = i;
        this.delayErrors = z;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.f4400s.cancel();
            disposeInner();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber3 = CANCELLED;
        if (flowableSwitchMap$SwitchMapInnerSubscriber2 == flowableSwitchMap$SwitchMapInnerSubscriber3 || (flowableSwitchMap$SwitchMapInnerSubscriber = (FlowableSwitchMap$SwitchMapInnerSubscriber) this.active.getAndSet(flowableSwitchMap$SwitchMapInnerSubscriber3)) == CANCELLED || flowableSwitchMap$SwitchMapInnerSubscriber == null) {
            return;
        }
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public void drain() {
        boolean z;
        R r;
        if (getAndIncrement() != 0) {
            return;
        }
        s51<? super R> s51Var = this.actual;
        int i = 1;
        while (!this.cancelled) {
            if (this.done) {
                if (this.delayErrors) {
                    if (this.active.get() == null) {
                        if (this.error.get() != null) {
                            s51Var.onError(this.error.terminate());
                            return;
                        } else {
                            s51Var.onComplete();
                            return;
                        }
                    }
                } else if (this.error.get() != null) {
                    disposeInner();
                    s51Var.onError(this.error.terminate());
                    return;
                } else if (this.active.get() == null) {
                    s51Var.onComplete();
                    return;
                }
            }
            FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
            t70<R> t70Var = flowableSwitchMap$SwitchMapInnerSubscriber != null ? flowableSwitchMap$SwitchMapInnerSubscriber.queue : null;
            if (t70Var != null) {
                if (flowableSwitchMap$SwitchMapInnerSubscriber.done) {
                    if (!this.delayErrors) {
                        if (this.error.get() != null) {
                            disposeInner();
                            s51Var.onError(this.error.terminate());
                            return;
                        } else if (t70Var.isEmpty()) {
                            this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                        }
                    } else if (t70Var.isEmpty()) {
                        this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                    }
                }
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    z = false;
                    if (j2 != j) {
                        if (!this.cancelled) {
                            boolean z2 = flowableSwitchMap$SwitchMapInnerSubscriber.done;
                            try {
                                r = t70Var.mo4868poll();
                            } catch (Throwable th) {
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
                                this.error.addThrowable(th);
                                r = (Object) null;
                                z2 = true;
                            }
                            boolean z3 = r == null;
                            if (flowableSwitchMap$SwitchMapInnerSubscriber != this.active.get()) {
                                break;
                            }
                            if (z2) {
                                if (this.delayErrors) {
                                    if (z3) {
                                        break;
                                    }
                                } else if (this.error.get() == null) {
                                    if (z3) {
                                        break;
                                    }
                                } else {
                                    s51Var.onError(this.error.terminate());
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            s51Var.onNext(r);
                            j2++;
                        } else {
                            return;
                        }
                    } else {
                        break;
                    }
                }
                this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, null);
                z = true;
                if (j2 != 0 && !this.cancelled) {
                    if (j != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j2);
                    }
                    flowableSwitchMap$SwitchMapInnerSubscriber.get().request(j2);
                }
                if (z) {
                    continue;
                }
            }
            i = addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
        this.active.lazySet(null);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done || !this.error.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        this.done = true;
        drain();
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber;
        if (this.done) {
            return;
        }
        long j = this.unique + 1;
        this.unique = j;
        FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
        if (flowableSwitchMap$SwitchMapInnerSubscriber2 != null) {
            flowableSwitchMap$SwitchMapInnerSubscriber2.cancel();
        }
        try {
            r51<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The publisher returned is null");
            r51<? extends R> r51Var = apply;
            FlowableSwitchMap$SwitchMapInnerSubscriber<T, R> flowableSwitchMap$SwitchMapInnerSubscriber3 = new FlowableSwitchMap$SwitchMapInnerSubscriber<>(this, j, this.bufferSize);
            do {
                flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
                if (flowableSwitchMap$SwitchMapInnerSubscriber == CANCELLED) {
                    return;
                }
            } while (!this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, flowableSwitchMap$SwitchMapInnerSubscriber3));
            r51Var.subscribe(flowableSwitchMap$SwitchMapInnerSubscriber3);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4400s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4400s, t51Var)) {
            this.f4400s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.requested, j);
            if (this.unique == 0) {
                this.f4400s.request(Long.MAX_VALUE);
            } else {
                drain();
            }
        }
    }
}
