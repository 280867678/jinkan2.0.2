package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlDotQuery extends InfixExpression {

    /* renamed from: rp */
    public int f4722rp = -1;

    public XmlDotQuery() {
        this.type = 147;
    }

    public XmlDotQuery(int i) {
        super(i);
        this.type = 147;
    }

    public XmlDotQuery(int i, int i2) {
        super(i, i2);
        this.type = 147;
    }

    public int getRp() {
        return this.f4722rp;
    }

    public void setRp(int i) {
        this.f4722rp = i;
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + ".(" + getRight().toSource(0) + ")";
    }
}
