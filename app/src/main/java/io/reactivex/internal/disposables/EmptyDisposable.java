package io.reactivex.internal.disposables;

import me.tvspark.a60;
import me.tvspark.j60;
import me.tvspark.m60;
import me.tvspark.o70;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public enum EmptyDisposable implements o70<Object> {
    INSTANCE,
    NEVER;

    public static void complete(a60<?> a60Var) {
        a60Var.onSubscribe(INSTANCE);
        a60Var.onComplete();
    }

    public static void complete(j60<?> j60Var) {
        j60Var.onSubscribe(INSTANCE);
        j60Var.onComplete();
    }

    public static void complete(u50 u50Var) {
        u50Var.onSubscribe(INSTANCE);
        u50Var.onComplete();
    }

    public static void error(Throwable th, a60<?> a60Var) {
        a60Var.onSubscribe(INSTANCE);
        a60Var.onError(th);
    }

    public static void error(Throwable th, j60<?> j60Var) {
        j60Var.onSubscribe(INSTANCE);
        j60Var.onError(th);
    }

    public static void error(Throwable th, m60<?> m60Var) {
        m60Var.onSubscribe(INSTANCE);
        m60Var.onError(th);
    }

    public static void error(Throwable th, u50 u50Var) {
        u50Var.onSubscribe(INSTANCE);
        u50Var.onError(th);
    }

    @Override // me.tvspark.t70
    public void clear() {
    }

    @Override // me.tvspark.p60
    public void dispose() {
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // me.tvspark.t70
    public boolean isEmpty() {
        return true;
    }

    @Override // me.tvspark.t70
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public Object mo4868poll() throws Exception {
        return null;
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        return i & 2;
    }
}
