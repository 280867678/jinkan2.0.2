package me.tvspark.utils.cast.p050ui;

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

/* renamed from: me.tvspark.utils.cast.ui.DialogEpisode_ViewBinding */
/* loaded from: classes4.dex */
public class DialogEpisode_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogEpisode Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.utils.cast.ui.DialogEpisode_ViewBinding$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogEpisode Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogEpisode_ViewBinding dialogEpisode_ViewBinding, DialogEpisode dialogEpisode) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogEpisode;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            Dialog dialog;
            DialogEpisode dialogEpisode = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (dialogEpisode != null) {
                if (view.getId() != R.id.iv_close || (dialog = dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww) == null || !dialog.isShowing()) {
                    return;
                }
                dialogEpisode.Wwwwwwwwwwwwwwwwwwwwwww.dismiss();
                return;
            }
            throw null;
        }
    }

    @UiThread
    public DialogEpisode_ViewBinding(DialogEpisode dialogEpisode, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogEpisode;
        dialogEpisode.rvFile = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_file, "field 'rvFile'", RecyclerView.class);
        dialogEpisode.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_close, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogEpisode));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogEpisode dialogEpisode = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogEpisode != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogEpisode.rvFile = null;
            dialogEpisode.flytBanner = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
