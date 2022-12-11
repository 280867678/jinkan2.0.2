package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class CatchClause extends AstNode {
    public Block body;
    public AstNode catchCondition;
    public int ifPosition = -1;

    /* renamed from: lp */
    public int f4702lp = -1;

    /* renamed from: rp */
    public int f4703rp = -1;
    public Name varName;

    public CatchClause() {
        this.type = 125;
    }

    public CatchClause(int i) {
        super(i);
        this.type = 125;
    }

    public CatchClause(int i, int i2) {
        super(i, i2);
        this.type = 125;
    }

    public Block getBody() {
        return this.body;
    }

    public AstNode getCatchCondition() {
        return this.catchCondition;
    }

    public int getIfPosition() {
        return this.ifPosition;
    }

    public int getLp() {
        return this.f4702lp;
    }

    public int getRp() {
        return this.f4703rp;
    }

    public Name getVarName() {
        return this.varName;
    }

    public void setBody(Block block) {
        assertNotNull(block);
        this.body = block;
        block.setParent(this);
    }

    public void setCatchCondition(AstNode astNode) {
        this.catchCondition = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setIfPosition(int i) {
        this.ifPosition = i;
    }

    public void setLp(int i) {
        this.f4702lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4702lp = i;
        this.f4703rp = i2;
    }

    public void setRp(int i) {
        this.f4703rp = i;
    }

    public void setVarName(Name name) {
        assertNotNull(name);
        this.varName = name;
        name.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("catch (");
        sb.append(this.varName.toSource(0));
        if (this.catchCondition != null) {
            sb.append(" if ");
            sb.append(this.catchCondition.toSource(0));
        }
        sb.append(") ");
        sb.append(this.body.toSource(0));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.varName.visit(nodeVisitor);
            AstNode astNode = this.catchCondition;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
            this.body.visit(nodeVisitor);
        }
    }
}
