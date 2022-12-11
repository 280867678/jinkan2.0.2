package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C1648o;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.pro.s */
/* loaded from: classes4.dex */
public class C1659s {

    /* renamed from: a */
    public static final String f3629a = "fs_lc_tl_uapp";

    /* renamed from: f */
    public static final String f3630f = "-1";

    /* renamed from: g */
    public static Context f3631g;

    /* renamed from: b */
    public final int f3632b;

    /* renamed from: c */
    public final int f3633c;

    /* renamed from: d */
    public final int f3634d;

    /* renamed from: e */
    public final int f3635e;

    /* renamed from: h */
    public JSONObject f3636h;

    /* renamed from: com.umeng.analytics.pro.s$a */
    /* loaded from: classes4.dex */
    public static class C1661a {

        /* renamed from: a */
        public static final C1659s f3637a = new C1659s();
    }

    public C1659s() {
        this.f3632b = 128;
        this.f3633c = 256;
        this.f3634d = 1024;
        this.f3635e = 10;
        this.f3636h = null;
        if (0 == 0) {
            try {
                m906b(f3631g);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static C1659s m915a(Context context) {
        if (f3631g == null && context != null) {
            f3631g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C1661a.f3637a;
    }

    /* renamed from: a */
    private JSONObject m907a(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < iArr.length) {
                                        jSONArray.put(iArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < dArr.length) {
                                        jSONArray.put(dArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < jArr.length) {
                                        jSONArray.put(jArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < fArr.length) {
                                        jSONArray.put(fArr[i]);
                                        i++;
                                    }
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    jSONArray = new JSONArray();
                                    while (i < sArr.length) {
                                        jSONArray.put((int) sArr[i]);
                                        i++;
                                    }
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                jSONArray = new JSONArray();
                                while (i < list.size()) {
                                    Object obj = list.get(i);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray.put(list.get(i));
                                    }
                                    i++;
                                }
                                if (jSONArray.length() > 0) {
                                }
                            } else {
                                if (value instanceof String) {
                                    value = HelperUtils.subStr(value.toString(), 256);
                                } else if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.m574e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                            jSONObject.put(subStr, jSONArray);
                        }
                    }
                } catch (Exception e) {
                    MLog.m570e(e);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private void m916a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f3631g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (this.f3636h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f3636h.has(subStr)) {
                        jSONObject.put(subStr, this.f3636h.get(subStr));
                    }
                }
            }
            this.f3636h = new JSONObject();
            if (split.length >= 10) {
                while (i < 10) {
                    m910a(split[i], jSONObject);
                    i++;
                }
            } else {
                while (i < split.length) {
                    m910a(split[i], jSONObject);
                    i++;
                }
            }
            m903c(f3631g);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m910a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        m909a(subStr, jSONObject.has(subStr) ? ((Boolean) jSONObject.get(subStr)).booleanValue() : false);
    }

    /* renamed from: a */
    private void m909a(String str, boolean z) {
        try {
            if (C1615d.f3299Y.equals(str) || C1615d.f3297W.equals(str) || "id".equals(str) || "ts".equals(str) || this.f3636h.has(str)) {
                return;
            }
            this.f3636h.put(str, z);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private boolean m914a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.m574e("key is " + str + ", please check key, illegal");
        return false;
    }

    /* renamed from: b */
    private void m906b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f3629a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f3636h = new JSONObject(string);
            }
            m916a();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    private boolean m905b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.m574e("value is " + str + ", please check value, illegal");
        return false;
    }

