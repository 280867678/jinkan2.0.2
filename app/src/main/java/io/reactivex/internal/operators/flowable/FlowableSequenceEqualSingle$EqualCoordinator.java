package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.t70;
import me.tvspark.t80;
import me.tvspark.u60;

/* loaded from: classes4.dex */
public final class FlowableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements p60, t80 {
    public static final long serialVersionUID = -6178010334400373240L;
    public final m60<? super Boolean> actual;
    public final u60<? super T, ? super T> comparer;
    public final AtomicThrowable error = new AtomicThrowable();
    public final FlowableSequenceEqual$EqualSubscriber<T> first;
    public final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* renamed from: v1 */
    public T f4393v1;

    /* renamed from: v2 */
    public T f4394v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(m60<? super Boolean> m60Var, int i, u60<? super T, ? super T> u60Var) {
        this.actual = m60Var;
        this.comparer = u60Var;
        this.first = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
        this.second = new FlowableSequenceEqual$EqualSubscriber<>(this, i);
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        if (getAndIncrement() == 0) {
            this.first.clear();
            this.second.clear();
        }
    }

    @Override // me.tvspark.t80
    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        int i = 1;
        do {
            t70<T> t70Var = this.first.queue;
            t70<T> t70Var2 = this.second.queue;
            if (t70Var != null && t70Var2 != null) {
                while (!isDisposed()) {
                    if (this.error.get() != null) {
                        cancelAndClear();
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    boolean z = this.first.done;
                    T t = this.f4393v1;
                    if (t == null) {
                        try {
                            t = t70Var.mo4868poll();
                            this.f4393v1 = t;
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
                    T t2 = this.f4394v2;
                    if (t2 == null) {
                        try {
                            t2 = t70Var2.mo4868poll();
                            this.f4394v2 = t2;
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
                        this.actual.onSuccess(true);
                        return;
                    } else if (z && z3 && z2 != z4) {
                        cancelAndClear();
                        this.actual.onSuccess(false);
                        return;
                    } else if (!z2 && !z4) {
                        try {
                            if (((l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) this.comparer) != null) {
                                if (!l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, t2)) {
                                    cancelAndClear();
                                    this.actual.onSuccess(false);
                                    return;
                                }
                                this.f4393v1 = null;
                                this.f4394v2 = null;
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
            } else if (isDisposed()) {
                this.first.clear();
                this.second.clear();
                return;
            } else if (this.error.get() != null) {
                cancelAndClear();
                this.actual.onError(this.error.terminate());
                return;
            }
            i = addAndGet(-i);
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

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return SubscriptionHelper.isCancelled(this.first.get());
    }

    public void subscribe(r51<? extends T> r51Var, r51<? extends T> r51Var2) {
        r51Var.subscribe(this.first);
        r51Var2.subscribe(this.second);
    }
}
