package me.tvspark;

/* loaded from: classes4.dex */
public final class za0<T> implements x60<Throwable> {
    public final j60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public za0(j60<T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
    }

    @Override // me.tvspark.x60
    public void accept(Throwable th) throws Exception {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
    }
}
