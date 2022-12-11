package me.tvspark;

import android.annotation.SuppressLint;

/* renamed from: me.tvspark.b4 */
/* loaded from: classes4.dex */
public final /* synthetic */ class C1933b4 {
    @SuppressLint({"WrongConstant"})
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i & 32;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (i != 0) {
            if (i == 1) {
                return "NO_UNSUPPORTED_TYPE";
            }
            if (i == 2) {
                return "NO_UNSUPPORTED_DRM";
            }
            if (i == 3) {
                return "NO_EXCEEDS_CAPABILITIES";
            }
            if (i != 4) {
                throw new IllegalStateException();
            }
            return "YES";
        }
        return "NO";
    }

    @SuppressLint({"WrongConstant"})
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return i & 7;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, 0, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
        return i | i2 | i3;
    }
}
