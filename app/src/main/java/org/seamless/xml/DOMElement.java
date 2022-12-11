package org.seamless.xml;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.seamless.xml.DOMElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public abstract class DOMElement<CHILD extends DOMElement, PARENT extends DOMElement> {
    public Element element;
    public final XPath xpath;
    public final DOMElement<CHILD, PARENT>.Builder<PARENT> PARENT_BUILDER = createParentBuilder(this);
    public final DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> CHILD_BUILDER = createChildBuilder(this);

    /* loaded from: classes5.dex */
    public abstract class ArrayBuilder<T extends DOMElement> extends DOMElement<CHILD, PARENT>.Builder<T> {
        public ArrayBuilder(DOMElement dOMElement) {
            super(dOMElement);
        }

        public T[] buildArray(DOMElement[] dOMElementArr) {
            T[] mo5295newChildrenArray = mo5295newChildrenArray(dOMElementArr.length);
            for (int i = 0; i < mo5295newChildrenArray.length; i++) {
                mo5295newChildrenArray[i] = mo5294build(dOMElementArr[i].getW3CElement());
            }
            return mo5295newChildrenArray;
        }

        public T[] getChildElements() {
            return buildArray(this.element.getChildren());
        }

        public T[] getChildElements(String str) {
            return buildArray(this.element.getChildren(str));
        }

        /* renamed from: newChildrenArray */
        public abstract T[] mo5295newChildrenArray(int i);
    }

    /* loaded from: classes5.dex */
    public abstract class Builder<T extends DOMElement> {
        public DOMElement element;

        public Builder(DOMElement dOMElement) {
            this.element = dOMElement;
        }

        /* renamed from: build */
        public abstract T mo5294build(Element element);

        public T firstChildOrNull(String str) {
            DOMElement firstChild = this.element.getFirstChild(str);
            if (firstChild != null) {
                return mo5294build(firstChild.getW3CElement());
            }
            return null;
        }
    }

    public DOMElement(XPath xPath, Element element) {
        this.xpath = xPath;
        this.element = element;
    }

    public CHILD adoptOrImport(Document document, CHILD child, boolean z) {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder;
        Node adoptNode;
        if (document != null) {
            if (z) {
                arrayBuilder = this.CHILD_BUILDER;
                adoptNode = document.importNode(child.getW3CElement(), true);
            } else {
                arrayBuilder = this.CHILD_BUILDER;
                adoptNode = document.adoptNode(child.getW3CElement());
            }
            return (CHILD) arrayBuilder.mo5294build((Element) adoptNode);
        }
        return child;
    }

    public CHILD appendChild(CHILD child, boolean z) {
        CHILD adoptOrImport = adoptOrImport(getW3CElement().getOwnerDocument(), child, z);
        getW3CElement().appendChild(adoptOrImport.getW3CElement());
        return adoptOrImport;
    }

    public CHILD createChild(String str) {
        return createChild(str, null);
    }

    public CHILD createChild(String str, String str2) {
        CHILD child = (CHILD) this.CHILD_BUILDER.mo5294build(str2 == null ? getW3CElement().getOwnerDocument().createElement(str) : getW3CElement().getOwnerDocument().createElementNS(str2, str));
        getW3CElement().appendChild(child.getW3CElement());
        return child;
    }

    public abstract DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> createChildBuilder(DOMElement dOMElement);

    public abstract DOMElement<CHILD, PARENT>.Builder<PARENT> createParentBuilder(DOMElement dOMElement);

    public CHILD findChildWithIdentifier(String str) {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder = this.CHILD_BUILDER;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("descendant::");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(prefix("*"));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("[@id=\"");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"]");
        Collection<CHILD> xPathChildElements = getXPathChildElements(arrayBuilder, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        if (xPathChildElements.size() == 1) {
            return xPathChildElements.iterator().next();
        }
        return null;
    }

    public CHILD[] findChildren(String str) {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder = this.CHILD_BUILDER;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("descendant::");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(prefix(str));
        Collection<CHILD> xPathChildElements = getXPathChildElements(arrayBuilder, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        return (CHILD[]) ((DOMElement[]) xPathChildElements.toArray(this.CHILD_BUILDER.mo5295newChildrenArray(xPathChildElements.size())));
    }

    public String getAttribute(String str) {
        String attribute = getW3CElement().getAttribute(str);
        if (attribute.length() > 0) {
            return attribute;
        }
        return null;
    }

    public CHILD[] getChildren() {
        NodeList childNodes = getW3CElement().getChildNodes();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                arrayList.add(this.CHILD_BUILDER.mo5294build((Element) item));
            }
        }
        return (CHILD[]) ((DOMElement[]) arrayList.toArray(this.CHILD_BUILDER.mo5295newChildrenArray(arrayList.size())));
    }

    public CHILD[] getChildren(String str) {
        Collection<CHILD> xPathChildElements = getXPathChildElements(this.CHILD_BUILDER, prefix(str));
        return (CHILD[]) ((DOMElement[]) xPathChildElements.toArray(this.CHILD_BUILDER.mo5295newChildrenArray(xPathChildElements.size())));
    }

    public String getContent() {
        return getW3CElement().getTextContent();
    }

    public String getElementName() {
        return getW3CElement().getNodeName();
    }

    public CHILD getFirstChild(String str) {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder = this.CHILD_BUILDER;
        return getXPathChildElement(arrayBuilder, prefix(str) + "[1]");
    }

    public PARENT getParent() {
        return (PARENT) this.PARENT_BUILDER.mo5294build((Element) getW3CElement().getParentNode());
    }

    public CHILD getRequiredChild(String str) throws ParserException {
        CHILD[] children = getChildren(str);
        if (children.length == 1) {
            return children[0];
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Required single child element of '");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getElementName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("' not found: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        throw new ParserException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public Element getW3CElement() {
        return this.element;
    }

    public CHILD getXPathChildElement(DOMElement<CHILD, PARENT>.Builder<CHILD> builder, String str) {
        Node node = (Node) getXPathResult(getW3CElement(), str, XPathConstants.NODE);
        if (node == null || node.getNodeType() != 1) {
            return null;
        }
        return (CHILD) builder.mo5294build((Element) node);
    }

    public Collection<CHILD> getXPathChildElements(DOMElement<CHILD, PARENT>.Builder<CHILD> builder, String str) {
        return getXPathElements(builder, str);
    }

    public Collection getXPathElements(Builder builder, String str) {
        ArrayList arrayList = new ArrayList();
        NodeList nodeList = (NodeList) getXPathResult(getW3CElement(), str, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            arrayList.add(builder.mo5294build((Element) nodeList.item(i)));
        }
        return arrayList;
    }

    public PARENT getXPathParentElement(DOMElement<CHILD, PARENT>.Builder<PARENT> builder, String str) {
        Node node = (Node) getXPathResult(getW3CElement(), str, XPathConstants.NODE);
        if (node == null || node.getNodeType() != 1) {
            return null;
        }
        return (PARENT) builder.mo5294build((Element) node);
    }

    public Collection<PARENT> getXPathParentElements(DOMElement<CHILD, PARENT>.Builder<CHILD> builder, String str) {
        return getXPathElements(builder, str);
    }

    public Object getXPathResult(String str, QName qName) {
        return getXPathResult(getW3CElement(), str, qName);
    }

    public Object getXPathResult(Node node, String str, QName qName) {
        try {
            return qName == null ? this.xpath.evaluate(str, node) : this.xpath.evaluate(str, node, qName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getXPathString(XPath xPath, String str) {
        return getXPathResult(getW3CElement(), str, null).toString();
    }

    public XPath getXpath() {
        return this.xpath;
    }

    public String prefix(String str) {
        return str;
    }

    public void removeChild(CHILD child) {
        getW3CElement().removeChild(child.getW3CElement());
    }

    public void removeChildren() {
        NodeList childNodes = getW3CElement().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            getW3CElement().removeChild(childNodes.item(i));
        }
    }

    public CHILD replaceChild(CHILD child, CHILD child2, boolean z) {
        CHILD adoptOrImport = adoptOrImport(getW3CElement().getOwnerDocument(), child2, z);
        getW3CElement().replaceChild(adoptOrImport.getW3CElement(), child.getW3CElement());
        return adoptOrImport;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceEqualChild(DOMElement dOMElement, String str) {
        CHILD findChildWithIdentifier = findChildWithIdentifier(str);
        findChildWithIdentifier.getParent().replaceChild(findChildWithIdentifier, dOMElement.findChildWithIdentifier(str), true);
    }

    /* renamed from: setAttribute */
    public DOMElement mo5292setAttribute(String str, String str2) {
        getW3CElement().setAttribute(str, str2);
        return this;
    }

    public DOMElement<CHILD, PARENT> setContent(String str) {
        getW3CElement().setTextContent(str);
        return this;
    }

    public String toSimpleXMLString() {
        String str;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getElementName());
        NamedNodeMap attributes = getW3CElement().getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(item.getNodeName());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("=\"");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(item.getTextContent());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\"");
        }
        if (getContent().length() > 0) {
            str = ">";
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getContent());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("</");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getElementName());
        } else {
            str = "/>";
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("(");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getClass().getSimpleName());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getW3CElement() == null ? "UNBOUND" : getElementName());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
