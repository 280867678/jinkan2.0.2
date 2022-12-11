package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.h60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.md0;
import me.tvspark.p60;
import me.tvspark.x80;

/* loaded from: classes4.dex */
public final class ObservableSampleTimed<T> extends x80<T, T> {
    public final k60 Wwwwwwwwwwwwwwwwwwwww;
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class SampleTimedObserver<T> extends AtomicReference<T> implements j60<T>, p60, Runnable {
        public static final long serialVersionUID = -3517602651313910099L;
        public final j60<? super T> actual;
        public final long period;

        /* renamed from: s */
        public p60 f4440s;
        public final k60 scheduler;
        public final AtomicReference<p60> timer = new AtomicReference<>();
        public final TimeUnit unit;

        public SampleTimedObserver(j60<? super T> j60Var, long j, TimeUnit timeUnit, k60 k60Var) {
            this.actual = j60Var;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = k60Var;
        }

        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // me.tvspark.p60
        public void dispose() {
            cancelTimer();
            this.f4440s.dispose();
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return this.f4440s.isDisposed();
        }

        @Override // me.tvspark.j60
        public void onComplete() {
            cancelTimer();
            this.actual.onComplete();
        }

        @Override // me.tvspark.j60
        public void onError(Throwable th) {
            cancelTimer();
            this.actual.onError(th);
        }

        @Override // me.tvspark.j60
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // me.tvspark.j60
        public void onSubscribe(p60 p60Var) {
            if (DisposableHelper.validate(this.f4440s, p60Var)) {
                this.f4440s = p60Var;
                this.actual.onSubscribe(this);
                k60 k60Var = this.scheduler;
                long j = this.period;
                DisposableHelper.replace(this.timer, k60Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j, j, this.unit));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.actual.onNext(andSet);
            }
        }
    }

    public ObservableSampleTimed(h60<T> h60Var, long j, TimeUnit timeUnit, k60 k60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new SampleTimedObserver(new md0(j60Var), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}
