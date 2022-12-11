package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

/* loaded from: classes5.dex */
public class ElementArrayLabel extends TemplateLabel {
    public boolean data;
    public Decorator decorator;
    public Introspector detail;
    public String entry;
    public Format format;
    public ElementArray label;
    public String name;
    public Expression path;
    public boolean required;
    public Class type;

    public ElementArrayLabel(Contact contact, ElementArray elementArray, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.decorator = new Qualifier(contact);
        this.required = elementArray.required();
        this.type = contact.getType();
        this.entry = elementArray.entry();
        this.data = elementArray.data();
        this.name = elementArray.name();
        this.format = format;
        this.label = elementArray;
    }

    private Converter getConverter(Context context, String str) throws Exception {
        Type dependent = getDependent();
        Contact contact = getContact();
        return !context.isPrimitive(dependent) ? new CompositeArray(context, contact, dependent, str) : new PrimitiveArray(context, contact, dependent, str);
    }

    @Override // org.simpleframework.xml.core.Label
    public Annotation getAnnotation() {
        return this.label;
    }

    @Override // org.simpleframework.xml.core.Label
    public Contact getContact() {
        return this.detail.getContact();
    }

    @Override // org.simpleframework.xml.core.Label
    public Converter getConverter(Context context) throws Exception {
        Contact contact = getContact();
        String entry = getEntry();
        if (this.type.isArray()) {
            return getConverter(context, entry);
        }
        throw new InstantiationException("Type is not an array %s for %s", this.type, contact);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() throws Exception {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Type getDependent() {
        Class<?> componentType = this.type.getComponentType();
        return componentType == null ? new ClassType(this.type) : new ClassType(componentType);
    }

    @Override // org.simpleframework.xml.core.Label
    /* renamed from: getEmpty */
    public Object mo5301getEmpty(Context context) throws Exception {
        ArrayFactory arrayFactory = new ArrayFactory(context, new ClassType(this.type));
        if (!this.label.empty()) {
            return arrayFactory.getInstance();
        }
        return null;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String getEntry() throws Exception {
        Style style = this.format.getStyle();
        if (this.detail.isEmpty(this.entry)) {
            this.entry = this.detail.getEntry();
        }
        return style.getElement(this.entry);
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() throws Exception {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() throws Exception {
        return this.format.getStyle().getElement(this.detail.getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() throws Exception {
        return getExpression().getElement(getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.data;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.Label
    public String toString() {
        return this.detail.toString();
    }
}
