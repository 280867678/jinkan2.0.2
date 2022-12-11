package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.a60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<p60> implements a60<T>, p60 {
    public static final long serialVersionUID = -2187421758664251153L;
    public final a60<? super T> actual;
    public final TakeUntilOtherMaybeObserver<U> other = new TakeUntilOtherMaybeObserver<>(this);

    /* loaded from: classes4.dex */
    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<t51> implements s51<U> {
        public static final long serialVersionUID = -1266041316834525931L;
        public final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> maybeTakeUntilPublisher$TakeUntilMainMaybeObserver) {
            this.parent = maybeTakeUntilPublisher$TakeUntilMainMaybeObserver;
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // me.tvspark.s51
        public void onNext(Object obj) {
            this.parent.otherComplete();
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.setOnce(this, t51Var)) {
                t51Var.request(Long.MAX_VALUE);
            }
        }
    }

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(a60<? super T> a60Var) {
        this.actual = a60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.a60
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onComplete();
        }
    }

    @Override // me.tvspark.a60
    public void onError(Throwable th) {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }

    @Override // me.tvspark.a60
    public void onSubscribe(p60 p60Var) {
        DisposableHelper.setOnce(this, p60Var);
    }

    @Override // me.tvspark.a60
    public void onSuccess(T t) {
        SubscriptionHelper.cancel(this.other);
        if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
            this.actual.onSuccess(t);
        }
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this)) {
            this.actual.onComplete();
        }
    }

    public void otherError(Throwable th) {
        if (DisposableHelper.dispose(this)) {
            this.actual.onError(th);
        } else {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
        }
    }
}
