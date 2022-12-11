package com.efs.sdk.base.core.p005a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p015b.C0774d;
import com.efs.sdk.base.http.HttpResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import me.tvspark.outline;
import org.json.JSONObject;

/* renamed from: com.efs.sdk.base.core.a.a */
/* loaded from: classes3.dex */
public final class C0694a {

    /* renamed from: b */
    public static volatile long f167b = -1;

    /* renamed from: a */
    public boolean f168a;

    /* renamed from: com.efs.sdk.base.core.a.a$a */
    /* loaded from: classes3.dex */
    public static class C0695a {

        /* renamed from: a */
        public static final C0694a f169a = new C0694a((byte) 0);
    }

    public C0694a() {
        this.f168a = true;
    }

    public /* synthetic */ C0694a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C0694a m4184a() {
        return C0695a.f169a;
    }

    /* renamed from: a */
    public static String m4182a(@NonNull String str, @NonNull C0698c c0698c) {
        byte b = c0698c.f177g;
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, b != 1 ? b != 2 ? b != 3 ? "/api/v1/raw/upload" : "/api/v1/mix/upload" : "/perf_upload" : "/apm_logs");
    }

    /* renamed from: a */
    public static void m4183a(@Nullable HttpResponse httpResponse) {
        if (httpResponse != null && httpResponse.succ && !TextUtils.isEmpty(httpResponse.data)) {
            try {
                JSONObject jSONObject = new JSONObject(httpResponse.data);
                String optString = jSONObject.optString("code", "-1");
                httpResponse.setBizCode(optString);
                if (!"0".equals(optString)) {
                    httpResponse.succ = false;
                }
                if (jSONObject.has("cver")) {
                    ((Map) httpResponse.extra).put("cver", jSONObject.getString("cver"));
                }
                long j = jSONObject.getLong("stm") * 1000;
                if (Math.abs(j - m4180b()) <= 1500000) {
                    return;
                }
                f167b = j - SystemClock.elapsedRealtime();
            } catch (Throwable th) {
                Log.m4065e("efs.px.api", "checkPxReturn error", th);
            }
        }
    }

    /* renamed from: b */
    public static long m4180b() {
        return f167b == -1 ? System.currentTimeMillis() : SystemClock.elapsedRealtime() + f167b;
    }

    @NonNull
    /* renamed from: a */
    public final HttpResponse m4181a(String str, C0698c c0698c, File file, boolean z) {
        String m4174b = c0698c.m4174b();
        String m4182a = m4182a(str, c0698c);
        if (this.f168a) {
            Log.m4062i("efs.px.api", "Upload file, url is ".concat(String.valueOf(m4182a)));
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("wpk-header", m4174b);
        C0774d m4015a = new C0774d(m4182a).m4015a(hashMap);
        m4015a.f331a.f326d = file;
        C0774d m4016a = m4015a.m4016a("type", c0698c.f178h);
        StringBuilder sb = new StringBuilder();
        sb.append(c0698c.f183m);
        return m4016a.m4016a("size", sb.toString()).m4016a("flow_limit", Boolean.toString(z)).m4017a(C0699d.m4173a()).m4018a().m4019b();
    }
}
