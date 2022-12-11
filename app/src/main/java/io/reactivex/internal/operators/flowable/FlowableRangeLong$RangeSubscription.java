package io.reactivex.internal.operators.flowable;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableRangeLong$RangeSubscription extends FlowableRangeLong$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final s51<? super Long> actual;

    public FlowableRangeLong$RangeSubscription(s51<? super Long> s51Var, long j, long j2) {
        super(j, j2);
        this.actual = s51Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void fastPath() {
        long j = this.end;
        s51<? super Long> s51Var = this.actual;
        for (long j2 = this.index; j2 != j; j2++) {
            if (this.cancelled) {
                return;
            }
            s51Var.onNext(Long.valueOf(j2));
        }
        if (this.cancelled) {
            return;
        }
        s51Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription
    public void slowPath(long j) {
        long j2 = this.end;
        long j3 = this.index;
        s51<? super Long> s51Var = this.actual;
        do {
            long j4 = 0;
            while (true) {
                if (j4 == j || j3 == j2) {
                    if (j3 == j2) {
                        if (this.cancelled) {
                            return;
                        }
                        s51Var.onComplete();
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
                    s51Var.onNext(Long.valueOf(j3));
                    j4++;
                    j3++;
                }
            }
        } while (j != 0);
    }
}
