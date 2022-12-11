package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class LabeledStatement extends AstNode {
    public List<Label> labels = new ArrayList();
    public AstNode statement;

    public LabeledStatement() {
        this.type = Token.EXPR_VOID;
    }

    public LabeledStatement(int i) {
        super(i);
        this.type = Token.EXPR_VOID;
    }

    public LabeledStatement(int i, int i2) {
        super(i, i2);
        this.type = Token.EXPR_VOID;
    }

    public void addLabel(Label label) {
        assertNotNull(label);
        this.labels.add(label);
        label.setParent(this);
    }

    public Label getFirstLabel() {
        return this.labels.get(0);
    }

    public Label getLabelByName(String str) {
        for (Label label : this.labels) {
            if (str.equals(label.getName())) {
                return label;
            }
        }
        return null;
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public AstNode getStatement() {
        return this.statement;
    }

    @Override // org.mozilla.javascript.ast.AstNode, org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        return true;
    }

    public void setLabels(List<Label> list) {
        assertNotNull(list);
        List<Label> list2 = this.labels;
        if (list2 != null) {
            list2.clear();
        }
        for (Label label : list) {
            addLabel(label);
        }
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        for (Label label : this.labels) {
            sb.append(label.toSource(i));
        }
        sb.append(this.statement.toSource(i + 1));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            for (Label label : this.labels) {
                label.visit(nodeVisitor);
            }
            this.statement.visit(nodeVisitor);
        }
    }
}
