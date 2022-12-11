package me.tvspark;

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.antlr.p055v4.runtime.RecognitionException;
import org.antlr.p055v4.runtime.Recognizer;

/* loaded from: classes4.dex */
public abstract class ay0 extends Recognizer<ey0, vz0> {
    public List<g11> Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final y01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public hy0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public xx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new xx0();
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    public by0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public int Wwwwwwwwwwwwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww = false;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwww = null;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements g11 {
    }

    static {
        new WeakHashMap();
    }

    public ay0(hy0 hy0Var) {
        y01 y01Var = new y01();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = y01Var;
        y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        xx0 xx0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        y01 y01Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Arrays.fill(y01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, y01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0);
        y01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        ATNInterpreter atninterpreter = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (atninterpreter != 0) {
            atninterpreter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hy0Var;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return -1;
        }
        y01 y01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i - 1;
        if (i2 >= 0 && i2 < i) {
            return y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
        }
        throw new IndexOutOfBoundsException();
    }

    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        by0 by0Var;
        ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Wwwwwwwwwwwwwwwwwwwwwww) {
            by0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        } else {
            by0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
        }
        by0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        List<g11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                g11 g11Var = this.Wwwwwwwwwwwwwwwwwwwwwwwww.get(size);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g11Var);
                g11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        by0 by0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = by0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = (by0) by0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getType() != -1) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        List<g11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z = list != null && !list.isEmpty();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww || z) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                by0 by0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                e11 e11Var = new e11(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (by0Var != null) {
                    e11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0Var);
                    by0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((by0) e11Var);
                    List<g11> list2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (list2 != null) {
                        for (g11 g11Var : list2) {
                            g11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((d11) e11Var);
                        }
                    }
                } else {
                    throw null;
                }
            } else {
                by0 by0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                l11 l11Var = new l11(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (by0Var2 != null) {
                    l11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0Var2);
                    by0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((by0) l11Var);
                    List<g11> list3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                    if (list3 != null) {
                        for (g11 g11Var2 : list3) {
                            g11Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(l11Var);
                        }
                    }
                } else {
                    throw null;
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0 by0Var, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = by0Var;
        by0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            by0 by0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            by0 by0Var3 = (by0) by0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (by0Var3 != null) {
                by0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0Var2);
            }
        }
        List<g11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (list != null) {
            for (g11 g11Var : list) {
                g11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g11Var);
            }
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0 by0Var, int i) {
        by0 by0Var2;
        by0 by0Var3;
        if (by0Var != null) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww && (by0Var2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) != by0Var && (by0Var3 = (by0) by0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
                List<f11> list = by0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (list != null) {
                    list.remove(list.size() - 1);
                }
                by0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0Var);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = by0Var;
            return;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ey0 ey0Var, String str, RecognitionException recognitionException) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww++;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, ey0Var, ey0Var.getLine(), ey0Var.getCharPositionInLine(), str, recognitionException);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g11 g11Var) {
        List<g11> list = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (list == null || !list.remove(g11Var) || !this.Wwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) throws RecognitionException {
        ey0 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getType() == i) {
            if (i == -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwww = true;
            }
            xx0 xx0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
            xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            xx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww && Wwwwwwwwwwwwwwwwwwwwwwwwwwww.getTokenIndex() == -1) {
                by0 by0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                e11 e11Var = new e11(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (by0Var == null) {
                    throw null;
                }
                e11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(by0Var);
                by0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((by0) e11Var);
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.antlr.p055v4.runtime.Recognizer
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dy0 dy0Var, int i) {
        y01 y01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i3 = i2 - 1;
        if (i3 < 0 || i3 >= i2) {
            throw new IndexOutOfBoundsException();
        }
        return i >= y01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
    }
}
