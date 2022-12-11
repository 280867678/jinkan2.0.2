package io.reactivex.internal.operators.flowable;

import me.tvspark.r40;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(s51<? super T> s51Var) {
        super(s51Var);
    }

    @Override // me.tvspark.w50
    public final void onNext(T t) {
        if (isCancelled()) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else if (get() == 0) {
            onOverflow();
        } else {
            this.actual.onNext(t);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, 1L);
        }
    }

    public abstract void onOverflow();
}
