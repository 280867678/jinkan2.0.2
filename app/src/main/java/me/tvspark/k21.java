package me.tvspark;

import org.mozilla.classfile.ClassFileWriter;

/* loaded from: classes4.dex */
public final class k21 {
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[0];
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

    public k21(int i, int i2, int i3, int[] iArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int[] iArr2 = new int[iArr.length];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int i, int[] iArr2, int i2, h21 h21Var) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr3.length != i || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length != i2) {
                throw new IllegalArgumentException("bad merge attempt");
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr3, iArr, i, h21Var) || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iArr2, i2, h21Var);
        }
        System.arraycopy(iArr, 0, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i);
        int[] iArr4 = new int[i2];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr4;
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        return true;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, int[] iArr2, int i, h21 h21Var) {
        String str;
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int i4 = iArr[i2];
            int i5 = iArr2[i2];
            int i6 = i4 & 255;
            int i7 = i5 & 255;
            boolean z2 = i6 == 7;
            boolean z3 = i7 == 7;
            if (i4 != i5 && (!z2 || i5 != 5)) {
                if (i6 == 0 || i7 == 0) {
                    i4 = 0;
                } else {
                    if (i4 != 5 || !z3) {
                        if (z2 && z3) {
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, h21Var);
                            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, h21Var);
                            String str2 = (String) h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                            String str3 = (String) h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(str2)) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str3;
                            }
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(str2)) {
                                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = str3;
                            }
                            Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                            Class<?> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isAssignableFrom(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) {
                                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isAssignableFrom(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isInterface() || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isInterface()) {
                                        str = "java/lang/Object";
                                    } else {
                                        do {
                                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getSuperclass();
                                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
                                            }
                                        } while (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isAssignableFrom(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                                        str = ClassFileWriter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.getName());
                                    }
                                    i4 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(h21Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
                                }
                            }
                        }
                        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bad merge attempt between ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, h21Var));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" and ");
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5, h21Var));
                        throw new IllegalArgumentException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    }
                    i4 = i5;
                }
            }
            iArr[i2] = i4;
            if (i3 != iArr[i2]) {
                z = true;
            }
        }
        return z;
    }

    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int length = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - 1;
        while (length >= 0) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr[length] != 0 || r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr[length - 1])) {
                break;
            }
            length--;
        }
        int i = length + 1;
        int i2 = 0;
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4])) {
                i3--;
            }
        }
        int[] iArr2 = new int[i3];
        int i5 = 0;
        while (i2 < i3) {
            int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            iArr2[i2] = iArr3[i5];
            if (r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr3[i5])) {
                i5++;
            }
            i2++;
            i5++;
        }
        return iArr2;
    }

    public String toString() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("sb ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
