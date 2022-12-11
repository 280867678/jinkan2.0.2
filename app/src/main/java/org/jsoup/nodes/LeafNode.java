package org.jsoup.nodes;

import java.util.Collections;
import java.util.List;
import org.jsoup.helper.Validate;

/* loaded from: classes5.dex */
public abstract class LeafNode extends Node {
    public static final List<Node> EmptyNodes = Collections.emptyList();
    public Object value;

    private void ensureAttributes() {
        if (!hasAttributes()) {
            Object obj = this.value;
            Attributes attributes = new Attributes();
            this.value = attributes;
            if (obj == null) {
                return;
            }
            attributes.put(nodeName(), (String) obj);
        }
    }

    @Override // org.jsoup.nodes.Node
    public String absUrl(String str) {
        ensureAttributes();
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.Node
    public String attr(String str) {
        Validate.notNull(str);
        return !hasAttributes() ? str.equals(nodeName()) ? (String) this.value : "" : super.attr(str);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: attr */
    public Node mo5251attr(String str, String str2) {
        if (hasAttributes() || !str.equals(nodeName())) {
            ensureAttributes();
            super.mo5251attr(str, str2);
        } else {
            this.value = str2;
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public final Attributes attributes() {
        ensureAttributes();
        return (Attributes) this.value;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return hasParent() ? mo5259parent().baseUri() : "";
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return 0;
    }

    public String coreValue() {
        return attr(nodeName());
    }

    public void coreValue(String str) {
        mo5251attr(nodeName(), str);
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: doClone */
    public LeafNode mo5267doClone(Node node) {
        LeafNode leafNode = (LeafNode) super.mo5267doClone(node);
        if (hasAttributes()) {
            leafNode.value = ((Attributes) this.value).clone();
        }
        return leafNode;
    }

    @Override // org.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: empty */
    public Node mo5257empty() {
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        return EmptyNodes;
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttr(String str) {
        ensureAttributes();
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public final boolean hasAttributes() {
        return this.value instanceof Attributes;
    }

    @Override // org.jsoup.nodes.Node
    /* renamed from: removeAttr */
    public Node mo5260removeAttr(String str) {
        ensureAttributes();
        return super.mo5260removeAttr(str);
    }
}
