package com.p038qq.p039e.ads.rewardvideo;

import com.p038qq.p039e.comm.util.AdError;
import java.util.Map;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoADListener */
/* loaded from: classes3.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(AdError adError);

    void onReward(Map<String, Object> map);

    void onVideoCached();

    void onVideoComplete();
}
