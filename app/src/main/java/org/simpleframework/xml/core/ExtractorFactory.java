package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class ExtractorFactory {
    public final Contact contact;
    public final Format format;
    public final Annotation label;

    /* loaded from: classes5.dex */
    public static class ElementExtractor implements Extractor<Element> {
        public final Contact contact;
        public final Format format;
        public final ElementUnion union;

        public ElementExtractor(Contact contact, ElementUnion elementUnion, Format format) throws Exception {
            this.contact = contact;
            this.format = format;
            this.union = elementUnion;
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Element[] getAnnotations() {
            return this.union.value();
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Label getLabel(Element element) {
            return new ElementLabel(this.contact, element, this.format);
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Class getType(Element element) {
            Class type = element.type();
            return type == Void.TYPE ? this.contact.getType() : type;
        }
    }

    /* loaded from: classes5.dex */
    public static class ElementListExtractor implements Extractor<ElementList> {
        public final Contact contact;
        public final Format format;
        public final ElementListUnion union;

        public ElementListExtractor(Contact contact, ElementListUnion elementListUnion, Format format) throws Exception {
            this.contact = contact;
            this.format = format;
            this.union = elementListUnion;
        }

        @Override // org.simpleframework.xml.core.Extractor
        public ElementList[] getAnnotations() {
            return this.union.value();
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Label getLabel(ElementList elementList) {
            return new ElementListLabel(this.contact, elementList, this.format);
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Class getType(ElementList elementList) {
            return elementList.type();
        }
    }

    /* loaded from: classes5.dex */
    public static class ElementMapExtractor implements Extractor<ElementMap> {
        public final Contact contact;
        public final Format format;
        public final ElementMapUnion union;

        public ElementMapExtractor(Contact contact, ElementMapUnion elementMapUnion, Format format) throws Exception {
            this.contact = contact;
            this.format = format;
            this.union = elementMapUnion;
        }

        @Override // org.simpleframework.xml.core.Extractor
        public ElementMap[] getAnnotations() {
            return this.union.value();
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Label getLabel(ElementMap elementMap) {
            return new ElementMapLabel(this.contact, elementMap, this.format);
        }

        @Override // org.simpleframework.xml.core.Extractor
        public Class getType(ElementMap elementMap) {
            return elementMap.valueType();
        }
    }

    /* loaded from: classes5.dex */
    public static class ExtractorBuilder {
        public final Class label;
        public final Class type;

        public ExtractorBuilder(Class cls, Class cls2) {
            this.label = cls;
            this.type = cls2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Constructor getConstructor() throws Exception {
            return this.type.getConstructor(Contact.class, this.label, Format.class);
        }
    }

    public ExtractorFactory(Contact contact, Annotation annotation, Format format) {
        this.contact = contact;
        this.format = format;
        this.label = annotation;
    }

    private ExtractorBuilder getBuilder(Annotation annotation) throws Exception {
        if (annotation instanceof ElementUnion) {
            return new ExtractorBuilder(ElementUnion.class, ElementExtractor.class);
        }
        if (annotation instanceof ElementListUnion) {
            return new ExtractorBuilder(ElementListUnion.class, ElementListExtractor.class);
        }
        if (!(annotation instanceof ElementMapUnion)) {
            throw new PersistenceException("Annotation %s is not a union", annotation);
        }
        return new ExtractorBuilder(ElementMapUnion.class, ElementMapExtractor.class);
    }

    private Object getInstance(Annotation annotation) throws Exception {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor.newInstance(this.contact, annotation, this.format);
    }

    public Extractor getInstance() throws Exception {
        return (Extractor) getInstance(this.label);
    }
}
