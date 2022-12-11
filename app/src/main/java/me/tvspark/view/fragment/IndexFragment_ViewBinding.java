package me.tvspark.view.fragment;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.androidkun.xtablayout.XTabLayout;
import white.whale.R;

/* loaded from: classes4.dex */
public class IndexFragment_ViewBinding implements Unbinder {
    public View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public IndexFragment Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends DebouncingOnClickListener {
        public final /* synthetic */ IndexFragment Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(IndexFragment_ViewBinding indexFragment_ViewBinding, IndexFragment indexFragment) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = indexFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            IndexFragment indexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwww;
            if (indexFragment != null) {
                if (view.getId() != R.id.llyt_reward) {
                    return;
                }
                indexFragment.Wwwwwwwwwwwwww();
                return;
            }
            throw null;
        }
    }

    @UiThread
    public IndexFragment_ViewBinding(IndexFragment indexFragment, View view) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = indexFragment;
        indexFragment.tablayout = (XTabLayout) Utils.findRequiredViewAsType(view, R.id.tablayout, "field 'tablayout'", XTabLayout.class);
        indexFragment.viewpager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewpager'", ViewPager.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.llyt_reward, "method 'onViewClicked'");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = findRequiredView;
        findRequiredView.setOnClickListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, indexFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IndexFragment indexFragment = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (indexFragment != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            indexFragment.tablayout = null;
            indexFragment.viewpager = null;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setOnClickListener(null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
