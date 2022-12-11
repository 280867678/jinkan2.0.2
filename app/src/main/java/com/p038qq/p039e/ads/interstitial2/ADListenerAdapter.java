package com.p038qq.p039e.ads.interstitial2;

import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.C1075a;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.interstitial2.ADListenerAdapter */
/* loaded from: classes3.dex */
public class ADListenerAdapter implements ADListener {
    public NegativeFeedbackListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ADRewardListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public UnifiedInterstitialMediaListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final UnifiedInterstitialADListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unifiedInterstitialADListener;
    }

    @Override // com.p038qq.p039e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedInterstitialADListener unifiedInterstitialADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 109) {
            UnifiedInterstitialADListener unifiedInterstitialADListener2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialADListener2 == null || !C1075a.m3640b(unifiedInterstitialADListener2)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onRenderSuccess();
        } else if (type == 110) {
            UnifiedInterstitialADListener unifiedInterstitialADListener3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialADListener3 == null || !C1075a.m3641a(unifiedInterstitialADListener3)) {
                return;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onRenderFail();
        } else if (type == 201) {
            UnifiedInterstitialADListener unifiedInterstitialADListener4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialADListener4 == null) {
                return;
            }
            unifiedInterstitialADListener4.onVideoCached();
        } else if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialMediaListener == null) {
                return;
            }
            unifiedInterstitialMediaListener.onVideoStart();
        } else if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialMediaListener2 == null) {
                return;
            }
            unifiedInterstitialMediaListener2.onVideoPause();
        } else if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialMediaListener3 == null) {
                return;
            }
            unifiedInterstitialMediaListener3.onVideoComplete();
        } else if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
        } else {
            switch (type) {
                case 100:
                    UnifiedInterstitialADListener unifiedInterstitialADListener5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedInterstitialADListener5 == null) {
                        return;
                    }
                    unifiedInterstitialADListener5.onADReceive();
                    return;
                case 101:
                    Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                    if (num2 == null || (unifiedInterstitialADListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == null) {
                        return;
                    }
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(num2.intValue()));
                    return;
                case 102:
                    UnifiedInterstitialADListener unifiedInterstitialADListener6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedInterstitialADListener6 == null) {
                        return;
                    }
                    unifiedInterstitialADListener6.onADOpened();
                    return;
                case 103:
                    UnifiedInterstitialADListener unifiedInterstitialADListener7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedInterstitialADListener7 == null) {
                        return;
                    }
                    unifiedInterstitialADListener7.onADExposure();
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
                    UnifiedInterstitialADListener unifiedInterstitialADListener8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedInterstitialADListener8 == null) {
                        return;
                    }
                    unifiedInterstitialADListener8.onADClicked();
                    return;
                case 106:
                    UnifiedInterstitialADListener unifiedInterstitialADListener9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (unifiedInterstitialADListener9 == null) {
                        return;
                    }
                    unifiedInterstitialADListener9.onADClosed();
                    return;
                default:
                    switch (type) {
                        case 209:
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (unifiedInterstitialMediaListener5 == null) {
                                return;
                            }
                            unifiedInterstitialMediaListener5.onVideoInit();
                            return;
                        case 210:
                            Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (unifiedInterstitialMediaListener6 == null || num3 == null) {
                                return;
                            }
                            unifiedInterstitialMediaListener6.onVideoReady(num3.intValue());
                            return;
                        case 211:
                            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (unifiedInterstitialMediaListener7 == null) {
                                return;
                            }
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            return;
                        default:
                            switch (type) {
                                case 301:
                                    UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (unifiedInterstitialMediaListener8 == null) {
                                        return;
                                    }
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    return;
                                case 302:
                                    UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (unifiedInterstitialMediaListener9 == null) {
                                        return;
                                    }
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    return;
                                case 303:
                                    UnifiedInterstitialADListener unifiedInterstitialADListener10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (unifiedInterstitialADListener10 == null) {
                                        return;
                                    }
                                    unifiedInterstitialADListener10.onADLeftApplication();
                                    return;
                                case 304:
                                    NegativeFeedbackListener negativeFeedbackListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                                    if (negativeFeedbackListener == null) {
                                        return;
                                    }
                                    negativeFeedbackListener.onComplainSuccess();
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = negativeFeedbackListener;
    }
}
