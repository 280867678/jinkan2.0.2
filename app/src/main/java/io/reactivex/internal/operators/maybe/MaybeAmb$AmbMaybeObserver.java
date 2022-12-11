package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.a60;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class MaybeAmb$AmbMaybeObserver<T> extends AtomicBoolean implements a60<T>, p60 {
    public static final long serialVersionUID = -7044685185359438206L;
    public final a60<? super T> actual;
    public final o60 set = new o60();

    public MaybeAmb$AmbMaybeObserver(a60<? super T> a60Var) {
        this.actual = a60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get();
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        if (!compareAndSet(false, true)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.set.dispose();
        this.actual.onError(th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.actual.onSuccess(t);
        }
    }
}
