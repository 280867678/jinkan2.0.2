package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.fu0;
import me.tvspark.gu0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.xt0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogDesc implements sk0 {
    public String Wwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.iv_bg)
    public RoundImageView ivBg;
    @BindView(R.id.iv_dialog_close)
    public ImageView ivDialogClose;
    @BindView(R.id.iv_mask1)
    public RoundImageView ivMask1;
    @BindView(R.id.iv_mask2)
    public ImageView ivMask2;
    @BindView(R.id.iv_poster)
    public RoundImageView ivPoster;
    @BindView(R.id.pbar)
    public ProgressBar pBar;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.tv_1)
    public TextView tv1;
    @BindView(R.id.tv_2)
    public TextView tv2;
    @BindView(R.id.tv_3)
    public TextView tv3;
    @BindView(R.id.tv_4)
    public TextView tv4;
    public TextView[] Wwwwwwwwwwwwwwwww = {this.tv1, this.tv2, this.tv3, this.tv4};

    public DialogDesc(Activity activity, String str, String str2, String str3) {
        this.Wwwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwww = str2;
        this.Wwwwwwwwwwwwwwwwwwww = str3;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_desc, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        this.tvTitle.setText(this.Wwwwwwwwwwwwwwwwwww);
        this.ivPoster.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
        this.ivBg.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwww, 12.0d));
        this.ivMask1.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwww, 12.0d));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, "", this.ivPoster, new fu0(this));
        vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, "", this.ivBg, (vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) null);
        if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww)) {
            this.pBar.setVisibility(0);
            this.tvDesc.setVisibility(8);
            if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() != null) {
                r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getBaseUrlRec(), jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getUserAgentRec()).get(this.Wwwwwwwwwwwwwwwwwwww).enqueue(new gu0(this));
            }
        }
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "4013778656247452";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DialogDesc.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    public DialogDesc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
            this.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
            this.Wwwwwwwwwwwwwwwwwwwwwww.show();
            Window window = this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
            window.setWindowAnimations(R.style.BotomInOutDialogStyle);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww);
            window.setAttributes(attributes);
            window.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
            this.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
        }
        return this;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }

    @OnClick({R.id.iv_dialog_close, R.id.llyt_search, R.id.llyt_douban})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.iv_dialog_close) {
            if (id == R.id.llyt_douban) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
            } else if (id != R.id.llyt_search) {
                return;
            } else {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww);
            }
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
