package io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.u50;

/* loaded from: classes4.dex */
public final class CompletableMergeIterable$MergeCompletableObserver extends AtomicBoolean implements u50 {
    public static final long serialVersionUID = -7730517613164279224L;
    public final u50 actual;
    public final o60 set;
    public final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(u50 u50Var, o60 o60Var, AtomicInteger atomicInteger) {
        this.actual = u50Var;
        this.set = o60Var;
        this.wip = atomicInteger;
    }

    @Override // me.tvspark.u50
    public void onComplete() {
        if (this.wip.decrementAndGet() != 0 || !compareAndSet(false, true)) {
            return;
        }
        this.actual.onComplete();
    }

    @Override // me.tvspark.u50
    public void onError(Throwable th) {
        this.set.dispose();
        if (compareAndSet(false, true)) {
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
