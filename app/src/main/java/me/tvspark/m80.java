package me.tvspark;

/* loaded from: classes4.dex */
public final class m80<T> implements t51 {
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public final T Wwwwwwwwwwwwwwwwwwwwwww;
    public final s51<? super T> Wwwwwwwwwwwwwwwwwwwwwwww;

    public m80(T t, s51<? super T> s51Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = t;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = s51Var;
    }

    @Override // me.tvspark.t51
    public void cancel() {
    }

    @Override // me.tvspark.t51
    public void request(long j) {
        if (j <= 0 || this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = true;
        s51<? super T> s51Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        s51Var.onNext((T) this.Wwwwwwwwwwwwwwwwwwwwwww);
        s51Var.onComplete();
    }
}
