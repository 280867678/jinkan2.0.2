package me.tvspark;

import java.lang.reflect.Method;

@ef0
/* loaded from: classes4.dex */
public class tg0 {

    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
            if (me.tvspark.ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r6, java.lang.Throwable.class) != false) goto L11;
         */
        static {
            Method method;
            Method[] methods = Throwable.class.getMethods();
            ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    break;
                }
                Method method2 = methods[i];
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method2, "it");
                boolean z = true;
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method2.getName(), (Object) "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterTypes, "it.parameterTypes");
                    ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(parameterTypes, "$this$singleOrNull");
                    if (parameterTypes.length == 1) {
                        method = parameterTypes[0];
                    }
                }
                z = false;
                if (z) {
                    method = method2;
                    break;
                }
                i++;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = method;
            for (Method method3 : methods) {
                ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method3, "it");
                if (ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) method3.getName(), (Object) "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, Throwable th2) {
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th, "cause");
        ii0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(th2, "exception");
        Method method = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
