package com.tencent.bugly.beta.download;

import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.p041ui.C1113j;
import com.tencent.bugly.beta.p041ui.C1114k;
import com.tencent.bugly.beta.upgrade.C1117b;
import com.tencent.bugly.crashreport.common.info.C1141b;
import com.tencent.bugly.proguard.C1176A;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1234p;
import java.util.ArrayList;

/* renamed from: com.tencent.bugly.beta.download.d */
/* loaded from: classes3.dex */
public class C1088d {

    /* renamed from: a */
    public final int f723a;

    /* renamed from: b */
    public final Object[] f724b;

    public C1088d(int i, Object... objArr) {
        this.f723a = i;
        this.f724b = objArr;
    }

    /* renamed from: a */
    public synchronized void m3629a(int i, int i2) {
        try {
            int i3 = this.f723a;
            if (i3 != 1) {
                if (i3 == 2) {
                    DownloadTask downloadTask = (DownloadTask) this.f724b[0];
                    C1113j c1113j = (C1113j) this.f724b[2];
                    if (i2 == 1) {
                        downloadTask.download();
                        C1199X.m3084a("continue download", new Object[0]);
                        this.f724b[1] = false;
                        c1113j.mo3595a();
                    } else if ((i == 1 || ((Boolean) this.f724b[1]).booleanValue()) && !C1093e.f737b.f758U && !C1093e.f737b.f759V) {
                        downloadTask.stop();
                        C1199X.m3084a("wifi network change to mobile network, stop download", new Object[0]);
                        this.f724b[1] = true;
                        if (C1141b.m3374c(C1093e.f737b.f789v) != null) {
                            C1114k.m3586a(c1113j, true);
                            this.f724b[1] = false;
                        }
                    }
                }
            } else if (i2 == 1 || i2 == 3 || i2 == 4) {
                ArrayList arrayList = (ArrayList) C1234p.f1572a.m2875b();
                if (arrayList != null && !arrayList.isEmpty()) {
                    C1117b.f869a.m3578a(new C1176A(arrayList), true);
                }
            }
        } catch (Exception e) {
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
    }
}
