package me.tvspark.view.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import java.util.List;
import me.tvspark.adapter.RankListDetailAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.ln0;
import me.tvspark.r40;
import me.tvspark.vn0;
import me.tvspark.widget.AppBarStateChangeListener;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class RankListActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwww;
    public List<VideoParcel> Wwwwwwwwwwwwwwwwww;
    public RankListDetailAdapter Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.app_bar)
    public AppBarLayout appBar;
    @BindView(R.id.collapsing_toolbar)
    public CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.iv_color)
    public RoundImageView ivColor;
    @BindView(R.id.iv_cover_bg)
    public ImageView ivCoverBg;
    @BindView(R.id.iv_cover_mask)
    public ImageView ivCoverMask;
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tv_hot)
    public TextView tvHot;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public String Wwwwwwwwwwwwwwwww = "";
    public int Wwwwwwwwwwwwwwww = 0;
    public String Wwwwwwwwwwwwww = RankListActivity.class.getSimpleName() + "_interstitial";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends AppBarStateChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.AppBarStateChangeListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            if (state == AppBarStateChangeListener.State.EXPANDED) {
                RankListActivity.this.getSupportActionBar().setTitle("");
                RankListActivity rankListActivity = RankListActivity.this;
                if (rankListActivity.Wwwwwwwwwwwwwwww == 0) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) rankListActivity.Wwwwwwwwwwwwwwwwwwwwwwww);
            } else if (state != AppBarStateChangeListener.State.COLLAPSED) {
            } else {
                if (!TextUtils.isEmpty(RankListActivity.this.Wwwwwwwwwwwwwwwww)) {
                    RankListActivity.this.getSupportActionBar().setTitle(RankListActivity.this.Wwwwwwwwwwwwwwwww);
                }
                RankListActivity rankListActivity2 = RankListActivity.this;
                int i = rankListActivity2.Wwwwwwwwwwwwwwww;
                if (i == 0) {
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) rankListActivity2.Wwwwwwwwwwwwwwwwwwwwwwww, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            RankListActivity rankListActivity = RankListActivity.this;
            rankListActivity.Wwwwwwwwwwwwwwww = i;
            rankListActivity.ivCoverMask.setBackgroundColor(i);
            RankListActivity.this.collapsingToolbar.setContentScrimColor(i);
            RankListActivity.this.ivColor.setBackgroundColor(i);
        }

        @Override // me.tvspark.vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bitmap bitmap) {
        }
    }

    static {
        StubApp.interface11(11243);
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
        return R.layout.activity_rank_list_detail;
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
        if (this.Wwwwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwwwww.setMediaListener(this);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwww;
        unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        this.Wwwwwwwwwwwwwww.getECPM();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwwwwwwwwwwww);
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwww) == null) {
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
