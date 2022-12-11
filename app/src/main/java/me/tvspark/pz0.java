package me.tvspark;

import org.antlr.p055v4.runtime.atn.LexerActionType;

/* loaded from: classes4.dex */
public final class pz0 implements hz0 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public pz0(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.hz0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zx0 zx0Var) {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        zx0Var.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zx0Var.Wwwwwwwwwwwwwwwwwwww);
        zx0Var.Wwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.hz0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof pz0) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((pz0) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        LexerActionType lexerActionType = LexerActionType.PUSH_MODE;
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 5), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 2);
    }

    public String toString() {
        return String.format("pushMode(%d)", Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
