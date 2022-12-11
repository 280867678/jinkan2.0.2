package org.seamless.xhtml;

import androidx.core.app.NotificationCompatJellybean;
import javax.xml.xpath.XPath;
import org.seamless.xhtml.XHTML;
import org.seamless.xml.DOMElement;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class Head extends XHTMLElement {
    public Head(XPath xPath, Element element) {
        super(xPath, element);
    }

    public XHTMLElement[] getDocumentStyles() {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder = this.CHILD_BUILDER;
        XHTML.ELEMENT element = XHTML.ELEMENT.style;
        return (XHTMLElement[]) arrayBuilder.getChildElements("style");
    }

    public XHTMLElement getHeadTitle() {
        DOMElement.Builder builder = this.CHILD_BUILDER;
        XHTML.ELEMENT element = XHTML.ELEMENT.title;
        return (XHTMLElement) builder.firstChildOrNull(NotificationCompatJellybean.KEY_TITLE);
    }

    public Link[] getLinks() {
        DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<Link> arrayBuilder = new DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<Link>(this) { // from class: org.seamless.xhtml.Head.1
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public Link mo5294build(Element element) {
                return new Link(Head.this.getXpath(), element);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.ArrayBuilder
            /* renamed from: newChildrenArray */
            public Link[] mo5295newChildrenArray(int i) {
                return new Link[i];
            }
        };
        XHTML.ELEMENT element = XHTML.ELEMENT.link;
        return arrayBuilder.getChildElements("link");
    }

    public Meta[] getMetas() {
        DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<Meta> arrayBuilder = new DOMElement<XHTMLElement, XHTMLElement>.ArrayBuilder<Meta>(this) { // from class: org.seamless.xhtml.Head.2
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public Meta mo5294build(Element element) {
                return new Meta(Head.this.getXpath(), element);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.ArrayBuilder
            /* renamed from: newChildrenArray */
            public Meta[] mo5295newChildrenArray(int i) {
                return new Meta[i];
            }
        };
        XHTML.ELEMENT element = XHTML.ELEMENT.meta;
        return arrayBuilder.getChildElements("meta");
    }

    public XHTMLElement[] getScripts() {
        DOMElement<CHILD, PARENT>.ArrayBuilder<CHILD> arrayBuilder = this.CHILD_BUILDER;
        XHTML.ELEMENT element = XHTML.ELEMENT.script;
        return (XHTMLElement[]) arrayBuilder.getChildElements("script");
    }
}
