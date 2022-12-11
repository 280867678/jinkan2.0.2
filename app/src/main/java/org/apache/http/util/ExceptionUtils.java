package org.apache.http.util;

import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes4.dex */
public final class ExceptionUtils {
    public static final Method INIT_CAUSE_METHOD = getInitCauseMethod();

    public static Method getInitCauseMethod() {
        try {
            return Throwable.class.getMethod("initCause", Throwable.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static void initCause(Throwable th, Throwable th2) {
        Method method = INIT_CAUSE_METHOD;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (Exception unused) {
            }
        }
    }
}
