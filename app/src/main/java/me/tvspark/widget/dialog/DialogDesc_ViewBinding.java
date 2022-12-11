package me.tvspark.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogDesc_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogDesc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDesc Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDesc_ViewBinding dialogDesc_ViewBinding, DialogDesc dialogDesc) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDesc Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDesc_ViewBinding dialogDesc_ViewBinding, DialogDesc dialogDesc) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDesc Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDesc_ViewBinding dialogDesc_ViewBinding, DialogDesc dialogDesc) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public DialogDesc_ViewBinding(DialogDesc dialogDesc, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogDesc;
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_dialog_close, "field 'ivDialogClose' and method 'onViewClicked'");
        dialogDesc.ivDialogClose = (ImageView) Utils.castView(findRequiredView, R.id.iv_dialog_close, "field 'ivDialogClose'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDesc));
        dialogDesc.ivPoster = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_poster, "field 'ivPoster'", RoundImageView.class);
        dialogDesc.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        dialogDesc.tv1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_1, "field 'tv1'", TextView.class);
        dialogDesc.tv2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_2, "field 'tv2'", TextView.class);
        dialogDesc.tv3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_3, "field 'tv3'", TextView.class);
        dialogDesc.tv4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_4, "field 'tv4'", TextView.class);
        LinearLayout linearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_tvs, "field 'llytTvs'", LinearLayout.class);
        dialogDesc.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tvDesc'", TextView.class);
        dialogDesc.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        dialogDesc.pBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pbar, "field 'pBar'", ProgressBar.class);
        dialogDesc.ivBg = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_bg, "field 'ivBg'", RoundImageView.class);
        dialogDesc.ivMask1 = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_mask1, "field 'ivMask1'", RoundImageView.class);
        dialogDesc.ivMask2 = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_mask2, "field 'ivMask2'", ImageView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.llyt_search, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDesc));
        View findRequiredView3 = Utils.findRequiredView(view, R.id.llyt_douban, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDesc));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogDesc dialogDesc = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogDesc != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogDesc.ivPoster = null;
            dialogDesc.tvTitle = null;
            dialogDesc.tv1 = null;
            dialogDesc.tv2 = null;
            dialogDesc.tv3 = null;
            dialogDesc.tv4 = null;
            dialogDesc.tvDesc = null;
            dialogDesc.flytBanner = null;
            dialogDesc.pBar = null;
            dialogDesc.ivBg = null;
            dialogDesc.ivMask1 = null;
            dialogDesc.ivMask2 = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
