package me.tvspark;

/* loaded from: classes4.dex */
public final class jb0<R, T> extends x80<T, R> {
    public final g60<? extends R, ? super T> Wwwwwwwwwwwwwwwwwwwwwww;

    public jb0(h60<T> h60Var, g60<? extends R, ? super T> g60Var) {
        super(h60Var);
        this.Wwwwwwwwwwwwwwwwwwwwwww = g60Var;
    }

    @Override // me.tvspark.d60
    public void subscribeActual(j60<? super R> j60Var) {
        try {
            j60<? super Object> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j60Var);
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "Operator " + this.Wwwwwwwwwwwwwwwwwwwwwww + " returned a null Observer");
            this.Wwwwwwwwwwwwwwwwwwwwwwww.subscribe(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
