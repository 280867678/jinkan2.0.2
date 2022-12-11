package io.reactivex.internal.subscriptions;

import me.tvspark.q70;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public enum EmptySubscription implements q70<Object> {
    INSTANCE;

    public static void complete(s51<?> s51Var) {
        s51Var.onSubscribe(INSTANCE);
        s51Var.onComplete();
    }

    public static void error(Throwable th, s51<?> s51Var) {
        s51Var.onSubscribe(INSTANCE);
        s51Var.onError(th);
    }

    @Override // me.tvspark.t51
    public void cancel() {
    }

    @Override // me.tvspark.t70
    public void clear() {
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
    public Object mo4868poll() {
        return null;
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // me.tvspark.p70
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }
}
