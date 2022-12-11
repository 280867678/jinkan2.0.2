package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C1528aa;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.analytics.pro.C1551am;
import com.umeng.analytics.pro.C1552an;
import com.umeng.analytics.pro.C1553ao;
import com.umeng.analytics.pro.C1642l;
import com.umeng.analytics.pro.C1648o;
import com.umeng.commonsdk.C1697a;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.SelfChecker;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.stateless.C1754b;
import com.umeng.commonsdk.stateless.C1759d;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import com.umeng.commonsdk.utils.C1847b;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.commonsdk.vchannel.C1849b;
import com.umeng.commonsdk.vchannel.Sender;
import java.io.File;
import java.lang.reflect.Method;
import me.tvspark.outline;
import org.json.JSONObject;

/* renamed from: com.umeng.commonsdk.internal.c */
/* loaded from: classes4.dex */
public class C1726c implements UMLogDataProtocol {

    /* renamed from: a */
    public static final String f3928a = "um_policy_grant";

    /* renamed from: b */
    public static final String f3929b = "preInitInvokedFlag";

    /* renamed from: c */
    public static final String f3930c = "policyGrantInvokedFlag";

    /* renamed from: d */
    public static final String f3931d = "policyGrantResult";

    /* renamed from: f */
    public static int f3932f = 1;

    /* renamed from: g */
    public static final String f3933g = "info";

    /* renamed from: h */
    public static final String f3934h = "stat";

    /* renamed from: i */
    public static Class<?> f3935i;

    /* renamed from: j */
    public static Method f3936j;

    /* renamed from: k */
    public static Method f3937k;

    /* renamed from: l */
    public static Method f3938l;

    /* renamed from: m */
    public static boolean f3939m;

    /* renamed from: e */
    public Context f3940e;

    static {
        m721c();
    }

