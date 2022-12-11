package org.seamless.xhtml;

import java.util.HashSet;
import javax.xml.xpath.XPath;
import me.tvspark.outline;
import org.seamless.xhtml.XHTML;
import org.seamless.xml.DOMParser;
import org.seamless.xml.NamespaceContextMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class XHTMLParser extends DOMParser<XHTML> {
    public XHTMLParser() {
        super(XHTML.createSchemaSources());
    }

    public void checkDuplicateIdentifiers(XHTML xhtml) throws IllegalStateException {
        final HashSet hashSet = new HashSet();
        DOMParser.accept(xhtml.getW3CDocument().getDocumentElement(), new DOMParser.NodeVisitor((short) 1) { // from class: org.seamless.xhtml.XHTMLParser.1
            @Override // org.seamless.xml.DOMParser.NodeVisitor
            public void visit(Node node) {
                XHTML.ATTR attr = XHTML.ATTR.id;
                String attribute = ((Element) node).getAttribute("id");
                if (!"".equals(attribute)) {
                    if (hashSet.contains(attribute)) {
                        throw new IllegalStateException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Duplicate identifier, override/change value: ", attribute));
                    }
                    hashSet.add(attribute);
                }
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.seamless.xml.DOMParser
    /* renamed from: createDOM */
    public XHTML mo5296createDOM(Document document) {
        if (document != null) {
            return new XHTML(document);
        }
        return null;
    }

    public NamespaceContextMap createDefaultNamespaceContext(String... strArr) {
        NamespaceContextMap namespaceContextMap = new NamespaceContextMap() { // from class: org.seamless.xhtml.XHTMLParser.2
            @Override // org.seamless.xml.NamespaceContextMap
            public String getDefaultNamespaceURI() {
                return XHTML.NAMESPACE_URI;
            }
        };
        for (String str : strArr) {
            namespaceContextMap.put(str, XHTML.NAMESPACE_URI);
        }
        return namespaceContextMap;
    }

    public XPath createXPath() {
        return super.createXPath(createDefaultNamespaceContext(XHTMLElement.XPATH_PREFIX));
    }
}
