package com.p038qq.p039e.ads.dfa;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p038qq.p039e.comm.C1058a;
import com.p038qq.p039e.comm.managers.C1060b;
import com.p038qq.p039e.comm.p040pi.DFA;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.dfa.GDTApkManager */
/* loaded from: classes3.dex */
public class GDTApkManager {
    public Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DFA Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    public AtomicInteger Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicInteger(0);

    public GDTApkManager(Context context, final IGDTApkListener iGDTApkListener) {
        String str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        if (C1060b.m3662b().m3660d()) {
            if (TextUtils.isEmpty(C1060b.m3662b().m3663a()) || context == null) {
                str = "初始化错误：GDTApkManager 构造失败，Context和appID不能为空";
            } else if (C1058a.m3664a(context)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = context;
                C1060b.f664g.execute(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final POFactory pOFactory = C1060b.m3662b().m3661c().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.dfa.GDTApkManager.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            GDTApkManager.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1060b.m3662b().m3661c().getPOFactory().getGDTApkDelegate(iGDTApkListener);
                                            GDTApkManager.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                            while (GDTApkManager.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndDecrement() > 0) {
                                                GDTApkManager.this.loadGDTApk();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            GDTLogger.m3645e("初始化错误：初始化时发生异常", th);
                                        } finally {
                                            GDTApkManager.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                                        }
                                    }
                                }
                            });
                        } catch (Throwable th) {
                            GDTLogger.m3645e("初始化错误：初始化时发生异常", th);
                        }
                    }
                });
                return;
            } else {
                str = "初始化错误：必需的 Activity/Service/Permission 没有在AndroidManifest.xml中声明";
            }
            GDTLogger.m3646e(str);
        }
    }

    public final void loadGDTApk() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.incrementAndGet();
            return;
        }
        DFA dfa = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dfa != null) {
            dfa.loadGDTApk();
        } else {
            GDTLogger.m3646e("调用loadGDTApk失败，实例未被正常初始化");
        }
    }

    public final void startInstall(GDTApk gDTApk) {
        DFA dfa = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dfa != null) {
            dfa.startInstall(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, gDTApk);
        }
    }
}
