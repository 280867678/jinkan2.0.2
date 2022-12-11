package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/* loaded from: classes5.dex */
public class DetailScanner implements Detail {
    public DefaultType access;
    public NamespaceList declaration;
    public List<FieldDetail> fields;
    public Annotation[] labels;
    public List<MethodDetail> methods;
    public String name;
    public Namespace namespace;
    public Order order;
    public DefaultType override;
    public boolean required;
    public Root root;
    public boolean strict;
    public Class type;

    public DetailScanner(Class cls) {
        this(cls, null);
    }

    public DetailScanner(Class cls, DefaultType defaultType) {
        this.methods = new LinkedList();
        this.fields = new LinkedList();
        this.labels = cls.getDeclaredAnnotations();
        this.override = defaultType;
        this.strict = true;
        this.type = cls;
        scan(cls);
    }

    private void access(Annotation annotation) {
        if (annotation != null) {
            Default r2 = (Default) annotation;
            this.required = r2.required();
            this.access = r2.value();
        }
    }

    private void extract(Class cls) {
        Annotation[] annotationArr;
        for (Annotation annotation : this.labels) {
            if (annotation instanceof Namespace) {
                namespace(annotation);
            }
            if (annotation instanceof NamespaceList) {
                scope(annotation);
            }
            if (annotation instanceof Root) {
                root(annotation);
            }
            if (annotation instanceof Order) {
                order(annotation);
            }
            if (annotation instanceof Default) {
                access(annotation);
            }
        }
    }

    private void fields(Class cls) {
        for (Field field : cls.getDeclaredFields()) {
            this.fields.add(new FieldDetail(field));
        }
    }

    private boolean isEmpty(String str) {
        return str.length() == 0;
    }

    private void methods(Class cls) {
        for (Method method : cls.getDeclaredMethods()) {
            this.methods.add(new MethodDetail(method));
        }
    }

    private void namespace(Annotation annotation) {
        if (annotation != null) {
            this.namespace = (Namespace) annotation;
        }
    }

    private void order(Annotation annotation) {
        if (annotation != null) {
            this.order = (Order) annotation;
        }
    }

    private void root(Annotation annotation) {
        if (annotation != null) {
            Root root = (Root) annotation;
            String simpleName = this.type.getSimpleName();
            String name = root.name();
            if (isEmpty(name)) {
                name = Reflector.getName(simpleName);
            }
            this.strict = root.strict();
            this.root = root;
            this.name = name;
        }
    }

    private void scan(Class cls) {
        methods(cls);
        fields(cls);
        extract(cls);
    }

    private void scope(Annotation annotation) {
        if (annotation != null) {
            this.declaration = (NamespaceList) annotation;
        }
    }

    @Override // org.simpleframework.xml.core.Detail
    public DefaultType getAccess() {
        DefaultType defaultType = this.override;
        return defaultType != null ? defaultType : this.access;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Annotation[] getAnnotations() {
        return this.labels;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Constructor[] getConstructors() {
        return this.type.getDeclaredConstructors();
    }

    @Override // org.simpleframework.xml.core.Detail
    public List<FieldDetail> getFields() {
        return this.fields;
    }

    @Override // org.simpleframework.xml.core.Detail
    public List<MethodDetail> getMethods() {
        return this.methods;
    }

    @Override // org.simpleframework.xml.core.Detail
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Namespace getNamespace() {
        return this.namespace;
    }

    @Override // org.simpleframework.xml.core.Detail
    public NamespaceList getNamespaceList() {
        return this.declaration;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Order getOrder() {
        return this.order;
    }

    @Override // org.simpleframework.xml.core.Detail
    public DefaultType getOverride() {
        return this.override;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Root getRoot() {
        return this.root;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Class getSuper() {
        Class superclass = this.type.getSuperclass();
        if (superclass == Object.class) {
            return null;
        }
        return superclass;
    }

    @Override // org.simpleframework.xml.core.Detail
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Detail
    public boolean isInstantiable() {
        if (Modifier.isStatic(this.type.getModifiers())) {
            return true;
        }
        return !this.type.isMemberClass();
    }

    @Override // org.simpleframework.xml.core.Detail
    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    @Override // org.simpleframework.xml.core.Detail
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.Detail
    public boolean isStrict() {
        return this.strict;
    }

    public String toString() {
        return this.type.toString();
    }
}
