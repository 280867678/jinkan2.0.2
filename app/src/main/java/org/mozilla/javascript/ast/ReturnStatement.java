package org.mozilla.javascript.ast;

import org.apache.commons.lang3.StringUtils;
import org.fourthline.cling.model.meta.QueryStateVariableAction;

/* loaded from: classes5.dex */
public class ReturnStatement extends AstNode {
    public AstNode returnValue;

    public ReturnStatement() {
        this.type = 4;
    }

    public ReturnStatement(int i) {
        super(i);
        this.type = 4;
    }

    public ReturnStatement(int i, int i2) {
        super(i, i2);
        this.type = 4;
    }

    public ReturnStatement(int i, int i2, AstNode astNode) {
        super(i, i2);
        this.type = 4;
        setReturnValue(astNode);
    }

    public AstNode getReturnValue() {
        return this.returnValue;
    }

    public void setReturnValue(AstNode astNode) {
        this.returnValue = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(QueryStateVariableAction.OUTPUT_ARG_RETURN);
        if (this.returnValue != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.returnValue.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (!nodeVisitor.visit(this) || (astNode = this.returnValue) == null) {
            return;
        }
        astNode.visit(nodeVisitor);
    }
}
