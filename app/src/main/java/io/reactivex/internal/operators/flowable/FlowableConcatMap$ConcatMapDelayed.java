package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableConcatMap$ConcatMapDelayed<T, R> extends FlowableConcatMap$BaseConcatMapSubscriber<T, R> {
    public static final long serialVersionUID = -2945777694260521066L;
    public final s51<? super R> actual;
    public final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(s51<? super R> s51Var, f70<? super T, ? extends r51<? extends R>> f70Var, int i, boolean z) {
        super(f70Var, i);
        this.actual = s51Var;
        this.veryEnd = z;
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
        if (getAndIncrement() == 0) {
            while (!this.cancelled) {
                if (!this.active) {
                    boolean z = this.done;
                    if (!z || this.veryEnd || this.errors.get() == null) {
                        try {
                            T mo4868poll = this.queue.mo4868poll();
                            boolean z2 = mo4868poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.actual.onError(terminate);
                                    return;
                                } else {
                                    this.actual.onComplete();
                                    return;
                                }
                            } else if (!z2) {
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
                                    Object call = ((Callable) r51Var).call();
                                    if (call == null) {
                                        continue;
                                    } else if (this.inner.isUnbounded()) {
                                        this.actual.onNext(call);
                                    } else {
                                        this.active = true;
                                        FlowableConcatMap$ConcatMapInner<R> flowableConcatMap$ConcatMapInner = this.inner;
                                        flowableConcatMap$ConcatMapInner.setSubscription(new m80(call, flowableConcatMap$ConcatMapInner));
                                    }
                                } else {
                                    this.active = true;
                                    r51Var.subscribe(this.inner);
                                }
                            }
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            this.f4362s.cancel();
                            this.errors.addThrowable(th);
                        }
                    }
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                if (decrementAndGet() == 0) {
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
        if (!this.veryEnd) {
            this.f4362s.cancel();
            this.done = true;
        }
        this.active = false;
        drain();
    }

    @Override // me.tvspark.l80
    public void innerNext(R r) {
        this.actual.onNext(r);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        drain();
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
