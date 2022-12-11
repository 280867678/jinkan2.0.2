package com.tencent.bugly.crashreport.crash.anr;

import android.os.FileObserver;
import com.tencent.bugly.proguard.C1199X;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.crashreport.crash.anr.b */
/* loaded from: classes3.dex */
public class FileObserverC1150b extends FileObserver {

    /* renamed from: a */
    public final /* synthetic */ C1155g f1184a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileObserverC1150b(C1155g c1155g, String str, int i) {
        super(str, i);
        this.f1184a = c1155g;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (str == null) {
            return;
        }
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("/data/anr/", str);
        C1199X.m3076e("watching file %s", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("trace")) {
            C1199X.m3076e("not anr file %s", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else {
            this.f1184a.m3323a(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }
}
