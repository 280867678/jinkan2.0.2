package com.umeng.commonsdk.internal;

import android.content.Context;
import com.stub.StubApp;

/* renamed from: com.umeng.commonsdk.internal.b */
/* loaded from: classes4.dex */
public class C1725b {

    /* renamed from: b */
    public static C1725b f3925b;

    /* renamed from: a */
    public Context f3926a;

    /* renamed from: c */
    public C1726c f3927c;

    public C1725b(Context context) {
        this.f3926a = context;
        this.f3927c = new C1726c(context);
    }

    /* renamed from: a */
    public static synchronized C1725b m729a(Context context) {
        C1725b c1725b;
        synchronized (C1725b.class) {
            if (f3925b == null) {
                f3925b = new C1725b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            c1725b = f3925b;
        }
        return c1725b;
    }

    /* renamed from: a */
    public C1726c m730a() {
        return this.f3927c;
    }
}
