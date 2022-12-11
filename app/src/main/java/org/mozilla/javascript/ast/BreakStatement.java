package org.mozilla.javascript.ast;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class BreakStatement extends Jump {
    public Name breakLabel;
    public AstNode target;

    public BreakStatement() {
        this.type = 121;
    }

    public BreakStatement(int i) {
        this.type = 121;
        this.position = i;
    }

    public BreakStatement(int i, int i2) {
        this.type = 121;
        this.position = i;
        this.length = i2;
    }

    public Name getBreakLabel() {
        return this.breakLabel;
    }

    public AstNode getBreakTarget() {
        return this.target;
    }

    public void setBreakLabel(Name name) {
        this.breakLabel = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    public void setBreakTarget(Jump jump) {
        assertNotNull(jump);
        this.target = jump;
        setJumpStatement(jump);
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("break");
        if (this.breakLabel != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.breakLabel.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        Name name;
        if (!nodeVisitor.visit(this) || (name = this.breakLabel) == null) {
            return;
        }
        name.visit(nodeVisitor);
    }
}
