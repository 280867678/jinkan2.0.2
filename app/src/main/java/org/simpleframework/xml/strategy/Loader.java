package org.simpleframework.xml.strategy;

/* loaded from: classes5.dex */
public class Loader {
    public static ClassLoader getCallerClassLoader() throws Exception {
        return Loader.class.getClassLoader();
    }

    public static ClassLoader getClassLoader() throws Exception {
        return Thread.currentThread().getContextClassLoader();
    }

    public Class load(String str) throws Exception {
        ClassLoader classLoader = getClassLoader();
        if (classLoader == null) {
            classLoader = getCallerClassLoader();
        }
        return classLoader.loadClass(str);
    }
}
