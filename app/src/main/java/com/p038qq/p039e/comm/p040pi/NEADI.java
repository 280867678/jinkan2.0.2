package com.p038qq.p039e.comm.p040pi;

import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.NEADI */
/* loaded from: classes3.dex */
public interface NEADI extends ADI {
    String getAdNetWorkName();

    void loadAd(int i);

    void loadAd(int i, LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);
}
