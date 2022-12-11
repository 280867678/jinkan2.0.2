package com.p038qq.p039e.ads.splash;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.splash.SplashADListener */
/* loaded from: classes3.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j);

    void onADPresent();

    void onADTick(long j);

    void onNoAD(AdError adError);
}
