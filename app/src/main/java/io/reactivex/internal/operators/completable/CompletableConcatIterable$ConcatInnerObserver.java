package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.l70;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class CompletableConcatIterable$ConcatInnerObserver extends AtomicInteger implements u50 {
    public static final long serialVersionUID = -7965400327305809232L;
    public final u50 actual;

    /* renamed from: sd */
    public final SequentialDisposable f4353sd = new SequentialDisposable();
    public final Iterator<? extends v50> sources;

    public CompletableConcatIterable$ConcatInnerObserver(u50 u50Var, Iterator<? extends v50> it) {
        this.actual = u50Var;
        this.sources = it;
    }

    public void next() {
        if (!this.f4353sd.isDisposed() && getAndIncrement() == 0) {
            Iterator<? extends v50> it = this.sources;
            while (!this.f4353sd.isDisposed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onComplete();
                        return;
                    }
                    try {
                        v50 next = it.next();
                        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, "The CompletableSource returned is null");
                        next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                        this.actual.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2);
                    this.actual.onError(th2);
                    return;
                }
            }
        }
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        next();
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        this.f4353sd.update(p60Var);
    }
}
