package com.tencent.bugly.beta.p041ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.C1085a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.C1094f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC1092d;
import com.tencent.bugly.beta.global.View$OnClickListenerC1090b;
import com.tencent.bugly.beta.utils.C1125e;
import com.tencent.bugly.proguard.C1177B;
import com.tencent.bugly.proguard.C1199X;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.bugly.beta.ui.l */
/* loaded from: classes3.dex */
public class C1115l extends AbstractC1105d {

    /* renamed from: n */
    public static C1115l f842n = new C1115l();

    /* renamed from: o */
    public TextView f846o;

    /* renamed from: p */
    public TextView f847p;

    /* renamed from: r */
    public C1177B f849r;

    /* renamed from: s */
    public DownloadTask f850s;

    /* renamed from: t */
    public Runnable f851t;

    /* renamed from: u */
    public Runnable f852u;

    /* renamed from: w */
    public BitmapDrawable f854w;

    /* renamed from: x */
    public UILifecycleListener f855x;

    /* renamed from: q */
    public ViewTreeObserver$OnPreDrawListenerC1108g f848q = null;

    /* renamed from: v */
    public Bitmap f853v = null;

    /* renamed from: y */
    public View.OnClickListener f856y = new View$OnClickListenerC1090b(9, this);

    /* renamed from: z */
    public View.OnClickListener f857z = new View$OnClickListenerC1090b(4, this);

    /* renamed from: A */
    public View.OnClickListener f843A = new View$OnClickListenerC1090b(5, this);

    /* renamed from: B */
    public View.OnClickListener f844B = new View$OnClickListenerC1090b(6, this);

    /* renamed from: C */
    public DownloadListener f845C = new C1085a(2, this);

