package org.mozilla.javascript;

/* loaded from: classes5.dex */
public class DefiningClassLoader extends ClassLoader implements GeneratedClassLoader {
    public final ClassLoader parentLoader;

    public DefiningClassLoader() {
        this.parentLoader = DefiningClassLoader.class.getClassLoader();
    }

    public DefiningClassLoader(ClassLoader classLoader) {
        this.parentLoader = classLoader;
    }

    @Override // org.mozilla.javascript.GeneratedClassLoader
    public Class<?> defineClass(String str, byte[] bArr) {
        return super.defineClass(str, bArr, 0, bArr.length, SecurityUtilities.getProtectionDomain(DefiningClassLoader.class));
    }

    @Override // org.mozilla.javascript.GeneratedClassLoader
    public void linkClass(Class<?> cls) {
        resolveClass(cls);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            ClassLoader classLoader = this.parentLoader;
            findLoadedClass = classLoader != null ? classLoader.loadClass(str) : findSystemClass(str);
        }
        if (z) {
            resolveClass(findLoadedClass);
        }
        return findLoadedClass;
    }
}
