package me.tvspark.utils.cast.p050ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import com.arialyy.aria.util.FileUtil;
import com.just.agentweb.DefaultWebClient;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialAD;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialADListener;
import com.p038qq.p039e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.p038qq.p039e.comm.util.AdError;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.tvspark.AbstractC3509oo0;
import me.tvspark.ApplicationC1880C;
import me.tvspark.a30;
import me.tvspark.ap0;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.bp0;
import me.tvspark.bq0;
import me.tvspark.c81;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.cu0;
import me.tvspark.data.bean.EpisodeParcel;
import me.tvspark.eo0;
import me.tvspark.gp0;
import me.tvspark.hp0;
import me.tvspark.ip0;
import me.tvspark.jp0;
import me.tvspark.lp0;
import me.tvspark.mu0;
import me.tvspark.or0;
import me.tvspark.outline;
import me.tvspark.pp0;
import me.tvspark.qo0;
import me.tvspark.qp0;
import me.tvspark.r40;
import me.tvspark.ro0;
import me.tvspark.rp0;
import me.tvspark.so0;
import me.tvspark.sp0;
import me.tvspark.to0;
import me.tvspark.tp0;
import me.tvspark.up0;
import me.tvspark.utils.cast.manager.ControlManager;
import me.tvspark.utils.cast.p050ui.DialogDlna;
import me.tvspark.utils.cast.p050ui.DialogEpisode;
import me.tvspark.utils.sniffer.dialog.DialogParse;
import me.tvspark.utils.statusbarutils.OSInfo$OSType;
import me.tvspark.vo0;
import me.tvspark.vp0;
import me.tvspark.w20;
import me.tvspark.widget.DirectionDpadView;
import me.tvspark.x11;
import me.tvspark.xp0;
import me.tvspark.xt0;
import me.tvspark.yp0;
import org.fourthline.cling.support.model.Res;
import org.fourthline.cling.support.model.item.Item;
import org.greenrobot.eventbus.ThreadMode;
import ru.bartwell.exfilepicker.ExFilePicker$ChoiceType;
import ru.bartwell.exfilepicker.ExFilePicker$SortingType;
import ru.bartwell.exfilepicker.p062ui.activity.ExFilePickerActivity;
import white.whale.R;

/* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity */
/* loaded from: classes4.dex */
public class CastPlayActivity extends BaseActivity implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {
    public UnifiedInterstitialAD Wwwwwwwwwwwwwww;
    public so0 Wwwwwwwwwwwwwwwwww;
    public Item Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.mDirectionDpadView)
    public DirectionDpadView mDirectionDpadView;
    @BindView(R.id.seek_bar_progress)
    public SeekBar seekBarProgress;
    @BindView(R.id.tv_choose_episode)
    public TextView tvChooseEpisode;
    @BindView(R.id.tv_content_title)
    public TextView tvContentTitle;
    @BindView(R.id.tv_content_url)
    public TextView tvContentUrl;
    @BindView(R.id.tv_device)
    public TextView tvDevice;
    @BindView(R.id.tv_play_max_time)
    public TextView tvPlayMaxTime;
    @BindView(R.id.tv_play_time)
    public TextView tvPlayTime;
    public int Wwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwwww = false;

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.cast.p050ui.DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            CastPlayActivity.this.tvDevice.setText(str);
            CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements w20 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            CastPlayActivity castPlayActivity = CastPlayActivity.this;
            if (z) {
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwww);
                FileUtil.createDir(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                ExFilePicker$ChoiceType exFilePicker$ChoiceType = ExFilePicker$ChoiceType.ALL;
                ExFilePicker$SortingType exFilePicker$SortingType = ExFilePicker$SortingType.NAME_ASC;
                ExFilePicker$ChoiceType exFilePicker$ChoiceType2 = ExFilePicker$ChoiceType.FILES;
                String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
                BaseActivity baseActivity = CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww;
                Intent intent = new Intent(baseActivity, ExFilePickerActivity.class);
                intent.putExtra("CAN_CHOOSE_ONLY_ONE_ITEM", false);
                intent.putExtra("CHOOSE_MODE_ENABLE", false);
                intent.putExtra("SHOW_ONLY_EXTENSIONS", (String[]) null);
                intent.putExtra("EXCEPT_EXTENSIONS", (String[]) null);
                intent.putExtra("IS_NEW_FOLDER_BUTTON_DISABLED", false);
                intent.putExtra("IS_SORT_BUTTON_DISABLED", false);
                intent.putExtra("IS_QUIT_BUTTON_ENABLED", false);
                intent.putExtra("CHOICE_TYPE", exFilePicker$ChoiceType2);
                intent.putExtra("SORTING_TYPE", exFilePicker$SortingType);
                intent.putExtra("START_DIRECTORY", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("DEFAULT_DIRECTORY", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                intent.putExtra("TITLE_NAME", "本地投屏");
                intent.putExtra("USE_FIRST_ITEM_AS_UP_ENABLED", false);
                intent.putExtra("HIDE_HIDDEN_FILES", true);
                baseActivity.startActivityForResult(intent, 0);
                return;
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(castPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }

        @Override // me.tvspark.w20
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list, boolean z) {
            if (z) {
                a30.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, list);
            }
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先授予读写权限");
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements mu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogEpisode.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.utils.cast.p050ui.DialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            CastPlayActivity.this.tvDevice.setText(str);
            CastPlayActivity castPlayActivity = CastPlayActivity.this;
            if (castPlayActivity.Wwwwwwwwwwwwwwwwww == null && castPlayActivity.Wwwwwwwwwwwwwwwwwww == null) {
                return;
            }
            CastPlayActivity castPlayActivity2 = CastPlayActivity.this;
            if (castPlayActivity2 == null) {
                throw null;
            }
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new sp0(castPlayActivity2, true, true));
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DirectionDpadView.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity) {
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
            dialog.dismiss();
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str) {
            dialog.dismiss();
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity, int i) {
        if (castPlayActivity != null) {
            String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            tp0 tp0Var = new tp0(castPlayActivity);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                tp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "AVTService is null");
                return;
            } else {
                ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new ip0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, tp0Var));
                return;
            }
        }
        throw null;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity) {
        if (castPlayActivity != null) {
            if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww == ControlManager.CastState.STOPED) {
                if (castPlayActivity.Wwwwwwwwwwwwwwwwwww != null) {
                    castPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    return;
                } else {
                    castPlayActivity.Wwwwwwwwwwwwww();
                    return;
                }
            } else if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww == ControlManager.CastState.PAUSED) {
                ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new qp0(castPlayActivity));
                return;
            } else if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww == ControlManager.CastState.PLAYING) {
                ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                rp0 rp0Var = new rp0(castPlayActivity);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    rp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "AVTService is null");
                    return;
                } else {
                    ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new hp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, rp0Var));
                    return;
                }
            } else {
                castPlayActivity.runOnUiThread(new up0(castPlayActivity, "正在连接设备，稍后操作"));
                return;
            }
        }
        throw null;
    }

    public final void Wwwwwwwwwwwww() {
        String str;
        TextView textView;
        String str2;
        this.Wwwwwwwwwwwwwwwwwww = ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        so0 so0Var = ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwww = so0Var;
        Item item = this.Wwwwwwwwwwwwwwwwwww;
        if (item != null) {
            this.tvContentTitle.setText(item.getTitle());
            this.tvContentUrl.setText(this.Wwwwwwwwwwwwwwwwwww.getFirstResource().getValue());
            str = this.Wwwwwwwwwwwwwwwwwww.getFirstResource().getDuration();
        } else if (so0Var != null) {
            TextView textView2 = this.tvContentTitle;
            textView2.setText(this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + "-" + this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwww);
            this.tvContentUrl.setText(this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            str = this.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.tvPlayMaxTime.setText(str);
            this.seekBarProgress.setMax((int) bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
        if (ApplicationC1880C.Wwwwwwwwwww.getEpisodeListPlay().isEmpty() || this.Wwwwwwwwwwwwwwwwww == null) {
            textView = this.tvChooseEpisode;
            str2 = "播放列表(0)";
        } else {
            textView = this.tvChooseEpisode;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("播放列表(");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(ApplicationC1880C.Wwwwwwwwwww.getEpisodeListPlay().size());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(")");
            str2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
        }
        textView.setText(str2);
    }

    public final void Wwwwwwwwwwwwww() {
        this.tvPlayTime.setText("00:00:00");
        this.tvPlayMaxTime.setText("00:00:00");
        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.TRANSITIONING;
        ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        so0 so0Var = this.Wwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new gp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, so0Var, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            return;
        }
        throw null;
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
        return R.layout.activity_cast_play;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        this.tvPlayTime.setText("00:00:00");
        this.tvPlayMaxTime.setText("00:00:00");
        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.TRANSITIONING;
        ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Item item = this.Wwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new bp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, item, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            if (ApplicationC1880C.Wwwww || !z) {
                return;
            }
            ApplicationC1880C.Wwwww = true;
            BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            cu0 cu0Var = new cu0(baseActivity, "说明", baseActivity.getString(R.string.local_dlna_tips));
            cu0Var.Wwwwwwww = true;
            cu0Var.Wwwwwwwwwwwww = "取 消";
            cu0Var.Wwwwwwwwwwww = "了 解";
            cu0Var.Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this);
            cu0Var.Wwwwww = -1;
            cu0Var.Wwwww = 15;
            cu0Var.Wwwwwww = 17;
            cu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        throw null;
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && i2 == -1) {
            try {
                ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                c81 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c81.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(intent);
                Item item = new Item();
                item.setTitle(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww.get(0));
                Res res = new Res();
                res.setValue(DefaultWebClient.HTTP_SCHEME + r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww) + ":8289/video" + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwww.get(0));
                ArrayList arrayList = new ArrayList();
                arrayList.add(res);
                item.setResources(arrayList);
                ap0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = item;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                ApplicationC1880C.Wwwwwwwwwww.clear();
                ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
                Wwwwwwwwwwwww();
                if (lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                } else {
                    DialogDlna dialogDlna = new DialogDlna(this.Wwwwwwwwwwwwwwwwwwwwwwww, "", "", "", "", "", 2, true);
                    dialogDlna.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwww();
                    dialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            } catch (Exception e) {
                e.printStackTrace();
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, e.getMessage());
            }
        }
    }

    @OnClick({R.id.iv_back, R.id.iv_close_cast, R.id.tv_choose_device, R.id.tv_choose_episode, R.id.iv_cast_url, R.id.iv_cast_file})
    public void onClick(View view) {
        so0 so0Var;
        switch (view.getId()) {
            case R.id.iv_back /* 2131362149 */:
                finish();
                return;
            case R.id.iv_cast_file /* 2131362151 */:
                a30 a30Var = new a30(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(UMUtils.SD_PERMISSION);
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("android.permission.READ_EXTERNAL_STORAGE");
                a30Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            case R.id.iv_cast_url /* 2131362152 */:
                mu0 mu0Var = new mu0(this.Wwwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
                if (mu0Var.Wwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                    return;
                }
                mu0Var.Wwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(mu0Var.Wwwwwwwwwwwwwwwww);
                mu0Var.Wwwwwwwwwwwwwwwwwwww.setOnClickListener(mu0Var);
                mu0Var.Wwwwwwwwwwwwwwwwwww.setOnClickListener(mu0Var);
                mu0Var.Wwwwwwwwwwwww = (int) (outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mu0Var.Wwwwwwwwwwwwwwwwwwwwwwww) * 0.9d);
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
                if (!ApplicationC1880C.Wwwwwwwww) {
                    xt0 xt0Var = new xt0(mu0Var.Wwwwwwwwwwwwwwwwwwwwwwww);
                    mu0Var.Wwwwwwwwwwwwww = xt0Var;
                    xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
                    xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mu0Var.Wwwwwwwwwwwww, mu0.class.getSimpleName());
                    mu0Var.Wwwwwwwwwwwwwwww.removeAllViews();
                    mu0Var.Wwwwwwwwwwwwwwww.addView(mu0Var.Wwwwwwwwwwwwww);
                }
                mu0Var.Wwwwwwwwwwwwwwwwwwwwww.setContentView(mu0Var.Wwwwwwwwwwwwwwwwwwwww);
                mu0Var.Wwwwwwwwwwwwwwwwwwwwww.show();
                Window window = mu0Var.Wwwwwwwwwwwwwwwwwwwwww.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = mu0Var.Wwwwwwwwwwwww;
                window.setAttributes(attributes);
                window.setContentView(mu0Var.Wwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.iv_close_cast /* 2131362155 */:
                if (this.Wwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new sp0(this, false, false));
                return;
            case R.id.tv_choose_device /* 2131362656 */:
                DialogDlna dialogDlna = new DialogDlna(this.Wwwwwwwwwwwwwwwwwwwwwwww, "", "", "", "", "", 2, true);
                dialogDlna.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                dialogDlna.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case R.id.tv_choose_episode /* 2131362657 */:
                if (!ApplicationC1880C.Wwwwwwwwwww.getEpisodeListPlay().isEmpty() && (so0Var = this.Wwwwwwwwwwwwwwwwww) != null) {
                    DialogEpisode dialogEpisode = new DialogEpisode(this.Wwwwwwwwwwwwwwwwwwwwwwww, so0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwww, ApplicationC1880C.Wwwwwwwwwww.getEpisodeListPlay(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    if (dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                        return;
                    }
                    dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                    dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                    dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.show();
                    Window window2 = dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                    window2.setWindowAnimations(R.style.BotomInOutDialogStyle);
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    attributes2.gravity = 80;
                    attributes2.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogEpisode.Wwwwwwwwwwwwwwwwwwwwww);
                    attributes2.height = (int) (dialogEpisode.Wwwwwwwwwwwwwwwwwwwwww.getWindowManager().getDefaultDisplay().getHeight() * 0.8d);
                    window2.setAttributes(attributes2);
                    window2.setContentView(dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwwww);
                    dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                    dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                    return;
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "暂无列表");
                return;
            default:
                return;
        }
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwww;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onEventBus(vo0 vo0Var) {
        DirectionDpadView directionDpadView;
        boolean z;
        if (this.Wwwwwwwwwwwwwwwwww == null && this.Wwwwwwwwwwwwwwwwwww == null) {
            return;
        }
        qo0 qo0Var = vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (qo0Var != null) {
            if (!TextUtils.isEmpty(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                if (qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("TRANSITIONING")) {
                    ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.TRANSITIONING;
                } else {
                    if (qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("PLAYING")) {
                        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.PLAYING;
                        directionDpadView = this.mDirectionDpadView;
                        z = true;
                    } else if (qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals("PAUSED_PLAYBACK")) {
                        ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.PAUSED;
                        directionDpadView = this.mDirectionDpadView;
                        z = false;
                    }
                    directionDpadView.setPlayStatus(z);
                }
            }
            if (!TextUtils.isEmpty(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                this.tvPlayMaxTime.setText(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.seekBarProgress.setMax((int) bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
            }
            if (!TextUtils.isEmpty(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bq0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                    if (!this.Wwwwwwwwwwwwww) {
                        this.seekBarProgress.setProgress((int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    }
                    this.tvPlayTime.setText(qo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                }
            }
        }
        to0 to0Var = vo0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (to0Var == null) {
            return;
        }
        int i = to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwww = i;
        if (!to0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && i != 0) {
            if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                throw null;
            }
        } else if (ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
            throw null;
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
        if (isFinishing() || (unifiedInterstitialAD = this.Wwwwwwwwwwwwwww) == null) {
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

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC3509oo0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this, String.format("New play cast remote content failed %s", str));
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.PLAYING;
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.CastPlayActivity$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC3509oo0 {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str) {
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.STOPED;
            CastPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity.this, String.format("New play cast local content failed %s", str));
        }

        @Override // me.tvspark.AbstractC3509oo0
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwww = ControlManager.CastState.PLAYING;
            ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity, int i) {
        castPlayActivity.Wwwwwwwwwwwwwwww = i;
        ControlManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ControlManager.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        pp0 pp0Var = new pp0(castPlayActivity);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            pp0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(101, "RCService is null");
        } else {
            ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().execute(new jp0(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, pp0Var));
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity, String str) {
        if (castPlayActivity != null) {
            castPlayActivity.runOnUiThread(new up0(castPlayActivity, str));
            return;
        }
        throw null;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CastPlayActivity castPlayActivity, EpisodeParcel episodeParcel, int i) {
        BaseActivity baseActivity = castPlayActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
        String str = castPlayActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwww;
        DialogParse dialogParse = new DialogParse(baseActivity, str, str, episodeParcel.getLink(), castPlayActivity.Wwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, episodeParcel.getCount(), 13, false);
        dialogParse.Wwwwwwwwwwwwwwwwwwwww = new yp0(castPlayActivity);
        dialogParse.Wwwwwwwwwwwwwwwwwwwwww = new xp0(castPlayActivity, episodeParcel, i);
        dialogParse.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009c  */
    @Override // me.tvspark.common.view.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        int systemUiVisibility;
        ro0 ro0Var;
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) baseActivity, baseActivity.getResources().getColor(R.color.color_cast_bg));
        BaseActivity baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        OSInfo$OSType Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2);
        Window window = baseActivity2.getWindow();
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT < 23) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == OSInfo$OSType.OS_TYPE_MIUI) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == OSInfo$OSType.OS_TYPE_FLYME) {
                or0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, true);
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == OSInfo$OSType.OS_TYPE_COLOR && Build.VERSION.SDK_INT >= 22) {
                window.addFlags(Integer.MIN_VALUE);
                systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 16;
            }
            if (!ApplicationC1880C.Wwwwwwwww) {
                UnifiedInterstitialAD unifiedInterstitialAD = this.Wwwwwwwwwwwwwww;
                if (unifiedInterstitialAD != null) {
                    unifiedInterstitialAD.close();
                    this.Wwwwwwwwwwwwwww.destroy();
                    this.Wwwwwwwwwwwwwww = null;
                }
                UnifiedInterstitialAD unifiedInterstitialAD2 = new UnifiedInterstitialAD(this, "4083974606045578", this);
                this.Wwwwwwwwwwwwwww = unifiedInterstitialAD2;
                this.Wwwwwwwwwwwwwww = unifiedInterstitialAD2;
                this.Wwwwwwwwwwwwwww.setVideoOption(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, 1, true));
                this.Wwwwwwwwwwwwwww.loadAD();
            }
            ro0Var = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (ro0Var != null) {
                this.tvDevice.setText(ro0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getDetails().getFriendlyName());
            }
            Wwwwwwwwwwwww();
            this.seekBarProgress.setOnSeekBarChangeListener(new vp0(this));
            this.mDirectionDpadView.setOnDirectionKeyListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
        window.addFlags(Integer.MIN_VALUE);
        systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 8192;
        decorView.setSystemUiVisibility(systemUiVisibility);
        if (!ApplicationC1880C.Wwwwwwwww) {
        }
        ro0Var = lp0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (ro0Var != null) {
        }
        Wwwwwwwwwwwww();
        this.seekBarProgress.setOnSeekBarChangeListener(new vp0(this));
        this.mDirectionDpadView.setOnDirectionKeyListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }
}
