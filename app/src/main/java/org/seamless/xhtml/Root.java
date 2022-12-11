package org.seamless.xhtml;

import androidx.core.net.MailTo;
import javax.xml.xpath.XPath;
import org.seamless.xhtml.XHTML;
import org.seamless.xml.DOMElement;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class Root extends XHTMLElement {
    public Root(XPath xPath, Element element) {
        super(xPath, element);
    }

    public Body getBody() {
        DOMElement<XHTMLElement, XHTMLElement>.Builder<Body> builder = new DOMElement<XHTMLElement, XHTMLElement>.Builder<Body>(this) { // from class: org.seamless.xhtml.Root.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public Body mo5294build(Element element) {
                return new Body(Root.this.getXpath(), element);
            }
        };
        XHTML.ELEMENT element = XHTML.ELEMENT.body;
        return builder.firstChildOrNull(MailTo.BODY);
    }

    public Head getHead() {
        DOMElement<XHTMLElement, XHTMLElement>.Builder<Head> builder = new DOMElement<XHTMLElement, XHTMLElement>.Builder<Head>(this) { // from class: org.seamless.xhtml.Root.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public Head mo5294build(Element element) {
                return new Head(Root.this.getXpath(), element);
            }
        };
        XHTML.ELEMENT element = XHTML.ELEMENT.head;
        return builder.firstChildOrNull("head");
    }
}
