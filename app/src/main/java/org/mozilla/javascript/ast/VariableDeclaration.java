package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class VariableDeclaration extends AstNode {
    public boolean isStatement;
    public List<VariableInitializer> variables = new ArrayList();

    public VariableDeclaration() {
        this.type = 123;
    }

    public VariableDeclaration(int i) {
        super(i);
        this.type = 123;
    }

    public VariableDeclaration(int i, int i2) {
        super(i, i2);
        this.type = 123;
    }

    private String declTypeName() {
        return Token.typeToName(this.type).toLowerCase();
    }

    public void addVariable(VariableInitializer variableInitializer) {
        assertNotNull(variableInitializer);
        this.variables.add(variableInitializer);
        variableInitializer.setParent(this);
    }

    public List<VariableInitializer> getVariables() {
        return this.variables;
    }

    public boolean isConst() {
        return this.type == 155;
    }

    public boolean isLet() {
        return this.type == 154;
    }

    public boolean isStatement() {
        return this.isStatement;
    }

    public boolean isVar() {
        return this.type == 123;
    }

    public void setIsStatement(boolean z) {
        this.isStatement = z;
    }

    @Override // org.mozilla.javascript.Node
    /* renamed from: setType */
    public Node mo5274setType(int i) {
        if (i == 123 || i == 155 || i == 154) {
            return super.mo5274setType(i);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("invalid decl type: ", i));
    }

    public void setVariables(List<VariableInitializer> list) {
        assertNotNull(list);
        this.variables.clear();
        for (VariableInitializer variableInitializer : list) {
            addVariable(variableInitializer);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (isStatement() != false) goto L7;
     */
    @Override // org.mozilla.javascript.ast.AstNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(declTypeName());
        sb.append(StringUtils.SPACE);
        printList(this.variables, sb);
        if (isStatement()) {
            sb.append(";");
        }
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i));
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            for (VariableInitializer variableInitializer : this.variables) {
                variableInitializer.visit(nodeVisitor);
            }
        }
    }
}
