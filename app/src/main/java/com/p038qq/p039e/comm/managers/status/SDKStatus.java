package com.p038qq.p039e.comm.managers.status;

import com.p038qq.p039e.comm.managers.C1060b;
import me.tvspark.outline;

/* renamed from: com.qq.e.comm.managers.status.SDKStatus */
/* loaded from: classes3.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 1;
    public static final String SDK_EX1 = "";
    public static final String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1352;
    }

    public static final String getIntegrationSDKVersion() {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("4.482.");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(getBuildInPluginVersion());
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    public static final int getPluginVersion() {
        if (!C1060b.m3662b().m3660d()) {
            return 0;
        }
        return C1060b.m3662b().m3661c().getPluginVersion();
    }

    public static final String getSDKVersion() {
        return "4.482";
    }
}
