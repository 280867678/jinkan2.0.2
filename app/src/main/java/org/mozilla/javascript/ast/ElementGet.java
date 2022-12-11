package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ElementGet extends AstNode {
    public AstNode element;

    /* renamed from: lb */
    public int f4704lb = -1;

    /* renamed from: rb */
    public int f4705rb = -1;
    public AstNode target;

    public ElementGet() {
        this.type = 36;
    }

    public ElementGet(int i) {
        super(i);
        this.type = 36;
    }

    public ElementGet(int i, int i2) {
        super(i, i2);
        this.type = 36;
    }

    public ElementGet(AstNode astNode, AstNode astNode2) {
        this.type = 36;
        setTarget(astNode);
        setElement(astNode2);
    }

    public AstNode getElement() {
        return this.element;
    }

    public int getLb() {
        return this.f4704lb;
    }

    public int getRb() {
        return this.f4705rb;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setElement(AstNode astNode) {
        assertNotNull(astNode);
        this.element = astNode;
        astNode.setParent(this);
    }

    public void setLb(int i) {
        this.f4704lb = i;
    }

    public void setParens(int i, int i2) {
        this.f4704lb = i;
        this.f4705rb = i2;
    }

    public void setRb(int i) {
        this.f4705rb = i;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.target.toSource(0) + "[" + this.element.toSource(0) + "]";
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            this.element.visit(nodeVisitor);
        }
    }
}
