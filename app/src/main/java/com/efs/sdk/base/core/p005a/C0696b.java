package com.efs.sdk.base.core.p005a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p013f.C0755b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.p014a.AbstractC0766c;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.a.b */
/* loaded from: classes3.dex */
public final class C0696b extends AbsHttpListener {

    /* renamed from: com.efs.sdk.base.core.a.b$a */
    /* loaded from: classes3.dex */
    public static class C0697a {

        /* renamed from: a */
        public static final C0696b f170a = new C0696b((byte) 0);
    }

    public C0696b() {
    }

    public /* synthetic */ C0696b(byte b) {
        this();
    }

    /* renamed from: a */
    public static C0696b m4178a() {
        return C0697a.f170a;
    }

    /* renamed from: a */
    public static void m4177a(@NonNull HttpResponse httpResponse) {
        C0759f c0759f;
        c0759f = C0759f.C0760a.f309a;
        c0759f.m4075a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    @Override // com.efs.sdk.base.core.util.p014a.AbstractC0765b
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo4042a(@NonNull AbstractC0766c<HttpResponse> abstractC0766c, @Nullable HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            C0694a.m4184a();
            C0694a.m4183a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@Nullable HttpResponse httpResponse) {
        if (httpResponse == null) {
            return;
        }
        m4177a(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@NonNull HttpResponse httpResponse) {
        C0759f c0759f;
        m4177a(httpResponse);
        if (((Map) httpResponse.extra).containsKey("cver")) {
            String str = (String) ((Map) httpResponse.extra).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int parseInt = Integer.parseInt(str);
            c0759f = C0759f.C0760a.f309a;
            if (c0759f.f306b == null || !ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                return;
            }
            C0755b c0755b = new C0755b("efs_core", "config_coverage", c0759f.f305a.f299c);
            c0755b.put("cver", Integer.valueOf(parseInt));
            c0759f.f306b.send(c0755b);
        }
    }
}
