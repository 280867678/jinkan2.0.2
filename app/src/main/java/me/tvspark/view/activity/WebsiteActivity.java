package me.tvspark.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.ln0;
import me.tvspark.mn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebsiteActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwww;
    public WebSourceTitaData Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_content)
    public FrameLayout flytContent;
    @BindView(R.id.iv_add)
    public ImageView ivAdd;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public boolean Wwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwwww = false;
    public String Wwwwwwwwwwwwwww = WebsiteActivity.class.getSimpleName() + "_interstitial";

    static {
        StubApp.interface11(11319);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_website;
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
        if (this.Wwwwwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwwwwww.setMediaListener(this);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwww;
        unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        this.Wwwwwwwwwwwwwwww.getECPM();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwwww) == null) {
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

    @OnClick({R.id.iv_back, R.id.iv_search, R.id.iv_add})
    public void onViewClicked(View view) {
        ImageView imageView;
        int i;
        int id = view.getId();
        if (id == R.id.iv_add) {
            if (this.Wwwwwwwwwwwwwwwwww) {
                imageView = this.ivAdd;
                i = R.drawable.ic_website_add;
            } else {
                imageView = this.ivAdd;
                i = R.drawable.ic_website_remove;
            }
            imageView.setImageResource(i);
            Intent intent = new Intent();
            intent.putExtra("key_boolean", !this.Wwwwwwwwwwwwwwwwww);
            intent.putExtra("key_string", this.Wwwwwwwwwwwwwwwwwww.getBaseUrl());
            intent.putExtra("key_string_one", this.Wwwwwwwwwwwwwwwwwww.getName());
            setResult(-1, intent);
        } else if (id != R.id.iv_back) {
            if (id != R.id.iv_search) {
                return;
            }
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "", this.Wwwwwwwwwwwwwwwwwww.trans2WebSourceIndexData());
            return;
        }
        finish();
    }
}
