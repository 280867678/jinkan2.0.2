package com.tencent.smtt.sdk.p045ui.dialog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.BufferedInputStream;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.b */
/* loaded from: classes4.dex */
public class C1404b {

    /* renamed from: a */
    public Context f2256a;

    /* renamed from: b */
    public ResolveInfo f2257b;

    /* renamed from: c */
    public Drawable f2258c;

    /* renamed from: d */
    public String f2259d;

    /* renamed from: e */
    public String f2260e;

    /* renamed from: f */
    public String f2261f;

    /* renamed from: g */
    public boolean f2262g;

    /* renamed from: h */
    public boolean f2263h;

    /* renamed from: i */
    public String f2264i;

    /* JADX WARN: Removed duplicated region for block: B:5:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C1404b(Context context, int i, String str, String str2) {
        Drawable drawable;
        this.f2259d = "";
        this.f2260e = "";
        this.f2262g = false;
        this.f2263h = false;
        this.f2264i = "";
        if (i != -1) {
            try {
                drawable = context.getResources().getDrawable(i);
            } catch (Exception unused) {
            }
            drawable = drawable == null ? C1410e.m2318a("application_icon") : drawable;
            this.f2256a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f2257b = null;
            this.f2261f = null;
            this.f2258c = drawable;
            this.f2259d = str2;
            this.f2262g = true;
            this.f2264i = str;
        }
        drawable = null;
        if (drawable == null) {
        }
        this.f2256a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2257b = null;
        this.f2261f = null;
        this.f2258c = drawable;
        this.f2259d = str2;
        this.f2262g = true;
        this.f2264i = str;
    }

    public C1404b(Context context, ResolveInfo resolveInfo) {
        this.f2259d = "";
        this.f2260e = "";
        this.f2262g = false;
        this.f2263h = false;
        this.f2264i = "";
        this.f2256a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2257b = resolveInfo;
        this.f2258c = null;
        this.f2259d = null;
        this.f2261f = null;
    }

    public C1404b(Context context, Drawable drawable, String str, String str2, String str3) {
        this.f2259d = "";
        this.f2260e = "";
        this.f2262g = false;
        this.f2263h = false;
        this.f2264i = "";
        this.f2256a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f2257b = null;
        this.f2258c = drawable;
        this.f2259d = str;
        this.f2261f = str2;
        this.f2263h = true;
        this.f2260e = str3;
    }

    /* renamed from: a */
    public static Drawable m2351a(Context context, String str) {
        if (TbsConfig.APP_QB.equals(str)) {
            try {
                return C1410e.m2318a("application_icon");
            } catch (Throwable th) {
                Log.getStackTraceString(th);
                return null;
            }
        }
        PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            TypedValue typedValue = new TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return Drawable.createFromResourceStream(resourcesForApplication, typedValue, new BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception e) {
            String str2 = "e = " + e;
            return null;
        }
    }

    /* renamed from: a */
    public Drawable m2352a() {
        Drawable drawable = this.f2258c;
        if (drawable != null) {
            return drawable;
        }
        Drawable m2351a = m2351a(this.f2256a, m2344d());
        if (m2351a != null) {
            return m2351a;
        }
        ResolveInfo resolveInfo = this.f2257b;
        return resolveInfo != null ? resolveInfo.loadIcon(this.f2256a.getPackageManager()) : this.f2258c;
    }

    /* renamed from: a */
    public void m2350a(ResolveInfo resolveInfo) {
        this.f2257b = resolveInfo;
    }

    /* renamed from: a */
    public void m2349a(Drawable drawable) {
        this.f2258c = drawable;
    }

    /* renamed from: a */
    public void m2348a(String str) {
        this.f2260e = str;
    }

    /* renamed from: a */
    public void m2347a(boolean z) {
        this.f2263h = z;
    }

    /* renamed from: b */
    public String m2346b() {
        ResolveInfo resolveInfo = this.f2257b;
        return resolveInfo != null ? resolveInfo.loadLabel(this.f2256a.getPackageManager()).toString() : this.f2259d;
    }

    /* renamed from: c */
    public ResolveInfo m2345c() {
        return this.f2257b;
    }

    /* renamed from: d */
    public String m2344d() {
        ResolveInfo resolveInfo = this.f2257b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        String str = this.f2261f;
        return str == null ? "" : str;
    }

    /* renamed from: e */
    public boolean m2343e() {
        return this.f2262g;
    }

    /* renamed from: f */
    public boolean m2342f() {
        return this.f2263h;
    }

    /* renamed from: g */
    public String m2341g() {
        return this.f2264i;
    }

    /* renamed from: h */
    public String m2340h() {
        return this.f2260e;
    }
}
