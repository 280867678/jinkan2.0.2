package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.l70;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public abstract class ReferenceDisposable<T> extends AtomicReference<T> implements p60 {
    public static final long serialVersionUID = 6537757548749041217L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceDisposable(T t) {
        super(t);
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "value is null");
    }

    @Override // me.tvspark.p60
    public final void dispose() {
        T andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        onDisposed(andSet);
    }

    @Override // me.tvspark.p60
    public final boolean isDisposed() {
        return get() == null;
    }

    public abstract void onDisposed(T t);
}
