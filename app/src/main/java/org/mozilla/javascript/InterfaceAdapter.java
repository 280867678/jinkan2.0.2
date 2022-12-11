package org.mozilla.javascript;

import java.lang.reflect.Method;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.InterfaceAdapter;

/* loaded from: classes5.dex */
public class InterfaceAdapter {
    public final Object proxyHelper;

    public InterfaceAdapter(ContextFactory contextFactory, Class<?> cls) {
        this.proxyHelper = VMBridge.instance.getInterfaceProxyHelper(contextFactory, new Class[]{cls});
    }

    public static Object create(Context context, Class<?> cls, ScriptableObject scriptableObject) {
        InterfaceAdapter interfaceAdapter;
        if (cls.isInterface()) {
            Scriptable topCallScope = ScriptRuntime.getTopCallScope(context);
            ClassCache classCache = ClassCache.get(topCallScope);
            InterfaceAdapter interfaceAdapter2 = (InterfaceAdapter) classCache.getInterfaceAdapter(cls);
            ContextFactory factory = context.getFactory();
            if (interfaceAdapter2 == null) {
                Method[] methods = cls.getMethods();
                if (scriptableObject instanceof Callable) {
                    int length = methods.length;
                    if (length == 0) {
                        throw Context.reportRuntimeError1("msg.no.empty.interface.conversion", cls.getName());
                    }
                    if (length > 1) {
                        String name = methods[0].getName();
                        for (int i = 1; i < length; i++) {
                            if (!name.equals(methods[i].getName())) {
                                throw Context.reportRuntimeError1("msg.no.function.interface.conversion", cls.getName());
                            }
                        }
                    }
                }
                InterfaceAdapter interfaceAdapter3 = new InterfaceAdapter(factory, cls);
                classCache.cacheInterfaceAdapter(cls, interfaceAdapter3);
                interfaceAdapter = interfaceAdapter3;
            } else {
                interfaceAdapter = interfaceAdapter2;
            }
            return VMBridge.instance.newInterfaceProxy(interfaceAdapter.proxyHelper, factory, interfaceAdapter, scriptableObject, topCallScope);
        }
        throw new IllegalArgumentException();
    }

    public Object invoke(ContextFactory contextFactory, final Object obj, final Scriptable scriptable, final Object obj2, final Method method, final Object[] objArr) {
        return contextFactory.call(new ContextAction() { // from class: me.tvspark.n21
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return InterfaceAdapter.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, scriptable, obj2, method, objArr, context);
            }
        });
    }

    /* renamed from: invokeImpl */
    public Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, Object obj, Scriptable scriptable, Object obj2, Method method, Object[] objArr) {
        if (!(obj instanceof Callable)) {
            String name = method.getName();
            obj = ScriptableObject.getProperty((Scriptable) obj, name);
            if (obj == Scriptable.NOT_FOUND) {
                Context.reportWarning(ScriptRuntime.getMessage1("msg.undefined.function.interface", name));
                Class<?> returnType = method.getReturnType();
                if (returnType != Void.TYPE) {
                    return Context.jsToJava(null, returnType);
                }
                return null;
            } else if (!(obj instanceof Callable)) {
                throw Context.reportRuntimeError1("msg.not.function.interface", name);
            }
        }
        Callable callable = (Callable) obj;
        WrapFactory wrapFactory = context.getWrapFactory();
        if (objArr == null) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int length = objArr.length;
            for (int i = 0; i != length; i++) {
                Object obj3 = objArr[i];
                if (!(obj3 instanceof String) && !(obj3 instanceof Number) && !(obj3 instanceof Boolean)) {
                    objArr[i] = wrapFactory.wrap(context, scriptable, obj3, null);
                }
            }
        }
        Object call = callable.call(context, scriptable, wrapFactory.wrapAsJavaObject(context, scriptable, obj2, null), objArr);
        Class<?> returnType2 = method.getReturnType();
        if (returnType2 == Void.TYPE) {
            return null;
        }
        return Context.jsToJava(call, returnType2);
    }
}
