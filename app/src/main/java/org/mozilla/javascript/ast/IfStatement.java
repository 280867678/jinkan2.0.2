package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class IfStatement extends AstNode {
    public AstNode condition;
    public AstNode elseKeyWordInlineComment;
    public AstNode elsePart;
    public int elsePosition = -1;

    /* renamed from: lp */
    public int f4712lp = -1;

    /* renamed from: rp */
    public int f4713rp = -1;
    public AstNode thenPart;

    public IfStatement() {
        this.type = 113;
    }

    public IfStatement(int i) {
        super(i);
        this.type = 113;
    }

    public IfStatement(int i, int i2) {
        super(i, i2);
        this.type = 113;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public AstNode getElseKeyWordInlineComment() {
        return this.elseKeyWordInlineComment;
    }

    public AstNode getElsePart() {
        return this.elsePart;
    }

    public int getElsePosition() {
        return this.elsePosition;
    }

    public int getLp() {
        return this.f4712lp;
    }

    public int getRp() {
        return this.f4713rp;
    }

    public AstNode getThenPart() {
        return this.thenPart;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public void setElseKeyWordInlineComment(AstNode astNode) {
        this.elseKeyWordInlineComment = astNode;
    }

    public void setElsePart(AstNode astNode) {
        this.elsePart = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setElsePosition(int i) {
        this.elsePosition = i;
    }

    public void setLp(int i) {
        this.f4712lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4712lp = i;
        this.f4713rp = i2;
    }

    public void setRp(int i) {
        this.f4713rp = i;
    }

    public void setThenPart(AstNode astNode) {
        assertNotNull(astNode);
        this.thenPart = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String str;
        String makeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder(32);
        sb.append(makeIndent);
        sb.append("if (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append("    ");
            sb.append(getInlineComment().toSource());
            sb.append("\n");
        }
        if (this.thenPart.getType() != 130) {
            if (getInlineComment() == null) {
                sb.append("\n");
            }
            sb.append(makeIndent(i + 1));
        }
        sb.append(this.thenPart.toSource(i).trim());
        if (this.elsePart != null) {
            if (this.thenPart.getType() != 130) {
                sb.append("\n");
                sb.append(makeIndent);
                str = "else ";
            } else {
                str = " else ";
            }
            sb.append(str);
            if (getElseKeyWordInlineComment() != null) {
                sb.append("    ");
                sb.append(getElseKeyWordInlineComment().toSource());
                sb.append("\n");
            }
            if (this.elsePart.getType() != 130 && this.elsePart.getType() != 113) {
                if (getElseKeyWordInlineComment() == null) {
                    sb.append("\n");
                }
                sb.append(makeIndent(i + 1));
            }
            sb.append(this.elsePart.toSource(i).trim());
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.thenPart.visit(nodeVisitor);
            AstNode astNode = this.elsePart;
            if (astNode == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }
}
