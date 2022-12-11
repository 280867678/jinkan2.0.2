package com.p038qq.p039e.comm.managers;

import com.p038qq.p039e.comm.managers.plugin.C1071e;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.managers.a */
/* loaded from: classes3.dex */
public class RunnableC1059a implements Runnable {
    public final /* synthetic */ C1060b Wwwwwwwwwwwwwwwwwwwwwwww;

    public RunnableC1059a(C1060b c1060b) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = c1060b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPOFactory();
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        } catch (C1071e e) {
            GDTLogger.m3645e(e.getMessage(), e);
        }
    }
}
