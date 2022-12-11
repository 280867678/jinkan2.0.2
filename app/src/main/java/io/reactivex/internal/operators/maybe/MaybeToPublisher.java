package io.reactivex.internal.operators.maybe;

import me.tvspark.b60;
import me.tvspark.f70;
import me.tvspark.r51;

/* loaded from: classes4.dex */
public enum MaybeToPublisher implements f70<b60<Object>, r51<Object>> {
    INSTANCE;

    public static <T> f70<b60<T>, r51<T>> instance() {
        return INSTANCE;
    }

    @Override // me.tvspark.f70
    public r51<Object> apply(b60<Object> b60Var) throws Exception {
        return new MaybeToFlowable(b60Var);
    }
}
