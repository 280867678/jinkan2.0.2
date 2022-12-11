package me.tvspark;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class do0 extends tk0 {
    static {
        new ThreadLocal();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j <= 0 || j >= 86400000) {
            return " 0 秒";
        }
        int i = (int) (j % 60);
        int i2 = (int) ((j / 60) % 60);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i2 > 0 ? formatter.format("%2d 分 %2d 秒", Integer.valueOf(i2), Integer.valueOf(i)) : formatter.format("%2d 秒", Integer.valueOf(i))).toString();
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            return new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (currentTimeMillis - bo0.Wwwwwwwwwwwwwwwwwwwwwwww.getLong("adb_timestamp", 0) > 86400000) {
            z = true;
        }
        if (z) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("adb_timestamp", Long.valueOf(currentTimeMillis));
        }
        return z;
    }
}
