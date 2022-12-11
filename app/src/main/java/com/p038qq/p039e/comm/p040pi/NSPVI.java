package com.p038qq.p039e.comm.p040pi;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.NSPVI */
/* loaded from: classes3.dex */
public interface NSPVI extends LADI {
    void fetchAdOnly();

    void fetchAndShowIn(ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(ViewGroup viewGroup);

    String getAdNetWorkName();

    Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(ADListener aDListener);

    void setDeveloperLogo(int i);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    @Deprecated
    void setSkipView(View view);

    void setSupportZoomOut(boolean z);

    void showAd(ViewGroup viewGroup);

    void showFullScreenAd(ViewGroup viewGroup);

    void zoomOutAnimationFinish();
}
