package com.tencent.bugly.beta.p041ui;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.crashreport.common.info.C1140a;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.bugly.beta.ui.k */
/* loaded from: classes3.dex */
public class C1114k {

    /* renamed from: a */
    public static final Map<Integer, AbstractC1106e> f838a = new ConcurrentHashMap();

    /* renamed from: b */
    public static final Map<Integer, RunnableC1092d> f839b = new ConcurrentHashMap();

    /* renamed from: c */
    public static final Map<Integer, RunnableC1092d> f840c = new ConcurrentHashMap();

    /* renamed from: d */
    public static RunnableC1092d f841d;

    /* renamed from: a */
    public static synchronized void m3586a(AbstractC1106e abstractC1106e, boolean z) {
        synchronized (C1114k.class) {
            m3585a(abstractC1106e, z, false, 5000L);
        }
    }

    /* renamed from: a */
    public static synchronized void m3585a(AbstractC1106e abstractC1106e, boolean z, boolean z2, long j) {
        synchronized (C1114k.class) {
            if (abstractC1106e != null) {
                if (!abstractC1106e.m3594b()) {
                    int hashCode = abstractC1106e.hashCode();
                    if (abstractC1106e instanceof C1115l) {
                        C1125e.m3488b(f841d);
                        if (((C1115l) abstractC1106e).f849r.f1334l == 2) {
                            RunnableC1092d runnableC1092d = new RunnableC1092d(15, abstractC1106e, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j));
                            f841d = runnableC1092d;
                            C1125e.m3489a(runnableC1092d, 3000L);
                        }
                        if (!z && !m3587a()) {
                            RunnableC1092d runnableC1092d2 = f839b.get(Integer.valueOf(hashCode));
                            if (runnableC1092d2 == null) {
                                runnableC1092d2 = new RunnableC1092d(11, abstractC1106e, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j));
                                f839b.put(Integer.valueOf(hashCode), runnableC1092d2);
                            }
                            C1125e.m3488b(runnableC1092d2);
                            C1125e.m3489a(runnableC1092d2, j);
                            return;
                        }
                        C1125e.m3488b(f839b.remove(Integer.valueOf(hashCode)));
                    }
                    if (!z2 && !C1208ca.m3016b(C1093e.f737b.f789v)) {
                        RunnableC1092d runnableC1092d3 = f840c.get(Integer.valueOf(hashCode));
                        if (runnableC1092d3 == null) {
                            runnableC1092d3 = new RunnableC1092d(11, abstractC1106e, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j));
                            f840c.put(Integer.valueOf(hashCode), runnableC1092d3);
                        }
                        C1125e.m3488b(runnableC1092d3);
                        C1125e.m3489a(runnableC1092d3, j);
                        return;
                    }
                    C1125e.m3488b(f840c.remove(Integer.valueOf(hashCode)));
                    RunnableC1092d runnableC1092d4 = new RunnableC1092d(17, f838a, Integer.valueOf(hashCode), abstractC1106e);
                    FragmentActivity activity = abstractC1106e.getActivity();
                    if (activity != null) {
                        if (activity instanceof BetaActivity) {
                            ((BetaActivity) activity).onDestroyRunnable = runnableC1092d4;
                        } else {
                            C1125e.m3489a(runnableC1092d4, 400L);
                        }
                        activity.finish();
                    } else {
                        runnableC1092d4.run();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static synchronized boolean m3587a() {
        synchronized (C1114k.class) {
            String m3584b = m3584b();
            if (m3584b == null || m3584b.equals(NotificationCompat.WearableExtender.KEY_BACKGROUND) || m3584b.equals("unknown")) {
                return false;
            }
            Class<?> cls = null;
            try {
                cls = Class.forName(m3584b);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (!C1093e.f737b.f783p.isEmpty()) {
                for (Class<? extends Activity> cls2 : C1093e.f737b.f783p) {
                    if (TextUtils.equals(cls2.getName(), m3584b) || (cls != null && cls2.isAssignableFrom(cls))) {
                        return true;
                    }
                }
                return false;
            } else if (C1093e.f737b.f784q.isEmpty()) {
                return true;
            } else {
                for (Class<? extends Activity> cls3 : C1093e.f737b.f784q) {
                    if (TextUtils.equals(cls3.getName(), m3584b) || (cls != null && cls3.isAssignableFrom(cls))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* renamed from: b */
    public static String m3584b() {
        try {
            return C1140a.m3394m().f1026W;
        } catch (SecurityException unused) {
            C1199X.m3081b("无法获取Activity信息，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n", new Object[0]);
            return null;
        } catch (Exception e) {
            if (C1199X.m3083a(e)) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}
