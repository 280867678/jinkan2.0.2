package me.tvspark.view.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.CollectListAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.sql.VideoCollectData;
import me.tvspark.yn0;
import org.litepal.crud.callback.FindMultiCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class CollectedFragment extends BaseFragment {
    public boolean Wwwwwwwwwwwwwww;
    public CollectListAdapter Wwwwwwwwwwwwwwww;
    public List<VideoCollectData> Wwwwwwwwwwwwwwwww = new ArrayList();
    @BindView(R.id.llyt_all_retry)
    public LinearLayout llytAllRetry;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;
    @BindView(R.id.tv_retry)
    public TextView tvRetry;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<VideoCollectData> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<VideoCollectData> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            CollectedFragment.this.Wwwwwwwwwwwwwwwww.clear();
            CollectedFragment.this.Wwwwwwwwwwwwwwwww.addAll(list);
            CollectedFragment collectedFragment = CollectedFragment.this;
            CollectListAdapter collectListAdapter = collectedFragment.Wwwwwwwwwwwwwwww;
            List<VideoCollectData> list2 = collectedFragment.Wwwwwwwwwwwwwwwww;
            if (collectListAdapter != null) {
                if (list2 != null) {
                    collectListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                    collectListAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list2);
                    collectListAdapter.notifyDataSetChanged();
                }
                CollectedFragment collectedFragment2 = CollectedFragment.this;
                CollectedFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(collectedFragment2, collectedFragment2.Wwwwwwwwwwwwwwwww.isEmpty());
                return;
            }
            throw null;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CollectListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(CollectedFragment collectedFragment, boolean z) {
        int i = 8;
        collectedFragment.llytAllRetry.setVisibility(z ? 0 : 8);
        RecyclerView recyclerView = collectedFragment.rvContent;
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
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwwwww = getArguments().getBoolean("key_boolean");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(1);
        this.rvContent.setLayoutManager(linearLayoutManager);
        CollectListAdapter collectListAdapter = new CollectListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwww = collectListAdapter;
        this.rvContent.setAdapter(collectListAdapter);
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
