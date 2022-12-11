package io.reactivex.disposables;

import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class SubscriptionDisposable extends ReferenceDisposable<t51> {
    public static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(t51 t51Var) {
        super(t51Var);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(t51 t51Var) {
        t51Var.cancel();
    }
}
