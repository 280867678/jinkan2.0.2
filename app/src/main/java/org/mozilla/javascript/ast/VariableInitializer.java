package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class VariableInitializer extends AstNode {
    public AstNode initializer;
    public AstNode target;

    public VariableInitializer() {
        this.type = 123;
    }

    public VariableInitializer(int i) {
        super(i);
        this.type = 123;
    }

    public VariableInitializer(int i, int i2) {
        super(i, i2);
        this.type = 123;
    }

    public AstNode getInitializer() {
        return this.initializer;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public boolean isDestructuring() {
        return !(this.target instanceof Name);
    }

    public void setInitializer(AstNode astNode) {
        this.initializer = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setNodeType(int i) {
        if (i == 123 || i == 155 || i == 154) {
            mo5274setType(i);
            return;
        }
        throw new IllegalArgumentException("invalid node type");
    }

    public void setTarget(AstNode astNode) {
        if (astNode != null) {
            this.target = astNode;
            astNode.setParent(this);
            return;
        }
        throw new IllegalArgumentException("invalid target arg");
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(this.target.toSource(0));
        if (this.initializer != null) {
            sb.append(" = ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            AstNode astNode = this.initializer;
            if (astNode == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }
}
