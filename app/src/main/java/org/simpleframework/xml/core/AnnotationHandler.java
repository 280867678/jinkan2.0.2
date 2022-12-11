package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.http.message.TokenParser;
import org.eclipse.jetty.util.B64Code;

/* loaded from: classes5.dex */
public class AnnotationHandler implements InvocationHandler {
    public static final String ATTRIBUTE = "attribute";
    public static final String CLASS = "annotationType";
    public static final String EQUAL = "equals";
    public static final String REQUIRED = "required";
    public static final String STRING = "toString";
    public final boolean attribute;
    public final Comparer comparer;
    public final boolean required;
    public final Class type;

    public AnnotationHandler(Class cls) {
        this(cls, true);
    }

    public AnnotationHandler(Class cls, boolean z) {
        this(cls, z, false);
    }

    public AnnotationHandler(Class cls, boolean z, boolean z2) {
        this.comparer = new Comparer();
        this.attribute = z2;
        this.required = z;
        this.type = cls;
    }

    private void attributes(StringBuilder sb) {
        Method[] declaredMethods = this.type.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            String name = declaredMethods[i].getName();
            Object value = value(declaredMethods[i]);
            if (i > 0) {
                sb.append(',');
                sb.append(TokenParser.f4579SP);
            }
            sb.append(name);
            sb.append(B64Code.__pad);
            sb.append(value);
        }
        sb.append(')');
    }

    private boolean equals(Object obj, Object[] objArr) throws Throwable {
        Annotation annotation = (Annotation) obj;
        Annotation annotation2 = (Annotation) objArr[0];
        if (annotation.annotationType() == annotation2.annotationType()) {
            return this.comparer.equals(annotation, annotation2);
        }
        throw new PersistenceException("Annotation %s is not the same as %s", annotation, annotation2);
    }

    private void name(StringBuilder sb) {
        String name = this.type.getName();
        sb.append('@');
        sb.append(name);
        sb.append('(');
    }

    private Object value(Method method) {
        boolean z;
        String name = method.getName();
        if (name.equals(REQUIRED)) {
            z = this.required;
        } else if (!name.equals(ATTRIBUTE)) {
            return method.getDefaultValue();
        } else {
            z = this.attribute;
        }
        return Boolean.valueOf(z);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        boolean z;
        String name = method.getName();
        if (name.equals(STRING)) {
            return toString();
        }
        if (name.equals(EQUAL)) {
            z = equals(obj, objArr);
        } else if (name.equals(CLASS)) {
            return this.type;
        } else {
            if (name.equals(REQUIRED)) {
                z = this.required;
            } else if (!name.equals(ATTRIBUTE)) {
                return method.getDefaultValue();
            } else {
                z = this.attribute;
            }
        }
        return Boolean.valueOf(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            name(sb);
            attributes(sb);
        }
        return sb.toString();
    }
}
