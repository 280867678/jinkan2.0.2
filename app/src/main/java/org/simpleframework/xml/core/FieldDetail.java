package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public class FieldDetail {
    public final Field field;
    public final Annotation[] list;
    public final String name;

    public FieldDetail(Field field) {
        this.list = field.getDeclaredAnnotations();
        this.name = field.getName();
        this.field = field;
    }

    public Annotation[] getAnnotations() {
        return this.list;
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }
}
