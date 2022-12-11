package com.efs.sdk.net.p017a.p018a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.p017a.C0809a;
import com.efs.sdk.net.p017a.C0824b;
import com.efs.sdk.net.p017a.p018a.AbstractC0816f;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.efs.sdk.net.a.a.g */
/* loaded from: classes3.dex */
public final class C0821g implements AbstractC0816f {

    /* renamed from: a */
    public static AtomicInteger f443a = new AtomicInteger(0);

    /* renamed from: c */
    public static C0821g f444c;

    /* renamed from: b */
    public C0811b f445b = new C0811b();

    /* renamed from: c */
    public static C0821g m3944c() {
        if (f444c == null) {
            f444c = new C0821g();
        }
        return f444c;
    }

    @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f
    /* renamed from: a */
    public final InputStream mo3946a(String str, String str2, String str3, InputStream inputStream) {
        Log.m4070d("NetTrace-Interceptor", "interpret response stream");
        return C0811b.m3960a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f
    /* renamed from: a */
    public final void mo3949a() {
        Log.m4070d("NetTrace-Interceptor", "data sent");
    }

    @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f
    /* renamed from: a */
    public final void mo3948a(AbstractC0816f.AbstractC0817a abstractC0817a) {
        Log.m4070d("NetTrace-Interceptor", "request will be sent");
        C0811b c0811b = this.f445b;
        try {
            String mo3952a = abstractC0817a.mo3952a();
            c0811b.f434a.put(abstractC0817a.mo3952a(), Long.valueOf(System.currentTimeMillis()));
            Log.m4062i("NetTrace-Interceptor", "save request");
            C0824b m3967a = C0809a.m3968a().m3967a(mo3952a);
            String mo3955b = abstractC0817a.mo3955b();
            if (!TextUtils.isEmpty(mo3955b)) {
                m3967a.f453d = mo3955b;
            }
            m3967a.f454e = abstractC0817a.mo3954c();
            m3967a.f455f = C0811b.m3962a(abstractC0817a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f
    /* renamed from: a */
    public final void mo3947a(AbstractC0816f.AbstractC0819c abstractC0819c) {
        Log.m4070d("NetTrace-Interceptor", "response headers received");
        C0811b c0811b = this.f445b;
        Log.m4062i("NetTrace-Interceptor", "save response");
        String mo3951a = abstractC0819c.mo3951a();
        if (c0811b.f434a != null) {
            C0809a.m3968a().m3967a(mo3951a).f456g = abstractC0819c.mo3950b();
        }
    }

    @Override // com.efs.sdk.net.p017a.p018a.AbstractC0816f
    /* renamed from: b */
    public final String mo3945b() {
        Log.m4070d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f443a.getAndIncrement());
    }
}
