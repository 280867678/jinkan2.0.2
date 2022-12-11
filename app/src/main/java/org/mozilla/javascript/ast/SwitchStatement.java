package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.outline;

/* loaded from: classes5.dex */
public class SwitchStatement extends Jump {
    public static final List<SwitchCase> NO_CASES = Collections.unmodifiableList(new ArrayList());
    public List<SwitchCase> cases;
    public AstNode expression;

    /* renamed from: lp */
    public int f4718lp = -1;

    /* renamed from: rp */
    public int f4719rp = -1;

    public SwitchStatement() {
        this.type = 115;
    }

    public SwitchStatement(int i) {
        this.type = 115;
        this.position = i;
    }

    public SwitchStatement(int i, int i2) {
        this.type = 115;
        this.position = i;
        this.length = i2;
    }

    public void addCase(SwitchCase switchCase) {
        assertNotNull(switchCase);
        if (this.cases == null) {
            this.cases = new ArrayList();
        }
        this.cases.add(switchCase);
        switchCase.setParent(this);
    }

    public List<SwitchCase> getCases() {
        List<SwitchCase> list = this.cases;
        return list != null ? list : NO_CASES;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public int getLp() {
        return this.f4718lp;
    }

    public int getRp() {
        return this.f4719rp;
    }

    public void setCases(List<SwitchCase> list) {
        if (list == null) {
            this.cases = null;
            return;
        }
        List<SwitchCase> list2 = this.cases;
        if (list2 != null) {
            list2.clear();
        }
        for (SwitchCase switchCase : list) {
            addCase(switchCase);
        }
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setLp(int i) {
        this.f4718lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4718lp = i;
        this.f4719rp = i2;
    }

    public void setRp(int i) {
        this.f4719rp = i;
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String makeIndent = makeIndent(i);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(makeIndent, "switch (");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.expression.toSource(0));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(") {\n");
        List<SwitchCase> list = this.cases;
        if (list != null) {
            for (SwitchCase switchCase : list) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(switchCase.toSource(i + 1));
            }
        }
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, makeIndent, "}\n");
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            for (SwitchCase switchCase : getCases()) {
                switchCase.visit(nodeVisitor);
            }
        }
    }
}
