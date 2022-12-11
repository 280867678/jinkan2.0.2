package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class InputElement implements InputNode {
    public final InputNodeMap map;
    public final EventNode node;
    public final InputNode parent;
    public final NodeReader reader;

    public InputElement(InputNode inputNode, NodeReader nodeReader, EventNode eventNode) {
        this.map = new InputNodeMap(this, eventNode);
        this.reader = nodeReader;
        this.parent = inputNode;
        this.node = eventNode;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getAttribute(String str) {
        return this.map.mo5312get(str);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public NodeMap<InputNode> getAttributes() {
        return this.map;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getName() {
        return this.node.getName();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext() throws Exception {
        return this.reader.readElement(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public InputNode getNext(String str) throws Exception {
        return this.reader.readElement(this, str);
    }

    @Override // org.simpleframework.xml.stream.InputNode, org.simpleframework.xml.stream.Node
    /* renamed from: getParent */
    public InputNode mo5311getParent() {
        return this.parent;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Position getPosition() {
        return new InputPosition(this.node);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getPrefix() {
        return this.node.getPrefix();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public String getReference() {
        return this.node.getReference();
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public Object getSource() {
        return this.node.getSource();
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getValue() throws Exception {
        return this.reader.readValue(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isElement() {
        return true;
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isEmpty() throws Exception {
        if (!this.map.isEmpty()) {
            return false;
        }
        return this.reader.isEmpty(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public boolean isRoot() {
        return this.reader.isRoot(this);
    }

    @Override // org.simpleframework.xml.stream.InputNode
    public void skip() throws Exception {
        this.reader.skipElement(this);
    }

    public String toString() {
        return String.format("element %s", getName());
    }
}
