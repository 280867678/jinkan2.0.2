package io.reactivex.internal.util;

import me.tvspark.a60;
import me.tvspark.j60;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public enum EmptyComponent implements s51<Object>, j60<Object>, a60<Object>, m60<Object>, u50, t51, p60 {
    INSTANCE;

    public static <T> j60<T> asObserver() {
        return INSTANCE;
    }

    public static <T> s51<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // me.tvspark.t51
    public void cancel() {
    }

    @Override // me.tvspark.p60
    public void dispose() {
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return true;
    }

    @Override // me.tvspark.s51
    public void onComplete() {
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
    }

    @Override // me.tvspark.s51
    public void onNext(Object obj) {
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        p60Var.dispose();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        t51Var.cancel();
    }

    @Override // me.tvspark.a60
    public void onSuccess(Object obj) {
    }

    @Override // me.tvspark.t51
    public void request(long j) {
    }
}
