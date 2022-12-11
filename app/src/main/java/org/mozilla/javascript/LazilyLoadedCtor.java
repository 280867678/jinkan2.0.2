package org.mozilla.javascript;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes5.dex */
public final class LazilyLoadedCtor implements Serializable {
    public static final int STATE_BEFORE_INIT = 0;
    public static final int STATE_INITIALIZING = 1;
    public static final int STATE_WITH_VALUE = 2;
    public static final long serialVersionUID = 1;
    public final String className;
    public Object initializedValue;
    public final boolean privileged;
    public final String propertyName;
    public final ScriptableObject scope;
    public final boolean sealed;
    public int state;

    public LazilyLoadedCtor(ScriptableObject scriptableObject, String str, String str2, boolean z) {
        this(scriptableObject, str, str2, z, false);
    }

    public LazilyLoadedCtor(ScriptableObject scriptableObject, String str, String str2, boolean z, boolean z2) {
        this.scope = scriptableObject;
        this.propertyName = str;
        this.className = str2;
        this.sealed = z;
        this.privileged = z2;
        this.state = 0;
        scriptableObject.addLazilyInitializedValue(str, 0, this, 2);
    }

    private Object buildValue() {
        return this.privileged ? AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.mozilla.javascript.LazilyLoadedCtor.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                return LazilyLoadedCtor.this.buildValue0();
            }
        }) : buildValue0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object buildValue0() {
        Class<? extends Scriptable> cast = cast(Kit.classOrNull(this.className));
        if (cast != null) {
            try {
                BaseFunction buildClassCtor = ScriptableObject.buildClassCtor(this.scope, cast, this.sealed, false);
                if (buildClassCtor != null) {
                    return buildClassCtor;
                }
                Object obj = this.scope.get(this.propertyName, this.scope);
                if (obj != Scriptable.NOT_FOUND) {
                    return obj;
                }
            } catch (IllegalAccessException | InstantiationException | SecurityException | RhinoException unused) {
            } catch (InvocationTargetException e) {
                Throwable targetException = e.getTargetException();
                if (targetException instanceof RuntimeException) {
                    throw ((RuntimeException) targetException);
                }
            }
        }
        return Scriptable.NOT_FOUND;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Class<? extends Scriptable> cast(Class<?> cls) {
        return cls;
    }

    public Object getValue() {
        if (this.state == 2) {
            return this.initializedValue;
        }
        throw new IllegalStateException(this.propertyName);
    }

    public void init() {
        synchronized (this) {
            if (this.state == 1) {
                throw new IllegalStateException("Recursive initialization for " + this.propertyName);
            } else if (this.state == 0) {
                this.state = 1;
                Object obj = Scriptable.NOT_FOUND;
                this.initializedValue = buildValue();
                this.state = 2;
            }
        }
    }
}
