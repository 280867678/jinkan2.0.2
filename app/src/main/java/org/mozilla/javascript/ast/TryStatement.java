package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class TryStatement extends AstNode {
    public static final List<CatchClause> NO_CATCHES = Collections.unmodifiableList(new ArrayList());
    public List<CatchClause> catchClauses;
    public AstNode finallyBlock;
    public int finallyPosition = -1;
    public AstNode tryBlock;

    public TryStatement() {
        this.type = 82;
    }

    public TryStatement(int i) {
        super(i);
        this.type = 82;
    }

    public TryStatement(int i, int i2) {
        super(i, i2);
        this.type = 82;
    }

    public void addCatchClause(CatchClause catchClause) {
        assertNotNull(catchClause);
        if (this.catchClauses == null) {
            this.catchClauses = new ArrayList();
        }
        this.catchClauses.add(catchClause);
        catchClause.setParent(this);
    }

    public List<CatchClause> getCatchClauses() {
        List<CatchClause> list = this.catchClauses;
        return list != null ? list : NO_CATCHES;
    }

    public AstNode getFinallyBlock() {
        return this.finallyBlock;
    }

    public int getFinallyPosition() {
        return this.finallyPosition;
    }

    public AstNode getTryBlock() {
        return this.tryBlock;
    }

    public void setCatchClauses(List<CatchClause> list) {
        if (list == null) {
            this.catchClauses = null;
            return;
        }
        List<CatchClause> list2 = this.catchClauses;
        if (list2 != null) {
            list2.clear();
        }
        for (CatchClause catchClause : list) {
            addCatchClause(catchClause);
        }
    }

    public void setFinallyBlock(AstNode astNode) {
        this.finallyBlock = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setFinallyPosition(int i) {
        this.finallyPosition = i;
    }

    public void setTryBlock(AstNode astNode) {
        assertNotNull(astNode);
        this.tryBlock = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append(makeIndent(i));
        sb.append("try ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1));
            sb.append("\n");
        }
        sb.append(this.tryBlock.toSource(i).trim());
        for (CatchClause catchClause : getCatchClauses()) {
            sb.append(catchClause.toSource(i));
        }
        if (this.finallyBlock != null) {
            sb.append(" finally ");
            sb.append(this.finallyBlock.toSource(i));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.tryBlock.visit(nodeVisitor);
            for (CatchClause catchClause : getCatchClauses()) {
                catchClause.visit(nodeVisitor);
            }
            AstNode astNode = this.finallyBlock;
            if (astNode == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }
}
