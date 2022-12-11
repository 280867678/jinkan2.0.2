package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public abstract class FlowableRange$BaseRangeSubscription extends BasicQueueSubscription<Integer> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final int end;
    public int index;

    public FlowableRange$BaseRangeSubscription(int i, int i2) {
        this.index = i;
        this.end = i2;
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
    public final Integer mo4868poll() {
        int i = this.index;
        if (i == this.end) {
            return null;
        }
        this.index = i + 1;
        return Integer.valueOf(i);
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
