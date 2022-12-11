package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import com.p038qq.p039e.ads.cfg.DownAPPConfirmPolicy;
import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import com.p038qq.p039e.comm.util.AdError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.SearchWebSourceAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.RecyclerFragment;
import me.tvspark.data.bean.UseWebViewReqParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.fn0;
import me.tvspark.gn0;
import me.tvspark.km0;
import me.tvspark.ln0;
import me.tvspark.nn0;
import me.tvspark.r40;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.widget.listener.EndlessOnScrollListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceSignalFragment extends RecyclerFragment<VideoParcel, RecyclerView.LayoutManager, fn0> implements NativeExpressAD.NativeExpressADListener, gn0 {
    public static final String Wwww = SearchWebSourceSignalFragment.class.getSimpleName();
    public WebSourceIndexData Wwwwww;
    public String Wwwwwww;
    public List<NativeExpressADView> Wwwwwwwww;
    public NativeExpressAD Wwwwwwwwww;
    public final int Wwwwwwwwwww;
    public final int[] Wwwwwwwwwwww;
    public SearchWebSourceAdapter Wwwwwwwwwwwwww;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout mRefreshLayout;
    public List<VideoParcel> Wwwwwwwwwwwww = new ArrayList();
    public HashMap<NativeExpressADView, Integer> Wwwwwwww = new HashMap<>();
    public String Wwwww = SearchWebSourceSignalFragment.class.getSimpleName() + "_nativeExpress";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SwipeRefreshLayout.OnRefreshListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SearchWebSourceSignalFragment.this = r1;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            SearchWebSourceSignalFragment.this.Wwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SearchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SearchWebSourceSignalFragment.this = r1;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends GridLayoutManager.SpanSizeLookup {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment searchWebSourceSignalFragment) {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return i == 0 ? 3 : 1;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SearchWebSourceSignalFragment.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<VideoParcel> list = SearchWebSourceSignalFragment.this.Wwwwwwwwwwwww;
            if (list != null) {
                list.clear();
            }
            SearchWebSourceSignalFragment.this.mRefreshLayout.setRefreshing(true);
            SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    public SearchWebSourceSignalFragment() {
        int[] iArr = {3, 8, 12, 17, 21, 27, 34, 41};
        this.Wwwwwwwwwwww = iArr;
        this.Wwwwwwwwwww = iArr.length;
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment searchWebSourceSignalFragment, int i, int i2) {
        if (searchWebSourceSignalFragment != null) {
            if (ApplicationC1880C.Wwwwwwwww || ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceSignalFragment.Wwwww) || searchWebSourceSignalFragment.Wwwwwwwwww != null || r40.Wwwwwwwwwwwwwwwwwwwwwwwwww(i) == 0 || r40.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2) == 0) {
                return;
            }
            NativeExpressAD nativeExpressAD = new NativeExpressAD(searchWebSourceSignalFragment.Wwwwwwwwwwwwwwwwwwwwwww, new ADSize(r40.Wwwwwwwwwwwwwwwwwwwwwwwwww(i), r40.Wwwwwwwwwwwwwwwwwwwwwwwwww(i2) + 10), "5013977696639862", searchWebSourceSignalFragment);
            searchWebSourceSignalFragment.Wwwwwwwwww = nativeExpressAD;
            nativeExpressAD.setDownAPPConfirmPolicy(DownAPPConfirmPolicy.Default);
            searchWebSourceSignalFragment.Wwwwwwwwww.loadAD(searchWebSourceSignalFragment.Wwwwwwwwwww);
            return;
        }
        throw null;
    }

    public final void Wwwwwwwwwwww() {
        SwipeRefreshLayout swipeRefreshLayout = this.mRefreshLayout;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.post(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return new km0();
    }

    @Override // me.tvspark.common.view.RecyclerFragment, me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_search_websource;
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
        if (this.Wwwwwwwwwwwwww != null) {
            int intValue = this.Wwwwwwww.get(nativeExpressADView).intValue();
            SearchWebSourceAdapter searchWebSourceAdapter = this.Wwwwwwwwwwwwww;
            searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwww.remove(intValue);
            searchWebSourceAdapter.notifyItemRemoved(intValue);
            searchWebSourceAdapter.notifyItemRangeChanged(0, searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwww.size() - 1);
        }
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        int i;
        list.size();
        this.Wwwwwwwww = list;
        for (int i2 = 0; i2 < this.Wwwwwwwww.size(); i2++) {
            int[] iArr = this.Wwwwwwwwwwww;
            if (i2 < iArr.length && (i = iArr[i2]) < this.Wwwwwwwwwwwwwww.size() && !((VideoParcel) this.Wwwwwwwwwwwwwww.get(i)).isADPos()) {
                this.Wwwwwwwww.get(i2).sendWinNotification(this.Wwwwwwwww.get(i2).getECPM());
                this.Wwwwwwwww.get(i2).getECPM();
                this.Wwwwwwww.put(this.Wwwwwwwww.get(i2), Integer.valueOf(i));
                VideoParcel videoParcel = new VideoParcel();
                videoParcel.setADPos(true);
                videoParcel.setNativeExpressADView(this.Wwwwwwwww.get(i2));
                this.Wwwwwwwwwwwwwww.add(i, videoParcel);
            }
        }
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.Wwwwww = (WebSourceIndexData) getArguments().getParcelable("key_parcel");
            this.Wwwwwww = arguments.getString("key_string");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        List<NativeExpressADView> list = this.Wwwwwwwww;
        if (list != null) {
            for (NativeExpressADView nativeExpressADView : list) {
                nativeExpressADView.destroy();
            }
        }
    }

    @Override // com.p038qq.p039e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        ln0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(adError.getErrorCode(), adError.getErrorMsg(), this.Wwwww);
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
    }

    @Override // com.p038qq.p039e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        nativeExpressADView.toString();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || !this.Wwwwwwwwwwwwwwwwwwwwww || this.Wwwwwwwwwwwwww.getItemCount() != 0) {
            return;
        }
        Wwwwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        if (this.Wwwwww == null) {
            return;
        }
        this.mRecyclerView.setItemAnimator(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 3);
        gridLayoutManager.setSpanSizeLookup(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        super.mRecyclerView.setLayoutManager(gridLayoutManager);
        SearchWebSourceAdapter searchWebSourceAdapter = new SearchWebSourceAdapter(this.Wwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwww, this.Wwwwwww);
        searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwww = searchWebSourceAdapter;
        super.mRecyclerView.setAdapter(searchWebSourceAdapter);
        this.mRecyclerView.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        SwipeRefreshLayout swipeRefreshLayout = super.mRefreshLayout;
        this.Wwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        swipeRefreshLayout.setOnRefreshListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        RecyclerView recyclerView = super.mRecyclerView;
        this.Wwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        recyclerView.addOnScrollListener(wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwww();
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends EndlessOnScrollListener<VideoParcel> {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            SearchWebSourceSignalFragment.this = r1;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public SwipeRefreshLayout Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return SearchWebSourceSignalFragment.this.mRefreshLayout;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.LayoutManager Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return SearchWebSourceSignalFragment.this.Wwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public List<VideoParcel> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public UseWebViewReqParcel Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            return null;
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public RecyclerView.Adapter Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwww();
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public Call<ResponseBody> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            SearchWebSourceSignalFragment searchWebSourceSignalFragment = SearchWebSourceSignalFragment.this;
            return ((fn0) SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchWebSourceSignalFragment.Wwwwww, searchWebSourceSignalFragment.Wwwwwww, i);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, int i) {
            ((fn0) SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment.this.Wwwwww, "", i);
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ResponseBody responseBody, int i) {
            String str;
            if (responseBody != null) {
                try {
                    str = !TextUtils.isEmpty(SearchWebSourceSignalFragment.this.Wwwwww.getHtmlCharset()) ? new String(responseBody.bytes(), SearchWebSourceSignalFragment.this.Wwwwww.getHtmlCharset()) : responseBody.string();
                } catch (IOException e) {
                    e.printStackTrace();
                    ((fn0) SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment.this.Wwwwww, "", i);
                    return;
                }
            } else {
                str = "";
            }
            if (((fn0) SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment.this.Wwwwww, str, i)) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                long currentTimeMillis = System.currentTimeMillis();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = currentTimeMillis;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(currentTimeMillis);
            }
        }

        @Override // me.tvspark.widget.listener.BasicOnScrollListener
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, int i) {
            ((fn0) SearchWebSourceSignalFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchWebSourceSignalFragment.this.Wwwwww, str, i);
        }
    }

    @Override // me.tvspark.gn0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, List<VideoParcel> list, String str, int i) {
        List<NativeExpressADView> list2;
        this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if ((i != 0 || this.Wwwwwwwwwwwwwww.isEmpty() || !list.isEmpty()) && list != null && !list.isEmpty() && !nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, list)) {
            this.Wwwwwwwwwwwww.clear();
            this.Wwwwwwwwwwwww.addAll(list);
            if (i == 0) {
                this.Wwwwwwwwwwwwwww.clear();
            }
            this.Wwwwwwwwwwwwwww.addAll(list);
            ArrayList<I> arrayList = this.Wwwwwwwwwwwwwww;
            if (arrayList != 0 && !arrayList.isEmpty() && (list2 = this.Wwwwwwwww) != null && !list2.isEmpty()) {
                onADLoaded(this.Wwwwwwwww);
            }
            SearchWebSourceAdapter searchWebSourceAdapter = this.Wwwwwwwwwwwwww;
            List list3 = this.Wwwwwwwwwwwwwww;
            if (searchWebSourceAdapter == null) {
                throw null;
            }
            if (list3 == null || list3.isEmpty()) {
                return;
            }
            searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwww.addAll(list3);
            searchWebSourceAdapter.notifyDataSetChanged();
        }
    }
}
