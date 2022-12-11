package me.tvspark.view.fragment;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.androidkun.xtablayout.XTabLayout;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebFragment extends BaseFragment {
    public MyViewPagerAdapter Wwwwwwwwwwwwww;
    @BindView(R.id.tablayout)
    public XTabLayout tablayout;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public List<String> Wwwwwwwwwwwwwwwww = new ArrayList();
    public List<String> Wwwwwwwwwwwwwwww = new ArrayList();
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwww = new SparseArray<>();
    public String Wwwwwwwwwwwww = "";

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_search_web;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwwwwwww = getArguments().getString("key_string");
        this.tablayout.setTabMode(1);
        this.Wwwwwwwwwwwwwwwww.add("必应");
        this.Wwwwwwwwwwwwwwwww.add("百度");
        this.Wwwwwwwwwwwwwwwww.add("搜狗");
        this.Wwwwwwwwwwwwwwwww.add("头条");
        this.Wwwwwwwwwwwwwwwww.add("神马");
        this.Wwwwwwwwwwwwwwww.add("https://cn.bing.com/search?q={search}+在线播放");
        this.Wwwwwwwwwwwwwwww.add("https://m.baidu.com/s?word={search} 在线播放");
        this.Wwwwwwwwwwwwwwww.add("https://wap.sogou.com/web/searchList.jsp?keyword={search} 在线播放");
        this.Wwwwwwwwwwwwwwww.add("http://so.toutiao.com/search?keyword={search} 在线播放");
        this.Wwwwwwwwwwwwwwww.add("https://m.sm.cn/s?from=cs&q={search} 在线播放");
        for (int i = 0; i < this.Wwwwwwwwwwwwwwwww.size(); i++) {
            SparseArray<BaseFragment> sparseArray = this.Wwwwwwwwwwwwwww;
            String str = this.Wwwwwwwwwwwww;
            WebSoFragment webSoFragment = new WebSoFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("key_string", this.Wwwwwwwwwwwwwwww.get(i));
            bundle2.putString("key_string_one", str);
            webSoFragment.setArguments(bundle2);
            sparseArray.put(i, webSoFragment);
            XTabLayout xTabLayout = this.tablayout;
            XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww.get(i);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, xTabLayout.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        }
        this.Wwwwwwwwwwwwww = new MyViewPagerAdapter(getChildFragmentManager(), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
        this.viewpager.setOffscreenPageLimit(5);
        this.viewpager.setAdapter(this.Wwwwwwwwwwwwww);
        this.tablayout.setupWithViewPager(this.viewpager);
        this.viewpager.setCurrentItem(0);
    }
}
