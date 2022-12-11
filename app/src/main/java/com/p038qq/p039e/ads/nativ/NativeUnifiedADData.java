package com.p038qq.p039e.ads.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.nativ.widget.NativeAdContainer;
import com.p038qq.p039e.comm.p040pi.LADI;
import com.p038qq.p039e.comm.p040pi.NFBI;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedADData */
/* loaded from: classes3.dex */
public interface NativeUnifiedADData extends LADI, NFBI {
    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list);

    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2);

    void bindCTAViews(List<View> list);

    void bindImageViews(List<ImageView> list, int i);

    void bindImageViews(List<ImageView> list, byte[] bArr);

    void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener);

    void destroy();

    boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData);

    int getAdPatternType();

    NativeUnifiedADAppMiitInfo getAppMiitInfo();

    double getAppPrice();

    int getAppScore();

    int getAppStatus();

    String getButtonText();

    String getCTAText();

    String getDesc();

    long getDownloadCount();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    String getTitle();

    int getVideoCurrentPosition();

    int getVideoDuration();

    boolean isAppAd();

    boolean isWeChatCanvasAd();

    void negativeFeedback();

    void pauseAppDownload();

    void pauseVideo();

    void preloadVideo(VideoPreloadListener videoPreloadListener);

    @Deprecated
    void resume();

    void resumeAppDownload();

    void resumeVideo();

    void setNativeAdEventListener(NativeADEventListener nativeADEventListener);

    void setVideoMute(boolean z);

    void startVideo();

    void stopVideo();
}
