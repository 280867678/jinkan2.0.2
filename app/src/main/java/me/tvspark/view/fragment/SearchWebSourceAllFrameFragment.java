package me.tvspark.view.fragment;

import android.os.Bundle;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.xt0;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchWebSourceAllFrameFragment extends BaseFragment {
    public String Wwwwwwwwww;
    public MyViewPagerAdapter Wwwwwwwwwwww;
    public SearchWebSourceAllFragment Wwwwwwwwwwwww;
    public SearchWebSourceAllFragment Wwwwwwwwwwwwww;
    public xt0 Wwwwwwwwwwwwwwwww;
    @BindView(R.id.flyt_banner)
    public FrameLayout flytBanner;
    @BindView(R.id.pbar)
    public ProgressBar pBar;
    @BindView(R.id.tv_custom)
    public TextView tvCustom;
    @BindView(R.id.tv_official)
    public TextView tvOfficial;
    @BindView(R.id.tv_search_status)
    public TextView tvSearchStatus;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public String[] Wwwwwwwwwwwwwwww = {"推荐", "自定义"};
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwww = new SparseArray<>();
    public boolean Wwwwwwwwwww = true;

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
            SearchWebSourceAllFrameFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i == 0);
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_search_websource_all_frame;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        if (r8 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b7, code lost:
        r8 = r7.tvSearchStatus;
        r0 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b1, code lost:
        r7.tvSearchStatus.setText(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
        if (r8 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        Spanned spanned;
        TextView textView;
        SearchWebSourceAllFragment searchWebSourceAllFragment;
        String str;
        int i = 0;
        if (z) {
            this.Wwwwwwwwwww = true;
            this.tvOfficial.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            this.tvOfficial.setBackgroundResource(R.drawable.shape_bg_category);
            this.tvCustom.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.black));
            this.tvCustom.setBackgroundResource(R.drawable.shape_trans);
            ProgressBar progressBar = this.pBar;
            if (!this.Wwwwwwwwwwwwww.Wwwwwwwwwwwww) {
                i = 8;
            }
            progressBar.setVisibility(i);
            this.tvSearchStatus.setOnClickListener(this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwww);
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwwww)) {
                spanned = this.Wwwwwwwwwwwwww.Wwwwwwwwwwwwwww;
            } else {
                textView = this.tvSearchStatus;
                searchWebSourceAllFragment = this.Wwwwwwwwwwwwww;
                str = searchWebSourceAllFragment.Wwwwwwwwwwwwwwww;
            }
        } else {
            this.Wwwwwwwwwww = false;
            this.tvOfficial.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.black));
            this.tvOfficial.setBackgroundResource(R.drawable.shape_trans);
            this.tvCustom.setTextColor(ContextCompat.getColor(this.Wwwwwwwwwwwwwwwwwwwwwww, R.color.colorPrimary));
            this.tvCustom.setBackgroundResource(R.drawable.shape_bg_category);
            ProgressBar progressBar2 = this.pBar;
            if (!this.Wwwwwwwwwwwww.Wwwwwwwwwwwww) {
                i = 8;
            }
            progressBar2.setVisibility(i);
            this.tvSearchStatus.setOnClickListener(this.Wwwwwwwwwwwww.Wwwwwwwwwwwwww);
            if (!TextUtils.isEmpty(this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwww)) {
                textView = this.tvSearchStatus;
                searchWebSourceAllFragment = this.Wwwwwwwwwwwww;
                str = searchWebSourceAllFragment.Wwwwwwwwwwwwwwww;
            } else {
                spanned = this.Wwwwwwwwwwwww.Wwwwwwwwwwwwwww;
            }
        }
        textView.setText(str);
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        String string = getArguments().getString("key_string");
        this.Wwwwwwwwww = string;
        SearchWebSourceAllFragment searchWebSourceAllFragment = new SearchWebSourceAllFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_string", string);
        bundle2.putBoolean("key_boolean", true);
        searchWebSourceAllFragment.setArguments(bundle2);
        this.Wwwwwwwwwwwwww = searchWebSourceAllFragment;
        String str = this.Wwwwwwwwww;
        SearchWebSourceAllFragment searchWebSourceAllFragment2 = new SearchWebSourceAllFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("key_string", str);
        bundle3.putBoolean("key_boolean", false);
        searchWebSourceAllFragment2.setArguments(bundle3);
        this.Wwwwwwwwwwwww = searchWebSourceAllFragment2;
        this.Wwwwwwwwwwwwwww.put(0, this.Wwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwww.put(1, this.Wwwwwwwwwwwww);
        this.Wwwwwwwwwwww = new MyViewPagerAdapter(getChildFragmentManager(), this.Wwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
        this.viewpager.setOffscreenPageLimit(4);
        this.viewpager.setAdapter(this.Wwwwwwwwwwww);
        this.viewpager.setCurrentItem(0);
        this.viewpager.addOnPageChangeListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("ad_type");
        if (!ApplicationC1880C.Wwwwwwwww) {
            xt0 xt0Var = new xt0(this.Wwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwww = xt0Var;
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwww = "8091823043098355";
            xt0Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, SearchWebSourceAllFrameFragment.class.getSimpleName());
            this.flytBanner.removeAllViews();
            this.flytBanner.addView(this.Wwwwwwwwwwwwwwwww);
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2, String str, Spanned spanned, View.OnClickListener onClickListener) {
        if (this.Wwwwwwwwwww == z) {
            this.pBar.setVisibility(z2 ? 0 : 8);
            this.tvSearchStatus.setOnClickListener(onClickListener);
            if (!TextUtils.isEmpty(str)) {
                this.tvSearchStatus.setText(str);
            } else if (spanned == null) {
            } else {
                this.tvSearchStatus.setText(spanned);
            }
        }
    }

    @Override // me.tvspark.common.view.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @OnClick({R.id.tv_official, R.id.tv_custom})
    public void onViewClicked(View view) {
        ViewPager viewPager;
        int i;
        int id = view.getId();
        if (id == R.id.tv_custom) {
            viewPager = this.viewpager;
            i = 1;
        } else if (id != R.id.tv_official) {
            return;
        } else {
            viewPager = this.viewpager;
            i = 0;
        }
        viewPager.setCurrentItem(i);
    }
}
