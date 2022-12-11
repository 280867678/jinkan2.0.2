package me.tvspark;

/* loaded from: classes4.dex */
public final class wa0<T, R, U> implements f70<T, h60<R>> {
    public final f70<? super T, ? extends h60<? extends U>> Wwwwwwwwwwwwwwwwwwwwwww;
    public final t60<? super T, ? super U, ? extends R> Wwwwwwwwwwwwwwwwwwwwwwww;

    public wa0(t60<? super T, ? super U, ? extends R> t60Var, f70<? super T, ? extends h60<? extends U>> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.f70
    public Object apply(Object obj) throws Exception {
        return new kb0(this.Wwwwwwwwwwwwwwwwwwwwwww.apply(obj), new va0(this.Wwwwwwwwwwwwwwwwwwwwwwww, obj));
    }
}
