package io.reactivex.internal.operators.flowable;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableFromArray$ArraySubscription<T> extends FlowableFromArray$BaseArraySubscription<T> {
    public static final long serialVersionUID = 2587302975077663557L;
    public final s51<? super T> actual;

    public FlowableFromArray$ArraySubscription(s51<? super T> s51Var, T[] tArr) {
        super(tArr);
        this.actual = s51Var;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void fastPath() {
        T[] tArr = this.array;
        int length = tArr.length;
        s51<? super T> s51Var = this.actual;
        for (int i = this.index; i != length; i++) {
            if (this.cancelled) {
                return;
            }
            T t = tArr[i];
            if (t == null) {
                s51Var.onError(new NullPointerException("array element is null"));
                return;
            }
            s51Var.onNext(t);
        }
        if (this.cancelled) {
            return;
        }
        s51Var.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription
    public void slowPath(long j) {
        T[] tArr = this.array;
        int length = tArr.length;
        int i = this.index;
        s51<? super T> s51Var = this.actual;
        do {
            long j2 = 0;
            while (true) {
                if (j2 == j || i == length) {
                    if (i == length) {
                        if (this.cancelled) {
                            return;
                        }
                        s51Var.onComplete();
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
                        s51Var.onError(new NullPointerException("array element is null"));
                        return;
                    }
                    s51Var.onNext(t);
                    j2++;
                    i++;
                }
            }
        } while (j != 0);
    }
}
