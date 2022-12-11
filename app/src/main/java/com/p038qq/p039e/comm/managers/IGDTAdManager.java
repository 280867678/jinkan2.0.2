package com.p038qq.p039e.comm.managers;

import com.p038qq.p039e.ads.dfa.GDTAppDialogClickListener;
import com.p038qq.p039e.comm.managers.devtool.DevTools;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.IGDTAdManager */
/* loaded from: classes3.dex */
public interface IGDTAdManager {
    String getBuyerId(Map<String, Object> map);

    DevTools getDevTools();

    String getSDKInfo(String str);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
