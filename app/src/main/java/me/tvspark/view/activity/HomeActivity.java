package me.tvspark.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.umeng.commonsdk.statistics.C1767b;
import java.util.ArrayList;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.MyViewPagerAdapter;
import me.tvspark.am0;
import me.tvspark.ap0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.mn0;
import me.tvspark.nn0;
import me.tvspark.pn0;
import me.tvspark.r40;
import me.tvspark.rr0;
import me.tvspark.tm0;
import me.tvspark.um0;
import me.tvspark.utils.cast.service.ClingService;
import me.tvspark.utils.cast.service.SystemService;
import me.tvspark.view.fragment.CategoryFragment;
import me.tvspark.view.fragment.IndexFragment;
import me.tvspark.view.fragment.MeFragment;
import me.tvspark.view.fragment.WebSourceFragment;
import me.tvspark.vt0;
import me.tvspark.widget.NoScrollViewPager;
import white.whale.R;

/* loaded from: classes4.dex */
public class HomeActivity extends BaseActivity<tm0> implements um0 {
    public WebSourceFragment Wwwwwwwwwwww;
    public BaseFragment Wwwwwwwwwwwww;
    public BaseFragment Wwwwwwwwwwwwww;
    public BaseFragment Wwwwwwwwwwwwwww;
    public MyViewPagerAdapter Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.view_pager_main)
    public NoScrollViewPager mViewPager;
    @BindView(R.id.rg_bottom)
    public RadioGroup radioGroup;
    @BindView(R.id.rb_category)
    public RadioButton rbCategory;
    @BindView(R.id.rb_home)
    public RadioButton rbHome;
    @BindView(R.id.rb_me)
    public RadioButton rbMe;
    @BindView(R.id.rb_webSource)
    public RadioButton rbWebSource;
    public boolean Wwwwwwwwwwwwwwwwww = false;
    public SparseArray<BaseFragment> Wwwwwwwwwwwwwwwww = new SparseArray<>();
    public int Wwwwwwwwwwwwwwww = 0;
    public Handler Wwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    public ArrayList<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwww = new ArrayList<>();
    public Point Wwwwwwwww = new Point(0, 0);

    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void onTouchEvent(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(HomeActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HomeActivity.this.Wwwwwwwwwwwwwwwwww = false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements RadioGroup.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            HomeActivity homeActivity = HomeActivity.this;
            switch (i) {
                case R.id.rb_category /* 2131362413 */:
                    homeActivity.Wwwwwwwwwwwwwwww = 2;
                    BaseActivity baseActivity = homeActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, ContextCompat.getColor(baseActivity, R.color.f5061white));
                    break;
                case R.id.rb_home /* 2131362414 */:
                    homeActivity.Wwwwwwwwwwwwwwww = 0;
                    BaseActivity baseActivity2 = homeActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity2, ContextCompat.getColor(baseActivity2, R.color.f5061white));
                    break;
                case R.id.rb_me /* 2131362415 */:
                    homeActivity.Wwwwwwwwwwwwwwww = 3;
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Activity) homeActivity.Wwwwwwwwwwwwwwwwwwwwwwww);
                    break;
                case R.id.rb_webSource /* 2131362416 */:
                    homeActivity.Wwwwwwwwwwwwwwww = 1;
                    WebSourceFragment webSourceFragment = homeActivity.Wwwwwwwwwwww;
                    if (webSourceFragment != null) {
                        nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(webSourceFragment.Wwwwwwwwwwwwwwwwwwwwwww, new vt0(webSourceFragment));
                    }
                    BaseActivity baseActivity22 = homeActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                    r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity22, ContextCompat.getColor(baseActivity22, R.color.f5061white));
                    break;
            }
            homeActivity.mViewPager.setCurrentItem(homeActivity.Wwwwwwwwwwwwwwww, false);
        }
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public tm0 Wwwwwwwwwwwwwwww() {
        return new am0();
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_home;
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        if (!z) {
            AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle("注意").setMessage("当前配置信息请求失败，请立即切换配置，以防App无法使用！！！").setPositiveButton("切换配置", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    @Override // me.tvspark.common.view.BaseActivity
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        MeFragment meFragment;
        if (nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww) || nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(getApplication()).equals(C1767b.f4025f)) {
            System.exit(0);
        }
        BaseActivity baseActivity = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, ContextCompat.getColor(baseActivity, R.color.f5061white));
        Drawable drawable = getResources().getDrawable(R.drawable.rbtn_main_home_selector);
        drawable.setBounds(0, 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20));
        this.rbHome.setCompoundDrawables(null, drawable, null, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.rbtn_main_live_selector);
        drawable2.setBounds(0, 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21));
        this.rbWebSource.setCompoundDrawables(null, drawable2, null, null);
        Drawable drawable3 = getResources().getDrawable(R.drawable.rbtn_main_newest_selector);
        drawable3.setBounds(0, 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(21));
        this.rbCategory.setCompoundDrawables(null, drawable3, null, null);
        Drawable drawable4 = getResources().getDrawable(R.drawable.rbtn_main_me_selector);
        drawable4.setBounds(0, 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20), r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20));
        this.rbMe.setCompoundDrawables(null, drawable4, null, null);
        ApplicationC1880C.Wwwwwwwww = false;
        if (bundle == null) {
            this.Wwwwwwwwwwwwwww = new IndexFragment();
            this.Wwwwwwwwwwww = new WebSourceFragment();
            this.Wwwwwwwwwwwwww = new CategoryFragment();
            meFragment = new MeFragment();
        } else {
            this.Wwwwwwwwwwwwwww = (IndexFragment) this.Wwwwwwwwwwwwwwwwwwwwwww.getFragment(bundle, IndexFragment.class.getName());
            this.Wwwwwwwwwwww = (WebSourceFragment) this.Wwwwwwwwwwwwwwwwwwwwwww.getFragment(bundle, WebSourceFragment.class.getName());
            this.Wwwwwwwwwwwwww = (CategoryFragment) this.Wwwwwwwwwwwwwwwwwwwwwww.getFragment(bundle, CategoryFragment.class.getName());
            meFragment = (MeFragment) this.Wwwwwwwwwwwwwwwwwwwwwww.getFragment(bundle, MeFragment.class.getName());
        }
        this.Wwwwwwwwwwwww = meFragment;
        this.Wwwwwwwwwwwwwwwww.put(0, this.Wwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.put(1, this.Wwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.put(2, this.Wwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww.put(3, this.Wwwwwwwwwwwww);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this.Wwwwwwwwwwwwwwwwwwwwwww, new ArrayList(), this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww = myViewPagerAdapter;
        this.mViewPager.setAdapter(myViewPagerAdapter);
        this.mViewPager.setOffscreenPageLimit(5);
        this.mViewPager.setNoScroll(true);
        this.radioGroup.setOnCheckedChangeListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.radioGroup.check(R.id.rb_home);
        pn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false, false);
        ((tm0) this.Wwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
        ApplicationC1880C.Wwwwwwwww = false;
        new rr0(this.Wwwwwwwwwwwwwwwwwwwwwwww).execute(new String[0]);
    }

    @Override // me.tvspark.um0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.Wwwwwwwww.x = (int) motionEvent.getRawX();
            this.Wwwwwwwww.y = (int) motionEvent.getRawY();
        }
        for (int i = 0; i < this.Wwwwwwwwww.size(); i++) {
            this.Wwwwwwwwww.get(i).onTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.Wwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwww = true;
            Toast.makeText(this, "再按一次退出app", 0).show();
            this.Wwwwwwwwwww.sendEmptyMessageDelayed(0, 3000L);
            return;
        }
        ap0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = ap0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        ServiceConnection serviceConnection = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (serviceConnection != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unbindService(serviceConnection);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        ServiceConnection serviceConnection2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (serviceConnection2 != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.unbindService(serviceConnection2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        ClingService clingService = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (clingService != null) {
            clingService.onDestroy();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        SystemService systemService = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (systemService != null) {
            systemService.onDestroy();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        ap0.Wwwwwwwwwwwwwwwwwwwwwwww = null;
        Process.killProcess(Process.myPid());
    }
}
