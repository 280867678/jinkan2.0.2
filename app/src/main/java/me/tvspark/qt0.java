package me.tvspark;

import android.widget.FrameLayout;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import com.p038qq.p039e.comm.util.AdError;
import java.util.List;
import me.tvspark.view.fragment.RecIndexFragment;

/* loaded from: classes4.dex */
public class qt0 implements NativeExpressAD.NativeExpressADListener {
    public final /* synthetic */ RecIndexFragment Wwwwwwwwwwwwwwwwwwwwwwww;

    public qt0(RecIndexFragment recIndexFragment) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww = recIndexFragment;
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
        NativeExpressADView nativeExpressADView = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.getVisibility() != 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.setVisibility(0);
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.getChildCount() > 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.flytNative.removeAllViews();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww = list.get(0);
        NativeExpressADView nativeExpressADView2 = this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww;
        nativeExpressADView2.sendWinNotification(nativeExpressADView2.getECPM());
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww.getECPM();
        RecIndexFragment recIndexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        recIndexFragment.flytNative.addView(recIndexFragment.Wwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwww.render();
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
