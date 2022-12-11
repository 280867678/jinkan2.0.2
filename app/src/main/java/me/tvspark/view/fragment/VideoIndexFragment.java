package me.tvspark.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.VideoIndexListAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.RecyclerFragment;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.data.bean.VideoIndexParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.jn0;
import me.tvspark.kn0;
import me.tvspark.mm0;
import me.tvspark.mn0;
import me.tvspark.qn0;
import me.tvspark.widget.listener.EndlessOnScrollListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import white.whale.R;

/* loaded from: classes4.dex */
public class VideoIndexFragment extends RecyclerFragment<VideoIndexParcel, RecyclerView.LayoutManager, jn0> implements kn0 {
    public boolean Wwwwwwwwww;
    public boolean Wwwwwwwwwww;
    public WebSourceIndexData Wwwwwwwwwwww;
    public List<VideoIndexParcel> Wwwwwwwwwwwww = new ArrayList();
    public VideoIndexListAdapter Wwwwwwwwwwwwww;
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

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, VideoIndexFragment.this.Wwwwwwwwwwww.getWebIndexUrl(), false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ String Wwwwwwwwwwwwwwwwwwwwwwww;

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((jn0) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, null, this.Wwwwwwwwwwwwwwwwwwwwwwww, 0, VideoIndexFragment.this.Wwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements VideoIndexListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public static VideoIndexFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(WebSourceIndexData webSourceIndexData, boolean z, boolean z2) {
        VideoIndexFragment videoIndexFragment = new VideoIndexFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcel", webSourceIndexData);
        bundle.putBoolean("key_boolean", z);
        bundle.putBoolean("key_boolean_one", z2);
        videoIndexFragment.setArguments(bundle);
        return videoIndexFragment;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return new mm0();
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
        this.tvRetry.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.tvGoWeb.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (this.Wwwwwwwwwwwwwwwwwwwwww && z) {
            this.Wwwwwwwwww = false;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        super.mRecyclerView.setLayoutManager(linearLayoutManager);
        VideoIndexListAdapter videoIndexListAdapter = new VideoIndexListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new ArrayList());
        videoIndexListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwww = videoIndexListAdapter;
        super.mRecyclerView.setAdapter(videoIndexListAdapter);
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwww;
        if (this.Wwwwwwwwwww && !this.Wwwwwwwwww) {
            qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            String str = qn0.Wwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            qn0Var.Wwwwwwwwwwwwwwwwwwwwwww = str;
            qn0Var.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            qn0Var.execute(new Void[0]);
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        SwipeRefreshLayout swipeRefreshLayout = super.mRefreshLayout;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        swipeRefreshLayout.setOnRefreshListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        RecyclerView recyclerView = super.mRecyclerView;
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        recyclerView.addOnScrollListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!this.Wwwwwwwwww && (!getUserVisibleHint() || this.Wwwwwwwwwwwwwwwwwww)) {
            z = false;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Wwwwwwwwwww = arguments.getBoolean("key_boolean", false);
            this.Wwwwwwwwww = arguments.getBoolean("key_boolean_one", false);
            this.Wwwwwwwwwwww = (WebSourceIndexData) arguments.getParcelable("key_parcel");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww || (z && !this.Wwwwwwwwwwwwwwwwwww));
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EndlessOnScrollListener<VideoIndexParcel> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return false;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return VideoIndexFragment.this.mRefreshLayout;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return VideoIndexFragment.this.Wwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public List<VideoIndexParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return VideoIndexFragment.this.Wwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return null;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return VideoIndexFragment.this.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return ((jn0) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoIndexFragment.this.Wwwwwwwwwwww);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
            ((jn0) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, null, "", i, VideoIndexFragment.this.Wwwwwwwwwwww);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
            try {
                if (!((jn0) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, responseBody, "", i, VideoIndexFragment.this.Wwwwwwwwwwww)) {
                    return;
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                long currentTimeMillis = System.currentTimeMillis();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = currentTimeMillis;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(currentTimeMillis);
            } catch (Exception e) {
                e.printStackTrace();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, i);
            }
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
            ((jn0) VideoIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, null, str, i, VideoIndexFragment.this.Wwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.kn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<VideoIndexParcel> list, String str) {
        if (!z || list == null || list.isEmpty() || !this.Wwwwwwwwwwwwwww.isEmpty()) {
            return;
        }
        this.Wwwwwwwwwwwwwww.addAll(list);
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.kn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<VideoIndexParcel> list, String str, int i) {
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwww = true;
        this.Wwwwwwwwwwwww = list;
        if (this.Wwwwwwwwwwwwww.getItemCount() == 0 || !this.Wwwwwwwwwwwww.isEmpty()) {
            this.Wwwwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwwwww.addAll(this.Wwwwwwwwwwwww);
            this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwww && !TextUtils.isEmpty(str) && !list.isEmpty() && i == 0) {
            qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            qn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwwwwww, str);
            qn0Var.execute(new Void[0]);
        }
        if (this.Wwwwwwwwwwwwww.getItemCount() == 0 && i == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        }
    }
}
