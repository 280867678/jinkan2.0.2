package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import me.tvspark.j60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements j60<T> {
    public static final long serialVersionUID = -266195175408988651L;

    /* renamed from: s */
    public p60 f4350s;

    public DeferredScalarObserver(j60<? super R> j60Var) {
        super(j60Var);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, me.tvspark.p60
    public void dispose() {
        super.dispose();
        this.f4350s.dispose();
    }

    @Override // me.tvspark.j60
    public void onComplete() {
        T t = this.value;
        if (t == null) {
            complete();
            return;
        }
        this.value = null;
        complete(t);
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4350s, p60Var)) {
            this.f4350s = p60Var;
            this.actual.onSubscribe(this);
        }
    }
}
