package com.efs.sdk.base.core.util.p015b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.core.util.p014a.AbstractC0765b;
import com.efs.sdk.base.http.AbsHttpListener;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.efs.sdk.base.core.util.b.d */
/* loaded from: classes3.dex */
public final class C0774d {

    /* renamed from: a */
    public C0772b f331a;

    /* renamed from: b */
    public List<AbstractC0765b<HttpResponse>> f332b;

    public C0774d(@NonNull String str) {
        C0772b c0772b = new C0772b();
        this.f331a = c0772b;
        c0772b.f323a = str;
    }

    /* renamed from: a */
    public final C0773c m4018a() {
        C0773c c0773c = new C0773c(this.f331a);
        List<AbstractC0765b<HttpResponse>> list = this.f332b;
        if (list != null && list.size() > 0) {
            c0773c.m4039a(this.f332b);
        }
        List<AbstractC0765b<HttpResponse>> httpListenerList = HttpEnv.getInstance().getHttpListenerList();
        if (httpListenerList != null && httpListenerList.size() > 0) {
            c0773c.m4039a(httpListenerList);
        }
        return c0773c;
    }

    /* renamed from: a */
    public final C0774d m4017a(@NonNull AbsHttpListener absHttpListener) {
        if (this.f332b == null) {
            this.f332b = new ArrayList(5);
        }
        this.f332b.add(absHttpListener);
        return this;
    }

    /* renamed from: a */
    public final C0774d m4016a(String str, String str2) {
        C0772b c0772b = this.f331a;
        if (c0772b.f328f == null) {
            c0772b.f328f = new HashMap(5);
        }
        this.f331a.f328f.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public final C0774d m4015a(@NonNull Map<String, String> map) {
        this.f331a.f324b = map;
        return this;
    }
}
