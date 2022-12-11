package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.p60;
import me.tvspark.u50;
import me.tvspark.u80;

/* loaded from: classes4.dex */
public final class MaybeDelayWithCompletable$OtherObserver<T> extends AtomicReference<p60> implements u50, p60 {
    public static final long serialVersionUID = 703409937383992161L;
    public final a60<? super T> actual;
    public final b60<T> source;

    public MaybeDelayWithCompletable$OtherObserver(a60<? super T> a60Var, b60<T> b60Var) {
        this.actual = a60Var;
        this.source = b60Var;
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
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new u80(this, this.actual));
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.setOnce(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }
}
