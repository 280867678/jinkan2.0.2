package me.tvspark;

/* loaded from: classes4.dex */
public final class x90<T> extends x80<T, T> {
    public final r60 Wwwwwwwwwwwwwwwwwwwwww;
    public final x60<? super p60> Wwwwwwwwwwwwwwwwwwwwwww;

    public x90(d60<T> d60Var, x60<? super p60> x60Var, r60 r60Var) {
        super(d60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = x60Var;
        this.Wwwwwwwwwwwwwwwwwwwwww = r60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(new a80(j60Var, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww));
    }
}
