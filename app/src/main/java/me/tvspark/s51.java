package me.tvspark;

/* loaded from: classes4.dex */
public interface s51<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(t51 t51Var);
}