    /* renamed from: b */
    private boolean m904b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!m914a(entry.getKey())) {
                            UMLog.m773aq(C1640j.f3507h, 0, "\\|");
                            return false;
                        } else if (entry.getValue() == null) {
                            UMLog.m773aq(C1640j.f3508i, 0, "\\|");
                            return false;
                        } else if (entry.getValue() instanceof String) {
                            if (C1615d.f3306aE.equals(entry.getKey())) {
                                if (!m902c(entry.getValue().toString())) {
                                    UMLog.m773aq(C1640j.f3471P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!m902c(entry.getValue().toString())) {
                                    UMLog.m773aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!m905b(entry.getValue().toString())) {
                                UMLog.m773aq(C1640j.f3509j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.m773aq(C1640j.f3506g, 0, "\\|");
        return false;
    }

    /* renamed from: c */
    private void m903c(Context context) {
        try {
            if (this.f3636h == null) {
                return;
            }
            PreferenceWrapper.getDefault(f3631g).edit().putString(f3629a, this.f3636h.toString()).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m902c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void m913a(String str, String str2, long j, int i, String str3) {
        try {
            if (m914a(str) && m905b(str2)) {
                if (Arrays.asList(C1615d.f3308aG).contains(str)) {
                    MLog.m574e("key is " + str + ", please check key, illegal");
                    UMLog.m773aq(C1640j.f3512m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j > 0) {
                    jSONObject.put(C1615d.f3297W, j);
                }
                jSONObject.put("__t", C1636i.f3436a);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                String m859d = UMUtils.isMainProgress(f3631g) ? C1669y.m870a().m859d(UMGlobalContext.getAppContext(f3631g)) : C1669y.m870a().m866a(UMGlobalContext.getAppContext(f3631g), currentTimeMillis);
                if (TextUtils.isEmpty(m859d)) {
                    m859d = "-1";
                }
                jSONObject.put("__i", m859d);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(C1615d.f3330au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f3631g).getProcessName(f3631g));
                m916a();
                if (this.f3636h != null && this.f3636h.has(str) && !((Boolean) this.f3636h.get(str)).booleanValue()) {
                    jSONObject.put(C1615d.f3299Y, 1);
                    this.f3636h.put(str, true);
                    m903c(f3631g);
                }
                UMWorkDispatch.sendEvent(f3631g, 4097, CoreProtocol.getInstance(f3631g), jSONObject);
                return;
            }
            UMLog.m773aq(C1640j.f3511l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m912a(String str, Map<String, Object> map, long j, String str2, boolean z) {
        Context context;
        int i;
        Context context2;
        JSONArray jSONArray;
        String key;
        try {
            if (!m914a(str)) {
                UMLog.m773aq(C1640j.f3505f, 0, "\\|");
            } else if (m904b(map)) {
                if (map.size() > 100) {
                    MLog.m574e("map size is " + map.size() + ", please check");
                } else if (Arrays.asList(C1615d.f3308aG).contains(str)) {
                    MLog.m574e("key is " + str + ", please check key, illegal");
                    UMLog.m773aq(C1640j.f3501b, 0, "\\|");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("ts", System.currentTimeMillis());
                    if (j > 0) {
                        jSONObject.put(C1615d.f3297W, j);
                    }
                    jSONObject.put("__t", C1636i.f3436a);
                    ULog.m538i("befort ekv map, event is " + jSONObject.toString());
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (Arrays.asList(C1615d.f3308aG).contains(entry.getKey())) {
                            UMLog.m773aq(C1640j.f3504e, 0, "\\|");
                            return;
                        }
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (!value.getClass().isArray()) {
                                MLog.m574e("please check key or value, illegal type!");
                                return;
                            }
                            if (value instanceof int[]) {
                                int[] iArr = (int[]) value;
                                if (iArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (int i2 : iArr) {
                                    jSONArray.put(i2);
                                }
                                key = entry.getKey();
                            } else if (value instanceof double[]) {
                                double[] dArr = (double[]) value;
                                if (dArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (double d : dArr) {
                                    jSONArray.put(d);
                                }
                                key = entry.getKey();
                            } else if (value instanceof long[]) {
                                long[] jArr = (long[]) value;
                                if (jArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (long j2 : jArr) {
                                    jSONArray.put(j2);
                                }
                                key = entry.getKey();
                            } else if (value instanceof float[]) {
                                float[] fArr = (float[]) value;
                                if (fArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (float f : fArr) {
                                    jSONArray.put(f);
                                }
                                key = entry.getKey();
                            } else if (value instanceof short[]) {
                                short[] sArr = (short[]) value;
                                if (sArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (short s : sArr) {
                                    jSONArray.put((int) s);
                                }
                                key = entry.getKey();
                            } else if (!(value instanceof String[])) {
                                MLog.m574e("please check key or value, illegal type!");
                                return;
                            } else {
                                String[] strArr = (String[]) value;
                                if (strArr.length > 10) {
                                    MLog.m574e("please check key or value, size overlength!");
                                    return;
                                }
                                jSONArray = new JSONArray();
                                for (int i3 = 0; i3 < strArr.length; i3++) {
                                    if (strArr[i3] == null) {
                                        MLog.m574e("please check array, null item!");
                                        return;
                                    } else if (!m905b(strArr[i3])) {
                                        return;
                                    } else {
                                        jSONArray.put(strArr[i3]);
                                    }
                                }
                                key = entry.getKey();
                            }
                            jSONObject.put(key, jSONArray);
                        }
                        jSONObject.put(entry.getKey(), value);
                    }
                    String m859d = UMUtils.isMainProgress(f3631g) ? C1669y.m870a().m859d(UMGlobalContext.getAppContext(f3631g)) : C1669y.m870a().m866a(UMGlobalContext.getAppContext(f3631g), jSONObject.getLong("ts"));
                    if (TextUtils.isEmpty(m859d)) {
                        m859d = "-1";
                    }
                    jSONObject.put("__i", m859d);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            if (jSONObject2.length() > 0) {
                                jSONObject.put(C1615d.f3330au, jSONObject2);
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    jSONObject.put("ds", 0);
                    jSONObject.put("pn", UMGlobalContext.getInstance(f3631g).getProcessName(f3631g));
                    m916a();
                    if (this.f3636h != null && this.f3636h.has(str) && !((Boolean) this.f3636h.get(str)).booleanValue()) {
                        jSONObject.put(C1615d.f3299Y, 1);
                        this.f3636h.put(str, true);
                        m903c(f3631g);
                    }
                    ULog.m538i("----->>>>>ekv event json is " + jSONObject.toString());
                    if (!z) {
                        context = f3631g;
                        i = 4097;
                        context2 = f3631g;
                    } else {
                        context = f3631g;
                        i = C1648o.C1650a.f3597n;
                        context2 = f3631g;
                    }
                    UMWorkDispatch.sendEvent(context, i, CoreProtocol.getInstance(context2), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m911a(String str, Map<String, Object> map, String str2) {
        try {
            if (!m914a(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str);
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(C1615d.f3297W, 0);
            jSONObject.put("__t", C1636i.f3437b);
            ULog.m538i("befort gkv map, event is " + jSONObject.toString());
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            for (int i = 0; i < 10 && it.hasNext(); i++) {
                Map.Entry<String, Object> next = it.next();
                if (!C1615d.f3299Y.equals(next.getKey()) && !C1615d.f3297W.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                    Object value = next.getValue();
                    if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                        jSONObject.put(next.getKey(), value);
                    }
                }
            }
            String m859d = C1669y.m870a().m859d(UMGlobalContext.getAppContext(f3631g));
            if (TextUtils.isEmpty(m859d)) {
                m859d = "-1";
            }
            jSONObject.put("__i", m859d);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    if (jSONObject2.length() > 0) {
                        jSONObject.put(C1615d.f3330au, jSONObject2);
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("ds", 0);
            jSONObject.put("pn", UMGlobalContext.getInstance(f3631g).getProcessName(f3631g));
            ULog.m538i("----->>>>>gkv event json is " + jSONObject.toString());
            UMWorkDispatch.sendEvent(f3631g, 4098, CoreProtocol.getInstance(f3631g), jSONObject);
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m908a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    m916a();
                    if (this.f3636h == null) {
                        this.f3636h = new JSONObject();
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            if (this.f3636h == null) {
                                this.f3636h = new JSONObject();
                            } else if (this.f3636h.length() >= 5) {
                                break;
                            }
                            String str = list.get(i);
                            if (!TextUtils.isEmpty(str)) {
                                m909a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                    } else if (this.f3636h.length() >= 5) {
                        MLog.m580d("already setFistLaunchEvent, igone.");
                        return;
                    } else {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (this.f3636h.length() >= 5) {
                                MLog.m580d(" add setFistLaunchEvent over.");
                                return;
                            }
                            m909a(HelperUtils.subStr(list.get(i2), 128), false);
                        }
                    }
                    m903c(f3631g);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.m773aq(C1640j.f3493ak, 0, "\\|");
    }
}
