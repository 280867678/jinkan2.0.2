package com.tencent.smtt.sdk.p045ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.stub.StubApp;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.p045ui.dialog.widget.C1411a;
import com.tencent.smtt.sdk.p045ui.dialog.widget.C1412b;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.outline;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.d */
/* loaded from: classes4.dex */
public class DialogC1406d extends Dialog {

    /* renamed from: a */
    public static WeakReference<ValueCallback<String>> f2268a;

    /* renamed from: b */
    public List<C1404b> f2269b;

    /* renamed from: g */
    public ListView f2274g;

    /* renamed from: h */
    public Button f2275h;

    /* renamed from: i */
    public Button f2276i;

    /* renamed from: k */
    public String f2278k;

    /* renamed from: l */
    public View$OnClickListenerC1401a f2279l;

    /* renamed from: m */
    public String f2280m;

    /* renamed from: n */
    public String f2281n;

    /* renamed from: o */
    public Intent f2282o;

    /* renamed from: p */
    public SharedPreferences f2283p;

    /* renamed from: s */
    public FrameLayout f2286s;

    /* renamed from: t */
    public LinearLayout f2287t;

    /* renamed from: j */
    public final String f2277j = "TBSActivityPicker";

    /* renamed from: c */
    public final String f2270c = "extraMenu";

    /* renamed from: d */
    public final String f2271d = "name";

    /* renamed from: e */
    public final String f2272e = "resource_id";

    /* renamed from: f */
    public final String f2273f = "value";

    /* renamed from: q */
    public int f2284q = 0;

    /* renamed from: r */
    public int f2285r = 0;

