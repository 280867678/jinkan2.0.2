package com.p038qq.p039e.ads.cfg;

import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.cfg.MultiProcessFlag */
/* loaded from: classes3.dex */
public class MultiProcessFlag {
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public static boolean isMultiProcess() {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static void setMultiProcess(boolean z) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            GDTLogger.m3643w("MultiProcessFlag已经设置过，再次设置无效");
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }
}
