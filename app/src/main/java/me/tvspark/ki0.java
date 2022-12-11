package me.tvspark;

/* loaded from: classes4.dex */
public class ki0 {
    public static final li0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        li0 li0Var = null;
        try {
            li0Var = (li0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (li0Var == null) {
            li0Var = new li0();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = li0Var;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hi0 hi0Var) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hi0Var);
    }

    public static ij0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class cls) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            return new ei0(cls);
        }
        throw null;
    }
}
