package org.fourthline.cling.support.messagebox.parser;

import javax.xml.xpath.XPath;
import org.seamless.xml.DOMParser;
import org.seamless.xml.NamespaceContextMap;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class MessageDOMParser extends DOMParser<MessageDOM> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.seamless.xml.DOMParser
    /* renamed from: createDOM */
    public MessageDOM mo5296createDOM(Document document) {
        return new MessageDOM(document);
    }

    public NamespaceContextMap createDefaultNamespaceContext(String... strArr) {
        NamespaceContextMap namespaceContextMap = new NamespaceContextMap() { // from class: org.fourthline.cling.support.messagebox.parser.MessageDOMParser.1
            @Override // org.seamless.xml.NamespaceContextMap
            public String getDefaultNamespaceURI() {
                return MessageDOM.NAMESPACE_URI;
            }
        };
        for (String str : strArr) {
            namespaceContextMap.put(str, MessageDOM.NAMESPACE_URI);
        }
        return namespaceContextMap;
    }

    public XPath createXPath() {
        return super.createXPath(createDefaultNamespaceContext("m"));
    }
}
