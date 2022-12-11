package org.mozilla.javascript.ast;

import me.tvspark.outline;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class LetNode extends Scope {
    public AstNode body;

    /* renamed from: lp */
    public int f4714lp = -1;

    /* renamed from: rp */
    public int f4715rp = -1;
    public VariableDeclaration variables;

    public LetNode() {
        this.type = Token.LETEXPR;
    }

    public LetNode(int i) {
        super(i);
        this.type = Token.LETEXPR;
    }

    public LetNode(int i, int i2) {
        super(i, i2);
        this.type = Token.LETEXPR;
    }

    public AstNode getBody() {
        return this.body;
    }

    public int getLp() {
        return this.f4714lp;
    }

    public int getRp() {
        return this.f4715rp;
    }

    public VariableDeclaration getVariables() {
        return this.variables;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setLp(int i) {
        this.f4714lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4714lp = i;
        this.f4715rp = i2;
    }

    public void setRp(int i) {
        this.f4715rp = i;
    }

    public void setVariables(VariableDeclaration variableDeclaration) {
        assertNotNull(variableDeclaration);
        this.variables = variableDeclaration;
        variableDeclaration.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(makeIndent(i), "let (");
        printList(this.variables.getVariables(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") ");
        AstNode astNode = this.body;
        if (astNode != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(astNode.toSource(i));
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.variables.visit(nodeVisitor);
            AstNode astNode = this.body;
            if (astNode == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }
}
