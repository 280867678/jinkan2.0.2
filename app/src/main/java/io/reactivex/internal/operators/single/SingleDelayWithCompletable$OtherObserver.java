package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.g80;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class SingleDelayWithCompletable$OtherObserver<T> extends AtomicReference<p60> implements u50, p60 {
    public static final long serialVersionUID = -8565274649390031272L;
    public final m60<? super T> actual;
    public final n60<T> source;

    public SingleDelayWithCompletable$OtherObserver(m60<? super T> m60Var, n60<T> n60Var) {
        this.actual = m60Var;
        this.source = n60Var;
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
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new g80(this, this.actual));
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
