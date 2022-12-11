package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.m60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.r60;

/* loaded from: classes4.dex */
public final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<r60> implements m60<T>, p60 {
    public static final long serialVersionUID = -8583764624474935784L;
    public final m60<? super T> actual;

    /* renamed from: d */
    public p60 f4466d;

    public SingleDoOnDispose$DoOnDisposeObserver(m60<? super T> m60Var, r60 r60Var) {
        this.actual = m60Var;
        lazySet(r60Var);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        r60 andSet = getAndSet(null);
        if (andSet != null) {
            try {
                andSet.run();
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            }
            this.f4466d.dispose();
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return this.f4466d.isDisposed();
    }

    @Override // me.tvspark.m60
    public void onError(Throwable th) {
        this.actual.onError(th);
    }

    @Override // me.tvspark.m60
    public void onSubscribe(p60 p60Var) {
        if (DisposableHelper.validate(this.f4466d, p60Var)) {
            this.f4466d = p60Var;
            this.actual.onSubscribe(this);
        }
    }

    @Override // me.tvspark.m60
    public void onSuccess(T t) {
        this.actual.onSuccess(t);
    }
}
