package com.p038qq.p039e.ads.banner2;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.banner2.UnifiedBannerADListener */
/* loaded from: classes3.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADReceive();

    void onNoAD(AdError adError);
}
