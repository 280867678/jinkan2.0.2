package me.tvspark;

import io.reactivex.internal.subscribers.InnerQueuedSubscriber;

/* loaded from: classes4.dex */
public interface bd0<T> {
    void drain();

    void innerComplete(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void innerError(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th);

    void innerNext(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t);
}
