package me.tvspark;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* loaded from: classes4.dex */
public final class ja0<T> extends d60<T> {
    public final r51<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww<T> implements s51<T>, p60 {
        public t51 Wwwwwwwwwwwwwwwwwwwwwww;
        public final j60<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60<? super T> j60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            this.Wwwwwwwwwwwwwwwwwwwwwww.cancel();
            this.Wwwwwwwwwwwwwwwwwwwwwww = SubscriptionHelper.CANCELLED;
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.Wwwwwwwwwwwwwwwwwwwwwww == SubscriptionHelper.CANCELLED;
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onComplete();
        }

        @Override // me.tvspark.s51
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.s51
        public void onNext(T t) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.validate(this.Wwwwwwwwwwwwwwwwwwwwwww, t51Var)) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = t51Var;
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(this);
                t51Var.request(Long.MAX_VALUE);
            }
        }
    }

    public ja0(r51<? extends T> r51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = r51Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var));
    }
}
