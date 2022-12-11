package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.v80;

/* loaded from: classes4.dex */
public final class MaybeFlatMapSingle$FlatMapMaybeObserver<T, R> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = 4827726964688405508L;
    public final m60<? super R> actual;
    public final f70<? super T, ? extends n60<? extends R>> mapper;

    public MaybeFlatMapSingle$FlatMapMaybeObserver(m60<? super R> m60Var, f70<? super T, ? extends n60<? extends R>> f70Var) {
        this.actual = m60Var;
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

    @Override // me.tvspark.a60
    public void onComplete() {
        this.actual.onError(new NoSuchElementException());
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        try {
            n60<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null SingleSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new v80(this, this.actual));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            onError(th);
        }
    }
}
