package io.reactivex.internal.operators.flowable;

import me.tvspark.m70;

/* loaded from: classes4.dex */
public final class FlowableRange$RangeConditionalSubscription extends FlowableRange$BaseRangeSubscription {
    public static final long serialVersionUID = 2587302975077663557L;
    public final m70<? super Integer> actual;

    public FlowableRange$RangeConditionalSubscription(m70<? super Integer> m70Var, int i, int i2) {
        super(i, i2);
        this.actual = m70Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void fastPath() {
        int i = this.end;
        m70<? super Integer> m70Var = this.actual;
        for (int i2 = this.index; i2 != i; i2++) {
            if (this.cancelled) {
                return;
            }
            m70Var.tryOnNext(Integer.valueOf(i2));
        }
        if (this.cancelled) {
            return;
        }
        m70Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription
    public void slowPath(long j) {
        int i = this.end;
        int i2 = this.index;
        m70<? super Integer> m70Var = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i2 == i) {
                    if (i2 == i) {
                        if (this.cancelled) {
                            return;
                        }
                        m70Var.onComplete();
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
                    if (m70Var.tryOnNext(Integer.valueOf(i2))) {
                        j2++;
                    }
                    i2++;
                }
            }
        } while (j != 0);
    }
}
