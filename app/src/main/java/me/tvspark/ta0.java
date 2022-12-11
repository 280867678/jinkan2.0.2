package me.tvspark;

/* loaded from: classes4.dex */
public final class ta0 implements f70<d60<T>, h60<R>> {
    public final /* synthetic */ k60 Wwwwwwwwwwwwwwwwwwwwwww;
    public final /* synthetic */ f70 Wwwwwwwwwwwwwwwwwwwwwwww;

    public ta0(f70 f70Var, k60 k60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = f70Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = k60Var;
    }

    @Override // me.tvspark.f70
    public Object apply(Object obj) throws Exception {
        return d60.wrap((h60) this.Wwwwwwwwwwwwwwwwwwwwwwww.apply((d60) obj)).observeOn(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }
}
