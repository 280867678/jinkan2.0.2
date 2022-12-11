package me.tvspark;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class iv0 extends ClassLoader {
    public static final Class<?>[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dv0.class.getName();

    static {
        Class<?> cls = Integer.TYPE;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Class[]{String.class, byte[].class, cls, cls};
    }

    public iv0(ClassLoader classLoader) {
        super(classLoader);
    }

    public Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, byte[] bArr) throws ClassFormatError {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            declaredMethod.setAccessible(true);
            return (Class) declaredMethod.invoke(getParent(), str, bArr, 0, Integer.valueOf(bArr.length));
        } catch (Exception unused) {
            return defineClass(str, bArr, 0, bArr.length);
        }
    }

    @Override // java.lang.ClassLoader
    public synchronized Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (str.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return dv0.class;
        }
        return super.loadClass(str, z);
    }
}
