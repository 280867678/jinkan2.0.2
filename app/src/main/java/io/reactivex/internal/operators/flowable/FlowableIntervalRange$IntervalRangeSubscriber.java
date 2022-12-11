package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import me.tvspark.outline;
import me.tvspark.p60;
import me.tvspark.r40;
import me.tvspark.s51;
import me.tvspark.t51;

/* loaded from: classes4.dex */
public final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements t51, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final s51<? super Long> actual;
    public long count;
    public final long end;
    public final AtomicReference<p60> resource = new AtomicReference<>();

    public FlowableIntervalRange$IntervalRangeSubscriber(s51<? super Long> s51Var, long j, long j2) {
        this.actual = s51Var;
        this.count = j;
        this.end = j2;
    }

    @Override // me.tvspark.t51
    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.resource.get() != DisposableHelper.DISPOSED) {
            long j = get();
            if (j == 0) {
                this.actual.onError(new MissingBackpressureException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't deliver value "), this.count, " due to lack of requests")));
                DisposableHelper.dispose(this.resource);
                return;
            }
            long j2 = this.count;
            this.actual.onNext(Long.valueOf(j2));
            if (j2 == this.end) {
                if (this.resource.get() != DisposableHelper.DISPOSED) {
                    this.actual.onComplete();
                }
                DisposableHelper.dispose(this.resource);
                return;
            }
            this.count = j2 + 1;
            if (j == Long.MAX_VALUE) {
                return;
            }
            decrementAndGet();
        }
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.setOnce(this.resource, p60Var);
    }
}
