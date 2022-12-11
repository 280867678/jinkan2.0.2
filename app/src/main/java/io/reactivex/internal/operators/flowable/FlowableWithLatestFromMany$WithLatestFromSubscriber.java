package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableWithLatestFromMany$WithLatestFromSubscriber<T, R> extends AtomicInteger implements s51<T>, t51 {
    public static final long serialVersionUID = 1577321883966341961L;
    public final s51<? super R> actual;
    public final f70<? super Object[], R> combiner;
    public volatile boolean done;
    public final AtomicThrowable error;
    public final AtomicLong requested;

    /* renamed from: s */
    public final AtomicReference<t51> f4413s;
    public final FlowableWithLatestFromMany$WithLatestInnerSubscriber[] subscribers;
    public final AtomicReferenceArray<Object> values;

    public FlowableWithLatestFromMany$WithLatestFromSubscriber(s51<? super R> s51Var, f70<? super Object[], R> f70Var, int i) {
        this.actual = s51Var;
        this.combiner = f70Var;
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = new FlowableWithLatestFromMany$WithLatestInnerSubscriber[i];
        for (int i2 = 0; i2 < i; i2++) {
            flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2] = new FlowableWithLatestFromMany$WithLatestInnerSubscriber(this, i2);
        }
        this.subscribers = flowableWithLatestFromMany$WithLatestInnerSubscriberArr;
        this.values = new AtomicReferenceArray<>(i);
        this.f4413s = new AtomicReference<>();
        this.requested = new AtomicLong();
        this.error = new AtomicThrowable();
    }

    @Override // me.tvspark.t51
    public void cancel() {
        SubscriptionHelper.cancel(this.f4413s);
        for (FlowableWithLatestFromMany$WithLatestInnerSubscriber flowableWithLatestFromMany$WithLatestInnerSubscriber : this.subscribers) {
            flowableWithLatestFromMany$WithLatestInnerSubscriber.dispose();
        }
    }

    public void cancelAllBut(int i) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        for (int i2 = 0; i2 < flowableWithLatestFromMany$WithLatestInnerSubscriberArr.length; i2++) {
            if (i2 != i) {
                flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2].dispose();
            }
        }
    }

    public void innerComplete(int i, boolean z) {
        if (!z) {
            this.done = true;
            cancelAllBut(i);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, this, this.error);
        }
    }

    public void innerError(int i, Throwable th) {
        this.done = true;
        SubscriptionHelper.cancel(this.f4413s);
        cancelAllBut(i);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((s51<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    public void innerNext(int i, Object obj) {
        this.values.set(i, obj);
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (!this.done) {
            this.done = true;
            cancelAllBut(-1);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, this, this.error);
        }
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        cancelAllBut(-1);
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((s51<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.values;
        int length = atomicReferenceArray.length();
        Object[] objArr = new Object[length + 1];
        int i = 0;
        objArr[0] = t;
        while (i < length) {
            Object obj = atomicReferenceArray.get(i);
            if (obj == null) {
                this.f4413s.get().request(1L);
                return;
            } else {
                i++;
                objArr[i] = obj;
            }
        }
        try {
            R apply = this.combiner.apply(objArr);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "combiner returned a null value");
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.actual, apply, this, this.error);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            cancel();
            onError(th);
        }
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        SubscriptionHelper.deferredSetOnce(this.f4413s, this.requested, t51Var);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.f4413s, this.requested, j);
    }

    public void subscribe(r51<?>[] r51VarArr, int i) {
        FlowableWithLatestFromMany$WithLatestInnerSubscriber[] flowableWithLatestFromMany$WithLatestInnerSubscriberArr = this.subscribers;
        AtomicReference<t51> atomicReference = this.f4413s;
        for (int i2 = 0; i2 < i && !SubscriptionHelper.isCancelled(atomicReference.get()) && !this.done; i2++) {
            r51VarArr[i2].subscribe(flowableWithLatestFromMany$WithLatestInnerSubscriberArr[i2]);
        }
    }
}
