package io.reactivex.internal.operators.maybe;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.f70;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = 4375739915521278546L;
    public final a60<? super R> actual;

    /* renamed from: d */
    public p60 f4416d;
    public final Callable<? extends b60<? extends R>> onCompleteSupplier;
    public final f70<? super Throwable, ? extends b60<? extends R>> onErrorMapper;
    public final f70<? super T, ? extends b60<? extends R>> onSuccessMapper;

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements a60<R> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.a60
        public void onComplete() {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onComplete();
        }

        @Override // me.tvspark.a60
        public void onError(Throwable th) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onError(th);
        }

        @Override // me.tvspark.a60
        public void onSubscribe(p60 p60Var) {
            DisposableHelper.setOnce(MaybeFlatMapNotification$FlatMapMaybeObserver.this, p60Var);
        }

        @Override // me.tvspark.a60
        public void onSuccess(R r) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.actual.onSuccess(r);
        }
    }

    public MaybeFlatMapNotification$FlatMapMaybeObserver(a60<? super R> a60Var, f70<? super T, ? extends b60<? extends R>> f70Var, f70<? super Throwable, ? extends b60<? extends R>> f70Var2, Callable<? extends b60<? extends R>> callable) {
        this.actual = a60Var;
        this.onSuccessMapper = f70Var;
        this.onErrorMapper = f70Var2;
        this.onCompleteSupplier = callable;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        this.f4416d.dispose();
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        try {
            b60<? extends R> call = this.onCompleteSupplier.call();
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(call, "The onCompleteSupplier returned a null MaybeSource");
            call.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (Exception e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            this.actual.onError(e);
        }
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        try {
            b60<? extends R> apply = this.onErrorMapper.apply(th);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onErrorMapper returned a null MaybeSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (Exception e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            this.actual.onError(new CompositeException(th, e));
        }
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4416d, p60Var)) {
            this.f4416d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        try {
            b60<? extends R> apply = this.onSuccessMapper.apply(t);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(apply, "The onSuccessMapper returned a null MaybeSource");
            apply.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } catch (Exception e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            this.actual.onError(e);
        }
    }
}
