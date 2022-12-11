package me.tvspark.common.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import java.util.ArrayList;
import me.tvspark.bl0;
import me.tvspark.widget.listener.BasicOnScrollListener;
import white.whale.R;

/* loaded from: classes4.dex */
public abstract class RecyclerFragment<I, LM extends RecyclerView.LayoutManager, T extends bl0> extends BaseFragment<T> {
    public ArrayList<I> Wwwwwwwwwwwwwww = new ArrayList<>();
    public BasicOnScrollListener Wwwwwwwwwwwwwwww;
    public SwipeRefreshLayout.OnRefreshListener Wwwwwwwwwwwwwwwww;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;

    public LM Wwwwwwwwwwwww() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        try {
            return (LM) recyclerView.getLayoutManager();
        } catch (Exception unused) {
            return null;
        }
    }

    public RecyclerView.Adapter Wwwwwwwwwwwwww() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        return recyclerView.getAdapter();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_recycler;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleBlue), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleGreen), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleRed), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleYellow));
        if (bundle != null) {
            if (Wwwwwwwwwwwww() != null) {
                Wwwwwwwwwwwww().onRestoreInstanceState(bundle.getParcelable("LayoutManagerState"));
            }
            ArrayList arrayList = (ArrayList) bundle.getSerializable("Items");
            if (this.Wwwwwwwwwwwwwww.size() > 0) {
                this.Wwwwwwwwwwwwwww.clear();
            }
            this.Wwwwwwwwwwwwwww.addAll(arrayList);
            Wwwwwwwwwwwwww().notifyDataSetChanged();
            BasicOnScrollListener basicOnScrollListener = this.Wwwwwwwwwwwwwwww;
            if (basicOnScrollListener == null) {
                return;
            }
            Bundle bundle2 = bundle.getBundle("ScrollListenerState");
            if (bundle2 != null && !basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bundle2.getInt("CurrentPage");
            }
            basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("Items", this.Wwwwwwwwwwwwwww);
        if (Wwwwwwwwwwwww() != null) {
            bundle.putParcelable("LayoutManagerState", Wwwwwwwwwwwww().onSaveInstanceState());
        }
        BasicOnScrollListener basicOnScrollListener = this.Wwwwwwwwwwwwwwww;
        if (basicOnScrollListener != null) {
            if (basicOnScrollListener != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("CurrentPage", basicOnScrollListener.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                bundle.putBundle("ScrollListenerState", bundle2);
            } else {
                throw null;
            }
        }
        super.onSaveInstanceState(bundle);
    }
}
