package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class SingleSubscribeOn$SubscribeOnObserver<T> extends AtomicReference<p60> implements m60<T>, p60, Runnable {
    public static final long serialVersionUID = 7000911171163930287L;
    public final m60<? super T> actual;
    public final n60<? extends T> source;
    public final SequentialDisposable task = new SequentialDisposable();

    public SingleSubscribeOn$SubscribeOnObserver(m60<? super T> m60Var, n60<? extends T> n60Var) {
        this.actual = m60Var;
        this.source = n60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        this.task.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }
}
