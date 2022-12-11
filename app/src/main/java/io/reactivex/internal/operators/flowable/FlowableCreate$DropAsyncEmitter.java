package io.reactivex.internal.operators.flowable;

import me.tvspark.s51;

/* loaded from: classes4.dex */
public final class FlowableCreate$DropAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    public FlowableCreate$DropAsyncEmitter(s51<? super T> s51Var) {
        super(s51Var);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
    }
}
