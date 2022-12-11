package me.tvspark.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;

/* loaded from: classes4.dex */
public class MyViewPagerAdapter2 extends FragmentStatePagerAdapter {
    public List<String> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public List<Fragment> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public MyViewPagerAdapter2(FragmentManager fragmentManager, List<String> list, List<Fragment> list2) {
        super(fragmentManager);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i);
    }
}
