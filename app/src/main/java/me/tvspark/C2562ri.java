package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import java.util.regex.Pattern;

/* renamed from: me.tvspark.ri */
/* loaded from: classes4.dex */
public final class C2562ri {
    public static final Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Pattern.compile("^NOTE([ \t].*)?$");

    public static long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws NumberFormatException {
        String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "\\.");
        long j = 0;
        for (String str2 : C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0], ":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length == 2) {
            j2 += Long.parseLong(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1]);
        }
        return j2 * 1000;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws ParserException {
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el)) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            String valueOf = String.valueOf(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            throw new ParserException(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "));
        }
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("WEBVTT");
    }
}
