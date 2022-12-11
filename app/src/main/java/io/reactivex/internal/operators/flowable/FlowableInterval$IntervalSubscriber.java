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
public final class FlowableInterval$IntervalSubscriber extends AtomicLong implements t51, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final s51<? super Long> actual;
    public long count;
    public final AtomicReference<p60> resource = new AtomicReference<>();

    public FlowableInterval$IntervalSubscriber(s51<? super Long> s51Var) {
        this.actual = s51Var;
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
            int i = (get() > 0L ? 1 : (get() == 0L ? 0 : -1));
            s51<? super Long> s51Var = this.actual;
            if (i == 0) {
                s51Var.onError(new MissingBackpressureException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't deliver value "), this.count, " due to lack of requests")));
                DisposableHelper.dispose(this.resource);
                return;
            }
            long j = this.count;
            this.count = j + 1;
            s51Var.onNext(Long.valueOf(j));
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
        }
    }

    public void setResource(p60 p60Var) {
        DisposableHelper.setOnce(this.resource, p60Var);
    }
}
