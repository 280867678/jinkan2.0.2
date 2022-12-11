package io.reactivex.internal.operators.flowable;

import me.tvspark.m70;

/* loaded from: classes4.dex */
public final class FlowableRangeLong$RangeConditionalSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final m70<? super Long> actual;

    public FlowableRangeLong$RangeConditionalSubscription(m70<? super Long> m70Var, long j, long j2) {
        super(j, j2);
        this.actual = m70Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long j = this.end;
        m70<? super Long> m70Var = this.actual;
        for (long j2 = this.index; j2 != j; j2++) {
            if (this.cancelled) {
                return;
            }
            m70Var.tryOnNext(Long.valueOf(j2));
        }
        if (this.cancelled) {
            return;
        }
        m70Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        m70<? super Long> m70Var = this.actual;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (j3 == j2) {
                        if (this.cancelled) {
                            return;
                        }
                        m70Var.onComplete();
                        return;
                    }
                    j = get();
                    if (j4 == j) {
                        this.index = j3;
                        j = addAndGet(-j4);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    if (m70Var.tryOnNext(Long.valueOf(j3))) {
                        j4++;
                    }
                    j3++;
                }
            }
        } while (j != 0);
    }
}
