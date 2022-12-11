package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.p60;
import me.tvspark.u50;
import me.tvspark.v50;

/* loaded from: classes4.dex */
public final class CompletableConcatArray$ConcatInnerObserver extends AtomicInteger implements u50 {
    public static final long serialVersionUID = -7965400327305809232L;
    public final u50 actual;
    public int index;

    /* renamed from: sd */
    public final SequentialDisposable f4352sd = new SequentialDisposable();
    public final v50[] sources;

    public CompletableConcatArray$ConcatInnerObserver(u50 u50Var, v50[] v50VarArr) {
        this.actual = u50Var;
        this.sources = v50VarArr;
    }

    public void next() {
        if (!this.f4352sd.isDisposed() && getAndIncrement() == 0) {
            v50[] v50VarArr = this.sources;
            while (!this.f4352sd.isDisposed()) {
                int i = this.index;
                this.index = i + 1;
                if (i == v50VarArr.length) {
                    this.actual.onComplete();
                    return;
                }
                v50VarArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                if (decrementAndGet() == 0) {
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
        this.f4352sd.update(p60Var);
    }
}
