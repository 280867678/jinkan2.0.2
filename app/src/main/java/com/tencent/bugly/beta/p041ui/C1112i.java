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
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.View$OnClickListenerC1090b;
import com.tencent.bugly.proguard.C1199X;

/* renamed from: com.tencent.bugly.beta.ui.i */
/* loaded from: classes3.dex */
public class C1112i extends AbstractC1105d {

    /* renamed from: n */
    public TextView f835n;

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
            this.f835n = textView;
            textView.setLayoutParams(layoutParams);
            TextView textView2 = this.f835n;
            this.f815k.getClass();
            textView2.setTextColor(Color.parseColor("#757575"));
            this.f835n.setTextSize(16.0f);
            this.f835n.setTag(Beta.TAG_TIP_MESSAGE);
            this.f814j.addView(this.f835n);
        } else if (onCreateView != null) {
            this.f835n = (TextView) onCreateView.findViewWithTag(Beta.TAG_TIP_MESSAGE);
        }
        try {
            this.f835n.setText("检测到当前版本需要重启，是否重启应用？");
            this.f811g.setText("更新提示");
            m3596a("取消", new View$OnClickListenerC1090b(8, this), "重启应用", new View$OnClickListenerC1090b(7, this));
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
}
