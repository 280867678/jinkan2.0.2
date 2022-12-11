package com.p038qq.p039e.comm.p040pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.p038qq.p039e.ads.banner2.UnifiedBannerView;
import com.p038qq.p039e.ads.dfa.GDTAppDialogClickListener;
import com.p038qq.p039e.ads.dfa.IGDTApkListener;
import com.p038qq.p039e.ads.hybrid.HybridADListener;
import com.p038qq.p039e.ads.hybrid.HybridADSetting;
import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.comm.adevent.ADListener;
import java.util.Map;

/* renamed from: com.qq.e.comm.pi.POFactory */
/* loaded from: classes3.dex */
public interface POFactory extends InnerPOFactory {
    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ SVSD getAPKDownloadServiceDelegate(Service service);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ ACTD getActivityDelegate(String str, Activity activity);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ String getBuyerId(Map<String, Object> map);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ String getSDKInfo(String str);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    @Override // com.p038qq.p039e.comm.p040pi.InnerPOFactory
    /* synthetic */ int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
