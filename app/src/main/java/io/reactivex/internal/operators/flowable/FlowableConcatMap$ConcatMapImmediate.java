package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableConcatMap$ConcatMapImmediate<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    public static final long serialVersionUID = 7898995095634264146L;
    public final s51<? super R> actual;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatMap$ConcatMapImmediate(s51<? super R> s51Var, f70<? super T, ? extends r51<? extends R>> f70Var, int i) {
        super(f70Var, i);
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.inner.cancel();
            this.f4362s.cancel();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T mo4868poll = this.queue.mo4868poll();
                        boolean z2 = mo4868poll == null;
                        if (z && z2) {
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                r51<? extends R> apply = this.mapper.apply(mo4868poll);
                                l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null Publisher");
                                r51<? extends R> r51Var = apply;
                                if (this.sourceMode != 1) {
                                    int i = this.consumed + 1;
                                    if (i == this.limit) {
                                        this.consumed = 0;
                                        this.f4362s.request(i);
                                    } else {
                                        this.consumed = i;
                                    }
                                }
                                if (r51Var instanceof Callable) {
                                    try {
                                        Object call = ((Callable) r51Var).call();
                                        if (call == null) {
                                            continue;
                                        } else if (!this.inner.isUnbounded()) {
                                            this.active = true;
                                            FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                            flowableConcatMap$ConcatMapInner.setSubscription(new m80(call, flowableConcatMap$ConcatMapInner));
                                        } else if (get() == 0 && compareAndSet(0, 1)) {
                                            this.actual.onNext(call);
                                            if (!compareAndSet(1, 0)) {
                                                this.actual.onError(this.errors.terminate());
                                                return;
                                            }
                                        }
                                    } catch (Throwable th) {
                                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                                        this.f4362s.cancel();
                                        this.errors.addThrowable(th);
                                        this.actual.onError(this.errors.terminate());
                                        return;
                                    }
                                } else {
                                    this.active = true;
                                    r51Var.subscribe(this.inner);
                                }
                            } catch (Throwable th2) {
                                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                                this.f4362s.cancel();
                                this.errors.addThrowable(th2);
                                this.actual.onError(this.errors.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                        this.f4362s.cancel();
                        this.errors.addThrowable(th3);
                        this.actual.onError(this.errors.terminate());
                        return;
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    @Override // me.tvspark.l80
    public void innerError(Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.f4362s.cancel();
        if (getAndIncrement() != 0) {
            return;
        }
        this.actual.onError(this.errors.terminate());
    }

    @Override // me.tvspark.l80
    public void innerNext(R r) {
        if (get() != 0 || !compareAndSet(0, 1)) {
            return;
        }
        this.actual.onNext(r);
        if (compareAndSet(1, 0)) {
            return;
        }
        this.actual.onError(this.errors.terminate());
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.inner.cancel();
        if (getAndIncrement() != 0) {
            return;
        }
        this.actual.onError(this.errors.terminate());
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        this.inner.request(j);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber
    public void subscribeActual() {
        this.actual.onSubscribe(this);
    }
}
