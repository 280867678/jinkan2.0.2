package me.tvspark.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.fastjson.JSON;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.List;
import java.util.Locale;
import me.tvspark.ApplicationC1880C;
import me.tvspark.a30;
import me.tvspark.bl0;
import me.tvspark.c81;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.CustomConfUrlData;
import me.tvspark.eo0;
import me.tvspark.jo0;
import me.tvspark.mn0;
import me.tvspark.r40;
import me.tvspark.utils.SKUtils;
import me.tvspark.w20;
import me.tvspark.xt0;
import me.tvspark.yn0;
import ru.bartwell.exfilepicker.ExFilePicker$ChoiceType;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class ConfActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.et_custom_conf_url)
    public EditText etCustomConfUrl;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.tv_conf_status)
    public TextView tvConfStatus;
    @BindView(R.id.tv_title)
    public TextView tvTitle;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.jo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void onFinish(boolean z) {
            BaseActivity baseActivity;
            String str;
            ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            if (z) {
                baseActivity = ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "导入成功，重启后生效";
            } else {
                baseActivity = ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                str = "导入失败";
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (z) {
                ExFilePicker$ChoiceType exFilePicker$ChoiceType = ExFilePicker$ChoiceType.ALL;
                ExFilePicker$SortingType exFilePicker$SortingType = ExFilePicker$SortingType.NAME_ASC;
                ExFilePicker$ChoiceType exFilePicker$ChoiceType2 = ExFilePicker$ChoiceType.FILES;
                String path = Environment.getExternalStorageDirectory().getPath();
                String path2 = Environment.getExternalStorageDirectory().getPath();
                BaseActivity baseActivity = ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                Intent intent = new Intent(baseActivity, ExFilePickerActivity.class);
                intent.putExtra("CAN_CHOOSE_ONLY_ONE_ITEM", false);
                intent.putExtra("CHOOSE_MODE_ENABLE", false);
                intent.putExtra("SHOW_ONLY_EXTENSIONS", (String[]) null);
                intent.putExtra("EXCEPT_EXTENSIONS", (String[]) null);
                intent.putExtra("IS_NEW_FOLDER_BUTTON_DISABLED", false);
                intent.putExtra("IS_SORT_BUTTON_DISABLED", false);
                intent.putExtra("IS_QUIT_BUTTON_ENABLED", true);
                intent.putExtra("CHOICE_TYPE", exFilePicker$ChoiceType2);
                intent.putExtra("SORTING_TYPE", exFilePicker$SortingType);
                intent.putExtra("START_DIRECTORY", path);
                intent.putExtra("DEFAULT_DIRECTORY", path2);
                intent.putExtra("TITLE_NAME", "导入本地配置");
                intent.putExtra("USE_FIRST_ITEM_AS_UP_ENABLED", false);
                intent.putExtra("HIDE_HIDDEN_FILES", true);
                baseActivity.startActivityForResult(intent, 0);
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (z) {
                a30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, list);
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ int Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            String str = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 ? " C " : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 ? " G " : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2 ? " H " : "";
            BaseActivity baseActivity = ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
            Toast.makeText(baseActivity, "已切换配置" + str + "，重启中...", 1).show();
            mn0.Wwwwwwwwwwwwwwwwwwwwwwww(ConfActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    static {
        StubApp.interface11(11121);
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
        return R.layout.activity_conf;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("提示").setMessage("此项用于：当前页面请求连接提示为异常的的情况下！可尝试切换配置！").setPositiveButton("切换", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1) {
            try {
                c81 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intent);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww("导入中...");
                jo0 jo0Var = new jo0();
                jo0Var.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                jo0Var.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww.get(0);
                jo0Var.execute(new Void[0]);
            } catch (Exception e) {
                e.printStackTrace();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, e.getMessage());
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etCustomConfUrl);
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

    @OnClick({R.id.iv_top_back, R.id.btn_conf_url_h, R.id.btn_conf_url_g, R.id.btn_conf_url_c, R.id.btn_local_conf, R.id.btn_custom_conf_url})
    public void onViewClicked(View view) {
        int i;
        int id = view.getId();
        if (id == R.id.iv_top_back) {
            finish();
            return;
        }
        switch (id) {
            case R.id.btn_conf_url_c /* 2131361898 */:
                i = 0;
                break;
            case R.id.btn_conf_url_g /* 2131361899 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                return;
            case R.id.btn_conf_url_h /* 2131361900 */:
                i = 2;
                break;
            case R.id.btn_custom_conf_url /* 2131361901 */:
                try {
                    String obj = this.etCustomConfUrl.getText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请输入地址代码", 1).show();
                        return;
                    }
                    CustomConfUrlData customConfUrlData = (CustomConfUrlData) JSON.parseObject(r40.Wwwwwwwwwwwwwwwwwwwwwwww(SKUtils.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj)), CustomConfUrlData.class);
                    if (TextUtils.isEmpty(customConfUrlData.getVersionUrl()) || TextUtils.isEmpty(customConfUrlData.getIndexUrl()) || TextUtils.isEmpty(customConfUrlData.getSeasonUrl()) || TextUtils.isEmpty(customConfUrlData.getCategoryUrl()) || TextUtils.isEmpty(customConfUrlData.getDownloadUrl()) || TextUtils.isEmpty(customConfUrlData.getLiveUrl())) {
                        Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "配置不完整", 1).show();
                        return;
                    }
                    yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    customConfUrlData.clearSavedState();
                    customConfUrlData.save();
                    ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
                    Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "已切换 手动配置地址 ，重启中...", 1).show();
                    mn0.Wwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(this.Wwwwwwwwwwwwwwwwwwwwwwww, "配置错误", 1).show();
                    return;
                }
            case R.id.btn_local_conf /* 2131361902 */:
                a30 a30Var = new a30(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UMUtils.SD_PERMISSION);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("android.permission.READ_EXTERNAL_STORAGE");
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            default:
                return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }
}
