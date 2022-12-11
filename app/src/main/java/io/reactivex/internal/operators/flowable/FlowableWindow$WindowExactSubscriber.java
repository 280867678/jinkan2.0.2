package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class FlowableWindow$WindowExactSubscriber<T> extends AtomicInteger implements s51<T>, t51, Runnable {
    public static final long serialVersionUID = -2365647875069161133L;
    public final s51<? super x50<T>> actual;
    public final int bufferSize;
    public boolean done;
    public long index;
    public final AtomicBoolean once = new AtomicBoolean();

    /* renamed from: s */
    public t51 f4409s;
    public final long size;
    public UnicastProcessor<T> window;

    public FlowableWindow$WindowExactSubscriber(s51<? super x50<T>> s51Var, long j, int i) {
        super(1);
        this.actual = s51Var;
        this.size = j;
        this.bufferSize = i;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        UnicastProcessor<T> unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(th);
        }
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index;
        UnicastProcessor<T> unicastProcessor = this.window;
        if (j == 0) {
            getAndIncrement();
            UnicastProcessor<T> unicastProcessor2 = new UnicastProcessor<>(this.bufferSize, this);
            this.window = unicastProcessor2;
            this.actual.onNext(unicastProcessor2);
            unicastProcessor = unicastProcessor2;
        }
        long j2 = j + 1;
        unicastProcessor.onNext(t);
        if (j2 != this.size) {
            this.index = j2;
            return;
        }
        this.index = 0L;
        this.window = null;
        unicastProcessor.onComplete();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4409s, t51Var)) {
            this.f4409s = t51Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.f4409s.request(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.size, j));
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.f4409s.cancel();
        }
    }
}
