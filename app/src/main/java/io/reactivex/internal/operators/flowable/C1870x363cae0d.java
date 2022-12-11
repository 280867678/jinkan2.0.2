package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.u50;
import me.tvspark.v50;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber */
/* loaded from: classes4.dex */
public final class C1870x363cae0d<T> extends AtomicInteger implements s51<T>, p60 {
    public static final long serialVersionUID = 8443155186132538303L;
    public final u50 actual;
    public final boolean delayErrors;
    public final f70<? super T, ? extends v50> mapper;
    public final int maxConcurrency;

    /* renamed from: s */
    public t51 f4371s;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final o60 set = new o60();

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber$InnerObserver */
    /* loaded from: classes4.dex */
    public final class InnerObserver extends AtomicReference<p60> implements u50, p60 {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
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
            C1870x363cae0d.this.innerComplete(this);
        }

        @Override // me.tvspark.u50
        public void onError(Throwable th) {
            C1870x363cae0d.this.innerError(this, th);
        }

        @Override // me.tvspark.u50
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public C1870x363cae0d(u50 u50Var, f70<? super T, ? extends v50> f70Var, boolean z, int i) {
        this.actual = u50Var;
        this.mapper = f70Var;
        this.delayErrors = z;
        this.maxConcurrency = i;
        lazySet(1);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4371s.cancel();
        this.set.dispose();
    }

    public void innerComplete(C1870x363cae0d<T>.InnerObserver innerObserver) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
        onComplete();
    }

    public void innerError(C1870x363cae0d<T>.InnerObserver innerObserver, Throwable th) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
        onError(th);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.set.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (decrementAndGet() != 0) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            this.f4371s.request(1L);
            return;
        }
        Throwable terminate = this.errors.terminate();
        if (terminate != null) {
            this.actual.onError(terminate);
        } else {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (!this.errors.addThrowable(th)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        if (!this.delayErrors) {
            dispose();
            if (getAndSet(0) <= 0) {
                return;
            }
        } else if (decrementAndGet() != 0) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            this.f4371s.request(1L);
            return;
        }
        this.actual.onError(this.errors.terminate());
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        try {
            v50 apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null CompletableSource");
            v50 v50Var = apply;
            getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
            v50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerObserver);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4371s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4371s, t51Var)) {
            this.f4371s = t51Var;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            t51Var.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }
}
