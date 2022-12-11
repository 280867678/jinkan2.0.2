package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.pc0;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = -5843758257109742742L;
    public final a60<? super R> actual;
    public final f70<? super T, ? extends b60<? extends R>> mapper;

    public SingleFlatMapMaybe$FlatMapSingleObserver(a60<? super R> a60Var, f70<? super T, ? extends b60<? extends R>> f70Var) {
        this.actual = a60Var;
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

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        try {
            b60<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null MaybeSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new pc0(this, this.actual));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            onError(th);
        }
    }
}
