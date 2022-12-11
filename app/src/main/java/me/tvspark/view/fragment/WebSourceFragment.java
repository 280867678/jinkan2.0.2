package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.androidkun.xtablayout.XTabLayout;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class WebSourceFragment extends BaseFragment {
    public SiteFragment Wwwwwwwwwwwww;
    public MyViewPagerAdapter Wwwwwwwwwwwwwww;
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwwww;
    @BindView(R.id.rlyt_search)
    public RelativeLayout rlytSearch;
    @BindView(R.id.tablayout)
    public XTabLayout tablayout;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public String[] Wwwwwwwwwwwwwwwww = {"推荐", "自定义"};
    public int Wwwwwwwwwwwwww = 0;
    public String Wwwwwwwwwwww = "";

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements ViewPager.OnPageChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            WebSourceFragment.this.Wwwwwwwwwwwwww = i;
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("web_source_pager_index", Integer.valueOf(i));
            if (i != 1 || TextUtils.isEmpty(WebSourceFragment.this.Wwwwwwwwwwww)) {
                return;
            }
            WebSourceFragment webSourceFragment = WebSourceFragment.this;
            SiteFragment siteFragment = webSourceFragment.Wwwwwwwwwwwww;
            if (siteFragment != null) {
                siteFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceFragment.Wwwwwwwwwwww);
            }
            WebSourceFragment.this.Wwwwwwwwwwww = "";
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_websource;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        SparseArray<BaseFragment> sparseArray = new SparseArray<>();
        this.Wwwwwwwwwwwwwwww = sparseArray;
        SiteFragment siteFragment = new SiteFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_boolean", false);
        siteFragment.setArguments(bundle2);
        sparseArray.put(0, siteFragment);
        XTabLayout xTabLayout = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, xTabLayout.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        SiteFragment siteFragment2 = new SiteFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("key_boolean", true);
        siteFragment2.setArguments(bundle3);
        this.Wwwwwwwwwwwww = siteFragment2;
        this.Wwwwwwwwwwwwwwww.put(1, siteFragment2);
        XTabLayout xTabLayout2 = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = xTabLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[1];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, xTabLayout2.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        this.Wwwwwwwwwwwwwww = new MyViewPagerAdapter(getChildFragmentManager(), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
        this.viewpager.setOffscreenPageLimit(4);
        this.viewpager.setAdapter(this.Wwwwwwwwwwwwwww);
        this.tablayout.setupWithViewPager(this.viewpager);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("web_source_pager_index");
        this.Wwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.viewpager.setCurrentItem(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        this.viewpager.addOnPageChangeListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        SparseArray<BaseFragment> sparseArray = this.Wwwwwwwwwwwwwwww;
        if (sparseArray == null || this.Wwwwwwwwwwwwww >= sparseArray.size()) {
            return;
        }
        this.Wwwwwwwwwwwwwwww.get(this.Wwwwwwwwwwwwww).setUserVisibleHint(z);
    }
}
