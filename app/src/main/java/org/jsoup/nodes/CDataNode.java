package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.seamless.xml.DOM;

/* loaded from: classes5.dex */
public class CDataNode extends TextNode {
    public CDataNode(String str) {
        super(str);
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    /* renamed from: clone  reason: collision with other method in class */
    public CDataNode mo5269clone() {
        return (CDataNode) super.mo5269clone();
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    public String nodeName() {
        return "#cdata";
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(DOM.CDATA_BEGIN).append(getWholeText());
    }

    @Override // org.jsoup.nodes.TextNode, org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
        try {
            appendable.append(DOM.CDATA_END);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override // org.jsoup.nodes.TextNode
    public String text() {
        return getWholeText();
    }
}
