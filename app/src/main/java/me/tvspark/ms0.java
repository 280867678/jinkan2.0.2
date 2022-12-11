package me.tvspark;

import android.widget.FrameLayout;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import com.p038qq.p039e.comm.util.AdError;
import java.util.List;
import me.tvspark.view.activity.DetailActivity;

/* loaded from: classes4.dex */
public class ms0 implements NativeExpressAD.NativeExpressADListener {
    public final /* synthetic */ DetailActivity Wwwwwwwwwwwwwwwwwwwwwwww;

    public ms0(DetailActivity detailActivity) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = detailActivity;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        FrameLayout frameLayout = this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative;
        if (frameLayout == null || frameLayout.getChildCount() <= 0) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.removeAllViews();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.setVisibility(8);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        list.size();
        NativeExpressADView nativeExpressADView = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww = list.get(0);
        NativeExpressADView nativeExpressADView2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww;
        nativeExpressADView2.sendWinNotification(nativeExpressADView2.getECPM());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww.getECPM();
        DetailActivity detailActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (detailActivity.Wwwwwwwwwwwwww == null || detailActivity.flytNative.getVisibility() != 8) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.setVisibility(0);
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.getChildCount() > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.removeAllViews();
        }
        DetailActivity detailActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        detailActivity2.flytNative.addView(detailActivity2.Wwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww.render();
    }

    @Override // com.p038qq.p039e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
    }
}
