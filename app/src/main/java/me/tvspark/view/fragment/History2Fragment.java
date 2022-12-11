package me.tvspark.view.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.HistoryListWebAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.sql.WebHistoryData;
import me.tvspark.yn0;
import org.litepal.crud.callback.FindMultiCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class History2Fragment extends BaseFragment {
    public boolean Wwwwwwwwwwwwwww;
    public HistoryListWebAdapter Wwwwwwwwwwwwwwww;
    public List<WebHistoryData> Wwwwwwwwwwwwwwwww = new ArrayList();
    @BindView(R.id.llyt_all_retry)
    public LinearLayout llytAllRetry;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.tv_retry)
    public TextView tvRetry;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebHistoryData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<WebHistoryData> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            History2Fragment.this.Wwwwwwwwwwwwwwwww.clear();
            History2Fragment.this.Wwwwwwwwwwwwwwwww.addAll(list);
            History2Fragment history2Fragment = History2Fragment.this;
            HistoryListWebAdapter historyListWebAdapter = history2Fragment.Wwwwwwwwwwwwwwww;
            List<WebHistoryData> list2 = history2Fragment.Wwwwwwwwwwwwwwwww;
            if (historyListWebAdapter != null) {
                if (list2 != null) {
                    historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                    historyListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    historyListWebAdapter.notifyDataSetChanged();
                }
                History2Fragment history2Fragment2 = History2Fragment.this;
                History2Fragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(history2Fragment2, history2Fragment2.Wwwwwwwwwwwwwwwww.isEmpty());
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements HistoryListWebAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(History2Fragment history2Fragment, boolean z) {
        int i = 8;
        history2Fragment.llytAllRetry.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = history2Fragment.rvContent;
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
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwww = getArguments().getBoolean("key_boolean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        this.rvContent.setLayoutManager(linearLayoutManager);
        HistoryListWebAdapter historyListWebAdapter = new HistoryListWebAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwww = historyListWebAdapter;
        this.rvContent.setAdapter(historyListWebAdapter);
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
