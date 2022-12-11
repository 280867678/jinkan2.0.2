package com.p038qq.p039e.comm.p040pi;

import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.UBVI */
/* loaded from: classes3.dex */
public interface UBVI extends LADI {
    void destroy();

    void fetchAd();

    String getAdNetWorkName();

    void onWindowFocusChanged(boolean z);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setRefresh(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
