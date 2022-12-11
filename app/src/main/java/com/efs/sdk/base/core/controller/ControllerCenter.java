package com.efs.sdk.base.core.controller;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.config.C0725a;
import com.efs.sdk.base.core.config.C0734b;
import com.efs.sdk.base.core.config.GlobalEnvStruct;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.p009a.RunnableC0737a;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.p007c.C0722f;
import com.efs.sdk.base.core.p007c.HandlerC0719d;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p011e.C0751d;
import com.efs.sdk.base.core.p013f.C0755b;
import com.efs.sdk.base.core.p013f.C0756c;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0778d;
import com.efs.sdk.base.core.util.C0779e;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.core.util.p014a.C0767d;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import com.p038qq.p039e.comm.p040pi.ACTD;
import com.umeng.umcrash.UMCrash;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ControllerCenter implements Handler.Callback {

    /* renamed from: h */
    public static GlobalEnvStruct f260h;

    /* renamed from: a */
    public int f261a = 0;

    /* renamed from: b */
    public final int f262b = 0;

    /* renamed from: c */
    public final int f263c = 1;

    /* renamed from: d */
    public final int f264d = 2;

    /* renamed from: e */
    public final int f265e = 3;

    /* renamed from: f */
    public volatile boolean f266f = false;

    /* renamed from: g */
    public RunnableC0737a f267g;

    /* renamed from: i */
    public Handler f268i;

    public ControllerCenter(EfsReporter.Builder builder) {
        f260h = builder.getGlobalEnvStruct();
        Handler handler = new Handler(C0764a.f317a.getLooper(), this);
        this.f268i = handler;
        handler.sendEmptyMessage(0);
    }

    /* renamed from: a */
    private void m4102a() {
        if (this.f267g == null) {
            this.f267g = new RunnableC0737a();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f260h.mAppContext.registerReceiver(this.f267g, intentFilter);
        } catch (Throwable th) {
            Log.m4053w("efs.base", "register network change receiver error", th);
            int i = this.f261a + 1;
            this.f261a = i;
            if (i >= 3) {
                return;
            }
            this.f268i.sendEmptyMessageDelayed(3, 6000L);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m4101a(ILogProtocol iLogProtocol) {
        for (ValueCallback<Pair<Message, Message>> valueCallback : getGlobalEnvStruct().getCallback(9)) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("log_type", iLogProtocol.getLogType());
            hashMap.put("log_data", iLogProtocol.generateString());
            hashMap.put("link_key", iLogProtocol.getLinkKey());
            hashMap.put("link_id", iLogProtocol.getLinkId());
            Message obtain = Message.obtain(null, 9, hashMap);
            Message obtain2 = Message.obtain();
            valueCallback.onReceiveValue(new Pair<>(obtain, obtain2));
            obtain.recycle();
            obtain2.recycle();
        }
    }

    /* renamed from: b */
    private void m4100b(final ILogProtocol iLogProtocol) {
        if (iLogProtocol == null) {
            return;
        }
        C0767d.m4041a(new Runnable() { // from class: com.efs.sdk.base.core.controller.ControllerCenter.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    iLogProtocol.insertGlobal(C0734b.C0735a.m4103a().f257a);
                    if (!"wa".equalsIgnoreCase(iLogProtocol.getLogType())) {
                        ControllerCenter.m4101a(iLogProtocol);
                    }
                    if (!ControllerCenter.getGlobalEnvStruct().isEnableSendLog()) {
                        return;
                    }
                    final C0739b m4097a = C0739b.m4097a(iLogProtocol);
                    final C0751d m4085a = C0751d.C0753a.m4085a();
                    C0767d.m4041a(new Runnable() { // from class: com.efs.sdk.base.core.e.d.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            m4085a.f288a.m4090a(m4097a);
                        }
                    });
                } catch (Throwable th) {
                    Log.m4065e("efs.base", "log send error", th);
                }
            }
        });
    }

    @NonNull
    public static GlobalEnvStruct getGlobalEnvStruct() {
        return f260h;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01a7 A[Catch: all -> 0x01c2, TryCatch #0 {all -> 0x01c2, blocks: (B:22:0x0170, B:25:0x0182, B:26:0x0186, B:27:0x019d, B:29:0x01a7, B:30:0x01b0, B:41:0x018a, B:43:0x0192, B:44:0x0198), top: B:21:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01e8  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(@NonNull Message message) {
        boolean isIntl;
        String str;
        C0759f m4074a;
        String[] networkAccessMode;
        C0725a c0725a;
        String str2;
        int i = message.what;
        if (i == 0) {
            C0734b m4103a = C0734b.C0735a.m4103a();
            C0725a c0725a2 = new C0725a();
            m4103a.f257a = c0725a2;
            c0725a2.m4133a(ACTD.APPID_KEY, getGlobalEnvStruct().getAppid());
            int m4005a = C0778d.m4005a();
            m4103a.f257a.m4133a("pid", Integer.valueOf(m4005a));
            m4103a.f257a.m4133a("ps", C0778d.m4004a(m4005a));
            String m4001a = C0779e.m4001a(m4103a.f258b);
            m4103a.f257a.m4133a("wid", m4001a);
            if (TextUtils.isEmpty(getGlobalEnvStruct().getUid())) {
                m4103a.f257a.m4133a("uid", m4001a);
            } else {
                m4103a.f257a.m4133a("uid", getGlobalEnvStruct().getUid());
            }
            C0725a c0725a3 = m4103a.f257a;
            C0694a.m4184a();
            c0725a3.m4133a("stime", Long.valueOf(C0694a.m4180b() - Process.getElapsedCpuTime()));
            m4103a.f257a.m4133a("pkg", PackageUtil.getPackageName(m4103a.f258b));
            m4103a.f257a.m4133a("ver", PackageUtil.getAppVersionName(m4103a.f258b));
            m4103a.f257a.m4133a("vcode", PackageUtil.getAppVersionCode(m4103a.f258b));
            m4103a.f257a.m4133a("sdk_ver", BuildConfig.VERSION_NAME);
            m4103a.f257a.m4133a("brand", Build.BRAND.toLowerCase());
            C0725a c0725a4 = m4103a.f257a;
            String str3 = Build.MODEL;
            c0725a4.m4133a("model", str3 == null ? "unknown" : str3.replace(StringUtils.SPACE, "-").replace("_", "-").toLowerCase());
            m4103a.f257a.m4133a("build_model", Build.MODEL);
            DisplayMetrics displayMetrics = m4103a.f258b.getResources().getDisplayMetrics();
            m4103a.f257a.m4133a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            m4103a.f257a.m4133a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
            m4103a.f257a.m4133a("fr", "android");
            m4103a.f257a.m4133a("rom", Build.VERSION.RELEASE);
            m4103a.f257a.m4133a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
            m4103a.f257a.m4133a("lang", Locale.getDefault().getLanguage());
            m4103a.f257a.m4133a("tzone", TimeZone.getDefault().getID());
            m4103a.f257a.m4133a("net", NetworkUtil.getNetworkType(m4103a.f258b));
            try {
                networkAccessMode = NetworkUtil.getNetworkAccessMode(m4103a.f258b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                c0725a = m4103a.f257a;
                str2 = NetworkUtil.NETWORK_TYPE_WIFI;
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                m4103a.f257a.m4133a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
                if (!"".equals(networkAccessMode[1])) {
                    m4103a.f257a.m4133a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
                }
                m4103a.f257a.m4133a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(m4103a.f258b)));
                C0722f.C0724a.m4136a();
                C0729c.m4127a().m4121b();
                m4102a();
                C0759f m4074a2 = C0759f.C0760a.m4074a();
                isIntl = f260h.isIntl();
                C0756c c0756c = m4074a2.f305a;
                if (!isIntl) {
                    c0756c.f297a = "https://errlogos.umeng.com/api/crashsdk/logcollect";
                    str = "4ea4e41a3993";
                } else {
                    c0756c.f297a = "https://errlog.umeng.com/api/crashsdk/logcollect";
                    str = "28ef1713347d";
                }
                c0756c.f298b = str;
                m4074a2.f306b = this;
                m4074a2.f307c.f292a = this;
                m4074a2.f308d.f292a = this;
                this.f266f = true;
                HandlerC0719d.m4141a().sendEmptyMessageDelayed(0, f260h.getLogSendDelayMills());
                m4074a = C0759f.C0760a.m4074a();
                if (m4074a.f306b != null && getGlobalEnvStruct().isEnableWaStat()) {
                    m4074a.f306b.send(new C0755b("efs_core", "pvuv", m4074a.f305a.f299c));
                }
            } else {
                c0725a = m4103a.f257a;
                str2 = "unknow";
            }
            c0725a.m4133a(UMCrash.KEY_HEADER_ACCESS, str2);
            if (!"".equals(networkAccessMode[1])) {
            }
            m4103a.f257a.m4133a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(m4103a.f258b)));
            C0722f.C0724a.m4136a();
            C0729c.m4127a().m4121b();
            m4102a();
            C0759f m4074a22 = C0759f.C0760a.m4074a();
            isIntl = f260h.isIntl();
            C0756c c0756c2 = m4074a22.f305a;
            if (!isIntl) {
            }
            c0756c2.f298b = str;
            m4074a22.f306b = this;
            m4074a22.f307c.f292a = this;
            m4074a22.f308d.f292a = this;
            this.f266f = true;
            HandlerC0719d.m4141a().sendEmptyMessageDelayed(0, f260h.getLogSendDelayMills());
            m4074a = C0759f.C0760a.m4074a();
            if (m4074a.f306b != null) {
                m4074a.f306b.send(new C0755b("efs_core", "pvuv", m4074a.f305a.f299c));
            }
        } else if (i == 1) {
            Object obj = message.obj;
            if (obj != null && (obj instanceof ILogProtocol)) {
                m4100b((ILogProtocol) obj);
            }
        } else if (i == 3) {
            m4102a();
        }
        return true;
    }

    public void send(ILogProtocol iLogProtocol) {
        if (this.f266f) {
            m4100b(iLogProtocol);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iLogProtocol;
        this.f268i.sendMessage(obtain);
    }

    @Nullable
    public HttpResponse sendSyncImmediately(String str, int i, String str2, boolean z, File file) {
        C0739b c0739b = new C0739b(str, (byte) 2);
        c0739b.m4093b(1);
        c0739b.f281d = file;
        c0739b.m4096a(str2);
        c0739b.m4098a(i);
        c0739b.f279b.f283b = z;
        c0739b.m4092c();
        C0751d.C0753a.m4085a().f288a.m4090a(c0739b);
        return c0739b.f279b.f284c;
    }
}