    public DialogC1406d(Context context, String str, Intent intent, Bundle bundle, ValueCallback<String> valueCallback, String str2, String str3) {
        super(context, 16973835);
        List<C1404b> list;
        List<C1404b> list2;
        this.f2280m = "*/*";
        String str4 = null;
        this.f2283p = null;
        this.f2281n = str3;
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("acts.size(): ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(queryIntentActivities.size());
        TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
        Bundle bundle2 = bundle != null ? bundle.getBundle("extraMenu") : null;
        if (bundle2 != null) {
            this.f2269b = new ArrayList();
            for (String str5 : bundle2.keySet()) {
                Bundle bundle3 = bundle2.getBundle(str5);
                if (bundle3 != null) {
                    String string = bundle3.getString("name", str4);
                    int i = bundle3.getInt("resource_id", -1);
                    String string2 = bundle3.getString("value", str4);
                    if (string != null && i != -1 && string2 != null) {
                        this.f2269b.add(new C1404b(getContext(), i, string, string2));
                    }
                }
                str4 = null;
            }
        } else {
            TbsLog.m2155i("TBSActivityPicker", "no extra menu info in bundle");
        }
        if (queryIntentActivities.size() == 0 && (((list2 = this.f2269b) == null || list2.isEmpty()) && MttLoader.isBrowserInstalled(context))) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("no action has been found with Intent:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(intent.toString());
            TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            QbSdk.isDefaultDialog = true;
        }
        if ("com.tencent.rtxlite".equalsIgnoreCase(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName()) && queryIntentActivities.size() == 0 && ((list = this.f2269b) == null || list.isEmpty())) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("package name equal to `com.tencent.rtxlite` but no action has been found with Intent:");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(intent.toString());
            TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
            QbSdk.isDefaultDialog = true;
        }
        this.f2278k = str;
        this.f2282o = intent;
        f2268a = new WeakReference<>(valueCallback);
        this.f2283p = context.getSharedPreferences(QbSdk.SHARE_PREFERENCES_NAME, 0);
        if (!TextUtils.isEmpty(str2)) {
            this.f2280m = str2;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Intent:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.f2280m);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(" MineType:");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.f2280m);
        TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString());
    }

    /* renamed from: a */
    private View m2334a(Context context) {
        this.f2286s = new FrameLayout(context);
        this.f2287t = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, Double.valueOf(C1405c.m2339a(context) * 0.5f).intValue());
        layoutParams.gravity = 17;
        this.f2287t.setLayoutParams(layoutParams);
        this.f2287t.setOrientation(1);
        this.f2285r = C1405c.m2338a(context, 72.0f);
        C1411a c1411a = new C1411a(context, C1405c.m2338a(context, 12.0f), C1405c.m2336b(context, 35.0f), C1405c.m2336b(context, 15.0f));
        c1411a.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f2285r));
        c1411a.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1406d.this.dismiss();
            }
        });
        this.f2287t.addView(c1411a);
        ListView listView = new ListView(context);
        this.f2274g = listView;
        listView.setOverScrollMode(2);
        this.f2274g.setVerticalScrollBarEnabled(false);
        this.f2274g.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 16;
        this.f2274g.setLayoutParams(layoutParams2);
        this.f2274g.setDividerHeight(0);
        this.f2287t.addView(this.f2274g);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f2284q = C1405c.m2338a(context, 150.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, this.f2284q);
        layoutParams3.weight = 0.0f;
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setContentDescription("x5_tbs_activity_picker_btn_container");
        this.f2275h = new C1412b(context, C1405c.m2338a(context, 12.0f), Color.parseColor("#EBEDF5"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, C1405c.m2338a(context, 90.0f));
        layoutParams4.weight = 1.0f;
        layoutParams4.topMargin = C1405c.m2338a(context, 30.0f);
        layoutParams4.bottomMargin = C1405c.m2338a(context, 30.0f);
        layoutParams4.leftMargin = C1405c.m2338a(context, 32.0f);
        layoutParams4.rightMargin = C1405c.m2338a(context, 8.0f);
        this.f2275h.setLayoutParams(layoutParams4);
        this.f2275h.setText(C1410e.m2317b("x5_tbs_wechat_activity_picker_label_always"));
        this.f2275h.setTextColor(Color.rgb(29, 29, 29));
        this.f2275h.setTextSize(0, C1405c.m2338a(context, 34.0f));
        linearLayout.addView(this.f2275h);
        this.f2276i = new C1412b(context, C1405c.m2338a(context, 12.0f), Color.parseColor("#00CAFC"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, C1405c.m2338a(context, 90.0f));
        layoutParams5.weight = 1.0f;
        layoutParams5.topMargin = C1405c.m2338a(context, 30.0f);
        layoutParams5.bottomMargin = C1405c.m2338a(context, 30.0f);
        layoutParams5.leftMargin = C1405c.m2338a(context, 8.0f);
        layoutParams5.rightMargin = C1405c.m2338a(context, 32.0f);
        this.f2276i.setLayoutParams(layoutParams5);
        this.f2276i.setText(C1410e.m2317b("x5_tbs_wechat_activity_picker_label_once"));
        this.f2276i.setTextColor(Color.rgb(255, 255, 255));
        this.f2276i.setTextSize(0, C1405c.m2338a(context, 34.0f));
        linearLayout.addView(this.f2276i);
        this.f2287t.addView(linearLayout);
        this.f2286s.addView(this.f2287t);
        return this.f2286s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2333a(C1404b c1404b) {
        if (c1404b.m2342f()) {
            if (m2324c() && f2268a.get() != null) {
                f2268a.get().onReceiveValue("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11047");
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://mdc.html5.qq.com/d/directdown.jsp?channel_id=11041"));
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2325b(String str) {
        ValueCallback<String> valueCallback;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ValueCallback<String> valueCallback2;
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String m2344d;
        ActivityInfo activityInfo;
        if (this.f2279l == null || !m2324c()) {
            return;
        }
        C1404b m2365a = this.f2279l.m2365a();
        ResolveInfo m2358a = this.f2279l.m2358a(m2365a);
        if (f2268a.get() == null) {
            return;
        }
        if (m2365a != null && m2358a != null && (activityInfo = m2358a.activityInfo) != null && activityInfo.packageName != null) {
            valueCallback = f2268a.get();
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(m2358a.activityInfo.packageName);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString();
        } else if (m2365a != null) {
            if (m2365a.m2343e()) {
                valueCallback2 = f2268a.get();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                m2344d = m2365a.m2341g();
            } else if (!m2365a.m2342f()) {
                return;
            } else {
                valueCallback2 = f2268a.get();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
                m2344d = m2365a.m2344d();
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(m2344d);
            valueCallback2.onReceiveValue(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            return;
        } else {
            valueCallback = f2268a.get();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, "other");
        }
        valueCallback.onReceiveValue(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* renamed from: c */
    private Drawable m2322c(String str) {
        Context context = getContext();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        if (!FileUtil.m2170c(file)) {
            return null;
        }
        try {
            TbsLog.m2155i("TBSActivityPicker", "load icon from: " + file.getAbsolutePath());
            return new BitmapDrawable(BitmapFactory.decodeFile(file.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m2324c() {
        String[] strArr = {TbsConfig.APP_QQ, "com.tencent.tim"};
        String packageName = StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getPackageName();
        for (int i = 0; i < 2; i++) {
            if (strArr[i].equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    private void m2321d() {
        String str;
        String str2;
        View$OnClickListenerC1401a view$OnClickListenerC1401a = this.f2279l;
        Drawable drawable = null;
        C1404b m2365a = view$OnClickListenerC1401a != null ? view$OnClickListenerC1401a.m2365a() : null;
        SharedPreferences sharedPreferences = this.f2283p;
        if (sharedPreferences != null) {
            Drawable m2322c = m2322c(sharedPreferences.getString("key_tbs_recommend_icon_url", null));
            str = this.f2283p.getString("key_tbs_recommend_label", null);
            str2 = this.f2283p.getString("key_tbs_recommend_description", null);
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            drawable = m2322c;
        } else {
            str = null;
            str2 = null;
        }
        if (drawable == null) {
            drawable = C1410e.m2318a("application_icon");
        }
        Drawable drawable2 = drawable;
        if (str == null) {
            str = "QQ浏览器";
        }
        String str3 = str;
        if (str2 == null) {
            str2 = C1410e.m2317b("x5_tbs_wechat_activity_picker_label_recommend");
        }
        View$OnClickListenerC1401a view$OnClickListenerC1401a2 = new View$OnClickListenerC1401a(getContext(), this.f2282o, new C1404b(getContext(), drawable2, str3, TbsConfig.APP_QB, str2), this.f2269b, m2365a, this, this.f2274g);
        this.f2279l = view$OnClickListenerC1401a2;
        this.f2274g.setAdapter((ListAdapter) view$OnClickListenerC1401a2);
        m2319e();
    }

    /* renamed from: e */
    private void m2319e() {
        ListAdapter adapter = this.f2274g.getAdapter();
        if (adapter == null) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < adapter.getCount(); i2++) {
            View view = adapter.getView(i2, null, this.f2274g);
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            i += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = this.f2287t.getLayoutParams();
        float m2339a = C1405c.m2339a(getContext());
        layoutParams.height = Double.valueOf(Math.max(Math.min(this.f2285r + i + this.f2284q, 0.9f * m2339a), m2339a * 0.5f)).intValue();
        this.f2287t.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public String m2335a() {
        if (this.f2283p != null) {
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("getTBSPickedDefaultBrowser: ");
            SharedPreferences sharedPreferences = this.f2283p;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("key_tbs_picked_default_browser_");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f2280m);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(sharedPreferences.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString(), null));
            TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
            SharedPreferences sharedPreferences2 = this.f2283p;
            StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("key_tbs_picked_default_browser_");
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.f2280m);
            return sharedPreferences2.getString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString(), null);
        }
        return null;
    }

    /* renamed from: a */
    public void m2329a(String str) {
        SharedPreferences.Editor putString;
        TbsLog.m2155i("TBSActivityPicker", "setTBSPickedDefaultBrowser:" + str);
        if (this.f2283p != null) {
            if (TextUtils.isEmpty(str)) {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("paramString empty, remove: key_tbs_picked_default_browser_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.f2280m);
                TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                SharedPreferences.Editor edit = this.f2283p.edit();
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("key_tbs_picked_default_browser_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(this.f2280m);
                putString = edit.remove(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
            } else {
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("paramString not empty, set: key_tbs_picked_default_browser_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.f2280m);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append("=");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(str);
                TbsLog.m2155i("TBSActivityPicker", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                SharedPreferences.Editor edit2 = this.f2283p.edit();
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("key_tbs_picked_default_browser_");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.append(this.f2280m);
                putString = edit2.putString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.toString(), str);
            }
            putString.commit();
        }
    }

    /* renamed from: a */
    public void m2328a(boolean z) {
        Button button = this.f2276i;
        if (button != null) {
            button.setEnabled(z);
        }
        Button button2 = this.f2275h;
        if (button2 != null) {
            button2.setEnabled(z);
        }
        m2325b("userMenuClickEvent:");
    }

    /* renamed from: b */
    public void m2327b() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.horizontalMargin = 0.0f;
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
        }
        setContentView(m2334a(getContext()));
        m2321d();
        this.f2275h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1404b m2365a = DialogC1406d.this.f2279l.m2365a();
                ResolveInfo m2358a = DialogC1406d.this.f2279l.m2358a(m2365a);
                DialogC1406d.this.m2325b("userClickAlwaysEvent:");
                if (m2365a == null) {
                    return;
                }
                if (m2365a.m2343e()) {
                    String m2341g = m2365a.m2341g();
                    if (DialogC1406d.f2268a.get() != null) {
                        DialogC1406d.f2268a.get().onReceiveValue("extraMenuEvent:" + m2341g);
                    }
                    DialogC1406d dialogC1406d = DialogC1406d.this;
                    dialogC1406d.m2329a("extraMenuEvent:" + m2341g);
                } else if (m2358a == null) {
                    DialogC1406d.this.m2333a(m2365a);
                } else {
                    Intent intent = DialogC1406d.this.f2282o;
                    Context context = DialogC1406d.this.getContext();
                    String str = m2358a.activityInfo.packageName;
                    intent.setPackage(str);
                    if (TbsConfig.APP_QB.equals(str)) {
                        intent.putExtra("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName());
                        intent.putExtra("PosID", "4");
                    }
                    if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                    }
                    if (!TextUtils.isEmpty(DialogC1406d.this.f2281n)) {
                        intent.putExtra("big_brother_source_key", DialogC1406d.this.f2281n);
                    }
                    try {
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (DialogC1406d.f2268a.get() != null) {
                        DialogC1406d.f2268a.get().onReceiveValue("always");
                    }
                    DialogC1406d.this.m2329a(str);
                }
                DialogC1406d.this.dismiss();
            }
        });
        this.f2276i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.smtt.sdk.ui.dialog.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1404b m2365a = DialogC1406d.this.f2279l.m2365a();
                ResolveInfo m2358a = DialogC1406d.this.f2279l.m2358a(m2365a);
                DialogC1406d.this.m2325b("userClickOnceEvent:");
                DialogC1406d.this.m2329a("");
                if (m2365a == null) {
                    return;
                }
                if (!m2365a.m2343e()) {
                    if (m2358a == null) {
                        DialogC1406d.this.m2333a(m2365a);
                    } else {
                        Intent intent = DialogC1406d.this.f2282o;
                        Context context = DialogC1406d.this.getContext();
                        String str = m2358a.activityInfo.packageName;
                        intent.setPackage(str);
                        if (TbsConfig.APP_QB.equals(str)) {
                            intent.putExtra("ChannelID", StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName());
                            intent.putExtra("PosID", "4");
                        }
                        if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                            intent.addFlags(1);
                        }
                        if (!TextUtils.isEmpty(DialogC1406d.this.f2281n)) {
                            intent.putExtra("big_brother_source_key", DialogC1406d.this.f2281n);
                        }
                        try {
                            context.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (DialogC1406d.f2268a.get() != null) {
                            DialogC1406d.f2268a.get().onReceiveValue("once");
                        }
                    }
                } else if (DialogC1406d.this.m2324c() && DialogC1406d.f2268a.get() != null) {
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("extraMenuEvent:");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(m2365a.m2341g());
                    DialogC1406d.f2268a.get().onReceiveValue(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString());
                }
                DialogC1406d.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        m2327b();
    }
}
