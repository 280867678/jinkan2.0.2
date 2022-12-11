package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public class CacheParameter implements Parameter {
    public final Annotation annotation;
    public final boolean attribute;
    public final Expression expression;
    public final int index;
    public final Object key;
    public final String name;
    public final String path;
    public final boolean primitive;
    public final boolean required;
    public final String string;
    public final boolean text;
    public final Class type;

    public CacheParameter(Parameter parameter, Label label) throws Exception {
        this.annotation = parameter.getAnnotation();
        this.expression = parameter.getExpression();
        this.attribute = parameter.isAttribute();
        this.primitive = parameter.isPrimitive();
        this.required = label.isRequired();
        this.string = parameter.toString();
        this.text = parameter.isText();
        this.index = parameter.getIndex();
        this.name = parameter.getName();
        this.path = parameter.getPath();
        this.type = parameter.getType();
        this.key = label.getKey();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Annotation getAnnotation() {
        return this.annotation;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Expression getExpression() {
        return this.expression;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public int getIndex() {
        return this.index;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Object getKey() {
        return this.key;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String getName() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String getPath() {
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isAttribute() {
        return this.attribute;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isPrimitive() {
        return this.primitive;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isText() {
        return this.text;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String toString() {
        return this.string;
    }
}
