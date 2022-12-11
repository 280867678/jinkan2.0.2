package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
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

/* loaded from: classes4.dex */
public final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements s51<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public final s51<? super T> actual;
    public final boolean delayErrors;
    public final f70<? super T, ? extends v50> mapper;
    public final int maxConcurrency;

    /* renamed from: s */
    public t51 f4370s;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final o60 set = new o60();

    /* loaded from: classes4.dex */
    public final class InnerConsumer extends AtomicReference<p60> implements u50, p60 {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerConsumer() {
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
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        @Override // me.tvspark.u50
        public void onError(Throwable th) {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th);
        }

        @Override // me.tvspark.u50
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(s51<? super T> s51Var, f70<? super T, ? extends v50> f70Var, boolean z, int i) {
        this.actual = s51Var;
        this.mapper = f70Var;
        this.delayErrors = z;
        this.maxConcurrency = i;
        lazySet(1);
    }

    @Override // me.tvspark.t51
    public void cancel() {
        this.f4370s.cancel();
        this.set.dispose();
    }

    @Override // me.tvspark.t70
    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerConsumer);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerConsumer);
        onError(th);
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return true;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (decrementAndGet() != 0) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            this.f4370s.request(1L);
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
            cancel();
            if (getAndSet(0) <= 0) {
                return;
            }
        } else if (decrementAndGet() != 0) {
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            this.f4370s.request(1L);
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
            InnerConsumer innerConsumer = new InnerConsumer();
            this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerConsumer);
            v50Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(innerConsumer);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4370s.cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4370s, t51Var)) {
            this.f4370s = t51Var;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            t51Var.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public T mo4868poll() throws Exception {
        return null;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        return i & 2;
    }
}
