package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.w60;

/* loaded from: classes4.dex */
public final class CancellableDisposable extends AtomicReference<w60> implements p60 {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(w60 w60Var) {
        super(w60Var);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        w60 andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Throwable) e);
        }
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return get() == null;
    }
}
