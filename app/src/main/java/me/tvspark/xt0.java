package me.tvspark;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.p038qq.p039e.ads.banner2.UnifiedBannerADListener;
import com.p038qq.p039e.ads.banner2.UnifiedBannerView;
import com.p038qq.p039e.comm.util.AdError;
import me.tvspark.data.bean.VersionParcel;

/* loaded from: classes4.dex */
public class xt0 extends RelativeLayout implements UnifiedBannerADListener {
    public ImageView Wwwwwwwwwwwwwwwwwww;
    public UnifiedBannerView Wwwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwwwwwww;
    public Point Wwwwwwwwwwwwwwwwwwwww = new Point();
    public String Wwwwwwwwwwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
            if (versionParcel == null || TextUtils.isEmpty(versionParcel.getBanner_url())) {
                return;
            }
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(xt0.this.Wwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwwwwwww.getBanner_url());
        }
    }

    public xt0(Activity activity) {
        super(activity);
        this.Wwwwwwwwwwwwwwwwwwwwwww = activity;
    }

    public xt0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
        this.Wwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "_AdViewBanner");
        if (ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww)) {
            setVisibility(8);
        } else {
            if (i == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwww.getWindowManager().getDefaultDisplay().getSize(this.Wwwwwwwwwwwwwwwwwwwww);
                i = this.Wwwwwwwwwwwwwwwwwwwww.x;
            }
            ImageView imageView = new ImageView(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww = imageView;
            imageView.setBackgroundColor(Color.parseColor("#ffffff"));
            float f = i;
            this.Wwwwwwwwwwwwwwwwwww.setLayoutParams(new RelativeLayout.LayoutParams(i, Math.round(f / 6.6f)));
            VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
            if (versionParcel == null || TextUtils.isEmpty(versionParcel.getBanner_pic())) {
                vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "", this.Wwwwwwwwwwwwwwwwwww);
            } else {
                vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwwwwwww.getBanner_pic(), this.Wwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwww.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            addView(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwww = new UnifiedBannerView(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww, this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, Math.round(f / 6.4f));
            layoutParams.setMargins(0, 0, 0, 0);
            this.Wwwwwwwwwwwwwwwwwwwwww.setLayoutParams(layoutParams);
            this.Wwwwwwwwwwwwwwwwwwwwww.setRefresh(0);
            this.Wwwwwwwwwwwwwwwwwwwwww.loadAD();
            addView(this.Wwwwwwwwwwwwwwwwwwwwww);
        }
        return this;
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onADClicked() {
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onADClosed() {
        setVisibility(8);
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onADExposure() {
        ImageView imageView = this.Wwwwwwwwwwwwwwwwwww;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onADLeftApplication() {
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onADReceive() {
        UnifiedBannerView unifiedBannerView = this.Wwwwwwwwwwwwwwwwwwwwww;
        unifiedBannerView.sendWinNotification(unifiedBannerView.getECPM());
        this.Wwwwwwwwwwwwwwwwwwwwww.getECPM();
    }

    @Override // com.p038qq.p039e.ads.banner2.UnifiedBannerADListener
    public void onNoAD(AdError adError) {
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwwwwwwwwwwwwwwwwww);
        setVisibility(8);
    }
}
