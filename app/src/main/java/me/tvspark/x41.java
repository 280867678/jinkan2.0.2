package me.tvspark;

/* loaded from: classes4.dex */
public final class x41 {
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final z41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final c51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public x41(c51 c51Var, boolean z, z41 z41Var, z41 z41Var2, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c51Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z41Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z41Var2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, p51 p51Var, z41 z41Var) {
        int i2 = i >>> 24;
        if (i2 != 0 && i2 != 1) {
            switch (i2) {
                case 19:
                case 20:
                case 21:
                    z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    break;
                case 22:
                    break;
                default:
                    switch (i2) {
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                            break;
                        default:
                            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2, (i & 16776960) >> 8);
                            break;
                    }
            }
            if (p51Var != null) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                return;
            }
            byte[] bArr = p51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = p51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3, (bArr[i3] * 2) + 1);
            return;
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i >>> 16);
        if (p51Var != null) {
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x41[] x41VarArr, int i, z41 z41Var) {
        int length = ((x41VarArr.length - i) * 2) + 1;
        int i2 = i;
        while (true) {
            int i3 = 0;
            if (i2 >= x41VarArr.length) {
                break;
            }
            if (x41VarArr[i2] != null) {
                i3 = x41VarArr[i2].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            length += i3;
            i2++;
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(x41VarArr.length - i);
        while (i < x41VarArr.length) {
            x41 x41Var = null;
            int i4 = 0;
            for (x41 x41Var2 = x41VarArr[i]; x41Var2 != null; x41Var2 = x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                i4++;
                x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = x41Var;
                x41Var = x41Var2;
            }
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4);
            while (x41Var != null) {
                z41 z41Var2 = x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                x41Var = x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            i++;
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (z41Var != null) {
            byte[] bArr = z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        for (x41 x41Var = this; x41Var != null; x41Var = x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i += x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return i;
    }

    public x41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, 0);
        c51 c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        z41 z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return new x41(c51Var, false, z41Var, z41Var, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 2);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object obj) {
        int i;
        z41 z41Var;
        c51 c51Var;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
        if (obj instanceof String) {
            z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            i = 115;
            c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (String) obj;
        } else {
            i = 66;
            if (obj instanceof Byte) {
                z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Byte) obj).byteValue()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
            } else if (obj instanceof Boolean) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Boolean) obj).booleanValue() ? 1 : 0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            } else if (obj instanceof Character) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(67, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Character) obj).charValue()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            } else if (obj instanceof Short) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) ((Short) obj).shortValue()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            } else if (!(obj instanceof o51)) {
                int i3 = 0;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, bArr.length);
                    while (i3 < bArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(66, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) bArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, zArr.length);
                    while (i3 < zArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(90, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(zArr[i3] ? 1 : 0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, sArr.length);
                    while (i3 < sArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(83, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) sArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof char[]) {
                    char[] cArr = (char[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, cArr.length);
                    while (i3 < cArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(67, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((int) cArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, iArr.length);
                    while (i3 < iArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(73, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, jArr.length);
                    while (i3 < jArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(74, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, fArr.length);
                    while (i3 < fArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(70, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(fArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                } else if (!(obj instanceof double[])) {
                    j51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(".s.IFJDCS".charAt(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                } else {
                    double[] dArr = (double[]) obj;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(91, dArr.length);
                    while (i3 < dArr.length) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(68, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dArr[i3]).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        i3++;
                    }
                    return;
                }
            } else {
                z41Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = 99;
                c51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((o51) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
        i2 = c51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41 z41Var) {
        int i = 2;
        int i2 = 0;
        x41 x41Var = null;
        for (x41 x41Var2 = this; x41Var2 != null; x41Var2 = x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            i2++;
            i += x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            x41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = x41Var;
            x41Var = x41Var2;
        }
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        while (x41Var != null) {
            z41 z41Var2 = x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, z41Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            x41Var = x41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}
