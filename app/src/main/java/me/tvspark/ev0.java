package me.tvspark;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes4.dex */
public class ev0 {
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dv0.class);
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final iv0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final bv0[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HashMap<Class<?>, Method> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashMap<>();
    public Class<? extends Exception> Wwwwwwwwwwwwwwwwwwwwwwwwwww = NoSuchFieldException.class;

    public ev0(Class<?> cls, bv0[] bv0VarArr, iv0 iv0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bv0VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iv0Var;
        String name = cls.getName();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = name;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = name.startsWith("java.") ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new StringBuilder("net.minidev.asm."), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "AccAccess") : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.concat("AccAccess");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.replace('.', '/');
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.replace('.', '/');
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l51 l51Var, Class<?> cls) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mapping " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " failed to map field:");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 2);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "<init>", "(Ljava/lang/String;)V");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l51 l51Var, int i, int i2, k51 k51Var) {
        int i3;
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, i);
        if (i2 == 0) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(154, k51Var);
            return;
        }
        if (i2 == 1) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        } else if (i2 == 2) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(5);
        } else if (i2 == 3) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(6);
        } else {
            if (i2 == 4) {
                i3 = 7;
            } else if (i2 == 5) {
                i3 = 8;
            } else if (i2 < 6) {
                throw new RuntimeException("non supported negative values");
            } else {
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16, i2);
            }
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
        }
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(160, k51Var);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l51 l51Var, Class<?> cls) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(187, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(89);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("mapping " + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + " failed to map field:");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21, 2);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, "java/lang/Integer", AnnotationHandler.STRING, "(I)Ljava/lang/String;");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(183, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "<init>", "(Ljava/lang/String;)V");
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(191);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l51 l51Var, bv0 bv0Var) {
        int i;
        k51 k51Var;
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 1);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 3);
        o51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Class<?> cls = bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls);
        Method method = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.get(cls);
        if (method != null) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method.getDeclaringClass()), method.getName(), o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method));
        } else {
            if (bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEnum()) {
                k51Var = new k51();
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(198, k51Var);
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 3);
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/Object", AnnotationHandler.STRING, "()Ljava/lang/String;");
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(184, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, "valueOf", "(Ljava/lang/String;)L" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ";");
            } else if (cls.equals(String.class)) {
                k51Var = new k51();
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(198, k51Var);
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 3);
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, "java/lang/Object", AnnotationHandler.STRING, "()Ljava/lang/String;");
            } else {
                i = 192;
                l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(58, 3);
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(k51Var);
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3, 0, (Object[]) null, 0, (Object[]) null);
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 1);
            i = 192;
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(192, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(25, 3);
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(181, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        } else {
            l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(182, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), o51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bv0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        l51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(177);
    }
}
