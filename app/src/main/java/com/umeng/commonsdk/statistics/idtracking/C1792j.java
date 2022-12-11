package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.utils.C1847b;

/* renamed from: com.umeng.commonsdk.statistics.idtracking.j */
/* loaded from: classes4.dex */
public class C1792j extends AbstractC1782a {

    /* renamed from: a */
    public static final String f4117a = "utdid";

    /* renamed from: b */
    public Context f4118b;

    public C1792j(Context context) {
        super(f4117a);
        this.f4118b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC1782a
    /* renamed from: f */
    public String mo436f() {
        try {
            if (FieldManager.allow(C1847b.f4309u)) {
                return (String) Class.forName("com.ut.device.UTDevice").getMethod("getUtdid", Context.class).invoke(null, this.f4118b);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
