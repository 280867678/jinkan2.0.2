package com.p038qq.p039e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.mediation.interfaces.BaseRewardAd */
/* loaded from: classes3.dex */
public abstract class BaseRewardAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;
    public LoadAdParams Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;

    public BaseRewardAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    @Deprecated
    public abstract long getExpireTimestamp();

    public LoadAdParams getLoadAdParams() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int getRewardAdType() {
        return 0;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, String str) {
    }

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(ADListener aDListener);

    @Override // com.p038qq.p039e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = loadAdParams;
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVolumeOn(boolean z);

    public abstract void showAD();

    public void showAD(Activity activity) {
        showAD();
    }
}
