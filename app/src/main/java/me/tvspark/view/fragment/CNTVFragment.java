package me.tvspark.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.CNTVAdapter;
import me.tvspark.adapter.CategoryTypeListAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.RecyclerFragment;
import me.tvspark.data.bean.CNTVParcel;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.pm0;
import me.tvspark.presenter.CNTVPresenterImpl;
import me.tvspark.qm0;
import me.tvspark.qn0;
import me.tvspark.r40;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.listener.EndlessOnScrollListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import white.whale.R;

/* loaded from: classes4.dex */
public class CNTVFragment extends RecyclerFragment<CNTVParcel.DataBean.ListBean, RecyclerView.LayoutManager, pm0> implements qm0 {
    public GenreParcel Wwwwwwwwwww;
    public List<GenreParcel> Wwwwwwwwwwww = new ArrayList();
    public CategoryTypeListAdapter Wwwwwwwwwwwww;
    public CNTVAdapter Wwwwwwwwwwwwww;
    @BindView(R.id.layout_ing_retry)
    public RelativeLayout layoutIngRetry;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.rv_type)
    public RecyclerView rvType;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CNTVFragment.this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            CNTVFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            CNTVFragment cNTVFragment = CNTVFragment.this;
            cNTVFragment.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            CNTVAdapter cNTVAdapter = cNTVFragment.Wwwwwwwwwwwwww;
            cNTVAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            cNTVAdapter.notifyDataSetChanged();
            CNTVFragment cNTVFragment2 = CNTVFragment.this;
            cNTVFragment2.Wwwwwwwwwww = genreParcel;
            cNTVFragment2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((pm0) CNTVFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, str, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends GridLayoutManager.SpanSizeLookup {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CNTVFragment cNTVFragment) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return i == 0 ? 3 : 1;
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return new CNTVPresenterImpl();
    }

    @Override // me.tvspark.common.view.RecyclerFragment, me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_cntv;
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
            new Handler().postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(), i * 1000);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwww = new CNTVAdapter(getActivity());
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 3);
        gridLayoutManager.setSpanSizeLookup(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        this.mRecyclerView.setLayoutManager(gridLayoutManager);
        this.mRecyclerView.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9)));
        this.mRecyclerView.setAdapter(this.Wwwwwwwwwwwwww);
        qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
        String str = qn0.Wwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        qn0Var.Wwwwwwwwwwwwwwwwwwwwwww = str;
        qn0Var.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        qn0Var.execute(new Void[0]);
        this.mRefreshLayout.setEnabled(false);
        this.mRefreshLayout.setProgressViewOffset(true, 0, (int) TypedValue.applyDimension(1, 50.0f, getResources().getDisplayMetrics()));
        CategoryTypeListAdapter categoryTypeListAdapter = new CategoryTypeListAdapter(getActivity(), this.Wwwwwwwwwwww);
        categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwww = categoryTypeListAdapter;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(0);
        this.rvType.setLayoutManager(linearLayoutManager);
        this.rvType.setAdapter(this.Wwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        SwipeRefreshLayout swipeRefreshLayout = super.mRefreshLayout;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        swipeRefreshLayout.setOnRefreshListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        RecyclerView recyclerView = this.mRecyclerView;
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        recyclerView.addOnScrollListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.qm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<GenreParcel> list) {
        this.Wwwwwwwwwwww.addAll(list);
        this.Wwwwwwwwwww = this.Wwwwwwwwwwww.get(0);
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ((pm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z && !this.Wwwwwwwwwwwwwwwwwww, false);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EndlessOnScrollListener<CNTVParcel.DataBean.ListBean> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CNTVFragment.this.mRefreshLayout;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CNTVFragment.this.Wwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public List<CNTVParcel.DataBean.ListBean> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CNTVFragment.this.Wwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return null;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return CNTVFragment.this.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return ((pm0) CNTVFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CNTVFragment.this.Wwwwwwwwwww, i);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
            try {
                ((pm0) CNTVFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, responseBody.string(), i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
            List<CNTVParcel.DataBean.ListBean> list = CNTVFragment.this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (list == null || list.isEmpty()) {
                CNTVFragment.this.layoutIngRetry.setVisibility(0);
                CNTVFragment.this.mRefreshLayout.setVisibility(8);
            }
        }
    }

    @Override // me.tvspark.qm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<CNTVParcel.DataBean.ListBean> list, String str) {
        if (this.Wwwwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwww.addAll(list);
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww, false);
        }
    }

    @Override // me.tvspark.qm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<CNTVParcel.DataBean.ListBean> list, String str, int i) {
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
        if (!TextUtils.isEmpty(str) && list != null && !list.isEmpty() && i == 0 && this.Wwwwwwwwwww.getName().equals(this.Wwwwwwwwwwww.get(0).getName())) {
            qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            qn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwwwwwww, str);
            qn0Var.execute(new Void[0]);
        }
        List<CNTVParcel.DataBean.ListBean> list2 = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (list2 != null && !list2.isEmpty()) {
            z2 = false;
        }
        if (z2) {
            this.layoutIngRetry.setVisibility(0);
            this.mRefreshLayout.setVisibility(8);
        }
    }
}
