package com.qihoo.util;

import dalvik.system.PathClassLoader;

/* loaded from: classes.dex */
public class QHClassLoader extends PathClassLoader {
    public static native void interface23(String str);

    public QHClassLoader(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    public QHClassLoader(String str, String str2, ClassLoader classLoader) {
        super(str, str2, classLoader);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        try {
            interface23(str);
        } catch (Throwable th) {
        }
        return super.loadClass(str);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z) {
        try {
            interface23(str);
        } catch (Throwable th) {
        }
        return super.loadClass(str, z);
    }
}
