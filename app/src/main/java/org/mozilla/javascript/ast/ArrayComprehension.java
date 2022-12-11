package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ArrayComprehension extends Scope {
    public AstNode filter;
    public AstNode result;
    public List<ArrayComprehensionLoop> loops = new ArrayList();
    public int ifPosition = -1;

    /* renamed from: lp */
    public int f4700lp = -1;

    /* renamed from: rp */
    public int f4701rp = -1;

    public ArrayComprehension() {
        this.type = 158;
    }

    public ArrayComprehension(int i) {
        super(i);
        this.type = 158;
    }

    public ArrayComprehension(int i, int i2) {
        super(i, i2);
        this.type = 158;
    }

    public void addLoop(ArrayComprehensionLoop arrayComprehensionLoop) {
        assertNotNull(arrayComprehensionLoop);
        this.loops.add(arrayComprehensionLoop);
        arrayComprehensionLoop.setParent(this);
    }

    public AstNode getFilter() {
        return this.filter;
    }

    public int getFilterLp() {
        return this.f4700lp;
    }

    public int getFilterRp() {
        return this.f4701rp;
    }

    public int getIfPosition() {
        return this.ifPosition;
    }

    public List<ArrayComprehensionLoop> getLoops() {
        return this.loops;
    }

    public AstNode getResult() {
        return this.result;
    }

    public void setFilter(AstNode astNode) {
        this.filter = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setFilterLp(int i) {
        this.f4700lp = i;
    }

    public void setFilterRp(int i) {
        this.f4701rp = i;
    }

    public void setIfPosition(int i) {
        this.ifPosition = i;
    }

    public void setLoops(List<ArrayComprehensionLoop> list) {
        assertNotNull(list);
        this.loops.clear();
        for (ArrayComprehensionLoop arrayComprehensionLoop : list) {
            addLoop(arrayComprehensionLoop);
        }
    }

    public void setResult(AstNode astNode) {
        assertNotNull(astNode);
        this.result = astNode;
        astNode.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append("[");
        sb.append(this.result.toSource(0));
        for (ArrayComprehensionLoop arrayComprehensionLoop : this.loops) {
            sb.append(arrayComprehensionLoop.toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (!nodeVisitor.visit(this)) {
            return;
        }
        this.result.visit(nodeVisitor);
        for (ArrayComprehensionLoop arrayComprehensionLoop : this.loops) {
            arrayComprehensionLoop.visit(nodeVisitor);
        }
        AstNode astNode = this.filter;
        if (astNode == null) {
            return;
        }
        astNode.visit(nodeVisitor);
    }
}
