package me.tvspark;

import com.p038qq.p039e.ads.rewardvideo.RewardVideoAD;
import com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.util.AdError;
import java.util.Locale;
import java.util.Map;
import me.tvspark.view.fragment.MeFragment;

/* loaded from: classes4.dex */
public class nt0 implements RewardVideoADListener {
    public final /* synthetic */ MeFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public nt0(MeFragment meFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = meFragment;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        String str = MeFragment.Wwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        String str = MeFragment.Wwwwwwwwwwww;
        ApplicationC1880C.Wwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww();
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        String str = MeFragment.Wwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        MeFragment meFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        meFragment.Wwwwwwwwwwwwwww = true;
        if (meFragment.Wwwwwwwwwwwwwwwww.getRewardAdType() == 0) {
            String str = MeFragment.Wwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.getECPMLevel();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.getVideoDuration();
        } else if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.getRewardAdType() == 1) {
            String str2 = MeFragment.Wwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.getECPMLevel();
        }
        RewardVideoAD rewardVideoAD = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww;
        rewardVideoAD.sendWinNotification(rewardVideoAD.getECPM());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww.getECPM();
        MeFragment meFragment2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (meFragment2.Wwwwwwwwwwwww) {
            meFragment2.Wwwwwwwwwwwww = false;
            MeFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(meFragment2);
        }
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        String str = MeFragment.Wwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        String.format(Locale.getDefault(), "onError, error code: %d, error msg: %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        String str = MeFragment.Wwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        String str = MeFragment.Wwwwwwwwwwww;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("onReward ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(map.get(ServerSideVerificationOptions.TRANS_ID));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwww = true;
        String str = MeFragment.Wwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        String str = MeFragment.Wwwwwwwwwwww;
        ApplicationC1880C.Wwwwwwwww = true;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww();
    }
}
