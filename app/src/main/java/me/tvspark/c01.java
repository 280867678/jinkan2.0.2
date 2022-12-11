package me.tvspark;

import org.antlr.p055v4.runtime.atn.Transition;

/* loaded from: classes4.dex */
public final class c01 extends Transition {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public c01(sy0 sy0Var, int i, int i2) {
        super(sy0Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return a11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 2;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i <= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public String toString() {
        StringBuilder appendCodePoint = new StringBuilder("'").appendCodePoint(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        appendCodePoint.append("'..'");
        StringBuilder appendCodePoint2 = appendCodePoint.appendCodePoint(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        appendCodePoint2.append("'");
        return appendCodePoint2.toString();
    }
}
