package me.tvspark.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.appbar.AppBarLayout;
import me.tvspark.common.view.RecyclerFragment_ViewBinding;
import white.whale.R;

/* loaded from: classes4.dex */
public class CategoryFragment_ViewBinding extends RecyclerFragment_ViewBinding {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CategoryFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CategoryFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment_ViewBinding categoryFragment_ViewBinding, CategoryFragment categoryFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = categoryFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CategoryFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment_ViewBinding categoryFragment_ViewBinding, CategoryFragment categoryFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = categoryFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ CategoryFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment_ViewBinding categoryFragment_ViewBinding, CategoryFragment categoryFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = categoryFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.onViewClicked(view);
        }
    }

    @UiThread
    public CategoryFragment_ViewBinding(CategoryFragment categoryFragment, View view) {
        super(categoryFragment, view);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = categoryFragment;
        View findRequiredView = Utils.findRequiredView(view, R.id.iv_search, "field 'ivSearch' and method 'onViewClicked'");
        ImageView imageView = (ImageView) Utils.castView(findRequiredView, R.id.iv_search, "field 'ivSearch'", ImageView.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, categoryFragment));
        AppBarLayout appBarLayout = (AppBarLayout) Utils.findRequiredViewAsType(view, R.id.top, "field 'top'", AppBarLayout.class);
        categoryFragment.rvForm = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_form, "field 'rvForm'", RecyclerView.class);
        categoryFragment.rvType = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_type, "field 'rvType'", RecyclerView.class);
        categoryFragment.rvArea = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_area, "field 'rvArea'", RecyclerView.class);
        categoryFragment.rvYear = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_year, "field 'rvYear'", RecyclerView.class);
        categoryFragment.rvSort = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_sort, "field 'rvSort'", RecyclerView.class);
        categoryFragment.stickyHeaderView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rlyt_sticky_header_view, "field 'stickyHeaderView'", RelativeLayout.class);
        categoryFragment.tv_category = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_category, "field 'tv_category'", TextView.class);
        categoryFragment.llyt_rv_category = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_rv_category, "field 'llyt_rv_category'", LinearLayout.class);
        categoryFragment.llytCategorySummary = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.llyt_category_summary, "field 'llytCategorySummary'", LinearLayout.class);
        categoryFragment.mRefreshLayout = (SwipeRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'mRefreshLayout'", SwipeRefreshLayout.class);
        ProgressBar progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, R.id.view_progress, "field 'viewProgress'", ProgressBar.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.view_retry, "field 'viewRetry' and method 'onViewClicked'");
        LinearLayout linearLayout = (LinearLayout) Utils.castView(findRequiredView2, R.id.view_retry, "field 'viewRetry'", LinearLayout.class);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView2;
        findRequiredView2.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, categoryFragment));
        categoryFragment.layoutIngRetry = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.layout_ing_retry, "field 'layoutIngRetry'", RelativeLayout.class);
        View findRequiredView3 = Utils.findRequiredView(view, R.id.iv_action_cast, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView3;
        findRequiredView3.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, categoryFragment));
    }

    @Override // me.tvspark.common.view.RecyclerFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        CategoryFragment categoryFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (categoryFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            categoryFragment.rvForm = null;
            categoryFragment.rvType = null;
            categoryFragment.rvArea = null;
            categoryFragment.rvYear = null;
            categoryFragment.rvSort = null;
            categoryFragment.stickyHeaderView = null;
            categoryFragment.tv_category = null;
            categoryFragment.llyt_rv_category = null;
            categoryFragment.llytCategorySummary = null;
            categoryFragment.mRefreshLayout = null;
            categoryFragment.layoutIngRetry = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            super.unbind();
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
