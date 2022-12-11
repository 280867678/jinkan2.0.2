package me.tvspark;

import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* renamed from: me.tvspark.rz */
/* loaded from: classes4.dex */
public final class C2579rz {
    public static final Ordering<Constructor<?>> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Ordering.natural().onResultOf(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).reverse();

    /* renamed from: me.tvspark.rz$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2271jt<Constructor<?>, Boolean> {
        @Override // me.tvspark.AbstractC2271jt
        /* renamed from: apply */
        public Boolean mo4462apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<? extends Exception> cls) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cls, new Exception());
        } catch (Exception unused) {
            z = false;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z, "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static <X extends Exception> X Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Class<X> cls, Throwable th) {
        Object obj;
        for (E e : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.sortedCopy(Arrays.asList(cls.getConstructors()))) {
            Class<?>[] parameterTypes = e.getParameterTypes();
            Object[] objArr = new Object[parameterTypes.length];
            int i = 0;
            while (true) {
                obj = null;
                if (i < parameterTypes.length) {
                    Class<?> cls2 = parameterTypes[i];
                    if (!cls2.equals(String.class)) {
                        if (!cls2.equals(Throwable.class)) {
                            break;
                        }
                        objArr[i] = th;
                    } else {
                        objArr[i] = th.toString();
                    }
                    i++;
                } else {
                    try {
                        obj = e.newInstance(objArr);
                        break;
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
                    }
                }
            }
            X x = (X) obj;
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }
}
