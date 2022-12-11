package io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.l60;
import me.tvspark.m60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class SingleCache<T> extends l60<T> implements m60<T> {

    /* loaded from: classes4.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements p60 {
        public static final long serialVersionUID = 7514387411091976596L;
        public final m60<? super T> actual;
        public final SingleCache<T> parent;

        public CacheDisposable(m60<? super T> m60Var, SingleCache<T> singleCache) {
            this.actual = m60Var;
            this.parent = singleCache;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (compareAndSet(false, true)) {
                throw null;
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get();
        }
    }
}
