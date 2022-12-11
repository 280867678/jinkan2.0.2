package com.tencent.smtt.sdk.p045ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stub.StubApp;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.p045ui.dialog.widget.RoundImageView;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.a */
/* loaded from: classes4.dex */
public class View$OnClickListenerC1401a extends ArrayAdapter<C1404b> implements View.OnClickListener, ListAdapter {

    /* renamed from: a */
    public ArrayList<C1404b> f2244a;

    /* renamed from: b */
    public C1404b f2245b = null;

    /* renamed from: c */
    public Intent f2246c;

    /* renamed from: d */
    public WeakReference<ListView> f2247d;

    /* renamed from: e */
    public WeakReference<DialogC1406d> f2248e;

    /* renamed from: f */
    public C1404b f2249f;

    /* renamed from: g */
    public C1404b f2250g;

    /* renamed from: h */
    public List<C1404b> f2251h;

    /* renamed from: i */
    public Handler f2252i;

    /* renamed from: j */
    public String[] f2253j;

    public View$OnClickListenerC1401a(Context context, Intent intent, C1404b c1404b, List<C1404b> list, C1404b c1404b2, DialogC1406d dialogC1406d, ListView listView) {
        super(context, 0);
        m2356a(dialogC1406d);
        m2360a(listView);
        this.f2250g = c1404b;
        this.f2246c = intent;
        if ("com.tencent.rtxlite".equalsIgnoreCase(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) || MttLoader.isBrowserInstalled(context)) {
            this.f2249f = null;
        } else {
            this.f2249f = this.f2250g;
        }
        this.f2251h = list;
        this.f2252i = new Handler() { // from class: com.tencent.smtt.sdk.ui.dialog.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                View$OnClickListenerC1401a.this.m2354b();
            }
        };
        String[] strArr = new String[2];
        this.f2253j = strArr;
        strArr[0] = C1410e.m2317b("x5_tbs_activity_picker_recommend_to_trim");
        this.f2253j[1] = C1410e.m2317b("x5_tbs_activity_picker_recommend_with_chinese_brace_to_trim");
        m2362a(context, c1404b2);
    }

    /* renamed from: a */
    private View m2363a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.argb(41, 0, 0, 0)));
        stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
        linearLayout.setBackgroundDrawable(stateListDrawable);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, C1405c.m2338a(getContext(), 144.0f)));
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(C1405c.m2338a(getContext(), 96.0f), C1405c.m2338a(getContext(), 96.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.setMargins(C1405c.m2338a(getContext(), 32.0f), C1405c.m2338a(getContext(), 24.0f), C1405c.m2338a(getContext(), 24.0f), C1405c.m2338a(getContext(), 24.0f));
        roundImageView.setLayoutParams(layoutParams);
        roundImageView.setId(101);
        relativeLayout.addView(roundImageView);
        LinearLayout linearLayout2 = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 101);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setMaxLines(1);
        textView.setTextColor(Color.rgb(29, 29, 29));
        textView.setTextSize(1, 17.0f);
        textView.setId(102);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView2.setText(C1410e.m2317b("x5_tbs_wechat_activity_picker_label_recommend"));
        textView2.setTextColor(Color.parseColor("#00CAFC"));
        textView2.setTextSize(1, 14.0f);
        textView2.setId(103);
        linearLayout2.addView(textView2);
        relativeLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(C1405c.m2338a(getContext(), 48.0f), C1405c.m2338a(getContext(), 48.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(0, 0, C1405c.m2338a(getContext(), 32.0f), 0);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageDrawable(C1410e.m2318a("x5_tbs_activity_picker_check"));
        imageView.setId(104);
        relativeLayout.addView(imageView);
        relativeLayout.setId(105);
        linearLayout.addView(relativeLayout);
        return linearLayout;
    }

    /* renamed from: a */
    private void m2357a(C1404b c1404b, View view) {
        String[] strArr;
        if (view == null || c1404b == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(102);
        TextView textView2 = (TextView) view.findViewById(103);
        ImageView imageView = (ImageView) view.findViewById(104);
        View findViewById = view.findViewById(105);
        View findViewById2 = view.findViewById(106);
        ((ImageView) view.findViewById(101)).setImageDrawable(c1404b.m2352a());
        String replaceAll = c1404b.m2346b().trim().replaceAll(" ", "");
        for (String str : this.f2253j) {
            if (str != null && str.length() > 0) {
                replaceAll = replaceAll.replaceAll(str, "");
            }
        }
        textView.setText(replaceAll);
        if (c1404b.m2345c() == null) {
            c1404b.m2350a(m2358a(c1404b));
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ViewParent parent = view2.getParent();
                if (!(parent instanceof View)) {
                    return;
                }
                View view3 = (View) parent;
                if (view3.getTag() != View$OnClickListenerC1401a.this.f2249f) {
                    return;
                }
                View$OnClickListenerC1401a.this.onClick(view3);
            }
        });
        if (TbsConfig.APP_QB.equals(c1404b.m2344d())) {
            textView2.setVisibility(0);
            textView2.setText(c1404b.m2340h());
        } else {
            textView2.setVisibility(8);
        }
        findViewById.setClickable(false);
        findViewById.setEnabled(false);
        if (c1404b == this.f2245b) {
            imageView.setVisibility(0);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else {
            imageView.setVisibility(8);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        }
        view.setTag(c1404b);
        view.setOnClickListener(this);
    }

    /* renamed from: a */
    private void m2355a(boolean z) {
        DialogC1406d dialogC1406d;
        WeakReference<DialogC1406d> weakReference = this.f2248e;
        if (weakReference == null || (dialogC1406d = weakReference.get()) == null) {
            return;
        }
        dialogC1406d.m2328a(z);
    }

    /* renamed from: a */
    public static boolean m2361a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m2353b(Context context, C1404b c1404b) {
        this.f2245b = c1404b;
        if (c1404b == null) {
            return;
        }
        m2355a((c1404b.m2343e() || this.f2245b.m2342f()) ? true : m2361a(context, this.f2245b.m2344d()));
    }

    /* renamed from: a */
    public ResolveInfo m2358a(C1404b c1404b) {
        if (c1404b != null && !TextUtils.isEmpty(c1404b.m2344d())) {
            for (ResolveInfo resolveInfo : getContext().getPackageManager().queryIntentActivities(this.f2246c, 65536)) {
                if (c1404b.m2344d().equals(resolveInfo.activityInfo.packageName)) {
                    return resolveInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public C1404b m2365a() {
        return this.f2245b;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a */
    public C1404b getItem(int i) {
        if (i < 0 || i >= this.f2244a.size()) {
            return null;
        }
        return this.f2244a.get(i);
    }

    /* renamed from: a */
    public void m2362a(Context context, C1404b c1404b) {
        C1404b c1404b2;
        this.f2244a = new ArrayList<>();
        List<C1404b> list = this.f2251h;
        if (list != null && list.size() != 0) {
            this.f2244a.addAll(this.f2251h);
        }
        boolean z = false;
        boolean z2 = false;
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(this.f2246c, 65536)) {
            if (C1404b.m2351a(context, resolveInfo.activityInfo.packageName) != null || resolveInfo.loadIcon(context.getPackageManager()) != null) {
                C1404b c1404b3 = new C1404b(context, resolveInfo);
                C1404b c1404b4 = this.f2249f;
                if (c1404b4 != null && c1404b4.m2344d().equals(resolveInfo.activityInfo.packageName)) {
                    c1404b3.m2347a(this.f2249f.m2342f());
                    c1404b3.m2348a(this.f2249f.m2340h());
                    c1404b3.m2349a(this.f2249f.m2352a());
                    this.f2244a.add(0, c1404b3);
                    z = true;
                } else if (TbsConfig.APP_QB.equals(resolveInfo.activityInfo.packageName)) {
                    C1404b c1404b5 = this.f2250g;
                    if (c1404b5 != null) {
                        c1404b3.m2347a(c1404b5.m2342f());
                        c1404b3.m2348a(this.f2250g.m2340h());
                        c1404b3.m2349a(this.f2250g.m2352a());
                    }
                    this.f2244a.add(0, c1404b3);
                } else {
                    this.f2244a.add(c1404b3);
                }
                if (!z2 && c1404b != null && c1404b3.m2344d().equals(c1404b.m2344d())) {
                    m2353b(context, c1404b3);
                    z2 = true;
                }
            }
        }
        if (!z && (c1404b2 = this.f2249f) != null) {
            this.f2244a.add(0, c1404b2);
        }
        if (z2 || this.f2244a.size() <= 0) {
            return;
        }
        m2353b(context, this.f2244a.get(0));
    }

    /* renamed from: a */
    public void m2360a(ListView listView) {
        this.f2247d = new WeakReference<>(listView);
    }

    /* renamed from: a */
    public void m2356a(DialogC1406d dialogC1406d) {
        this.f2248e = new WeakReference<>(dialogC1406d);
    }

    /* renamed from: b */
    public void m2354b() {
        View findViewWithTag;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f2252i.obtainMessage(1).sendToTarget();
            return;
        }
        ListView listView = this.f2247d.get();
        if (listView == null || (findViewWithTag = listView.findViewWithTag(this.f2249f)) == null) {
            return;
        }
        m2357a(this.f2249f, findViewWithTag);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f2244a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1404b item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = m2363a(getContext());
        }
        m2357a(item, view);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1404b c1404b;
        Object tag = view.getTag();
        if (tag == null || !(tag instanceof C1404b) || (c1404b = (C1404b) tag) == this.f2245b) {
            return;
        }
        ViewParent parent = view.getParent();
        View view2 = null;
        if (parent instanceof View) {
            view2 = (View) parent;
        }
        C1404b c1404b2 = this.f2245b;
        m2353b(view.getContext(), c1404b);
        m2357a(c1404b2, view2.findViewWithTag(c1404b2));
        m2357a(this.f2245b, view);
    }
}
