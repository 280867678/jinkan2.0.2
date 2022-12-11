package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.w60;
import me.tvspark.y50;

/* loaded from: classes4.dex */
public abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements y50<T>, t51 {
    public static final long serialVersionUID = 7326289992464377023L;
    public final s51<? super T> actual;
    public final SequentialDisposable serial = new SequentialDisposable();

    public FlowableCreate$BaseEmitter(s51<? super T> s51Var) {
        this.actual = s51Var;
    }

    @Override // me.tvspark.t51
    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    @Override // me.tvspark.w50
    public void onComplete() {
        if (isCancelled()) {
            return;
        }
        try {
            this.actual.onComplete();
        } finally {
            this.serial.dispose();
        }
    }

    @Override // me.tvspark.w50
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isCancelled()) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        try {
            this.actual.onError(th);
        } finally {
            this.serial.dispose();
        }
    }

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final y50<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(w60 w60Var) {
        setDisposable(new CancellableDisposable(w60Var));
    }

    public final void setDisposable(p60 p60Var) {
        this.serial.update(p60Var);
    }
}
