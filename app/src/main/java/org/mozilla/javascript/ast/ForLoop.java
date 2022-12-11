package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ForLoop extends Loop {
    public AstNode condition;
    public AstNode increment;
    public AstNode initializer;

    public ForLoop() {
        this.type = 120;
    }

    public ForLoop(int i) {
        super(i);
        this.type = 120;
    }

    public ForLoop(int i, int i2) {
        super(i, i2);
        this.type = 120;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public AstNode getIncrement() {
        return this.increment;
    }

    public AstNode getInitializer() {
        return this.initializer;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public void setIncrement(AstNode astNode) {
        assertNotNull(astNode);
        this.increment = astNode;
        astNode.setParent(this);
    }

    public void setInitializer(AstNode astNode) {
        assertNotNull(astNode);
        this.initializer = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("for (");
        sb.append(this.initializer.toSource(0));
        sb.append("; ");
        sb.append(this.condition.toSource(0));
        sb.append("; ");
        sb.append(this.increment.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource());
            sb.append("\n");
        }
        if (this.body.getType() == 130) {
            String source = this.body.toSource(i);
            if (getInlineComment() == null) {
                source = source.trim();
            }
            sb.append(source);
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
            this.initializer.visit(nodeVisitor);
            this.condition.visit(nodeVisitor);
            this.increment.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }
}
