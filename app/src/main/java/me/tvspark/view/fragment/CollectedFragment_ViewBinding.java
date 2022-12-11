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
public class CollectedFragment_ViewBinding implements Unbinder {
    public CollectedFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @UiThread
    public CollectedFragment_ViewBinding(CollectedFragment collectedFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = collectedFragment;
        collectedFragment.rvContent = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_content, "field 'rvContent'", RecyclerView.class);
        ProgressBar progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.pb_all, "field 'pbAll'", ProgressBar.class);
        collectedFragment.tvRetry = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_retry, "field 'tvRetry'", TextView.class);
        collectedFragment.llytAllRetry = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_all_retry, "field 'llytAllRetry'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CollectedFragment collectedFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (collectedFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            collectedFragment.rvContent = null;
            collectedFragment.tvRetry = null;
            collectedFragment.llytAllRetry = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
