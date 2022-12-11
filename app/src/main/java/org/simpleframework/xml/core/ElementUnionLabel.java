package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class ElementUnionLabel extends TemplateLabel {
    public Contact contact;
    public GroupExtractor extractor;
    public Label label;
    public Expression path;
    public ElementUnion union;

    public ElementUnionLabel(Contact contact, ElementUnion elementUnion, Element element, Format format) throws Exception {
        this.extractor = new GroupExtractor(contact, elementUnion, format);
        this.label = new ElementLabel(contact, element, format);
        this.contact = contact;
        this.union = elementUnion;
    }

    @Override // org.simpleframework.xml.core.Label
    public Annotation getAnnotation() {
        return this.label.getAnnotation();
    }

    @Override // org.simpleframework.xml.core.Label
    public Contact getContact() {
        return this.contact;
    }

    @Override // org.simpleframework.xml.core.Label
    public Converter getConverter(Context context) throws Exception {
        Expression expression = getExpression();
        Contact contact = getContact();
        if (contact != null) {
            return new CompositeUnion(context, this.extractor, expression, contact);
        }
        throw new UnionException("Union %s was not declared on a field or method", this.label);
    }

    @Override // org.simpleframework.xml.core.Label
    public Decorator getDecorator() throws Exception {
        return this.label.getDecorator();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Type getDependent() throws Exception {
        return this.label.getDependent();
    }

    @Override // org.simpleframework.xml.core.Label
    /* renamed from: getEmpty */
    public Object mo5301getEmpty(Context context) throws Exception {
        return this.label.mo5301getEmpty(context);
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String getEntry() throws Exception {
        return this.label.getEntry();
    }

    @Override // org.simpleframework.xml.core.Label
    public Expression getExpression() throws Exception {
        if (this.path == null) {
            this.path = this.label.getExpression();
        }
        return this.path;
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Label getLabel(Class cls) throws Exception {
        Contact contact = getContact();
        if (this.extractor.isValid(cls)) {
            return this.extractor.getLabel(cls);
        }
        throw new UnionException("No type matches %s in %s for %s", cls, this.union, contact);
    }

    @Override // org.simpleframework.xml.core.Label
    public String getName() throws Exception {
        return this.label.getName();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String[] getNames() throws Exception {
        return this.extractor.getNames();
    }

    @Override // org.simpleframework.xml.core.Label
    public String getOverride() {
        return this.label.getOverride();
    }

    @Override // org.simpleframework.xml.core.Label
    public String getPath() throws Exception {
        return this.label.getPath();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public String[] getPaths() throws Exception {
        return this.extractor.getPaths();
    }

    @Override // org.simpleframework.xml.core.Label
    public Class getType() {
        return this.label.getType();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public Type getType(Class cls) throws Exception {
        Contact contact = getContact();
        if (this.extractor.isValid(cls)) {
            return this.extractor.isDeclared(cls) ? new OverrideType(contact, cls) : contact;
        }
        throw new UnionException("No type matches %s in %s for %s", cls, this.union, contact);
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isCollection() {
        return this.label.isCollection();
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isData() {
        return this.label.isData();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isInline() {
        return this.label.isInline();
    }

    @Override // org.simpleframework.xml.core.Label
    public boolean isRequired() {
        return this.label.isRequired();
    }

    @Override // org.simpleframework.xml.core.TemplateLabel, org.simpleframework.xml.core.Label
    public boolean isUnion() {
        return true;
    }

    @Override // org.simpleframework.xml.core.Label
    public String toString() {
        return this.label.toString();
    }
}
