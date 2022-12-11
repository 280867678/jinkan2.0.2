package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import me.tvspark.m60;
import me.tvspark.n60;
import me.tvspark.p60;
import me.tvspark.s51;
import me.tvspark.x50;

/* loaded from: classes4.dex */
public final class SingleToFlowable<T> extends x50<T> {
    public final n60<? extends T> Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements m60<T> {
        public static final long serialVersionUID = 187782011903685568L;

        /* renamed from: d */
        public p60 f4471d;

        public SingleToFlowableObserver(s51<? super T> s51Var) {
            super(s51Var);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, me.tvspark.t51
        public void cancel() {
            super.cancel();
            this.f4471d.dispose();
        }

        @Override // me.tvspark.m60
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // me.tvspark.m60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4471d, p60Var)) {
                this.f4471d = p60Var;
                this.actual.onSubscribe(this);
            }
        }

        @Override // me.tvspark.m60
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToFlowable(n60<? extends T> n60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = n60Var;
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new SingleToFlowableObserver(s51Var));
    }
}
