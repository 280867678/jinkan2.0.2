package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = 4375739915521278546L;
    public final a60<? super R> actual;

    /* renamed from: d */
    public p60 f4417d;
    public final f70<? super T, ? extends b60<? extends R>> mapper;

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements a60<R> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.a60
        public void onComplete() {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onComplete();
        }

        @Override // me.tvspark.a60
        public void onError(Throwable th) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onError(th);
        }

        @Override // me.tvspark.a60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(MaybeFlatten$FlatMapMaybeObserver.this, p60Var);
        }

        @Override // me.tvspark.a60
        public void onSuccess(R r) {
            MaybeFlatten$FlatMapMaybeObserver.this.actual.onSuccess(r);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(a60<? super R> a60Var, f70<? super T, ? extends b60<? extends R>> f70Var) {
        this.actual = a60Var;
        this.mapper = f70Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        this.f4417d.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
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
        if (DisposableHelper.validate(this.f4417d, p60Var)) {
            this.f4417d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        try {
            b60<? extends R> apply = this.mapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The mapper returned a null MaybeSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (Exception e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            this.actual.onError(e);
        }
    }
}
