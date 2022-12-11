package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public class ClassTransform implements Transform<Class> {
    public static final String BOOLEAN = "boolean";
    public static final String BYTE = "byte";
    public static final String CHARACTER = "char";
    public static final String DOUBLE = "double";
    public static final String FLOAT = "float";
    public static final String INTEGER = "int";
    public static final String LONG = "long";
    public static final String SHORT = "short";
    public static final String VOID = "void";

    private ClassLoader getCallerClassLoader() {
        return ClassTransform.class.getClassLoader();
    }

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private Class readPrimitive(String str) throws Exception {
        if (str.equals(BYTE)) {
            return Byte.TYPE;
        }
        if (str.equals(SHORT)) {
            return Short.TYPE;
        }
        if (str.equals(INTEGER)) {
            return Integer.TYPE;
        }
        if (str.equals(LONG)) {
            return Long.TYPE;
        }
        if (str.equals(CHARACTER)) {
            return Character.TYPE;
        }
        if (str.equals(FLOAT)) {
            return Float.TYPE;
        }
        if (str.equals(DOUBLE)) {
            return Double.TYPE;
        }
        if (str.equals(BOOLEAN)) {
            return Boolean.TYPE;
        }
        if (!str.equals(VOID)) {
            return null;
        }
        return Void.TYPE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.simpleframework.xml.transform.Transform
    /* renamed from: read */
    public Class mo5334read(String str) throws Exception {
        Class readPrimitive = readPrimitive(str);
        if (readPrimitive == null) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader == null) {
                classLoader = getCallerClassLoader();
            }
            return classLoader.loadClass(str);
        }
        return readPrimitive;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Class cls) throws Exception {
        return cls.getName();
    }
}
