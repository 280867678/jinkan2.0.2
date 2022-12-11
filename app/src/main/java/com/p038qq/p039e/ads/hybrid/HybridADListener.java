package com.p038qq.p039e.ads.hybrid;

import com.p038qq.p039e.comm.util.AdError;

/* renamed from: com.qq.e.ads.hybrid.HybridADListener */
/* loaded from: classes3.dex */
public interface HybridADListener {
    void onClose();

    void onError(AdError adError);

    void onLoadFinished();

    void onPageShow();
}
