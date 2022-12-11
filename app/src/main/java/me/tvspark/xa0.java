package me.tvspark;

import io.reactivex.internal.functions.Functions;

/* loaded from: classes4.dex */
public final class xa0<T, U> implements f70<T, h60<T>> {
    public final f70<? super T, ? extends h60<U>> Wwwwwwwwwwwwwwwwwwwwwwww;

    public xa0(f70<? super T, ? extends h60<U>> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.f70
    public Object apply(Object obj) throws Exception {
        return new dc0(this.Wwwwwwwwwwwwwwwwwwwwwwww.apply(obj), 1L).map(Functions.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj)).defaultIfEmpty(obj);
    }
}
