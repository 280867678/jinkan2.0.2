package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.C1199X;
import java.util.HashMap;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.anr.h */
/* loaded from: classes3.dex */
public class C1156h implements TraceFileHelper.AbstractC1148b {

    /* renamed from: a */
    public final /* synthetic */ TraceFileHelper.C1147a f1203a;

    /* renamed from: b */
    public final /* synthetic */ String f1204b;

    /* renamed from: c */
    public final /* synthetic */ boolean f1205c;

    public C1156h(TraceFileHelper.C1147a c1147a, String str, boolean z) {
        this.f1203a = c1147a;
        this.f1204b = str;
        this.f1205c = z;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AbstractC1148b
    /* renamed from: a */
    public boolean mo3307a(long j) {
        C1199X.m3084a("process end %d", Long.valueOf(j));
        TraceFileHelper.C1147a c1147a = this.f1203a;
        return c1147a.f1173a <= 0 || c1147a.f1175c <= 0 || c1147a.f1174b == null;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AbstractC1148b
    /* renamed from: a */
    public boolean mo3306a(long j, long j2, String str) {
        C1199X.m3084a("new process %s", str);
        if (!str.equals(this.f1204b)) {
            return true;
        }
        TraceFileHelper.C1147a c1147a = this.f1203a;
        c1147a.f1173a = j;
        c1147a.f1174b = str;
        c1147a.f1175c = j2;
        return this.f1205c;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AbstractC1148b
    /* renamed from: a */
    public boolean mo3305a(String str, int i, String str2, String str3, boolean z) {
        C1199X.m3084a("new thread %s", str);
        TraceFileHelper.C1147a c1147a = this.f1203a;
        if (c1147a.f1173a > 0 && c1147a.f1175c > 0 && c1147a.f1174b != null) {
            if (c1147a.f1176d == null) {
                c1147a.f1176d = new HashMap();
            }
            this.f1203a.f1176d.put(str, new String[]{str2, str3, outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", i)});
        }
        return true;
    }

    @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.AbstractC1148b
    /* renamed from: a */
    public boolean mo3304a(String str, long j, long j2) {
        return true;
    }
}
