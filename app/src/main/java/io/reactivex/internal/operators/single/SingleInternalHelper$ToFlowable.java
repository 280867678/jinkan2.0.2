package io.reactivex.internal.operators.single;

import me.tvspark.f70;
import me.tvspark.n60;
import me.tvspark.r51;

/* loaded from: classes4.dex */
public enum SingleInternalHelper$ToFlowable implements f70<n60, r51> {
    INSTANCE;

    @Override // me.tvspark.f70
    public r51 apply(n60 n60Var) {
        return new SingleToFlowable(n60Var);
    }
}
