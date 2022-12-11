package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<p60> implements Runnable, p60 {
    public static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once = new AtomicBoolean();
    public final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    public final T value;

    public FlowableDebounceTimed$DebounceEmitter(T t, long j, FlowableDebounceTimed$DebounceTimedSubscriber<T> flowableDebounceTimed$DebounceTimedSubscriber) {
        this.value = t;
        this.idx = j;
        this.parent = flowableDebounceTimed$DebounceTimedSubscriber;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        if (this.once.compareAndSet(false, true)) {
            this.parent.emit(this.idx, this.value, this);
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.replace(this, p60Var);
    }
}
