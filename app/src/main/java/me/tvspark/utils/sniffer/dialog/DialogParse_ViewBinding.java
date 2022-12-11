package me.tvspark.utils.sniffer.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogParse_ViewBinding implements Unbinder {
    public DialogParse Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public DialogParse_ViewBinding(DialogParse dialogParse, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogParse;
        dialogParse.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        dialogParse.rvProgress = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_progress, "field 'rvProgress'", RecyclerView.class);
        dialogParse.llytPcPlay = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_pc_play, "field 'llytPcPlay'", LinearLayout.class);
        dialogParse.tvIp = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ip, "field 'tvIp'", TextView.class);
        dialogParse.tvDialogTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dialog_title, "field 'tvDialogTitle'", TextView.class);
        dialogParse.ivDialogClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_dialog_close, "field 'ivDialogClose'", ImageView.class);
        dialogParse.ivQuickSniff = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_quick_sniff, "field 'ivQuickSniff'", ImageView.class);
        dialogParse.llytQuickSniff = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_quick_sniff, "field 'llytQuickSniff'", LinearLayout.class);
        dialogParse.viewBottom = Utils.findRequiredView(view, R.id.view_bottom, "field 'viewBottom'");
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogParse dialogParse = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogParse != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogParse.flytBanner = null;
            dialogParse.rvProgress = null;
            dialogParse.llytPcPlay = null;
            dialogParse.tvIp = null;
            dialogParse.tvDialogTitle = null;
            dialogParse.ivDialogClose = null;
            dialogParse.ivQuickSniff = null;
            dialogParse.llytQuickSniff = null;
            dialogParse.viewBottom = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
