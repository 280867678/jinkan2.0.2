package me.tvspark;

import java.util.Arrays;
import java.util.Iterator;
import org.antlr.p055v4.runtime.LexerNoViableAltException;
import org.antlr.p055v4.runtime.atn.Transition;

/* loaded from: classes4.dex */
public class gz0 extends ry0 {
    public static int Wwwwwwwwwwwwwwwwwwwwwwww;
    public final p01[] Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final zx0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
    }

    public gz0(zx0 zx0Var, ly0 ly0Var, p01[] p01VarArr, b01 b01Var) {
        super(ly0Var, b01Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = p01VarArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = zx0Var;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0 sx0Var) {
        m01 m01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwwwwwwwwwwwwwww);
        cz0 cz0Var = a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        uz0 uz0Var = new uz0();
        int i = 0;
        while (i < m01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            int i2 = i + 1;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, new fz0(m01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, cz0Var), uz0Var, false, false, false);
            i = i2;
        }
        boolean z = uz0Var.Wwwwwwwwwwwwwwwwwww;
        uz0Var.Wwwwwwwwwwwwwwwwwww = false;
        r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uz0Var);
        if (!z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
    }

    public r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ny0 ny0Var) {
        my0 my0Var;
        r01 r01Var = new r01(ny0Var);
        Iterator<my0> it = ny0Var.iterator();
        while (true) {
            if (!it.hasNext()) {
                my0Var = null;
                break;
            }
            my0Var = it.next();
            if (my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof e01) {
                break;
            }
        }
        if (my0Var != null) {
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((fz0) my0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww[my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
        }
        p01 p01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwww];
        synchronized (p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            r01 r01Var2 = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(r01Var);
            if (r01Var2 != null) {
                return r01Var2;
            }
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
            ny0Var.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            ny0Var.Wwwwwwwwwwwwwwwwwwwwwww = null;
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ny0Var;
            p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(r01Var, r01Var);
            return r01Var;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01 r01Var, int i, r01 r01Var2) {
        if (i < 0 || i > 127) {
            return;
        }
        synchronized (r01Var) {
            if (r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new r01[128];
            }
            r01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i + 0] = r01Var2;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0 sx0Var) {
        if (sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) == 10) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        }
        sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0 sx0Var, fz0 fz0Var, ny0 ny0Var, boolean z, boolean z2, boolean z3) {
        fz0 fz0Var2;
        fz0 fz0Var3;
        iz0 iz0Var;
        sy0 sy0Var = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z4 = true;
        if (sy0Var instanceof e01) {
            a01 a01Var = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (a01Var == null || a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                a01 a01Var2 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (a01Var2 != null && !a01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new fz0(fz0Var, fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, a01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), null);
                } else {
                    ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var, null);
                    return true;
                }
            } else {
                z4 = z;
            }
            a01 a01Var3 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (a01Var3 == null || a01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return z4;
            }
            boolean z5 = z4;
            for (int i = 0; i < fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i++) {
                if (fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i) != Integer.MAX_VALUE) {
                    z5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, new fz0(fz0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)), fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)), ny0Var, z5, z2, z3);
                }
            }
            return z5;
        }
        if (!sy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && (!z || !fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            ny0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var, null);
        }
        sy0 sy0Var2 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        boolean z6 = z;
        for (int i2 = 0; i2 < sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i2++) {
            Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = sy0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != 10) {
                switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                    case 1:
                        fz0Var3 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        fz0Var2 = fz0Var3;
                        break;
                    case 2:
                    case 5:
                    case 7:
                        if (z3 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, 0, 1114111)) {
                            fz0Var3 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            fz0Var2 = fz0Var3;
                            break;
                        }
                        fz0Var2 = null;
                        break;
                    case 3:
                        fz0Var2 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((f01) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                        break;
                    case 4:
                        zz0 zz0Var = (zz0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                        ny0Var.Wwwwwwwwwwwwwwwwwww = true;
                        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && z2) {
                            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                            int mark = sx0Var.mark();
                            try {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var);
                                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                                    throw null;
                                }
                            } finally {
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
                                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
                                sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                                sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mark);
                            }
                        }
                        fz0Var3 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        fz0Var2 = fz0Var3;
                        break;
                    case 6:
                        a01 a01Var4 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (a01Var4 != null && !a01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            fz0Var3 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            fz0Var2 = fz0Var3;
                            break;
                        } else {
                            iz0 iz0Var2 = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            hz0 hz0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww[((uy0) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
                            if (iz0Var2 == null) {
                                iz0Var = new iz0(new hz0[]{hz0Var});
                            } else {
                                hz0[] hz0VarArr = iz0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                hz0[] hz0VarArr2 = (hz0[]) Arrays.copyOf(hz0VarArr, hz0VarArr.length + 1);
                                hz0VarArr2[hz0VarArr2.length - 1] = hz0Var;
                                iz0Var = new iz0(hz0VarArr2);
                            }
                            fz0Var2 = new fz0(fz0Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iz0Var);
                            break;
                        }
                        break;
                    default:
                        fz0Var2 = null;
                        break;
                }
                if (fz0Var2 != null) {
                    z6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, fz0Var2, ny0Var, z6, z2, z3);
                }
            } else {
                throw new UnsupportedOperationException("Precedence predicates are not supported in lexers.");
            }
        }
        return z6;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x014f A[EDGE_INSN: B:139:0x014f->B:91:0x014f ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0 sx0Var, r01 r01Var) {
        zx0 zx0Var;
        boolean z;
        hz0[] hz0VarArr;
        int i;
        int i2;
        my0 my0Var;
        int i3;
        int i4;
        r01 r01Var2 = r01Var;
        if (r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var2;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        while (true) {
            r01[] r01VarArr = r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            r01 r01Var3 = (r01VarArr == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0 || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 127) ? null : r01VarArr[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 0];
            int i5 = 0;
            if (r01Var3 == null) {
                uz0 uz0Var = new uz0();
                Iterator<my0> it = r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    my0 next = it.next();
                    boolean z2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i6;
                    if (!z2 || !((fz0) next).Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                                break;
                            }
                            Transition Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = next.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i7);
                            sy0 sy0Var = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i5, 1114111) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : null;
                            if (sy0Var != null) {
                                fz0 fz0Var = (fz0) next;
                                iz0 iz0Var = fz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                if (iz0Var != null) {
                                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    int i8 = 0;
                                    hz0[] hz0VarArr2 = null;
                                    while (true) {
                                        hz0[] hz0VarArr3 = iz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                        i4 = i7;
                                        if (i8 >= hz0VarArr3.length) {
                                            break;
                                        }
                                        if (hz0VarArr3[i8].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                                            hz0[] hz0VarArr4 = iz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                            if (!(hz0VarArr4[i8] instanceof lz0)) {
                                                if (hz0VarArr2 == null) {
                                                    hz0VarArr2 = (hz0[]) hz0VarArr4.clone();
                                                }
                                                hz0VarArr2[i8] = new lz0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, iz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i8]);
                                            }
                                        }
                                        i8++;
                                        i7 = i4;
                                    }
                                    if (hz0VarArr2 != null) {
                                        iz0Var = new iz0(hz0VarArr2);
                                    }
                                } else {
                                    i4 = i7;
                                }
                                i = i4;
                                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                my0Var = next;
                                i3 = i6;
                                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, new fz0(fz0Var, sy0Var, iz0Var), uz0Var, z2, true, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1)) {
                                    i6 = my0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    break;
                                }
                            } else {
                                i = i7;
                                i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                my0Var = next;
                                i3 = i6;
                            }
                            i7 = i + 1;
                            i6 = i3;
                            next = my0Var;
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i2;
                            i5 = 0;
                        }
                        i5 = 0;
                    }
                }
                if (!uz0Var.isEmpty()) {
                    boolean z3 = uz0Var.Wwwwwwwwwwwwwwwwwww;
                    uz0Var.Wwwwwwwwwwwwwwwwwww = false;
                    r01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(uz0Var);
                    if (!z3) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                    }
                    r01Var3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5;
                    if (r01Var3 == ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        break;
                    }
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var);
                    }
                    if (r01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r01Var3;
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                            break;
                        }
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                    r01Var2 = r01Var3;
                } else {
                    if (!uz0Var.Wwwwwwwwwwwwwwwwwww) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r01Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    }
                    r01Var3 = ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            if (r01Var3 == ry0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        ny0 ny0Var = r01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        r01 r01Var4 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (r01Var4 == null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1 || sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new LexerNoViableAltException(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, sx0Var, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ny0Var);
            }
            return -1;
        }
        iz0 iz0Var2 = r01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i10 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i11 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i12 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i10);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i11;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i12;
        if (iz0Var2 != null && (zx0Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            try {
                boolean z4 = false;
                for (hz0 hz0Var : iz0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    try {
                        if (hz0Var instanceof lz0) {
                            int i13 = ((lz0) hz0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + i9;
                            sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i13);
                            hz0Var = ((lz0) hz0Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (i13 != Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6) {
                                z4 = true;
                            }
                            z4 = false;
                        } else if (hz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                            sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                            z4 = false;
                        }
                        hz0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zx0Var);
                    } catch (Throwable th) {
                        th = th;
                        z = z4;
                        if (z) {
                            sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                        }
                        throw th;
                    }
                }
                if (z4) {
                    sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0 sx0Var, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwww++;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = i;
        int mark = sx0Var.mark();
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            p01 p01Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            return p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sx0Var, p01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } finally {
            sx0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mark);
        }
    }

    @Override // me.tvspark.ry0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }
}
