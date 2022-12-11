package me.tvspark.view.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchActivity_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SearchActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ SearchActivity Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchActivity_ViewBinding searchActivity_ViewBinding, SearchActivity searchActivity) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = searchActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public SearchActivity_ViewBinding(SearchActivity searchActivity, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = searchActivity;
        searchActivity.etSearch = (EditText) Utils.findRequiredViewAsType(view, R.id.et_search, "field 'etSearch'", EditText.class);
        searchActivity.ivSearch = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_search, "field 'ivSearch'", ImageView.class);
        searchActivity.flytHistory = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_history, "field 'flytHistory'", FrameLayout.class);
        searchActivity.flytWeb = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_web, "field 'flytWeb'", FrameLayout.class);
        searchActivity.flytWebSourceAll = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_web_source_all, "field 'flytWebSourceAll'", FrameLayout.class);
        searchActivity.flytWebSourceSignal = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.flyt_web_source_signal, "field 'flytWebSourceSignal'", FrameLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_back, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, searchActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SearchActivity searchActivity = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (searchActivity != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            searchActivity.etSearch = null;
            searchActivity.ivSearch = null;
            searchActivity.flytHistory = null;
            searchActivity.flytWeb = null;
            searchActivity.flytWebSourceAll = null;
            searchActivity.flytWebSourceSignal = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
