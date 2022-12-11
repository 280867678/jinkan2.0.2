package com.p038qq.p039e.mediation.interfaces;

import android.content.Context;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.mediation.interfaces.BaseNativeExpressAd */
/* loaded from: classes3.dex */
public abstract class BaseNativeExpressAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeExpressAd(Context context, ADSize aDSize, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadAD(int i);

    public abstract void loadAD(int i, LoadAdParams loadAdParams);

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

    public abstract void setECPMLevel(String str);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMinVideoDuration(int i);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVideoOption(VideoOption videoOption);
}
