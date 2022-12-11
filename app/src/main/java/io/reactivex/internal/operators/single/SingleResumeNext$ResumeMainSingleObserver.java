package io.reactivex.internal.operators.single;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.g80;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleResumeNext$ResumeMainSingleObserver<T> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = -5314538511045349925L;
    public final m60<? super T> actual;
    public final f70<? super Throwable, ? extends n60<? extends T>> nextFunction;

    public SingleResumeNext$ResumeMainSingleObserver(m60<? super T> m60Var, f70<? super Throwable, ? extends n60<? extends T>> f70Var) {
        this.actual = m60Var;
        this.nextFunction = f70Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        try {
            n60<? extends T> apply = this.nextFunction.apply(th);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The nextFunction returned a null SingleSource.");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new g80(this, this.actual));
        } catch (Throwable th2) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
            this.actual.onError(new CompositeException(th, th2));
        }
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
