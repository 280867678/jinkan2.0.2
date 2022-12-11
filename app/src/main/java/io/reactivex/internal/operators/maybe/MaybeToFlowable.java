package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import me.tvspark.a60;
import me.tvspark.b60;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class MaybeToFlowable<T> extends x50<T> {
    public final b60<T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements a60<T> {
        public static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: d */
        public p60 f4418d;

        public MaybeToFlowableSubscriber(s51<? super T> s51Var) {
            super(s51Var);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
        public void cancel() {
            super.cancel();
            this.f4418d.dispose();
        }

        @Override // me.tvspark.a60
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // me.tvspark.a60
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // me.tvspark.a60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4418d, p60Var)) {
                this.f4418d = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        @Override // me.tvspark.a60
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public MaybeToFlowable(b60<T> b60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = b60Var;
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new MaybeToFlowableSubscriber(s51Var));
    }
}
