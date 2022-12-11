package com.efs.sdk.base.core.p007c;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.p005a.C0694a;
import com.efs.sdk.base.core.p005a.C0698c;
import com.efs.sdk.base.core.p005a.C0699d;
import com.efs.sdk.base.core.p010d.C0738a;
import com.efs.sdk.base.core.p010d.C0739b;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p015b.C0772b;
import com.efs.sdk.base.core.util.p015b.C0774d;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* renamed from: com.efs.sdk.base.core.c.a */
/* loaded from: classes3.dex */
public final class C0713a implements AbstractC0718c {
    @Override // com.efs.sdk.base.core.p007c.AbstractC0718c
    @NonNull
    /* renamed from: a */
    public final HttpResponse mo4080a(C0739b c0739b, boolean z) {
        HttpResponse m4181a;
        C0698c m4175a = C0698c.m4175a();
        C0738a c0738a = c0739b.f278a;
        m4175a.f174d = c0738a.f274d;
        m4175a.f175e = c0738a.f275e;
        m4175a.f177g = c0738a.f272b;
        m4175a.f178h = c0738a.f271a;
        m4175a.f183m = c0739b.m4099a();
        String m4122a = C0729c.m4127a().m4122a(false);
        int i = c0739b.f278a.f273c;
        if (i == 0) {
            C0694a m4184a = C0694a.m4184a();
            byte[] bArr = c0739b.f280c;
            boolean z2 = c0739b.f279b.f283b;
            String m4174b = m4175a.m4174b();
            String m4182a = C0694a.m4182a(m4122a, m4175a);
            if (m4184a.f168a) {
                Log.m4062i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(m4182a)));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wpk-header", m4174b);
            C0774d m4015a = new C0774d(m4182a).m4015a(hashMap);
            C0772b c0772b = m4015a.f331a;
            c0772b.f325c = bArr;
            c0772b.f329g = true;
            C0774d m4016a = m4015a.m4016a("type", m4175a.f178h);
            StringBuilder sb = new StringBuilder();
            sb.append(m4175a.f183m);
            m4181a = m4016a.m4016a("size", sb.toString()).m4016a("flow_limit", Boolean.toString(z2)).m4017a(C0699d.m4173a()).m4018a().m4019b();
        } else {
            m4181a = 1 == i ? C0694a.m4184a().m4181a(m4122a, m4175a, c0739b.f281d, c0739b.f279b.f283b) : new HttpResponse();
        }
        if (m4181a.succ && z) {
            C0769b.m4031b(c0739b.f281d);
        }
        return m4181a;
    }
}
