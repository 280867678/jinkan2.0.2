package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class OutputDocument implements OutputNode {
    public String comment;
    public String name;
    public String reference;
    public OutputStack stack;
    public String value;
    public NodeWriter writer;
    public OutputNodeMap table = new OutputNodeMap(this);
    public Mode mode = Mode.INHERIT;

    public OutputDocument(NodeWriter nodeWriter, OutputStack outputStack) {
        this.writer = nodeWriter;
        this.stack = outputStack;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void commit() throws Exception {
        if (!this.stack.isEmpty()) {
            this.stack.bottom().commit();
            return;
        }
        throw new NodeException("No root node");
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    /* renamed from: getAttributes */
    public NodeMap<OutputNode> mo5310getAttributes() {
        return this.table;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public OutputNode getChild(String str) throws Exception {
        return this.writer.writeElement(this, str);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getComment() {
        return this.comment;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public Mode getMode() {
        return this.mode;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getName() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public NamespaceMap getNamespaces() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode, org.simpleframework.xml.stream.Node
    /* renamed from: getParent  reason: collision with other method in class */
    public OutputNode mo5311getParent() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix(boolean z) {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getReference() {
        return this.reference;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getValue() throws Exception {
        return this.value;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public boolean isCommitted() {
        return this.stack.isEmpty();
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public boolean isRoot() {
        return true;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void remove() throws Exception {
        if (!this.stack.isEmpty()) {
            this.stack.bottom().remove();
            return;
        }
        throw new NodeException("No root node");
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public OutputNode setAttribute(String str, String str2) {
        return this.table.mo5314put(str, str2);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setComment(String str) {
        this.comment = str;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setData(boolean z) {
        this.mode = z ? Mode.DATA : Mode.ESCAPE;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setName(String str) {
        this.name = str;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setReference(String str) {
        this.reference = str;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setValue(String str) {
        this.value = str;
    }
}
