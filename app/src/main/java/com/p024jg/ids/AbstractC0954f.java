package com.p024jg.ids;

import android.content.Context;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.f */
/* loaded from: classes6.dex */
public abstract class AbstractC0954f implements AbstractC0969i {

    /* renamed from: b */
    private static String f614b = "";

    /* renamed from: c */
    private static String f615c = "";

    /* renamed from: d */
    private static String f616d = "";

    /* renamed from: a */
    protected Context f617a;

    public AbstractC0954f(Context context) {
        this.f617a = null;
        this.f617a = context;
        try {
            f614b = C0979k.m3734a().m3731b();
            f615c = C0979k.m3734a().m3729c();
            f616d = C0979k.m3734a().m3727d();
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public final void m3763a(String str) {
        try {
            f614b = str;
            C0979k.m3734a().m3732a(f614b);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public final void m3762b(String str) {
        try {
            f615c = str;
            C0979k.m3734a().m3730b(f615c);
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    public final void m3761c(String str) {
        try {
            f616d = str;
            C0979k.m3734a().m3728c(f616d);
        } catch (Throwable th) {
        }
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: a */
    public String mo3723a(Context context) {
        return f615c;
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: b */
    public String mo3721b(Context context) {
        return f616d;
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: c */
    public String mo3720c(Context context) {
        return f614b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo3760c() {
        return TextUtils.isEmpty(f614b) || TextUtils.isEmpty(f615c) || TextUtils.isEmpty(f616d);
    }

    @Override // com.p024jg.ids.AbstractC0969i
    /* renamed from: d */
    public boolean mo3706d() {
        return true;
    }
}
