package com.tencent.bugly.beta.p041ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.View$OnClickListenerC1090b;
import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.beta.ui.j */
/* loaded from: classes3.dex */
public class C1113j extends AbstractC1105d {

    /* renamed from: n */
    public DownloadTask f836n;

    /* renamed from: o */
    public TextView f837o;

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1106e
    /* renamed from: a */
    public boolean mo3583a(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1105d, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f817m = C1093e.f737b.f780m;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f817m == 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            TextView textView = new TextView(this.f806b);
            this.f837o = textView;
            textView.setLayoutParams(layoutParams);
            TextView textView2 = this.f837o;
            this.f815k.getClass();
            textView2.setTextColor(Color.parseColor("#757575"));
            this.f837o.setTextSize(16.0f);
            this.f837o.setTag(Beta.TAG_TIP_MESSAGE);
            this.f814j.addView(this.f837o);
        } else if (onCreateView != null) {
            this.f837o = (TextView) onCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.f837o.setText(Beta.strNetworkTipsMessage);
            this.f811g.setText(Beta.strNetworkTipsTitle);
            m3596a(Beta.strNetworkTipsCancelBtn, new View$OnClickListenerC1090b(2, this), Beta.strNetworkTipsConfirmBtn, new View$OnClickListenerC1090b(3, this, this.f836n));
        } catch (Exception e) {
            if (this.f817m != 0) {
                C1199X.m3081b("please confirm your argument: [Beta.tipsDialogLayoutId] is correct", new Object[0]);
            }
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
        }
        return onCreateView;
    }

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1105d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f837o = null;
    }
}
