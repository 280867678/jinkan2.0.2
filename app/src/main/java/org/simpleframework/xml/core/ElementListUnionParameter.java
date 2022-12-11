package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class ElementListUnionParameter extends TemplateParameter {
    public final Contact contact;
    public final Expression expression;
    public final int index;
    public final Object key;
    public final Label label;
    public final String name;
    public final String path;
    public final Class type;

    /* loaded from: classes5.dex */
    public static class Contact extends ParameterContact<ElementList> {
        public Contact(ElementList elementList, Constructor constructor, int i) {
            super(elementList, constructor, i);
        }

        @Override // org.simpleframework.xml.core.ParameterContact, org.simpleframework.xml.core.Contact
        public String getName() {
            return ((ElementList) this.label).name();
        }
    }

    public ElementListUnionParameter(Constructor constructor, ElementListUnion elementListUnion, ElementList elementList, Format format, int i) throws Exception {
        Contact contact = new Contact(elementList, constructor, i);
        this.contact = contact;
        ElementListUnionLabel elementListUnionLabel = new ElementListUnionLabel(contact, elementListUnion, elementList, format);
        this.label = elementListUnionLabel;
        this.expression = elementListUnionLabel.getExpression();
        this.path = this.label.getPath();
        this.type = this.label.getType();
        this.name = this.label.getName();
        this.key = this.label.getKey();
        this.index = i;
    }

    @Override // org.simpleframework.xml.core.Parameter
    public Annotation getAnnotation() {
        return this.contact.getAnnotation();
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
    public boolean isPrimitive() {
        return this.type.isPrimitive();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public boolean isRequired() {
        return this.label.isRequired();
    }

    @Override // org.simpleframework.xml.core.Parameter
    public String toString() {
        return this.contact.toString();
    }
}
