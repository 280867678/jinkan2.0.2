package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C1636i;
import com.umeng.analytics.vshelper.AbstractC1684a;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.v */
/* loaded from: classes4.dex */
public class C1666v {

    /* renamed from: c */
    public static final int f3652c = 5;

    /* renamed from: d */
    public static JSONArray f3653d = new JSONArray();

    /* renamed from: e */
    public static Object f3654e = new Object();

    /* renamed from: f */
    public final Map<String, Long> f3657f = new HashMap();

    /* renamed from: a */
    public Stack<String> f3655a = new Stack<>();

    /* renamed from: b */
    public AbstractC1684a f3656b = PageNameMonitor.getInstance();

    /* renamed from: a */
    public static void m879a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f3654e) {
                    jSONArray = f3653d.toString();
                    f3653d = new JSONArray();
                }
                if (jSONArray.length() <= 0) {
                    return;
                }
                jSONObject.put("__a", new JSONArray(jSONArray));
                if (jSONObject.length() <= 0) {
                    return;
                }
                C1636i.m1056a(context).m1050a(C1663u.m899a().m887c(), jSONObject, C1636i.EnumC1638a.PAGE);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public int mo880a() {
        return 2;
    }

    /* renamed from: a */
    public void m878a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog() && this.f3655a.size() != 0) {
                UMLog.m771aq(C1640j.f3461F, 0, "\\|", new String[]{"@"}, new String[]{this.f3655a.peek()}, null, null);
            }
            this.f3656b.customPageBegin(str);
            synchronized (this.f3657f) {
                this.f3657f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.f3655a.push(str);
                }
            }
        }
    }

    /* renamed from: b */
    public void m877b() {
        String str;
        synchronized (this.f3657f) {
            str = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f3657f.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                }
            }
        }
        if (str != null) {
            m876b(str);
        }
    }

    /* renamed from: b */
    public void m876b(String str) {
        Long l;
        Context appContext;
        if (!TextUtils.isEmpty(str)) {
            if (!this.f3657f.containsKey(str)) {
                if (!UMConfigure.isDebugLog() || this.f3655a.size() != 0) {
                    return;
                }
                UMLog.m771aq(C1640j.f3462G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            synchronized (this.f3657f) {
                l = this.f3657f.get(str);
            }
            if (l == null) {
                return;
            }
            if (UMConfigure.isDebugLog() && this.f3655a.size() > 0 && str.equals(this.f3655a.peek())) {
                this.f3655a.pop();
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (f3654e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C1615d.f3356v, str);
                    jSONObject.put("duration", currentTimeMillis);
                    jSONObject.put(C1615d.f3358x, l);
                    jSONObject.put("type", mo880a());
                    f3653d.put(jSONObject);
                    if (f3653d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                        UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                    }
                } catch (Throwable unused) {
                }
            }
            if (!UMConfigure.isDebugLog() || this.f3655a.size() == 0) {
                return;
            }
            UMLog.m771aq(C1640j.f3460E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
        }
    }
}
