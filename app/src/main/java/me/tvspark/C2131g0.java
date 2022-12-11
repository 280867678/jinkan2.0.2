package me.tvspark;

import java.lang.reflect.InvocationTargetException;

@Deprecated
/* renamed from: me.tvspark.g0 */
/* loaded from: classes4.dex */
public final class C2131g0 {
    public static AbstractC2057e0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        try {
            try {
                Object newInstance = Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (!(newInstance instanceof AbstractC2057e0)) {
                    throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Expected instanceof GlideModule, but found: ", newInstance));
                }
                return (AbstractC2057e0) newInstance;
            } catch (IllegalAccessException e) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls4, e);
                throw null;
            } catch (InstantiationException e2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls3, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls2, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<?> cls, Exception exc) {
        throw new RuntimeException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unable to instantiate GlideModule implementation for ", (Class) cls), exc);
    }
}
