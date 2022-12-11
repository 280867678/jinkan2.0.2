package com.sun.script.javascript;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import org.mozilla.javascript.ClassShutter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.WrapFactory;
import sun.security.util.SecurityConstants;

/* loaded from: classes3.dex */
public final class RhinoWrapFactory extends WrapFactory {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static RhinoWrapFactory theInstance;

    /* loaded from: classes3.dex */
    public static class RhinoJavaObject extends NativeJavaObject {
        public RhinoJavaObject(Scriptable scriptable, Object obj, Class cls) {
            super(scriptable, null, cls);
            this.javaObject = obj;
        }
    }

    public static synchronized WrapFactory getInstance() {
        RhinoWrapFactory rhinoWrapFactory;
        synchronized (RhinoWrapFactory.class) {
            if (theInstance == null) {
                theInstance = new RhinoWrapFactory();
            }
            rhinoWrapFactory = theInstance;
        }
        return rhinoWrapFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    @Override // org.mozilla.javascript.WrapFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class cls) {
        String str;
        Class<?> declaringClass;
        SecurityManager securityManager = System.getSecurityManager();
        ClassShutter rhinoClassShutter = RhinoClassShutter.getInstance();
        if (obj instanceof ClassLoader) {
            if (securityManager != null) {
                securityManager.checkPermission(SecurityConstants.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return super.wrapAsJavaObject(context, scriptable, obj, cls);
        }
        if (obj instanceof Class) {
            declaringClass = (Class) obj;
        } else if (!(obj instanceof Member)) {
            str = null;
            if (str == null) {
                if (rhinoClassShutter.visibleToScripts(str)) {
                    return super.wrapAsJavaObject(context, scriptable, obj, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (rhinoClassShutter.visibleToScripts(cls2.getName())) {
                return super.wrapAsJavaObject(context, scriptable, obj, cls);
            }
            if (cls == null || !cls.isInterface()) {
                do {
                    cls2 = cls2.getSuperclass();
                } while (!rhinoClassShutter.visibleToScripts(cls2.getName()));
                cls = cls2;
            }
            return new RhinoJavaObject(scriptable, obj, cls);
        } else {
            Member member = (Member) obj;
            if (securityManager != null && !Modifier.isPublic(member.getModifiers())) {
                return null;
            }
            declaringClass = member.getDeclaringClass();
        }
        str = declaringClass.getName();
        if (str == null) {
        }
    }
}
