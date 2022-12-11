package com.efs.sdk.base.core.p005a;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p007c.HandlerC0714b;
import com.efs.sdk.base.core.p013f.C0759f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.AbstractC0766c;
import com.efs.sdk.base.core.util.p015b.C0772b;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpResponse;
import java.util.Map;
import me.tvspark.outline;

/* renamed from: com.efs.sdk.base.core.a.d */
/* loaded from: classes3.dex */
public final class C0699d extends AbsHttpListener {

    /* renamed from: com.efs.sdk.base.core.a.d$a */
    /* loaded from: classes3.dex */
    public static class C0700a {

        /* renamed from: a */
        public static final C0699d f184a = new C0699d((byte) 0);
    }

    public C0699d() {
    }

    public /* synthetic */ C0699d(byte b) {
        this();
    }

    /* renamed from: a */
    public static C0699d m4173a() {
        return C0700a.f184a;
    }

    /* renamed from: a */
    public static void m4172a(@Nullable HttpResponse httpResponse) {
        String sb;
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (httpResponse == null) {
                sb = "upload result : false";
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("upload result : ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpResponse.succ);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(", resp is ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(httpResponse.toString());
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
            }
            Log.m4062i("efs.px.api", sb);
        }
    }

    /* renamed from: b */
    public static void m4171b(HttpResponse httpResponse) {
        C0759f c0759f;
        c0759f = C0759f.C0760a.f309a;
        c0759f.m4075a(String.valueOf(httpResponse.getHttpCode()), httpResponse.getBizCode(), httpResponse.getReqUrl());
    }

    /* renamed from: c */
    public static void m4170c(HttpResponse httpResponse) {
        int parseInt;
        if (!((Map) httpResponse.extra).containsKey("cver")) {
            return;
        }
        String str = (String) ((Map) httpResponse.extra).get("cver");
        if (TextUtils.isEmpty(str) || (parseInt = Integer.parseInt(str)) <= C0729c.m4127a().f248d.f238a) {
            return;
        }
        C0729c.m4127a().m4126a(parseInt);
    }

    @Override // com.efs.sdk.base.core.util.p014a.AbstractC0765b
    /* renamed from: a */
    public final /* synthetic */ void mo4042a(@NonNull AbstractC0766c<HttpResponse> abstractC0766c, @Nullable HttpResponse httpResponse) {
        HttpResponse httpResponse2 = httpResponse;
        if (httpResponse2 != null) {
            C0772b c0772b = (C0772b) abstractC0766c;
            ((Map) httpResponse2.extra).putAll(c0772b.f328f);
            c0772b.f328f.clear();
            C0694a.m4184a();
            C0694a.m4183a(httpResponse2);
        }
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onError(@Nullable HttpResponse httpResponse) {
        m4172a(httpResponse);
        if (httpResponse == null) {
            return;
        }
        m4171b(httpResponse);
        m4170c(httpResponse);
    }

    @Override // com.efs.sdk.base.http.AbsHttpListener
    public final void onSuccess(@NonNull HttpResponse httpResponse) {
        int i;
        C0759f c0759f;
        if (!((Map) httpResponse.extra).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) httpResponse.extra).get("flow_limit"))) {
            String str = ((Map) httpResponse.extra).containsKey("type") ? (String) ((Map) httpResponse.extra).get("type") : "";
            if (((Map) httpResponse.extra).containsKey("size")) {
                String str2 = (String) ((Map) httpResponse.extra).get("size");
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.parseInt(str2);
                    HandlerC0714b m4150a = HandlerC0714b.m4150a();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i;
                    m4150a.sendMessage(obtain);
                }
            }
            i = 0;
            HandlerC0714b m4150a2 = HandlerC0714b.m4150a();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i;
            m4150a2.sendMessage(obtain2);
        }
        m4171b(httpResponse);
        c0759f = C0759f.C0760a.f309a;
        c0759f.f307c.f300b.incrementAndGet();
        m4170c(httpResponse);
        m4172a(httpResponse);
    }
}
