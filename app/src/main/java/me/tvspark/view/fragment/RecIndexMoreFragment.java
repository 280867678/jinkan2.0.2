package me.tvspark.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.IndexRecMoreAdapter;
import me.tvspark.an0;
import me.tvspark.bl0;
import me.tvspark.common.view.RecyclerFragment;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexRecData;
import me.tvspark.gm0;
import me.tvspark.jl0;
import me.tvspark.r40;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.listener.EndlessOnScrollListener;
import me.tvspark.ym0;
import okhttp3.ResponseBody;
import retrofit2.Call;
import white.whale.R;

/* loaded from: classes4.dex */
public class RecIndexMoreFragment extends RecyclerFragment<VideoParcel, RecyclerView.LayoutManager, ym0> implements an0 {
    public WebSourceIndexRecData Wwwwwwwwwwww;
    public IndexRecMoreAdapter Wwwwwwwwwwwwww;
    @BindView(R.id.llyt_error)
    public LinearLayout llytError;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.tv_go_web)
    public TextView tvGoWeb;
    @BindView(R.id.tv_retry)
    public TextView tvRetry;
    public List<VideoParcel> Wwwwwwwwwwwww = new ArrayList();
    public String Wwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return new gm0();
    }

    @Override // me.tvspark.common.view.RecyclerFragment, me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_recycler_index;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!z) {
            this.llytError.setVisibility(8);
            this.mRefreshLayout.setVisibility(0);
            return;
        }
        this.llytError.setVisibility(0);
        this.mRefreshLayout.setVisibility(8);
        this.tvRetry.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.tvGoWeb.setVisibility(8);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww && z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
            if (!this.mRefreshLayout.isRefreshing()) {
                this.mRefreshLayout.setRefreshing(true);
            }
            if (this.Wwwwwwwwwwww == null || this.Wwwwwwwwwwwwwwwww == null) {
                return;
            }
            this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.mRecyclerView.setItemAnimator(null);
        boolean z = true;
        this.mRefreshLayout.setEnabled(true);
        super.mRecyclerView.setLayoutManager(new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 3));
        this.mRecyclerView.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(9)));
        IndexRecMoreAdapter indexRecMoreAdapter = new IndexRecMoreAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new ArrayList());
        this.Wwwwwwwwwwwwww = indexRecMoreAdapter;
        super.mRecyclerView.setAdapter(indexRecMoreAdapter);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        SwipeRefreshLayout swipeRefreshLayout = super.mRefreshLayout;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        swipeRefreshLayout.setOnRefreshListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        RecyclerView recyclerView = super.mRecyclerView;
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        recyclerView.addOnScrollListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!getUserVisibleHint() || this.Wwwwwwwwwwwwwwwwwww) {
            z = false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Wwwwwwwwwww = arguments.getString("key_string");
        }
        this.Wwwwwwwwwwww = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z && !this.Wwwwwwwwwwwwwwwwwww);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EndlessOnScrollListener<VideoParcel> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return true;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return RecIndexMoreFragment.this.mRefreshLayout;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return RecIndexMoreFragment.this.Wwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return RecIndexMoreFragment.this.Wwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return null;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return RecIndexMoreFragment.this.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            RecIndexMoreFragment recIndexMoreFragment = RecIndexMoreFragment.this;
            return ((ym0) RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(recIndexMoreFragment.Wwwwwwwwwww, i, recIndexMoreFragment.Wwwwwwwwwwww);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
            ((ym0) RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", i, RecIndexMoreFragment.this.Wwwwwwwwwwww);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
            try {
                ((ym0) RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(responseBody.string(), i, RecIndexMoreFragment.this.Wwwwwwwwwwww);
            } catch (Exception e) {
                e.printStackTrace();
                ((ym0) RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("", i, RecIndexMoreFragment.this.Wwwwwwwwwwww);
            }
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
            ((ym0) RecIndexMoreFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, i, RecIndexMoreFragment.this.Wwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.an0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<VideoParcel> list, String str, int i) {
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwww = list;
        if (this.Wwwwwwwwwwwwww.getItemCount() == 0 || !this.Wwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwww.addAll(this.Wwwwwwwwwwwww);
            IndexRecMoreAdapter indexRecMoreAdapter = this.Wwwwwwwwwwwwww;
            List list2 = this.Wwwwwwwwwwwwwww;
            if (indexRecMoreAdapter != null) {
                if (list2 != null && !list2.isEmpty()) {
                    indexRecMoreAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                    indexRecMoreAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    indexRecMoreAdapter.notifyDataSetChanged();
                }
            } else {
                throw null;
            }
        }
        if (this.Wwwwwwwwwwwwww.getItemCount() == 0 && i == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }
}
