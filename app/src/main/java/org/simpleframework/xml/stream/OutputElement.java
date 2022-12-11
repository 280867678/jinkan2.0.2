package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class OutputElement implements OutputNode {
    public String comment;
    public String name;
    public OutputNode parent;
    public String reference;
    public NamespaceMap scope;
    public String value;
    public NodeWriter writer;
    public OutputNodeMap table = new OutputNodeMap(this);
    public Mode mode = Mode.INHERIT;

    public OutputElement(OutputNode outputNode, NodeWriter nodeWriter, String str) {
        this.scope = new PrefixResolver(outputNode);
        this.writer = nodeWriter;
        this.parent = outputNode;
        this.name = str;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void commit() throws Exception {
        this.writer.commit(this);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    /* renamed from: getAttributes  reason: collision with other method in class */
    public OutputNodeMap mo5310getAttributes() {
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
        return this.name;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public NamespaceMap getNamespaces() {
        return this.scope;
    }

    @Override // org.simpleframework.xml.stream.OutputNode, org.simpleframework.xml.stream.Node
    /* renamed from: getParent  reason: collision with other method in class */
    public OutputNode mo5311getParent() {
        return this.parent;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix() {
        return getPrefix(true);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix(boolean z) {
        String prefix = this.scope.getPrefix(this.reference);
        return (!z || prefix != null) ? prefix : this.parent.getPrefix();
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getReference() {
        return this.reference;
    }

    @Override // org.simpleframework.xml.stream.Node
    public String getValue() {
        return this.value;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public boolean isCommitted() {
        return this.writer.isCommitted(this);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public boolean isRoot() {
        return this.writer.isRoot(this);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void remove() throws Exception {
        this.writer.remove(this);
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

    public String toString() {
        return String.format("element %s", this.name);
    }
}
