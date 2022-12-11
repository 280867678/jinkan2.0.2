package me.tvspark.view.fragment;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.CategoryTypeListAdapter;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.bean.GenreParcel;
import me.tvspark.data.bean.VersionParcel;
import me.tvspark.data.event.ReqWebSourceEvent;
import me.tvspark.data.sql.WebSourceLiveData;
import me.tvspark.jl0;
import me.tvspark.nn0;
import me.tvspark.r40;
import me.tvspark.widget.selectionLayout.SelectionLayout;
import me.tvspark.x11;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class LiveFrameFragment extends BaseFragment {
    public CategoryTypeListAdapter Wwwwwwwwwww;
    public MyViewPagerAdapter Wwwwwwwwwwwwwww;
    @BindView(R.id.llyt_error)
    public LinearLayout llytError;
    @BindView(R.id.pb_all)
    public ProgressBar pbAll;
    @BindView(R.id.rlyt_top_bar)
    public RelativeLayout rlytTopBar;
    @BindView(R.id.rv_type)
    public RecyclerView rvType;
    @BindView(R.id.slOverall)
    public SelectionLayout slOverall;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public List<String> Wwwwwwwwwwwwwwwww = new ArrayList();
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwwww = new SparseArray<>();
    public int Wwwwwwwwwwwwww = 0;
    public List<String> Wwwwwwwwwwwww = new ArrayList();
    public List<Integer> Wwwwwwwwwwww = new ArrayList();

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SelectionLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.widget.selectionLayout.SelectionLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, String str, TextView textView) {
            BaseActivity baseActivity;
            int i3;
            if (LiveFrameFragment.this.Wwwwwwwwwwww.get(i2).intValue() == 6 && !nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveFrameFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, "com.UCMobile")) {
                baseActivity = LiveFrameFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
                i3 = R.string.uc_uninstall;
            } else if (LiveFrameFragment.this.Wwwwwwwwwwww.get(i2).intValue() == 5 && !nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(LiveFrameFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, TbsConfig.APP_QB)) {
                baseActivity = LiveFrameFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
                i3 = R.string.qq_uninstall;
            } else {
                LiveFrameFragment.this.Wwwwwwwwwwwwww = i2;
                LiveFrameFragment liveFrameFragment = LiveFrameFragment.this;
                bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_live_type", liveFrameFragment.Wwwwwwwwwwww.get(liveFrameFragment.Wwwwwwwwwwwwww));
            }
            Toast.makeText(baseActivity, i3, 0).show();
            LiveFrameFragment liveFrameFragment2 = LiveFrameFragment.this;
            textView.setText(liveFrameFragment2.Wwwwwwwwwwwww.get(liveFrameFragment2.Wwwwwwwwwwwwww));
            LiveFrameFragment liveFrameFragment3 = LiveFrameFragment.this;
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_live_type", liveFrameFragment3.Wwwwwwwwwwww.get(liveFrameFragment3.Wwwwwwwwwwwwww));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewPager.OnPageChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            CategoryTypeListAdapter categoryTypeListAdapter = LiveFrameFragment.this.Wwwwwwwwwww;
            categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            categoryTypeListAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.adapter.CategoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(GenreParcel genreParcel) {
            int i;
            try {
                i = Integer.valueOf(genreParcel.getLink()).intValue();
            } catch (Exception unused) {
                i = 0;
            }
            LiveFrameFragment.this.viewpager.setCurrentItem(i);
        }
    }

    public final void Wwwwwwwwwwwwww() {
        List<WebSourceLiveData> list;
        VersionParcel versionParcel;
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        int i = 0;
        if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null || jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().isEmpty()) {
            this.llytError.setVisibility(8);
            this.pbAll.setVisibility(0);
            this.viewpager.setVisibility(8);
            this.rlytTopBar.setVisibility(8);
            jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, false, false);
        } else if (this.Wwwwwwwwwwwwwwww.size() != 0) {
            this.llytError.setVisibility(8);
            this.pbAll.setVisibility(8);
            this.viewpager.setVisibility(0);
            this.rlytTopBar.setVisibility(0);
            while (i < this.Wwwwwwwwwwwwwwww.size()) {
                ((LiveContentFragment) this.Wwwwwwwwwwwwwwww.valueAt(i)).Wwwwwwwwwwwwww();
                i++;
            }
        } else {
            BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwww;
            VersionParcel versionParcel2 = ApplicationC1880C.Wwwwwwwwwwwwwww;
            boolean z = true;
            if (versionParcel2 != null && versionParcel2.getNeedUpdateWebsourceApkVersion() == 302 && !bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("update_apk_geted_newest_live", false)) {
                jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, false, true);
            } else if (jl0.Wwwwwwwwwwwwwwwww || (list = jl0.Wwwwwwwwwwwwwww) == null || list.isEmpty() || (versionParcel = ApplicationC1880C.Wwwwwwwwwwwwwww) == null || versionParcel.getRuleLiveVersion() <= jl0.Wwwwwwwwwwwwwww.get(0).getVersion()) {
                z = false;
            } else {
                jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, true, false);
            }
            this.llytError.setVisibility(8);
            ProgressBar progressBar = this.pbAll;
            if (z) {
                progressBar.setVisibility(0);
                this.viewpager.setVisibility(8);
                this.rlytTopBar.setVisibility(8);
                return;
            }
            progressBar.setVisibility(8);
            this.viewpager.setVisibility(0);
            this.rlytTopBar.setVisibility(0);
            CategoryTypeListAdapter categoryTypeListAdapter = new CategoryTypeListAdapter(getActivity(), new ArrayList());
            categoryTypeListAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwww = categoryTypeListAdapter;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(0);
            this.rvType.setLayoutManager(linearLayoutManager);
            this.rvType.setAdapter(this.Wwwwwwwwwww);
            ArrayList arrayList = new ArrayList();
            while (i < jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().size()) {
                LiveContentFragment liveContentFragment = new LiveContentFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("key_integer", i);
                liveContentFragment.setArguments(bundle);
                this.Wwwwwwwwwwwwwwww.put(i, liveContentFragment);
                this.Wwwwwwwwwwwwwwwww.add(jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().get(i).getWebSourceSiteName());
                arrayList.add(new GenreParcel(this.Wwwwwwwwwwwwwwwww.get(i), i + ""));
                i++;
            }
            CategoryTypeListAdapter categoryTypeListAdapter2 = this.Wwwwwwwwwww;
            categoryTypeListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
            categoryTypeListAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.addAll(arrayList);
            this.Wwwwwwwwwwwwwww = new MyViewPagerAdapter(getChildFragmentManager(), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
            this.viewpager.setOffscreenPageLimit(4);
            this.viewpager.addOnPageChangeListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.viewpager.setAdapter(this.Wwwwwwwwwwwwwww);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_live_frame;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwww.clear();
        this.Wwwwwwwwwwww.add(14);
        this.Wwwwwwwwwwww.add(9);
        this.Wwwwwwwwwwww.add(2);
        this.Wwwwwwwwwwww.add(5);
        this.Wwwwwwwwwwww.add(6);
        this.Wwwwwwwwwwww.add(3);
        this.Wwwwwwwwwwww.add(0);
        this.Wwwwwwwwwwww.add(4);
        this.Wwwwwwwwwwww.add(8);
        this.Wwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwww.add("云播投屏");
        this.Wwwwwwwwwwwww.add("DLNA投屏");
        this.Wwwwwwwwwwwww.add("三方播放");
        this.Wwwwwwwwwwwww.add("QQ  播放");
        this.Wwwwwwwwwwwww.add("UC  播放");
        this.Wwwwwwwwwwwww.add("电脑播放");
        this.Wwwwwwwwwwwww.add("X5   播放");
        this.Wwwwwwwwwwwww.add("KSY 播放");
        this.Wwwwwwwwwwwww.add("网页 嗅探");
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("go_live_type", 4);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 0) {
            this.Wwwwwwwwwwwwww = 6;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 14) {
            this.Wwwwwwwwwwwwww = 0;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
            this.Wwwwwwwwwwwwww = 2;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 3) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 4) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 5) {
                    this.Wwwwwwwwwwwwww = 3;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 6) {
                    this.Wwwwwwwwwwwwww = 4;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 8) {
                    this.Wwwwwwwwwwwwww = 8;
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 9) {
                    this.Wwwwwwwwwwwwww = 1;
                }
            }
            this.Wwwwwwwwwwwwww = 7;
        } else {
            this.Wwwwwwwwwwwwww = 5;
        }
        this.slOverall.removeAllViews();
        if (this.Wwwwwwwwwwwwww >= this.Wwwwwwwwwwwww.size()) {
            this.Wwwwwwwwwwwwww = 0;
        }
        this.slOverall.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(R.layout.layout_selection_gray, false, 15, this.Wwwwwwwwwwwwww, 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(130), -2, this.Wwwwwwwwwwwww);
        this.slOverall.setOnSelectListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onWebSourceDownload(ReqWebSourceEvent reqWebSourceEvent) {
        if (reqWebSourceEvent.getUrlWebSource().equals(ApplicationC1880C.Wwwwwwwwwwwwwwww)) {
            if (reqWebSourceEvent.isSuccess()) {
                Wwwwwwwwwwwwww();
                return;
            }
            this.pbAll.setVisibility(8);
            this.llytError.setVisibility(0);
            this.viewpager.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            Wwwwwwwwwwwwww();
        }
    }
}
