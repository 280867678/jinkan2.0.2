package io.reactivex.disposables;

import java.util.concurrent.Future;

/* loaded from: classes4.dex */
public final class FutureDisposable extends ReferenceDisposable<Future<?>> {
    public static final long serialVersionUID = 6545242830671168775L;
    public final boolean allowInterrupt;

    public FutureDisposable(Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(Future<?> future) {
        future.cancel(this.allowInterrupt);
    }
}
