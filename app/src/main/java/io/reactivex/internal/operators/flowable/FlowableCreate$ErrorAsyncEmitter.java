package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(s51<? super T> s51Var) {
        super(s51Var);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
