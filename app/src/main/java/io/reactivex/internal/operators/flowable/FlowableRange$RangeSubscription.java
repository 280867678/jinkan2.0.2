package io.reactivex.internal.operators.flowable;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableRange$RangeSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final s51<? super Integer> actual;

    public FlowableRange$RangeSubscription(s51<? super Integer> s51Var, int i, int i2) {
        super(i, i2);
        this.actual = s51Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int i = this.end;
        s51<? super Integer> s51Var = this.actual;
        for (int i2 = this.index; i2 != i; i2++) {
            if (this.cancelled) {
                return;
            }
            s51Var.onNext(Integer.valueOf(i2));
        }
        if (this.cancelled) {
            return;
        }
        s51Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long j) {
        int i = this.end;
        int i2 = this.index;
        s51<? super Integer> s51Var = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i2 == i) {
                    if (i2 == i) {
                        if (this.cancelled) {
                            return;
                        }
                        s51Var.onComplete();
                        return;
                    }
                    j = get();
                    if (j2 == j) {
                        this.index = i2;
                        j = addAndGet(-j2);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    s51Var.onNext(Integer.valueOf(i2));
                    j2++;
                    i2++;
                }
            }
        } while (j != 0);
    }
}
