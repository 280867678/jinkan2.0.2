package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.t60;

/* loaded from: classes4.dex */
public final class MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver<T, U, R> extends AtomicReference<p60> implements a60<U> {
    public static final long serialVersionUID = -2897979525538174559L;
    public final a60<? super R> actual;
    public final t60<? super T, ? super U, ? extends R> resultSelector;
    public T value;

    public MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver(a60<? super R> a60Var, t60<? super T, ? super U, ? extends R> t60Var) {
        this.actual = a60Var;
        this.resultSelector = t60Var;
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(U u) {
        T t = this.value;
        this.value = null;
        try {
            R Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.resultSelector.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, u);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "The resultSelector returned a null value");
            this.actual.onSuccess(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }
}
