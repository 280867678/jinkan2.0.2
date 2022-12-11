package com.p038qq.p039e.ads.nativ;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADMediaListener */
/* loaded from: classes3.dex */
public interface NativeADMediaListener {
    void onVideoClicked();

    void onVideoCompleted();

    void onVideoError(AdError adError);

    void onVideoInit();

    void onVideoLoaded(int i);

    void onVideoLoading();

    void onVideoPause();

    void onVideoReady();

    void onVideoResume();

    void onVideoStart();

    void onVideoStop();
}
