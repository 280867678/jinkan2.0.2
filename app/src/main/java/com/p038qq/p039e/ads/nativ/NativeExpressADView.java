package com.p038qq.p039e.ads.nativ;

import android.content.Context;
import android.widget.FrameLayout;
import com.p038qq.p039e.comm.compliance.DownloadConfirmListener;
import com.p038qq.p039e.comm.p040pi.AdData;
import com.p038qq.p039e.comm.p040pi.LADI;
import com.p038qq.p039e.comm.p040pi.NFBI;

/* renamed from: com.qq.e.ads.nativ.NativeExpressADView */
/* loaded from: classes3.dex */
public abstract class NativeExpressADView extends FrameLayout implements DownloadConfirmListener, LADI, NFBI {

    /* renamed from: com.qq.e.ads.nativ.NativeExpressADView$ViewBindStatusListener */
    /* loaded from: classes3.dex */
    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(Context context) {
        super(context);
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    @Deprecated
    public abstract void setAdSize(ADSize aDSize);

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);

    public abstract void setViewBindStatusListener(ViewBindStatusListener viewBindStatusListener);
}
