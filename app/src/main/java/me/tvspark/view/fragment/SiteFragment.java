package me.tvspark.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import com.androidkun.xtablayout.XTabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.ApplicationC1880C;
import me.tvspark.adapter.MyViewPagerAdapter2;
import me.tvspark.bo0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.common.view.BaseFragment;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.event.ReqWebSourceEvent;
import me.tvspark.data.sql.CodeForSiteData;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.eo0;
import me.tvspark.jl0;
import me.tvspark.mn0;
import me.tvspark.nm0;
import me.tvspark.nn0;
import me.tvspark.om0;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.widget.dialog.DialogLines;
import me.tvspark.widget.dialog.DialogOperate;
import me.tvspark.x11;
import me.tvspark.yn0;
import me.tvspark.zl0;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;
import org.litepal.crud.callback.FindMultiCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class SiteFragment extends BaseFragment<nm0> implements om0 {
    public boolean Wwwwwwwww;
    public MyViewPagerAdapter2 Wwwwwwwwwwwwwwww;
    @BindView(R.id.fab_add)
    public FloatingActionButton fabAdd;
    @BindView(R.id.llyt_empty)
    public LinearLayout llytEmpty;
    @BindView(R.id.pb_websource)
    public ProgressBar pbWebsource;
    @BindView(R.id.tablayout)
    public XTabLayout tablayout;
    @BindView(R.id.viewpager)
    public ViewPager viewpager;
    public List<String> Wwwwwwwwwwwwwwwww = new ArrayList();
    public List<Fragment> Wwwwwwwwwwwwwww = new ArrayList();
    public boolean Wwwwwwwwwwwwww = false;
    public List<WebSourceIndexData> Wwwwwwwwwwwww = new ArrayList();
    public List<CodeForSiteData> Wwwwwwwwwwww = new ArrayList();
    public int Wwwwwwwwwww = 0;
    public int Wwwwwwwwww = 12;
    public boolean Wwwwwwww = false;
    public CustomWebEvent Wwwwwww = null;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements ViewPager.OnPageChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            SiteFragment.this.Wwwwwwwwwww = i;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, (WebSourceTitaData) null, -1);
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnShowListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment siteFragment) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String obj = this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, "不能为空");
                return;
            }
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            try {
                ((nm0) SiteFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, obj);
            } catch (Exception e) {
                e.printStackTrace();
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, "格式错误，请升级到最新版本！");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // me.tvspark.nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
                BaseActivity baseActivity;
                String str2;
                if (TextUtils.isEmpty(str)) {
                    baseActivity = SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
                    str2 = "剪切板为空";
                } else {
                    try {
                        ((nm0) SiteFragment.this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, str);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        baseActivity = SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww;
                        str2 = "格式错误，请升级到最新版本！";
                    }
                }
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(baseActivity, str2);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            nn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceIndexData> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SiteFragment siteFragment = SiteFragment.this;
                siteFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(siteFragment.Wwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<WebSourceIndexData> list) {
            SiteFragment siteFragment;
            if (list == null || list.isEmpty()) {
                jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, false, false);
                return;
            }
            ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww = !TextUtils.isEmpty(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index")) ? bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index") : !TextUtils.isEmpty(bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_index_url")) ? bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("default_index_url") : list.get(0).getWebSourceBaseUrl();
            if (jl0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, list.get(0))) {
                return;
            }
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(list.get(i).getRuleIndex1List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex2List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex3List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex4List())) {
                    if (TextUtils.isEmpty(ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww)) {
                        siteFragment = SiteFragment.this;
                    } else if (ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww.equals(list.get(i).getWebSourceBaseUrl())) {
                        SiteFragment.this.Wwwwwwwwwwwww.add(0, list.get(i));
                        z = true;
                    } else {
                        siteFragment = SiteFragment.this;
                    }
                    siteFragment.Wwwwwwwwwwwww.add(list.get(i));
                }
            }
            if (!z) {
                ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww = SiteFragment.this.Wwwwwwwwwwwww.get(0).getWebSourceBaseUrl();
            }
            bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("cur_url_index", ApplicationC1880C.Wwwwwwwwwwwwwwwwwwwwwww);
            SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<CodeForSiteData> {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements FindMultiCallback<WebSourceTitaData> {

            /* renamed from: me.tvspark.view.fragment.SiteFragment$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC3504Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
                public RunnableC3504Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    SiteFragment siteFragment = SiteFragment.this;
                    siteFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(siteFragment.Wwwwwwwwwwwww);
                }
            }

            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.FindMultiCallback
            public void onFinish(List<WebSourceTitaData> list) {
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!TextUtils.isEmpty(list.get(i).getRuleIndex1List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex2List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex3List()) || !TextUtils.isEmpty(list.get(i).getRuleIndex4List())) {
                            int size = SiteFragment.this.Wwwwwwwwwwwww.size();
                            SiteFragment siteFragment = SiteFragment.this;
                            if (size >= siteFragment.Wwwwwwwwww) {
                                break;
                            }
                            siteFragment.Wwwwwwwwwwwww.add(list.get(i).trans2WebSourceIndexData());
                            SiteFragment.this.Wwwwwwwwwwww.add(new CodeForSiteData(list.get(i).getBaseUrl(), list.get(i).getName()));
                        }
                    }
                }
                if (!SiteFragment.this.Wwwwwwwwwwww.isEmpty()) {
                    LitePal.saveAllAsync(SiteFragment.this.Wwwwwwwwwwww).listen(null);
                }
                SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new RunnableC3504Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            }
        }

        /* renamed from: me.tvspark.view.fragment.SiteFragment$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC3505Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public final /* synthetic */ boolean Wwwwwwwwwwwwwwwwwwwwwwww;

            public RunnableC3505Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
                this.Wwwwwwwwwwwwwwwwwwwwwwww = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.Wwwwwwwwwwwwwwwwwwwwwwww && !bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("site_websource_deleted_notify", false)) {
                    bo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("site_websource_deleted_notify", true);
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww, "失效站源已从首页列表中删除");
                }
                SiteFragment siteFragment = SiteFragment.this;
                siteFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(siteFragment.Wwwwwwwwwwwww);
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.FindMultiCallback
        public void onFinish(List<CodeForSiteData> list) {
            if (list == null || list.isEmpty()) {
                yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
                return;
            }
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwwww = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(i).getWebSourceBaseUrl());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    int size = SiteFragment.this.Wwwwwwwwwwwww.size();
                    SiteFragment siteFragment = SiteFragment.this;
                    if (size >= siteFragment.Wwwwwwwwww) {
                        break;
                    }
                    siteFragment.Wwwwwwwwwwwww.add(Wwwwwwwwwwwwwwwwwwwwwwwwwww.trans2WebSourceIndexData());
                    SiteFragment.this.Wwwwwwwwwwww.add(list.get(i));
                } else {
                    LitePal.deleteAllAsync(CodeForSiteData.class, "code = ?", list.get(i).getWebSourceBaseUrl()).listen(null);
                    z = true;
                }
            }
            SiteFragment.this.Wwwwwwwwwwwwwwwwwwwwwww.runOnUiThread(new RunnableC3505Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z));
        }
    }

    public final void Wwwwwwwwwwwwww() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        this.Wwwwwwwwwwwww.clear();
        if (!this.Wwwwwwwww) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            return;
        }
        this.Wwwwwwwwwwww.clear();
        yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // me.tvspark.common.view.BaseFragment
    public nm0 Wwwwwwwwwwwwwwwww() {
        return new zl0();
    }

    @Override // me.tvspark.common.view.BaseFragment
    public int Wwwwwwwwwwwwwwwwww() {
        return R.layout.fragment_site;
    }

    @Override // me.tvspark.om0
    public void Wwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
    }

    @Override // me.tvspark.om0
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww() {
        return getActivity().isFinishing();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        EditText editText = new EditText(this.Wwwwwwwwwwwwwwwwwwwwwww);
        editText.setHint("自定义站源格式规则(可批量导入)");
        if (!TextUtils.isEmpty(str)) {
            editText.setText(str);
        }
        AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwww).setTitle("站源导入").setView(editText).setNegativeButton("取消", (DialogInterface.OnClickListener) null).setPositiveButton("导入", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText)).setNeutralButton("粘贴", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).create();
        create.setView(editText, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0);
        create.setOnShowListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
        create.show();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(List<WebSourceIndexData> list) {
        CustomWebEvent customWebEvent;
        this.pbWebsource.setVisibility(8);
        if (list.isEmpty()) {
            this.Wwwwwwwwwwwwwwwww.clear();
            this.tablayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwww.clear();
            this.viewpager.setVisibility(8);
            this.llytEmpty.setVisibility(0);
            return;
        }
        this.Wwwwwwwwwwwwww = true;
        this.viewpager.setVisibility(0);
        this.llytEmpty.setVisibility(8);
        this.Wwwwwwwwwwwwwwwww.clear();
        this.tablayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwww.clear();
        int i = 0;
        while (i < list.size()) {
            this.Wwwwwwwwwwwwwwwww.add(list.get(i).getWebSourceSiteName());
            XTabLayout xTabLayout = this.tablayout;
            XTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list.get(i).getWebSourceSiteName();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            xTabLayout.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, xTabLayout.Wwwwwwwwwwwwwwwwwwwwww.isEmpty());
            this.Wwwwwwwwwwwwwww.add(VideoIndexFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(list.get(i), i == 0, i == 0));
            i++;
        }
        MyViewPagerAdapter2 myViewPagerAdapter2 = this.Wwwwwwwwwwwwwwww;
        if (myViewPagerAdapter2 == null) {
            this.Wwwwwwwwwwwwwwww = new MyViewPagerAdapter2(getChildFragmentManager(), this.Wwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwww);
            this.viewpager.setOffscreenPageLimit(5);
            this.viewpager.addOnPageChangeListener(new Wwwwwwwwwwwwwwwwwwwwwwwwww());
            this.viewpager.setAdapter(this.Wwwwwwwwwwwwwwww);
            this.tablayout.setupWithViewPager(this.viewpager);
        } else {
            myViewPagerAdapter2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
            myViewPagerAdapter2.notifyDataSetChanged();
            this.viewpager.setCurrentItem(0);
        }
        if (!this.Wwwwwwww && (customWebEvent = this.Wwwwwww) != null) {
            this.Wwwwwwww = true;
            onWebSourceAdded(customWebEvent);
            this.Wwwwwww = null;
        }
        this.Wwwwwwww = true;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        try {
            ((nm0) this.Wwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, str);
        } catch (Exception e) {
            e.printStackTrace();
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, "格式错误，请升级到最新版本！");
        }
    }

    @Override // me.tvspark.common.view.BaseFragment
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Bundle bundle) {
        this.Wwwwwwwww = getArguments().getBoolean("key_boolean");
    }

    @Override // me.tvspark.om0
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
    }

    @OnClick({R.id.tv_retry, R.id.tv_retry2, R.id.iv_sort, R.id.fab_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_add /* 2131362077 */:
                new DialogOperate(this.Wwwwwwwwwwwwwwwwwwwwwww, new String[]{"粘贴自定义站源", "编写自定义站源", "编辑 / 删除站源"}, new Integer[]{Integer.valueOf((int) R.drawable.ic_website_add), Integer.valueOf((int) R.drawable.ic_web_source_edit), Integer.valueOf((int) R.drawable.ic_website_remove)}, new View.OnClickListener[]{new Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwwww(), new Wwwwwwwwwwwwwwwwwwwwwwwwwww()}).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return;
            case R.id.iv_sort /* 2131362190 */:
                if (this.Wwwwwwwww) {
                    mn0.Wwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww);
                    return;
                }
                DialogLines dialogLines = new DialogLines(this.Wwwwwwwwwwwwwwwwwwwwwww);
                if (dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.isShowing()) {
                    return;
                }
                dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.setCanceledOnTouchOutside(true);
                dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.setCancelable(true);
                dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.show();
                Window window = dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.getWindow();
                window.setWindowAnimations(R.style.BotomInOutDialogStyle);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.width = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(dialogLines.Wwwwwwwwwwwwwwwwwwwwww);
                attributes.height = (int) (dialogLines.Wwwwwwwwwwwwwwwwwwwwww.getWindowManager().getDefaultDisplay().getHeight() * 0.95d);
                window.setAttributes(attributes);
                window.setContentView(dialogLines.Wwwwwwwwwwwwwwwwwwwwwwww);
                dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().clearFlags(131080);
                dialogLines.Wwwwwwwwwwwwwwwwwwwwwww.getWindow().setSoftInputMode(18);
                return;
            case R.id.tv_retry /* 2131362731 */:
            case R.id.tv_retry2 /* 2131362732 */:
                if (this.Wwwwwwwww) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("");
                    return;
                } else {
                    Wwwwwwwwwwwwww();
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @x11(threadMode = ThreadMode.MAIN)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onWebSourceAdded(CustomWebEvent customWebEvent) {
        if (this.Wwwwwwwww) {
            int i = 0;
            if (customWebEvent.isToAdd()) {
                if (!this.Wwwwwwww) {
                    this.Wwwwwww = customWebEvent;
                    return;
                } else if (this.Wwwwwwwwwwwww.size() >= this.Wwwwwwwwww) {
                    if (customWebEvent.getWebSourceTitaData() != null) {
                        for (int i2 = 0; i2 < this.Wwwwwwwwwwwww.size(); i2++) {
                            if (this.Wwwwwwwwwwwww.get(i2).getWebSourceBaseUrl().equals(customWebEvent.getWebSourceTitaData().getBaseUrl())) {
                                this.Wwwwwwwwwwwww.set(i2, customWebEvent.getWebSourceTitaData().trans2WebSourceIndexData());
                                this.Wwwwwwwwwwww.set(i2, new CodeForSiteData(customWebEvent.getWebSourceTitaData().getBaseUrl(), customWebEvent.getWebSourceTitaData().getName()));
                                i = 1;
                                break;
                            }
                        }
                    }
                    if (i == 0) {
                    }
                } else if (customWebEvent.getWebSourceTitaData() != null) {
                    boolean z = false;
                    while (i < this.Wwwwwwwwwwwww.size()) {
                        if (this.Wwwwwwwwwwwww.get(i).getWebSourceBaseUrl().equals(customWebEvent.getWebSourceTitaData().getBaseUrl())) {
                            this.Wwwwwwwwwwwww.set(i, customWebEvent.getWebSourceTitaData().trans2WebSourceIndexData());
                            this.Wwwwwwwwwwww.set(i, new CodeForSiteData(customWebEvent.getWebSourceTitaData().getBaseUrl(), customWebEvent.getWebSourceTitaData().getName()));
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        this.Wwwwwwwwwwwww.add(customWebEvent.getWebSourceTitaData().trans2WebSourceIndexData());
                        this.Wwwwwwwwwwww.add(new CodeForSiteData(customWebEvent.getWebSourceTitaData().getBaseUrl(), customWebEvent.getWebSourceTitaData().getName()));
                    }
                    i = 1;
                    if (i == 0) {
                        return;
                    }
                } else {
                    if (customWebEvent.getWebSourceTitaDataList() != null && this.Wwwwwwwwwwwww.isEmpty()) {
                        Wwwwwwwwwwwwww();
                    }
                    if (i == 0) {
                    }
                }
            } else if (customWebEvent.getWebSourceTitaData() != null) {
                while (i < this.Wwwwwwwwwwwww.size()) {
                    if (this.Wwwwwwwwwwwww.get(i).getWebSourceBaseUrl().equals(customWebEvent.getWebSourceTitaData().getBaseUrl())) {
                        this.Wwwwwwwwwwwww.remove(i);
                        this.Wwwwwwwwwwww.remove(i);
                    } else {
                        i++;
                    }
                }
                return;
            } else {
                this.Wwwwwwwwwwwww.clear();
                this.Wwwwwwwwwwww.clear();
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwww);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
        }
    }

    @x11(threadMode = ThreadMode.MAIN)
    public void onWebSourceDownload(ReqWebSourceEvent reqWebSourceEvent) {
        if (reqWebSourceEvent.getUrlWebSource().equals(ApplicationC1880C.Wwwwwwwwwwwwwwwwww)) {
            if (reqWebSourceEvent.isSuccess()) {
                Wwwwwwwwwwwwww();
            } else {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        FloatingActionButton floatingActionButton;
        super.setUserVisibleHint(z);
        if (z && !this.Wwwwwwwwwwwwww) {
            Wwwwwwwwwwwwww();
        }
        if (!z || (floatingActionButton = this.fabAdd) == null) {
            return;
        }
        floatingActionButton.setVisibility(this.Wwwwwwwww ? 0 : 8);
    }
}
