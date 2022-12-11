package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t60;

/* loaded from: classes4.dex */
public final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    public static final long serialVersionUID = -1776795561228106469L;
    public final t60<R, ? super T, R> accumulator;

    public FlowableScanSeed$ScanSeedSubscriber(s51<? super R> s51Var, t60<R, ? super T, R> t60Var, R r) {
        super(s51Var);
        this.accumulator = t60Var;
        this.value = r;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        complete(this.value);
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        R r = this.value;
        try {
            R Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.accumulator.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r, t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "The accumulator returned a null value");
            this.value = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.produced++;
            this.actual.onNext(r);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.f4474s.cancel();
            onError(th);
        }
    }
}
