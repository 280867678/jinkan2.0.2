package io.reactivex.internal.operators.single;

import me.tvspark.d60;
import me.tvspark.f70;
import me.tvspark.n60;
import me.tvspark.rc0;

/* loaded from: classes4.dex */
public enum SingleInternalHelper$ToObservable implements f70<n60, d60> {
    INSTANCE;

    @Override // me.tvspark.f70
    public d60 apply(n60 n60Var) {
        return new rc0(n60Var);
    }
}
