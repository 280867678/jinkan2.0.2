package com.p038qq.p039e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADListener;

/* renamed from: com.qq.e.mediation.interfaces.BaseBannerAd */
/* loaded from: classes3.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setAdSize(int i, int i2);

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
