package me.tvspark.view.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.HistoryListAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.sql.VideoHistoryData;
import me.tvspark.yn0;
import org.litepal.crud.callback.FindMultiCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class History1Fragment extends BaseFragment {
    public boolean Wwwwwwwwwwwwwww;
    public HistoryListAdapter Wwwwwwwwwwwwwwww;
    public List<VideoHistoryData> Wwwwwwwwwwwwwwwww = new ArrayList();
    @BindView(R.id.llyt_all_retry)
    public LinearLayout llytAllRetry;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.tv_retry)
    public TextView tvRetry;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<VideoHistoryData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<VideoHistoryData> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            History1Fragment.this.Wwwwwwwwwwwwwwwww.clear();
            History1Fragment.this.Wwwwwwwwwwwwwwwww.addAll(list);
            History1Fragment history1Fragment = History1Fragment.this;
            HistoryListAdapter historyListAdapter = history1Fragment.Wwwwwwwwwwwwwwww;
            List<VideoHistoryData> list2 = history1Fragment.Wwwwwwwwwwwwwwwww;
            if (historyListAdapter != null) {
                if (list2 != null) {
                    historyListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                    historyListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    historyListAdapter.notifyDataSetChanged();
                }
                History1Fragment history1Fragment2 = History1Fragment.this;
                History1Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(history1Fragment2, history1Fragment2.Wwwwwwwwwwwwwwwww.isEmpty());
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements HistoryListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(History1Fragment history1Fragment, boolean z) {
        int i = 8;
        history1Fragment.llytAllRetry.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = history1Fragment.rvContent;
        if (!z) {
            i = 0;
        }
        recyclerView.setVisibility(i);
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_collect;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (!(this.Wwwwwwwwwwwwwwww.getItemCount() == 0) && !z) {
            return;
        }
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwww = getArguments().getBoolean("key_boolean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        this.rvContent.setLayoutManager(linearLayoutManager);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwww = historyListAdapter;
        this.rvContent.setAdapter(historyListAdapter);
        this.tvRetry.setText("空空如也");
        if (this.Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || !this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }
}
