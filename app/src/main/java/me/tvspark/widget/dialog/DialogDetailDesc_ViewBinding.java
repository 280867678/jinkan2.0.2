package me.tvspark.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import me.tvspark.widget.RoundImageView;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogDetailDesc_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogDetailDesc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDetailDesc Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDetailDesc_ViewBinding dialogDetailDesc_ViewBinding, DialogDetailDesc dialogDetailDesc) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDetailDesc;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDetailDesc Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDetailDesc_ViewBinding dialogDetailDesc_ViewBinding, DialogDetailDesc dialogDetailDesc) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDetailDesc;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public DialogDetailDesc_ViewBinding(DialogDetailDesc dialogDetailDesc, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogDetailDesc;
        dialogDetailDesc.tvDialogTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dialog_title, "field 'tvDialogTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_dialog_close, "field 'ivDialogClose' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_dialog_close, "field 'ivDialogClose'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDetailDesc));
        dialogDetailDesc.ivPoster = (RoundImageView) Utils.findRequiredViewAsType(view, R.id.iv_poster, "field 'ivPoster'", RoundImageView.class);
        dialogDetailDesc.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        dialogDetailDesc.tv1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_1, "field 'tv1'", TextView.class);
        dialogDetailDesc.tv2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_2, "field 'tv2'", TextView.class);
        dialogDetailDesc.tv3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_3, "field 'tv3'", TextView.class);
        dialogDetailDesc.tv4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_4, "field 'tv4'", TextView.class);
        LinearLayout linearLayout = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_tvs, "field 'llytTvs'", LinearLayout.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_source, "field 'tvSource' and method 'onViewClicked'");
        dialogDetailDesc.tvSource = (TextView) Utils.castView(findRequiredView2, R.id.tv_source, "field 'tvSource'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDetailDesc));
        dialogDetailDesc.tvDesc = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_desc, "field 'tvDesc'", TextView.class);
        dialogDetailDesc.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogDetailDesc dialogDetailDesc = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogDetailDesc != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogDetailDesc.ivPoster = null;
            dialogDetailDesc.tvTitle = null;
            dialogDetailDesc.tv1 = null;
            dialogDetailDesc.tv2 = null;
            dialogDetailDesc.tv3 = null;
            dialogDetailDesc.tv4 = null;
            dialogDetailDesc.tvSource = null;
            dialogDetailDesc.tvDesc = null;
            dialogDetailDesc.flytBanner = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
