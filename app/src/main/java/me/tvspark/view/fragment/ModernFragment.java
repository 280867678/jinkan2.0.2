package me.tvspark.view.fragment;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import me.tvspark.adapter.HomeModernAdapter;
import me.tvspark.bl0;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.event.RefreshHomeMarkEvent;
import me.tvspark.h50;
import me.tvspark.ot0;
import me.tvspark.r40;
import me.tvspark.view.activity.HomeActivity;
import me.tvspark.widget.ItemTouchCallBack;
import me.tvspark.widget.decoration.GridSpanDecoration;
import me.tvspark.x11;
import me.tvspark.yn0;
import org.greenrobot.eventbus.ThreadMode;
import white.whale.R;

/* loaded from: classes4.dex */
public class ModernFragment extends BaseFragment {
    public HomeModernAdapter Wwwwwwwwwwwwww;
    public h50 Wwwwwwwwwwwwwww;
    public Point Wwwwwwwwwwwwwwww;
    public ItemTouchCallBack Wwwwwwwwwwwwwwwww;
    @BindView(R.id.rlyt_search)
    public RelativeLayout rlytSearch;
    @BindView(R.id.rv_content)
    public RecyclerView rvContent;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements HomeActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ModernFragment.this = r1;
        }

        @Override // me.tvspark.view.activity.HomeActivity.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ModernFragment.this.Wwwwwwwwwwwwwwww.x = (int) motionEvent.getRawX();
                ModernFragment.this.Wwwwwwwwwwwwwwww.y = (int) motionEvent.getRawY();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements HomeModernAdapter.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ModernFragment.this = r1;
        }
    }

    public static /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment modernFragment) {
        return modernFragment.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    public static /* synthetic */ BaseActivity Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ModernFragment modernFragment) {
        return modernFragment.Wwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public bl0 Wwwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_modern;
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        if (bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("is_first_websoso", true)) {
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("is_first_websoso", false);
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
        this.rlytSearch.setBackground(getResources().getDrawable(R.drawable.shape_bg_home_top_search));
        this.rvContent.setLayoutManager(new GridLayoutManager(this.Wwwwwwwwwwwwwwwwwwwwwww, 5));
        this.rvContent.setNestedScrollingEnabled(false);
        this.rvContent.addItemDecoration(new GridSpanDecoration(r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwww, 13.0d)));
        HomeModernAdapter homeModernAdapter = new HomeModernAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwww = homeModernAdapter;
        this.rvContent.setAdapter(homeModernAdapter);
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(new ot0(this));
        ItemTouchCallBack itemTouchCallBack = new ItemTouchCallBack(false);
        this.Wwwwwwwwwwwwwwwww = itemTouchCallBack;
        itemTouchCallBack.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwww;
        new ItemTouchHelper(itemTouchCallBack).attachToRecyclerView(this.rvContent);
        if (getActivity() instanceof HomeActivity) {
            this.Wwwwwwwwwwwwwwww = new Point(0, 0);
            ((HomeActivity) getActivity()).Wwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onRefreshHomeMark(RefreshHomeMarkEvent refreshHomeMarkEvent) {
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(new ot0(this));
    }
}
