package com.p038qq.p039e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.p038qq.p039e.comm.managers.C1060b;
import com.p038qq.p039e.comm.p040pi.SVSD;
import com.p038qq.p039e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.DownloadService */
/* loaded from: classes3.dex */
public class DownloadService extends Service {
    public SVSD Wwwwwwwwwwwwwwwwwwwwwwww;

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.m3646e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("GDT_APPID", C1060b.m3662b().m3663a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww == null) {
            try {
                if (C1060b.m3662b().m3660d()) {
                    SVSD aPKDownloadServiceDelegate = C1060b.m3662b().m3661c().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.Wwwwwwwwwwwwwwwwwwwwwwww = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                }
            } catch (Throwable th) {
                GDTLogger.m3645e("初始化Service发生异常", th);
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwww != null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.m3647d("DownloadService.onBind");
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.m3647d("DownloadService.onBind,appID=" + stringExtra);
        if (!TextUtils.isEmpty(stringExtra) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        } else if (!TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwww.onStartCommand(intent, i, i2);
        } else {
            GDTLogger.m3643w("Service onStartCommand 出现异常");
            return 2;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
