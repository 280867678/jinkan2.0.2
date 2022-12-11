package org.seamless.xml;

import com.just.agentweb.JsCallJava;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import me.tvspark.ne0;
import me.tvspark.outline;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.seamless.xml.DOM;
import org.simpleframework.xml.stream.DocumentReader;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public abstract class DOMParser<D extends DOM> implements ErrorHandler, EntityResolver {
    public Schema schema;
    public Source[] schemaSources;
    public static Logger log = Logger.getLogger(DOMParser.class.getName());
    public static final URL XML_SCHEMA_RESOURCE = Thread.currentThread().getContextClassLoader().getResource("org/seamless/schemas/xml.xsd");

    /* loaded from: classes5.dex */
    public static abstract class NodeVisitor {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public short nodeType;

        public NodeVisitor(short s) {
            this.nodeType = s;
        }

        public boolean isHalted() {
            return false;
        }

        public abstract void visit(Node node);
    }

    public DOMParser() {
        this(null);
    }

    public DOMParser(Source[] sourceArr) {
        this.schemaSources = sourceArr;
    }

    public static void accept(Node node, NodeVisitor nodeVisitor) {
        if (node != null && !nodeVisitor.isHalted()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if (item.getNodeType() == nodeVisitor.nodeType) {
                    nodeVisitor.visit(item);
                    if (nodeVisitor.isHalted()) {
                        return;
                    }
                }
                accept(item, nodeVisitor);
            }
        }
    }

    public static String escape(String str) {
        return escape(str, false, false);
    }

    public static String escape(String str, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            String str2 = charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : "&#62;" : "&#60;" : "&#38;" : "&#34;";
            if (str2 != null) {
                sb.append(str2);
            } else {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        if (z2) {
            Matcher matcher = Pattern.compile("(\\n+)(\\s*)(.*)").matcher(sb2);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String group = matcher.group(2);
                StringBuilder sb3 = new StringBuilder();
                for (int i2 = 0; i2 < group.length(); i2++) {
                    sb3.append("&#160;");
                }
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("$1");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sb3.toString());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("$3");
                matcher.appendReplacement(stringBuffer, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            }
            matcher.appendTail(stringBuffer);
            sb2 = stringBuffer.toString();
        }
        return z ? sb2.replaceAll("\n", "<br/>") : sb2;
    }

    public static String stripElements(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("<([a-zA-Z]|/).*?>", "");
    }

    public static String wrap(String str, String str2) {
        return wrap(str, null, str2);
    }

    public static String wrap(String str, String str2, String str3) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<", str);
        if (str2 != null) {
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, " xmlns=\"", str2, "\"");
        }
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ">", str3, "</", str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(">");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    /* renamed from: createDOM */
    public abstract D mo5296createDOM(Document document);

    public D createDocument() {
        try {
            return mo5296createDOM(createFactory(false).newDocumentBuilder().newDocument());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DocumentBuilderFactory createFactory(boolean z) throws ParserException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            newInstance.setNamespaceAware(true);
            if (z) {
                newInstance.setXIncludeAware(true);
                newInstance.setFeature("http://apache.org/xml/features/xinclude/fixup-base-uris", false);
                newInstance.setFeature("http://apache.org/xml/features/xinclude/fixup-language", false);
                newInstance.setSchema(getSchema());
                newInstance.setFeature("http://apache.org/xml/features/validation/dynamic", true);
            }
            return newInstance;
        } catch (ParserConfigurationException e) {
            throw new ParserException(e);
        }
    }

    public Transformer createTransformer(String str, int i, boolean z) throws ParserException {
        try {
            TransformerFactory newInstance = TransformerFactory.newInstance();
            if (i > 0) {
                try {
                    newInstance.setAttribute("indent-number", Integer.valueOf(i));
                } catch (IllegalArgumentException unused) {
                }
            }
            Transformer newTransformer = newInstance.newTransformer();
            String str2 = "no";
            newTransformer.setOutputProperty("omit-xml-declaration", z ? str2 : "yes");
            if (z) {
                try {
                    newTransformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");
                } catch (IllegalArgumentException unused2) {
                }
            }
            if (i > 0) {
                str2 = "yes";
            }
            newTransformer.setOutputProperty("indent", str2);
            if (i > 0) {
                newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
            }
            newTransformer.setOutputProperty(JsCallJava.KEY_METHOD, str);
            return newTransformer;
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public XPath createXPath(XPathFactory xPathFactory, ne0 ne0Var) {
        XPath newXPath = xPathFactory.newXPath();
        newXPath.setNamespaceContext(ne0Var);
        return newXPath;
    }

    public XPath createXPath(ne0 ne0Var) {
        XPath newXPath = createXPathFactory().newXPath();
        newXPath.setNamespaceContext(ne0Var);
        return newXPath;
    }

    public XPathFactory createXPathFactory() {
        return XPathFactory.newInstance();
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw new SAXException(new ParserException(sAXParseException));
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw new SAXException(new ParserException(sAXParseException));
    }

    public Schema getSchema() {
        if (this.schema == null) {
            try {
                SchemaFactory newInstance = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                newInstance.setResourceResolver(new CatalogResourceResolver(new HashMap<URI, URL>() { // from class: org.seamless.xml.DOMParser.1
                    {
                        put(DOM.XML_SCHEMA_NAMESPACE, DOMParser.XML_SCHEMA_RESOURCE);
                    }
                }));
                this.schema = this.schemaSources != null ? newInstance.newSchema(this.schemaSources) : newInstance.newSchema();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this.schema;
    }

    public Object getXPathResult(DOM dom, XPath xPath, String str, QName qName) {
        return getXPathResult(dom.getW3CDocument(), xPath, str, qName);
    }

    public Object getXPathResult(DOMElement dOMElement, XPath xPath, String str, QName qName) {
        return getXPathResult(dOMElement.getW3CElement(), xPath, str, qName);
    }

    public Object getXPathResult(Node node, XPath xPath, String str, QName qName) {
        try {
            Logger logger = log;
            logger.fine("Evaluating xpath query: " + str);
            return xPath.evaluate(str, node, qName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isIgnorableWSNode(Node node) {
        return node.getNodeType() == 3 && node.getTextContent().matches("[\\t\\n\\x0B\\f\\r\\s]+");
    }

    public D parse(File file) throws ParserException {
        return parse(file, true);
    }

    public D parse(File file, boolean z) throws ParserException {
        if (file != null) {
            try {
                return parse(file.toURI().toURL(), z);
            } catch (Exception e) {
                throw new ParserException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Parsing file failed: ", file), e);
            }
        }
        throw new IllegalArgumentException("Can't parse null file");
    }

    public D parse(InputStream inputStream) throws ParserException {
        return parse(inputStream, true);
    }

    public D parse(InputStream inputStream, boolean z) throws ParserException {
        return parse(new InputSource(inputStream), z);
    }

    public D parse(String str) throws ParserException {
        return parse(str, true);
    }

    public D parse(String str, boolean z) throws ParserException {
        if (str != null) {
            return parse(new InputSource(new StringReader(str)), z);
        }
        throw new IllegalArgumentException("Can't parse null string");
    }

    public D parse(URL url) throws ParserException {
        return parse(url, true);
    }

    public D parse(URL url, boolean z) throws ParserException {
        if (url != null) {
            try {
                return parse(url.openStream(), z);
            } catch (Exception e) {
                throw new ParserException("Parsing URL failed: " + url, e);
            }
        }
        throw new IllegalArgumentException("Can't parse null URL");
    }

    public D parse(InputSource inputSource, boolean z) throws ParserException {
        try {
            DocumentBuilder newDocumentBuilder = createFactory(z).newDocumentBuilder();
            newDocumentBuilder.setEntityResolver(this);
            newDocumentBuilder.setErrorHandler(this);
            Document parse = newDocumentBuilder.parse(inputSource);
            parse.normalizeDocument();
            return mo5296createDOM(parse);
        } catch (Exception e) {
            throw unwrapException(e);
        }
    }

    public String print(String str, int i, boolean z) throws ParserException {
        return print(new StreamSource(new StringReader(str)), i, z);
    }

    public String print(Source source, int i, boolean z) throws ParserException {
        try {
            Transformer createTransformer = createTransformer(DocumentReader.RESERVED, i, z);
            createTransformer.setOutputProperty(Http2ExchangeCodec.ENCODING, "utf-8");
            StringWriter stringWriter = new StringWriter();
            createTransformer.transform(source, new StreamResult(stringWriter));
            stringWriter.flush();
            return stringWriter.toString();
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public String print(DOM dom) throws ParserException {
        return print(dom, 4, true);
    }

    public String print(DOM dom, int i) throws ParserException {
        return print(dom, i, true);
    }

    public String print(DOM dom, int i, boolean z) throws ParserException {
        return print(dom.getW3CDocument(), i, z);
    }

    public String print(DOM dom, boolean z) throws ParserException {
        return print(dom, 4, z);
    }

    public String print(Document document, int i, boolean z) throws ParserException {
        removeIgnorableWSNodes(document.getDocumentElement());
        return print(new DOMSource(document.getDocumentElement()), i, z);
    }

    public String printHTML(Document document) throws ParserException {
        return printHTML(document, 4, true, true);
    }

    public String printHTML(Document document, int i, boolean z, boolean z2) throws ParserException {
        Document document2 = (Document) document.cloneNode(true);
        accept(document2.getDocumentElement(), new NodeVisitor((short) 4) { // from class: org.seamless.xml.DOMParser.2
            @Override // org.seamless.xml.DOMParser.NodeVisitor
            public void visit(Node node) {
                CDATASection cDATASection = (CDATASection) node;
                cDATASection.getParentNode().setTextContent(cDATASection.getData());
            }
        });
        removeIgnorableWSNodes(document2.getDocumentElement());
        try {
            Transformer createTransformer = createTransformer("html", i, z);
            if (z2) {
                createTransformer.setOutputProperty("doctype-public", "-//W3C//DTD HTML 4.01 Transitional//EN");
                createTransformer.setOutputProperty("doctype-system", "http://www.w3.org/TR/html4/loose.dtd");
            }
            StringWriter stringWriter = new StringWriter();
            createTransformer.transform(new DOMSource(document2), new StreamResult(stringWriter));
            stringWriter.flush();
            return stringWriter.toString().replaceFirst("\\s*<META http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">", "").replaceFirst("<html xmlns=\"http://www.w3.org/1999/xhtml\">", "<html>");
        } catch (Exception e) {
            throw new ParserException(e);
        }
    }

    public void removeIgnorableWSNodes(Element element) {
        Node firstChild = element.getFirstChild();
        while (firstChild != null) {
            Node nextSibling = firstChild.getNextSibling();
            if (isIgnorableWSNode(firstChild)) {
                element.removeChild(firstChild);
            } else if (firstChild.getNodeType() == 1) {
                removeIgnorableWSNodes((Element) firstChild);
            }
            firstChild = nextSibling;
        }
    }

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) throws SAXException, IOException {
        InputSource inputSource = str2.startsWith("file://") ? new InputSource(new FileInputStream(new File(URI.create(str2)))) : new InputSource(new ByteArrayInputStream(new byte[0]));
        inputSource.setPublicId(str);
        inputSource.setSystemId(str2);
        return inputSource;
    }

    public ParserException unwrapException(Exception exc) {
        return (exc.getCause() == null || !(exc.getCause() instanceof ParserException)) ? new ParserException(exc) : (ParserException) exc.getCause();
    }

    public void validate(String str) throws ParserException {
        if (str != null) {
            Logger logger = log;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Validating XML string characters: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(str.length());
            logger.fine(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            validate(new SAXSource(new InputSource(new StringReader(str))));
            return;
        }
        throw new IllegalArgumentException("Can't validate null string");
    }

    public void validate(URL url) throws ParserException {
        if (url != null) {
            Logger logger = log;
            logger.fine("Validating XML of URL: " + url);
            validate(new StreamSource(url.toString()));
            return;
        }
        throw new IllegalArgumentException("Can't validate null URL");
    }

    public void validate(Source source) throws ParserException {
        try {
            Validator newValidator = getSchema().newValidator();
            newValidator.setErrorHandler(this);
            newValidator.validate(source);
        } catch (Exception e) {
            throw unwrapException(e);
        }
    }

    public void validate(DOM dom) throws ParserException {
        validate(new DOMSource(dom.getW3CDocument()));
    }

    public void validate(Document document) throws ParserException {
        validate(new DOMSource(document));
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
        log.warning(sAXParseException.toString());
    }
}
