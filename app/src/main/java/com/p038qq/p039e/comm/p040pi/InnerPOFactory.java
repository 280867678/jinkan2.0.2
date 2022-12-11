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

/* renamed from: com.qq.e.comm.pi.InnerPOFactory */
/* loaded from: classes3.dex */
public interface InnerPOFactory {
    SVSD getAPKDownloadServiceDelegate(Service service);

    ACTD getActivityDelegate(String str, Activity activity);

    String getBuyerId();

    String getBuyerId(Map<String, Object> map);

    DFA getGDTApkDelegate(IGDTApkListener iGDTApkListener);

    HADI getHybridAD(HybridADSetting hybridADSetting, HybridADListener hybridADListener);

    NUADI getNativeAdManagerDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    NEADI getNativeExpressADDelegate(Context context, ADSize aDSize, String str, String str2, String str3, ADListener aDListener);

    NSPVI getNativeSplashAdView(Context context, String str, String str2, String str3);

    RVADI getRewardVideoADDelegate(Context context, String str, String str2, String str3, ADListener aDListener);

    String getSDKInfo(String str);

    UBVI getUnifiedBannerViewDelegate(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, String str3, ADListener aDListener);

    UIADI getUnifiedInterstitialADDelegate(Activity activity, String str, String str2, String str3, ADListener aDListener);

    int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener);
}
