package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class WhileLoop extends Loop {
    public AstNode condition;

    public WhileLoop() {
        this.type = 118;
    }

    public WhileLoop(int i) {
        super(i);
        this.type = 118;
    }

    public WhileLoop(int i, int i2) {
        super(i, i2);
        this.type = 118;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("while (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1));
            sb.append("\n");
        }
        if (this.body.getType() == 130) {
            sb.append(this.body.toSource(i).trim());
            sb.append("\n");
        } else {
            if (getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(this.body.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }
}
