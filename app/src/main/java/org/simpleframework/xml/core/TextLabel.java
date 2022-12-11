package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class TextLabel extends TemplateLabel {
    public Contact contact;
    public boolean data;
    public Introspector detail;
    public String empty;
    public Text label;
    public Expression path;
    public boolean required;
    public Class type;

    public TextLabel(Contact contact, Text text, Format format) {
        this.detail = new Introspector(contact, this, format);
        this.required = text.required();
        this.type = contact.getType();
        this.empty = text.empty();
        this.data = text.data();
        this.contact = contact;
        this.label = text;
    }

    @Override // org.simpleframework.xml.core.Label
    public Annotation getAnnotation() {
        return this.label;
    }

    @Override // org.simpleframework.xml.core.Label
    public Contact getContact() {
        return this.contact;
    }

    @Override // org.simpleframework.xml.core.Label
    public Converter getConverter(Context context) throws Exception {
        String mo5301getEmpty = mo5301getEmpty(context);
        Contact contact = getContact();
        if (context.isPrimitive(contact)) {
            return new Primitive(context, contact, mo5301getEmpty);
        }
        throw new TextException("Cannot use %s to represent %s", contact, this.label);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() throws Exception {
        return null;
    }

    @Override // org.simpleframework.xml.core.Label
    /* renamed from: getEmpty  reason: collision with other method in class */
    public String mo5301getEmpty(Context context) {
        if (this.detail.isEmpty(this.empty)) {
            return null;
        }
        return this.empty;
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() throws Exception {
        if (this.path == null) {
            this.path = this.detail.getExpression();
        }
        return this.path;
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() {
        return "";
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.contact.toString();
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() throws Exception {
        return getExpression().getPath();
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.type;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.data;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isInline() {
        return true;
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isRequired() {
        return this.required;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isText() {
        return true;
    }

    @Override // org.simpleframework.xml.core.Label
    public String toString() {
        return this.detail.toString();
    }
}
