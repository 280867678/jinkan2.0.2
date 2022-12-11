package io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.m60;
import me.tvspark.o60;
import me.tvspark.p60;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public final class SingleAmb$AmbSingleObserver<T> extends AtomicBoolean implements m60<T> {
    public static final long serialVersionUID = -1944085461036028108L;

    /* renamed from: s */
    public final m60<? super T> f4464s;
    public final o60 set;

    public SingleAmb$AmbSingleObserver(m60<? super T> m60Var, o60 o60Var) {
        this.f4464s = m60Var;
        this.set = o60Var;
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        if (!compareAndSet(false, true)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.set.dispose();
        this.f4464s.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        this.set.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p60Var);
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            this.set.dispose();
            this.f4464s.onSuccess(t);
        }
    }
}
