package org.jsoup.helper;

import com.just.agentweb.JsCallJava;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.simpleframework.xml.stream.DocumentReader;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class W3CDom {
    public DocumentBuilderFactory factory;

    /* loaded from: classes5.dex */
    public static class W3CBuilder implements NodeVisitor {
        public static final String xmlnsKey = "xmlns";
        public static final String xmlnsPrefix = "xmlns:";
        public Element dest;
        public final Document doc;
        public final Stack<HashMap<String, String>> namespacesStack;

        public W3CBuilder(Document document) {
            Stack<HashMap<String, String>> stack = new Stack<>();
            this.namespacesStack = stack;
            this.doc = document;
            stack.push(new HashMap<>());
        }

        private void copyAttributes(Node node, Element element) {
            Iterator<Attribute> it = node.attributes().iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                String replaceAll = next.getKey().replaceAll("[^-a-zA-Z0-9_:.]", "");
                if (replaceAll.matches("[a-zA-Z_:][-a-zA-Z0-9_:.]*")) {
                    element.setAttribute(replaceAll, next.getValue());
                }
            }
        }

        private String updateNamespaces(org.jsoup.nodes.Element element) {
            String str;
            Iterator<Attribute> it = element.attributes().iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                Attribute next = it.next();
                String key = next.getKey();
                if (!key.equals(xmlnsKey)) {
                    if (key.startsWith(xmlnsPrefix)) {
                        str = key.substring(6);
                    }
                }
                this.namespacesStack.peek().put(str, next.getValue());
            }
            int indexOf = element.tagName().indexOf(":");
            return indexOf > 0 ? element.tagName().substring(0, indexOf) : str;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            Document document;
            String wholeData;
            org.w3c.dom.Node createComment;
            this.namespacesStack.push(new HashMap<>(this.namespacesStack.peek()));
            if (node instanceof org.jsoup.nodes.Element) {
                org.jsoup.nodes.Element element = (org.jsoup.nodes.Element) node;
                String str = this.namespacesStack.peek().get(updateNamespaces(element));
                String tagName = element.tagName();
                Element createElementNS = (str != null || !tagName.contains(":")) ? this.doc.createElementNS(str, tagName) : this.doc.createElementNS("", tagName);
                copyAttributes(element, createElementNS);
                Element element2 = this.dest;
                if (element2 == null) {
                    this.doc.appendChild(createElementNS);
                } else {
                    element2.appendChild(createElementNS);
                }
                this.dest = createElementNS;
                return;
            }
            if (node instanceof TextNode) {
                document = this.doc;
                wholeData = ((TextNode) node).getWholeText();
            } else if (node instanceof Comment) {
                createComment = this.doc.createComment(((Comment) node).getData());
                this.dest.appendChild(createComment);
            } else if (!(node instanceof DataNode)) {
                return;
            } else {
                document = this.doc;
                wholeData = ((DataNode) node).getWholeData();
            }
            createComment = document.createTextNode(wholeData);
            this.dest.appendChild(createComment);
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = (Element) this.dest.getParentNode();
            }
            this.namespacesStack.pop();
        }
    }

    public W3CDom() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        this.factory = newInstance;
        newInstance.setNamespaceAware(true);
    }

    public static HashMap<String, String> OutputHtml() {
        return methodMap("html");
    }

    public static HashMap<String, String> OutputXml() {
        return methodMap(DocumentReader.RESERVED);
    }

    public static String asString(Document document, Map<String, String> map) {
        String str;
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            if (map != null) {
                newTransformer.setOutputProperties(propertiesFromMap(map));
            }
            if (document.getDoctype() != null) {
                DocumentType doctype = document.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId())) {
                    newTransformer.setOutputProperty("doctype-public", doctype.getPublicId());
                }
                if (!StringUtil.isBlank(doctype.getSystemId())) {
                    str = doctype.getSystemId();
                } else if (doctype.getName().equalsIgnoreCase("html") && StringUtil.isBlank(doctype.getPublicId()) && StringUtil.isBlank(doctype.getSystemId())) {
                    str = "about:legacy-compat";
                }
                newTransformer.setOutputProperty("doctype-system", str);
            }
            newTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Document convert(org.jsoup.nodes.Document document) {
        return new W3CDom().fromJsoup(document);
    }

    public static HashMap<String, String> methodMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(JsCallJava.KEY_METHOD, str);
        return hashMap;
    }

    public static Properties propertiesFromMap(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public String asString(Document document) {
        return asString(document, null);
    }

    public void convert(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        NodeTraversor.traverse(new W3CBuilder(document2), document.child(0));
    }

    public Document fromJsoup(org.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            DocumentBuilder newDocumentBuilder = this.factory.newDocumentBuilder();
            DOMImplementation dOMImplementation = newDocumentBuilder.getDOMImplementation();
            Document newDocument = newDocumentBuilder.newDocument();
            org.jsoup.nodes.DocumentType documentType = document.documentType();
            if (documentType != null) {
                newDocument.appendChild(dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId()));
            }
            newDocument.setXmlStandalone(true);
            convert(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }
}
