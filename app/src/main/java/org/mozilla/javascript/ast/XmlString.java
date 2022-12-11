package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlString extends XmlFragment {
    public String xml;

    public XmlString() {
    }

    public XmlString(int i) {
        super(i);
    }

    public XmlString(int i, String str) {
        super(i);
        setXml(str);
    }

    public String getXml() {
        return this.xml;
    }

    public void setXml(String str) {
        assertNotNull(str);
        this.xml = str;
        setLength(str.length());
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.xml;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
