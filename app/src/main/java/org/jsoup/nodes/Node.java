package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

/* loaded from: classes5.dex */
public abstract class Node implements Cloneable {
    public static final String EmptyString = "";
    public Node parentNode;
    public int siblingIndex;

    /* loaded from: classes5.dex */
    public static class OuterHtmlVisitor implements NodeVisitor {
        public Appendable accum;
        public Document.OutputSettings out;

        public OuterHtmlVisitor(Appendable appendable, Document.OutputSettings outputSettings) {
            this.accum = appendable;
            this.out = outputSettings;
            outputSettings.prepareEncoder();
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            try {
                node.outerHtmlHead(this.accum, i, this.out);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if (!node.nodeName().equals("#text")) {
                try {
                    node.outerHtmlTail(this.accum, i, this.out);
                } catch (IOException e) {
                    throw new SerializationException(e);
                }
            }
        }
    }

    private void addSiblingHtml(int i, String str) {
        Validate.notNull(str);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(i, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, mo5259parent() instanceof Element ? (Element) mo5259parent() : null, baseUri()).toArray(new Node[0]));
    }

    private Element getDeepChild(Element element) {
        Elements children = element.children();
        return children.size() > 0 ? getDeepChild(children.get(0)) : element;
    }

    private void reindexChildren(int i) {
        List<Node> ensureChildNodes = ensureChildNodes();
        while (i < ensureChildNodes.size()) {
            ensureChildNodes.get(i).setSiblingIndex(i);
            i++;
        }
    }

    public String absUrl(String str) {
        Validate.notEmpty(str);
        return !hasAttr(str) ? "" : StringUtil.resolve(baseUri(), attr(str));
    }

