package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public class MethodContact implements Contact {
    public MethodPart get;
    public Class item;
    public Class[] items;
    public Annotation label;
    public String name;
    public Class owner;
    public MethodPart set;
    public Class type;

    public MethodContact(MethodPart methodPart) {
        this(methodPart, null);
    }

    public MethodContact(MethodPart methodPart, MethodPart methodPart2) {
        this.owner = methodPart.getDeclaringClass();
        this.label = methodPart.getAnnotation();
        this.items = methodPart.getDependents();
        this.item = methodPart.getDependent();
        this.type = methodPart.getType();
        this.name = methodPart.getName();
        this.set = methodPart2;
        this.get = methodPart;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Object get(Object obj) throws Exception {
        return this.get.getMethod().invoke(obj, new Object[0]);
    }

    @Override // org.simpleframework.xml.core.Contact
    public Annotation getAnnotation() {
        return this.label;
    }

    @Override // org.simpleframework.xml.strategy.Type
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        MethodPart methodPart;
        T t = (T) this.get.getAnnotation(cls);
        return cls == this.label.annotationType() ? (T) this.label : (t != null || (methodPart = this.set) == null) ? t : (T) methodPart.getAnnotation(cls);
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class getDeclaringClass() {
        return this.owner;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class getDependent() {
        return this.item;
    }

    @Override // org.simpleframework.xml.core.Contact
    public Class[] getDependents() {
        return this.items;
    }

    @Override // org.simpleframework.xml.core.Contact
    public String getName() {
        return this.name;
    }

    public MethodPart getRead() {
        return this.get;
    }

    @Override // org.simpleframework.xml.strategy.Type
    public Class getType() {
        return this.type;
    }

    public MethodPart getWrite() {
        return this.set;
    }

    @Override // org.simpleframework.xml.core.Contact
    public boolean isReadOnly() {
        return this.set == null;
    }

    @Override // org.simpleframework.xml.core.Contact
    public void set(Object obj, Object obj2) throws Exception {
        Class<?> declaringClass = this.get.getMethod().getDeclaringClass();
        MethodPart methodPart = this.set;
        if (methodPart != null) {
            methodPart.getMethod().invoke(obj, obj2);
            return;
        }
        throw new MethodException("Property '%s' is read only in %s", this.name, declaringClass);
    }

    @Override // org.simpleframework.xml.core.Contact, org.simpleframework.xml.strategy.Type
    public String toString() {
        return String.format("method '%s'", this.name);
    }
}
