package com.p024jg.ids;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  classes.dex
 */
/* renamed from: com.jg.ids.k */
/* loaded from: classes6.dex */
public final class C0979k {

    /* renamed from: a */
    private static final C0979k f633a = new C0979k();

    /* renamed from: b */
    private SharedPreferences f634b = null;

    private C0979k() {
    }

    /* renamed from: a */
    public final void m3733a(Context context) {
        if (this.f634b == null) {
            this.f634b = context.getSharedPreferences("jg_ids", 0);
        }
    }

    /* renamed from: a */
    public static C0979k m3734a() {
        return f633a;
    }

    /* renamed from: b */
    public final String m3731b() {
        return this.f634b.getString("jg_aaid", "");
    }

    /* renamed from: a */
    public final void m3732a(String str) {
        SharedPreferences.Editor edit = this.f634b.edit();
        edit.putString("jg_aaid", str);
        edit.commit();
    }

    /* renamed from: c */
    public final String m3729c() {
        return this.f634b.getString("jg_vaid", "");
    }

    /* renamed from: b */
    public final void m3730b(String str) {
        SharedPreferences.Editor edit = this.f634b.edit();
        edit.putString("jg_vaid", str);
        edit.commit();
    }

    /* renamed from: d */
    public final String m3727d() {
        return this.f634b.getString("jg_oaid", "");
    }

    /* renamed from: c */
    public final void m3728c(String str) {
        SharedPreferences.Editor edit = this.f634b.edit();
        edit.putString("jg_oaid", str);
        edit.commit();
    }
}
