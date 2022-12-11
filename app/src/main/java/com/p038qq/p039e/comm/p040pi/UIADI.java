package com.p038qq.p039e.comm.p040pi;

import android.app.Activity;
import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;

/* renamed from: com.qq.e.comm.pi.UIADI */
/* loaded from: classes3.dex */
public interface UIADI extends LADI {
    void close();

    void destroy();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);

    void showFullScreenAD(Activity activity);
}
