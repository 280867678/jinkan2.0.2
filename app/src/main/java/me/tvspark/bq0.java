package me.tvspark;

import java.text.SimpleDateFormat;

/* loaded from: classes4.dex */
public class bq0 {
    static {
        new SimpleDateFormat("yyyy/MM/dd HH:mm");
        new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        new SimpleDateFormat("MM/dd HH:mm");
        new SimpleDateFormat("yyyy/MM/dd");
        new SimpleDateFormat("yyyy月MM日");
        new SimpleDateFormat("MM/dd");
        new SimpleDateFormat("HH:mm");
    }

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (str.lastIndexOf(".") != -1) {
            str = str.substring(0, str.lastIndexOf("."));
        }
        String[] split = str.split(":");
        if (split.length == 3) {
            return (Long.parseLong(split[0]) * 3600) + (Long.parseLong(split[1]) * 60) + Long.parseLong(split[2]);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Can't parse time string: ", str));
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return String.format("%02d:%02d:%02d", Long.valueOf(j / 3600), Long.valueOf((j / 60) % 60), Long.valueOf(j % 60));
    }
}
