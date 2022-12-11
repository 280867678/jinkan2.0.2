package me.tvspark;

import java.io.PrintStream;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public interface r11 {

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements r11 {
        @Override // me.tvspark.r11
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // me.tvspark.r11
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Level level, String str, Throwable th);
}
