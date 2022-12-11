package me.tvspark.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bo0;
import me.tvspark.data.bean.VideoDetailParcel;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.sk0;
import me.tvspark.vn0;
import me.tvspark.widget.RoundImageView;
import me.tvspark.xt0;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogDetailDesc implements sk0 {
    public boolean Wwwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwwwww;
    public VideoDetailParcel Wwwwwwwwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwwwwwww;
    public Activity Wwwwwwwwwwwwwwwwwwwwww;
    public Dialog Wwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.iv_poster)
    public RoundImageView ivPoster;
    @BindView(R.id.tv_desc)
    public TextView tvDesc;
    @BindView(R.id.tv_dialog_title)
    public TextView tvDialogTitle;
    @BindView(R.id.tv_source)
    public TextView tvSource;
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
    public TextView[] Wwwwwwwwwwwwwwwwww = {this.tv1, this.tv2, this.tv3, this.tv4};

    public DialogDetailDesc(Activity activity, boolean z, String str, VideoDetailParcel videoDetailParcel) {
        TextView textView;
        TextView textView2;
        String sb;
        this.Wwwwwwwwwwwwwwwwwww = "";
        this.Wwwwwwwwwwwwwwwwwwwwww = activity;
        this.Wwwwwwwwwwwwwwwwwwww = videoDetailParcel;
        this.Wwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwww = z;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_detail_desc, (ViewGroup) null);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = inflate;
        ButterKnife.bind(this, inflate);
        Dialog dialog = new Dialog(activity, R.style.Dialog_style);
        this.Wwwwwwwwwwwwwwwwwwwwwww = dialog;
        dialog.requestWindowFeature(1);
        this.Wwwwwwwwwwwwwwwwwwwwwww.setContentView(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        int i = 4;
        if (this.Wwwwwwwwwwwwwwwwwwww != null) {
            TextView textView3 = this.tvSource;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("源网站：");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwww ? "高清专区" : this.Wwwwwwwwwwwwwwwwwww);
            textView3.setText(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            if (this.Wwwwwwwwwwwwwwwwwwww.getTvsList().size() == 1) {
                textView = this.Wwwwwwwwwwwwwwwwww[0];
            } else {
                textView = this.Wwwwwwwwwwwwwwwwww[0];
                i = 1;
            }
            textView.setMaxLines(i);
            for (int i2 = 0; i2 < this.Wwwwwwwwwwwwwwwwwwww.getTvsList().size(); i2++) {
                TextView[] textViewArr = this.Wwwwwwwwwwwwwwwwww;
                if (i2 < textViewArr.length) {
                    textViewArr[i2].setText(this.Wwwwwwwwwwwwwwwwwwww.getTvsList().get(i2));
                }
            }
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww.getTitle())) {
                this.tvTitle.setText(this.Wwwwwwwwwwwwwwwwwwww.getTitle());
            }
            this.ivPoster.setRectAdius(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3));
            vn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwww.getCoverUrl(), this.ivPoster, "");
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwww.getDesc())) {
                textView2 = this.tvDesc;
                sb = "简介：暂无";
            } else {
                textView2 = this.tvDesc;
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("简介：");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwwwwwwwwwwwww.getDesc());
                sb = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            }
            textView2.setText(sb);
        }
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "4013778656247452";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, DialogDetailDesc.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwwwwwww);
        }
    }

    @OnClick({R.id.iv_dialog_close, R.id.tv_source})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id != R.id.iv_dialog_close) {
            if (id != R.id.tv_source || this.Wwwwwwwwwwwwwwwww) {
                return;
            }
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, true);
            return;
        }
        Dialog dialog = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
    }
}
