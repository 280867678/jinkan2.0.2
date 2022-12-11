package com.efs.sdk.base.core.controller.p009a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.efs.sdk.base.core.config.C0734b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.p014a.C0767d;

/* renamed from: com.efs.sdk.base.core.controller.a.a */
/* loaded from: classes3.dex */
public final class RunnableC0737a extends BroadcastReceiver implements Runnable {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C0767d.m4041a(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734b c0734b;
        c0734b = C0734b.C0735a.f259a;
        String networkType = NetworkUtil.getNetworkType(ControllerCenter.getGlobalEnvStruct().mAppContext);
        Log.m4054w("efs.info.manager", "network change: ".concat(String.valueOf(networkType)));
        c0734b.f257a.m4133a("net", networkType);
    }
}
