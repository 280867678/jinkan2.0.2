package com.p038qq.p039e.ads.banner2;

import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.banner2.ADListenerAdapter */
/* loaded from: classes3.dex */
public class ADListenerAdapter implements ADListener {
    public ADRewardListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public NegativeFeedbackListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final UnifiedBannerADListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unifiedBannerADListener;
    }

    @Override // com.p038qq.p039e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedBannerADListener2 == null) {
                return;
            }
            unifiedBannerADListener2.onADReceive();
        } else if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
        } else if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedBannerADListener3 == null) {
                return;
            }
            unifiedBannerADListener3.onADLeftApplication();
        } else if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (negativeFeedbackListener == null) {
                return;
            }
            negativeFeedbackListener.onComplainSuccess();
        } else {
            switch (type) {
                case 103:
                    UnifiedBannerADListener unifiedBannerADListener4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedBannerADListener4 == null) {
                        return;
                    }
                    unifiedBannerADListener4.onADExposure();
                    return;
                case 104:
                    if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onReward(hashMap);
                    return;
                case 105:
                    UnifiedBannerADListener unifiedBannerADListener5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedBannerADListener5 == null) {
                        return;
                    }
                    unifiedBannerADListener5.onADClicked();
                    return;
                case 106:
                    UnifiedBannerADListener unifiedBannerADListener6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedBannerADListener6 == null) {
                        return;
                    }
                    unifiedBannerADListener6.onADClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = negativeFeedbackListener;
    }
}
