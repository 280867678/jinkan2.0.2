package org.fourthline.cling.support.messagebox.parser;

import javax.xml.xpath.XPath;
import me.tvspark.outline;
import org.seamless.xml.DOMElement;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class MessageElement extends DOMElement<MessageElement, MessageElement> {
    public static final String XPATH_PREFIX = "m";

    public MessageElement(XPath xPath, Element element) {
        super(xPath, element);
    }

    @Override // org.seamless.xml.DOMElement
    public DOMElement<MessageElement, MessageElement>.ArrayBuilder<MessageElement> createChildBuilder(DOMElement dOMElement) {
        return new DOMElement<MessageElement, MessageElement>.ArrayBuilder<MessageElement>(dOMElement) { // from class: org.fourthline.cling.support.messagebox.parser.MessageElement.2
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public MessageElement mo5294build(Element element) {
                return new MessageElement(MessageElement.this.getXpath(), element);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.ArrayBuilder
            /* renamed from: newChildrenArray */
            public MessageElement[] mo5295newChildrenArray(int i) {
                return new MessageElement[i];
            }
        };
    }

    @Override // org.seamless.xml.DOMElement
    public DOMElement<MessageElement, MessageElement>.Builder<MessageElement> createParentBuilder(DOMElement dOMElement) {
        return new DOMElement<MessageElement, MessageElement>.Builder<MessageElement>(dOMElement) { // from class: org.fourthline.cling.support.messagebox.parser.MessageElement.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // org.seamless.xml.DOMElement.Builder
            /* renamed from: build */
            public MessageElement mo5294build(Element element) {
                return new MessageElement(MessageElement.this.getXpath(), element);
            }
        };
    }

    @Override // org.seamless.xml.DOMElement
    public String prefix(String str) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("m:", str);
    }
}
