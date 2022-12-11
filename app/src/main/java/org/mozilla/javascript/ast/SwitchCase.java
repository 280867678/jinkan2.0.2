package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class SwitchCase extends AstNode {
    public AstNode expression;
    public List<AstNode> statements;

    public SwitchCase() {
        this.type = 116;
    }

    public SwitchCase(int i) {
        super(i);
        this.type = 116;
    }

    public SwitchCase(int i, int i2) {
        super(i, i2);
        this.type = 116;
    }

    public void addStatement(AstNode astNode) {
        assertNotNull(astNode);
        if (this.statements == null) {
            this.statements = new ArrayList();
        }
        setLength((astNode.getLength() + astNode.getPosition()) - getPosition());
        this.statements.add(astNode);
        astNode.setParent(this);
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public List<AstNode> getStatements() {
        return this.statements;
    }

    public boolean isDefault() {
        return this.expression == null;
    }

    public void setExpression(AstNode astNode) {
        this.expression = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setStatements(List<AstNode> list) {
        List<AstNode> list2 = this.statements;
        if (list2 != null) {
            list2.clear();
        }
        for (AstNode astNode : list) {
            addStatement(astNode);
        }
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (this.expression == null) {
            sb.append("default:\n");
        } else {
            sb.append("case ");
            sb.append(this.expression.toSource(0));
            sb.append(":");
            if (getInlineComment() != null) {
                sb.append(getInlineComment().toSource(i + 1));
            }
            sb.append("\n");
        }
        List<AstNode> list = this.statements;
        if (list != null) {
            for (AstNode astNode : list) {
                sb.append(astNode.toSource(i + 1));
                if (astNode.getType() == 162 && ((Comment) astNode).getCommentType() == Token.CommentType.LINE) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            AstNode astNode = this.expression;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
            List<AstNode> list = this.statements;
            if (list == null) {
                return;
            }
            for (AstNode astNode2 : list) {
                astNode2.visit(nodeVisitor);
            }
        }
    }
}
