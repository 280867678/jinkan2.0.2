package me.tvspark;

import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;

/* renamed from: me.tvspark.Zz */
/* loaded from: classes4.dex */
public final class C1890Zz {
    public static volatile C1890Zz Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final File Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new File("/proc/self/fd");
    @GuardedBy("this")
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    @GuardedBy("this")
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @VisibleForTesting
    public C1890Zz() {
        boolean z = true;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String substring = Build.MODEL.substring(0, 7);
            char c = 65535;
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    if (Build.VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    }
                    break;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        if (Build.VERSION.SDK_INT >= 28) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 20000;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 700;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 128;
    }

    public static C1890Zz Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            synchronized (C1890Zz.class) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1890Zz();
                }
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean z = true;
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        if (i >= 50) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.list().length >= this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                z = false;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
            if (!z) {
                Log.isLoggable("Downsampler", 5);
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z, boolean z2) {
        int i3;
        return z && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Build.VERSION.SDK_INT >= 26 && !z2 && i >= (i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && i2 >= i3 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
