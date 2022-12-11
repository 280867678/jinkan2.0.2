package com.efs.sdk.base.core.p006b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.config.p008a.C0729c;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.p006b.C0701a;
import com.efs.sdk.base.core.util.C0763a;
import com.efs.sdk.base.core.util.C0769b;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.p014a.C0764a;
import com.efs.sdk.base.core.util.p014a.C0767d;
import java.io.File;

/* renamed from: com.efs.sdk.base.core.b.c */
/* loaded from: classes3.dex */
public final class HandlerC0705c extends Handler implements Runnable {

    /* renamed from: a */
    public boolean f191a;

    /* renamed from: com.efs.sdk.base.core.b.c$a */
    /* loaded from: classes3.dex */
    public static class C0706a {

        /* renamed from: a */
        public static final HandlerC0705c f192a = new HandlerC0705c((byte) 0);
    }

    public HandlerC0705c() {
        super(C0764a.f317a.getLooper());
        this.f191a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }

    public /* synthetic */ HandlerC0705c(byte b) {
        this();
    }

    /* renamed from: a */
    public static HandlerC0705c m4161a() {
        return C0706a.f192a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            C0767d.m4041a(this);
            return;
        }
        Log.m4054w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0701a unused;
        unused = C0701a.C0703b.f189a;
        File m4044f = C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (m4044f.exists()) {
            for (File file : C0769b.m4028d(m4044f)) {
                if (C0701a.m4166a(file.getName())) {
                    C0701a.m4164c(file);
                }
            }
        }
        C0729c m4127a = C0729c.m4127a();
        String str = "4194304";
        String str2 = m4127a.f248d.f243f.containsKey("disk_bytes") ? m4127a.f248d.f243f.get("disk_bytes") : str;
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        long parseLong = Long.parseLong(str);
        File m4044f2 = C0763a.m4044f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        long m4029c = C0769b.m4029c(C0763a.m4046d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + C0769b.m4029c(m4044f2);
        boolean z = m4029c < parseLong;
        this.f191a = z;
        if (!z) {
            Log.m4054w("efs.cache", "Cache Limited! curr " + m4029c + "byte, max " + parseLong + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }
}
