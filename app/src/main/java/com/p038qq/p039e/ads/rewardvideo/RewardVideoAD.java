package com.p038qq.p039e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.p038qq.p039e.ads.LiteAbstractAD;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.p040pi.NFBI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.p040pi.RVADI;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD */
/* loaded from: classes3.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;
    public final ADListenerAdapter Wwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwww;
    public ServerSideVerificationOptions Wwwwwwwwwwwwwwww;
    public LoadAdParams Wwwwwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwwwwww;
    public final RewardVideoADListener Wwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$ADListenerAdapter */
    /* loaded from: classes3.dex */
    public static class ADListenerAdapter implements ADListener {
        public NegativeFeedbackListener Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        @Override // com.p038qq.p039e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            } else if (type == 201) {
                this.adListener.onVideoCached();
            } else if (type == 206) {
                this.adListener.onVideoComplete();
            } else if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (negativeFeedbackListener == null) {
                    return;
                }
                negativeFeedbackListener.onComplainSuccess();
            } else {
                switch (type) {
                    case 102:
                        this.adListener.onADShow();
                        return;
                    case 103:
                        this.adListener.onADExpose();
                        return;
                    case 104:
                        String str = (String) aDEvent.getParam(String.class);
                        if (str == null) {
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                        this.adListener.onReward(hashMap);
                        return;
                    case 105:
                        this.adListener.onADClick();
                        return;
                    case 106:
                        this.adListener.onADClose();
                        return;
                    case 107:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num == null) {
                            return;
                        }
                        this.adListener.onError(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this.Wwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwww = rewardVideoADListener;
        this.Wwwwwwwwwwwwww = new ADListenerAdapter(rewardVideoADListener);
        m3679a(context, str);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.Wwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public void mo3668a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.Wwwwwwwwwwwwwww);
        rvadi.setLoadAdParams(this.Wwwwwwwwwwwwwwwww);
        rvadi.setServerSideVerificationOptions(this.Wwwwwwwwwwwwwwww);
        if (this.Wwwwwwwwwwwwwwwwww) {
            loadAD();
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        RewardVideoADListener rewardVideoADListener = this.Wwwwwwwwwwwwwwwwwww;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((RVADI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t = this.f657a;
        if (t != 0) {
            return ((RVADI) t).getRewardAdType();
        }
        m3677a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f657a;
        if (t != 0) {
            return ((RVADI) t).getVideoDuration();
        }
        m3677a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.f657a;
        if (t != 0) {
            return ((RVADI) t).hasShown();
        }
        m3677a("hasShown");
        return false;
    }

    public void loadAD() {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwwwwwwww = true;
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((RVADI) t).loadAD();
        } else {
            m3677a("loadAD");
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.Wwwwwwwwwwwwwwwww = loadAdParams;
        T t = this.f657a;
        if (t != 0) {
            ((RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = negativeFeedbackListener;
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwwwwwwwww = serverSideVerificationOptions;
        T t = this.f657a;
        if (t != 0) {
            ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.f657a;
        if (t != 0) {
            ((RVADI) t).showAD();
        } else {
            m3677a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t = this.f657a;
        if (t != 0) {
            ((RVADI) t).showAD(activity);
        } else {
            m3677a("showAD");
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this.Wwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwww = rewardVideoADListener;
        this.Wwwwwwwwwwwwww = new ADListenerAdapter(rewardVideoADListener);
        m3678a(context, str, str2);
    }
}
