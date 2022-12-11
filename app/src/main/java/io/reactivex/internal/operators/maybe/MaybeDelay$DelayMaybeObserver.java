package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeDelay$DelayMaybeObserver<T> extends AtomicReference<p60> implements a60<T>, p60, Runnable {
    public static final long serialVersionUID = 5566860102500855068L;
    public final a60<? super T> actual;
    public final long delay;
    public Throwable error;
    public final k60 scheduler;
    public final TimeUnit unit;
    public T value;

    public MaybeDelay$DelayMaybeObserver(a60<? super T> a60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        this.actual = a60Var;
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = k60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        schedule();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.error = th;
        schedule();
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.value = t;
        schedule();
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.actual.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.actual.onSuccess(t);
        } else {
            this.actual.onComplete();
        }
    }

    public void schedule() {
        DisposableHelper.replace(this, this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.delay, this.unit));
    }
}
