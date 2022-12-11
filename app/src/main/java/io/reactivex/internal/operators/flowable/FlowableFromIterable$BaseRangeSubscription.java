package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import me.tvspark.l70;
import me.tvspark.r40;

/* loaded from: classes4.dex */
public abstract class FlowableFromIterable$BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    public static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;

    /* renamed from: it */
    public Iterator<? extends T> f4375it;
    public boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator<? extends T> it) {
        this.f4375it = it;
    }

    @Override // me.tvspark.t51
    public final void cancel() {
        this.cancelled = true;
    }

    @Override // me.tvspark.t70
    public final void clear() {
        this.f4375it = null;
    }

    public abstract void fastPath();

    @Override // me.tvspark.t70
    public final boolean isEmpty() {
        Iterator<? extends T> it = this.f4375it;
        return it == null || !it.hasNext();
    }

    @Override // me.tvspark.t70
    /* renamed from: poll */
    public final T mo4868poll() {
        Iterator<? extends T> it = this.f4375it;
        if (it == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
        } else if (!it.hasNext()) {
            return null;
        }
        T next = this.f4375it.next();
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) next, "Iterator.next() returned a null value");
        return next;
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
