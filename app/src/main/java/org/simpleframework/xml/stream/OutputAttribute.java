package org.simpleframework.xml.stream;

/* loaded from: classes5.dex */
public class OutputAttribute implements OutputNode {
    public String name;
    public String reference;
    public NamespaceMap scope;
    public OutputNode source;
    public String value;

    public OutputAttribute(OutputNode outputNode, String str, String str2) {
        this.scope = outputNode.getNamespaces();
        this.source = outputNode;
        this.value = str2;
        this.name = str;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void commit() {
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    /* renamed from: getAttributes */
    public NodeMap<OutputNode> mo5310getAttributes() {
        return new OutputNodeMap(this);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public OutputNode getChild(String str) {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getComment() {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public Mode getMode() {
        return Mode.INHERIT;
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
        return this.source;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix() {
        return this.scope.getPrefix(this.reference);
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public String getPrefix(boolean z) {
        return this.scope.getPrefix(this.reference);
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
        return true;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public boolean isRoot() {
        return false;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void remove() {
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public OutputNode setAttribute(String str, String str2) {
        return null;
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setComment(String str) {
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setData(boolean z) {
    }

    @Override // org.simpleframework.xml.stream.OutputNode
    public void setMode(Mode mode) {
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
        return String.format("attribute %s='%s'", this.name, this.value);
    }
}
