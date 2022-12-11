package me.tvspark;

import org.antlr.p055v4.runtime.atn.Transition;

/* loaded from: classes4.dex */
public final class uy0 extends Transition {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public uy0(sy0 sy0Var, int i, int i2, boolean z) {
        super(sy0Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return true;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 6;
    }

    @Override // org.antlr.p055v4.runtime.atn.Transition
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return false;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("action_");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(":");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
