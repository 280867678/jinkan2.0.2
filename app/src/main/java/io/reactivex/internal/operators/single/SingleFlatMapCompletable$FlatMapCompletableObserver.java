package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class SingleFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<p60> implements m60<T>, u50, p60 {
    public static final long serialVersionUID = -2177128922851101253L;
    public final u50 actual;
    public final f70<? super T, ? extends v50> mapper;

    public SingleFlatMapCompletable$FlatMapCompletableObserver(u50 u50Var, f70<? super T, ? extends v50> f70Var) {
        this.actual = u50Var;
        this.mapper = f70Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        this.actual.onComplete();
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.replace(this, p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        try {
            v50 apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null CompletableSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            onError(th);
        }
    }
}
