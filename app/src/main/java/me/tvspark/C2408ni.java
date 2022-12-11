package me.tvspark;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

/* renamed from: me.tvspark.ni */
/* loaded from: classes4.dex */
public final class C2408ni {
    public float Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    @ColorInt
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
    public Set<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Collections.emptySet();
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
    @Nullable
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwwwww = -1;
    public int Wwwwwwwwwwwwwwwwwww = -1;
    public boolean Wwwwwwwwwwwwwwwwww = false;

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, @Nullable String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (!str.equals(str2)) {
            return -1;
        }
        return i + i2;
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwww == -1 && this.Wwwwwwwwwwwwwwwwwwwwww == -1) {
            return -1;
        }
        int i = 0;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww == 1 ? 1 : 0;
        if (this.Wwwwwwwwwwwwwwwwwwwwww == 1) {
            i = 2;
        }
        return i2 | i;
    }
}
