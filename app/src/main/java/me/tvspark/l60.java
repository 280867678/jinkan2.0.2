package me.tvspark;

/* loaded from: classes4.dex */
public abstract class l60<T> implements n60<T> {
    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super T> m60Var);

    @Override // me.tvspark.n60
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60<? super T> m60Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, "subscriber is null");
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(m60Var);
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
