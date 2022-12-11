package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class DoLoop extends Loop {
    public AstNode condition;
    public int whilePosition = -1;

    public DoLoop() {
        this.type = 119;
    }

    public DoLoop(int i) {
        super(i);
        this.type = 119;
    }

    public DoLoop(int i, int i2) {
        super(i, i2);
        this.type = 119;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public int getWhilePosition() {
        return this.whilePosition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public void setWhilePosition(int i) {
        this.whilePosition = i;
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("do ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1));
            sb.append("\n");
        }
        sb.append(this.body.toSource(i).trim());
        sb.append(" while (");
        sb.append(this.condition.toSource(0));
        sb.append(");\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.body.visit(nodeVisitor);
            this.condition.visit(nodeVisitor);
        }
    }
}
