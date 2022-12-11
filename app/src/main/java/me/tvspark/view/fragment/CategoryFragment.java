package me.tvspark.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.CategoryAdapter;
import me.tvspark.adapter.CategoryTypeListAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.RecyclerFragment;
import me.tvspark.data.bean.DoubanCategoryParcel;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.mn0;
import me.tvspark.outline;
import me.tvspark.presenter.CategoryPresenterImpl;
import me.tvspark.qn0;
import me.tvspark.r40;
import me.tvspark.rm0;
import me.tvspark.sm0;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.listener.EndlessOnScrollListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import white.whale.R;

/* loaded from: classes4.dex */
public class CategoryFragment extends RecyclerFragment<DoubanCategoryParcel.DataEntity, RecyclerView.LayoutManager, rm0> implements sm0 {
    public GenreParcel Kkkkkkkkkkkkkkkkkkkkkkk;
    public GenreParcel Kkkkkkkkkkkkkkkkkkkkkkkk;
    public GenreParcel Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public GenreParcel Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public GenreParcel Www;
    public CategoryTypeListAdapter Wwwwwwwww;
    public CategoryTypeListAdapter Wwwwwwwwww;
    public CategoryTypeListAdapter Wwwwwwwwwww;
    public CategoryTypeListAdapter Wwwwwwwwwwww;
    public CategoryTypeListAdapter Wwwwwwwwwwwww;
    public CategoryAdapter Wwwwwwwwwwwwww;
    @BindView(R.id.layout_ing_retry)
    public RelativeLayout layoutIngRetry;
    @BindView(R.id.llyt_category_summary)
    public LinearLayout llytCategorySummary;
    @BindView(R.id.llyt_rv_category)
    public LinearLayout llyt_rv_category;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_area)
    public RecyclerView rvArea;
    @BindView(R.id.rv_form)
    public RecyclerView rvForm;
    @BindView(R.id.rv_sort)
    public RecyclerView rvSort;
    @BindView(R.id.rv_type)
    public RecyclerView rvType;
    @BindView(R.id.rv_year)
    public RecyclerView rvYear;
    @BindView(R.id.rlyt_sticky_header_view)
    public RelativeLayout stickyHeaderView;
    @BindView(R.id.tv_category)
    public TextView tv_category;
    public List<GenreParcel> Wwwwwwww = new ArrayList();
    public List<GenreParcel> Wwwwwww = new ArrayList();
    public List<GenreParcel> Wwwwww = new ArrayList();
    public List<GenreParcel> Wwwww = new ArrayList();
    public List<GenreParcel> Wwww = new ArrayList();
    public boolean Kkkkkkkkkkkkkkkkkkkkkk = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CategoryFragment categoryFragment = CategoryFragment.this;
            categoryFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            categoryFragment.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CategoryFragment categoryFragment2 = CategoryFragment.this;
            categoryFragment2.Kkkkkkkkkkkkkkkkkkkkkkk = genreParcel;
            TextView textView = categoryFragment2.tv_category;
            StringBuilder sb = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Www, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            sb.append(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
            textView.setText(sb.toString());
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CategoryFragment categoryFragment = CategoryFragment.this;
            categoryFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            categoryFragment.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CategoryFragment categoryFragment2 = CategoryFragment.this;
            categoryFragment2.Kkkkkkkkkkkkkkkkkkkkkkkk = genreParcel;
            TextView textView = categoryFragment2.tv_category;
            StringBuilder sb = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Www, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            sb.append(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
            textView.setText(sb.toString());
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CategoryFragment categoryFragment = CategoryFragment.this;
            categoryFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            categoryFragment.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CategoryFragment categoryFragment2 = CategoryFragment.this;
            categoryFragment2.Kkkkkkkkkkkkkkkkkkkkkkkkk = genreParcel;
            TextView textView = categoryFragment2.tv_category;
            StringBuilder sb = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Www, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            sb.append(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
            textView.setText(sb.toString());
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CategoryFragment categoryFragment = CategoryFragment.this;
            categoryFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            categoryFragment.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CategoryFragment categoryFragment2 = CategoryFragment.this;
            categoryFragment2.Kkkkkkkkkkkkkkkkkkkkkkkkkk = genreParcel;
            TextView textView = categoryFragment2.tv_category;
            StringBuilder sb = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Www, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            sb.append(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
            textView.setText(sb.toString());
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CategoryFragment categoryFragment = CategoryFragment.this;
            categoryFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            categoryFragment.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CategoryFragment categoryFragment2 = CategoryFragment.this;
            categoryFragment2.Www = genreParcel;
            TextView textView = categoryFragment2.tv_category;
            StringBuilder sb = new StringBuilder();
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Www, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
            sb.append(CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
            textView.setText(sb.toString());
            CategoryFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends RecyclerView.OnScrollListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            View childAt = recyclerView.getChildAt(0);
            int top = childAt.getTop();
            if (CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkk || childAt.getTag() == null) {
                CategoryFragment.this.stickyHeaderView.setTranslationY(0.0f);
                if (!(Math.abs(i2) > r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2))) {
                    return;
                }
                LinearLayout linearLayout = CategoryFragment.this.llyt_rv_category;
                if (i2 > 0) {
                    linearLayout.setVisibility(8);
                    CategoryFragment.this.llytCategorySummary.setVisibility(0);
                    CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkk = false;
                    return;
                }
                linearLayout.setVisibility(0);
                CategoryFragment.this.llytCategorySummary.setVisibility(8);
                CategoryFragment.this.Kkkkkkkkkkkkkkkkkkkkkk = true;
                return;
            }
            int intValue = ((Integer) childAt.getTag()).intValue();
            CategoryAdapter categoryAdapter = CategoryFragment.this.Wwwwwwwwwwwwww;
            if (intValue != 6) {
                return;
            }
            if (childAt.getTop() > (-r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(150))) {
                CategoryFragment.this.stickyHeaderView.setTranslationY(top);
                CategoryFragment.this.llyt_rv_category.setVisibility(0);
                CategoryFragment.this.llytCategorySummary.setVisibility(8);
                return;
            }
            CategoryFragment.this.stickyHeaderView.setTranslationY(0.0f);
            CategoryFragment.this.llyt_rv_category.setVisibility(8);
            CategoryFragment.this.llytCategorySummary.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((rm0) CategoryFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, str, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends GridLayoutManager.SpanSizeLookup {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CategoryFragment categoryFragment) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return i == 0 ? 3 : 1;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CategoryFragment.this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return new CategoryPresenterImpl();
    }

    @Override // me.tvspark.common.view.RecyclerFragment, me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_category;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww && z) {
            this.layoutIngRetry.setVisibility(8);
            int i = 0;
            this.mRefreshLayout.setVisibility(0);
            this.mRefreshLayout.setRefreshing(true);
            if (z2) {
                i = (int) (Math.random() * 6.0d);
            }
            new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i * 1000);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwww = new CategoryAdapter(getActivity());
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 3);
        gridLayoutManager.setSpanSizeLookup(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        this.mRecyclerView.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9)));
        this.mRecyclerView.setAdapter(this.Wwwwwwwwwwwwww);
        qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
        String str = qn0.Wwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        qn0Var.Wwwwwwwwwwwwwwwwwwwwwww = str;
        qn0Var.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        qn0Var.execute(new Void[0]);
        TextView textView = this.tv_category;
        StringBuilder sb = new StringBuilder();
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Www, sb, " · ");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
        outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk, sb, " · ");
        sb.append(this.Kkkkkkkkkkkkkkkkkkkkkkk.getName());
        textView.setText(sb.toString());
        this.mRefreshLayout.setEnabled(false);
        this.mRefreshLayout.setProgressViewOffset(true, 0, (int) TypedValue.applyDimension(1, 220.0f, getResources().getDisplayMetrics()));
        this.mRecyclerView.setOnScrollListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        CategoryTypeListAdapter categoryTypeListAdapter = new CategoryTypeListAdapter(getActivity(), this.Wwwwwwww);
        categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwww = categoryTypeListAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        this.rvForm.setLayoutManager(linearLayoutManager);
        this.rvForm.setAdapter(this.Wwwwwwwwwwwww);
        CategoryTypeListAdapter categoryTypeListAdapter2 = new CategoryTypeListAdapter(getActivity(), this.Wwwwwww);
        categoryTypeListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwww = categoryTypeListAdapter2;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(0);
        this.rvType.setLayoutManager(linearLayoutManager2);
        this.rvType.setAdapter(this.Wwwwwwwwwwww);
        CategoryTypeListAdapter categoryTypeListAdapter3 = new CategoryTypeListAdapter(getActivity(), this.Wwwwww);
        categoryTypeListAdapter3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwww = categoryTypeListAdapter3;
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity());
        linearLayoutManager3.setOrientation(0);
        this.rvArea.setLayoutManager(linearLayoutManager3);
        this.rvArea.setAdapter(this.Wwwwwwwwwww);
        CategoryTypeListAdapter categoryTypeListAdapter4 = new CategoryTypeListAdapter(getActivity(), this.Wwwww);
        categoryTypeListAdapter4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwww = categoryTypeListAdapter4;
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity());
        linearLayoutManager4.setOrientation(0);
        this.rvYear.setLayoutManager(linearLayoutManager4);
        this.rvYear.setAdapter(this.Wwwwwwwwww);
        CategoryTypeListAdapter categoryTypeListAdapter5 = new CategoryTypeListAdapter(getActivity(), this.Wwww);
        categoryTypeListAdapter5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwww = categoryTypeListAdapter5;
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity());
        linearLayoutManager5.setOrientation(0);
        this.rvSort.setLayoutManager(linearLayoutManager5);
        this.rvSort.setAdapter(this.Wwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwww();
        SwipeRefreshLayout swipeRefreshLayout = super.mRefreshLayout;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwww;
        swipeRefreshLayout.setOnRefreshListener(wwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        RecyclerView recyclerView = this.mRecyclerView;
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        recyclerView.addOnScrollListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.sm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<GenreParcel> list, List<GenreParcel> list2, List<GenreParcel> list3, List<GenreParcel> list4, List<GenreParcel> list5) {
        this.Wwwwwwww.addAll(list);
        this.Wwwwwww.addAll(list2);
        this.Wwwwww.addAll(list3);
        this.Wwwww.addAll(list4);
        this.Wwww.addAll(list5);
        this.Www = this.Wwwwwwww.get(0);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwwww.get(0);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwwww.get(0);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = this.Wwwww.get(0);
        this.Kkkkkkkkkkkkkkkkkkkkkkk = this.Wwww.get(0);
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((rm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @OnClick({R.id.iv_action_cast, R.id.iv_search, R.id.view_retry})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.iv_action_cast) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        } else if (id == R.id.iv_search) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "");
        } else if (id != R.id.view_retry) {
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z && !this.Wwwwwwwwwwwwwwwwwww, false);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EndlessOnScrollListener<DoubanCategoryParcel.DataEntity> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CategoryFragment.this.mRefreshLayout;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CategoryFragment.this.Wwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public List<DoubanCategoryParcel.DataEntity> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CategoryFragment.this.Wwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return null;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CategoryFragment.this.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            rm0 rm0Var = (rm0) CategoryFragment.this.Wwwwwwwwwwwwwwwwwwww;
            CategoryFragment categoryFragment = CategoryFragment.this;
            return rm0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(categoryFragment.Www, categoryFragment.Kkkkkkkkkkkkkkkkkkkkkkkkkk, categoryFragment.Kkkkkkkkkkkkkkkkkkkkkkkkk, categoryFragment.Kkkkkkkkkkkkkkkkkkkkkkkk, categoryFragment.Kkkkkkkkkkkkkkkkkkkkkkk, i);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
            try {
                ((rm0) CategoryFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, responseBody.string(), i);
            } catch (Exception e) {
                e.printStackTrace();
                ((rm0) CategoryFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, "", i);
            }
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
            List<DoubanCategoryParcel.DataEntity> list = CategoryFragment.this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null || list.isEmpty()) {
                CategoryFragment.this.layoutIngRetry.setVisibility(0);
                CategoryFragment.this.mRefreshLayout.setVisibility(8);
            }
        }
    }

    @Override // me.tvspark.sm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<DoubanCategoryParcel.DataEntity> list, String str) {
        if (this.Wwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwww.addAll(list);
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, false);
        }
    }

    @Override // me.tvspark.sm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<DoubanCategoryParcel.DataEntity> list, String str, int i) {
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        boolean z2 = true;
        if (i == 0 && !list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwww = true;
        }
        if (i != 0 || this.Wwwwwwwwwwwwwww.isEmpty() || !list.isEmpty()) {
            if (list != null && !list.isEmpty()) {
                if (i == 0) {
                    this.Wwwwwwwwwwwwwww.clear();
                }
                this.Wwwwwwwwwwwwwww.addAll(list);
            } else if (i == 0) {
                this.Wwwwwwwwwwwwwww.clear();
            }
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, false);
        }
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty() && i == 0 && this.Www.getName().equals(this.Wwwwwwww.get(0).getName()) && this.Kkkkkkkkkkkkkkkkkkkkkkkkkk.getName().equals(this.Wwwwwww.get(0).getName()) && this.Kkkkkkkkkkkkkkkkkkkkkkkkk.getName().equals(this.Wwwwww.get(0).getName()) && this.Kkkkkkkkkkkkkkkkkkkkkkkk.getName().equals(this.Wwwww.get(0).getName()) && this.Kkkkkkkkkkkkkkkkkkkkkkk.getName().equals(this.Wwww.get(0).getName())) {
            qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            qn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwwwwwwww, str);
            qn0Var.execute(new Void[0]);
        }
        List<DoubanCategoryParcel.DataEntity> list2 = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list2 != null && !list2.isEmpty()) {
            z2 = false;
        }
        if (z2) {
            this.layoutIngRetry.setVisibility(0);
            this.mRefreshLayout.setVisibility(8);
        }
    }
}
