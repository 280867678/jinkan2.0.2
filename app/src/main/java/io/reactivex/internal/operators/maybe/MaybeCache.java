package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;
import me.tvspark.z50;

/* loaded from: classes4.dex */
public final class MaybeCache<T> extends z50<T> implements a60<T> {
    public Throwable Wwwwwwwwwwwwwwwwwwwwwww;
    public T Wwwwwwwwwwwwwwwwwwwwwwww;
    public static final CacheDisposable[] Wwwwwwwwwwwwwwwwwwwwww = new CacheDisposable[0];
    public static final CacheDisposable[] Wwwwwwwwwwwwwwwwwwwww = new CacheDisposable[0];

    /* loaded from: classes4.dex */
    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements p60 {
        public static final long serialVersionUID = -5791853038359966195L;
        public final a60<? super T> actual;

        public CacheDisposable(a60<? super T> a60Var, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.actual = a60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (getAndSet(null) == null) {
                return;
            }
            throw null;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @Override // me.tvspark.z50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var) {
        a60Var.onSubscribe(new CacheDisposable(a60Var, this));
        throw null;
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        throw null;
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = th;
        throw null;
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
        throw null;
    }
}
