package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlElemRef extends XmlRef {
    public AstNode indexExpr;

    /* renamed from: lb */
    public int f4723lb = -1;

    /* renamed from: rb */
    public int f4724rb = -1;

    public XmlElemRef() {
        this.type = 78;
    }

    public XmlElemRef(int i) {
        super(i);
        this.type = 78;
    }

    public XmlElemRef(int i, int i2) {
        super(i, i2);
        this.type = 78;
    }

    public AstNode getExpression() {
        return this.indexExpr;
    }

    public int getLb() {
        return this.f4723lb;
    }

    public int getRb() {
        return this.f4724rb;
    }

    public void setBrackets(int i, int i2) {
        this.f4723lb = i;
        this.f4724rb = i2;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.indexExpr = astNode;
        astNode.setParent(this);
    }

    public void setLb(int i) {
        this.f4723lb = i;
    }

    public void setRb(int i) {
        this.f4724rb = i;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        Name name = this.namespace;
        if (name != null) {
            sb.append(name.toSource(0));
            sb.append("::");
        }
        sb.append("[");
        sb.append(this.indexExpr.toSource(0));
        sb.append("]");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            Name name = this.namespace;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            this.indexExpr.visit(nodeVisitor);
        }
    }
}
