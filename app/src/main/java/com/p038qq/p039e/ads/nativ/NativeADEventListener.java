package com.p038qq.p039e.ads.nativ;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.nativ.NativeADEventListener */
/* loaded from: classes3.dex */
public interface NativeADEventListener {
    void onADClicked();

    void onADError(AdError adError);

    void onADExposed();

    void onADStatusChanged();
}
