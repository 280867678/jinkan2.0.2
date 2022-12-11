package me.tvspark.view.activity;

import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.DelWebsiteAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.bs0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.eo0;
import me.tvspark.ln0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.dialog.DialogOperate;
import me.tvspark.x11;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class DelWebsiteActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public DelWebsiteAdapter Wwwwwwwwwwwwwwww;
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.recycler_view)
    public RecyclerView rvContent;
    public String Wwwwwwwwwwwwwwwww = DelWebsiteActivity.class.getSimpleName() + "_interstitial";
    public List<WebSourceTitaData> Wwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DelWebsiteActivity delWebsiteActivity = DelWebsiteActivity.this;
            if (delWebsiteActivity != null) {
                try {
                    if (delWebsiteActivity.Wwwwwwwwwwwwwww == null || delWebsiteActivity.Wwwwwwwwwwwwwww.isEmpty()) {
                        eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(delWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "自定义为空");
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer("[");
                    int i = 0;
                    while (i < delWebsiteActivity.Wwwwwwwwwwwwwww.size()) {
                        stringBuffer.append("\"");
                        stringBuffer.append(delWebsiteActivity.Wwwwwwwwwwwwwww.get(i).toCustomJson());
                        stringBuffer.append("\"");
                        i++;
                        stringBuffer.append(i != delWebsiteActivity.Wwwwwwwwwwwwwww.size() ? "," : "]");
                    }
                    ((ClipboardManager) delWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(stringBuffer.toString());
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(delWebsiteActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "已复制所有自定义规则");
                    stringBuffer.toString();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {

        /* renamed from: me.tvspark.view.activity.DelWebsiteActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class DialogInterface$OnClickListenerC3498Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public DialogInterface$OnClickListenerC3498Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DelWebsiteActivity.this.Wwwwwwwwwwwwwww.clear();
                DelWebsiteActivity delWebsiteActivity = DelWebsiteActivity.this;
                delWebsiteActivity.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(delWebsiteActivity.Wwwwwwwwwwwwwww);
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                CustomWebEvent customWebEvent = new CustomWebEvent();
                customWebEvent.setToAdd(false);
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new AlertDialog.Builder(DelWebsiteActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", new DialogInterface$OnClickListenerC3498Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this)).setPositiveButton("删除", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setMessage("确定删除全部站源 ？").show();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DelWebsiteAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
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
        return R.layout.activity_del_website;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, baseActivity.getResources().getColor(R.color.f5061white));
        this.Wwwwwwwwwwwwwwww = new DelWebsiteAdapter(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.rvContent.setLayoutManager(new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwwww, 2));
        this.rvContent.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9)));
        this.rvContent.setAdapter(this.Wwwwwwwwwwwwwwww);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new bs0(this));
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DelWebsiteActivity.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwwwww);
        }
        if (ApplicationC1880C.Wwwwwwwww || ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww)) {
            return;
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.Wwwwwwwwwwwwwwwwww.destroy();
            this.Wwwwwwwwwwwwwwwwww = null;
        }
        UnifiedInterstitialAD unifiedInterstitialAD2 = new UnifiedInterstitialAD(this, "7083579656567267", this);
        this.Wwwwwwwwwwwwwwwwww = unifiedInterstitialAD2;
        this.Wwwwwwwwwwwwwwwwww = unifiedInterstitialAD2;
        this.Wwwwwwwwwwwwwwwwww.setVideoOption(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, 1, true));
        this.Wwwwwwwwwwwwwwwwww.loadAD();
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
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwwwwwwwwwwwwwww);
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

    @OnClick({R.id.iv_back, R.id.tv_more})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else if (id != R.id.tv_more) {
        } else {
            new DialogOperate(this.Wwwwwwwwwwwwwwwwwwwwwwww, new String[]{"删除全部站源", "复制全部站源"}, new Integer[]{Integer.valueOf((int) R.drawable.ic_web_source_del_red), Integer.valueOf((int) R.drawable.ic_drawer_share)}, new View.OnClickListener[]{new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()}).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onWebSourceAdded(CustomWebEvent customWebEvent) {
        if (customWebEvent.isToAdd()) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new bs0(this));
        } else if (customWebEvent.getPositionInList() >= this.Wwwwwwwwwwwwwww.size()) {
        } else {
            this.Wwwwwwwwwwwwwww.remove(customWebEvent.getPositionInList());
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        }
    }
}
