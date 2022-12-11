package me.tvspark.view.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;
import com.efs.sdk.base.Constants;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import com.p038qq.p039e.ads.splash.SplashAD;
import com.p038qq.p039e.ads.splash.SplashADListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import com.umeng.commonsdk.statistics.C1767b;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.List;
import me.tvspark.a30;
import me.tvspark.am0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.rn0;
import me.tvspark.tm0;
import me.tvspark.um0;
import me.tvspark.vn0;
import me.tvspark.w20;
import white.whale.R;

/* loaded from: classes4.dex */
public class GActivity extends BaseActivity<tm0> implements SplashADListener, um0 {
    public SplashAD Wwwwwwwwwwwwwww;
    public NativeExpressADView Wwwwwwwwwwwwwwwww;
    public NativeExpressAD Wwwwwwwwwwwwwwwwww;
    @BindView(R.id.splash_container1)
    public RelativeLayout container1;
    @BindView(R.id.iv_splash)
    public ImageView ivSplash;
    @BindView(R.id.tv_skip_view)
    public TextView tvSkipView;
    @BindView(R.id.tv_version)
    public TextView tvVersion;
    public boolean Wwwwwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwww = false;
    public rn0 Wwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(7000, 1000);

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements NativeExpressAD.NativeExpressADListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            GActivity.this.Wwwwwwwwwwwww();
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
            NativeExpressADView nativeExpressADView = GActivity.this.Wwwwwwwwwwwwwwwww;
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
            GActivity.this.Wwwwwwwwwwwwwwwww = list.get(0);
            NativeExpressADView nativeExpressADView2 = GActivity.this.Wwwwwwwwwwwwwwwww;
            nativeExpressADView2.sendWinNotification(nativeExpressADView2.getECPM());
            GActivity.this.Wwwwwwwwwwwwwwwww.getECPM();
            GActivity gActivity = GActivity.this;
            if (gActivity.Wwwwwwwwwwwwwwww) {
                gActivity.Wwwwwwwwww();
            }
        }

        @Override // com.p038qq.p039e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            String.format("Splash2 onNoAD，eCode = %d, eMsg = %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
            GActivity gActivity = GActivity.this;
            gActivity.Wwwwwwwwwwwww = true;
            if (gActivity.Wwwwwwwwwwwwww) {
                gActivity.Wwwwwwwwwwwwwwwwwww = true;
                gActivity.Wwwwwwwwwwwww();
            }
        }

        @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends rn0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) {
            super(j, j2);
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }

        @Override // me.tvspark.rn0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
            if (!GActivity.this.isFinishing()) {
                try {
                    long j2 = j / 1000;
                    TextView textView = GActivity.this.tvSkipView;
                    textView.setText("跳过 " + j2);
                    if (j2 != 1) {
                        return;
                    }
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    GActivity.this.Wwwwwwwwwwwww();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            GActivity.this.Wwwwwwwwwwww = null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            GActivity.this.Wwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GActivity gActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            System.exit(0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            GActivity gActivity = GActivity.this;
            if (!z) {
                gActivity.Wwwwwwwwwwww();
            } else if (gActivity == null) {
                throw null;
            } else {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_type");
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                    gActivity.ivSplash.setVisibility(0);
                    vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(gActivity.Wwwwwwwwwwwwwwwwwwwwwwww, bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_pic"), gActivity.ivSplash, Constants.CP_NONE);
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    if (gActivity.container1.getVisibility() == 8) {
                        System.exit(0);
                    }
                    gActivity.Wwwwwwwwwwwwww();
                    gActivity.Wwwwwwwwww();
                } else {
                    if (gActivity.container1.getVisibility() == 8) {
                        System.exit(0);
                    }
                    gActivity.Wwwwwwwwwwwwww();
                    SplashAD splashAD = new SplashAD(gActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "1051825003086984", gActivity, 0);
                    gActivity.Wwwwwwwwwwwwwww = splashAD;
                    splashAD.fetchAndShowIn(gActivity.container1);
                }
            }
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (!z) {
                GActivity.this.Wwwwwwwwwwww();
                return;
            }
            a30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, list);
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予权限");
        }
    }

    static {
        StubApp.interface11(11209);
    }

    public final void Wwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwww = true;
            return;
        }
        if (this.container1.getChildCount() > 0) {
            this.container1.removeAllViews();
        }
        this.container1.addView(this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.render();
        this.tvSkipView.setVisibility(0);
        rn0 rn0Var = this.Wwwwwwwwwwww;
        if (rn0Var == null) {
            return;
        }
        rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwww() {
        a30 a30Var = new a30(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UMUtils.SD_PERMISSION);
        a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("android.permission.READ_PHONE_STATE");
        a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public void Wwwwwwwwwwww() {
        new AlertDialog.Builder(this).setPositiveButton("授权", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("拒绝", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).setCancelable(false).setTitle("授权").setMessage("需要相应权限，APP才能继续运行.").show();
    }

    public final void Wwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwww = true;
        } else if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww) || nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getApplication()).equals(C1767b.f4025f)) {
            System.exit(0);
        } else {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            finish();
        }
    }

    public final void Wwwwwwwwwwwwww() {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(this.Wwwwwwwwwwwwwwwwwwwwwwww, new ADSize(-1, -2), "7063674646353742", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwww = nativeExpressAD;
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
        this.Wwwwwwwwwwwwwwwwww.loadAD(1);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public tm0 Wwwwwwwwwwwwwwww() {
        return new am0();
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_splash;
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADClicked() {
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADDismissed() {
        Wwwwwwwwwwwww();
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADExposure() {
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        SplashAD splashAD = this.Wwwwwwwwwwwwwww;
        if (splashAD != null) {
            splashAD.sendWinNotification(splashAD.getECPM());
            this.Wwwwwwwwwwwwwww.getECPM();
        }
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onADTick(long j) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        NativeExpressADView nativeExpressADView = this.Wwwwwwwwwwwwwwwww;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
        rn0 rn0Var = this.Wwwwwwwwwwww;
        if (rn0Var != null) {
            rn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // com.p038qq.p039e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        String.format("Splash1 onNoAD，eCode = %d, eMsg = %s", Integer.valueOf(adError.getErrorCode()), adError.getErrorMsg());
        if (this.container1.getVisibility() == 8) {
            System.exit(0);
        }
        this.Wwwwwwwwwwwwww = true;
        if (!this.Wwwwwwwwwwwww) {
            Wwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Wwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwww();
        }
        this.Wwwwwwwwwwwwwwwwwww = true;
    }

    @OnClick({R.id.iv_splash, R.id.tv_skip_view})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_splash) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("data_url"));
        } else if (id != R.id.tv_skip_view) {
        } else {
            Wwwwwwwwwwwww();
        }
    }
}
