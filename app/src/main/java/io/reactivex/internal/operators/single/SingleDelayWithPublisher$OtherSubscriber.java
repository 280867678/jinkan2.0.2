package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.g80;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class SingleDelayWithPublisher$OtherSubscriber<T, U> extends AtomicReference<p60> implements s51<U>, p60 {
    public static final long serialVersionUID = -8565274649390031272L;
    public final m60<? super T> actual;
    public boolean done;

    /* renamed from: s */
    public t51 f4465s;
    public final n60<T> source;

    public SingleDelayWithPublisher$OtherSubscriber(m60<? super T> m60Var, n60<T> n60Var) {
        this.actual = m60Var;
        this.source = n60Var;
    }

    @Override // me.tvspark.p60
    public void dispose() {
        this.f4465s.cancel();
        DisposableHelper.dispose(this);
    }

    @Override // me.tvspark.p60
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // me.tvspark.s51
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.source.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new g80(this, this.actual));
    }

    @Override // me.tvspark.s51
    public void onError(Throwable th) {
        if (this.done) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            return;
        }
        this.done = true;
        this.actual.onError(th);
    }

    @Override // me.tvspark.s51
    public void onNext(U u) {
        this.f4465s.cancel();
        onComplete();
    }

    @Override // me.tvspark.s51
    public void onSubscribe(t51 t51Var) {
        if (SubscriptionHelper.validate(this.f4465s, t51Var)) {
            this.f4465s = t51Var;
            this.actual.onSubscribe(this);
            t51Var.request(Long.MAX_VALUE);
        }
    }
}
