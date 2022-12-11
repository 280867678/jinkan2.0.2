package me.tvspark;

import android.util.Log;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public class c21 implements r11 {
    public static final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    static {
        boolean z;
        try {
            Class.forName("android.util.Log");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public c21(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        } else if (intValue < 900) {
            return 4;
        } else {
            return intValue < 1000 ? 5 : 6;
        }
    }

    @Override // me.tvspark.r11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str) {
        if (level != Level.OFF) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level);
        }
    }

    @Override // me.tvspark.r11
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(level);
            Log.getStackTraceString(th);
        }
    }
}
