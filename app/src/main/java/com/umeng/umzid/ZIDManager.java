package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.p038qq.p039e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.stub.StubApp;
import com.umeng.analytics.pro.C1543ak;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.C1783b;
import com.umeng.commonsdk.statistics.idtracking.C1788f;
import com.umeng.commonsdk.statistics.idtracking.C1789g;
import com.umeng.commonsdk.statistics.idtracking.C1790h;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import org.litepal.crud.LitePalSupport;
import org.litepal.parser.LitePalParser;

/* loaded from: classes4.dex */
public class ZIDManager {

    /* renamed from: c */
    public static ZIDManager f4331c;

    /* renamed from: a */
    public boolean f4332a = false;

    /* renamed from: b */
    public boolean f4333b = false;

    /* renamed from: com.umeng.umzid.ZIDManager$a */
    /* loaded from: classes4.dex */
    public class RunnableC1856a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f4334a;

        /* renamed from: b */
        public final /* synthetic */ IZIDCompletionCallback f4335b;

        public RunnableC1856a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.f4334a = context;
            this.f4335b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String m206a = ZIDManager.m206a(ZIDManager.this, this.f4334a);
            if (TextUtils.isEmpty(m206a)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f4335b;
                if (iZIDCompletionCallback == null) {
                    return;
                }
                iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f4335b;
            if (iZIDCompletionCallback2 == null) {
                return;
            }
            iZIDCompletionCallback2.onSuccess(m206a);
        }
    }

    /* renamed from: com.umeng.umzid.ZIDManager$b */
    /* loaded from: classes4.dex */
    public class RunnableC1857b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f4337a;

        public RunnableC1857b(Context context) {
            this.f4337a = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x00b0 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #0 {all -> 0x0108, blocks: (B:60:0x001a, B:62:0x0020, B:6:0x0027, B:9:0x0037, B:11:0x003d, B:13:0x0047, B:14:0x004d, B:17:0x005d, B:19:0x0063, B:21:0x006d, B:22:0x0073, B:25:0x008d, B:27:0x0093, B:28:0x0099, B:31:0x00a0, B:33:0x00a6, B:34:0x00aa, B:36:0x00b0, B:38:0x00b5, B:40:0x00c3, B:42:0x00d8, B:44:0x00eb, B:45:0x00ee, B:47:0x00f8, B:48:0x00fb, B:50:0x0105), top: B:59:0x001a }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00c3 A[Catch: all -> 0x0108, TryCatch #0 {all -> 0x0108, blocks: (B:60:0x001a, B:62:0x0020, B:6:0x0027, B:9:0x0037, B:11:0x003d, B:13:0x0047, B:14:0x004d, B:17:0x005d, B:19:0x0063, B:21:0x006d, B:22:0x0073, B:25:0x008d, B:27:0x0093, B:28:0x0099, B:31:0x00a0, B:33:0x00a6, B:34:0x00aa, B:36:0x00b0, B:38:0x00b5, B:40:0x00c3, B:42:0x00d8, B:44:0x00eb, B:45:0x00ee, B:47:0x00f8, B:48:0x00fb, B:50:0x0105), top: B:59:0x001a }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            SharedPreferences m205a;
            String string;
            String str;
            String str2;
            String m204a;
            SharedPreferences m205a2;
            SharedPreferences m205a3;
            SharedPreferences m205a4;
            SharedPreferences m205a5;
            ZIDManager zIDManager = ZIDManager.this;
            Context context = this.f4337a;
            if (zIDManager.f4333b) {
                return;
            }
            zIDManager.f4333b = true;
            JSONObject jSONObject = new JSONObject();
            String str3 = "";
            if (context != null) {
                try {
                    m205a = C1859a.m205a(context);
                } catch (Throwable unused) {
                }
                if (m205a != null) {
                    string = m205a.getString("zdata", null);
                    String id = Spy.getID();
                    jSONObject.put("zdata", id);
                    jSONObject.put("old_zdata", string);
                    if (context != null || (m205a5 = C1859a.m205a(context)) == null) {
                        str = str3;
                    } else {
                        str = m205a5.getString(C1790h.f4114d, str3);
                        if (C1863c.m193c(str)) {
                            str = C1863c.m199a(str);
                        }
                    }
                    String m195c = C1863c.m195c(context);
                    jSONObject.put("old_oaid", str);
                    jSONObject.put(C1790h.f4114d, m195c);
                    if (context != null || (m205a4 = C1859a.m205a(context)) == null) {
                        str2 = str3;
                    } else {
                        str2 = m205a4.getString(C1789g.f4109a, str3);
                        if (C1863c.m193c(str2)) {
                            str2 = C1863c.m199a(str2);
                        }
                    }
                    String m198b = C1863c.m198b(context);
                    jSONObject.put(C1789g.f4109a, m198b);
                    jSONObject.put("old_mac", str2);
                    zIDManager.m207a(context, jSONObject);
                    jSONObject.put("aaid", C1863c.m201a(context));
                    jSONObject.put("uabc", (context != null || (m205a3 = C1859a.m205a(context)) == null) ? str3 : m205a3.getString("uabc", str3));
                    if (context != null && (m205a2 = C1859a.m205a(context)) != null) {
                        str3 = m205a2.getString("resetToken", str3);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("resetToken", str3);
                    }
                    m204a = C1859a.m204a("https://aaid.umeng.com/api/updateZdata", jSONObject.toString());
                    if (!TextUtils.isEmpty(m204a)) {
                        JSONObject jSONObject2 = new JSONObject(m204a);
                        if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                            C1863c.m190f(context, id);
                            C1863c.m200a(context, m198b);
                            C1863c.m197b(context, m195c);
                            String optString = jSONObject2.optString("aaid");
                            if (!TextUtils.isEmpty(optString)) {
                                C1863c.m191e(context, optString);
                            }
                            String string2 = jSONObject2.getString("uabc");
                            if (!TextUtils.isEmpty(string2)) {
                                C1863c.m192d(context, string2);
                            }
                            String string3 = jSONObject2.getString("resetToken");
                            if (!TextUtils.isEmpty(string3)) {
                                C1863c.m194c(context, string3);
                            }
                        }
                    }
                    zIDManager.f4333b = false;
                }
            }
            string = str3;
            String id2 = Spy.getID();
            jSONObject.put("zdata", id2);
            jSONObject.put("old_zdata", string);
            if (context != null) {
            }
            str = str3;
            String m195c2 = C1863c.m195c(context);
            jSONObject.put("old_oaid", str);
            jSONObject.put(C1790h.f4114d, m195c2);
            if (context != null) {
            }
            str2 = str3;
            String m198b2 = C1863c.m198b(context);
            jSONObject.put(C1789g.f4109a, m198b2);
            jSONObject.put("old_mac", str2);
            zIDManager.m207a(context, jSONObject);
            jSONObject.put("aaid", C1863c.m201a(context));
            jSONObject.put("uabc", (context != null || (m205a3 = C1859a.m205a(context)) == null) ? str3 : m205a3.getString("uabc", str3));
            if (context != null) {
                str3 = m205a2.getString("resetToken", str3);
            }
            if (!TextUtils.isEmpty(str3)) {
            }
            m204a = C1859a.m204a("https://aaid.umeng.com/api/updateZdata", jSONObject.toString());
            if (!TextUtils.isEmpty(m204a)) {
            }
            zIDManager.f4333b = false;
        }
    }

    /* renamed from: com.umeng.umzid.ZIDManager$c */
    /* loaded from: classes4.dex */
    public class RunnableC1858c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f4339a;

        public RunnableC1858c(Context context) {
            this.f4339a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.m206a(ZIDManager.this, this.f4339a);
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m206a(ZIDManager zIDManager, Context context) {
        String str = null;
        if (!zIDManager.f4332a) {
            zIDManager.f4332a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put("zdata", id);
                String m198b = C1863c.m198b(context);
                jSONObject.put(C1789g.f4109a, m198b);
                String m195c = C1863c.m195c(context);
                jSONObject.put(C1790h.f4114d, m195c);
                zIDManager.m207a(context, jSONObject);
                String m204a = C1859a.m204a("https://aaid.umeng.com/api/postZdata", jSONObject.toString());
                if (!TextUtils.isEmpty(m204a)) {
                    JSONObject jSONObject2 = new JSONObject(m204a);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        C1863c.m190f(context, id);
                        C1863c.m200a(context, m198b);
                        C1863c.m197b(context, m195c);
                        str = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            C1863c.m191e(context, str);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            C1863c.m192d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            C1863c.m194c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.f4332a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f4331c == null) {
                f4331c = new ZIDManager();
            }
            zIDManager = f4331c;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.4.1";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(47:1|(4:2|3|4|5)|(2:7|(43:11|12|(1:118)(1:16)|(1:18)|19|(5:106|107|(2:114|115)|109|(37:111|22|23|24|25|26|(2:28|(30:32|33|34|35|36|37|(3:87|88|(5:90|91|(2:94|92)|95|96))|39|(1:41)(1:86)|42|(1:44)(1:85)|45|46|47|48|49|50|51|52|53|54|(1:58)|59|60|61|62|63|(2:65|(2:69|70))|72|73))|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(2:56|58)|59|60|61|62|63|(0)|72|73))|21|22|23|24|25|26|(0)|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(0)|59|60|61|62|63|(0)|72|73))|120|12|(1:14)|118|(0)|19|(0)|21|22|23|24|25|26|(0)|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(0)|59|60|61|62|63|(0)|72|73) */
    /* JADX WARN: Can't wrap try/catch for region: R(50:1|2|3|4|5|(2:7|(43:11|12|(1:118)(1:16)|(1:18)|19|(5:106|107|(2:114|115)|109|(37:111|22|23|24|25|26|(2:28|(30:32|33|34|35|36|37|(3:87|88|(5:90|91|(2:94|92)|95|96))|39|(1:41)(1:86)|42|(1:44)(1:85)|45|46|47|48|49|50|51|52|53|54|(1:58)|59|60|61|62|63|(2:65|(2:69|70))|72|73))|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(2:56|58)|59|60|61|62|63|(0)|72|73))|21|22|23|24|25|26|(0)|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(0)|59|60|61|62|63|(0)|72|73))|120|12|(1:14)|118|(0)|19|(0)|21|22|23|24|25|26|(0)|104|33|34|35|36|37|(0)|39|(0)(0)|42|(0)(0)|45|46|47|48|49|50|51|52|53|54|(0)|59|60|61|62|63|(0)|72|73) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0135, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b9, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ba, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a0, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a1, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x017d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x017e, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3 A[Catch: all -> 0x00d7, TryCatch #6 {all -> 0x00d7, blocks: (B:24:0x00b1, B:26:0x00b7, B:28:0x00c3, B:30:0x00d0, B:32:0x00d4), top: B:23:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e6 A[Catch: all -> 0x01fa, TryCatch #7 {all -> 0x01fa, blocks: (B:61:0x01d4, B:63:0x01da, B:65:0x01e6, B:67:0x01f3, B:69:0x01f7), top: B:60:0x01d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject m207a(Context context, JSONObject jSONObject) {
        Object obj;
        String externalStorageState;
        Locale locale;
        int rawOffset;
        Object obj2;
        String str;
        Method declaredMethod;
        SharedPreferences m205a;
        Method declaredMethod2;
        Class<?> cls;
        Method declaredMethod3;
        String str2 = "";
        jSONObject.putOpt("zdata_ver", Spy.getVersion());
        try {
            cls = Class.forName(DeviceConfig.LOG_TAG);
            declaredMethod3 = cls.getDeclaredMethod("getAndroidId", Context.class);
        } catch (Throwable unused) {
        }
        if (declaredMethod3 != null) {
            declaredMethod3.setAccessible(true);
            Object invoke = declaredMethod3.invoke(cls, context);
            if (invoke != null && (invoke instanceof String)) {
                obj = (String) invoke;
                jSONObject.putOpt(C1783b.f4089a, obj);
                long j = 0;
                externalStorageState = Environment.getExternalStorageState();
                if (!"mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
                    j = Environment.getExternalStorageDirectory().getFreeSpace();
                }
                jSONObject.putOpt(LitePalParser.NODE_STORAGE, Long.valueOf(j));
                jSONObject.putOpt(C1543ak.f3054y, Build.VERSION.RELEASE);
                Object obj3 = null;
                if (context != null) {
                    try {
                        Configuration configuration = new Configuration();
                        configuration.setToDefaults();
                        Settings.System.getConfiguration(context.getContentResolver(), configuration);
                        locale = configuration.locale;
                    } catch (Throwable unused2) {
                        locale = null;
                    }
                    if (locale == null) {
                        try {
                            locale = Locale.getDefault();
                        } catch (Throwable unused3) {
                        }
                    }
                    Calendar calendar = Calendar.getInstance(locale);
                    if (calendar != null) {
                        rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
                        jSONObject.putOpt(C1543ak.f2949M, Integer.valueOf(rawOffset));
                        jSONObject.putOpt("model", Build.MODEL);
                        Class<?> cls2 = Class.forName(DeviceConfig.LOG_TAG);
                        declaredMethod2 = cls2.getDeclaredMethod("getImeiNew", Context.class);
                        if (declaredMethod2 != null) {
                            declaredMethod2.setAccessible(true);
                            Object invoke2 = declaredMethod2.invoke(cls2, context);
                            if (invoke2 != null && (invoke2 instanceof String)) {
                                obj2 = (String) invoke2;
                                jSONObject.putOpt(C1788f.f4107a, obj2);
                                Method declaredMethod4 = Build.class.getDeclaredMethod("getString", String.class);
                                declaredMethod4.setAccessible(true);
                                str = declaredMethod4.invoke(null, "net.hostname").toString();
                                if (str != null) {
                                    try {
                                        if (!str.equalsIgnoreCase(str2)) {
                                            try {
                                                MessageDigest messageDigest = MessageDigest.getInstance(LitePalSupport.MD5);
                                                messageDigest.update(str.getBytes());
                                                byte[] digest = messageDigest.digest();
                                                StringBuffer stringBuffer = new StringBuffer();
                                                for (byte b : digest) {
                                                    stringBuffer.append(Integer.toHexString(b & 255));
                                                }
                                                str = stringBuffer.toString();
                                            } catch (Throwable unused4) {
                                                str = str2;
                                            }
                                        }
                                    } catch (Exception unused5) {
                                    }
                                }
                                jSONObject.putOpt("hostname", str);
                                jSONObject.putOpt("sdk_version", "1.4.1");
                                jSONObject.putOpt(C1543ak.f3044o, context != null ? null : context.getPackageName());
                                jSONObject.putOpt(C1543ak.f3050u, "Android");
                                SharedPreferences m205a2 = C1859a.m205a(context);
                                jSONObject.putOpt("uuid", m205a2 == null ? m205a2.getString("uuid", str2) : str2);
                                jSONObject.putOpt("source_id", "umeng");
                                Object obj4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                                jSONObject.putOpt("app_version", obj4);
                                Object obj5 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                                jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, obj5);
                                Object obj6 = context.getResources().getConfiguration().locale.getCountry();
                                jSONObject.putOpt(C1543ak.f2951O, obj6);
                                if (context != null && (m205a = C1859a.m205a(context)) != null) {
                                    obj3 = m205a.getString("appkey", null);
                                }
                                jSONObject.putOpt("appkey", obj3);
                                Class<?> cls3 = Class.forName(DeviceConfig.LOG_TAG);
                                declaredMethod = cls3.getDeclaredMethod("getIdfa", Context.class);
                                if (declaredMethod != null) {
                                    declaredMethod.setAccessible(true);
                                    Object invoke3 = declaredMethod.invoke(cls3, context);
                                    if (invoke3 != null && (invoke3 instanceof String)) {
                                        str2 = (String) invoke3;
                                    }
                                }
                                jSONObject.putOpt("gaid", str2);
                                return jSONObject;
                            }
                        }
                        obj2 = str2;
                        jSONObject.putOpt(C1788f.f4107a, obj2);
                        Method declaredMethod42 = Build.class.getDeclaredMethod("getString", String.class);
                        declaredMethod42.setAccessible(true);
                        str = declaredMethod42.invoke(null, "net.hostname").toString();
                        if (str != null) {
                        }
                        jSONObject.putOpt("hostname", str);
                        jSONObject.putOpt("sdk_version", "1.4.1");
                        jSONObject.putOpt(C1543ak.f3044o, context != null ? null : context.getPackageName());
                        jSONObject.putOpt(C1543ak.f3050u, "Android");
                        SharedPreferences m205a22 = C1859a.m205a(context);
                        jSONObject.putOpt("uuid", m205a22 == null ? m205a22.getString("uuid", str2) : str2);
                        jSONObject.putOpt("source_id", "umeng");
                        Object obj42 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        jSONObject.putOpt("app_version", obj42);
                        Object obj52 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                        jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, obj52);
                        Object obj62 = context.getResources().getConfiguration().locale.getCountry();
                        jSONObject.putOpt(C1543ak.f2951O, obj62);
                        if (context != null) {
                            obj3 = m205a.getString("appkey", null);
                        }
                        jSONObject.putOpt("appkey", obj3);
                        Class<?> cls32 = Class.forName(DeviceConfig.LOG_TAG);
                        declaredMethod = cls32.getDeclaredMethod("getIdfa", Context.class);
                        if (declaredMethod != null) {
                        }
                        jSONObject.putOpt("gaid", str2);
                        return jSONObject;
                    }
                }
                rawOffset = 8;
                jSONObject.putOpt(C1543ak.f2949M, Integer.valueOf(rawOffset));
                jSONObject.putOpt("model", Build.MODEL);
                Class<?> cls22 = Class.forName(DeviceConfig.LOG_TAG);
                declaredMethod2 = cls22.getDeclaredMethod("getImeiNew", Context.class);
                if (declaredMethod2 != null) {
                }
                obj2 = str2;
                jSONObject.putOpt(C1788f.f4107a, obj2);
                Method declaredMethod422 = Build.class.getDeclaredMethod("getString", String.class);
                declaredMethod422.setAccessible(true);
                str = declaredMethod422.invoke(null, "net.hostname").toString();
                if (str != null) {
                }
                jSONObject.putOpt("hostname", str);
                jSONObject.putOpt("sdk_version", "1.4.1");
                jSONObject.putOpt(C1543ak.f3044o, context != null ? null : context.getPackageName());
                jSONObject.putOpt(C1543ak.f3050u, "Android");
                SharedPreferences m205a222 = C1859a.m205a(context);
                jSONObject.putOpt("uuid", m205a222 == null ? m205a222.getString("uuid", str2) : str2);
                jSONObject.putOpt("source_id", "umeng");
                Object obj422 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                jSONObject.putOpt("app_version", obj422);
                Object obj522 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, obj522);
                Object obj622 = context.getResources().getConfiguration().locale.getCountry();
                jSONObject.putOpt(C1543ak.f2951O, obj622);
                if (context != null) {
                }
                jSONObject.putOpt("appkey", obj3);
                Class<?> cls322 = Class.forName(DeviceConfig.LOG_TAG);
                declaredMethod = cls322.getDeclaredMethod("getIdfa", Context.class);
                if (declaredMethod != null) {
                }
                jSONObject.putOpt("gaid", str2);
                return jSONObject;
            }
        }
        obj = str2;
        jSONObject.putOpt(C1783b.f4089a, obj);
        long j2 = 0;
        externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
        }
        jSONObject.putOpt(LitePalParser.NODE_STORAGE, Long.valueOf(j2));
        jSONObject.putOpt(C1543ak.f3054y, Build.VERSION.RELEASE);
        Object obj32 = null;
        if (context != null) {
        }
        rawOffset = 8;
        jSONObject.putOpt(C1543ak.f2949M, Integer.valueOf(rawOffset));
        jSONObject.putOpt("model", Build.MODEL);
        Class<?> cls222 = Class.forName(DeviceConfig.LOG_TAG);
        declaredMethod2 = cls222.getDeclaredMethod("getImeiNew", Context.class);
        if (declaredMethod2 != null) {
        }
        obj2 = str2;
        jSONObject.putOpt(C1788f.f4107a, obj2);
        Method declaredMethod4222 = Build.class.getDeclaredMethod("getString", String.class);
        declaredMethod4222.setAccessible(true);
        str = declaredMethod4222.invoke(null, "net.hostname").toString();
        if (str != null) {
        }
        jSONObject.putOpt("hostname", str);
        jSONObject.putOpt("sdk_version", "1.4.1");
        jSONObject.putOpt(C1543ak.f3044o, context != null ? null : context.getPackageName());
        jSONObject.putOpt(C1543ak.f3050u, "Android");
        SharedPreferences m205a2222 = C1859a.m205a(context);
        jSONObject.putOpt("uuid", m205a2222 == null ? m205a2222.getString("uuid", str2) : str2);
        jSONObject.putOpt("source_id", "umeng");
        Object obj4222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        jSONObject.putOpt("app_version", obj4222);
        Object obj5222 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, obj5222);
        Object obj6222 = context.getResources().getConfiguration().locale.getCountry();
        jSONObject.putOpt(C1543ak.f2951O, obj6222);
        if (context != null) {
        }
        jSONObject.putOpt("appkey", obj32);
        Class<?> cls3222 = Class.forName(DeviceConfig.LOG_TAG);
        declaredMethod = cls3222.getDeclaredMethod("getIdfa", Context.class);
        if (declaredMethod != null) {
        }
        jSONObject.putOpt("gaid", str2);
        return jSONObject;
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String m201a = C1863c.m201a(origApplicationContext);
        if (!TextUtils.isEmpty(m201a)) {
            return m201a;
        }
        C1861b.m202a(new RunnableC1858c(origApplicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0071 A[Catch: all -> 0x00a0, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000e, B:12:0x0016, B:15:0x001f, B:18:0x002b, B:20:0x0031, B:22:0x0037, B:24:0x003d, B:25:0x0046, B:27:0x004c, B:30:0x0053, B:32:0x005d, B:33:0x0069, B:35:0x0071, B:36:0x0079, B:38:0x007f, B:42:0x0091, B:47:0x0061), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007f A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:9:0x000e, B:12:0x0016, B:15:0x001f, B:18:0x002b, B:20:0x0031, B:22:0x0037, B:24:0x003d, B:25:0x0046, B:27:0x004c, B:30:0x0053, B:32:0x005d, B:33:0x0069, B:35:0x0071, B:36:0x0079, B:38:0x007f, B:42:0x0091, B:47:0x0061), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        String str2;
        SharedPreferences m205a;
        SharedPreferences m205a2;
        SharedPreferences.Editor edit;
        if (context == null) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure("1001", "传入参数Context为null");
            }
        } else if (TextUtils.isEmpty(str)) {
            if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onFailure("1003", "传入参数appkey为空");
            }
        } else {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null && str != null && !TextUtils.isEmpty(str) && (m205a2 = C1859a.m205a(origApplicationContext)) != null && (edit = m205a2.edit()) != null) {
                edit.putString("appkey", str).commit();
            }
            String m201a = C1863c.m201a(origApplicationContext);
            if (m201a != null && !TextUtils.isEmpty(m201a)) {
                C1861b.m202a(new RunnableC1857b(origApplicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(m201a);
                }
                str2 = "";
                m205a = C1859a.m205a(context);
                if (m205a != null) {
                    str2 = m205a.getString("uuid", "");
                }
                if (TextUtils.isEmpty(str2)) {
                    String str3 = "";
                    SharedPreferences m205a3 = C1859a.m205a(context);
                    try {
                        str3 = UUID.randomUUID().toString();
                    } catch (Throwable unused) {
                    }
                    if (m205a3 != null) {
                        m205a3.edit().putString("uuid", str3).commit();
                    }
                }
            }
            C1861b.m202a(new RunnableC1856a(origApplicationContext, iZIDCompletionCallback));
            str2 = "";
            m205a = C1859a.m205a(context);
            if (m205a != null) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
        }
    }
}
