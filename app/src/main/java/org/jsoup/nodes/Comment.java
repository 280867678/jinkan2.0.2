package org.jsoup.nodes;

import java.io.IOException;
import me.tvspark.outline;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* loaded from: classes5.dex */
public class Comment extends LeafNode {
    public Comment(String str) {
        this.value = str;
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    public XmlDeclaration asXmlDeclaration() {
        String data = getData();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("<");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(data.substring(1, data.length() - 1));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(">");
        Document parse = Jsoup.parse(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString(), baseUri(), Parser.xmlParser());
        if (parse.children().size() > 0) {
            Element child = parse.child(0);
            XmlDeclaration xmlDeclaration = new XmlDeclaration(NodeUtils.parser(parse).settings().normalizeTag(child.tagName()), data.startsWith("!"));
            xmlDeclaration.attributes().addAll(child.attributes());
            return xmlDeclaration;
        }
        return null;
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: attr */
    public /* bridge */ /* synthetic */ Node mo5251attr(String str, String str2) {
        return super.mo5251attr(str, str2);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: clone  reason: collision with other method in class */
    public Comment mo5269clone() {
        return (Comment) super.mo5269clone();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: empty */
    public /* bridge */ /* synthetic */ Node mo5257empty() {
        return super.mo5257empty();
    }

    public String getData() {
        return coreValue();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isXmlDeclaration() {
        String data = getData();
        return data.length() > 1 && (data.startsWith("!") || data.startsWith("?"));
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r5.outline() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (((org.jsoup.nodes.Element) r0).tag().formatAsBlock() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        indent(r3, r4, r5);
     */
    @Override // org.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint()) {
            if (siblingIndex() == 0) {
                Node node = this.parentNode;
                if (node instanceof Element) {
                }
            }
        }
        appendable.append("<!--").append(getData()).append("-->");
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public /* bridge */ /* synthetic */ Node mo5260removeAttr(String str) {
        return super.mo5260removeAttr(str);
    }

    public Comment setData(String str) {
        coreValue(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }
}
