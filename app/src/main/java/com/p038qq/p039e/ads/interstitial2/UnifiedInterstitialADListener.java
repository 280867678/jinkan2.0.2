package com.p038qq.p039e.ads.interstitial2;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialADListener */
/* loaded from: classes3.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(AdError adError);

    void onRenderFail();

    void onRenderSuccess();

    void onVideoCached();
}
