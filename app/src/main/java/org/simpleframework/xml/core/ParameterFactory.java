package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

/* loaded from: classes5.dex */
public class ParameterFactory {
    public final Format format;

    /* loaded from: classes5.dex */
    public static class ParameterBuilder {
        public final Class entry;
        public final Class label;
        public final Class type;

        public ParameterBuilder(Class cls, Class cls2) {
            this(cls, cls2, null);
        }

        public ParameterBuilder(Class cls, Class cls2, Class cls3) {
            this.label = cls2;
            this.entry = cls3;
            this.type = cls;
        }

        private Constructor getConstructor(Class... clsArr) throws Exception {
            return this.type.getConstructor(clsArr);
        }

        public Constructor getConstructor() throws Exception {
            Class cls = this.entry;
            return cls != null ? getConstructor(this.label, cls) : getConstructor(this.label);
        }

        public Constructor getConstructor(Class cls) throws Exception {
            return getConstructor(Constructor.class, cls, Format.class, Integer.TYPE);
        }

        public Constructor getConstructor(Class cls, Class cls2) throws Exception {
            return getConstructor(Constructor.class, cls, cls2, Format.class, Integer.TYPE);
        }
    }

    public ParameterFactory(Support support) {
        this.format = support.getFormat();
    }

    private ParameterBuilder getBuilder(Annotation annotation) throws Exception {
        if (annotation instanceof Element) {
            return new ParameterBuilder(ElementParameter.class, Element.class);
        }
        if (annotation instanceof ElementList) {
            return new ParameterBuilder(ElementListParameter.class, ElementList.class);
        }
        if (annotation instanceof ElementArray) {
            return new ParameterBuilder(ElementArrayParameter.class, ElementArray.class);
        }
        if (annotation instanceof ElementMapUnion) {
            return new ParameterBuilder(ElementMapUnionParameter.class, ElementMapUnion.class, ElementMap.class);
        }
        if (annotation instanceof ElementListUnion) {
            return new ParameterBuilder(ElementListUnionParameter.class, ElementListUnion.class, ElementList.class);
        }
        if (annotation instanceof ElementUnion) {
            return new ParameterBuilder(ElementUnionParameter.class, ElementUnion.class, Element.class);
        }
        if (annotation instanceof ElementMap) {
            return new ParameterBuilder(ElementMapParameter.class, ElementMap.class);
        }
        if (annotation instanceof Attribute) {
            return new ParameterBuilder(AttributeParameter.class, Attribute.class);
        }
        if (!(annotation instanceof Text)) {
            throw new PersistenceException("Annotation %s not supported", annotation);
        }
        return new ParameterBuilder(TextParameter.class, Text.class);
    }

    private Constructor getConstructor(Annotation annotation) throws Exception {
        Constructor constructor = getBuilder(annotation).getConstructor();
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        return constructor;
    }

    public Parameter getInstance(Constructor constructor, Annotation annotation, int i) throws Exception {
        return getInstance(constructor, annotation, null, i);
    }

    public Parameter getInstance(Constructor constructor, Annotation annotation, Annotation annotation2, int i) throws Exception {
        Constructor constructor2 = getConstructor(annotation);
        return (Parameter) (annotation2 != null ? constructor2.newInstance(constructor, annotation, annotation2, this.format, Integer.valueOf(i)) : constructor2.newInstance(constructor, annotation, this.format, Integer.valueOf(i)));
    }
}
