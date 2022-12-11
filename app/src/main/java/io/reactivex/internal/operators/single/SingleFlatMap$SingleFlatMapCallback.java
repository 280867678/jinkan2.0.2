package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleFlatMap$SingleFlatMapCallback<T, R> extends AtomicReference<p60> implements m60<T>, p60 {
    public static final long serialVersionUID = 3258103020495908596L;
    public final m60<? super R> actual;
    public final f70<? super T, ? extends n60<? extends R>> mapper;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<R> implements m60<R> {
        public final m60<? super R> Wwwwwwwwwwwwwwwwwwwwwww;
        public final AtomicReference<p60> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AtomicReference<p60> atomicReference, m60<? super R> m60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = atomicReference;
            this.Wwwwwwwwwwwwwwwwwwwwwww = m60Var;
        }

        @Override // me.tvspark.m60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.m60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.replace(this.Wwwwwwwwwwwwwwwwwwwwwwww, p60Var);
        }

        @Override // me.tvspark.m60
        public void onSuccess(R r) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.onSuccess(r);
        }
    }

    public SingleFlatMap$SingleFlatMapCallback(m60<? super R> m60Var, f70<? super T, ? extends n60<? extends R>> f70Var) {
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
            n60<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The single returned by the mapper is null");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, this.actual));
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            this.actual.onError(th);
        }
    }
}
