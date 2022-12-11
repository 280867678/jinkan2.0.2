package me.tvspark;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class dy0 implements i11 {
    public static final by0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new by0();
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public dy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public dy0() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    public dy0(dy0 dy0Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dy0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return -1;
    }

    @Override // me.tvspark.f11
    public <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h11<? extends T> h11Var) {
        return h11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
    }

    @Override // me.tvspark.f11
    public f11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        throw null;
    }

    @Override // me.tvspark.f11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dy0 dy0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dy0Var;
    }

    @Override // me.tvspark.j11
    public int getChildCount() {
        throw null;
    }

    @Override // me.tvspark.f11
    public String getText() {
        if (getChildCount() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getChildCount(); i++) {
            sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).getText());
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[");
        for (dy0 dy0Var = this; dy0Var != null; dy0Var = dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (!dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            dy0 dy0Var2 = dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (dy0Var2 != null && !dy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(StringUtils.SPACE);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("]");
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
