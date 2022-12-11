package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import me.tvspark.a60;
import me.tvspark.j60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeToObservable$MaybeToFlowableSubscriber<T> extends DeferredScalarDisposable<T> implements a60<T> {
    public static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: d */
    public p60 f4419d;

    public MaybeToObservable$MaybeToFlowableSubscriber(j60<? super T> j60Var) {
        super(j60Var);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, me.tvspark.p60
    public void dispose() {
        super.dispose();
        this.f4419d.dispose();
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        complete();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        error(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4419d, p60Var)) {
            this.f4419d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        complete(t);
    }
}
