package me.tvspark;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* loaded from: classes4.dex */
public abstract class a01 {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final cz0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new cz0();
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;

    public a01(int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01 a01Var, b01 b01Var, IdentityHashMap<a01, a01> identityHashMap) {
        if (a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return a01Var;
        }
        a01 a01Var2 = identityHashMap.get(a01Var);
        if (a01Var2 != null) {
            return a01Var2;
        }
        a01 a01Var3 = b01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(a01Var);
        if (a01Var3 != null) {
            identityHashMap.put(a01Var, a01Var3);
            return a01Var3;
        }
        a01[] a01VarArr = new a01[a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()];
        boolean z = false;
        for (int i = 0; i < a01VarArr.length; i++) {
            a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i), b01Var, identityHashMap);
            if (z || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
                if (!z) {
                    a01VarArr = new a01[a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()];
                    for (int i2 = 0; i2 < a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(); i2++) {
                        a01VarArr[i2] = a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    }
                    z = true;
                }
                a01VarArr[i] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
        }
        if (!z) {
            b01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01Var);
            identityHashMap.put(a01Var, a01Var);
            return a01Var;
        }
        a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = a01VarArr.length == 0 ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : a01VarArr.length == 1 ? i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01VarArr[0], a01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0)) : new vy0(a01VarArr, ((vy0) a01Var).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        b01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        identityHashMap.put(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        identityHashMap.put(a01Var, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
    }

    public static a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ly0 ly0Var, dy0 dy0Var) {
        if (dy0Var == null) {
            dy0Var = dy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        dy0 dy0Var2 = dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return (dy0Var2 == null || dy0Var == dy0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ly0Var, dy0Var2), ((f01) ly0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(dy0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0)).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public abstract a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - 1) == Integer.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r1 == r9) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00dc, code lost:
        if (r19 != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0104, code lost:
        r19.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(r0, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0102, code lost:
        if (r19 != 0) goto L54;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Type inference failed for: r10v11, types: [me.tvspark.vy0] */
    /* JADX WARN: Type inference failed for: r10v15, types: [me.tvspark.vy0] */
    /* JADX WARN: Type inference failed for: r19v0, types: [me.tvspark.u01, me.tvspark.u01<me.tvspark.a01, me.tvspark.a01, me.tvspark.a01>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01 a01Var, a01 a01Var2, boolean z, u01<a01, a01, a01> u01Var) {
        a01 vy0Var;
        cz0 cz0Var;
        a01 vy0Var2;
        a01 a01Var3;
        vy0 vy0Var3 = a01Var;
        a01 a01Var4 = a01Var2;
        if (vy0Var3 == a01Var4 || a01Var.equals(a01Var2)) {
            return vy0Var3;
        }
        boolean z2 = vy0Var3 instanceof i01;
        if (z2 && (a01Var4 instanceof i01)) {
            i01 i01Var = (i01) vy0Var3;
            i01 i01Var2 = (i01) a01Var4;
            if (u01Var == 0 || ((vy0Var2 = (a01) u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i01Var, i01Var2)) == null && (vy0Var2 = (a01) u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i01Var2, i01Var)) == null)) {
                a01 a01Var5 = null;
                cz0 cz0Var2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (z) {
                    if (i01Var != cz0Var2) {
                    }
                    if (cz0Var2 == null) {
                        if (u01Var != 0) {
                            u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i01Var, i01Var2, cz0Var2);
                        }
                        return cz0Var2;
                    } else if (i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        a01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, z, u01Var);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            return i01Var;
                        }
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            return i01Var2;
                        }
                        i01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        if (u01Var != 0) {
                            u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i01Var, i01Var2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                        }
                        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                    } else {
                        if (i01Var == i01Var2 || ((a01Var3 = i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) != null && a01Var3.equals(i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) {
                            a01Var5 = i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        }
                        int[] iArr = new int[2];
                        if (a01Var5 != null) {
                            int i = i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            iArr[0] = i;
                            int i2 = i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            iArr[1] = i2;
                            if (i > i2) {
                                iArr[0] = i2;
                                iArr[1] = i;
                            }
                            vy0Var2 = new vy0(new a01[]{a01Var5, a01Var5}, iArr);
                        } else {
                            int i3 = i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            iArr[0] = i3;
                            int i4 = i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            iArr[1] = i4;
                            a01 a01Var6 = i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            a01 a01Var7 = i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            a01[] a01VarArr = {a01Var6, a01Var7};
                            if (i3 > i4) {
                                iArr[0] = i4;
                                iArr[1] = i3;
                                a01VarArr = new a01[]{a01Var7, a01Var6};
                            }
                            vy0Var2 = new vy0(a01VarArr, iArr);
                        }
                    }
                } else {
                    if (i01Var != cz0Var2 || i01Var2 != cz0Var2) {
                        cz0 cz0Var3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        if (i01Var == cz0Var3) {
                            cz0Var = new vy0(new a01[]{i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null}, new int[]{i01Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.MAX_VALUE});
                        } else {
                            if (i01Var2 == cz0Var3) {
                                cz0Var = new vy0(new a01[]{i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null}, new int[]{i01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Integer.MAX_VALUE});
                            }
                            cz0Var2 = null;
                        }
                        cz0Var2 = cz0Var;
                    }
                    if (cz0Var2 == null) {
                    }
                }
            }
            return vy0Var2;
        }
        if (z) {
            if (vy0Var3 instanceof cz0) {
                return vy0Var3;
            }
            if (a01Var4 instanceof cz0) {
                return a01Var4;
            }
        }
        if (z2) {
            i01 i01Var3 = (i01) vy0Var3;
            vy0Var3 = new vy0(new a01[]{i01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww}, new int[]{i01Var3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww});
        }
        boolean z3 = a01Var4 instanceof i01;
        vy0 vy0Var4 = a01Var4;
        if (z3) {
            i01 i01Var4 = (i01) a01Var4;
            vy0Var4 = new vy0(new a01[]{i01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww}, new int[]{i01Var4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww});
        }
        vy0 vy0Var5 = (vy0) vy0Var3;
        vy0 vy0Var6 = (vy0) vy0Var4;
        if (u01Var == 0 || ((vy0Var = (a01) u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var5, vy0Var6)) == null && (vy0Var = (a01) u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var6, vy0Var5)) == null)) {
            int[] iArr2 = vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int length = iArr2.length;
            int[] iArr3 = vy0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int[] iArr4 = new int[length + iArr3.length];
            int length2 = iArr2.length + iArr3.length;
            a01[] a01VarArr2 = new a01[length2];
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr5 = vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i5 >= iArr5.length) {
                    break;
                }
                int[] iArr6 = vy0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i6 >= iArr6.length) {
                    break;
                }
                a01 a01Var8 = vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5];
                a01 a01Var9 = vy0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6];
                if (iArr5[i5] == iArr6[i6]) {
                    int i8 = iArr5[i5];
                    boolean z4 = i8 == Integer.MAX_VALUE && a01Var8 == null && a01Var9 == null;
                    boolean z5 = (a01Var8 == null || a01Var9 == null || !a01Var8.equals(a01Var9)) ? false : true;
                    if (z4 || z5) {
                        a01VarArr2[i7] = a01Var8;
                        iArr4[i7] = i8;
                    } else {
                        a01VarArr2[i7] = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01Var8, a01Var9, z, u01Var);
                        iArr4[i7] = i8;
                    }
                    i5++;
                } else if (iArr5[i5] < iArr6[i6]) {
                    a01VarArr2[i7] = a01Var8;
                    iArr4[i7] = iArr5[i5];
                    i5++;
                    i7++;
                } else {
                    a01VarArr2[i7] = a01Var9;
                    iArr4[i7] = iArr6[i6];
                }
                i6++;
                i7++;
            }
            if (i5 >= vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length) {
                while (true) {
                    int[] iArr7 = vy0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i6 >= iArr7.length) {
                        break;
                    }
                    a01VarArr2[i7] = vy0Var6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6];
                    iArr4[i7] = iArr7[i6];
                    i7++;
                    i6++;
                }
            } else {
                while (true) {
                    int[] iArr8 = vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i5 >= iArr8.length) {
                        break;
                    }
                    a01VarArr2[i7] = vy0Var5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5];
                    iArr4[i7] = iArr8[i5];
                    i7++;
                    i5++;
                }
            }
            if (i7 < length2) {
                if (i7 == 1) {
                    i01 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = i01.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(a01VarArr2[0], iArr4[0]);
                    if (u01Var != 0) {
                        u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var5, vy0Var6, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                    }
                    return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                }
                a01VarArr2 = (a01[]) Arrays.copyOf(a01VarArr2, i7);
                iArr4 = Arrays.copyOf(iArr4, i7);
            }
            vy0Var = new vy0(a01VarArr2, iArr4);
            if (vy0Var.equals(vy0Var5)) {
                if (u01Var == 0) {
                    return vy0Var5;
                }
                u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var5, vy0Var6, vy0Var5);
                return vy0Var5;
            } else if (vy0Var.equals(vy0Var6)) {
                if (u01Var != 0) {
                    u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var5, vy0Var6, vy0Var6);
                }
                return vy0Var6;
            } else {
                HashMap hashMap = new HashMap();
                for (a01 a01Var10 : a01VarArr2) {
                    if (!hashMap.containsKey(a01Var10)) {
                        hashMap.put(a01Var10, a01Var10);
                    }
                }
                for (int i9 = 0; i9 < a01VarArr2.length; i9++) {
                    a01VarArr2[i9] = (a01) hashMap.get(a01VarArr2[i9]);
                }
                if (u01Var != 0) {
                    u01Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(vy0Var5, vy0Var6, vy0Var);
                }
            }
        }
        return vy0Var;
    }
}
