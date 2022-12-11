package me.tvspark;

import com.p038qq.p039e.ads.rewardvideo.RewardVideoAD;
import com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.util.AdError;
import java.util.Locale;
import java.util.Map;
import me.tvspark.view.fragment.IndexFragment;
import me.tvspark.view.fragment.RecIndexFragment;

/* loaded from: classes4.dex */
public class mt0 implements RewardVideoADListener {
    public final /* synthetic */ IndexFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public mt0(IndexFragment indexFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = indexFragment;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        String str = IndexFragment.Wwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        String str = IndexFragment.Wwwwwwwwww;
        ApplicationC1880C.Wwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww();
        RecIndexFragment recIndexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        if (recIndexFragment != null) {
            recIndexFragment.Wwwwwwwwwwwwww();
        }
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        String str = IndexFragment.Wwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        IndexFragment indexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        indexFragment.Wwwwwwwwwwww = true;
        if (indexFragment.Wwwwwwwwwwwwww.getRewardAdType() == 0) {
            String str = IndexFragment.Wwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getECPMLevel();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getVideoDuration();
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getRewardAdType() == 1) {
            String str2 = IndexFragment.Wwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getECPMLevel();
        }
        RewardVideoAD rewardVideoAD = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww;
        rewardVideoAD.sendWinNotification(rewardVideoAD.getECPM());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww.getECPM();
        IndexFragment indexFragment2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (indexFragment2.Wwwwwwwwwww) {
            indexFragment2.Wwwwwwwwwww = false;
            IndexFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexFragment2);
        }
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        String str = IndexFragment.Wwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        String.format(Locale.getDefault(), "onError, error code: %d, error msg: %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        String str = IndexFragment.Wwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        String str = IndexFragment.Wwwwwwwwww;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onReward ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(map.get(ServerSideVerificationOptions.TRANS_ID));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        String str = IndexFragment.Wwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        String str = IndexFragment.Wwwwwwwwww;
        ApplicationC1880C.Wwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww();
        RecIndexFragment recIndexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwww;
        if (recIndexFragment != null) {
            recIndexFragment.Wwwwwwwwwwwwww();
        }
    }
}
