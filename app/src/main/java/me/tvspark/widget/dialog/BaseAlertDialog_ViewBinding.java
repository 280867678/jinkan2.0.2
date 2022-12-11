package me.tvspark.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class BaseAlertDialog_ViewBinding implements Unbinder {
    public BaseAlertDialog Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public BaseAlertDialog_ViewBinding(BaseAlertDialog baseAlertDialog, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = baseAlertDialog;
        baseAlertDialog.flytBg = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_bg, "field 'flytBg'", FrameLayout.class);
        baseAlertDialog.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        baseAlertDialog.tvMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg, "field 'tvMsg'", TextView.class);
        baseAlertDialog.tvOk = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ok, "field 'tvOk'", TextView.class);
        baseAlertDialog.tvCancel = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        baseAlertDialog.flytView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_view, "field 'flytView'", FrameLayout.class);
        baseAlertDialog.listView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list_view, "field 'listView'", RecyclerView.class);
        ImageView imageView = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_icon, "field 'ivIcon'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        BaseAlertDialog baseAlertDialog = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (baseAlertDialog != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            baseAlertDialog.flytBg = null;
            baseAlertDialog.tvTitle = null;
            baseAlertDialog.tvMsg = null;
            baseAlertDialog.tvOk = null;
            baseAlertDialog.tvCancel = null;
            baseAlertDialog.flytView = null;
            baseAlertDialog.listView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
