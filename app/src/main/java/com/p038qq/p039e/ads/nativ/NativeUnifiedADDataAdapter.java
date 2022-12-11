package com.p038qq.p039e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.nativ.widget.NativeAdContainer;
import com.p038qq.p039e.comm.adevent.ADEvent;
import com.p038qq.p039e.comm.adevent.ADEventListener;
import com.p038qq.p039e.comm.adevent.ADListener;
import com.p038qq.p039e.comm.compliance.DownloadConfirmCallBack;
import com.p038qq.p039e.comm.compliance.DownloadConfirmListener;
import com.p038qq.p039e.comm.listeners.NegativeFeedbackListener;
import com.p038qq.p039e.comm.util.AdErrorConvertor;
import java.util.List;
import java.util.Map;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter */
/* loaded from: classes3.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {
    public NegativeFeedbackListener Wwwwwwwwwwwwwwwwwww;
    public VideoPreloadListener Wwwwwwwwwwwwwwwwwwww;
    public DownloadConfirmListener Wwwwwwwwwwwwwwwwwwwww;
    public NativeADMediaListener Wwwwwwwwwwwwwwwwwwwwww;
    public NativeADEventListener Wwwwwwwwwwwwwwwwwwwwwww;
    public NativeUnifiedADData Wwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedADDataAdapter$UnifiedAdListener */
    /* loaded from: classes3.dex */
    public class UnifiedAdListener implements ADListener {
        public /* synthetic */ UnifiedAdListener(C10521 c10521) {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0102 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
        @Override // com.p038qq.p039e.comm.adevent.ADListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onADEvent(ADEvent aDEvent) {
            boolean z;
            boolean z2;
            boolean z3;
            NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter = NativeUnifiedADDataAdapter.this;
            if (nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww != null) {
                int type = aDEvent.getType();
                if (type == 103) {
                    nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww.onADExposed();
                } else if (type == 105) {
                    NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww;
                    if (nativeADEventListener instanceof NativeADEventListenerWithClickInfo) {
                        ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww).onADClicked((View) aDEvent.getParam(View.class));
                    } else {
                        nativeADEventListener.onADClicked();
                    }
                } else if (type == 107) {
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww.onADError(AdErrorConvertor.formatErrorCode(num.intValue()));
                    }
                } else if (type == 111) {
                    nativeUnifiedADDataAdapter.Wwwwwwwwwwwwwwwwwwwwwww.onADStatusChanged();
                }
                z = true;
                if (!z) {
                    return;
                }
                NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter2 = NativeUnifiedADDataAdapter.this;
                if (nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww != null) {
                    switch (aDEvent.getType()) {
                        case 201:
                            Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                            if (num2 != null) {
                                nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoLoaded(num2.intValue());
                            }
                            z2 = true;
                            break;
                        case 202:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoStart();
                            z2 = true;
                            break;
                        case 203:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoResume();
                            z2 = true;
                            break;
                        case 204:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoPause();
                            z2 = true;
                            break;
                        case 205:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoStop();
                            z2 = true;
                            break;
                        case 206:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoCompleted();
                            z2 = true;
                            break;
                        case 207:
                            Integer num3 = (Integer) aDEvent.getParam(Integer.class);
                            if (num3 != null) {
                                nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoError(AdErrorConvertor.formatErrorCode(num3.intValue()));
                            }
                            z2 = true;
                            break;
                        case 208:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoClicked();
                            z2 = true;
                            break;
                        case 209:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoInit();
                            z2 = true;
                            break;
                        case 210:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoReady();
                            z2 = true;
                            break;
                        case 211:
                            nativeUnifiedADDataAdapter2.Wwwwwwwwwwwwwwwwwwwwww.onVideoLoading();
                            z2 = true;
                            break;
                    }
                    if (!z2) {
                        return;
                    }
                    NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter3 = NativeUnifiedADDataAdapter.this;
                    if (nativeUnifiedADDataAdapter3.Wwwwwwwwwwwwwwwwwwww != null) {
                        int type2 = aDEvent.getType();
                        if (type2 == 212) {
                            nativeUnifiedADDataAdapter3.Wwwwwwwwwwwwwwwwwwww.onVideoCached();
                        } else if (type2 == 213) {
                            if (((Integer) aDEvent.getParam(Integer.class)) != null) {
                                nativeUnifiedADDataAdapter3.Wwwwwwwwwwwwwwwwwwww.onVideoCacheFailed(5002, "视频下载失败");
                            }
                        }
                        z3 = true;
                        if (!z3) {
                            return;
                        }
                        NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter4 = NativeUnifiedADDataAdapter.this;
                        if (nativeUnifiedADDataAdapter4.Wwwwwwwwwwwwwwwwwww == null || aDEvent.getType() != 304) {
                            return;
                        }
                        nativeUnifiedADDataAdapter4.Wwwwwwwwwwwwwwwwwww.onComplainSuccess();
                        return;
                    }
                    z3 = false;
                    if (!z3) {
                    }
                }
                z2 = false;
                if (!z2) {
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(null));
        }
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindCTAViews(list);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindImageViews(list, i);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindImageViews(list, bArr);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.Wwwwwwwwwwwwwwwwwwwwww = nativeADMediaListener;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.bindMediaView(mediaView, videoOption, null);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.destroy();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAdPatternType();
    }

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getApkInfoUrl();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAppMiitInfo();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAppPrice();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAppScore();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getAppStatus();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getButtonText();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getCTAText();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getDesc();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getDownloadCount();
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public int getECPM() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getECPM();
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public String getECPMLevel() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getECPMLevel();
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getExtraInfo();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getIconUrl();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getImgList();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getImgUrl();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getPictureHeight();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getPictureWidth();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getProgress();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getTitle();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getVideoCurrentPosition();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getVideoDuration();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isAppAd();
    }

    @Override // com.p038qq.p039e.comm.p040pi.LADI
    public boolean isValid() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isValid();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.isWeChatCanvasAd();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.negativeFeedback();
    }

    @Override // com.p038qq.p039e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.Wwwwwwwwwwwwwwwwwwwww;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.pauseAppDownload();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.pauseVideo();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.Wwwwwwwwwwwwwwwwwwww = videoPreloadListener;
        this.Wwwwwwwwwwwwwwwwwwwwwwww.preloadVideo(null);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.resumeAppDownload();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.resumeVideo();
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

    @Override // com.p038qq.p039e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.Wwwwwwwwwwwwwwwwwwwww = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = nativeADEventListener;
    }

    @Override // com.p038qq.p039e.comm.p040pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.Wwwwwwwwwwwwwwwwwww = negativeFeedbackListener;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setVideoMute(z);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.startVideo();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.stopVideo();
    }
}
