package me.tvspark;

import org.antlr.p055v4.runtime.atn.LexerActionType;

/* loaded from: classes4.dex */
public final class jz0 implements hz0 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public jz0(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    @Override // me.tvspark.hz0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zx0 zx0Var) {
        zx0Var.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.hz0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof jz0) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == ((jz0) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        LexerActionType lexerActionType = LexerActionType.CHANNEL;
        return r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, 0), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 2);
    }

    public String toString() {
        return String.format("channel(%d)", Integer.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
