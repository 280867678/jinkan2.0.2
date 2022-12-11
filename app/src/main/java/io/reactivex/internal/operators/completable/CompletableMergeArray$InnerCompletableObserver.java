package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class CompletableMergeArray$InnerCompletableObserver extends AtomicInteger implements u50 {
    public static final long serialVersionUID = -8360547806504310570L;
    public final u50 actual;
    public final AtomicBoolean once;
    public final o60 set;

    public CompletableMergeArray$InnerCompletableObserver(u50 u50Var, AtomicBoolean atomicBoolean, o60 o60Var, int i) {
        this.actual = u50Var;
        this.once = atomicBoolean;
        this.set = o60Var;
        lazySet(i);
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        if (decrementAndGet() != 0 || !this.once.compareAndSet(false, true)) {
            return;
        }
        this.actual.onComplete();
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.set.dispose();
        if (this.once.compareAndSet(false, true)) {
            this.actual.onError(th);
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.u50
    public void onSubscribe(p60 p60Var) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
    }
}
