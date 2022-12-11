package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class Comparer {
    public static final String NAME = "name";
    public final String[] ignore;

    public Comparer() {
        this("name");
    }

    public Comparer(String... strArr) {
        this.ignore = strArr;
    }

    private boolean isIgnore(Method method) {
        String name = method.getName();
        String[] strArr = this.ignore;
        if (strArr != null) {
            for (String str : strArr) {
                if (name.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Annotation annotation, Annotation annotation2) throws Exception {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        Class<? extends Annotation> annotationType2 = annotation2.annotationType();
        Method[] declaredMethods = annotationType.getDeclaredMethods();
        if (annotationType.equals(annotationType2)) {
            for (Method method : declaredMethods) {
                if (!isIgnore(method) && !method.invoke(annotation, new Object[0]).equals(method.invoke(annotation2, new Object[0]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
