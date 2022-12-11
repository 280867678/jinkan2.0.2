package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import me.tvspark.outline;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class Undefined implements Serializable {
    public static final long serialVersionUID = 9195680630202616767L;
    public static final Object instance = new Undefined();
    public static final Scriptable SCRIPTABLE_UNDEFINED = (Scriptable) Proxy.newProxyInstance(Undefined.class.getClassLoader(), new Class[]{Scriptable.class}, new InvocationHandler() { // from class: org.mozilla.javascript.Undefined.1
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals(AnnotationHandler.STRING)) {
                return "undefined";
            }
            if (!method.getName().equals(AnnotationHandler.EQUAL)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("undefined doesn't support ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(method.getName());
                throw new UnsupportedOperationException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            boolean z = false;
            if (objArr.length > 0 && Undefined.isUndefined(objArr[0])) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    });

    public static boolean isUndefined(Object obj) {
        return instance == obj || SCRIPTABLE_UNDEFINED == obj;
    }

    public boolean equals(Object obj) {
        return isUndefined(obj) || super.equals(obj);
    }

    public int hashCode() {
        return 0;
    }

    public Object readResolve() {
        return instance;
    }
}
