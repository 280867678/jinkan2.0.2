package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.C1847b;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.h */
/* loaded from: classes4.dex */
public class C1790h extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4111a = "umeng_sp_oaid";

    /* renamed from: b */
    public static final String f4112b = "key_umeng_sp_oaid";

    /* renamed from: c */
    public static final String f4113c = "key_umeng_sp_oaid_required_time";

    /* renamed from: d */
    public static final String f4114d = "oaid";

    /* renamed from: e */
    public Context f4115e;

    public C1790h(Context context) {
        super(f4114d);
        this.f4115e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        if (FieldManager.allow(C1847b.f4256G)) {
            try {
                SharedPreferences sharedPreferences = this.f4115e.getSharedPreferences(f4111a, 0);
                if (sharedPreferences == null) {
                    return null;
                }
                return sharedPreferences.getString(f4112b, "");
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
