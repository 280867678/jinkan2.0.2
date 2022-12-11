package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;

/* loaded from: classes5.dex */
public class DataNode extends LeafNode {
    public DataNode(String str) {
        this.value = str;
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str));
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
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
    public DataNode mo5269clone() {
        return (DataNode) super.mo5269clone();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: empty */
    public /* bridge */ /* synthetic */ Node mo5257empty() {
        return super.mo5257empty();
    }

    public String getWholeData() {
        return coreValue();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#data";
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(getWholeData());
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public /* bridge */ /* synthetic */ Node mo5260removeAttr(String str) {
        return super.mo5260removeAttr(str);
    }

    public DataNode setWholeData(String str) {
        coreValue(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }
}
