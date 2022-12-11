package me.tvspark.utils.cast.utils;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public class VMLog {

    /* loaded from: classes4.dex */
    public enum Level {
        DEBUG,
        INFO,
        ERROR,
        NONE
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level.INFO, str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level.ERROR, str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level.DEBUG, str);
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\n┆ Thread:");
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(name + " - " + id);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" - ");
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[6];
        String className = stackTraceElement.getClassName();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(String.format("%s.%s (%s:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        sb.append(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        sb.append("\n┆ " + str);
        sb.append("\n└──────────────────────────────────────────────────────────────────────────");
        int ordinal = level.ordinal();
        if (ordinal == 0 || ordinal == 1 || ordinal == 2) {
            sb.toString();
        }
    }
}
