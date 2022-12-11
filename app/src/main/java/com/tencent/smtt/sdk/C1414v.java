package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.C1465m;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.v */
/* loaded from: classes4.dex */
public class C1414v {

    /* renamed from: a */
    public Context f2329a;

    /* renamed from: b */
    public Context f2330b;

    /* renamed from: c */
    public String f2331c;

    /* renamed from: d */
    public String[] f2332d;

    /* renamed from: e */
    public DexLoader f2333e;

    /* renamed from: f */
    public String f2334f;

    /* renamed from: g */
    public String f2335g = null;

    public C1414v(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        boolean z;
        boolean z2;
        this.f2329a = null;
        this.f2330b = null;
        this.f2331c = null;
        this.f2332d = null;
        this.f2333e = null;
        this.f2334f = "TbsDexOpt";
        TbsLog.m2155i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        this.f2329a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (StubApp.getOrigApplicationContext(context2.getApplicationContext()) != null) {
            this.f2330b = StubApp.getOrigApplicationContext(context2.getApplicationContext());
        } else {
            this.f2330b = context2;
        }
        this.f2331c = str;
        this.f2332d = strArr;
        this.f2334f = str2;
        for (int i = 0; i < this.f2332d.length; i++) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#2 mDexFileList[", i, "]: ");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2332d[i]);
            TbsLog.m2155i("TbsWizard", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("new DexLoader #2 libraryPath is ", str3, " mCallerAppContext is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f2329a);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" dexOutPutDir is ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(str2);
        TbsLog.m2155i("TbsWizard", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
        this.f2333e = new DexLoader(str3, this.f2329a, this.f2332d, str2, QbSdk.f1754o);
        System.currentTimeMillis();
        m2305a(context);
        libwebp.loadWepLibraryIfNeed(context2, this.f2331c);
        if ("com.nd.android.pandahome2".equals(this.f2329a.getApplicationInfo().packageName)) {
            this.f2333e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.f2329a);
        }
        if (QbSdk.f1754o != null) {
            try {
                z = TbsPVConfig.getInstance(this.f2329a).getTbsCoreSandboxModeEnable();
            } catch (Throwable unused) {
                z = false;
            }
            try {
                z2 = "true".equals(String.valueOf(QbSdk.f1754o.get(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)));
            } catch (Throwable th) {
                th.printStackTrace();
                z2 = false;
            }
            QbSdk.f1754o.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z && z2));
            this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.f1754o);
        }
        int m2301b = m2301b(context);
        if (m2301b >= 0) {
            TbsLog.m2155i("TbsWizard", "construction end...");
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("TbsWizard init error: ", m2301b, "; msg: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.f2335g);
        throw new Exception(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
    }

    /* renamed from: b */
    private int m2301b(Context context) {
        Object invokeStaticMethod;
        int i;
        String str;
        if (this.f2330b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.m2155i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.f2330b + " mDexLoader is " + this.f2333e + " mtbsInstallLocation is " + this.f2331c + " mDexOptPath is " + this.f2334f);
            DexLoader dexLoader = this.f2333e;
            invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.f2330b, dexLoader, this.f2331c, this.f2334f, TbsConfig.TBS_SDK_VERSIONNAME, 44115, QbSdk.m2839a());
        } else {
            DexLoader dexLoader2 = this.f2333e;
            invokeStaticMethod = dexLoader2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.f2330b, dexLoader2, this.f2331c, this.f2334f, TbsConfig.TBS_SDK_VERSIONNAME, 44115, QbSdk.m2839a(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (invokeStaticMethod == null) {
            m2300c();
            m2299d();
            DexLoader dexLoader3 = this.f2333e;
            invokeStaticMethod = dexLoader3.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.f2330b, dexLoader3, this.f2331c, this.f2334f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().m2814a(this.f2329a, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("#");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getMessage());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; cause: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th.getCause());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("; th: ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(th);
                this.f2335g = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            if (invokeStaticMethod2 instanceof String) {
                str = (String) invokeStaticMethod2;
            }
            return i;
        }
        str = null;
        this.f2335g = str;
        return i;
    }

    /* renamed from: c */
    private void m2300c() {
        this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    /* renamed from: d */
    private void m2299d() {
        this.f2333e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 44115);
    }

    /* renamed from: a */
    public String m2306a() {
        String str = null;
        Object invokeStaticMethod = this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, true, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f2333e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String.valueOf(invokeStaticMethod), " ReaderPackName=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsReaderView.gReaderPackName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" ReaderPackVersion=");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(TbsReaderView.gReaderPackVersion);
            str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m2305a(Context context) {
        boolean z;
        Map<String, Object> map = QbSdk.f1754o;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                z = ((Boolean) obj).booleanValue();
                if (z) {
                    return;
                }
                C1465m.m2021b(context);
                return;
            }
        }
        z = true;
        if (z) {
        }
    }

    /* renamed from: a */
    public void m2304a(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f2329a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (StubApp.getOrigApplicationContext(this.f2330b.getApplicationContext()) != null) {
            this.f2330b = StubApp.getOrigApplicationContext(this.f2330b.getApplicationContext());
        }
        this.f2331c = str;
        this.f2332d = strArr;
        this.f2334f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        Map<String, Object> map = QbSdk.f1754o;
        if (map != null) {
            this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, map);
        }
        int m2301b = m2301b(context);
        if (m2301b >= 0) {
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("continueInit init error: ", m2301b, "; msg: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2335g);
        throw new Exception(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
    }

    /* renamed from: a */
    public boolean m2303a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.f2333e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    /* renamed from: b */
    public DexLoader m2302b() {
        return this.f2333e;
    }
}
