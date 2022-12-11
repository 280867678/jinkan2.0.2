package me.tvspark.view.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.p038qq.p039e.ads.rewardvideo.RewardVideoAD;
import me.tvspark.ApplicationC1880C;
import me.tvspark.am0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.cu0;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.nt0;
import me.tvspark.tm0;
import me.tvspark.um0;
import me.tvspark.utils.web.WebService;
import white.whale.R;

/* loaded from: classes4.dex */
public class MeFragment extends BaseFragment<tm0> implements um0 {
    public static final String Wwwwwwwwwwww = MeFragment.class.getSimpleName();
    public boolean Wwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwww;
    public RewardVideoAD Wwwwwwwwwwwwwwwww;
    @BindView(R.id.llyt_update)
    public LinearLayout llytUpdate;
    @BindView(R.id.tv_version)
    public TextView tvVersion;
    public int Wwwwwwwwwwwwwwww = 0;
    public boolean Wwwwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(MeFragment.this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
            dialog.dismiss();
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str) {
            dialog.dismiss();
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            MeFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MeFragment.this);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MeFragment meFragment) {
        RewardVideoAD rewardVideoAD;
        if (!meFragment.Wwwwwwwwwwwwwww || (rewardVideoAD = meFragment.Wwwwwwwwwwwwwwwww) == null) {
            meFragment.Wwwwwwwwwwwww = true;
        } else if (rewardVideoAD.isValid()) {
            meFragment.Wwwwwwwwwwwwwwwww.showAD();
        } else {
            meFragment.Wwwwwwwwwwwww = true;
            meFragment.Wwwwwwwwwwwwwww = false;
            meFragment.Wwwwwwwwwwwwwwwww.loadAD();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public tm0 Wwwwwwwwwwwwwwwww() {
        return new am0();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_me;
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!z) {
            AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwww).setTitle("注意").setMessage("当前配置信息请求失败，请立即切换配置，以防App无法使用！！！").setPositiveButton("切换配置", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    @OnClick({R.id.tv_version, R.id.llyt_conf, R.id.llyt_reward, R.id.llyt_email, R.id.llyt_notice, R.id.llyt_setting, R.id.llyt_app_rec, R.id.llyt_update, R.id.llyt_share, R.id.llyt_about})
    public void onViewClicked(View view) {
        BaseActivity baseActivity;
        String str;
        switch (view.getId()) {
            case R.id.llyt_about /* 2131362228 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_app_rec /* 2131362235 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwww, true);
                return;
            case R.id.llyt_conf /* 2131362248 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_email /* 2131362255 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) this.Wwwwwwwwwwwwwwwwwwwwwww, false);
                return;
            case R.id.llyt_notice /* 2131362270 */:
                VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
                if (versionParcel == null || TextUtils.isEmpty(versionParcel.getNoticeUrl())) {
                    baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    str = "https://docs.qq.com/doc/DUEJvZW1sVXZWSHJB";
                } else {
                    baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    str = ApplicationC1880C.Wwwwwwwwwwwwwww.getNoticeUrl();
                }
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) baseActivity, str, false);
                return;
            case R.id.llyt_reward /* 2131362283 */:
                cu0 cu0Var = new cu0(this.Wwwwwwwwwwwwwwwwwwwwwww, "提示", "观看一段视频可去除应用内所有广告并支持开发者，点击确定开始观看");
                cu0Var.Wwwwwwwwwwwwww = 3;
                cu0Var.Wwwwwwwwwwwww = "取 消";
                cu0Var.Wwwwwwwwwwww = "确 定";
                cu0Var.Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                cu0Var.Wwwwww = -1;
                cu0Var.Wwwww = 16;
                cu0Var.Wwwwwww = 17;
                cu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case R.id.llyt_setting /* 2131362288 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_share /* 2131362289 */:
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                ((tm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                return;
            case R.id.llyt_update /* 2131362301 */:
                this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                ((tm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                return;
            case R.id.tv_version /* 2131362758 */:
                if (!nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    return;
                }
                int i = this.Wwwwwwwwwwwwwwww + 1;
                this.Wwwwwwwwwwwwwwww = i;
                if (i != 3) {
                    return;
                }
                this.Wwwwwwwwwwwwwwww = 0;
                if (WebService.startThis(this.Wwwwwwwwwwwwwwwwwwwwwww)) {
                    return;
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "服务已启动");
                return;
            default:
                return;
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.tvVersion.setText("版本号：2.0.2");
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            this.tvVersion.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.red));
        }
        ApplicationC1880C.Wwwwwwwww = false;
        RewardVideoAD rewardVideoAD = new RewardVideoAD(this.Wwwwwwwwwwwwwwwwwwwwwww, "6053479616348758", new nt0(this), false);
        this.Wwwwwwwwwwwwwwwww = rewardVideoAD;
        this.Wwwwwwwwwwwwwww = false;
        ApplicationC1880C.Wwwwwwwww = false;
        rewardVideoAD.loadAD();
    }
}
