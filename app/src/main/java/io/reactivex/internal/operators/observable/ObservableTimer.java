package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ObservableTimer extends d60<Long> {
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class IntervalOnceObserver extends AtomicReference<p60> implements p60, Runnable {
        public static final long serialVersionUID = -2809475196591179431L;
        public final j60<? super Long> actual;

        public IntervalOnceObserver(j60<? super Long> j60Var) {
            this.actual = j60Var;
        }

        @Override // me.tvspark.p60
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // me.tvspark.p60
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                this.actual.onNext(0L);
                this.actual.onComplete();
                lazySet(EmptyDisposable.INSTANCE);
            }
        }

        public void setResource(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Long> j60Var) {
        IntervalOnceObserver intervalOnceObserver = new IntervalOnceObserver(j60Var);
        j60Var.onSubscribe(intervalOnceObserver);
        intervalOnceObserver.setResource(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intervalOnceObserver, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
