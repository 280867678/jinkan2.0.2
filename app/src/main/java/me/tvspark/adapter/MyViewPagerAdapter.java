package me.tvspark.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import me.tvspark.common.view.BaseFragment;

/* loaded from: classes4.dex */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public MyViewPagerAdapter(FragmentManager fragmentManager, List<String> list, SparseArray<BaseFragment> sparseArray) {
        super(fragmentManager);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sparseArray;
    }

    public MyViewPagerAdapter(FragmentManager fragmentManager, String[] strArr, SparseArray<BaseFragment> sparseArray) {
        super(fragmentManager);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new SparseArray<>();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = strArr;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = sparseArray;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        String[] strArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (strArr == null || strArr.length <= i) {
            List<String> list = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return (list == null || list.size() <= i) ? "" : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
        }
        return strArr[i];
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return (Fragment) super.instantiateItem(viewGroup, i);
    }
}
