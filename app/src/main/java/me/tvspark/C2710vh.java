package me.tvspark;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.vh */
/* loaded from: classes4.dex */
public final class C2710vh {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2710vh(int i, int i2, int i3, int i4, int i5) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public static C2710vh Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        char c;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < split.length; i5++) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(split[i5].trim());
            switch (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode()) {
                case 100571:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("end")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("text")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("start")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("style")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                i = i5;
            } else if (c == 1) {
                i2 = i5;
            } else if (c == 2) {
                i3 = i5;
            } else if (c == 3) {
                i4 = i5;
            }
        }
        if (i == -1 || i2 == -1) {
            return null;
        }
        return new C2710vh(i, i2, i3, i4, split.length);
    }
}
