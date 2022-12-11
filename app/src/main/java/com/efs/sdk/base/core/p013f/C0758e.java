package com.efs.sdk.base.core.p013f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.p007c.AbstractC0718c;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p015b.C0774d;
import com.efs.sdk.base.core.util.p016c.C0777b;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.f.e */
/* loaded from: classes3.dex */
public final class C0758e implements AbstractC0718c {
    /* renamed from: a */
    public static void m4079a(HttpResponse httpResponse) {
        if (httpResponse != null && !TextUtils.isEmpty(httpResponse.data)) {
            for (String str : httpResponse.data.split("`")) {
                String[] split = str.split("=");
                if (split.length >= 2) {
                    if (split[0].equalsIgnoreCase("retcode")) {
                        httpResponse.setBizCode(split[1]);
                    } else {
                        ((Map) httpResponse.extra).put(split[0], split[1]);
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.p007c.AbstractC0718c
    @NonNull
    /* renamed from: a */
    public final HttpResponse mo4080a(C0739b c0739b, boolean z) {
        C0759f c0759f;
        HttpResponse httpResponse = null;
        try {
            c0759f = C0759f.C0760a.f309a;
            C0756c c0756c = c0759f.f305a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            String m4009a = C0777b.m4009a(c0756c.f298b + c0756c.f299c + valueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = c0756c.f297a;
            if (str.startsWith("http")) {
                sb.append(str);
            } else {
                sb.append(str);
            }
            sb.append("?chk=");
            sb.append(m4009a.substring(m4009a.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(c0756c.f299c);
            sb.append("&app=");
            sb.append(c0756c.f298b);
            sb.append("&zip=gzip");
            String sb2 = sb.toString();
            int i = 0;
            byte[] bArr = new byte[0];
            if (c0739b.f278a.f273c == 0) {
                bArr = c0739b.f280c;
                i = bArr.length;
            } else if (1 == c0739b.f278a.f273c) {
                bArr = C0769b.m4032a(c0739b.f281d.getPath());
                i = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(i));
            C0774d m4015a = new C0774d(sb2).m4015a(hashMap);
            m4015a.f331a.f325c = bArr;
            httpResponse = m4015a.m4018a().m4019b();
            m4079a(httpResponse);
        } catch (Throwable th) {
            if (0 == 0) {
                httpResponse = new HttpResponse();
            }
            Log.m4065e("efs.wa.send", "get file size error", th);
        }
        if (!httpResponse.succ) {
            Log.m4062i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
            return httpResponse;
        }
        Log.m4062i("efs.base", "wa upload succ, " + httpResponse.toString());
        C0769b.m4031b(c0739b.f281d);
        return httpResponse;
    }
}
