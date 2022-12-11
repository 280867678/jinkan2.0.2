package me.tvspark;

/* loaded from: classes4.dex */
public abstract class t50 implements v50 {
    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50 u50Var);

    @Override // me.tvspark.v50
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50 u50Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50Var, "s is null");
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(u50Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
