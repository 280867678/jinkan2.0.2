package me.tvspark;

import java.util.BitSet;
import java.util.Set;
import org.antlr.p055v4.runtime.atn.Transition;

/* loaded from: classes4.dex */
public class ez0 {
    public final ly0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ez0(ly0 ly0Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ly0Var;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0 sy0Var, sy0 sy0Var2, a01 a01Var, a11 a11Var, Set<my0> set, BitSet bitSet, boolean z, boolean z2) {
        int i;
        int i2;
        f01 f01Var;
        if (!set.add(new my0(sy0Var, 0, a01Var))) {
            return;
        }
        if (sy0Var == sy0Var2) {
            if (a01Var == null) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
                return;
            } else if (a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && z2) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
                return;
            }
        }
        if (sy0Var instanceof e01) {
            if (a01Var == null) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
                return;
            } else if (a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && z2) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
                return;
            } else if (a01Var != a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                boolean z3 = bitSet.get(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                try {
                    bitSet.clear(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    for (int i3 = 0; i3 < a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i3++) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3)), sy0Var2, a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3), a11Var, set, bitSet, z, z2);
                    }
                    if (!z3) {
                        return;
                    }
                    return;
                } finally {
                    if (z3) {
                        bitSet.set(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            }
        }
        int i4 = 0;
        for (int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i4 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2) {
            Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getClass() == f01.class) {
                f01 f01Var2 = (f01) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                if (bitSet.get(f01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    i = i4;
                    i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    i01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01Var, f01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    try {
                        bitSet.set(((f01) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        f01Var = f01Var2;
                        i = i4;
                        i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } catch (Throwable th) {
                        th = th;
                        f01Var = f01Var2;
                    }
                    try {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sy0Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, a11Var, set, bitSet, z, z2);
                        bitSet.clear(f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } catch (Throwable th2) {
                        th = th2;
                        bitSet.clear(f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        throw th;
                    }
                }
            } else {
                i = i4;
                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof ty0) {
                    if (!z) {
                        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sy0Var2, a01Var, a11Var, set, bitSet, z, z2);
                } else {
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getClass() == n01.class) {
                            a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        } else {
                            a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 instanceof tz0) {
                                    a11 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                                    } else {
                                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new a11(new int[0]);
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        } else {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        }
                                        a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                        i4 = i + 1;
                                    }
                                }
                                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                i4 = i + 1;
                            }
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sy0Var2, a01Var, a11Var, set, bitSet, z, z2);
                }
            }
            i4 = i + 1;
        }
    }
}
