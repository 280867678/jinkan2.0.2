package org.mozilla.javascript;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes5.dex */
public abstract class VMBridge {
    public static final VMBridge instance = makeInstance();

    public static VMBridge makeInstance() {
        VMBridge vMBridge;
        String[] strArr = {"org.mozilla.javascript.VMBridge_custom", "org.mozilla.javascript.jdk18.VMBridge_jdk18"};
        for (int i = 0; i != 2; i++) {
            Class<?> classOrNull = Kit.classOrNull(strArr[i]);
            if (classOrNull != null && (vMBridge = (VMBridge) Kit.newInstanceOrNull(classOrNull)) != null) {
                return vMBridge;
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }

    public abstract Context getContext(Object obj);

    public abstract Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr);

    public abstract Object getThreadContextHelper();

    public abstract Object newInterfaceProxy(Object obj, ContextFactory contextFactory, InterfaceAdapter interfaceAdapter, Object obj2, Scriptable scriptable);

    public abstract void setContext(Object obj, Context context);

    public abstract boolean tryToMakeAccessible(AccessibleObject accessibleObject);
}
