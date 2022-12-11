package com.p038qq.p039e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.p038qq.p039e.ads.dfa.GDTAppDialogClickListener;
import com.p038qq.p039e.comm.managers.devtool.DevTools;
import com.p038qq.p039e.comm.managers.plugin.C1062PM;
import com.p038qq.p039e.comm.util.GDTLogger;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.qq.e.comm.managers.b */
/* loaded from: classes3.dex */
public class C1060b implements IGDTAdManager {

    /* renamed from: g */
    public static final ExecutorService f664g = Executors.newSingleThreadExecutor();
    public volatile String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile DevTools Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile C1062PM Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile Context Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public volatile Boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.FALSE;
    public volatile boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;

    /* renamed from: com.qq.e.comm.managers.b$a */
    /* loaded from: classes3.dex */
    public static final class C1061a {
        public static C1060b Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1060b(null);
    }

    public C1060b() {
    }

    public /* synthetic */ C1060b(RunnableC1059a runnableC1059a) {
    }

    /* renamed from: b */
    public static C1060b m3662b() {
        return C1061a.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public synchronized boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, String str) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.m3646e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C1062PM(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, null);
        f664g.submit(new RunnableC1059a(this));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Boolean.TRUE;
        return true;
    }

    /* renamed from: a */
    public String m3663a() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: c */
    public C1062PM m3661c() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: d */
    public boolean m3660d() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.booleanValue()) {
            GDTLogger.m3646e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
            return false;
        }
        return true;
    }

    @Override // com.p038qq.p039e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!m3660d()) {
            return "";
        }
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPOFactory().getBuyerId(map);
        } catch (Exception e) {
            GDTLogger.m3645e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.p038qq.p039e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new DevTools();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!m3660d()) {
            return "";
        }
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPOFactory().getSDKInfo(str);
        } catch (Exception e) {
            GDTLogger.m3645e("SDK 初始化异常", e);
            return "";
        }
    }

    @Override // com.p038qq.p039e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return 0;
        }
        try {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e) {
            GDTLogger.m3645e("SDK 初始化异常", e);
            return 0;
        }
    }
}