    /* JADX WARN: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3582a(DownloadTask downloadTask) {
        String str;
        View.OnClickListener onClickListener;
        int status = downloadTask.getStatus();
        if (status != 0) {
            if (status == 1) {
                str = Beta.strUpgradeDialogInstallBtn;
                onClickListener = this.f856y;
            } else if (status != 2) {
                if (status == 3) {
                    str = Beta.strUpgradeDialogContinueBtn;
                } else if (status != 4) {
                    if (status != 5) {
                        str = "";
                        onClickListener = null;
                    } else {
                        str = Beta.strUpgradeDialogRetryBtn;
                    }
                }
                onClickListener = this.f857z;
            } else {
                str = String.format(Locale.getDefault(), "%.1f%%", Float.valueOf((((float) downloadTask.getSavedLength()) / ((float) downloadTask.getTotalLength())) * 100.0f));
                if (str.equals("NaN%")) {
                    str = "0%";
                }
                onClickListener = this.f843A;
            }
            if (this.f849r.f1334l == 2) {
                m3596a(Beta.strUpgradeDialogCancelBtn, this.f844B, str, onClickListener);
                return;
            } else {
                m3596a(null, null, str, onClickListener);
                return;
            }
        }
        str = Beta.strUpgradeDialogUpgradeBtn;
        onClickListener = this.f857z;
        if (this.f849r.f1334l == 2) {
        }
    }

    /* renamed from: a */
    public synchronized void m3581a(C1177B c1177b, DownloadTask downloadTask) {
        this.f849r = c1177b;
        this.f850s = downloadTask;
        downloadTask.addListener(this.f845C);
        C1125e.m3490a(new RunnableC1092d(7, this));
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1106e
    /* renamed from: a */
    public boolean mo3583a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f849r.f1334l == 2) {
                return true;
            }
            Runnable runnable = this.f852u;
            if (runnable != null) {
                runnable.run();
            }
            mo3595a();
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public synchronized void m3580c() {
        String str;
        try {
        } catch (Exception e) {
            if (this.f817m != 0) {
                C1199X.m3081b("please confirm your argument: [Beta.upgradeDialogLayoutId] is correct", new Object[0]);
            }
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
        if (this.f807c != null && this.f849r != null && this.f850s != null) {
            Bitmap bitmap = null;
            if (this.f817m != 0) {
                this.f811g.setText(this.f849r.f1328f);
                if (this.f810f != null) {
                    this.f810f.setAdjustViewBounds(true);
                    if (this.f816l != 0) {
                        Context context = this.f806b;
                        Object[] objArr = new Object[1];
                        objArr[0] = this.f815k.m3628a("IMG_title");
                        Bitmap m3624a = C1089a.m3624a(context, 0, objArr);
                        this.f853v = m3624a;
                        this.f854w = null;
                        if (m3624a != null) {
                            bitmap = m3624a;
                        } else if (C1093e.f737b.f778k != 0) {
                            bitmap = C1089a.m3624a(this.f806b, 1, Integer.valueOf(C1093e.f737b.f778k));
                        }
                        this.f810f.setImageBitmap(bitmap);
                    }
                }
            } else if (this.f816l != 0) {
                Context context2 = this.f806b;
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.f815k.m3628a("IMG_title");
                Bitmap m3624a2 = C1089a.m3624a(context2, 0, objArr2);
                this.f853v = m3624a2;
                this.f854w = null;
                if (m3624a2 != null) {
                    bitmap = m3624a2;
                } else if (C1093e.f737b.f778k != 0) {
                    bitmap = C1089a.m3624a(this.f806b, 1, Integer.valueOf(C1093e.f737b.f778k));
                }
                this.f811g.getViewTreeObserver().removeOnPreDrawListener(this.f848q);
                this.f848q = new ViewTreeObserver$OnPreDrawListenerC1108g(1, this, this.f811g, bitmap, Integer.valueOf(this.f816l));
                this.f811g.getViewTreeObserver().addOnPreDrawListener(this.f848q);
            } else {
                this.f811g.setHeight(C1089a.m3625a(this.f806b, 42.0f));
                this.f811g.setText(this.f849r.f1328f);
            }
            this.f847p.setText(this.f849r.f1329g.length() > 500 ? this.f849r.f1329g.substring(0, 500) : this.f849r.f1329g);
            if (C1093e.f737b.f760W) {
                StringBuilder sb = new StringBuilder();
                sb.append(Beta.strUpgradeDialogVersionLabel);
                sb.append(": ");
                sb.append(this.f849r.f1332j.f1671e);
                sb.append("\n");
                sb.append(Beta.strUpgradeDialogFileSizeLabel);
                sb.append(": ");
                float f = (float) this.f849r.f1333k.f1665e;
                if (f >= 1048576.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f / 1048576.0f)));
                    str = "M";
                } else if (f >= 1024.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f / 1024.0f)));
                    str = "K";
                } else {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f)));
                    str = "B";
                }
                sb.append(str);
                sb.append("\n");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                sb.append(Beta.strUpgradeDialogUpdateTimeLabel);
                sb.append(": ");
                sb.append(simpleDateFormat.format(new Date(this.f849r.f1342t)));
                this.f846o.setText(sb);
            }
            m3582a(this.f850s);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1093e c1093e = C1093e.f737b;
        this.f817m = c1093e.f779l;
        this.f855x = c1093e.f781n;
        try {
            this.f816l = Integer.parseInt(ResBean.f725a.m3628a("VAL_style"));
        } catch (Exception e) {
            C1199X.m3078c(e.getMessage(), new Object[0]);
            this.f816l = 0;
        }
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1105d, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f817m != 0) {
            this.f846o = (TextView) onCreateView.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.f847p = (TextView) onCreateView.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.f806b);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ResBean resBean = ResBean.f725a;
            if (C1093e.f737b.f760W) {
                TextView textView = new TextView(this.f806b);
                this.f846o = textView;
                textView.setLayoutParams(layoutParams2);
                TextView textView2 = this.f846o;
                resBean.getClass();
                textView2.setTextColor(Color.parseColor("#757575"));
                this.f846o.setTextSize(14);
                this.f846o.setTag(Beta.TAG_UPGRADE_INFO);
                this.f846o.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.f846o);
            }
            TextView textView3 = new TextView(this.f806b);
            textView3.setLayoutParams(layoutParams2);
            resBean.getClass();
            textView3.setTextColor(Color.parseColor("#273238"));
            float f = 14;
            textView3.setTextSize(f);
            textView3.setSingleLine();
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setText(String.valueOf(Beta.strUpgradeDialogFeatureLabel + ": "));
            textView3.setPadding(0, C1089a.m3625a(this.f806b, 8.0f), 0, 0);
            linearLayout.addView(textView3);
            TextView textView4 = new TextView(this.f806b);
            this.f847p = textView4;
            textView4.setLayoutParams(layoutParams2);
            TextView textView5 = this.f847p;
            resBean.getClass();
            textView5.setTextColor(Color.parseColor("#273238"));
            this.f847p.setTextSize(f);
            this.f847p.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.f847p.setMaxHeight(C1089a.m3625a(this.f806b, 200.0f));
            this.f847p.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.f847p);
            this.f814j.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.f855x;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            C1177B c1177b = this.f849r;
            uILifecycleListener.onCreate(activity, onCreateView, c1177b != null ? new UpgradeInfo(c1177b) : null);
        }
        return onCreateView;
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1105d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            UpgradeInfo upgradeInfo = null;
            this.f846o = null;
            this.f847p = null;
            synchronized (this) {
                this.f848q = null;
            }
            if (this.f854w != null) {
                this.f854w.setCallback(null);
            }
            if (this.f855x == null) {
                return;
            }
            UILifecycleListener uILifecycleListener = this.f855x;
            Context context = this.f806b;
            View view = this.f807c;
            if (this.f849r != null) {
                upgradeInfo = new UpgradeInfo(this.f849r);
            }
            uILifecycleListener.onDestroy(context, view, upgradeInfo);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1106e, androidx.fragment.app.Fragment
    public void onPause() {
        DownloadTask downloadTask;
        super.onPause();
        DownloadListener downloadListener = this.f845C;
        if (downloadListener != null && (downloadTask = this.f850s) != null) {
            downloadTask.removeListener(downloadListener);
        }
        UILifecycleListener uILifecycleListener = this.f855x;
        if (uILifecycleListener != null) {
            Context context = this.f806b;
            View view = this.f807c;
            C1177B c1177b = this.f849r;
            uILifecycleListener.onPause(context, view, c1177b != null ? new UpgradeInfo(c1177b) : null);
        }
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1106e, androidx.fragment.app.Fragment
    public void onResume() {
        DownloadTask downloadTask;
        super.onResume();
        DownloadListener downloadListener = this.f845C;
        if (downloadListener != null && (downloadTask = this.f850s) != null) {
            downloadTask.addListener(downloadListener);
        }
        m3580c();
        if (this.f816l != 0 && this.f853v == null) {
            C1094f.f794a.m3605a(new RunnableC1092d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.f855x;
        if (uILifecycleListener != null) {
            Context context = this.f806b;
            View view = this.f807c;
            C1177B c1177b = this.f849r;
            uILifecycleListener.onResume(context, view, c1177b != null ? new UpgradeInfo(c1177b) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.f855x;
        if (uILifecycleListener != null) {
            Context context = this.f806b;
            View view = this.f807c;
            C1177B c1177b = this.f849r;
            uILifecycleListener.onStart(context, view, c1177b != null ? new UpgradeInfo(c1177b) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.f855x;
        if (uILifecycleListener != null) {
            Context context = this.f806b;
            View view = this.f807c;
            C1177B c1177b = this.f849r;
            uILifecycleListener.onStop(context, view, c1177b != null ? new UpgradeInfo(c1177b) : null);
        }
    }
}
