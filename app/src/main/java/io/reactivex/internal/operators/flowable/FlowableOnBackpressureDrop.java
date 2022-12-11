package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import me.tvspark.i80;
import me.tvspark.r40;
import me.tvspark.r51;
import me.tvspark.s51;
import me.tvspark.t51;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public final class FlowableOnBackpressureDrop<T> extends i80<T, T> implements x60<T> {
    public final x60<? super T> Wwwwwwwwwwwwwwwwwwwwww = this;

    /* loaded from: classes4.dex */
    public static final class BackpressureDropSubscriber<T> extends AtomicLong implements s51<T>, t51 {
        public static final long serialVersionUID = -6246093802440953054L;
        public final s51<? super T> actual;
        public boolean done;
        public final x60<? super T> onDrop;

        /* renamed from: s */
        public t51 f4380s;

        public BackpressureDropSubscriber(s51<? super T> s51Var, x60<? super T> x60Var) {
            this.actual = s51Var;
            this.onDrop = x60Var;
        }

        @Override // me.tvspark.t51
        public void cancel() {
            this.f4380s.cancel();
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
            if (get() != 0) {
                this.actual.onNext(t);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
                return;
            }
            try {
                this.onDrop.accept(t);
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                cancel();
                onError(th);
            }
        }

        @Override // me.tvspark.s51
        public void onSubscribe(t51 t51Var) {
            if (SubscriptionHelper.validate(this.f4380s, t51Var)) {
                this.f4380s = t51Var;
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

    public FlowableOnBackpressureDrop(r51<T> r51Var) {
        super(r51Var);
    }

    @Override // me.tvspark.x50
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.subscribe(new BackpressureDropSubscriber(s51Var, this.Wwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.x60
    public void accept(T t) {
    }
}