    public C1726c(Context context) {
        if (context != null) {
            this.f3940e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    /* renamed from: a */
    public static Class<?> m724a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private void m727a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put("app_version", UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(C1543ak.f3053x, "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m726a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String m1399a = C1528aa.m1399a(origApplicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(m1399a);
                }
            }
        }).start();
    }

    /* renamed from: b */
    public static String m723b() {
        Method method;
        Class<?> cls = f3935i;
        if (cls == null || (method = f3936j) == null || f3938l == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) f3938l.invoke(invoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: b */
    public static void m722b(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(C1790h.f4111a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String m1399a = C1528aa.m1399a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(m1399a) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(C1790h.f4113c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(C1790h.f4112b, m1399a);
                        edit2.commit();
                    }
                    if (Build.VERSION.SDK_INT <= 28) {
                        return;
                    }
                    UMConfigureImpl.removeInterruptFlag();
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* renamed from: c */
    public static void m721c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            f3935i = cls;
            Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod != null) {
                f3936j = declaredMethod;
            }
            Method declaredMethod2 = f3935i.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f3937k = declaredMethod2;
            }
            Method declaredMethod3 = f3935i.getDeclaredMethod("getSDKVersion", new Class[0]);
            if (declaredMethod3 == null) {
                return;
            }
            f3938l = declaredMethod3;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static void m720c(final Context context) {
        if (!FieldManager.allow(C1847b.f4256G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        m726a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
            @Override // com.umeng.commonsdk.listener.OnGetOaidListener
            public void onGetOaid(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(C1790h.f4111a, 0);
                    if (sharedPreferences == null || sharedPreferences.getString(C1790h.f4112b, "").equalsIgnoreCase(str)) {
                        return;
                    }
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(C1790h.f4112b, str);
                    edit.commit();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* renamed from: d */
    private void m719d() {
        C1551am m1296a = C1551am.m1296a(this.f3940e);
        C1552an m1294a = m1296a.m1294a(C1553ao.f3114c);
        if (m1294a != null) {
            UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = m1294a.f3106a;
                JSONObject m590a = new C1767b().m590a(StubApp.getOrigApplicationContext(this.f3940e.getApplicationContext()), new JSONObject(m1294a.f3108c), new JSONObject(m1294a.f3109d), m1294a.f3110e, m1294a.f3107b, m1294a.f3111f);
                UMRTLog.m767e(UMRTLog.RTLOG_TAG, (m590a == null || !m590a.has("exception")) ? "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。" : "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                m1296a.m1292a(C1553ao.f3114c, str);
                m1296a.m1289b();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    private void m718d(Context context) {
        Object invoke;
        Method declaredMethod;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> m724a = m724a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = m724a.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(m724a, new Object[0])) == null || (declaredMethod = m724a.getDeclaredMethod("init", Context.class, String.class, m724a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, origApplicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    private void m717e() {
        if (f3939m) {
            if (FieldManager.allow(C1847b.f4256G)) {
                return;
            }
            f3939m = false;
        } else if (!FieldManager.allow(C1847b.f4256G) || Build.VERSION.SDK_INT <= 28) {
        } else {
            f3939m = true;
            m726a(this.f3940e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = C1726c.this.f3940e.getSharedPreferences(C1790h.f4111a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(C1790h.f4112b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(C1726c.this.f3940e, C1724a.f3921w, C1725b.m729a(C1726c.this.f3940e).m730a(), null);
                }
            });
        }
    }

    /* renamed from: e */
    public static void m716e(Context context) {
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(filesDir.getAbsolutePath());
        File file = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, C1553ao.f3123l));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: f */
    private void m715f() {
        if (!FieldManager.allow(C1847b.f4256G) || Build.VERSION.SDK_INT <= 28) {
            return;
        }
        f3939m = true;
        UMConfigureImpl.registerInterruptFlag();
        UMConfigureImpl.init(this.f3940e);
        f3932f++;
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
        UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
            @Override // com.umeng.commonsdk.utils.onMessageSendListener
            public void onMessageSend() {
                if (C1726c.this.f3940e != null) {
                    UMWorkDispatch.sendEvent(C1726c.this.f3940e, C1724a.f3922x, C1725b.m729a(C1726c.this.f3940e).m730a(), null);
                }
                UMConfigureImpl.removeMessageSendListener(this);
            }
        });
        m722b(this.f3940e);
    }

    /* renamed from: g */
    private void m714g() {
        if (f3932f <= 0) {
            m713h();
            m718d(this.f3940e);
        }
    }

    /* renamed from: h */
    private void m713h() {
        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f3940e)) {
            m716e(this.f3940e);
            C1697a.m795a(this.f3940e);
            Context context = this.f3940e;
            UMWorkDispatch.sendEvent(context, C1648o.C1650a.f3607x, CoreProtocol.getInstance(context), null);
            Context context2 = this.f3940e;
            UMWorkDispatch.sendEvent(context2, C1724a.f3918t, C1725b.m729a(context2).m730a(), null);
        }
    }

    /* renamed from: a */
    public String m728a() {
        Method method;
        Class<?> cls = f3935i;
        if (cls == null || (method = f3936j) == null || f3937k == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) f3937k.invoke(invoke, this.f3940e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0196 A[Catch: all -> 0x031e, TryCatch #0 {all -> 0x031e, blocks: (B:4:0x001f, B:9:0x0049, B:16:0x0061, B:18:0x007f, B:20:0x0085, B:21:0x0095, B:23:0x00be, B:29:0x00c8, B:31:0x00cc, B:33:0x00e2, B:52:0x0152, B:54:0x0169, B:56:0x0174, B:59:0x017b, B:61:0x0181, B:63:0x018c, B:67:0x0196, B:69:0x019c, B:72:0x01ad), top: B:2:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ab  */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void workEvent(Object obj, int i) {
        String str;
        SharedPreferences.Editor edit;
        boolean z = true;
        boolean z2 = false;
        ULog.m535i("walle", "[internal] workEvent");
        try {
            switch (i) {
                case 32769:
                    ULog.m535i("walle", "[internal] workEvent send envelope");
                    Class<?> cls = Class.forName("com.umeng.commonsdk.internal.UMInternalManagerAgent");
                    cls.getMethod("sendInternalEnvelopeByStateful2", Context.class).invoke(cls, this.f3940e);
                    return;
                case C1724a.f3905g /* 32770 */:
                case C1724a.f3907i /* 32772 */:
                case 32773:
                case 32778:
                case 32780:
                case C1724a.f3915q /* 32782 */:
                case C1724a.f3916r /* 32783 */:
                case 32789:
                case 32794:
                case 32795:
                case 32796:
                case 32797:
                case 32798:
                case 32799:
                default:
                    return;
                case C1724a.f3906h /* 32771 */:
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("[internal] workEvent cache battery, event is ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(obj.toString());
                    ULog.m535i("walle", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                    Class<?> cls2 = Class.forName("com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent");
                    cls2.getMethod("saveBattery", Context.class, String.class).invoke(cls2, this.f3940e, (String) obj);
                    return;
                case C1724a.f3909k /* 32774 */:
                    Class<?> cls3 = Class.forName("com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent");
                    cls3.getMethod("wifiChange", Context.class).invoke(cls3, this.f3940e);
                    return;
                case C1724a.f3910l /* 32775 */:
                    Class<?> cls4 = Class.forName("com.umeng.commonsdk.internal.utils.InfoPreferenceAgent");
                    cls4.getMethod("saveUA", Context.class, String.class).invoke(cls4, this.f3940e, (String) obj);
                    return;
                case C1724a.f3911m /* 32776 */:
                    SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(this.f3940e.getApplicationContext()).getSharedPreferences("info", 0);
                    if (sharedPreferences == null) {
                        return;
                    }
                    sharedPreferences.edit().putString(f3934h, (String) obj).commit();
                    return;
                case C1724a.f3912n /* 32777 */:
                    ULog.m535i("walle", "[internal] workEvent send envelope");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C1543ak.f2976aM, C1724a.f3903e);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(C1543ak.f3010au, new JSONObject());
                    JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.f3940e, jSONObject, jSONObject2);
                    if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                        return;
                    }
                    ULog.m535i("walle", "[internal] workEvent send envelope back, result is ok");
                    return;
                case C1724a.f3913o /* 32779 */:
                    Sender.handleEvent(this.f3940e, (C1849b) obj);
                    return;
                case C1724a.f3914p /* 32781 */:
                    if (UMFrUtils.hasEnvelopeFile(this.f3940e, UMLogDataProtocol.UMBusinessType.U_ZeroEnv)) {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 零号报文信封文件已存在，尝试发送之!");
                        return;
                    }
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文");
                    m727a(this.f3940e);
                    return;
                case C1724a.f3917s /* 32784 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 零号报文流程，接收到云控配置加载成功通知(成功收到零号报文应答)。");
                    m715f();
                    break;
                case C1724a.f3918t /* 32785 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]接收到消费二级缓存数据通知.");
                    if (C1551am.m1296a(this.f3940e).m1286c()) {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> [有状态]已消费完毕,二级缓存数据库为空.");
                        return;
                    }
                    m719d();
                    if (UMWorkDispatch.eventHasExist(C1724a.f3918t)) {
                        return;
                    }
                    Context context = this.f3940e;
                    UMWorkDispatch.sendEvent(context, C1724a.f3918t, C1725b.m729a(context).m730a(), null);
                    return;
                case C1724a.f3919u /* 32786 */:
                    UMCrashManager.buildEnvelope(this.f3940e, obj);
                    return;
                case C1724a.f3920v /* 32787 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 触发2号仓遗留信封检查动作。");
                    String m614a = C1759d.m614a(this.f3940e, false);
                    String m614a2 = C1759d.m614a(this.f3940e, true);
                    if (!TextUtils.isEmpty(m614a)) {
                        File file = new File(m614a);
                        if (file.exists() && file.isDirectory()) {
                            z2 = true;
                        }
                    }
                    if (!TextUtils.isEmpty(m614a2)) {
                        File file2 = new File(m614a2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (z) {
                                str = "--->>> 触发2号仓遗留信封检查，没有需要处理的目录，不需要处理。";
                            } else if (!C1754b.m645a()) {
                                new C1754b(this.f3940e);
                                C1754b.m641b();
                                return;
                            } else {
                                str = "--->>> 触发2号仓遗留信封检查，Sender已创建，不需要处理。";
                            }
                            UMRTLog.m767e(UMRTLog.RTLOG_TAG, str);
                            return;
                        }
                    }
                    z = z2;
                    if (z) {
                    }
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, str);
                    return;
                case C1724a.f3921w /* 32788 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新，触发 伪冷启动。");
                    C1767b.m596a();
                    m717e();
                    if (FieldManager.allow(C1847b.f4254E) && !UMWorkDispatch.eventHasExist()) {
                        UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 前台计数器功能 打开，触发 5秒周期检查机制");
                        Context context2 = this.f3940e;
                        UMWorkDispatch.sendEventEx(context2, C1648o.C1650a.f3581C, CoreProtocol.getInstance(context2), null, 5000L);
                    }
                    if (!FieldManager.allow(C1847b.f4255F)) {
                        return;
                    }
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 云控下发参数更新 FirstResume功能 打开，触发 trigger");
                    C1642l.m1019a(this.f3940e).m1012b(this.f3940e);
                    return;
                case C1724a.f3922x /* 32790 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 成功接收到(OAID)读取结束通知。");
                    break;
                case C1724a.f3923y /* 32791 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 正常冷启动流程，接收到云控配置加载成功通知。");
                    m720c(this.f3940e);
                    C1697a.m795a(this.f3940e);
                    m718d(this.f3940e);
                    return;
                case C1724a.f3924z /* 32792 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 保存隐私授权结果.");
                    if (!(obj instanceof Integer)) {
                        return;
                    }
                    int intValue = ((Integer) obj).intValue();
                    SharedPreferences sharedPreferences2 = StubApp.getOrigApplicationContext(this.f3940e.getApplicationContext()).getSharedPreferences(f3928a, 0);
                    if (sharedPreferences2 == null) {
                        return;
                    }
                    sharedPreferences2.edit().putInt("policyGrantResult", intValue).commit();
                    return;
                case C1724a.f3890A /* 32793 */:
                    UMRTLog.m767e(UMRTLog.RTLOG_TAG, "--->>> 保存preInit执行结果及授权API是否调用结果.");
                    if (!(obj instanceof JSONObject)) {
                        return;
                    }
                    JSONObject jSONObject3 = (JSONObject) obj;
                    if (!jSONObject3.has(C1724a.f3896G)) {
                        return;
                    }
                    int i2 = jSONObject3.getInt(C1724a.f3896G);
                    int i3 = jSONObject3.getInt(C1724a.f3897H);
                    int i4 = jSONObject3.getInt("policyGrantResult");
                    SharedPreferences sharedPreferences3 = StubApp.getOrigApplicationContext(this.f3940e.getApplicationContext()).getSharedPreferences(f3928a, 0);
                    if (sharedPreferences3 != null && (edit = sharedPreferences3.edit()) != null) {
                        edit.putInt(f3929b, i2);
                        edit.putInt(f3930c, i3);
                        edit.putInt("policyGrantResult", i4);
                        edit.commit();
                    }
                    File filesDir = this.f3940e.getFilesDir();
                    File file3 = new File(filesDir.getAbsolutePath() + File.separator + C1553ao.f3124m);
                    if (file3.exists()) {
                        return;
                    }
                    file3.createNewFile();
                    return;
                case C1724a.f3891B /* 32800 */:
                    File filesDir2 = this.f3940e.getFilesDir();
                    StringBuilder sb = new StringBuilder();
                    sb.append(filesDir2.getAbsolutePath());
                    File file4 = new File(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb, File.separator, C1553ao.f3124m));
                    if (!file4.exists()) {
                        return;
                    }
                    file4.delete();
                    return;
                case C1724a.f3892C /* 32801 */:
                    SelfChecker.doCheck(this.f3940e);
                    return;
            }
            f3932f--;
            m714g();
        } catch (Throwable unused) {
        }
    }
}
