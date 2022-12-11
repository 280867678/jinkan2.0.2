package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class VersionLabel extends TemplateLabel {
    public Decorator decorator;
    public Introspector detail;
    public Format format;
    public Version label;
    public String name;
    public Expression path;
    public boolean required;
    public Class type;

    public VersionLabel(Contact contact, Version version, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.decorator = new Qualifier(contact);
        this.required = version.required();
        this.type = contact.getType();
        this.name = version.name();
        this.format = format;
        this.label = version;
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
        String mo5301getEmpty = mo5301getEmpty(context);
        Contact contact = getContact();
        if (context.isFloat(contact)) {
            return new Primitive(context, contact, mo5301getEmpty);
        }
        throw new AttributeException("Cannot use %s to represent %s", this.label, contact);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() throws Exception {
        return this.decorator;
    }

    @Override // org.simpleframework.xml.core.Label
    /* renamed from: getEmpty  reason: collision with other method in class */
    public String mo5301getEmpty(Context context) {
        return null;
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
        return this.format.getStyle().getAttribute(this.detail.getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.name;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() throws Exception {
        return getExpression().getAttribute(getName());
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isAttribute() {
        return true;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return false;
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
