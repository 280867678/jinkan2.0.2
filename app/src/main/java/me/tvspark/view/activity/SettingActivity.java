package me.tvspark.view.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;
import com.arialyy.aria.util.FileUtil;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.stub.StubApp;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.List;
import java.util.Locale;
import me.tvspark.a30;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.c81;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.do0;
import me.tvspark.eo0;
import me.tvspark.ju0;
import me.tvspark.ku0;
import me.tvspark.lu0;
import me.tvspark.nn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.w20;
import me.tvspark.xs0;
import ru.bartwell.exfilepicker.ExFilePicker$ChoiceType;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;
import white.whale.R;

/* loaded from: classes4.dex */
public class SettingActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.cbox_auto_play)
    public CheckBox cboxAutoPlay;
    @BindView(R.id.cbox_ksy_progress)
    public CheckBox cboxKsyProgress;
    @BindView(R.id.cbox_no_history)
    public CheckBox cboxNoHistory;
    @BindView(R.id.cbox_play_next_auto)
    public CheckBox cboxPlayNextAuto;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.tv_default_path)
    public TextView tvDefaultPath;
    @BindView(R.id.tv_default_rate)
    public TextView tvDefaultRate;
    @BindView(R.id.tv_ksy)
    public TextView tvKSY;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_trash)
    public TextView tvTrash;
    @BindView(R.id.tv_x5)
    public TextView tvX5;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            SettingActivity settingActivity = SettingActivity.this;
            if (z) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settingActivity.Wwwwwwwwwwwwwwwwwwwwwwww);
                FileUtil.createDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ExFilePicker$ChoiceType exFilePicker$ChoiceType = ExFilePicker$ChoiceType.ALL;
                ExFilePicker$SortingType exFilePicker$SortingType = ExFilePicker$SortingType.NAME_ASC;
                ExFilePicker$ChoiceType exFilePicker$ChoiceType2 = ExFilePicker$ChoiceType.DIRECTORIES;
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                BaseActivity baseActivity = SettingActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
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
                intent.putExtra("START_DIRECTORY", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("DEFAULT_DIRECTORY", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("TITLE_NAME", "默认根目录");
                intent.putExtra("USE_FIRST_ITEM_AS_UP_ENABLED", false);
                intent.putExtra("HIDE_HIDDEN_FILES", true);
                baseActivity.startActivityForResult(intent, 0);
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(settingActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (z) {
                a30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, list);
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            TextView textView;
            String str;
            if (i != 0) {
                int i3 = 1;
                if (i != 1) {
                    i3 = 2;
                    if (i != 2) {
                        i3 = 3;
                        if (i != 3) {
                            i3 = 4;
                            if (i != 4) {
                                i3 = 5;
                                if (i != 5) {
                                    return;
                                }
                                textView = SettingActivity.this.tvDefaultRate;
                                str = "x2.00";
                            } else {
                                textView = SettingActivity.this.tvDefaultRate;
                                str = "x1.50";
                            }
                        } else {
                            textView = SettingActivity.this.tvDefaultRate;
                            str = "x1.25";
                        }
                    } else {
                        textView = SettingActivity.this.tvDefaultRate;
                        str = "x1.00";
                    }
                } else {
                    textView = SettingActivity.this.tvDefaultRate;
                    str = "x0.75";
                }
                textView.setText(str);
                i2 = Integer.valueOf(i3);
            } else {
                SettingActivity.this.tvDefaultRate.setText("x0.50");
                i2 = 0;
            }
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", i2);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            int i2;
            TextView textView;
            String str;
            if (i != 0) {
                int i3 = 1;
                if (i != 1) {
                    i3 = 2;
                    if (i != 2) {
                        return;
                    }
                    textView = SettingActivity.this.tvKSY;
                    str = "Android内核";
                } else {
                    textView = SettingActivity.this.tvKSY;
                    str = "EXO内核";
                }
                textView.setText(str);
                i2 = Integer.valueOf(i3);
            } else {
                SettingActivity.this.tvKSY.setText("IJK内核");
                i2 = 0;
            }
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", i2);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no_history", Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("play_next_auto", Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("hide_ksy_bottom_progress", Boolean.valueOf(z));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SettingActivity settingActivity) {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("auto_play_activity", Boolean.valueOf(z));
        }
    }

    static {
        StubApp.interface11(11263);
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
        return R.layout.activity_setting;
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
        if (this.Wwwwwwwwwwwwwwwwwww.getAdPatternType() == 2) {
            this.Wwwwwwwwwwwwwwwwwww.setMediaListener(this);
        }
        this.Wwwwwwwwwwwwwwwwwww.getECPMLevel();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1) {
            try {
                c81 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intent);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("save_path_root", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww.get(0) + "/");
                TextView textView = this.tvDefaultPath;
                textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww.get(0) + "/");
            } catch (Exception e) {
                e.printStackTrace();
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, e.getMessage());
            }
        }
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwwww;
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
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwwwwwww) == null) {
            return;
        }
        unifiedInterstitialAD.showAsPopupWindow();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        TextView textView;
        String str;
        super.onResume();
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwwww)) {
            textView = this.tvX5;
            str = "已加载";
        } else {
            textView = this.tvX5;
            str = "手动初始化";
        }
        textView.setText(str);
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

    @OnClick({R.id.iv_top_back, R.id.llyt_skip_time, R.id.rlyt_default_path, R.id.llyt_default_rate, R.id.llyt_ksy, R.id.llyt_x5, R.id.llyt_trash})
    public void onViewClicked(View view) {
        AlertDialog.Builder builder;
        switch (view.getId()) {
            case R.id.iv_top_back /* 2131362193 */:
                finish();
                return;
            case R.id.llyt_default_rate /* 2131362250 */:
                builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_rate_index", 2);
                String str = "x0.50";
                String str2 = "x0.75";
                String str3 = "x1.00";
                String str4 = "x1.25";
                String str5 = "x1.50";
                String str6 = "x2.00";
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
                    str = "x0.50      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1) {
                    str2 = "x0.75      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                    str3 = "x1.00      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 3) {
                    str4 = "x1.25      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 4) {
                    str5 = "x1.50      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5) {
                    str6 = "x2.00      √";
                }
                builder.setItems(new String[]{str, str2, str3, str4, str5, str6}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                break;
            case R.id.llyt_ksy /* 2131362263 */:
                builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_ksy_core", 0);
                String str7 = "IJK内核（推荐）";
                String str8 = "EXO内核";
                String str9 = "Android内核";
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0) {
                    str7 = "IJK内核（推荐）      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 1) {
                    str8 = "EXO内核      √";
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 2) {
                    str9 = "Android内核      √";
                }
                builder.setItems(new String[]{str7, str8, str9}, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                break;
            case R.id.llyt_skip_time /* 2131362290 */:
                lu0 lu0Var = new lu0(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                if (lu0Var.Wwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                    return;
                }
                lu0Var.Wwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(lu0Var.Wwwwwwwwwwwwww);
                lu0Var.Wwwwwwwwwwwwwwwwwwww.setOnClickListener(lu0Var);
                lu0Var.Wwwwwwwwwwwwwwwwwww.setOnClickListener(lu0Var);
                lu0Var.Wwwwwwwwwwwww = (int) (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lu0Var.Wwwwwwwwwwwwwwwwwwwwwwww) * 0.9d);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_head");
                lu0Var.Wwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4;
                lu0Var.Wwwwwwwwwwwwwwww.setProgress(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4);
                TextView textView = lu0Var.Wwwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("跳过片头：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lu0Var.Wwwwwwwwwwww));
                textView.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5.toString());
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("skip_end");
                lu0Var.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6;
                lu0Var.Wwwwwwwwwwwwwww.setProgress(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6);
                TextView textView2 = lu0Var.Wwwwwwwwwwwwwwwww;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("跳过片尾：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.append(do0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(lu0Var.Wwwwwwwwwww));
                textView2.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww7.toString());
                lu0Var.Wwwwwwwwwwwwwwww.setOnSeekBarChangeListener(new ju0(lu0Var));
                lu0Var.Wwwwwwwwwwwwwww.setOnSeekBarChangeListener(new ku0(lu0Var));
                lu0Var.Wwwwwwwwwwwwwwwwwwwwww.setContentView(lu0Var.Wwwwwwwwwwwwwwwwwwwww);
                lu0Var.Wwwwwwwwwwwwwwwwwwwwww.show();
                Window window = lu0Var.Wwwwwwwwwwwwwwwwwwwwww.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = lu0Var.Wwwwwwwwwwwww;
                window.setAttributes(attributes);
                window.setContentView(lu0Var.Wwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_trash /* 2131362299 */:
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getCacheDir());
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww.getFilesDir());
                this.tvTrash.setText("0KB");
                return;
            case R.id.llyt_x5 /* 2131362304 */:
                new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("X5 内核调试").setItems(new String[]{"※※ 腾讯X5内核目前已不再提供视频播放器功能，想要使用 极速播放器(X5) 的，可点击下方安装旧版本的内核试一试！", "1、[ 安装旧版本X5内核 ]", "2、[ 在线debug调试页 ]"}, new xs0(this)).create().show();
                return;
            case R.id.rlyt_default_path /* 2131362437 */:
                a30 a30Var = new a30(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UMUtils.SD_PERMISSION);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("android.permission.READ_EXTERNAL_STORAGE");
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            default:
                return;
        }
        builder.setCancelable(true);
        builder.create().show();
    }
}
