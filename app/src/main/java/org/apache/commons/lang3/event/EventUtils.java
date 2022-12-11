package org.apache.commons.lang3.event;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import me.tvspark.outline;
import org.apache.commons.lang3.reflect.MethodUtils;

/* loaded from: classes4.dex */
public class EventUtils {

    /* loaded from: classes4.dex */
    public static class EventBindingInvocationHandler implements InvocationHandler {
        public final Set<String> eventTypes;
        public final String methodName;
        public final Object target;

        public EventBindingInvocationHandler(Object obj, String str, String[] strArr) {
            this.target = obj;
            this.methodName = str;
            this.eventTypes = new HashSet(Arrays.asList(strArr));
        }

        private boolean hasMatchingParametersMethod(Method method) {
            return MethodUtils.getAccessibleMethod(this.target.getClass(), this.methodName, method.getParameterTypes()) != null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.eventTypes.isEmpty() || this.eventTypes.contains(method.getName())) {
                return hasMatchingParametersMethod(method) ? MethodUtils.invokeMethod(this.target, this.methodName, objArr) : MethodUtils.invokeMethod(this.target, this.methodName, new Object[0]);
            }
            return null;
        }
    }

    public static <L> void addEventListener(Object obj, Class<L> cls, L l) {
        try {
            MethodUtils.invokeMethod(obj, "add" + cls.getSimpleName(), l);
        } catch (IllegalAccessException unused) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Class ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" does not have an accessible add");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" method which takes a parameter of type ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(cls.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(".");
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } catch (NoSuchMethodException unused2) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Class ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(obj.getClass().getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" does not have a public add");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getSimpleName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" method which takes a parameter of type ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(cls.getName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(".");
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unable to add listener.", e.getCause());
        }
    }

    public static <L> void bindEventsToMethod(Object obj, String str, Object obj2, Class<L> cls, String... strArr) {
        addEventListener(obj2, cls, cls.cast(Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new EventBindingInvocationHandler(obj, str, strArr))));
    }
}
