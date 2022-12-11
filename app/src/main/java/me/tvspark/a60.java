package me.tvspark;

/* loaded from: classes4.dex */
public interface a60<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(p60 p60Var);

    void onSuccess(T t);
}
