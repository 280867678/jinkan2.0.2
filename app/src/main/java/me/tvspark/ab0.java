package me.tvspark;

/* loaded from: classes4.dex */
public final class ab0<T> implements x60<T> {
    public final j60<T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public ab0(j60<T> j60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = j60Var;
    }

    @Override // me.tvspark.x60
    public void accept(T t) throws Exception {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.onNext(t);
    }
}
