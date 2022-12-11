package org.mozilla.javascript.ast;

import me.tvspark.outline;

/* loaded from: classes5.dex */
public class Yield extends AstNode {
    public AstNode value;

    public Yield() {
        this.type = 73;
    }

    public Yield(int i) {
        super(i);
        this.type = 73;
    }

    public Yield(int i, int i2) {
        super(i, i2);
        this.type = 73;
    }

    public Yield(int i, int i2, AstNode astNode) {
        super(i, i2);
        this.type = 73;
        setValue(astNode);
    }

    public AstNode getValue() {
        return this.value;
    }

    public void setValue(AstNode astNode) {
        this.value = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        if (this.value == null) {
            return "yield";
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("yield ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.value.toSource(0));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (!nodeVisitor.visit(this) || (astNode = this.value) == null) {
            return;
        }
        astNode.visit(nodeVisitor);
    }
}
