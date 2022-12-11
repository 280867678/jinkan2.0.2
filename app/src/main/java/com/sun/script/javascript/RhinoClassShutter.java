package com.sun.script.javascript;

import java.util.HashMap;
import java.util.Map;
import org.mozilla.javascript.ClassShutter;

/* loaded from: classes3.dex */
public final class RhinoClassShutter implements ClassShutter {
    public static Map<String, Boolean> protectedClasses;
    public static RhinoClassShutter theInstance;

    public static synchronized ClassShutter getInstance() {
        RhinoClassShutter rhinoClassShutter;
        synchronized (RhinoClassShutter.class) {
            if (theInstance == null) {
                theInstance = new RhinoClassShutter();
                HashMap hashMap = new HashMap();
                protectedClasses = hashMap;
                hashMap.put("java.security.AccessController", Boolean.TRUE);
            }
            rhinoClassShutter = theInstance;
        }
        return rhinoClassShutter;
    }

    @Override // org.mozilla.javascript.ClassShutter
    public boolean visibleToScripts(String str) {
        int lastIndexOf;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && (lastIndexOf = str.lastIndexOf(".")) != -1) {
            try {
                securityManager.checkPackageAccess(str.substring(0, lastIndexOf));
            } catch (SecurityException unused) {
                return false;
            }
        }
        return protectedClasses.get(str) == null;
    }
}
