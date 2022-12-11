package com.p038qq.p039e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.p038qq.p039e.ads.LiteAbstractAD;
import com.p038qq.p039e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.constants.ErrorCode;
import com.p038qq.p039e.comm.constants.LoadAdParams;
import com.p038qq.p039e.comm.listeners.ADRewardListener;
import com.p038qq.p039e.comm.p040pi.IReward;
import com.p038qq.p039e.comm.p040pi.NSPVI;
import com.p038qq.p039e.comm.p040pi.POFactory;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import com.p038qq.p039e.comm.util.GDTLogger;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.splash.SplashAD */
/* loaded from: classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {
    public int Wwwwwwwww;
    public volatile ServerSideVerificationOptions Wwwwwwwwww;
    public volatile byte[] Wwwwwwwwwww;
    public volatile int Wwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwww;
    public volatile boolean Wwwwwwwwwwwwwww;
    public volatile LoadAdParams Wwwwwwwwwwwwwwww;
    public volatile ADRewardListener Wwwwwwwwwwwwwwwww;
    public volatile SplashADListener Wwwwwwwwwwwwwwwwww;
    public volatile ViewGroup Wwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.splash.SplashAD$ADListenerAdapter */
    /* loaded from: classes3.dex */
    public class ADListenerAdapter implements ADListener {
        public /* synthetic */ ADListenerAdapter(C10551 c10551) {
        }

        @Override // com.p038qq.p039e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.Wwwwwwwwwwwwwwwwww == null) {
                GDTLogger.m3647d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l = (Long) aDEvent.getParam(Long.class);
                    if (l == null) {
                        return;
                    }
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onADLoaded(l.longValue());
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num == null) {
                        return;
                    }
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    return;
                case 102:
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onADPresent();
                    return;
                case 103:
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.Wwwwwwwwwwwwwwwww == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(ServerSideVerificationOptions.TRANS_ID, str);
                    SplashAD.this.Wwwwwwwwwwwwwwwww.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onADClicked();
                    return;
                case 106:
                    SplashAD.this.Wwwwwwwwwwwwwwwwww.onADDismissed();
                    return;
                default:
                    switch (type) {
                        case 112:
                            Long l2 = (Long) aDEvent.getParam(Long.class);
                            if (l2 == null) {
                                return;
                            }
                            SplashAD.this.Wwwwwwwwwwwwwwwwww.onADTick(l2.longValue());
                            return;
                        case 113:
                            if (!(SplashAD.this.Wwwwwwwwwwwwwwwwww instanceof SplashADZoomOutListener)) {
                                return;
                            }
                            ((SplashADZoomOutListener) SplashAD.this.Wwwwwwwwwwwwwwwwww).onZoomOut();
                            return;
                        case 114:
                            if (!(SplashAD.this.Wwwwwwwwwwwwwwwwww instanceof SplashADZoomOutListener)) {
                                return;
                            }
                            ((SplashADZoomOutListener) SplashAD.this.Wwwwwwwwwwwwwwwwww).onZoomOutPlayFinish();
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.Wwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwww = splashADListener;
        this.Wwwwwwwww = i;
        m3679a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.Wwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwww = splashADListener;
        this.Wwwwwwwww = i;
        m3678a(context, str, str2);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.m3646e("传入参数错误，container参数为空");
            m3680a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.f657a;
        if (t == 0) {
            this.Wwwwwwwwwwwwwwwwwww = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.m3646e("传入参数有误：传入container参数为空");
            m3680a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.f657a;
        if (t == 0) {
            this.Wwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwwwwwwww = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwww = z;
            this.Wwwwwwwwwwwwww = true;
            return;
        }
        T t = this.f657a;
        if (t == 0) {
            m3677a("fetchAdInner");
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAdOnly();
        } else {
            nspvi.fetchAdOnly();
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public Object mo3669a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: a */
    public void mo3668a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.Wwwwwwwwwwwwwwww != null) {
            nspvi.setLoadAdParams(this.Wwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwww != 0) {
            nspvi.setDeveloperLogo(this.Wwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwww != null) {
            nspvi.setDeveloperLogo(this.Wwwwwwwwwww);
        }
        nspvi.setFetchDelay(this.Wwwwwwwww);
        nspvi.setAdListener(new ADListenerAdapter(null));
        nspvi.setServerSideVerificationOptions(this.Wwwwwwwwww);
        if ((this.Wwwwwwwwwwwwwwwwww instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.Wwwwwwwwwwwwwwwwww).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.Wwwwwwwwwwwwwwwwwww != null) {
            if (this.Wwwwwwwwwwwww) {
                fetchFullScreenAndShowIn(this.Wwwwwwwwwwwwwwwwwww);
            } else {
                fetchAndShowIn(this.Wwwwwwwwwwwwwwwwwww);
            }
        }
        if (this.Wwwwwwwwwwwwwww) {
            nspvi.preload();
            this.Wwwwwwwwwwwwwww = false;
        }
        if (this.Wwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwww) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.Wwwwwwwwwwwwww = false;
        }
    }

    @Override // com.p038qq.p039e.ads.AbstractAD
    /* renamed from: b */
    public void mo3667b(int i) {
        if (this.Wwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwww.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void fetchAdOnly() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.f657a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        m3677a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.f657a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        m3677a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (!m3681a()) {
            return;
        }
        if (!m3676b()) {
            this.Wwwwwwwwwwwwwww = true;
            return;
        }
        T t = this.f657a;
        if (t != 0) {
            ((NSPVI) t).preload();
        } else {
            m3677a("preLoad");
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.f657a;
        if (t == 0) {
            this.Wwwwwwwwwwww = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f657a;
        if (t == 0) {
            this.Wwwwwwwwwww = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f657a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.Wwwwwwwwwwwwwwww = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.Wwwwwwwwwwwwwwwww = aDRewardListener;
    }

    @Override // com.p038qq.p039e.comm.p040pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.Wwwwwwwwww = serverSideVerificationOptions;
        T t = this.f657a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.f657a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            m3677a("zoomOutAnimationFinish");
        }
    }
}
