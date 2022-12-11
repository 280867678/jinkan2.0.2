package me.tvspark;

/* loaded from: classes4.dex */
public interface j60<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(p60 p60Var);
}
