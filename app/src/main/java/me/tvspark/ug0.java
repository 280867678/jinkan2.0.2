package me.tvspark;

/* loaded from: classes4.dex */
public final class ug0 {
    public static final tg0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        int i;
        tg0 tg0Var;
        Object newInstance;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) property, '.', 0, false, 6);
            try {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < 0) {
                    i = Integer.parseInt(property) * 65536;
                } else {
                    int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1;
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = nk0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((CharSequence) property, '.', i2, false, 4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 < 0) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = property.length();
                    }
                    String substring = property.substring(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = property.substring(i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i = Integer.parseInt(substring2) + (Integer.parseInt(substring) * 65536);
                }
            } catch (NumberFormatException unused) {
            }
            if (i >= 65544) {
                try {
                    try {
                        newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    } catch (ClassNotFoundException unused2) {
                    }
                } catch (ClassNotFoundException unused3) {
                    Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        tg0Var = (tg0) newInstance2;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = tg0.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                }
                try {
                    tg0Var = (tg0) newInstance;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tg0Var;
                } catch (ClassCastException e2) {
                    ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                    ClassLoader classLoader4 = tg0.class.getClassLoader();
                    Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause2;
                }
            }
            if (i >= 65543) {
                try {
                    Object newInstance3 = Class.forName("me.tvspark.vg0").newInstance();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        try {
                            tg0Var = (tg0) newInstance3;
                        } catch (ClassCastException e3) {
                            ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader6 = tg0.class.getClassLoader();
                            Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause3;
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                } catch (ClassNotFoundException unused5) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        tg0Var = (tg0) newInstance4;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader8 = tg0.class.getClassLoader();
                        Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause4;
                    }
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tg0Var;
            }
            tg0Var = new tg0();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tg0Var;
        }
        i = 65542;
        if (i >= 65544) {
        }
        if (i >= 65543) {
        }
        tg0Var = new tg0();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = tg0Var;
    }
}
