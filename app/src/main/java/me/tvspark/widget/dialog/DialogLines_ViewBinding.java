package me.tvspark.widget.dialog;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class DialogLines_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public DialogLines Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogLines Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogLines_ViewBinding dialogLines_ViewBinding, DialogLines dialogLines) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogLines;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogLines Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogLines_ViewBinding dialogLines_ViewBinding, DialogLines dialogLines) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogLines;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ DialogLines Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DialogLines_ViewBinding dialogLines_ViewBinding, DialogLines dialogLines) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = dialogLines;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public DialogLines_ViewBinding(DialogLines dialogLines, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = dialogLines;
        dialogLines.rvFile = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_file, "field 'rvFile'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_ok, "field 'tvOk' and method 'onViewClicked'");
        dialogLines.tvOk = (TextView) Utils.castView(findRequiredView, R.id.tv_ok, "field 'tvOk'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogLines));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.tv_cancel, "field 'tvCancel' and method 'onViewClicked'");
        TextView textView = (TextView) Utils.castView(findRequiredView2, R.id.tv_cancel, "field 'tvCancel'", TextView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogLines));
        TextView textView2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_add, "field 'tvAdd'", TextView.class);
        dialogLines.llytChangeConfUrl = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_change_conf_url, "field 'llytChangeConfUrl'", LinearLayout.class);
        dialogLines.flytBanner = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_banner, "field 'flytBanner'", FrameLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.tv_change_conf_url, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, dialogLines));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DialogLines dialogLines = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (dialogLines != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            dialogLines.rvFile = null;
            dialogLines.tvOk = null;
            dialogLines.llytChangeConfUrl = null;
            dialogLines.flytBanner = null;
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
