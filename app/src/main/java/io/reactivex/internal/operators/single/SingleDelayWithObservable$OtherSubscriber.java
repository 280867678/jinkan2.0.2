package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.g80;
import me.tvspark.j60;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleDelayWithObservable$OtherSubscriber<T, U> extends AtomicReference<p60> implements j60<U>, p60 {
    public static final long serialVersionUID = -8565274649390031272L;
    public final m60<? super T> actual;
    public boolean done;
    public final n60<T> source;

    public SingleDelayWithObservable$OtherSubscriber(m60<? super T> m60Var, n60<T> n60Var) {
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

    @Override // me.tvspark.j60
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new g80(this, this.actual));
    }

    @Override // me.tvspark.j60
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // me.tvspark.j60
    public void onNext(U u) {
        get().dispose();
        onComplete();
    }

    @Override // me.tvspark.j60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.set(this, p60Var)) {
            this.actual.onSubscribe(this);
        }
    }
}
