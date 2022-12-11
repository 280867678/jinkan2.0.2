package io.reactivex.internal.disposables;

import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class SequentialDisposable extends AtomicReference<p60> implements p60 {
    public static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(p60 p60Var) {
        lazySet(p60Var);
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean replace(p60 p60Var) {
        return DisposableHelper.replace(this, p60Var);
    }

    public boolean update(p60 p60Var) {
        return DisposableHelper.set(this, p60Var);
    }
}
