package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.j60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class BlockingObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
    public static final Object TERMINATED = new Object();
    public static final long serialVersionUID = -4875965440900746268L;
    public final Queue<Object> queue;

    public BlockingObserver(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (DisposableHelper.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.queue.offer(NotificationLite.error(th));
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        this.queue.offer(NotificationLite.next(t));
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }
}
