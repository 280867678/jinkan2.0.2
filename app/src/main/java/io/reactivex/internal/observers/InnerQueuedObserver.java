package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d80;
import me.tvspark.j60;
import me.tvspark.o70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.t70;

/* loaded from: classes4.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<p60> implements j60<T>, p60 {
    public static final long serialVersionUID = -5417183359794346637L;
    public volatile boolean done;
    public int fusionMode;
    public final d80<T> parent;
    public final int prefetch;
    public t70<T> queue;

    public InnerQueuedObserver(d80<T> d80Var, int i) {
        this.parent = d80Var;
        this.prefetch = i;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // me.tvspark.j60
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            if (p60Var instanceof o70) {
                o70 o70Var = (o70) p60Var;
                int requestFusion = o70Var.requestFusion(3);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = o70Var;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = o70Var;
                    return;
                }
            }
            this.queue = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-this.prefetch);
        }
    }

    public t70<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
