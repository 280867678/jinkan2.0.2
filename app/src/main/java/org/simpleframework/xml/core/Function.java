package org.simpleframework.xml.core;

import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class Function {
    public final boolean contextual;
    public final Method method;

    public Function(Method method) {
        this(method, false);
    }

    public Function(Method method, boolean z) {
        this.contextual = z;
        this.method = method;
    }

    public Object call(Context context, Object obj) throws Exception {
        if (obj != null) {
            return this.contextual ? this.method.invoke(obj, context.getSession().getMap()) : this.method.invoke(obj, new Object[0]);
        }
        return null;
    }
}
