package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.p038qq.p039e.ads.cfg.VideoOption;
import com.p038qq.p039e.ads.nativ.ADSize;
import com.p038qq.p039e.ads.nativ.NativeExpressAD;
import com.p038qq.p039e.ads.nativ.NativeExpressADView;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.IndexRankListAdapter;
import me.tvspark.adapter.IndexRecListAdapter;
import me.tvspark.adapter.IndexRecTypeListAdapter;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.bean.IndexRankListParcel;
import me.tvspark.data.bean.IndexRecParcel;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.data.bean.VideoParcel;
import me.tvspark.data.event.ReqWebSourceEvent;
import me.tvspark.eo0;
import me.tvspark.hm0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.qn0;
import me.tvspark.qt0;
import me.tvspark.r40;
import me.tvspark.widget.decoration.SpacesItemDecorationIndexRec;
import me.tvspark.widget.dialog.DialogDesc;
import me.tvspark.x11;
import me.tvspark.xm0;
import me.tvspark.zm0;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class RecIndexFragment extends BaseFragment<xm0> implements zm0 {
    public NativeExpressADView Wwwwwwwwwwwwwwww;
    public NativeExpressAD Wwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_native)
    public FrameLayout flytNative;
    @BindView(R.id.llyt_2)
    public LinearLayout llyt2;
    @BindView(R.id.llyt_empty)
    public LinearLayout llytEmpty;
    @BindView(R.id.llyt_marquee)
    public LinearLayout llytMarque;
    @BindView(R.id.llyt_rec)
    public LinearLayout llytRec;
    @BindView(R.id.refresh_layout)
    public SwipeRefreshLayout refreshLayout;
    @BindView(R.id.rlyt_anim)
    public RelativeLayout rlytAnim;
    @BindView(R.id.rlyt_art)
    public RelativeLayout rlytArt;
    @BindView(R.id.rlyt_movie)
    public RelativeLayout rlytMovie;
    @BindView(R.id.rlyt_rank)
    public RelativeLayout rlytRank;
    @BindView(R.id.rlyt_tv)
    public RelativeLayout rlytTv;
    @BindView(R.id.rv_content_anim)
    public RecyclerView rvContentAnim;
    @BindView(R.id.rv_content_art)
    public RecyclerView rvContentArt;
    @BindView(R.id.rv_content_movie)
    public RecyclerView rvContentMovie;
    @BindView(R.id.rv_content_rank)
    public RecyclerView rvContentRank;
    @BindView(R.id.rv_content_tv)
    public RecyclerView rvContentTv;
    @BindView(R.id.rv_type_anim)
    public RecyclerView rvTypeAnim;
    @BindView(R.id.rv_type_art)
    public RecyclerView rvTypeArt;
    @BindView(R.id.rv_type_movie)
    public RecyclerView rvTypeMovie;
    @BindView(R.id.rv_type_tv)
    public RecyclerView rvTypeTv;
    @BindView(R.id.tv_marquee)
    public TextView tvMarquee;
    @BindView(R.id.tv_title_anim)
    public TextView tvTitleAnim;
    @BindView(R.id.tv_title_art)
    public TextView tvTitleArt;
    @BindView(R.id.tv_title_movie)
    public TextView tvTitleMovie;
    @BindView(R.id.tv_title_tv)
    public TextView tvTitleTv;
    public boolean Wwwwwwwwwwwwwww = false;
    public boolean Wwwwwwwwwwwwww = false;
    public IndexRecListAdapter Wwwwwwwwwwwww = null;
    public IndexRecListAdapter Wwwwwwwwwwww = null;
    public IndexRecListAdapter Wwwwwwwwwww = null;
    public IndexRecListAdapter Wwwwwwwwww = null;
    public IndexRecTypeListAdapter Wwwwwwwww = null;
    public IndexRecTypeListAdapter Wwwwwwww = null;
    public IndexRecTypeListAdapter Wwwwwww = null;
    public IndexRecTypeListAdapter Wwwwww = null;
    public IndexRankListAdapter Wwwww = null;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwww implements IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            new DialogDesc(RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, videoParcel.getTitle(), videoParcel.getCoverUrl(), videoParcel.getLink()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            IndexRecListAdapter indexRecListAdapter = RecIndexFragment.this.Wwwwwwwwwwww;
            if (indexRecListAdapter != null) {
                indexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                RecIndexFragment.this.rvContentMovie.scrollToPosition(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            new DialogDesc(RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, videoParcel.getTitle(), videoParcel.getCoverUrl(), videoParcel.getLink()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            IndexRecListAdapter indexRecListAdapter = RecIndexFragment.this.Wwwwwwwwwwwww;
            if (indexRecListAdapter != null) {
                indexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                RecIndexFragment.this.rvContentTv.scrollToPosition(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            new DialogDesc(RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, videoParcel.getTitle(), videoParcel.getCoverUrl(), videoParcel.getLink()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((xm0) RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((xm0) RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, false, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.qn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
            ((xm0) RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true, true, str);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            IndexRecListAdapter indexRecListAdapter = RecIndexFragment.this.Wwwwwwwwww;
            if (indexRecListAdapter != null) {
                indexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                RecIndexFragment.this.rvContentAnim.scrollToPosition(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(VideoParcel videoParcel) {
            new DialogDesc(RecIndexFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, videoParcel.getTitle(), videoParcel.getCoverUrl(), videoParcel.getLink()).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.IndexRecTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            IndexRecListAdapter indexRecListAdapter = RecIndexFragment.this.Wwwwwwwwwww;
            if (indexRecListAdapter != null) {
                indexRecListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
                RecIndexFragment.this.rvContentArt.scrollToPosition(0);
            }
        }
    }

    public void Wwwwwwwwwwwwww() {
        try {
            if (this.flytNative == null || this.flytNative.getChildCount() <= 0) {
                return;
            }
            this.flytNative.removeAllViews();
            this.flytNative.setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public xm0 Wwwwwwwwwwwwwwwww() {
        return new hm0();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_index_rec;
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwww() {
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "请求失败");
        }
        if (!this.Wwwwwwwwwwwwww) {
            this.llytRec.setVisibility(8);
        }
        if (this.Wwwwwwwwwwwwwww || this.Wwwwwwwwwwwwww) {
            return;
        }
        this.refreshLayout.setRefreshing(false);
        this.llytEmpty.setVisibility(0);
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "请求失败");
        }
        if (!this.Wwwwwwwwwwwwwww) {
            this.rlytRank.setVisibility(8);
        }
        if (this.Wwwwwwwwwwwwwww || this.Wwwwwwwwwwwwww) {
            return;
        }
        this.refreshLayout.setRefreshing(false);
        this.llytEmpty.setVisibility(0);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<IndexRankListParcel> list) {
        if (list.isEmpty()) {
            this.rlytRank.setVisibility(8);
            return;
        }
        this.rlytRank.setVisibility(0);
        if (this.Wwwww == null) {
            IndexRankListAdapter indexRankListAdapter = new IndexRankListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwww = indexRankListAdapter;
            this.rvContentRank.setAdapter(indexRankListAdapter);
        }
        IndexRankListAdapter indexRankListAdapter2 = this.Wwwww;
        if (indexRankListAdapter2 == null) {
            throw null;
        }
        if (!list.isEmpty()) {
            indexRankListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            indexRankListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(list);
        }
        indexRankListAdapter2.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        VersionParcel versionParcel;
        String[] split;
        if (this.Wwwwwwwwwwwwwwwwwwwwww && z) {
            this.llytEmpty.setVisibility(8);
            boolean z2 = true;
            this.refreshLayout.setRefreshing(true);
            if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
            BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
            if (!jl0.Wwwwwwwwwwwwwwwwwwww && jl0.Wwwwwwwwwwwwwwww != null && (versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) != null) {
                try {
                    split = versionParcel.getRuleIndexRecVersion().split("\\$");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (split.length == 2 && Integer.valueOf(split[0]).intValue() > jl0.Wwwwwwwwwwwwwwww.getVersion() && Integer.valueOf(split[1]).intValue() <= 302) {
                    jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity);
                    if (!z2) {
                        return;
                    }
                    if (!this.Wwwwwwwwwwwwww) {
                        ((xm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    }
                    if (this.Wwwwwwwwwwwwwww) {
                        return;
                    }
                    ((xm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                    return;
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<IndexRankListParcel> list) {
        if (!list.isEmpty()) {
            this.Wwwwwwwwwwwwwww = true;
            this.rlytRank.setVisibility(0);
            this.llytEmpty.setVisibility(8);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
        }
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, IndexRecParcel indexRecParcel, String str) {
        this.refreshLayout.setRefreshing(false);
        this.llytEmpty.setVisibility(8);
        if (!z || (indexRecParcel.getTvTypeContentList().isEmpty() && indexRecParcel.getMovieTypeContentList().isEmpty() && indexRecParcel.getAnimTypeContentList().isEmpty() && indexRecParcel.getArtTypeContentList().isEmpty())) {
            this.Wwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwww = false;
        } else {
            this.Wwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwww = true;
            this.llytRec.setVisibility(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel);
            if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "请求更新完毕 Rec");
            }
            if (!TextUtils.isEmpty(str)) {
                qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
                qn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwwwww, str);
                qn0Var.execute(new Void[0]);
            }
        }
        if (!ApplicationC1880C.Wwww && (getParentFragment() instanceof IndexFragment)) {
            ((IndexFragment) getParentFragment()).Wwwwwwwwwwwwww();
        }
        if (!this.Wwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        boolean z = false;
        this.refreshLayout.setColorSchemeColors(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleBlue), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleGreen), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleRed), ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.googleYellow));
        this.refreshLayout.setEnabled(false);
        this.refreshLayout.setProgressViewOffset(true, 0, (int) TypedValue.applyDimension(1, 90.0f, getResources().getDisplayMetrics()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager.setOrientation(0);
        this.rvContentRank.setLayoutManager(linearLayoutManager);
        this.rvContentRank.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(11)));
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager2.setOrientation(0);
        this.rvTypeTv.setLayoutManager(linearLayoutManager2);
        this.rvTypeTv.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager3.setOrientation(0);
        this.rvContentTv.setLayoutManager(linearLayoutManager3);
        this.rvContentTv.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10)));
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager4.setOrientation(0);
        this.rvTypeMovie.setLayoutManager(linearLayoutManager4);
        this.rvTypeMovie.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager5.setOrientation(0);
        this.rvContentMovie.setLayoutManager(linearLayoutManager5);
        this.rvContentMovie.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10)));
        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager6.setOrientation(0);
        this.rvTypeArt.setLayoutManager(linearLayoutManager6);
        this.rvTypeArt.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager7.setOrientation(0);
        this.rvContentArt.setLayoutManager(linearLayoutManager7);
        this.rvContentArt.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10)));
        LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager8.setOrientation(0);
        this.rvTypeAnim.setLayoutManager(linearLayoutManager8);
        this.rvTypeAnim.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8)));
        LinearLayoutManager linearLayoutManager9 = new LinearLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww);
        linearLayoutManager9.setOrientation(0);
        this.rvContentAnim.setLayoutManager(linearLayoutManager9);
        this.rvContentAnim.addItemDecoration(new SpacesItemDecorationIndexRec(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10)));
        VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
        if (versionParcel == null || TextUtils.isEmpty(versionParcel.getMarqueeTxt())) {
            this.llytMarque.setVisibility(8);
        } else {
            this.llytMarque.setVisibility(0);
            this.tvMarquee.setText(ApplicationC1880C.Wwwwwwwwwwwwwww.getMarqueeTxt());
        }
        qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
        String str = qn0.Wwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        qn0Var.Wwwwwwwwwwwwwwwwwwwwwww = str;
        qn0Var.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        qn0Var.execute(new Void[0]);
        qn0 qn0Var2 = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
        String str2 = qn0.Wwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        qn0Var2.Wwwwwwwwwwwwwwwwwwwwwww = str2;
        qn0Var2.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        qn0Var2.execute(new Void[0]);
        qn0 qn0Var3 = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
        String str3 = qn0.Wwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        qn0Var3.Wwwwwwwwwwwwwwwwwwwwwww = str3;
        qn0Var3.Wwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        qn0Var3.execute(new Void[0]);
        if (getUserVisibleHint() && !this.Wwwwwwwwwwwwwwwwwww) {
            z = true;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<IndexRankListParcel> list, String str, String str2) {
        this.refreshLayout.setRefreshing(false);
        this.llytEmpty.setVisibility(8);
        if (!list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwww = true;
            this.rlytRank.setVisibility(0);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list);
            if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "请求更新完毕 Rank");
            }
            if (!TextUtils.isEmpty(str)) {
                qn0 qn0Var = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
                qn0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwwww, str);
                qn0Var.execute(new Void[0]);
            }
            if (!TextUtils.isEmpty(str2)) {
                qn0 qn0Var2 = new qn0(this.Wwwwwwwwwwwwwwwwwwwwwww);
                qn0Var2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(qn0.Wwwwwwwwwwww, str2);
                qn0Var2.execute(new Void[0]);
            }
        } else {
            this.Wwwwwwwwwwwwwwwwwww = false;
            this.Wwwwwwwwwwwwwww = false;
        }
        if (!this.Wwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.zm0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, IndexRecParcel indexRecParcel, String str) {
        if (!indexRecParcel.getTvTypeContentList().isEmpty() || !indexRecParcel.getMovieTypeContentList().isEmpty() || !indexRecParcel.getAnimTypeContentList().isEmpty() || !indexRecParcel.getArtTypeContentList().isEmpty()) {
            this.Wwwwwwwwwwwwww = true;
            this.llytRec.setVisibility(0);
            this.llytEmpty.setVisibility(8);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel);
        }
        if (!this.Wwwwwwwwwwwwww || ApplicationC1880C.Wwww || !(getParentFragment() instanceof IndexFragment)) {
            return;
        }
        ((IndexFragment) getParentFragment()).Wwwwwwwwwwwwww();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        NativeExpressADView nativeExpressADView = this.Wwwwwwwwwwwwwwww;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    @OnClick({R.id.llyt_marquee, R.id.tv_retry, R.id.llyt_search, R.id.llyt_2, R.id.llyt_3, R.id.llyt_4, R.id.llyt_5, R.id.tv_more_tv, R.id.tv_more_movie, R.id.tv_more_art, R.id.tv_more_anim})
    public void onViewClicked(View view) {
        BaseActivity baseActivity;
        String marqueeUrl;
        BaseActivity baseActivity2;
        String animTitle;
        String animTypeJsonMore;
        String animUrlJsonMore;
        boolean z = true;
        switch (view.getId()) {
            case R.id.llyt_2 /* 2131362223 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_3 /* 2131362224 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                return;
            case R.id.llyt_4 /* 2131362226 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view.getContext());
                return;
            case R.id.llyt_5 /* 2131362227 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(view.getContext());
                return;
            case R.id.llyt_marquee /* 2131362267 */:
                VersionParcel versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww;
                if (versionParcel == null || TextUtils.isEmpty(versionParcel.getMarqueeUrl())) {
                    return;
                }
                if (ApplicationC1880C.Wwwwwwwwwwwwwww.getMarqueeUrl().contains("support.qq.com")) {
                    baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    marqueeUrl = ApplicationC1880C.Wwwwwwwwwwwwwww.getMarqueeUrl();
                } else {
                    baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
                    marqueeUrl = ApplicationC1880C.Wwwwwwwwwwwwwww.getMarqueeUrl();
                    z = false;
                }
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, marqueeUrl, z);
                return;
            case R.id.llyt_search /* 2131362287 */:
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "");
                return;
            case R.id.tv_more_anim /* 2131362700 */:
                baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                animTitle = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getAnimTitle();
                animTypeJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getAnimTypeJsonMore();
                animUrlJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getAnimUrlJsonMore();
                break;
            case R.id.tv_more_art /* 2131362701 */:
                baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                animTitle = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getArtTitle();
                animTypeJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getArtTypeJsonMore();
                animUrlJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getArtUrlJsonMore();
                break;
            case R.id.tv_more_movie /* 2131362702 */:
                baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                animTitle = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getMovieTitle();
                animTypeJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getMovieTypeJsonMore();
                animUrlJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getMovieUrlJsonMore();
                break;
            case R.id.tv_more_tv /* 2131362703 */:
                baseActivity2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                animTitle = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getTvTitle();
                animTypeJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getTvTypeJsonMore();
                animUrlJsonMore = jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().getTvUrlJsonMore();
                break;
            case R.id.tv_retry /* 2131362731 */:
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                return;
            default:
                return;
        }
        mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, animTitle, animTypeJsonMore, animUrlJsonMore);
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onWebSourceDownload(ReqWebSourceEvent reqWebSourceEvent) {
        if (reqWebSourceEvent.getUrlWebSource().equals(ApplicationC1880C.Wwwwwwwwwwwwwwwwwww)) {
            if (reqWebSourceEvent.isSuccess()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwww();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z && !this.Wwwwwwwwwwwwwwwwwww);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexRecParcel indexRecParcel) {
        if (!indexRecParcel.getTvTypeContentList().isEmpty()) {
            this.rlytTv.setVisibility(0);
            this.tvTitleTv.setText(indexRecParcel.getTitleTv());
            if (this.Wwwwwwwwwwwww == null) {
                IndexRecListAdapter indexRecListAdapter = new IndexRecListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwwwwww = indexRecListAdapter;
                this.rvContentTv.setAdapter(indexRecListAdapter);
            }
            this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getTvTypeContentList(), indexRecParcel.getTvTypeContentList().get(0).getVideoList());
            if (this.Wwwwwwwww == null) {
                IndexRecTypeListAdapter indexRecTypeListAdapter = new IndexRecTypeListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwww = indexRecTypeListAdapter;
                this.rvTypeTv.setAdapter(indexRecTypeListAdapter);
            }
            if (!indexRecParcel.getTvTypeList().isEmpty()) {
                this.rvTypeTv.setVisibility(0);
                this.Wwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getTvTypeList());
            } else {
                this.rvTypeTv.setVisibility(8);
            }
        } else {
            this.rlytTv.setVisibility(8);
        }
        if (!indexRecParcel.getMovieTypeContentList().isEmpty()) {
            this.rlytMovie.setVisibility(0);
            this.tvTitleMovie.setText(indexRecParcel.getTitleMovie());
            if (this.Wwwwwwwwwwww == null) {
                IndexRecListAdapter indexRecListAdapter2 = new IndexRecListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwwwww = indexRecListAdapter2;
                this.rvContentMovie.setAdapter(indexRecListAdapter2);
            }
            this.Wwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getMovieTypeContentList(), indexRecParcel.getMovieTypeContentList().get(0).getVideoList());
            if (this.Wwwwwwww == null) {
                IndexRecTypeListAdapter indexRecTypeListAdapter2 = new IndexRecTypeListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwww = indexRecTypeListAdapter2;
                this.rvTypeMovie.setAdapter(indexRecTypeListAdapter2);
            }
            if (!indexRecParcel.getMovieTypeList().isEmpty()) {
                this.rvTypeMovie.setVisibility(0);
                this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getMovieTypeList());
            } else {
                this.rvTypeMovie.setVisibility(8);
            }
        } else {
            this.rlytMovie.setVisibility(8);
        }
        if (!indexRecParcel.getArtTypeContentList().isEmpty()) {
            this.rlytArt.setVisibility(0);
            this.tvTitleArt.setText(indexRecParcel.getTitleArt());
            if (this.Wwwwwwwwwww == null) {
                IndexRecListAdapter indexRecListAdapter3 = new IndexRecListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwwww = indexRecListAdapter3;
                this.rvContentArt.setAdapter(indexRecListAdapter3);
            }
            this.Wwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getArtTypeContentList(), indexRecParcel.getArtTypeContentList().get(0).getVideoList());
            if (this.Wwwwwww == null) {
                IndexRecTypeListAdapter indexRecTypeListAdapter3 = new IndexRecTypeListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwww = indexRecTypeListAdapter3;
                this.rvTypeArt.setAdapter(indexRecTypeListAdapter3);
            }
            if (!indexRecParcel.getArtTypeList().isEmpty()) {
                this.rvTypeArt.setVisibility(0);
                this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getArtTypeList());
            } else {
                this.rvTypeArt.setVisibility(8);
            }
        } else {
            this.rlytArt.setVisibility(8);
        }
        if (!indexRecParcel.getAnimTypeContentList().isEmpty()) {
            this.rlytAnim.setVisibility(0);
            this.tvTitleAnim.setText(indexRecParcel.getTitleAnim());
            if (this.Wwwwwwwwww == null) {
                IndexRecListAdapter indexRecListAdapter4 = new IndexRecListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwwwwwww = indexRecListAdapter4;
                this.rvContentAnim.setAdapter(indexRecListAdapter4);
            }
            this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getAnimTypeContentList(), indexRecParcel.getAnimTypeContentList().get(0).getVideoList());
            if (this.Wwwwww == null) {
                IndexRecTypeListAdapter indexRecTypeListAdapter4 = new IndexRecTypeListAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                this.Wwwwww = indexRecTypeListAdapter4;
                this.rvTypeAnim.setAdapter(indexRecTypeListAdapter4);
            }
            if (!indexRecParcel.getAnimTypeList().isEmpty()) {
                this.rvTypeAnim.setVisibility(0);
                this.Wwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(indexRecParcel.getAnimTypeList());
            } else {
                this.rvTypeAnim.setVisibility(8);
            }
        } else {
            this.rlytAnim.setVisibility(8);
        }
        if (this.Wwwwwwwwwwwwwwwww == null) {
            NativeExpressAD nativeExpressAD = new NativeExpressAD(this.Wwwwwwwwwwwwwwwwwwwwwww, new ADSize(-1, -2), "7063674646353742", new qt0(this));
            this.Wwwwwwwwwwwwwwwww = nativeExpressAD;
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(true).build());
        }
        this.Wwwwwwwwwwwwwwwww.loadAD(1);
    }
}
