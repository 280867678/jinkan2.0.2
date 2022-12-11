package me.tvspark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import javax.script.Invocable;
import javax.script.ScriptException;

/* loaded from: classes4.dex */
public class n50 {
    public Invocable engine;

    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements InvocationHandler {
        public AccessControlContext Wwwwwwwwwwwwwwwwwwwwwww;
        public Object Wwwwwwwwwwwwwwwwwwwwwwww;

        /* renamed from: me.tvspark.n50$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3481Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements PrivilegedExceptionAction<Object> {
            public final /* synthetic */ Object[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ Method Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

            public C3481Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Method method, Object[] objArr) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = method;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = objArr;
            }

            @Override // java.security.PrivilegedExceptionAction
            public Object run() throws Exception {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this;
                Object obj = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                Invocable invocable = n50.this.engine;
                return obj == null ? invocable.invokeFunction(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : invocable.invokeMethod(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getName(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, AccessControlContext accessControlContext) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwww = accessControlContext;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return n50.this.convertResult(method, AccessController.doPrivileged(new C3481Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(method, n50.this.convertArguments(method, objArr)), this.Wwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    public n50(Invocable invocable) {
        this.engine = invocable;
    }

    public Object[] convertArguments(Method method, Object[] objArr) throws ScriptException {
        return objArr;
    }

    public Object convertResult(Method method, Object obj) throws ScriptException {
        throw null;
    }

    public <T> T getInterface(Object obj, Class<T> cls) throws ScriptException {
        if (cls == null || !cls.isInterface()) {
            throw new IllegalArgumentException("interface Class expected");
        }
        if (!isImplemented(obj, cls)) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, AccessController.getContext())));
    }

    public boolean isImplemented(Object obj, Class<?> cls) {
        throw null;
    }
}
