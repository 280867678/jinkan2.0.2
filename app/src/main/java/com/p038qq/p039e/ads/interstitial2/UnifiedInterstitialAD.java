package com.p038qq.p039e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.p038qq.p039e.ads.LiteAbstractAD;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.p040pi.IReward;
import com.p038qq.p039e.comm.p040pi.NFBI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.p040pi.UIADI;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.qq.e.ads.interstitial2.UnifiedInterstitialAD */
/* loaded from: classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {
    public final ADListenerAdapter Wwwwwwwwwww;
    public ServerSideVerificationOptions Wwwwwwwwwwww;
    public UnifiedInterstitialADListener Wwwwwwwwwwwww;
    public volatile LoadAdParams Wwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwww;
    public volatile int Wwwwwwwwwwwwwwww;
    public volatile VideoOption Wwwwwwwwwwwwwwwww;
    public AtomicInteger Wwwwwwwwwwwwwwwwww;
    public AtomicInteger Wwwwwwwwwwwwwwwwwww;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.Wwwwwwwwwwwwwwwwwww = new AtomicInteger(0);
        this.Wwwwwwwwwwwwwwwwww = new AtomicInteger(0);
        this.Wwwwwwwwwwwww = unifiedInterstitialADListener;
        this.Wwwwwwwwwww = new ADListenerAdapter(unifiedInterstitialADListener);
        m3679a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.Wwwwwwwwwwwwwwwwwww = new AtomicInteger(0);
        this.Wwwwwwwwwwwwwwwwww = new AtomicInteger(0);
        this.Wwwwwwwwwwwww = unifiedInterstitialADListener;
        this.Wwwwwwwwwww = new ADListenerAdapter(unifiedInterstitialADListener);
        m3678a(activity, str, str2);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.Wwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo3668a(Object obj) {
        UIADI uiadi = (UIADI) obj;
        m3673c();
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.Wwwwwwwwwwwww;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    /* renamed from: c */
    public void m3673c() {
        setVideoOption(this.Wwwwwwwwwwwwwwwww);
        setMinVideoDuration(this.Wwwwwwwwwwwwwwww);
        setMaxVideoDuration(this.Wwwwwwwwwwwwwww);
        setLoadAdParams(this.Wwwwwwwwwwwwww);
        setServerSideVerificationOptions(this.Wwwwwwwwwwww);
        while (this.Wwwwwwwwwwwwwwwwwww.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.Wwwwwwwwwwwwwwwwww.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            m3677a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.f657a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        m3677a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f657a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        m3677a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwwwwwwwww.incrementAndGet();
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).loadAd();
        } else {
            m3677a("loadAD");
        }
    }

    public void loadFullScreenAD() {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwwwwwwww.incrementAndGet();
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).loadFullScreenAD();
        } else {
            m3677a("loadFullScreenAD");
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.Wwwwwwwwwwwwww = loadAdParams;
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.Wwwwwwwwwwwwww);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.Wwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwww) {
            GDTLogger.m3646e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.Wwwwwwwwwww.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i) {
        this.Wwwwwwwwwwwwwwww = i;
        if (this.Wwwwwwwwwwwwwww > 0 && this.Wwwwwwwwwwwwwwww > this.Wwwwwwwwwwwwwww) {
            GDTLogger.m3646e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwww.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwww.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwwwww = serverSideVerificationOptions;
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.Wwwwwwwwwwwwwwwww = videoOption;
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            m3677a("show");
        }
    }

    public void show(Activity activity) {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            m3677a("show");
        }
    }

    public void showAsPopupWindow() {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow();
        } else {
            m3677a("showAsPopupWindow");
        }
    }

    public void showAsPopupWindow(Activity activity) {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow(activity);
        } else {
            m3677a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.f657a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            m3677a("showFullScreenAD");
        }
    }
}
