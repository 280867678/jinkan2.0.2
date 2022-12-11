package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1208ca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.tencent.bugly.crashreport.crash.g */
/* loaded from: classes3.dex */
public class C1163g extends Thread {

    /* renamed from: a */
    public final /* synthetic */ C1164h f1230a;

    public C1163g(C1164h c1164h) {
        this.f1230a = c1164h;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        ArrayList arrayList;
        context = this.f1230a.f1249q;
        if (!C1208ca.m3041a(context, "local_crash_lock", 10000L)) {
            return;
        }
        List<CrashDetailBean> m3288b = this.f1230a.f1250r.m3288b();
        if (m3288b != null && m3288b.size() > 0) {
            C1199X.m3084a("Size of crash list: %s", Integer.valueOf(m3288b.size()));
            int size = m3288b.size();
            if (size > 20) {
                ArrayList arrayList2 = new ArrayList();
                Collections.sort(m3288b);
                for (int i = 0; i < 20; i++) {
                    arrayList2.add(m3288b.get((size - 1) - i));
                }
                arrayList = arrayList2;
            } else {
                arrayList = m3288b;
            }
            this.f1230a.f1250r.m3291a(arrayList, 0L, false, false, false);
        }
        context2 = this.f1230a.f1249q;
        C1208ca.m3015b(context2, "local_crash_lock");
    }
}
