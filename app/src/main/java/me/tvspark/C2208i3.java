package me.tvspark;

import android.os.Build;
import java.util.HashSet;

/* renamed from: me.tvspark.i3 */
/* loaded from: classes4.dex */
public final class C2208i3 {
    public static final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final HashSet<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new HashSet<>();
    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "goog.exo.core";

    static {
        String str = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 56));
        sb.append("ExoPlayerLib/2.12.1 (Linux;Android ");
        sb.append(str);
        sb.append(") ");
        sb.append("ExoPlayerLib/2.12.1");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
    }

    public static synchronized String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        String str;
        synchronized (C2208i3.class) {
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return str;
    }

    public static synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        synchronized (C2208i3.class) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(str)) {
                String str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 2 + String.valueOf(str).length());
                sb.append(str2);
                sb.append(", ");
                sb.append(str);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sb.toString();
            }
        }
    }
}
