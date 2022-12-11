package me.tvspark.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import java.util.Locale;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.mn0;
import me.tvspark.nn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class AboutActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww = 0;
    @BindView(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tv_email)
    public TextView tvEmail;
    @BindView(R.id.tv_god)
    public TextView tvGod;
    @BindView(R.id.tv_version)
    public TextView tvVersion;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity baseActivity;
            if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                AboutActivity aboutActivity = AboutActivity.this;
                int i = aboutActivity.Wwwwwwwwwwwwwwwwwww + 1;
                aboutActivity.Wwwwwwwwwwwwwwwwwww = i;
                if (i != 12) {
                    return;
                }
                aboutActivity.Wwwwwwwwwwwwwwwwwww = 0;
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("req_count", -4);
                Toast.makeText(AboutActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "emm 1", 0).show();
                baseActivity = AboutActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                AboutActivity aboutActivity2 = AboutActivity.this;
                int i2 = aboutActivity2.Wwwwwwwwwwwwwwwwwww + 1;
                aboutActivity2.Wwwwwwwwwwwwwwwwwww = i2;
                if (i2 != 12) {
                    return;
                }
                aboutActivity2.Wwwwwwwwwwwwwwwwwww = 0;
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("req_count", 0);
                Toast.makeText(AboutActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "emm 0", 0).show();
                baseActivity = AboutActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            }
            mn0.Wwwwwwwwwwwwwwwwwwwwwwww(baseActivity);
        }
    }

    static {
        StubApp.interface11(11089);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_about;
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        if (this.Wwwwwwwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwwwwwwww.setMediaListener(this);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww;
        unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        this.Wwwwwwwwwwwwwwwwww.getECPM();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        String.format(Locale.getDefault(), "onNoAD, error code: %d, error msg: %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        unifiedInterstitialAD.showAsPopupWindow();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        adError.getErrorCode();
        adError.getErrorMsg();
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
    }
}
