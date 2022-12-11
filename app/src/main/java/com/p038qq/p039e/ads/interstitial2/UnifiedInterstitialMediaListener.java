package com.p038qq.p039e.ads.interstitial2;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener */
/* loaded from: classes3.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
