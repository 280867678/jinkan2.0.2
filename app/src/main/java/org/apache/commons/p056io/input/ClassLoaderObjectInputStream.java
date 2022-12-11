package org.apache.commons.p056io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.lang.reflect.Proxy;

/* renamed from: org.apache.commons.io.input.ClassLoaderObjectInputStream */
/* loaded from: classes4.dex */
public class ClassLoaderObjectInputStream extends ObjectInputStream {
    public final ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream) throws IOException, StreamCorruptedException {
        super(inputStream);
        this.classLoader = classLoader;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        try {
            return Class.forName(objectStreamClass.getName(), false, this.classLoader);
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveProxyClass(String[] strArr) throws IOException, ClassNotFoundException {
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i], false, this.classLoader);
        }
        try {
            return Proxy.getProxyClass(this.classLoader, clsArr);
        } catch (IllegalArgumentException unused) {
            return super.resolveProxyClass(strArr);
        }
    }
}
