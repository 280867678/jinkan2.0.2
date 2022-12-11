package me.tvspark;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class h10 implements r10<T> {
    public final /* synthetic */ Constructor Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public h10(g10 g10Var, Constructor constructor) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = constructor;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.lang.Object] */
    @Override // me.tvspark.r10
    public T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to invoke ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" with no args");
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), e2);
        } catch (InvocationTargetException e3) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Failed to invoke ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" with no args");
            throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), e3.getTargetException());
        }
    }
}
