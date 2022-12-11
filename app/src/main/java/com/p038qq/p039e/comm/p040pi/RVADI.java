package com.p038qq.p039e.comm.p040pi;

import android.app.Activity;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.RVADI */
/* loaded from: classes3.dex */
public interface RVADI extends LADI {
    String getAdNetWorkName();

    @Deprecated
    long getExpireTimestamp();

    int getRewardAdType();

    int getVideoDuration();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(Activity activity);
}
