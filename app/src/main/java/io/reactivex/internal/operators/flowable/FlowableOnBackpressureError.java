package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.i80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableOnBackpressureError<T> extends i80<T, T> {

    /* loaded from: classes4.dex */
    public static final class BackpressureErrorSubscriber<T> extends AtomicLong implements s51<T>, t51 {
        public static final long serialVersionUID = -3176480756392482682L;
        public final s51<? super T> actual;
        public boolean done;

        /* renamed from: s */
        public t51 f4381s;

        public BackpressureErrorSubscriber(s51<? super T> s51Var) {
            this.actual = s51Var;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            this.f4381s.cancel();
        }

        @Override // me.tvspark.s51
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.actual.onComplete();
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
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (get() == 0) {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
                return;
            }
            this.actual.onNext(t);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.validate(this.f4381s, t51Var)) {
                this.f4381s = t51Var;
                this.actual.onSubscribe(this);
                t51Var.request(Long.MAX_VALUE);
            }
        }

        @Override // me.tvspark.t51
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
            }
        }
    }

    public FlowableOnBackpressureError(r51<T> r51Var) {
        super(r51Var);
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new BackpressureErrorSubscriber(s51Var));
    }
}
