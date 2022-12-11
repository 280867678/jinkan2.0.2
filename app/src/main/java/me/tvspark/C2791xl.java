package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.xl */
/* loaded from: classes4.dex */
public final class C2791xl {
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2791xl(int i, int i2, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    @Nullable
    public static C2791xl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        String str;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int i = Wwwwwwwwwwwwwwwwwwwwww >> 1;
        int Wwwwwwwwwwwwwwwwwwwwww2 = ((c2078el.Wwwwwwwwwwwwwwwwwwwwww() >> 3) & 31) | ((Wwwwwwwwwwwwwwwwwwwwww & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder(str.length() + 26);
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(".0");
        sb.append(Wwwwwwwwwwwwwwwwwwwwww2);
        return new C2791xl(i, Wwwwwwwwwwwwwwwwwwwwww2, sb.toString());
    }
}
