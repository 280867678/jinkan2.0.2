package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.d60;
import me.tvspark.j60;
import me.tvspark.k60;
import me.tvspark.p60;

/* loaded from: classes4.dex */
public final class ObservableIntervalRange extends d60<Long> {
    public final TimeUnit Wwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwww;
    public final k60 Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static final class IntervalRangeObserver extends AtomicReference<p60> implements p60, Runnable {
        public static final long serialVersionUID = 1891866368734007884L;
        public final j60<? super Long> actual;
        public long count;
        public final long end;

        public IntervalRangeObserver(j60<? super Long> j60Var, long j, long j2) {
            this.actual = j60Var;
            this.count = j;
            this.end = j2;
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
                long j = this.count;
                this.actual.onNext(Long.valueOf(j));
                if (j != this.end) {
                    this.count = j + 1;
                    return;
                }
                DisposableHelper.dispose(this);
                this.actual.onComplete();
            }
        }

        public void setResource(p60 p60Var) {
            DisposableHelper.setOnce(this, p60Var);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwww = j3;
        this.Wwwwwwwwwwwwwwwwwwww = j4;
        this.Wwwwwwwwwwwwwwwwwww = timeUnit;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = k60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = j;
        this.Wwwwwwwwwwwwwwwwwwwwww = j2;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super Long> j60Var) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
        j60Var.onSubscribe(intervalRangeObserver);
        intervalRangeObserver.setResource(this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intervalRangeObserver, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww));
    }
}
