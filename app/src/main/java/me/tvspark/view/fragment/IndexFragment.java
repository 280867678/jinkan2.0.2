package me.tvspark.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.androidkun.xtablayout.XTabLayout;
import com.p038qq.p039e.ads.rewardvideo.RewardVideoAD;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.cu0;
import me.tvspark.mt0;
import me.tvspark.nn0;
import white.whale.R;

/* loaded from: classes4.dex */
public class IndexFragment extends BaseFragment {
    public static final String Wwwwwwwwww = IndexFragment.class.getSimpleName();
    public boolean Wwwwwwwwwwww;
    public RecIndexFragment Wwwwwwwwwwwww;
    public RewardVideoAD Wwwwwwwwwwwwww;
    public MyViewPagerAdapter Wwwwwwwwwwwwwww;
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwwww;
    @BindView(R.id.tablayout)
    public XTabLayout tablayout;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public String[] Wwwwwwwwwwwwwwwww = {"发现", "首页", "高清", "直播"};
    public boolean Wwwwwwwwwww = false;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog) {
            dialog.dismiss();
        }

        @Override // me.tvspark.cu0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Dialog dialog, String str) {
            dialog.dismiss();
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            IndexFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexFragment.this);
        }
    }

    public static /* synthetic */ void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexFragment indexFragment) {
        RewardVideoAD rewardVideoAD;
        if (!indexFragment.Wwwwwwwwwwww || (rewardVideoAD = indexFragment.Wwwwwwwwwwwwww) == null) {
            indexFragment.Wwwwwwwwwww = true;
        } else if (rewardVideoAD.isValid()) {
            indexFragment.Wwwwwwwwwwwwww.showAD();
        } else {
            indexFragment.Wwwwwwwwwww = true;
            indexFragment.Wwwwwwwwwwww = false;
            indexFragment.Wwwwwwwwwwwwww.loadAD();
        }
    }

    public void Wwwwwwwwwwwwww() {
        ApplicationC1880C.Wwww = true;
        cu0 cu0Var = new cu0(this.Wwwwwwwwwwwwwwwwwwwwwww, "提示", "观看一段视频可去除应用内所有广告并支持开发者，点击确定开始观看");
        cu0Var.Wwwwwwwwwwwwww = 3;
        cu0Var.Wwwwwwwwwwwww = "取 消";
        cu0Var.Wwwwwwwwwwww = "确 定";
        cu0Var.Wwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        cu0Var.Wwwwww = -1;
        cu0Var.Wwwww = 16;
        cu0Var.Wwwwwww = 17;
        cu0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_index;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        ApplicationC1880C.Wwwwwwwww = false;
        RewardVideoAD rewardVideoAD = new RewardVideoAD(this.Wwwwwwwwwwwwwwwwwwwwwww, "6053479616348758", new mt0(this), false);
        this.Wwwwwwwwwwwwww = rewardVideoAD;
        this.Wwwwwwwwwwww = false;
        ApplicationC1880C.Wwwwwwwww = false;
        rewardVideoAD.loadAD();
        SparseArray<BaseFragment> sparseArray = new SparseArray<>();
        this.Wwwwwwwwwwwwwwww = sparseArray;
        sparseArray.put(0, new ModernFragment());
        XTabLayout xTabLayout = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[0];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, xTabLayout.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        RecIndexFragment recIndexFragment = new RecIndexFragment();
        this.Wwwwwwwwwwwww = recIndexFragment;
        this.Wwwwwwwwwwwwwwww.put(1, recIndexFragment);
        XTabLayout xTabLayout2 = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = xTabLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[1];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, xTabLayout2.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        this.Wwwwwwwwwwwwwwww.put(2, new CNTVFragment());
        XTabLayout xTabLayout3 = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = xTabLayout3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[2];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3, xTabLayout3.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        this.Wwwwwwwwwwwwwwww.put(3, new LiveFrameFragment());
        XTabLayout xTabLayout4 = this.tablayout;
        XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = xTabLayout4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwww[3];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        xTabLayout4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, xTabLayout4.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
        this.Wwwwwwwwwwwwwww = new MyViewPagerAdapter(getChildFragmentManager(), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwww);
        this.viewpager.setOffscreenPageLimit(4);
        this.viewpager.setAdapter(this.Wwwwwwwwwwwwwww);
        this.tablayout.setupWithViewPager(this.viewpager);
        this.viewpager.setCurrentItem(1);
    }
}
