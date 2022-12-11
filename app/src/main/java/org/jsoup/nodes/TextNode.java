package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;

/* loaded from: classes5.dex */
public class TextNode extends LeafNode {
    public TextNode(String str) {
        this.value = str;
    }

    public static TextNode createFromEncoded(String str) {
        return new TextNode(Entities.unescape(str));
    }

    public static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public static String normaliseWhitespace(String str) {
        return StringUtil.normaliseWhitespace(str);
    }

    public static String stripLeadingWhitespace(String str) {
        return str.replaceFirst("^\\s+", "");
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
    /* renamed from: clone */
    public TextNode mo5269clone() {
        return (TextNode) super.mo5269clone();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: empty */
    public /* bridge */ /* synthetic */ Node mo5257empty() {
        return super.mo5257empty();
    }

    public String getWholeText() {
        return coreValue();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isBlank() {
        return StringUtil.isBlank(coreValue());
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (isBlank() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        indent(r10, r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (isBlank() == false) goto L11;
     */
    @Override // org.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        boolean prettyPrint = outputSettings.prettyPrint();
        if (prettyPrint) {
            if (siblingIndex() == 0) {
                Node node = this.parentNode;
                if (node instanceof Element) {
                    if (((Element) node).tag().formatAsBlock()) {
                    }
                }
            }
            if (outputSettings.outline()) {
                if (siblingNodes().size() > 0) {
                }
            }
        }
        Entities.escape(appendable, coreValue(), outputSettings, false, prettyPrint && !Element.preserveWhitespace(this.parentNode), prettyPrint && (this.parentNode instanceof Document));
    }

    @Override // org.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public /* bridge */ /* synthetic */ Node mo5260removeAttr(String str) {
        return super.mo5260removeAttr(str);
    }

    public TextNode splitText(int i) {
        String coreValue = coreValue();
        Validate.isTrue(i >= 0, "Split offset must be not be negative");
        Validate.isTrue(i < coreValue.length(), "Split offset must not be greater than current text length");
        String substring = coreValue.substring(0, i);
        String substring2 = coreValue.substring(i);
        text(substring);
        TextNode textNode = new TextNode(substring2);
        if (mo5259parent() != null) {
            mo5259parent().addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    public String text() {
        return StringUtil.normaliseWhitespace(getWholeText());
    }

    public TextNode text(String str) {
        coreValue(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }
}
