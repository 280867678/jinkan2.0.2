package io.reactivex.internal.operators.flowable;

import me.tvspark.t51;
import me.tvspark.x60;

/* loaded from: classes4.dex */
public enum FlowableInternalHelper$RequestMax implements x60<t51> {
    INSTANCE;

    @Override // me.tvspark.x60
    public void accept(t51 t51Var) throws Exception {
        t51Var.request(Long.MAX_VALUE);
    }
}