    public void addChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr);
        if (nodeArr.length == 0) {
            return;
        }
        List<Node> ensureChildNodes = ensureChildNodes();
        Node mo5259parent = nodeArr[0].mo5259parent();
        if (mo5259parent == null || mo5259parent.childNodeSize() != nodeArr.length) {
            Validate.noNullElements(nodeArr);
            for (Node node : nodeArr) {
                reparentChild(node);
            }
            ensureChildNodes.addAll(i, Arrays.asList(nodeArr));
            reindexChildren(i);
            return;
        }
        List<Node> childNodes = mo5259parent.childNodes();
        int length = nodeArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0 || nodeArr[i2] != childNodes.get(i2)) {
                break;
            }
            length = i2;
        }
        mo5259parent.mo5257empty();
        ensureChildNodes.addAll(i, Arrays.asList(nodeArr));
        int length2 = nodeArr.length;
        while (true) {
            int i3 = length2 - 1;
            if (length2 <= 0) {
                reindexChildren(i);
                return;
            } else {
                nodeArr[i3].parentNode = this;
                length2 = i3;
            }
        }
    }

    public void addChildren(Node... nodeArr) {
        List<Node> ensureChildNodes = ensureChildNodes();
        for (Node node : nodeArr) {
            reparentChild(node);
            ensureChildNodes.add(node);
            node.setSiblingIndex(ensureChildNodes.size() - 1);
        }
    }

    /* renamed from: after */
    public Node mo5249after(String str) {
        addSiblingHtml(this.siblingIndex + 1, str);
        return this;
    }

    /* renamed from: after */
    public Node mo5250after(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex + 1, node);
        return this;
    }

    public String attr(String str) {
        Validate.notNull(str);
        if (!hasAttributes()) {
            return "";
        }
        String ignoreCase = attributes().getIgnoreCase(str);
        return ignoreCase.length() > 0 ? ignoreCase : str.startsWith("abs:") ? absUrl(str.substring(4)) : "";
    }

    /* renamed from: attr */
    public Node mo5251attr(String str, String str2) {
        attributes().putIgnoreCase(NodeUtils.parser(this).settings().normalizeAttribute(str), str2);
        return this;
    }

    public abstract Attributes attributes();

    public abstract String baseUri();

    /* renamed from: before */
    public Node mo5252before(String str) {
        addSiblingHtml(this.siblingIndex, str);
        return this;
    }

    /* renamed from: before */
    public Node mo5253before(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex, node);
        return this;
    }

    public Node childNode(int i) {
        return ensureChildNodes().get(i);
    }

    public abstract int childNodeSize();

    public List<Node> childNodes() {
        return Collections.unmodifiableList(ensureChildNodes());
    }

    public Node[] childNodesAsArray() {
        return (Node[]) ensureChildNodes().toArray(new Node[0]);
    }

    public List<Node> childNodesCopy() {
        List<Node> ensureChildNodes = ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size());
        for (Node node : ensureChildNodes) {
            arrayList.add(node.mo5269clone());
        }
        return arrayList;
    }

    /* renamed from: clearAttributes */
    public Node mo5254clearAttributes() {
        Iterator<Attribute> it = attributes().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public Node mo5269clone() {
        Node mo5267doClone = mo5267doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(mo5267doClone);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            int childNodeSize = node.childNodeSize();
            for (int i = 0; i < childNodeSize; i++) {
                List<Node> ensureChildNodes = node.ensureChildNodes();
                Node mo5267doClone2 = ensureChildNodes.get(i).mo5267doClone(node);
                ensureChildNodes.set(i, mo5267doClone2);
                linkedList.add(mo5267doClone2);
            }
        }
        return mo5267doClone;
    }

    /* renamed from: doClone */
    public Node mo5267doClone(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.parentNode = node;
            node2.siblingIndex = node == null ? 0 : this.siblingIndex;
            return node2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void doSetBaseUri(String str);

    /* renamed from: empty */
    public abstract Node mo5257empty();

    public abstract List<Node> ensureChildNodes();

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* renamed from: filter */
    public Node mo5258filter(NodeFilter nodeFilter) {
        Validate.notNull(nodeFilter);
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public boolean hasAttr(String str) {
        Validate.notNull(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (attributes().hasKeyIgnoreCase(substring) && !absUrl(substring).equals("")) {
                return true;
            }
        }
        return attributes().hasKeyIgnoreCase(str);
    }

    public abstract boolean hasAttributes();

    public boolean hasParent() {
        return this.parentNode != null;
    }

    public boolean hasSameValue(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return outerHtml().equals(((Node) obj).outerHtml());
        }
        return false;
    }

    public <T extends Appendable> T html(T t) {
        outerHtml(t);
        return t;
    }

    public void indent(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(StringUtil.padding(outputSettings.indentAmount() * i));
    }

    public Node nextSibling() {
        Node node = this.parentNode;
        if (node == null) {
            return null;
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        int i = this.siblingIndex + 1;
        if (ensureChildNodes.size() <= i) {
            return null;
        }
        return ensureChildNodes.get(i);
    }

    public abstract String nodeName();

    public void nodelistChanged() {
    }

    public String outerHtml() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        outerHtml(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public void outerHtml(Appendable appendable) {
        NodeTraversor.traverse(new OuterHtmlVisitor(appendable, NodeUtils.outputSettings(this)), this);
    }

    public abstract void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public abstract void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public Document ownerDocument() {
        Node mo5261root = mo5261root();
        if (mo5261root instanceof Document) {
            return (Document) mo5261root;
        }
        return null;
    }

    /* renamed from: parent */
    public Node mo5259parent() {
        return this.parentNode;
    }

    public final Node parentNode() {
        return this.parentNode;
    }

    public Node previousSibling() {
        Node node = this.parentNode;
        if (node != null && this.siblingIndex > 0) {
            return node.ensureChildNodes().get(this.siblingIndex - 1);
        }
        return null;
    }

    public void remove() {
        Validate.notNull(this.parentNode);
        this.parentNode.removeChild(this);
    }

    /* renamed from: removeAttr */
    public Node mo5260removeAttr(String str) {
        Validate.notNull(str);
        attributes().removeIgnoreCase(str);
        return this;
    }

    public void removeChild(Node node) {
        Validate.isTrue(node.parentNode == this);
        int i = node.siblingIndex;
        ensureChildNodes().remove(i);
        reindexChildren(i);
        node.parentNode = null;
    }

    public void reparentChild(Node node) {
        node.setParentNode(this);
    }

    public void replaceChild(Node node, Node node2) {
        Validate.isTrue(node.parentNode == this);
        Validate.notNull(node2);
        Node node3 = node2.parentNode;
        if (node3 != null) {
            node3.removeChild(node2);
        }
        int i = node.siblingIndex;
        ensureChildNodes().set(i, node2);
        node2.parentNode = this;
        node2.setSiblingIndex(i);
        node.parentNode = null;
    }

    public void replaceWith(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.replaceChild(this, node);
    }

    /* renamed from: root */
    public Node mo5261root() {
        Node node = this;
        while (true) {
            Node node2 = node.parentNode;
            if (node2 != null) {
                node = node2;
            } else {
                return node;
            }
        }
    }

    public void setBaseUri(String str) {
        Validate.notNull(str);
        doSetBaseUri(str);
    }

    public void setParentNode(Node node) {
        Validate.notNull(node);
        Node node2 = this.parentNode;
        if (node2 != null) {
            node2.removeChild(this);
        }
        this.parentNode = node;
    }

    public void setSiblingIndex(int i) {
        this.siblingIndex = i;
    }

    /* renamed from: shallowClone */
    public Node mo5262shallowClone() {
        return mo5267doClone(null);
    }

    public int siblingIndex() {
        return this.siblingIndex;
    }

    public List<Node> siblingNodes() {
        Node node = this.parentNode;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size() - 1);
        for (Node node2 : ensureChildNodes) {
            if (node2 != this) {
                arrayList.add(node2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return outerHtml();
    }

    /* renamed from: traverse */
    public Node mo5263traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Node unwrap() {
        Validate.notNull(this.parentNode);
        List<Node> ensureChildNodes = ensureChildNodes();
        Node node = ensureChildNodes.size() > 0 ? ensureChildNodes.get(0) : null;
        this.parentNode.addChildren(this.siblingIndex, childNodesAsArray());
        remove();
        return node;
    }

    /* renamed from: wrap */
    public Node mo5264wrap(String str) {
        Validate.notEmpty(str);
        List<Node> parseFragmentInput = NodeUtils.parser(this).parseFragmentInput(str, mo5259parent() instanceof Element ? (Element) mo5259parent() : null, baseUri());
        Node node = parseFragmentInput.get(0);
        if (!(node instanceof Element)) {
            return null;
        }
        Element element = (Element) node;
        Element deepChild = getDeepChild(element);
        this.parentNode.replaceChild(this, element);
        deepChild.addChildren(this);
        if (parseFragmentInput.size() > 0) {
            for (int i = 0; i < parseFragmentInput.size(); i++) {
                Node node2 = parseFragmentInput.get(i);
                node2.parentNode.removeChild(node2);
                element.appendChild(node2);
            }
        }
        return this;
    }
}
