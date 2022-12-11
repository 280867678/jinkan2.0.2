package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<p60> implements a60<T> {
    public static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final MaybeZipArray$ZipCoordinator<T, ?> parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> maybeZipArray$ZipCoordinator, int i) {
        this.parent = maybeZipArray$ZipCoordinator;
        this.index = i;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.parent.innerError(th, this.index);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.parent.innerSuccess(t, this.index);
    }
}
