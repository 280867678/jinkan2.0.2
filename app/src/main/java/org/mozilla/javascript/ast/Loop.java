package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public abstract class Loop extends Scope {
    public AstNode body;

    /* renamed from: lp */
    public int f4716lp = -1;

    /* renamed from: rp */
    public int f4717rp = -1;

    public Loop() {
    }

    public Loop(int i) {
        super(i);
    }

    public Loop(int i, int i2) {
        super(i, i2);
    }

    public AstNode getBody() {
        return this.body;
    }

    public int getLp() {
        return this.f4716lp;
    }

    public int getRp() {
        return this.f4717rp;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        setLength((astNode.getLength() + astNode.getPosition()) - getPosition());
        astNode.setParent(this);
    }

    public void setLp(int i) {
        this.f4716lp = i;
    }

    public void setParens(int i, int i2) {
        this.f4716lp = i;
        this.f4717rp = i2;
    }

    public void setRp(int i) {
        this.f4717rp = i;
    }
}
