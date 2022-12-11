package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class WithStatement extends AstNode {
    public AstNode expression;

    /* renamed from: lp */
    public int f4720lp = -1;

    /* renamed from: rp */
    public int f4721rp = -1;
    public AstNode statement;

    public WithStatement() {
        this.type = 124;
    }

    public WithStatement(int i) {
        super(i);
        this.type = 124;
    }

    public WithStatement(int i, int i2) {
        super(i, i2);
        this.type = 124;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public int getLp() {
        return this.f4720lp;
    }

    public int getRp() {
        return this.f4721rp;
    }

    public AstNode getStatement() {
        return this.statement;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setLp(int i) {
        this.f4720lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4720lp = i;
        this.f4721rp = i2;
    }

    public void setRp(int i) {
        this.f4721rp = i;
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("with (");
        sb.append(this.expression.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1));
        }
        if (this.statement.getType() == 130) {
            if (getInlineComment() != null) {
                sb.append("\n");
            }
            sb.append(this.statement.toSource(i).trim());
            sb.append("\n");
        } else {
            sb.append("\n");
            sb.append(this.statement.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            this.statement.visit(nodeVisitor);
        }
    }
}
