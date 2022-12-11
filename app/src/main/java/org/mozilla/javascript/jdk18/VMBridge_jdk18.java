package org.mozilla.javascript.jdk18;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import me.tvspark.outline;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.InterfaceAdapter;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.VMBridge;
import org.simpleframework.xml.core.AnnotationHandler;

/* loaded from: classes5.dex */
public class VMBridge_jdk18 extends VMBridge {
    public ThreadLocal<Object[]> contextLocal = new ThreadLocal<>();

    @Override // org.mozilla.javascript.VMBridge
    public Context getContext(Object obj) {
        return (Context) ((Object[]) obj)[0];
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr) {
        try {
            return Proxy.getProxyClass(clsArr[0].getClassLoader(), clsArr).getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object getThreadContextHelper() {
        Object[] objArr = this.contextLocal.get();
        if (objArr == null) {
            Object[] objArr2 = new Object[1];
            this.contextLocal.set(objArr2);
            return objArr2;
        }
        return objArr;
    }

    @Override // org.mozilla.javascript.VMBridge
    public Object newInterfaceProxy(Object obj, final ContextFactory contextFactory, final InterfaceAdapter interfaceAdapter, final Object obj2, final Scriptable scriptable) {
        try {
            return ((Constructor) obj).newInstance(new InvocationHandler() { // from class: org.mozilla.javascript.jdk18.VMBridge_jdk18.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    if (method.getDeclaringClass() == Object.class) {
                        String name = method.getName();
                        if (name.equals(AnnotationHandler.EQUAL)) {
                            boolean z = false;
                            if (obj3 == objArr[0]) {
                                z = true;
                            }
                            return Boolean.valueOf(z);
                        } else if (name.equals("hashCode")) {
                            return Integer.valueOf(obj2.hashCode());
                        } else {
                            if (name.equals(AnnotationHandler.STRING)) {
                                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Proxy[");
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj2.toString());
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
                                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                            }
                        }
                    }
                    return interfaceAdapter.invoke(contextFactory, obj2, scriptable, obj3, method, objArr);
                }
            });
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (InvocationTargetException e3) {
            throw Context.throwAsScriptRuntimeEx(e3);
        }
    }

    @Override // org.mozilla.javascript.VMBridge
    public void setContext(Object obj, Context context) {
        ((Object[]) obj)[0] = context;
    }

    @Override // org.mozilla.javascript.VMBridge
    public boolean tryToMakeAccessible(AccessibleObject accessibleObject) {
        if (accessibleObject.isAccessible()) {
            return true;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception unused) {
        }
        return accessibleObject.isAccessible();
    }
}
