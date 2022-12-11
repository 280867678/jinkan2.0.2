package me.tvspark;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.tvspark.g01;
import me.tvspark.r01;
import org.antlr.p055v4.runtime.NoViableAltException;
import org.antlr.p055v4.runtime.atn.PredictionMode;
import org.antlr.p055v4.runtime.atn.Transition;
import org.antlr.p055v4.runtime.misc.Pair;

/* loaded from: classes4.dex */
public class vz0 extends ry0 {
    public static final boolean Wwwwwwwwwwwwwwwwwwwwwww = Boolean.parseBoolean(System.getenv("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT"));
    public p01 Wwwwwwwwwwwwwwwwwwwwwwww;
    public by0 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public hy0 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public u01<a01, a01, a01> Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public PredictionMode Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = PredictionMode.LL;
    public final p01[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final ay0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public vz0(ay0 ay0Var, ly0 ly0Var, p01[] p01VarArr, b01 b01Var) {
        super(ly0Var, b01Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ay0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p01VarArr;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var) {
        Iterator<my0> it = ny0Var.iterator();
        int i = 0;
        while (it.hasNext()) {
            my0 next = it.next();
            if (i == 0) {
                i = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != i) {
                return 0;
            }
        }
        return i;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var) {
        a11 a11Var = new a11(new int[0]);
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            my0 next = it.next();
            if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0 || ((next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01) && next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
                a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
            return 0;
        }
        return a11Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:80:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var, ny0 ny0Var, Set<my0> set, boolean z, boolean z2, int i, boolean z3) {
        my0 my0Var2;
        my0 my0Var3;
        int i2;
        int i3;
        boolean z4;
        boolean z5;
        sy0 sy0Var = my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        for (int i4 = 0; i4 < sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i4++) {
            if (i4 == 0) {
                if (!Wwwwwwwwwwwwwwwwwwwwwww) {
                    sy0 sy0Var2 = my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 10 && ((k01) sy0Var2).Wwwwwwwwwwwwwwwwwwwwwwwww && !my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                zy0 zy0Var = (zy0) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(((az0) sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                for (int i6 = 0; i6 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i6++) {
                                    sy0 sy0Var3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i6));
                                    if (sy0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1 && sy0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                        sy0 sy0Var4 = sy0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        if ((sy0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 8 && sy0Var4 == sy0Var2) || sy0Var3 == zy0Var || sy0Var4 == zy0Var || (sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 8 && sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1 && sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && sy0Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == sy0Var2)) {
                                        }
                                    }
                                }
                                z5 = true;
                            } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                i5++;
                            }
                        }
                    }
                }
                z5 = false;
                if (z5) {
                }
            }
            Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            boolean z6 = !(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof uy0) && z;
            boolean z7 = i == 0;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 10) {
                switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    case 1:
                        my0Var2 = new my0(my0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        break;
                    case 2:
                    case 5:
                    case 7:
                        if (z3 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, 0, 1)) {
                            my0Var2 = new my0(my0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            break;
                        }
                        my0Var2 = null;
                        break;
                    case 3:
                        f01 f01Var = (f01) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        my0Var3 = new my0(my0Var, f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        my0Var2 = my0Var3;
                        break;
                    case 4:
                        zz0 zz0Var = (zz0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (!z6 || ((z4 = zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (!z4 || !z7))) {
                            my0Var2 = new my0(my0Var, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            break;
                        } else if (z2) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                            new g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                            my0Var2 = new my0(my0Var, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            break;
                        } else {
                            my0Var3 = new my0(my0Var, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, zz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
                            my0Var2 = my0Var3;
                            break;
                        }
                        break;
                    case 6:
                        my0Var2 = new my0(my0Var, ((uy0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        break;
                    default:
                        my0Var2 = null;
                        break;
                }
                if (my0Var2 != null && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || set.add(my0Var2))) {
                    if (!(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01)) {
                        if (set.add(my0Var2)) {
                            p01 p01Var = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                            if (p01Var != null && p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww && ((dz0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                                my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 1073741824;
                            }
                            my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                            ny0Var.Wwwwwwwwwwwwwwwwww = true;
                            i3 = i - 1;
                        }
                    } else if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof f01) || i < 0) {
                        i2 = i;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var2, ny0Var, set, z6, z2, i2, z3);
                    } else {
                        i3 = i + 1;
                    }
                    i2 = i3;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var2, ny0Var, set, z6, z2, i2, z3);
                }
            } else {
                yz0 yz0Var = (yz0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (!z6 || !z7) {
                    my0Var2 = new my0(my0Var, yz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (z2) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = new g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5) {
                        my0Var2 = new my0(my0Var, yz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    my0Var2 = null;
                } else {
                    my0Var3 = new my0(my0Var, yz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, new g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(yz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
                    my0Var2 = my0Var3;
                }
                if (my0Var2 != null) {
                    if (!(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01)) {
                    }
                    i2 = i3;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var2, ny0Var, set, z6, z2, i2, z3);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [me.tvspark.p01, me.tvspark.u01<me.tvspark.a01, me.tvspark.a01, me.tvspark.a01>] */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hy0 hy0Var, int i, by0 by0Var) {
        r01 r01Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = hy0Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = by0Var;
        p01 p01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
        this.Wwwwwwwwwwwwwwwwwwwwwwww = p01Var;
        int mark = hy0Var.mark();
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            if (p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (!p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
                }
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwww >= 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwww < p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                    r01Var = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[Wwwwwwwwwwwwwwwwwwwwwwwwwww];
                }
                r01Var = null;
            } else {
                r01Var = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (r01Var == null) {
                if (by0Var == null) {
                    by0Var = dy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((sy0) p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (dy0) dy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
                if (p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    r01Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, new r01(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
                    p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww(), r01Var);
                } else {
                    r01Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, new r01(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                    p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var;
                }
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, r01Var, hy0Var, i2, by0Var);
        } finally {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwww = null;
            hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mark);
        }
    }

    public r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01 p01Var, r01 r01Var, int i, r01 r01Var2) {
        if (r01Var2 == null) {
            return null;
        }
        r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, r01Var2);
        if (r01Var == null || i < -1 || i > this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        synchronized (r01Var) {
            if (r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new r01[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1 + 1];
            }
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i + 1] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public NoViableAltException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hy0 hy0Var, by0 by0Var, ny0 ny0Var, int i) {
        return new NoViableAltException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, hy0Var, hy0Var.get(i), hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1), ny0Var, by0Var);
    }

    @Override // me.tvspark.ry0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01 p01Var, int i, int i2, boolean z, BitSet bitSet, ny0 ny0Var) {
        ay0 ay0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ay0Var != null) {
            ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, p01Var, i, i2, z, bitSet, ny0Var);
        }
    }

    public r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01 p01Var, r01 r01Var) {
        if (r01Var == ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return r01Var;
        }
        synchronized (p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            r01 r01Var2 = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(r01Var);
            if (r01Var2 != null) {
                return r01Var2;
            }
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            if (!r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww) {
                r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
                ny0 ny0Var = r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                ny0Var.Wwwwwwwwwwwwwwwwwwwwwwww = true;
                ny0Var.Wwwwwwwwwwwwwwwwwwwwwww = null;
            }
            p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(r01Var, r01Var);
            return r01Var;
        }
    }

    public ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var) {
        a01 a01Var;
        g01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        HashMap hashMap = new HashMap();
        ny0 ny0Var2 = new ny0(ny0Var.Wwwwwwwwwwwwwwwww);
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            my0 next = it.next();
            if (next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwww)) != null) {
                hashMap.put(Integer.valueOf(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(next, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else {
                    ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
        Iterator<my0> it2 = ny0Var.iterator();
        while (it2.hasNext()) {
            my0 next2 = it2.next();
            if (next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 1 && (next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || (a01Var = (a01) hashMap.get(Integer.valueOf(next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) == null || !a01Var.equals(next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        return ny0Var2;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0 my0Var, ny0 ny0Var, Set<my0> set, boolean z, boolean z2, int i, boolean z3) {
        if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01) {
            if (!my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                for (int i2 = 0; i2 < my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i2++) {
                    if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2) != Integer.MAX_VALUE) {
                        my0 my0Var2 = new my0(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)), my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2), my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        my0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var2, ny0Var, set, z, z2, i - 1, z3);
                    } else if (z2) {
                        ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(my0Var, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, ny0Var, set, z, z2, i, z3);
                    }
                }
                return;
            } else if (z2) {
                ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, ny0Var, set, z, z2, i, z3);
    }

    public ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var, int i, boolean z) {
        boolean z2;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new u01<>();
        }
        ny0 ny0Var2 = new ny0(z);
        Iterator<my0> it = ny0Var.iterator();
        ArrayList<my0> arrayList = null;
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            my0 next = it.next();
            sy0 sy0Var = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (!(sy0Var instanceof e01)) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                for (int i2 = 0; i2 < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i2++) {
                    Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    sy0 sy0Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
                    if (sy0Var2 != null) {
                        ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(next, sy0Var2, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
            } else if (z || i == -1) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
        }
        ny0 ny0Var3 = (arrayList != null || i == -1 || (ny0Var2.size() != 1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0Var2) == 0)) ? null : ny0Var2;
        if (ny0Var3 == null) {
            ny0 ny0Var4 = new ny0(z);
            HashSet hashSet = new HashSet();
            boolean z3 = i == -1;
            Iterator<my0> it2 = ny0Var2.iterator();
            while (it2.hasNext()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(it2.next(), ny0Var4, hashSet, false, z, 0, z3);
                ny0Var4 = ny0Var4;
            }
            ny0Var3 = ny0Var4;
        }
        if (i == -1) {
            if (ny0Var3 == ny0Var2) {
                z2 = true;
            }
            if (!PredictionMode.allConfigsInRuleStopStates(ny0Var3)) {
                ny0 ny0Var5 = new ny0(ny0Var3.Wwwwwwwwwwwwwwwww);
                Iterator<my0> it3 = ny0Var3.iterator();
                while (it3.hasNext()) {
                    my0 next2 = it3.next();
                    sy0 sy0Var3 = next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (sy0Var3 instanceof e01) {
                        ny0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } else if (z2 && sy0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0Var3).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2)) {
                        ny0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(next2, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[next2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww]), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                }
                ny0Var3 = ny0Var5;
            }
        }
        if (arrayList != null && (!z || !PredictionMode.hasConfigInRuleStopState(ny0Var3))) {
            for (my0 my0Var : arrayList) {
                ny0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(my0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
        }
        if (ny0Var3.isEmpty()) {
            return null;
        }
        return ny0Var3;
    }

    public ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sy0 sy0Var, dy0 dy0Var, boolean z) {
        a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, dy0Var);
        ny0 ny0Var = new ny0(z);
        int i = 0;
        while (i < sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int i2 = i + 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new my0(sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), ny0Var, new HashSet(), true, z, 0, false);
            i = i2;
        }
        return ny0Var;
    }

    public BitSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr, by0 by0Var, boolean z) {
        BitSet bitSet = new BitSet();
        for (r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr) {
            g01 g01Var = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (g01Var == g01.Wwwwwwwwwwwwwwwwwwwwwwww) {
                bitSet.set(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (!z) {
                    break;
                }
            } else {
                if (g01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var)) {
                    bitSet.set(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (!z) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return bitSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01ca, code lost:
        r11 = r2;
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e1, code lost:
        if (r6.Wwwwwwwwwwwwwwwwwwwww == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01e3, code lost:
        r4 = r19.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r0 = r16.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01e9, code lost:
        if (r0 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01eb, code lost:
        r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r16.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r17, r20, r4, r11, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0226, code lost:
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01fb, code lost:
        r3 = r19.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        r5 = new java.util.BitSet();
        r0 = r6.Wwwwwwwwwwwwwwwwwwwwww.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x020e, code lost:
        if (r0.hasNext() == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0210, code lost:
        r5.set(r0.next().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x021c, code lost:
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r17, r20, r3, r4, r5, r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01 p01Var, r01 r01Var, hy0 hy0Var, int i, by0 by0Var) {
        boolean z;
        BitSet bitSet;
        BitSet bitSet2;
        int i2;
        boolean z2 = true;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        r01 r01Var2 = r01Var;
        while (true) {
            r01[] r01VarArr = r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r01 r01Var3 = (r01VarArr == null || (i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1) < 0 || i2 >= r01VarArr.length) ? null : r01VarArr[i2];
            if (r01Var3 == null) {
                ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, r01Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    r01Var3 = ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    r01 r01Var4 = new r01(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 0) {
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    } else if (PredictionMode.hasSLLConflictTerminatingPrediction(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww = PredictionMode.getAlts(PredictionMode.getConflictingAltSubsets(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
                        r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww.nextSetBit(0);
                    }
                    if (r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        ny0 ny0Var = r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (ny0Var.Wwwwwwwwwwwwwwwwwwwww != 0) {
                            bitSet2 = new BitSet();
                            bitSet2.set(ny0Var.Wwwwwwwwwwwwwwwwwwwww);
                        } else {
                            bitSet2 = ny0Var.Wwwwwwwwwwwwwwwwwwww;
                        }
                        g01[] g01VarArr = new g01[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 + 1];
                        Iterator<my0> it = r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                        while (it.hasNext()) {
                            my0 next = it.next();
                            if (bitSet2.get(next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                int i3 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                g01VarArr[i3] = g01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01VarArr[i3], next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            }
                        }
                        int i4 = 0;
                        for (int i5 = 1; i5 <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2; i5++) {
                            if (g01VarArr[i5] == null) {
                                g01VarArr[i5] = g01.Wwwwwwwwwwwwwwwwwwwwwwww;
                            } else if (g01VarArr[i5] != g01.Wwwwwwwwwwwwwwwwwwwwwwww) {
                                i4++;
                            }
                        }
                        if (i4 == 0) {
                            g01VarArr = null;
                        }
                        if (g01VarArr != null) {
                            ArrayList arrayList = new ArrayList();
                            boolean z3 = false;
                            for (int i6 = 1; i6 < g01VarArr.length; i6++) {
                                g01 g01Var = g01VarArr[i6];
                                if (bitSet2 != null && bitSet2.get(i6)) {
                                    arrayList.add(new r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(g01Var, i6));
                                }
                                if (g01Var != g01.Wwwwwwwwwwwwwwwwwwwwwwww) {
                                    z3 = true;
                                }
                            }
                            r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwww = !z3 ? null : (r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[]) arrayList.toArray(new r01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[arrayList.size()]);
                            r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                        } else {
                            r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bitSet2.nextSetBit(0);
                        }
                        if (r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                            r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                        }
                    }
                    r01Var3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, r01Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, r01Var4);
                }
            }
            if (r01Var3 == ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                NoViableAltException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hy0Var, by0Var, r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
                hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 == 0) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
            } else if (r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != PredictionMode.SLL) {
                BitSet bitSet3 = r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwww;
                if (r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != i) {
                        hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                    }
                    z = true;
                    BitSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var, true);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.cardinality() == 1) {
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6.nextSetBit(0);
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 != i) {
                        hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                    }
                    bitSet = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                } else {
                    z = true;
                    bitSet = bitSet3;
                }
                ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var, z);
                ny0 ny0Var2 = r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8 = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ay0 ay0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (ay0Var != null) {
                    ay0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, p01Var, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww8, bitSet, ny0Var2);
                }
                hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                boolean z4 = true;
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                while (true) {
                    ny0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, z4);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9 == null) {
                        NoViableAltException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hy0Var, by0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, i);
                        hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7, by0Var);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11 == 0) {
                            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww10;
                        }
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww11;
                    }
                    Collection<BitSet> conflictingAltSubsets = PredictionMode.getConflictingAltSubsets(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                        break;
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww != PredictionMode.LL_EXACT_AMBIG_DETECTION) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = PredictionMode.resolvesToJustOneViableAlt(conflictingAltSubsets);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                            break;
                        }
                    } else if (PredictionMode.allSubsetsConflict(conflictingAltSubsets) && PredictionMode.allSubsetsEqual(conflictingAltSubsets)) {
                        int i7 = PredictionMode.getSingleViableAlt(conflictingAltSubsets);
                        boolean z5 = true;
                        break;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1) {
                        hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww9;
                    z4 = true;
                }
            } else if (r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12 = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                BitSet Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var, true);
                int cardinality = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.cardinality();
                if (cardinality == 0) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(hy0Var, by0Var, r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
                }
                if (cardinality == 1) {
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.nextSetBit(0);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(p01Var, i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww12, false, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13, r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww13.nextSetBit(0);
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                    hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = hy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                }
                r01Var2 = r01Var3;
                z2 = true;
            }
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var, by0 by0Var) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ny0 ny0Var2 = new ny0(ny0Var.Wwwwwwwwwwwwwwwww);
        ny0 ny0Var3 = new ny0(ny0Var.Wwwwwwwwwwwwwwwww);
        Iterator<my0> it = ny0Var.iterator();
        while (it.hasNext()) {
            my0 next = it.next();
            g01 g01Var = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (g01Var == g01.Wwwwwwwwwwwwwwwwwwwwwwww || g01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, by0Var)) {
                ny0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, null);
            } else {
                ny0Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(next, null);
            }
        }
        Pair pair = new Pair(ny0Var2, ny0Var3);
        ny0 ny0Var4 = (ny0) pair.f4544b;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((ny0) pair.f4543a);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        if (ny0Var4.size() > 0 && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0Var4)) != 0) {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return 0;
    }
}
