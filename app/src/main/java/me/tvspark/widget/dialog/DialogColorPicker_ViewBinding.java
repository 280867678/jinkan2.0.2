package me.tvspark.widget.dialog;

import android.app.Dialog;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogColorPicker_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogColorPicker Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogColorPicker Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogColorPicker_ViewBinding dialogColorPicker_ViewBinding, DialogColorPicker dialogColorPicker) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogColorPicker;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            Dialog dialog;
            DialogColorPicker dialogColorPicker = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (dialogColorPicker != null) {
                if (view.getId() != R.id.tv_cancel || (dialog = dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww) == null || !dialog.isShowing()) {
                    return;
                }
                dialogColorPicker.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
                return;
            }
            throw null;
        }
    }

    @UiThread
    public DialogColorPicker_ViewBinding(DialogColorPicker dialogColorPicker, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogColorPicker;
        dialogColorPicker.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        dialogColorPicker.flytBg = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_bg, "field 'flytBg'", FrameLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_cancel, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogColorPicker));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogColorPicker dialogColorPicker = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogColorPicker != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogColorPicker.rvContent = null;
            dialogColorPicker.flytBg = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
