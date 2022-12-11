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
public class History1Fragment_ViewBinding implements Unbinder {
    public History1Fragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public History1Fragment_ViewBinding(History1Fragment history1Fragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = history1Fragment;
        history1Fragment.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        ProgressBar progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_all, "field 'pbAll'", ProgressBar.class);
        history1Fragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        history1Fragment.llytAllRetry = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_all_retry, "field 'llytAllRetry'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        History1Fragment history1Fragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (history1Fragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            history1Fragment.rvContent = null;
            history1Fragment.tvRetry = null;
            history1Fragment.llytAllRetry = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
