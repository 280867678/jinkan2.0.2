package me.tvspark.utils.cast.p050ui;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* renamed from: me.tvspark.utils.cast.ui.DialogDlna_ViewBinding */
/* loaded from: classes4.dex */
public class DialogDlna_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogDlna Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.utils.cast.ui.DialogDlna_ViewBinding$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDlna Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna_ViewBinding dialogDlna_ViewBinding, DialogDlna dialogDlna) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDlna;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onClick(view);
        }
    }

    /* renamed from: me.tvspark.utils.cast.ui.DialogDlna_ViewBinding$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogDlna Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogDlna_ViewBinding dialogDlna_ViewBinding, DialogDlna dialogDlna) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogDlna;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onClick(view);
        }
    }

    @UiThread
    public DialogDlna_ViewBinding(DialogDlna dialogDlna, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogDlna;
        dialogDlna.rvProgress = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_progress, "field 'rvProgress'", RecyclerView.class);
        dialogDlna.tvDialogTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_dialog_title, "field 'tvDialogTitle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_net_setting, "method 'onClick'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDlna));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_cast_control, "method 'onClick'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogDlna));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogDlna dialogDlna = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogDlna != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogDlna.rvProgress = null;
            dialogDlna.tvDialogTitle = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
