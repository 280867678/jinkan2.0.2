package io.reactivex.internal.operators.flowable;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(s51<? super T> s51Var) {
        super(s51Var);
    }

    @Override // me.tvspark.w50
    public void onNext(T t) {
        long j;
        if (isCancelled()) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.actual.onNext(t);
        do {
            j = get();
            if (j == 0) {
                return;
            }
        } while (!compareAndSet(j, j - 1));
    }
}
