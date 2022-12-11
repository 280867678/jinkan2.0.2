package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class FunctionCall extends AstNode {
    public static final List<AstNode> NO_ARGS = Collections.unmodifiableList(new ArrayList());
    public List<AstNode> arguments;

    /* renamed from: lp */
    public int f4706lp = -1;

    /* renamed from: rp */
    public int f4707rp = -1;
    public AstNode target;

    public FunctionCall() {
        this.type = 38;
    }

    public FunctionCall(int i) {
        super(i);
        this.type = 38;
    }

    public FunctionCall(int i, int i2) {
        super(i, i2);
        this.type = 38;
    }

    public void addArgument(AstNode astNode) {
        assertNotNull(astNode);
        if (this.arguments == null) {
            this.arguments = new ArrayList();
        }
        this.arguments.add(astNode);
        astNode.setParent(this);
    }

    public List<AstNode> getArguments() {
        List<AstNode> list = this.arguments;
        return list != null ? list : NO_ARGS;
    }

    public int getLp() {
        return this.f4706lp;
    }

    public int getRp() {
        return this.f4707rp;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setArguments(List<AstNode> list) {
        if (list == null) {
            this.arguments = null;
            return;
        }
        List<AstNode> list2 = this.arguments;
        if (list2 != null) {
            list2.clear();
        }
        for (AstNode astNode : list) {
            addArgument(astNode);
        }
    }

    public void setLp(int i) {
        this.f4706lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4706lp = i;
        this.f4707rp = i2;
    }

    public void setRp(int i) {
        this.f4707rp = i;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(this.target.toSource(0));
        sb.append("(");
        List<AstNode> list = this.arguments;
        if (list != null) {
            printList(list, sb);
        }
        sb.append(")");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            for (AstNode astNode : getArguments()) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
