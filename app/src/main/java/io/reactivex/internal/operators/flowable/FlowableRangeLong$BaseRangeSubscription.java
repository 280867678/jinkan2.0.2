package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public abstract class FlowableRangeLong$BaseRangeSubscription extends BasicQueueSubscription<Long> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final long end;
    public long index;

    public FlowableRangeLong$BaseRangeSubscription(long j, long j2) {
        this.index = j;
        this.end = j2;
    }

    @Override // me.tvspark.t51
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // me.tvspark.t70
    public final void clear() {
        this.index = this.end;
    }

    public abstract void fastPath();

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        return this.index == this.end;
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public final Long mo4868poll() {
        long j = this.index;
        if (j == this.end) {
            return null;
        }
        this.index = 1 + j;
        return Long.valueOf(j);
    }

    @Override // me.tvspark.t51
    public final void request(long j) {
        if (!SubscriptionHelper.validate(j) || r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, j) != 0) {
            return;
        }
        if (j == Long.MAX_VALUE) {
            fastPath();
        } else {
            slowPath(j);
        }
    }

    @Override // me.tvspark.p70
    public final int requestFusion(int i) {
        return i & 1;
    }

    public abstract void slowPath(long j);
}
