package me.tvspark;

import io.reactivex.internal.operators.observable.ObservableInternalHelper$MapToInt;

/* loaded from: classes4.dex */
public final class bb0 implements f70<d60<c60<Object>>, h60<?>> {
    public final f70<? super d60<Object>, ? extends h60<?>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public bb0(f70<? super d60<Object>, ? extends h60<?>> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.f70
    public h60<?> apply(d60<c60<Object>> d60Var) throws Exception {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.apply(d60Var.map(ObservableInternalHelper$MapToInt.INSTANCE));
    }
}
