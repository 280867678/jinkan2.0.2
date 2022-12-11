package me.tvspark;

/* loaded from: classes4.dex */
public abstract class x50<T> implements r51<T> {
    public static final int Wwwwwwwwwwwwwwwwwwwwwwww = Math.max(16, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51<? super T> s51Var);

    @Override // me.tvspark.r51
    public final void subscribe(s51<? super T> s51Var) {
        l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51Var, "s is null");
        try {
            l70.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51Var, "Plugin returned null Subscriber");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(s51Var);
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
