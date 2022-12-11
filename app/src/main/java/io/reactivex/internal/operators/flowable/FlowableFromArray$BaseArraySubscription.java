package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import me.tvspark.l70;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public abstract class FlowableFromArray$BaseArraySubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public final T[] array;
    public volatile boolean cancelled;
    public int index;

    public FlowableFromArray$BaseArraySubscription(T[] tArr) {
        this.array = tArr;
    }

    @Override // me.tvspark.t51
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // me.tvspark.t70
    public final void clear() {
        this.index = this.array.length;
    }

    public abstract void fastPath();

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        return this.index == this.array.length;
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public final T mo4868poll() {
        int i = this.index;
        T[] tArr = this.array;
        if (i == tArr.length) {
            return null;
        }
        this.index = i + 1;
        T t = tArr[i];
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) t, "array element is null");
        return t;
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
