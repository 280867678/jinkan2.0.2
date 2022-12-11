package io.reactivex.disposables;

import io.reactivex.internal.util.ExceptionHelper;
import me.tvspark.r60;

/* loaded from: classes4.dex */
public final class ActionDisposable extends ReferenceDisposable<r60> {
    public static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(r60 r60Var) {
        super(r60Var);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public void onDisposed(r60 r60Var) {
        try {
            r60Var.run();
        } catch (Throwable th) {
            throw ExceptionHelper.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
