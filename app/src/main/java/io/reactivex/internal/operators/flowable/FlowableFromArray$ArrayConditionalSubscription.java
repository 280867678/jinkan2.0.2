package io.reactivex.internal.operators.flowable;

import me.tvspark.m70;

/* loaded from: classes4.dex */
public final class FlowableFromArray$ArrayConditionalSubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final m70<? super T> actual;

    public FlowableFromArray$ArrayConditionalSubscription(m70<? super T> m70Var, T[] tArr) {
        super(tArr);
        this.actual = m70Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        m70<? super T> m70Var = this.actual;
        for (int i = this.index; i != length; i++) {
            if (this.cancelled) {
                return;
            }
            T t = tArr[i];
            if (t == null) {
                m70Var.onError(new NullPointerException("array element is null"));
                return;
            }
            m70Var.tryOnNext(t);
        }
        if (this.cancelled) {
            return;
        }
        m70Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        m70<? super T> m70Var = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i == length) {
                    if (i == length) {
                        if (this.cancelled) {
                            return;
                        }
                        m70Var.onComplete();
                        return;
                    }
                    j = get();
                    if (j2 == j) {
                        this.index = i;
                        j = addAndGet(-j2);
                    }
                } else if (this.cancelled) {
                    return;
                } else {
                    T t = tArr[i];
                    if (t == null) {
                        m70Var.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    if (m70Var.tryOnNext(t)) {
                        j2++;
                    }
                    i++;
                }
            }
        } while (j != 0);
    }
}
