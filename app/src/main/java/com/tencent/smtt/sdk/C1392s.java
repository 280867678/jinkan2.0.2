package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.tbs.video.interfaces.AbstractC1489a;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;

/* renamed from: com.tencent.smtt.sdk.s */
/* loaded from: classes4.dex */
public class C1392s {

    /* renamed from: e */
    public static C1392s f2210e;

    /* renamed from: a */
    public C1400u f2211a;

    /* renamed from: b */
    public Context f2212b;

    /* renamed from: c */
    public AbstractC1489a f2213c;

    /* renamed from: d */
    public IUserStateChangedListener f2214d;

    public C1392s(Context context) {
        this.f2211a = null;
        this.f2212b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2211a = new C1400u(this.f2212b);
    }

    /* renamed from: a */
    public static synchronized C1392s m2404a(Context context) {
        C1392s c1392s;
        synchronized (C1392s.class) {
            if (f2210e == null) {
                f2210e = new C1392s(context);
            }
            c1392s = f2210e;
        }
        return c1392s;
    }

    /* renamed from: a */
    public void m2406a(int i, int i2, Intent intent) {
        AbstractC1489a abstractC1489a = this.f2213c;
        if (abstractC1489a != null) {
            abstractC1489a.m1964a(i, i2, intent);
        }
    }

    /* renamed from: a */
    public void m2405a(Activity activity, int i) {
        this.f2211a.m2370a(activity, i);
    }

    /* renamed from: a */
    public boolean m2407a() {
        this.f2211a.m2372a();
        return this.f2211a.m2368b();
    }

    /* renamed from: a */
    public boolean m2403a(String str, Bundle bundle, AbstractC1489a abstractC1489a) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (abstractC1489a != null) {
            this.f2211a.m2372a();
            if (!this.f2211a.m2368b()) {
                return false;
            }
            this.f2213c = abstractC1489a;
            IUserStateChangedListener iUserStateChangedListener = new IUserStateChangedListener() { // from class: com.tencent.smtt.sdk.s.1
                @Override // com.tencent.tbs.video.interfaces.IUserStateChangedListener
                public void onUserStateChanged() {
                    C1392s.this.f2211a.m2366c();
                }
            };
            this.f2214d = iUserStateChangedListener;
            this.f2213c.m1963a(iUserStateChangedListener);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        this.f2211a.m2369a(bundle, abstractC1489a == null ? null : this);
        return true;
    }
}
