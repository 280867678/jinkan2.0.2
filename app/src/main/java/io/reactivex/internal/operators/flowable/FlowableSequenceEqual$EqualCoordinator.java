package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t70;
import me.tvspark.t80;
import me.tvspark.u60;

/* loaded from: classes4.dex */
public final class FlowableSequenceEqual$EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements t80 {
    public static final long serialVersionUID = -6178010334400373240L;
    public final u60<? super T, ? super T> comparer;
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* renamed from: v1 */
    public T f4391v1;

    /* renamed from: v2 */
    public T f4392v2;
    public final AtomicInteger wip = new AtomicInteger();
    public final AtomicThrowable error = new AtomicThrowable();

    public FlowableSequenceEqual$EqualCoordinator(s51<? super Boolean> s51Var, int i, u60<? super T, ? super T> u60Var) {
        super(s51Var);
        this.comparer = u60Var;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
    public void cancel() {
        super.cancel();
        this.first.cancel();
        this.second.cancel();
        if (this.wip.getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // me.tvspark.t80
    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            t70<T> t70Var = this.first.queue;
            t70<T> t70Var2 = this.second.queue;
            if (t70Var != null && t70Var2 != null) {
                while (!isCancelled()) {
                    if (this.error.get() != null) {
                        cancelAndClear();
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    boolean z = this.first.done;
                    T t = this.f4391v1;
                    if (t == null) {
                        try {
                            t = t70Var.mo4868poll();
                            this.f4391v1 = t;
                        } catch (Throwable th) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                            cancelAndClear();
                            this.error.addThrowable(th);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                    boolean z2 = t == null;
                    boolean z3 = this.second.done;
                    T t2 = this.f4392v2;
                    if (t2 == null) {
                        try {
                            t2 = t70Var2.mo4868poll();
                            this.f4392v2 = t2;
                        } catch (Throwable th2) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                            cancelAndClear();
                            this.error.addThrowable(th2);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                    boolean z4 = t2 == null;
                    if (z && z3 && z2 && z4) {
                        complete(true);
                        return;
                    } else if (z && z3 && z2 != z4) {
                        cancelAndClear();
                        complete(false);
                        return;
                    } else if (!z2 && !z4) {
                        try {
                            if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.comparer) != null) {
                                if (!l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, t2)) {
                                    cancelAndClear();
                                    complete(false);
                                    return;
                                }
                                this.f4391v1 = null;
                                this.f4392v2 = null;
                                this.first.request();
                                this.second.request();
                            } else {
                                throw null;
                            }
                        } catch (Throwable th3) {
                            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th3);
                            cancelAndClear();
                            this.error.addThrowable(th3);
                            this.actual.onError(this.error.terminate());
                            return;
                        }
                    }
                }
                this.first.clear();
                this.second.clear();
                return;
            } else if (isCancelled()) {
                this.first.clear();
                this.second.clear();
                return;
            } else if (this.error.get() != null) {
                cancelAndClear();
                this.actual.onError(this.error.terminate());
                return;
            }
            i = this.wip.addAndGet(-i);
        } while (i != 0);
    }

    @Override // me.tvspark.t80
    public void innerError(Throwable th) {
        if (this.error.addThrowable(th)) {
            drain();
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    public void subscribe(r51<? extends T> r51Var, r51<? extends T> r51Var2) {
        r51Var.subscribe(this.first);
        r51Var2.subscribe(this.second);
    }
}
