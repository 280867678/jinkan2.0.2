package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.C1199X;
import com.tencent.bugly.proguard.C1212ea;

/* renamed from: com.tencent.bugly.crashreport.crash.anr.e */
/* loaded from: classes3.dex */
public class FileObserverC1153e extends FileObserver {

    /* renamed from: a */
    public final /* synthetic */ C1155g f1187a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileObserverC1153e(C1155g c1155g, String str, int i) {
        super(str, i);
        this.f1187a = c1155g;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        C1212ea c1212ea;
        C1212ea c1212ea2;
        if (str == null) {
            return;
        }
        C1199X.m3076e("startWatchingPrivateAnrDir %s", str);
        String str2 = "/data/anr/" + str;
        if (!str2.contains("trace")) {
            C1199X.m3076e("not anr file %s", str2);
            return;
        }
        c1212ea = this.f1187a.f1200l;
        if (c1212ea == null) {
            return;
        }
        c1212ea2 = this.f1187a.f1200l;
        c1212ea2.m2978a(true);
    }
}
