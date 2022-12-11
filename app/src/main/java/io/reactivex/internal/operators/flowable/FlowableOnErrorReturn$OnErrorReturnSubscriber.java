package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    public static final long serialVersionUID = -3740826063558713822L;
    public final f70<? super Throwable, ? extends T> valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(s51<? super T> s51Var, f70<? super Throwable, ? extends T> f70Var) {
        super(s51Var);
        this.valueSupplier = f70Var;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        try {
            T apply = this.valueSupplier.apply(th);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) apply, "The valueSupplier returned a null value");
            complete(apply);
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.s51
    public void onNext(T t) {
        this.produced++;
        this.actual.onNext(t);
    }
}
