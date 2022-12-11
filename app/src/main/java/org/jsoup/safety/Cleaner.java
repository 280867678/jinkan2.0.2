package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* loaded from: classes5.dex */
public class Cleaner {
    public Whitelist whitelist;

    /* loaded from: classes5.dex */
    public final class CleaningVisitor implements NodeVisitor {
        public Element destination;
        public int numDiscarded;
        public final Element root;

        public CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            Node dataNode;
            if (!(node instanceof Element)) {
                if (node instanceof TextNode) {
                    dataNode = new TextNode(((TextNode) node).getWholeText());
                } else if ((node instanceof DataNode) && Cleaner.this.whitelist.isSafeTag(node.mo5259parent().nodeName())) {
                    dataNode = new DataNode(((DataNode) node).getWholeData());
                }
                this.destination.appendChild(dataNode);
                return;
            }
            Element element = (Element) node;
            if (Cleaner.this.whitelist.isSafeTag(element.normalName())) {
                ElementMeta createSafeElement = Cleaner.this.createSafeElement(element);
                Element element2 = createSafeElement.f4655el;
                this.destination.appendChild(element2);
                this.numDiscarded += createSafeElement.numAttribsDiscarded;
                this.destination = element2;
                return;
            } else if (node == this.root) {
                return;
            }
            this.numDiscarded++;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if (!(node instanceof Element) || !Cleaner.this.whitelist.isSafeTag(node.nodeName())) {
                return;
            }
            this.destination = this.destination.mo5259parent();
        }
    }

    /* loaded from: classes5.dex */
    public static class ElementMeta {

        /* renamed from: el */
        public Element f4655el;
        public int numAttribsDiscarded;

        public ElementMeta(Element element, int i) {
            this.f4655el = element;
            this.numAttribsDiscarded = i;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.notNull(whitelist);
        this.whitelist = whitelist;
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        NodeTraversor.traverse(cleaningVisitor, element);
        return cleaningVisitor.numDiscarded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElementMeta createSafeElement(Element element) {
        String tagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(tagName), element.baseUri(), attributes);
        Iterator<Attribute> it = element.attributes().iterator();
        int i = 0;
        while (it.hasNext()) {
            Attribute next = it.next();
            if (this.whitelist.isSafeAttribute(tagName, element, next)) {
                attributes.put(next);
            } else {
                i++;
            }
        }
        attributes.addAll(this.whitelist.getEnforcedAttributes(tagName));
        return new ElementMeta(element2, i);
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document createShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            copySafeNodes(document.body(), createShell.body());
        }
        return createShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0 && document.head().childNodes().isEmpty();
    }

    public boolean isValidBodyHtml(String str) {
        Document createShell = Document.createShell("");
        Document createShell2 = Document.createShell("");
        ParseErrorList tracking = ParseErrorList.tracking(1);
        createShell2.body().insertChildren(0, Parser.parseFragment(str, createShell2.body(), "", tracking));
        return copySafeNodes(createShell2.body(), createShell.body()) == 0 && tracking.isEmpty();
    }
}
