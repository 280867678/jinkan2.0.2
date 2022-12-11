package me.tvspark.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.tvspark.adapter.AllDownParentAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.bean.MyDownData;
import me.tvspark.data.event.FileEvent;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.pr0;
import me.tvspark.r40;
import me.tvspark.widget.selectionLayout.SelectionLayout;
import me.tvspark.x11;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class AllDownParentActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwww;
    public AllDownParentAdapter Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.fab_add)
    public FloatingActionButton ibtnAdd;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.slOverall)
    public SelectionLayout slOverall;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    public List<MyDownData> Wwwwwwwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwwwwwwww = 0;
    public List<String> Wwwwwwwwwwwwwww = new ArrayList();
    public List<Integer> Wwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements pr0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwww;
            public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText, EditText editText2, EditText editText3) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
                this.Wwwwwwwwwwwwwwwwwwwwwww = editText2;
                this.Wwwwwwwwwwwwwwwwwwwwww = editText3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
                String obj2 = this.Wwwwwwwwwwwwwwwwwwwwwww.getText().toString();
                String obj3 = this.Wwwwwwwwwwwwwwwwwwwwww.getText().toString();
                if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj3)) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请完整填写正确内容");
                    return;
                }
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "加入缓存任务列表");
                String replace = obj.replace("/", "");
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, obj3, bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww) + "download/" + replace + "/" + obj2.replace("/", "") + "-" + replace, -1L, 0);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View inflate = LayoutInflater.from(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).inflate(R.layout.view_web_sniffer_down, (ViewGroup) null);
            inflate.findViewById(R.id.input_url).setVisibility(0);
            new AlertDialog.Builder(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("新建缓存").setView(inflate).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("下载", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((EditText) inflate.findViewById(R.id.et_dir), (EditText) inflate.findViewById(R.id.et_file), (EditText) inflate.findViewById(R.id.et_url))).create().show();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SelectionLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.selectionLayout.SelectionLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, TextView textView) {
            BaseActivity baseActivity;
            int i3;
            if (AllDownParentActivity.this.Wwwwwwwwwwwwww.get(i2).intValue() == 6 && !nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "com.UCMobile")) {
                baseActivity = AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                i3 = R.string.uc_uninstall;
            } else if (AllDownParentActivity.this.Wwwwwwwwwwwwww.get(i2).intValue() == 5 && !nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, TbsConfig.APP_QB)) {
                baseActivity = AllDownParentActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                i3 = R.string.qq_uninstall;
            } else {
                AllDownParentActivity.this.Wwwwwwwwwwwwwwww = i2;
                AllDownParentActivity allDownParentActivity = AllDownParentActivity.this;
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_play_local_type", allDownParentActivity.Wwwwwwwwwwwwww.get(allDownParentActivity.Wwwwwwwwwwwwwwww));
            }
            Toast.makeText(baseActivity, i3, 0).show();
            AllDownParentActivity allDownParentActivity2 = AllDownParentActivity.this;
            textView.setText(allDownParentActivity2.Wwwwwwwwwwwwwww.get(allDownParentActivity2.Wwwwwwwwwwwwwwww));
            AllDownParentActivity allDownParentActivity3 = AllDownParentActivity.this;
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_play_local_type", allDownParentActivity3.Wwwwwwwwwwwwww.get(allDownParentActivity3.Wwwwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AllDownParentAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    static {
        StubApp.interface11(11110);
    }

    public final void Wwwwwwwwwwwwww() {
        this.refreshLayout.setRefreshing(true);
        new pr0(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).execute(new Void[0]);
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
        return R.layout.activity_all_down_parent;
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
        if (this.Wwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwww.setMediaListener(this);
        }
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwww;
        unifiedInterstitialAD.sendWinNotification(unifiedInterstitialAD.getECPM());
        this.Wwwwwwwwwwwww.getECPM();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onFileEvent(FileEvent fileEvent) {
        List<MyDownData> list = this.Wwwwwwwwwwwwwwwww;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (this.Wwwwwwwwwwwwwwwww.get(size).getDirName().equals(fileEvent.getDirName())) {
                    if (this.Wwwwwwwwwwwwwwwww.get(size).getChildList() != null) {
                        for (int size2 = this.Wwwwwwwwwwwwwwwww.get(size).getChildList().size() - 1; size2 >= 0; size2--) {
                            if (this.Wwwwwwwwwwwwwwwww.get(size).getChildList().get(size2).getUrl().equals(fileEvent.getChildUrl())) {
                                this.Wwwwwwwwwwwwwwwww.get(size).getChildList().remove(size2);
                            }
                        }
                    }
                    if (this.Wwwwwwwwwwwwwwwww.get(size).getChildList().isEmpty()) {
                        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww.get(size).getDirPath());
                        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww.get(size).getDirName());
                        this.Wwwwwwwwwwwwwwwww.remove(size);
                    } else {
                        this.Wwwwwwwwwwwwwwwww.get(size).setChildFilesCount(this.Wwwwwwwwwwwwwwwww.get(size).getChildList().size());
                    }
                    this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, false);
                    return;
                }
            }
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
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwww) == null) {
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

    @OnClick({R.id.iv_top_back})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.iv_top_back) {
            return;
        }
        finish();
    }
}
