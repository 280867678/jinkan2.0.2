package com.thegrizzlylabs.sardineandroid.model;

import javax.xml.namespace.QName;
import me.tvspark.p50;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.w3c.dom.Element;

@Namespace(prefix = "D", reference = "DAV:")
@Root(strict = false)
/* loaded from: classes4.dex */
public class Property {
    public Element property;

    /* loaded from: classes4.dex */
    public static class PropertyConverter implements Converter<Property> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.simpleframework.xml.convert.Converter
        /* renamed from: read */
        public Property mo4863read(InputNode inputNode) throws Exception {
            Property property = new Property();
            InputNode next = inputNode.getNext();
            if (next != null) {
                Element Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p50.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new QName(next.getReference(), next.getName(), next.getPrefix()));
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTextContent(next.getValue());
                property.setProperty(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            return property;
        }

        @Override // org.simpleframework.xml.convert.Converter
        public void write(OutputNode outputNode, Property property) throws Exception {
            Element element = property.property;
            OutputNode child = outputNode.getChild(element.getNodeName());
            child.getNamespaces().setReference(element.getNamespaceURI(), element.getPrefix());
            child.setValue(element.getTextContent());
            child.commit();
        }
    }

    public Element getProperty() {
        return this.property;
    }

    public void setProperty(Element element) {
        this.property = element;
    }
}
