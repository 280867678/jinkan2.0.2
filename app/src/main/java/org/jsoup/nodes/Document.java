package org.jsoup.nodes;

import androidx.core.app.NotificationCompatJellybean;
import androidx.core.net.MailTo;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.litepal.parser.LitePalParser;
import org.simpleframework.xml.stream.DocumentReader;

/* loaded from: classes5.dex */
public class Document extends Element {
    public String location;
    public Parser parser;
    public OutputSettings outputSettings = new OutputSettings();
    public QuirksMode quirksMode = QuirksMode.noQuirks;
    public boolean updateMetaCharset = false;

    /* loaded from: classes5.dex */
    public static class OutputSettings implements Cloneable {
        public Charset charset;
        public Entities.CoreCharset coreCharset;
        public Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        public ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        public boolean prettyPrint = true;
        public boolean outline = false;
        public int indentAmount = 1;
        public Syntax syntax = Syntax.html;

        /* loaded from: classes5.dex */
        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName(StringUtil.__UTF8Alt));
        }

        public Charset charset() {
            return this.charset;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.indentAmount = i;
            return this;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public boolean outline() {
            return this.outline;
        }

        public CharsetEncoder prepareEncoder() {
            CharsetEncoder newEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(newEncoder);
            this.coreCharset = Entities.CoreCharset.byName(newEncoder.charset().name());
            return newEncoder;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.location = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.parser = document.parser();
        Element appendElement = document.appendElement("html");
        appendElement.appendElement("head");
        appendElement.appendElement(MailTo.BODY);
        return document;
    }

    private void ensureMetaCharsetElement() {
        XmlDeclaration xmlDeclaration;
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element first = select("meta[charset]").first();
                if (first == null) {
                    Element head = head();
                    if (head != null) {
                        first = head.appendElement("meta");
                    }
                    select("meta[name=charset]").remove();
                }
                first.mo5251attr("charset", charset().displayName());
                select("meta[name=charset]").remove();
            } else if (syntax != OutputSettings.Syntax.xml) {
            } else {
                Node node = childNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration2 = (XmlDeclaration) node;
                    if (xmlDeclaration2.name().equals(DocumentReader.RESERVED)) {
                        xmlDeclaration2.mo5251attr(Http2ExchangeCodec.ENCODING, charset().displayName());
                        if (xmlDeclaration2.attr(LitePalParser.NODE_VERSION) == null) {
                            return;
                        }
                        xmlDeclaration2.mo5251attr(LitePalParser.NODE_VERSION, "1.0");
                        return;
                    }
                    xmlDeclaration = new XmlDeclaration(DocumentReader.RESERVED, false);
                } else {
                    xmlDeclaration = new XmlDeclaration(DocumentReader.RESERVED, false);
                }
                xmlDeclaration.mo5251attr(LitePalParser.NODE_VERSION, "1.0");
                xmlDeclaration.mo5251attr(Http2ExchangeCodec.ENCODING, charset().displayName());
                prependChild(xmlDeclaration);
            }
        }
    }

    private Element findFirstElementByTagName(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        int childNodeSize = node.childNodeSize();
        for (int i = 0; i < childNodeSize; i++) {
            Element findFirstElementByTagName = findFirstElementByTagName(str, node.childNode(i));
            if (findFirstElementByTagName != null) {
                return findFirstElementByTagName;
            }
        }
        return null;
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < elementsByTag.size(); i++) {
                Element element2 = elementsByTag.get(i);
                arrayList.addAll(element2.ensureChildNodes());
                element2.remove();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                first.appendChild((Node) it.next());
            }
        }
        if (!first.mo5259parent().equals(element)) {
            element.appendChild(first);
        }
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(StringUtils.SPACE));
            body().prependChild(node2);
        }
    }

    public Element body() {
        return findFirstElementByTagName(MailTo.BODY, this);
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    /* renamed from: clone  reason: collision with other method in class */
    public Document mo5269clone() {
        Document document = (Document) super.mo5269clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public DocumentType documentType() {
        for (Node node : this.childNodes) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof LeafNode)) {
                return null;
            }
        }
        return null;
    }

    public Element head() {
        return findFirstElementByTagName("head", this);
    }

    public String location() {
        return this.location;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public Document normalise() {
        Element findFirstElementByTagName = findFirstElementByTagName("html", this);
        if (findFirstElementByTagName == null) {
            findFirstElementByTagName = appendElement("html");
        }
        if (head() == null) {
            findFirstElementByTagName.prependElement("head");
        }
        if (body() == null) {
            findFirstElementByTagName.appendElement(MailTo.BODY);
        }
        normaliseTextNodes(head());
        normaliseTextNodes(findFirstElementByTagName);
        normaliseTextNodes(this);
        normaliseStructure("head", findFirstElementByTagName);
        normaliseStructure(MailTo.BODY, findFirstElementByTagName);
        ensureMetaCharsetElement();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public Parser parser() {
        return this.parser;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    public String title() {
        Element first = getElementsByTag(NotificationCompatJellybean.KEY_TITLE).first();
        return first != null ? org.jsoup.internal.StringUtil.normaliseWhitespace(first.text()).trim() : "";
    }

    public void title(String str) {
        Validate.notNull(str);
        Element first = getElementsByTag(NotificationCompatJellybean.KEY_TITLE).first();
        if (first == null) {
            head().appendElement(NotificationCompatJellybean.KEY_TITLE).text(str);
        } else {
            first.text(str);
        }
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }
}
