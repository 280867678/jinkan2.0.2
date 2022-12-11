package me.tvspark.view.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class History2Fragment_ViewBinding implements Unbinder {
    public History2Fragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public History2Fragment_ViewBinding(History2Fragment history2Fragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = history2Fragment;
        history2Fragment.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        ProgressBar progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_all, "field 'pbAll'", ProgressBar.class);
        history2Fragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        history2Fragment.llytAllRetry = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_all_retry, "field 'llytAllRetry'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        History2Fragment history2Fragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (history2Fragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            history2Fragment.rvContent = null;
            history2Fragment.tvRetry = null;
            history2Fragment.llytAllRetry = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
