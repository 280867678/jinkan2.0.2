package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.BindView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.sql.SPData;
import me.tvspark.r50;
import me.tvspark.st0;
import me.tvspark.ut0;
import me.tvspark.xt0;
import me.tvspark.yn0;
import org.litepal.crud.callback.FindCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchHistoryFragment extends BaseFragment {
    public xt0 Wwwwwwwwwwwwww;
    public r50<String> Wwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.iv_del)
    public ImageView ivDel;
    @BindView(R.id.tags)
    public TagFlowLayout tags;
    public int Wwwwwwwwwwwwwwwww = 20;
    public List<String> Wwwwwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindCallback<SPData> {
        public final /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchHistoryFragment searchHistoryFragment, Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // org.litepal.crud.callback.FindCallback
        public void onFinish(SPData sPData) {
            SPData sPData2 = sPData;
            List<String> arrayList = (sPData2 == null || TextUtils.isEmpty(sPData2.getSearchHistory())) ? new ArrayList<>() : (List) JSON.parseObject(sPData2.getSearchHistory(), new st0(this), new Feature[0]);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(arrayList);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwww("");
            SearchHistoryFragment.this.Wwwwwwwwwwwwwww.clear();
            SearchHistoryFragment.this.Wwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TagFlowLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TagFlowLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {

        /* renamed from: me.tvspark.view.fragment.SearchHistoryFragment$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends r50<String> {
            public C3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List list) {
                super(list);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.view.fragment.SearchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<String> list) {
            SearchHistoryFragment.this.Wwwwwwwwwwwwwww.addAll(list);
            SearchHistoryFragment searchHistoryFragment = SearchHistoryFragment.this;
            searchHistoryFragment.Wwwwwwwwwwwwwwww = new C3503Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(searchHistoryFragment.Wwwwwwwwwwwwwww);
            SearchHistoryFragment searchHistoryFragment2 = SearchHistoryFragment.this;
            searchHistoryFragment2.tags.setAdapter(searchHistoryFragment2.Wwwwwwwwwwwwwwww);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SearchHistoryFragment searchHistoryFragment, String str) {
        if (searchHistoryFragment != null) {
            searchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new ut0(searchHistoryFragment, str));
            return;
        }
        throw null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_search_history;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, wwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.tags.setOnTagClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.tags.setOnTagLongClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.ivDel.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "5003078686848464";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, SearchHistoryFragment.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwww);
        }
    }
}
