package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements s51<v50>, p60 {
    public static final long serialVersionUID = -2108443387387077490L;
    public final u50 actual;
    public final boolean delayErrors;
    public final int maxConcurrency;

    /* renamed from: s */
    public t51 f4354s;
    public final o60 set = new o60();
    public final AtomicThrowable error = new AtomicThrowable();

    /* loaded from: classes4.dex */
    public final class MergeInnerObserver extends AtomicReference<p60> implements u50, p60 {
        public static final long serialVersionUID = 251330541679988317L;

        public MergeInnerObserver() {
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // me.tvspark.u50
        public void onComplete() {
            CompletableMerge$CompletableMergeSubscriber.this.innerComplete(this);
        }

        @Override // me.tvspark.u50
        public void onError(Throwable th) {
            CompletableMerge$CompletableMergeSubscriber.this.innerError(this, th);
        }

        @Override // me.tvspark.u50
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public CompletableMerge$CompletableMergeSubscriber(u50 u50Var, int i, boolean z) {
        this.actual = u50Var;
        this.maxConcurrency = i;
        this.delayErrors = z;
        lazySet(1);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4354s.cancel();
        this.set.dispose();
    }

    public void innerComplete(MergeInnerObserver mergeInnerObserver) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mergeInnerObserver);
        if (decrementAndGet() != 0) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            this.f4354s.request(1L);
            return;
        }
        Throwable th = this.error.get();
        if (th != null) {
            this.actual.onError(th);
        } else {
            this.actual.onComplete();
        }
    }

    public void innerError(MergeInnerObserver mergeInnerObserver, Throwable th) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mergeInnerObserver);
        if (!this.delayErrors) {
            this.f4354s.cancel();
            this.set.dispose();
            if (this.error.addThrowable(th)) {
                if (getAndSet(0) <= 0) {
                    return;
                }
                this.actual.onError(this.error.terminate());
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
        if (this.error.addThrowable(th)) {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    return;
                }
                this.f4354s.request(1L);
                return;
            }
            this.actual.onError(this.error.terminate());
            return;
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.set.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (decrementAndGet() == 0) {
            if (this.error.get() != null) {
                this.actual.onError(this.error.terminate());
            } else {
                this.actual.onComplete();
            }
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.delayErrors) {
            if (this.error.addThrowable(th)) {
                if (decrementAndGet() != 0) {
                    return;
                }
                this.actual.onError(this.error.terminate());
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
        this.set.dispose();
        if (this.error.addThrowable(th)) {
            if (getAndSet(0) <= 0) {
                return;
            }
            this.actual.onError(this.error.terminate());
            return;
        }
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.s51
    public void onNext(v50 v50Var) {
        getAndIncrement();
        MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mergeInnerObserver);
        v50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mergeInnerObserver);
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4354s, t51Var)) {
            this.f4354s = t51Var;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            t51Var.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }
}
