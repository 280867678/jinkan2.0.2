package org.mozilla.javascript.xmlimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.tvspark.outline;
import org.jsoup.helper.W3CDom;
import org.mozilla.javascript.Undefined;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class XmlNode implements Serializable {
    public static final boolean DOM_LEVEL_3 = true;
    public static final String USER_DATA_XMLNODE_KEY = XmlNode.class.getName();
    public static final String XML_NAMESPACES_NAMESPACE_URI = "http://www.w3.org/2000/xmlns/";
    public static final long serialVersionUID = 1;
    public Node dom;
    public UserDataHandler events = new XmlNodeUserDataHandler();
    public XML xml;

    /* loaded from: classes5.dex */
    public static abstract class Filter {
        public static final Filter COMMENT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.1
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            public boolean accept(Node node) {
                return node.getNodeType() == 8;
            }
        };
        public static final Filter TEXT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.2
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            public boolean accept(Node node) {
                return node.getNodeType() == 3;
            }
        };
        public static Filter ELEMENT = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.4
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            public boolean accept(Node node) {
                return node.getNodeType() == 1;
            }
        };
        public static Filter TRUE = new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.5
            @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
            public boolean accept(Node node) {
                return true;
            }
        };

        public static Filter PROCESSING_INSTRUCTION(final XMLName xMLName) {
            return new Filter() { // from class: org.mozilla.javascript.xmlimpl.XmlNode.Filter.3
                @Override // org.mozilla.javascript.xmlimpl.XmlNode.Filter
                public boolean accept(Node node) {
                    if (node.getNodeType() == 7) {
                        return XMLName.this.matchesLocalName(((ProcessingInstruction) node).getTarget());
                    }
                    return false;
                }
            };
        }

        public abstract boolean accept(Node node);
    }

    /* loaded from: classes5.dex */
    public static class InternalList implements Serializable {
        public static final long serialVersionUID = -3633151157292048978L;
        public List<XmlNode> list = new ArrayList();

        private void _add(XmlNode xmlNode) {
            this.list.add(xmlNode);
        }

        public void add(XML xml) {
            _add(xml.getAnnotation());
        }

        public void add(InternalList internalList) {
            for (int i = 0; i < internalList.length(); i++) {
                _add(internalList.item(i));
            }
        }

        public void add(InternalList internalList, int i, int i2) {
            while (i < i2) {
                _add(internalList.item(i));
                i++;
            }
        }

        public void add(XmlNode xmlNode) {
            _add(xmlNode);
        }

        public void addToList(Object obj) {
            XmlNode xmlNode;
            if (obj instanceof Undefined) {
                return;
            }
            if (obj instanceof XMLList) {
                XMLList xMLList = (XMLList) obj;
                for (int i = 0; i < xMLList.length(); i++) {
                    _add(xMLList.item(i).getAnnotation());
                }
                return;
            }
            if (obj instanceof XML) {
                xmlNode = ((XML) obj).getAnnotation();
            } else if (!(obj instanceof XmlNode)) {
                return;
            } else {
                xmlNode = (XmlNode) obj;
            }
            _add(xmlNode);
        }

        public XmlNode item(int i) {
            return this.list.get(i);
        }

        public int length() {
            return this.list.size();
        }

        public void remove(int i) {
            this.list.remove(i);
        }
    }

    /* loaded from: classes5.dex */
    public static class Namespace implements Serializable {
        public static final Namespace GLOBAL = create("", "");
        public static final long serialVersionUID = 4073904386884677090L;
        public String prefix;
        public String uri;

        public static Namespace create(String str) {
            Namespace namespace = new Namespace();
            namespace.uri = str;
            if (str == null || str.length() == 0) {
                namespace.prefix = "";
            }
            return namespace;
        }

        public static Namespace create(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new IllegalArgumentException("Namespace may not lack a URI");
                }
                Namespace namespace = new Namespace();
                namespace.prefix = str;
                namespace.uri = str2;
                return namespace;
            }
            throw new IllegalArgumentException("Empty string represents default namespace prefix");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrefix(String str) {
            if (str != null) {
                this.prefix = str;
                return;
            }
            throw new IllegalArgumentException();
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getUri() {
            return this.uri;
        }

        /* renamed from: is */
        public boolean m11is(Namespace namespace) {
            String str;
            String str2 = this.prefix;
            return str2 != null && (str = namespace.prefix) != null && str2.equals(str) && this.uri.equals(namespace.uri);
        }

        public boolean isDefault() {
            String str = this.prefix;
            return str != null && str.equals("");
        }

        public boolean isEmpty() {
            String str = this.prefix;
            return str != null && str.equals("") && this.uri.equals("");
        }

        public boolean isGlobal() {
            String str = this.uri;
            return str != null && str.equals("");
        }

        public boolean isUnspecifiedPrefix() {
            return this.prefix == null;
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String str;
            if (this.prefix == null) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("XmlNode.Namespace [");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.uri);
                str = "]";
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("XmlNode.Namespace [");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.prefix);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("{");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.uri);
                str = "}]";
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str);
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class Namespaces {
        public Map<String, String> map = new HashMap();
        public Map<String, String> uriToPrefix = new HashMap();

        public void declare(Namespace namespace) {
            if (this.map.get(namespace.prefix) == null) {
                this.map.put(namespace.prefix, namespace.uri);
            }
            if (this.uriToPrefix.get(namespace.uri) == null) {
                this.uriToPrefix.put(namespace.uri, namespace.prefix);
            }
        }

        public Namespace getNamespace(String str) {
            if (this.map.get(str) == null) {
                return null;
            }
            return Namespace.create(str, this.map.get(str));
        }

        public Namespace getNamespaceByUri(String str) {
            if (this.uriToPrefix.get(str) == null) {
                return null;
            }
            return Namespace.create(str, this.uriToPrefix.get(str));
        }

        public Namespace[] getNamespaces() {
            ArrayList arrayList = new ArrayList();
            for (String str : this.map.keySet()) {
                Namespace create = Namespace.create(str, this.map.get(str));
                if (!create.isEmpty()) {
                    arrayList.add(create);
                }
            }
            return (Namespace[]) arrayList.toArray(new Namespace[arrayList.size()]);
        }
    }

    /* loaded from: classes5.dex */
    public static class QName implements Serializable {
        public static final long serialVersionUID = -6587069811691451077L;
        public String localName;
        public Namespace namespace;

        @Deprecated
        public static QName create(String str, String str2, String str3) {
            return create(Namespace.create(str3, str), str2);
        }

        public static QName create(Namespace namespace, String str) {
            if (str == null || !str.equals("*")) {
                QName qName = new QName();
                qName.namespace = namespace;
                qName.localName = str;
                return qName;
            }
            throw new RuntimeException("* is not valid localName");
        }

        private boolean equals(String str, String str2) {
            if (str == null && str2 == null) {
                return true;
            }
            if (str != null && str2 != null) {
                return str.equals(str2);
            }
            return false;
        }

        private boolean namespacesEqual(Namespace namespace, Namespace namespace2) {
            if (namespace == null && namespace2 == null) {
                return true;
            }
            if (namespace != null && namespace2 != null) {
                return equals(namespace.getUri(), namespace2.getUri());
            }
            return false;
        }

        public static String qualify(String str, String str2) {
            if (str != null) {
                return str.length() > 0 ? outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, ":", str2) : str2;
            }
            throw new IllegalArgumentException("prefix must not be null");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof QName)) {
                return false;
            }
            return equals((QName) obj);
        }

        public final boolean equals(QName qName) {
            return namespacesEqual(this.namespace, qName.namespace) && equals(this.localName, qName.localName);
        }

        public String getLocalName() {
            return this.localName;
        }

        public Namespace getNamespace() {
            return this.namespace;
        }

        public int hashCode() {
            String str = this.localName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public void lookupPrefix(Node node) {
            if (node != null) {
                String lookupPrefix = node.lookupPrefix(this.namespace.getUri());
                if (lookupPrefix == null) {
                    String lookupNamespaceURI = node.lookupNamespaceURI(null);
                    if (lookupNamespaceURI == null) {
                        lookupNamespaceURI = "";
                    }
                    if (this.namespace.getUri().equals(lookupNamespaceURI)) {
                        lookupPrefix = "";
                    }
                }
                int i = 0;
                while (lookupPrefix == null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("e4x_");
                    int i2 = i + 1;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(i);
                    String sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
                    if (node.lookupNamespaceURI(sb) == null) {
                        Node node2 = node;
                        while (node2.getParentNode() != null && (node2.getParentNode() instanceof Element)) {
                            node2 = node2.getParentNode();
                        }
                        ((Element) node2).setAttributeNS(XmlNode.XML_NAMESPACES_NAMESPACE_URI, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(W3CDom.W3CBuilder.xmlnsPrefix, sb), this.namespace.getUri());
                        lookupPrefix = sb;
                    }
                    i = i2;
                }
                this.namespace.setPrefix(lookupPrefix);
                return;
            }
            throw new IllegalArgumentException("node must not be null");
        }

        public String qualify(Node node) {
            if (this.namespace.getPrefix() == null) {
                if (node != null) {
                    lookupPrefix(node);
                } else {
                    this.namespace.getUri().equals("");
                    this.namespace.setPrefix("");
                }
            }
            return qualify(this.namespace.getPrefix(), this.localName);
        }

        public void setAttribute(Element element, String str) {
            if (this.namespace.getPrefix() == null) {
                lookupPrefix(element);
            }
            element.setAttributeNS(this.namespace.getUri(), qualify(this.namespace.getPrefix(), this.localName), str);
        }

        public String toString() {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("XmlNode.QName [");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.localName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(",");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.namespace);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class XmlNodeUserDataHandler implements UserDataHandler, Serializable {
        public static final long serialVersionUID = 4666895518900769588L;

        @Override // org.w3c.dom.UserDataHandler
        public void handle(short s, String str, Object obj, Node node, Node node2) {
        }
    }

    private void addNamespaces(Namespaces namespaces, Element element) {
        if (element != null) {
            String uri = toUri(element.lookupNamespaceURI(null));
            if (!uri.equals(element.getParentNode() != null ? toUri(element.getParentNode().lookupNamespaceURI(null)) : "") || !(element.getParentNode() instanceof Element)) {
                namespaces.declare(Namespace.create("", uri));
            }
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Attr attr = (Attr) attributes.item(i);
                if (attr.getPrefix() != null && attr.getPrefix().equals(W3CDom.W3CBuilder.xmlnsKey)) {
                    namespaces.declare(Namespace.create(attr.getLocalName(), attr.getValue()));
                }
            }
            return;
        }
        throw new RuntimeException("element must not be null");
    }

    public static XmlNode copy(XmlNode xmlNode) {
        return createImpl(xmlNode.dom.cloneNode(true));
    }

    public static XmlNode createElement(XmlProcessor xmlProcessor, String str, String str2) throws SAXException {
        return createImpl(xmlProcessor.toXml(str, str2));
    }

    public static XmlNode createElementFromNode(Node node) {
        if (node instanceof Document) {
            node = ((Document) node).getDocumentElement();
        }
        return createImpl(node);
    }

    public static XmlNode createEmpty(XmlProcessor xmlProcessor) {
        return createText(xmlProcessor, "");
    }

    public static XmlNode createImpl(Node node) {
        if (!(node instanceof Document)) {
            if (getUserData(node) != null) {
                return getUserData(node);
            }
            XmlNode xmlNode = new XmlNode();
            xmlNode.dom = node;
            setUserData(node, xmlNode);
            return xmlNode;
        }
        throw new IllegalArgumentException();
    }

    public static XmlNode createText(XmlProcessor xmlProcessor, String str) {
        return createImpl(xmlProcessor.newDocument().createTextNode(str));
    }

    private void declareNamespace(Element element, String str, String str2) {
        if (str.length() <= 0) {
            element.setAttribute(W3CDom.W3CBuilder.xmlnsKey, str2);
            return;
        }
        element.setAttributeNS(XML_NAMESPACES_NAMESPACE_URI, W3CDom.W3CBuilder.xmlnsPrefix + str, str2);
    }

    private Namespaces getAllNamespaces() {
        Namespaces namespaces = new Namespaces();
        Node node = this.dom;
        if (node instanceof Attr) {
            node = ((Attr) node).getOwnerElement();
        }
        while (node != null) {
            if (node instanceof Element) {
                addNamespaces(namespaces, (Element) node);
            }
            node = node.getParentNode();
        }
        namespaces.declare(Namespace.create("", ""));
        return namespaces;
    }

    private Namespace getDefaultNamespace() {
        return Namespace.create("", this.dom.lookupNamespaceURI(null) == null ? "" : this.dom.lookupNamespaceURI(null));
    }

    private String getExistingPrefixFor(Namespace namespace) {
        return getDefaultNamespace().getUri().equals(namespace.getUri()) ? "" : this.dom.lookupPrefix(namespace.getUri());
    }

    private Namespace getNodeNamespace() {
        String namespaceURI = this.dom.getNamespaceURI();
        String prefix = this.dom.getPrefix();
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (prefix == null) {
            prefix = "";
        }
        return Namespace.create(prefix, namespaceURI);
    }

    public static XmlNode getUserData(Node node) {
        return (XmlNode) node.getUserData(USER_DATA_XMLNODE_KEY);
    }

    public static XmlNode newElementWithText(XmlProcessor xmlProcessor, XmlNode xmlNode, QName qName, String str) {
        String localName;
        if (!(xmlNode instanceof Document)) {
            Document ownerDocument = xmlNode != null ? xmlNode.dom.getOwnerDocument() : xmlProcessor.newDocument();
            String str2 = null;
            Node node = xmlNode != null ? xmlNode.dom : null;
            Namespace namespace = qName.getNamespace();
            if (namespace == null || namespace.getUri().length() == 0) {
                localName = qName.getLocalName();
            } else {
                str2 = namespace.getUri();
                localName = qName.qualify(node);
            }
            Element createElementNS = ownerDocument.createElementNS(str2, localName);
            if (str != null) {
                createElementNS.appendChild(ownerDocument.createTextNode(str));
            }
            return createImpl(createElementNS);
        }
        throw new IllegalArgumentException("Cannot use Document node as reference");
    }

    private void setProcessingInstructionName(String str) {
        ProcessingInstruction processingInstruction = (ProcessingInstruction) this.dom;
        processingInstruction.getParentNode().replaceChild(processingInstruction, processingInstruction.getOwnerDocument().createProcessingInstruction(str, processingInstruction.getData()));
    }

    public static void setUserData(Node node, XmlNode xmlNode) {
        node.setUserData(USER_DATA_XMLNODE_KEY, xmlNode, xmlNode.events);
    }

    private String toUri(String str) {
        return str == null ? "" : str;
    }

    public void addMatchingChildren(XMLList xMLList, Filter filter) {
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            XmlNode createImpl = createImpl(item);
            if (filter.accept(item)) {
                xMLList.addToList(createImpl);
            }
        }
    }

    public final XmlNode copy() {
        return copy(this);
    }

    public String debug() {
        XmlProcessor xmlProcessor = new XmlProcessor();
        xmlProcessor.setIgnoreComments(false);
        xmlProcessor.setIgnoreProcessingInstructions(false);
        xmlProcessor.setIgnoreWhitespace(false);
        xmlProcessor.setPrettyPrinting(false);
        return xmlProcessor.ecmaToXmlString(this.dom);
    }

    public void declareNamespace(String str, String str2) {
        Node node = this.dom;
        if (node instanceof Element) {
            if (node.lookupNamespaceURI(str2) != null && this.dom.lookupNamespaceURI(str2).equals(str)) {
                return;
            }
            declareNamespace((Element) this.dom, str, str2);
            return;
        }
        throw new IllegalStateException();
    }

    public void deleteMe() {
        Node node = this.dom;
        if (node instanceof Attr) {
            Attr attr = (Attr) node;
            attr.getOwnerElement().getAttributes().removeNamedItemNS(attr.getNamespaceURI(), attr.getLocalName());
        } else if (node.getParentNode() == null) {
        } else {
            this.dom.getParentNode().removeChild(this.dom);
        }
    }

    public String ecmaToXMLString(XmlProcessor xmlProcessor) {
        if (isElementType()) {
            Element element = (Element) this.dom.cloneNode(true);
            Namespace[] inScopeNamespaces = getInScopeNamespaces();
            for (int i = 0; i < inScopeNamespaces.length; i++) {
                declareNamespace(element, inScopeNamespaces[i].getPrefix(), inScopeNamespaces[i].getUri());
            }
            return xmlProcessor.ecmaToXmlString(element);
        }
        return xmlProcessor.ecmaToXmlString(this.dom);
    }

    public String ecmaValue() {
        if (isTextType()) {
            return ((Text) this.dom).getData();
        }
        if (isAttributeType()) {
            return ((Attr) this.dom).getValue();
        }
        if (isProcessingInstructionType()) {
            return ((ProcessingInstruction) this.dom).getData();
        }
        if (isCommentType()) {
            return ((Comment) this.dom).getNodeValue();
        }
        if (isElementType()) {
            throw new RuntimeException("Unimplemented ecmaValue() for elements.");
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Unimplemented for node ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.dom);
        throw new RuntimeException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    public String getAttributeValue() {
        return ((Attr) this.dom).getValue();
    }

    public XmlNode[] getAttributes() {
        NamedNodeMap attributes = this.dom.getAttributes();
        if (attributes != null) {
            XmlNode[] xmlNodeArr = new XmlNode[attributes.getLength()];
            for (int i = 0; i < attributes.getLength(); i++) {
                xmlNodeArr[i] = createImpl(attributes.item(i));
            }
            return xmlNodeArr;
        }
        throw new IllegalStateException("Must be element.");
    }

    public XmlNode getChild(int i) {
        return createImpl(this.dom.getChildNodes().item(i));
    }

    public int getChildCount() {
        return this.dom.getChildNodes().getLength();
    }

    public int getChildIndex() {
        if (!isAttributeType() && parent() != null) {
            NodeList childNodes = this.dom.getParentNode().getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i) == this.dom) {
                    return i;
                }
            }
            throw new RuntimeException("Unreachable.");
        }
        return -1;
    }

    public Namespace[] getInScopeNamespaces() {
        return getAllNamespaces().getNamespaces();
    }

    public XmlNode[] getMatchingChildren(Filter filter) {
        ArrayList arrayList = new ArrayList();
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (filter.accept(item)) {
                arrayList.add(createImpl(item));
            }
        }
        return (XmlNode[]) arrayList.toArray(new XmlNode[arrayList.size()]);
    }

    public Namespace getNamespace() {
        return getNodeNamespace();
    }

    public Namespace getNamespaceDeclaration() {
        return getNamespaceDeclaration(this.dom.getPrefix() == null ? "" : this.dom.getPrefix());
    }

    public Namespace getNamespaceDeclaration(String str) {
        return (!str.equals("") || !(this.dom instanceof Attr)) ? getAllNamespaces().getNamespace(str) : Namespace.create("", "");
    }

    public Namespace[] getNamespaceDeclarations() {
        if (this.dom instanceof Element) {
            Namespaces namespaces = new Namespaces();
            addNamespaces(namespaces, (Element) this.dom);
            return namespaces.getNamespaces();
        }
        return new Namespace[0];
    }

    public final QName getQname() {
        String str = "";
        String namespaceURI = this.dom.getNamespaceURI() == null ? str : this.dom.getNamespaceURI();
        if (this.dom.getPrefix() != null) {
            str = this.dom.getPrefix();
        }
        return QName.create(namespaceURI, this.dom.getLocalName(), str);
    }

    public XML getXml() {
        return this.xml;
    }

    public boolean hasChildElement() {
        NodeList childNodes = this.dom.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == 1) {
                return true;
            }
        }
        return false;
    }

    public void insertChildAt(int i, XmlNode xmlNode) {
        Node node = this.dom;
        Node importNode = node.getOwnerDocument().importNode(xmlNode.dom, true);
        if (node.getChildNodes().getLength() < i) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("index=", i, " length=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(node.getChildNodes().getLength());
            throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        } else if (node.getChildNodes().getLength() == i) {
            node.appendChild(importNode);
        } else {
            node.insertBefore(importNode, node.getChildNodes().item(i));
        }
    }

    public void insertChildrenAt(int i, XmlNode[] xmlNodeArr) {
        for (int i2 = 0; i2 < xmlNodeArr.length; i2++) {
            insertChildAt(i + i2, xmlNodeArr[i2]);
        }
    }

    public void invalidateNamespacePrefix() {
        Node node = this.dom;
        if (node instanceof Element) {
            String prefix = node.getPrefix();
            renameNode(QName.create(this.dom.getNamespaceURI(), this.dom.getLocalName(), null));
            NamedNodeMap attributes = this.dom.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.item(i).getPrefix().equals(prefix)) {
                    createImpl(attributes.item(i)).renameNode(QName.create(attributes.item(i).getNamespaceURI(), attributes.item(i).getLocalName(), null));
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final boolean isAttributeType() {
        return this.dom.getNodeType() == 2;
    }

    public final boolean isCommentType() {
        return this.dom.getNodeType() == 8;
    }

    public final boolean isElementType() {
        return this.dom.getNodeType() == 1;
    }

    public final boolean isParentType() {
        return isElementType();
    }

    public final boolean isProcessingInstructionType() {
        return this.dom.getNodeType() == 7;
    }

    public boolean isSameNode(XmlNode xmlNode) {
        return this.dom == xmlNode.dom;
    }

    public final boolean isTextType() {
        return this.dom.getNodeType() == 3 || this.dom.getNodeType() == 4;
    }

    public void normalize() {
        this.dom.normalize();
    }

    public XmlNode parent() {
        Node parentNode = this.dom.getParentNode();
        if (!(parentNode instanceof Document) && parentNode != null) {
            return createImpl(parentNode);
        }
        return null;
    }

    public void removeChild(int i) {
        Node node = this.dom;
        node.removeChild(node.getChildNodes().item(i));
    }

    public void removeNamespace(Namespace namespace) {
        if (namespace.m11is(getNodeNamespace())) {
            return;
        }
        NamedNodeMap attributes = this.dom.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            if (namespace.m11is(createImpl(attributes.item(i)).getNodeNamespace())) {
                return;
            }
        }
        String existingPrefixFor = getExistingPrefixFor(namespace);
        if (existingPrefixFor == null) {
            return;
        }
        if (!namespace.isUnspecifiedPrefix() && !existingPrefixFor.equals(namespace.getPrefix())) {
            return;
        }
        declareNamespace(existingPrefixFor, getDefaultNamespace().getUri());
    }

    public final void renameNode(QName qName) {
        this.dom = this.dom.getOwnerDocument().renameNode(this.dom, qName.getNamespace().getUri(), qName.qualify(this.dom));
    }

    public void replaceWith(XmlNode xmlNode) {
        Node node = xmlNode.dom;
        if (node.getOwnerDocument() != this.dom.getOwnerDocument()) {
            node = this.dom.getOwnerDocument().importNode(node, true);
        }
        this.dom.getParentNode().replaceChild(node, this.dom);
    }

    public void setAttribute(QName qName, String str) {
        Node node = this.dom;
        if (node instanceof Element) {
            qName.setAttribute((Element) node, str);
            return;
        }
        throw new IllegalStateException("Can only set attribute on elements.");
    }

    public final void setLocalName(String str) {
        Node node = this.dom;
        if (node instanceof ProcessingInstruction) {
            setProcessingInstructionName(str);
            return;
        }
        String prefix = node.getPrefix();
        if (prefix == null) {
            prefix = "";
        }
        Document ownerDocument = this.dom.getOwnerDocument();
        Node node2 = this.dom;
        this.dom = ownerDocument.renameNode(node2, node2.getNamespaceURI(), QName.qualify(prefix, str));
    }

    public void setXml(XML xml) {
        this.xml = xml;
    }

    public Node toDomNode() {
        return this.dom;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("XmlNode: type=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append((int) this.dom.getNodeType());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" dom=");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.dom.toString());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public String toXmlString(XmlProcessor xmlProcessor) {
        return xmlProcessor.ecmaToXmlString(this.dom);
    }
}
