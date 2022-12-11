package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ObservableInterval extends d60<Long> {
    public final TimeUnit Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class IntervalObserver extends AtomicReference<p60> implements p60, Runnable {
        public static final long serialVersionUID = 346773832286157679L;
        public final j60<? super Long> actual;
        public long count;

        public IntervalObserver(j60<? super Long> j60Var) {
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
            if (get() != DisposableHelper.DISPOSED) {
                j60<? super Long> j60Var = this.actual;
                long j = this.count;
                this.count = 1 + j;
                j60Var.onNext(Long.valueOf(j));
            }
        }

        public void setResource(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
        this.Wwwwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Long> j60Var) {
        IntervalObserver intervalObserver = new IntervalObserver(j60Var);
        j60Var.onSubscribe(intervalObserver);
        intervalObserver.setResource(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intervalObserver, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww));
    }
}
