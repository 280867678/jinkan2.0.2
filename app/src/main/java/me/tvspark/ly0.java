package me.tvspark;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import org.antlr.p055v4.runtime.atn.ATNType;

/* loaded from: classes4.dex */
public class ly0 {
    public hz0[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ATNType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public e01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public d01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<sy0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final List<bz0> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final List<m01> Wwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    public ly0(ATNType aTNType, int i) {
        new LinkedHashMap();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = aTNType;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0 sy0Var) {
        a11 a11Var = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (a11Var != null) {
            return a11Var;
        }
        a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var, (dy0) null);
        sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        return sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, dy0 dy0Var) {
        if (i < 0 || i >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size()) {
            throw new IllegalArgumentException("Invalid state number.");
        }
        a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i));
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2)) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        a11 a11Var = new a11(new int[0]);
        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
        while (dy0Var != null && dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((f01) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
            dy0Var = dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2)) {
            a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
        }
        return a11Var;
    }

    public a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0 sy0Var, dy0 dy0Var) {
        ez0 ez0Var = new ez0(this);
        a11 a11Var = new a11(new int[0]);
        ez0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var, null, dy0Var != null ? a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, dy0Var) : null, a11Var, new HashSet(), new BitSet(), true, true);
        return a11Var;
    }

    public bz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        }
        return null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0 sy0Var) {
        if (sy0Var != null) {
            sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this;
            sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(sy0Var);
    }
}
