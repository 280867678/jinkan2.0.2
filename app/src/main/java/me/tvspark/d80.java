package me.tvspark;

import io.reactivex.internal.observers.InnerQueuedObserver;

/* loaded from: classes4.dex */
public interface d80<T> {
    void drain();

    void innerComplete(InnerQueuedObserver<T> innerQueuedObserver);

    void innerError(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);

    void innerNext(InnerQueuedObserver<T> innerQueuedObserver, T t);
}
