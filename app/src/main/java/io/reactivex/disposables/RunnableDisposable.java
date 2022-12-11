package io.reactivex.disposables;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("RunnableDisposable(disposed=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(isDisposed());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(get());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(")");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
