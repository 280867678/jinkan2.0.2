package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableUnsubscribeOn<T> extends x80<T, T> {
    public final k60 Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements j60<T>, p60 {
        public static final long serialVersionUID = 1015244841293359600L;
        public final j60<? super T> actual;

        /* renamed from: s */
        public p60 f4458s;
        public final k60 scheduler;

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.f4458s.dispose();
            }
        }

        public UnsubscribeObserver(j60<? super T> j60Var, k60 k60Var) {
            this.actual = j60Var;
            this.scheduler = k60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            if (!get()) {
                this.actual.onComplete();
            }
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            if (get()) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            if (!get()) {
                this.actual.onNext(t);
            }
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4458s, p60Var)) {
                this.f4458s = p60Var;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(h60<T> h60Var, k60 k60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new UnsubscribeObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww));
    }
}
