package com.p038qq.p039e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.p038qq.p039e.ads.LiteAbstractAD;
import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.p040pi.IReward;
import com.p038qq.p039e.comm.p040pi.NFBI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.p040pi.UBVI;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.banner2.UnifiedBannerAD */
/* loaded from: classes3.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {
    public volatile ServerSideVerificationOptions Wwwwwwwwwwww;
    public final ADListenerAdapter Wwwwwwwwwwwww;
    public UnifiedBannerView Wwwwwwwwwwwwww;
    public DownAPPConfirmPolicy Wwwwwwwwwwwwwwwwww;
    public UnifiedBannerADListener Wwwwwwwwwwwwwwwwwww;
    public AtomicInteger Wwwwwwwwwwwwwwwww = new AtomicInteger(0);
    public int Wwwwwwwwwwwwwwww = 30;
    public LoadAdParams Wwwwwwwwwwwwwww = null;

    public UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.Wwwwwwwwwwwwwwwwwww = unifiedBannerADListener;
        this.Wwwwwwwwwwwwww = unifiedBannerView;
        this.Wwwwwwwwwwwww = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.Wwwwwwwwwwwwww, (Activity) context, str, str2, str3, this.Wwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public void mo3668a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.Wwwwwwwwwwwwwwwwww;
        if (downAPPConfirmPolicy != null) {
            this.Wwwwwwwwwwwwwwwwww = downAPPConfirmPolicy;
            T t = this.f657a;
            if (t != 0) {
                ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i = this.Wwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwww = i;
        T t2 = this.f657a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i);
        }
        LoadAdParams loadAdParams = this.Wwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwww = loadAdParams;
        T t3 = this.f657a;
        if (t3 != 0) {
            ((UBVI) t3).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.Wwwwwwwwwwww);
        while (this.Wwwwwwwwwwwwwwwww.getAndDecrement() > 0) {
            loadAD();
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        UnifiedBannerADListener unifiedBannerADListener = this.Wwwwwwwwwwwwwwwwwww;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwwwwwww.incrementAndGet();
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((UBVI) t).fetchAd();
        } else {
            m3677a("loadAD");
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwww.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwww.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwwwww = serverSideVerificationOptions;
        T t = this.f657a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }
}
