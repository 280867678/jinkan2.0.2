package me.tvspark;

/* loaded from: classes4.dex */
public final class qc0<T, R> extends l60<R> {
    public final f70<? super T, ? extends R> Wwwwwwwwwwwwwwwwwwwwwww;
    public final n60<? extends T> Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements m60<T> {
        public final /* synthetic */ m60 Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60 m60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = m60Var;
        }

        @Override // me.tvspark.m60
        public void onError(Throwable th) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
        }

        @Override // me.tvspark.m60
        public void onSubscribe(p60 p60Var) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onSubscribe(p60Var);
        }

        @Override // me.tvspark.m60
        public void onSuccess(T t) {
            try {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onSuccess(qc0.this.Wwwwwwwwwwwwwwwwwwwwwww.apply(t));
            } catch (Throwable th) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
                this.Wwwwwwwwwwwwwwwwwwwwwwww.onError(th);
            }
        }
    }

    public qc0(n60<? extends T> n60Var, f70<? super T, ? extends R> f70Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = n60Var;
        this.Wwwwwwwwwwwwwwwwwwwwwww = f70Var;
    }

    @Override // me.tvspark.l60
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super R> m60Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var));
    }
}
