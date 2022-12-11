package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.SearchListAdapter;
import me.tvspark.adapter.WebSourceListAdapter;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.bean.EngineResultParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.hn0;
import me.tvspark.in0;
import me.tvspark.lm0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.widget.decoration.GridSpanDecoration;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceAllFragment extends BaseFragment<hn0> implements in0 {
    public SearchListAdapter Wwwwwwwww;
    public WebSourceListAdapter Wwwwwwwwww;
    public View.OnClickListener Wwwwwwwwwwwwww;
    public Spanned Wwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    @BindView(R.id.layout_ing_retry)
    public RelativeLayout layoutIngRetry;
    @BindView(R.id.llyt_all)
    public LinearLayout llytAll;
    @BindView(R.id.rv_channel)
    public RecyclerView rvChannel;
    @BindView(R.id.rv_episode)
    public RecyclerView rvEpisode;
    @BindView(R.id.tv_retry)
    public TextView tvRetry;
    @BindView(R.id.tv_retry2)
    public TextView tvRetry2;
    @BindView(R.id.view_progress)
    public ProgressBar viewProgress;
    @BindView(R.id.view_retry)
    public LinearLayout viewRetry;
    public boolean Wwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwww = false;
    public boolean Wwwwwwwwwww = true;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchWebSourceAllFragment searchWebSourceAllFragment = SearchWebSourceAllFragment.this;
            ((hn0) SearchWebSourceAllFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceAllFragment.Wwwwwwwwwwwwwwwww, searchWebSourceAllFragment.Wwwwwwwwwww, false);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchWebSourceAllFragment searchWebSourceAllFragment = SearchWebSourceAllFragment.this;
            ((hn0) SearchWebSourceAllFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceAllFragment.Wwwwwwwwwwwwwwwww, searchWebSourceAllFragment.Wwwwwwwwwww, true);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceAllFragment searchWebSourceAllFragment) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements WebSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, WebSourceIndexData webSourceIndexData, List<EngineResultParcel> list) {
            SearchListAdapter searchListAdapter;
            if (!z && list != null && (searchListAdapter = SearchWebSourceAllFragment.this.Wwwwwwwww) != null && !list.isEmpty()) {
                searchListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                searchListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list);
                searchListAdapter.notifyDataSetChanged();
            }
        }
    }

    public final void Wwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwww || this.Wwwwwwwwww.getItemCount() == 0) {
            this.Wwwwwwwwwwww = true;
            ((hn0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwww, true);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public hn0 Wwwwwwwwwwwwwwwww() {
        return new lm0();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_search_web_source_all;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwwwww = getArguments().getString("key_string");
        this.Wwwwwwwwwww = getArguments().getBoolean("key_boolean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        this.rvChannel.setLayoutManager(linearLayoutManager);
        WebSourceListAdapter webSourceListAdapter = new WebSourceListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww);
        webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwww = webSourceListAdapter;
        this.rvChannel.setAdapter(webSourceListAdapter);
        this.rvEpisode.setLayoutManager(new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 3));
        SearchListAdapter searchListAdapter = new SearchListAdapter(new ArrayList(), this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwww = searchListAdapter;
        this.rvEpisode.setAdapter(searchListAdapter);
        this.rvEpisode.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        if (getUserVisibleHint()) {
            Wwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.in0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, String str2, int i, int i2) {
        this.Wwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("网页搜索中 ", i, "/", i2, " .....");
        this.Wwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwww = true;
        if (getParentFragment() instanceof SearchWebSourceAllFrameFragment) {
            ((SearchWebSourceAllFrameFragment) getParentFragment()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.in0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) {
        if (z) {
            this.Wwwwwwwwwwwwwwww = "未配置网站源";
            this.Wwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwww = false;
            if (getParentFragment() instanceof SearchWebSourceAllFrameFragment) {
                ((SearchWebSourceAllFrameFragment) getParentFragment()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
            }
            this.viewRetry.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
            this.layoutIngRetry.setVisibility(0);
            this.llytAll.setVisibility(8);
            this.tvRetry.setText("请先点击首页底部的");
            this.tvRetry2.setText("[ 影视库 ] 初始化");
            this.tvRetry2.setVisibility(0);
            return;
        }
        if (z2) {
            if (this.Wwwwwwwwww.getItemCount() == 0) {
                this.llytAll.setVisibility(8);
                this.tvRetry.setText("未搜索到，点我重试");
                this.tvRetry2.setVisibility(0);
                this.tvRetry2.setText("");
                this.layoutIngRetry.setVisibility(0);
                this.viewRetry.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("搜索完毕，共（");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.Wwwwwwwwww.getItemCount());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append("）条");
            this.Wwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString();
            this.Wwwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwwww = null;
            this.Wwwwwwwwwwwww = false;
            if (!(getParentFragment() instanceof SearchWebSourceAllFrameFragment)) {
                return;
            }
        } else {
            this.Wwwwwwwwwwwwwwww = "";
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("共（");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Wwwwwwwwww.getItemCount());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("）条，<font color=\"#008000\">点我继续搜</font>");
            this.Wwwwwwwwwwwwwww = Html.fromHtml(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            this.Wwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (!(getParentFragment() instanceof SearchWebSourceAllFrameFragment)) {
                return;
            }
        }
        ((SearchWebSourceAllFrameFragment) getParentFragment()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ((hn0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((hn0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || !this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        Wwwwwwwwwwwwww();
    }

    @Override // me.tvspark.in0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EngineResultParcel engineResultParcel, List<EngineResultParcel> list, int i, int i2) {
        WebSourceListAdapter webSourceListAdapter = this.Wwwwwwwwww;
        if (webSourceListAdapter != null) {
            if (webSourceListAdapter == null) {
                throw null;
            }
            if (engineResultParcel != null && list != null && !list.isEmpty()) {
                if (!list.get(0).isShowWebViewSearch()) {
                    int i3 = webSourceListAdapter.Wwwwwwwwwwwwwwwwwww;
                    if (i3 != -1) {
                        webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.add(i3, engineResultParcel);
                        webSourceListAdapter.Wwwwwwwwwwwwwwwwwww++;
                    } else {
                        webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.add(engineResultParcel);
                    }
                }
                webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwww.put(engineResultParcel.getWebSourceData().getWebSourceBaseUrl(), list);
                webSourceListAdapter.notifyDataSetChanged();
            }
        }
        this.Wwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("网页搜索中 ", i, "/", i2, " .....");
        this.Wwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwww = true;
        if (getParentFragment() instanceof SearchWebSourceAllFrameFragment) {
            ((SearchWebSourceAllFrameFragment) getParentFragment()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.in0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, boolean z) {
        this.layoutIngRetry.setVisibility(8);
        this.llytAll.setVisibility(0);
        if (!z) {
            WebSourceListAdapter webSourceListAdapter = this.Wwwwwwwwww;
            if (webSourceListAdapter != null) {
                webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwww.clear();
                webSourceListAdapter.Wwwwwwwwwwwwwwwwwwww = "";
            }
            SearchListAdapter searchListAdapter = this.Wwwwwwwww;
            if (searchListAdapter != null) {
                searchListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                searchListAdapter.notifyDataSetChanged();
            }
        }
        this.Wwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("网页搜索中 ", i, "/", i2, " .....");
        this.Wwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwww = true;
        if (getParentFragment() instanceof SearchWebSourceAllFrameFragment) {
            ((SearchWebSourceAllFrameFragment) getParentFragment()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwww, this.Wwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwww);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, boolean z) {
        WebSourceListAdapter webSourceListAdapter = this.Wwwwwwwwww;
        if (webSourceListAdapter != null) {
            webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            webSourceListAdapter.Wwwwwwwwwwwwwwwwwwwwww.clear();
            webSourceListAdapter.Wwwwwwwwwwwwwwwwwwww = "";
        }
        SearchListAdapter searchListAdapter = this.Wwwwwwwww;
        if (searchListAdapter != null) {
            searchListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            searchListAdapter.notifyDataSetChanged();
        }
        this.Wwwwwwwwwwwwwwwww = str;
        T t = this.Wwwwwwwwwwwwwwwwwwww;
        if (t == 0 || !z) {
            return;
        }
        ((hn0) t).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, this.Wwwwwwwwwww, true);
    }
}
