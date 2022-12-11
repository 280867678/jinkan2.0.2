package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<p60> implements a60<T> {
    public static final long serialVersionUID = -3031974433025990931L;
    public final MaybeEqualSingle$EqualCoordinator<T> parent;
    public Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> maybeEqualSingle$EqualCoordinator) {
        this.parent = maybeEqualSingle$EqualCoordinator;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        this.parent.done();
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        this.parent.error(this, th);
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        this.value = t;
        this.parent.done();
    }
}
