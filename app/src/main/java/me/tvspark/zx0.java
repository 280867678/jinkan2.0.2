package me.tvspark;

import org.antlr.p055v4.runtime.LexerNoViableAltException;
import org.antlr.p055v4.runtime.Recognizer;
import org.antlr.p055v4.runtime.misc.Pair;

/* loaded from: classes4.dex */
public abstract class zx0 extends Recognizer<Integer, gz0> implements gy0 {
    public String Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Pair<gy0, sx0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public sx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public fy0<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ux0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public final y01 Wwwwwwwwwwwwwwwwwwwww = new y01();
    public int Wwwwwwwwwwwwwwwwwwww = 0;

    public zx0(sx0 sx0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Pair<>(this, sx0Var);
    }

    @Override // me.tvspark.gy0
    public fy0<? extends ey0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LexerNoViableAltException lexerNoViableAltException) {
        char[] charArray;
        sx0 sx0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()));
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("token recognition error at: '");
        StringBuilder sb = new StringBuilder();
        for (char c : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toCharArray()) {
            String valueOf = String.valueOf(c);
            if (c == 65535) {
                valueOf = "<EOF>";
            } else if (c == '\r') {
                valueOf = "\\r";
            } else if (c == '\t') {
                valueOf = "\\t";
            } else if (c == '\n') {
                valueOf = "\\n";
            }
            sb.append(valueOf);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(sb.toString());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("'");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, (Object) null, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), lexerNoViableAltException);
    }

    @Override // me.tvspark.gy0
    public int getCharPositionInLine() {
        return ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.gy0
    public sx0 getInputStream() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.gy0
    public int getLine() {
        return ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.gy0
    public ey0 nextToken() {
        ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        sx0 sx0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (sx0Var != null) {
            int mark = sx0Var.mark();
            while (true) {
                try {
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                        ATNInterpreter atninterpreter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i2 = ((gz0) atninterpreter).Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        int i3 = ((gz0) atninterpreter).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((ux0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, -1, null, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1, i3, i2);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        break;
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                    this.Wwwwwwwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwww = ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwww = null;
                    while (true) {
                        this.Wwwwwwwwwwwwwwwwwwwwww = 0;
                        try {
                            i = ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww);
                        } catch (LexerNoViableAltException e) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e);
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) != -1) {
                                ((gz0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            i = -3;
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) == -1) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwww == 0) {
                            this.Wwwwwwwwwwwwwwwwwwwwww = i;
                        }
                        if (this.Wwwwwwwwwwwwwwwwwwwwww == -3) {
                            break;
                        } else if (this.Wwwwwwwwwwwwwwwwwwwwww != -2) {
                            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = ((ux0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1, this.Wwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                    }
                } finally {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mark);
                }
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new IllegalStateException("nextToken requires a non-null input stream.");
    }
}
