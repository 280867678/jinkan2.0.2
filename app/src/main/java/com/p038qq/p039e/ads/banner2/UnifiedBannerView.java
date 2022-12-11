package com.p038qq.p039e.ads.banner2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface;
import com.p038qq.p039e.comm.compliance.DownloadConfirmListener;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.p040pi.IBidding;
import com.p038qq.p039e.comm.p040pi.IReward;
import com.p038qq.p039e.comm.p040pi.NFBI;
import com.p038qq.p039e.comm.p040pi.UBVI;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.banner2.UnifiedBannerView */
/* loaded from: classes3.dex */
public class UnifiedBannerView extends FrameLayout implements ApkDownloadComplianceInterface, IBidding, NFBI, IReward {
    public final UnifiedBannerAD Wwwwwwwwwwwwwwwwwwwwwwww;

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map) {
        super(activity);
        UnifiedBannerAD unifiedBannerAD = new UnifiedBannerAD(this, unifiedBannerADListener);
        unifiedBannerAD.m3679a(activity, str);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = unifiedBannerAD;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        UnifiedBannerAD unifiedBannerAD = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        T t = unifiedBannerAD.f657a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            unifiedBannerAD.m3677a("destroy");
        }
    }

    public String getAdNetWorkName() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAdNetWorkName();
    }

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getApkInfoUrl();
    }

    public int getECPM() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getECPM();
    }

    public String getECPMLevel() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getECPMLevel();
    }

    public Map<String, Object> getExtraInfo() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getExtraInfo();
    }

    public boolean isValid() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isValid();
    }

    public void loadAD() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        T t = this.Wwwwwwwwwwwwwwwwwwwwwwww.f657a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.sendLossNotification(i, i2, str);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.sendLossNotification(map);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendWinNotification(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.sendWinNotification(i);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.sendWinNotification(map);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IBidding
    public void setBidECPM(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setBidECPM(i);
    }

    public void setDownConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        UnifiedBannerAD unifiedBannerAD = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        unifiedBannerAD.Wwwwwwwwwwwwwwwwww = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t = unifiedBannerAD.f657a) == 0) {
            return;
        }
        ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        UnifiedBannerAD unifiedBannerAD = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        unifiedBannerAD.Wwwwwwwwwwwwwww = loadAdParams;
        T t = unifiedBannerAD.f657a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        UnifiedBannerAD unifiedBannerAD = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        unifiedBannerAD.Wwwwwwwwwwwwwwww = i;
        T t = unifiedBannerAD.f657a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setRewardListener(aDRewardListener);
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public UnifiedBannerView(Activity activity, String str, UnifiedBannerADListener unifiedBannerADListener, Map map, String str2) {
        super(activity);
        if (TextUtils.isEmpty(str2)) {
            GDTLogger.m3646e(UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        UnifiedBannerAD unifiedBannerAD = new UnifiedBannerAD(this, unifiedBannerADListener);
        unifiedBannerAD.m3678a(activity, str, str2);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = unifiedBannerAD;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }
}
