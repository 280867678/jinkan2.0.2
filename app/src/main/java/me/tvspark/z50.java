package me.tvspark;

/* loaded from: classes4.dex */
public abstract class z50<T> implements b60<T> {
    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var);

    @Override // me.tvspark.b60
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60<? super T> a60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60Var, "observer is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60Var, "observer returned by the RxJavaPlugins hook is null");
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a60Var);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
