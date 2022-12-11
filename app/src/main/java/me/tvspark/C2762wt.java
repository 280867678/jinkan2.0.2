package me.tvspark;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: me.tvspark.wt */
/* loaded from: classes4.dex */
public final class C2762wt {
    public static final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            try {
                Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getStackTraceDepth", Throwable.class);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == null) {
                    return;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.invoke(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Throwable());
            } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            }
        }
    }

    public static Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th) {
        if (th != null) {
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            return;
        }
        throw null;
    }
}
