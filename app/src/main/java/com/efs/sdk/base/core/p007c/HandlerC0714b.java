package com.efs.sdk.base.core.p007c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.C0734b;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.newsharedpreferences.SharedPreferencesUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;

/* renamed from: com.efs.sdk.base.core.c.b */
/* loaded from: classes3.dex */
public class HandlerC0714b extends Handler {

    /* renamed from: a */
    public static final Map<String, Long> f198a = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.1
        {
            put("flow_5min", 300000L);
            put("flow_hour", Long.valueOf((long) DateUtils.MILLIS_PER_HOUR));
            put("flow_day", 86400000L);
        }
    };

    /* renamed from: b */
    public static final Map<String, Long> f199b = new HashMap<String, Long>() { // from class: com.efs.sdk.base.core.c.b.2
        {
            put("flow_5min", 1048576L);
            put("flow_hour", 1048576L);
            put("flow_day", Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE));
        }
    };

    /* renamed from: c */
    public Map<String, AtomicInteger> f200c;

    /* renamed from: d */
    public volatile SharedPreferences f201d;

    /* renamed from: e */
    public volatile SharedPreferences.Editor f202e;

    /* renamed from: f */
    public Context f203f;

    /* renamed from: g */
    public String f204g;

    /* renamed from: com.efs.sdk.base.core.c.b$a */
    /* loaded from: classes3.dex */
    public static class C0717a {

        /* renamed from: a */
        public static final HandlerC0714b f205a = new HandlerC0714b((byte) 0);
    }

    public HandlerC0714b() {
        super(C0764a.f317a.getLooper());
        this.f200c = new ConcurrentHashMap(5);
        this.f203f = ControllerCenter.getGlobalEnvStruct().mAppContext;
        this.f204g = ControllerCenter.getGlobalEnvStruct().getAppid();
        m4144b();
        File m4047c = C0763a.m4047c(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (m4047c.exists()) {
            C0769b.m4031b(m4047c);
        }
    }

    public /* synthetic */ HandlerC0714b(byte b) {
        this();
    }

    /* renamed from: a */
    public static long m4145a(Map<String, String> map, @NonNull String str, @NonNull String str2) {
        long longValue = f199b.get(str).longValue();
        if (map == null || !map.containsKey(str2) || TextUtils.isEmpty(map.get(str2))) {
            return longValue;
        }
        try {
            return Long.parseLong(map.get(str2));
        } catch (Throwable th) {
            Log.m4053w("efs.flow", "get max flow error", th);
            return longValue;
        }
    }

    /* renamed from: a */
    public static HandlerC0714b m4150a() {
        return C0717a.f205a;
    }

    /* renamed from: a */
    public static List<String> m4146a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str + "_" + str2);
        }
        if (!TextUtils.isEmpty(str3) && !"unknown".equalsIgnoreCase(str3)) {
            arrayList.add(str + "_" + str3);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            arrayList.add(str + "_" + str2 + "_" + str3);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m4149a(String str) {
        C0759f c0759f;
        C0759f c0759f2;
        if (!this.f200c.containsKey(str) || this.f200c.get(str) == null || this.f200c.get(str).get() <= 10) {
            c0759f = C0759f.C0760a.f309a;
            c0759f.m4077a(C0729c.m4127a().f248d.f238a, str);
            if (str.equals("flow_day")) {
                c0759f2 = C0759f.C0760a.f309a;
                c0759f2.m4078a(C0729c.m4127a().f248d.f238a);
            }
            if (!this.f200c.containsKey(str)) {
                this.f200c.put(str, new AtomicInteger());
            }
            this.f200c.get(str).incrementAndGet();
        }
    }

    /* renamed from: a */
    private boolean m4147a(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        m4144b();
        if (this.f201d == null) {
            Log.m4054w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            return false;
        }
        List<String> m4146a = m4146a(str, str2, str3);
        Map<String, String> m4119c = C0729c.m4127a().m4119c();
        for (String str4 : m4146a) {
            if (Math.abs(System.currentTimeMillis() - this.f201d.getLong("curr_time_".concat(String.valueOf(str)), System.currentTimeMillis())) > j) {
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = str;
                obtain.arg1 = Long.valueOf(j).intValue();
                sendMessage(obtain);
            }
            long m4145a = m4145a(m4119c, str, str4);
            long j3 = this.f201d.getLong(str4, 0L);
            if (j3 + j2 > m4145a) {
                Log.m4062i("efs.flow", "flow limit, key: " + str4 + ", max: " + m4145a + ", now: " + j3 + ", size: " + j2);
                m4149a(str4);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m4144b() {
        try {
            m4143c();
        } catch (Throwable th) {
            Log.m4065e("efs.flow", "init sharedpreferences error", th);
        }
    }

    /* renamed from: c */
    private void m4143c() {
        if (this.f201d == null) {
            synchronized (HandlerC0714b.class) {
                if (this.f201d == null) {
                    this.f201d = SharedPreferencesUtils.getSharedPreferences(this.f203f, this.f204g.toLowerCase() + "_flow");
                }
            }
        }
        if (this.f202e == null) {
            synchronized (HandlerC0714b.class) {
                if (this.f202e == null) {
                    this.f202e = this.f201d.edit();
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m4148a(@NonNull String str, long j) {
        C0734b c0734b;
        c0734b = C0734b.C0735a.f259a;
        String m4104a = c0734b.m4104a();
        boolean z = true;
        for (Map.Entry<String, Long> entry : f198a.entrySet()) {
            z = m4147a(entry.getKey(), entry.getValue().longValue(), str, m4104a, j);
            if (!z) {
                break;
            }
        }
        return z;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        C0734b c0734b;
        super.handleMessage(message);
        int i = message.what;
        if (i == 0) {
            m4144b();
            if (this.f201d == null) {
                Log.m4054w("efs.flow", "sharedpreferences is null, cann't get last flow stat");
            } else if (this.f202e == null) {
                Log.m4054w("efs.flow", "sharedpreferences editor is null, cann't refresh flow stat");
            } else {
                String valueOf = String.valueOf(message.obj);
                long j = message.arg1;
                c0734b = C0734b.C0735a.f259a;
                String m4104a = c0734b.m4104a();
                for (String str : f198a.keySet()) {
                    String concat = "curr_time_".concat(String.valueOf(str));
                    if (!this.f201d.contains(concat)) {
                        this.f202e.putLong(concat, System.currentTimeMillis());
                    }
                    for (String str2 : m4146a(str, valueOf, m4104a)) {
                        this.f202e.putLong(str2, this.f201d.getLong(str2, 0L) + j);
                    }
                }
                this.f202e.apply();
            }
        } else if (i != 1) {
            Log.m4054w("efs.flow", "flow stat listener not support action '" + message.what + "'");
        } else {
            String valueOf2 = String.valueOf(message.obj);
            long j2 = message.arg1;
            m4144b();
            if (this.f201d == null) {
                Log.m4054w("efs.flow", "sharedpreferences is null, cann't get last refresh timestamp");
            } else if (this.f202e == null) {
                Log.m4054w("efs.flow", "sharedpreferences editor is null, cann't refresh timestamp");
            } else {
                String concat2 = "curr_time_".concat(valueOf2);
                if (Math.abs(System.currentTimeMillis() - this.f201d.getLong(concat2, System.currentTimeMillis())) < j2) {
                    return;
                }
                for (String str3 : this.f201d.getAll().keySet()) {
                    if (str3.startsWith(valueOf2)) {
                        this.f202e.putLong(str3, 0L);
                    }
                }
                this.f202e.putLong(concat2, System.currentTimeMillis());
                this.f202e.apply();
                this.f200c.clear();
            }
        }
    }
}
