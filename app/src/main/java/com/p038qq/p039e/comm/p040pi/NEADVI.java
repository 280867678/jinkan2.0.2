package com.p038qq.p039e.comm.p040pi;

import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.NEADVI */
/* loaded from: classes3.dex */
public interface NEADVI extends LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(ADListener aDListener);

    void setAdSize(ADSize aDSize);
}
