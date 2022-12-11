package me.tvspark;

import org.antlr.p055v4.runtime.atn.Transition;

/* loaded from: classes4.dex */
public final class wy0 extends Transition {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public wy0(sy0 sy0Var, int i) {
        super(sy0Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        a11 a11Var = new a11(new int[0]);
        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        return a11Var;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 5;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i;
    }

    public String toString() {
        return String.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
