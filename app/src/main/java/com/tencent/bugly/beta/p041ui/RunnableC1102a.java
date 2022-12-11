package com.tencent.bugly.beta.p041ui;

import android.view.View;
import android.widget.TextView;

/* renamed from: com.tencent.bugly.beta.ui.a */
/* loaded from: classes3.dex */
public class RunnableC1102a implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ String f798a;

    /* renamed from: b */
    public final /* synthetic */ View.OnClickListener f799b;

    /* renamed from: c */
    public final /* synthetic */ String f800c;

    /* renamed from: d */
    public final /* synthetic */ View.OnClickListener f801d;

    /* renamed from: e */
    public final /* synthetic */ AbstractC1105d f802e;

    public RunnableC1102a(AbstractC1105d abstractC1105d, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2) {
        this.f802e = abstractC1105d;
        this.f798a = str;
        this.f799b = onClickListener;
        this.f800c = str2;
        this.f801d = onClickListener2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC1105d abstractC1105d = this.f802e;
        TextView textView = abstractC1105d.f812h;
        if (textView == null || abstractC1105d.f813i == null) {
            return;
        }
        if (this.f798a != null) {
            textView.setVisibility(0);
            AbstractC1105d abstractC1105d2 = this.f802e;
            if (abstractC1105d2.f816l != 2) {
                abstractC1105d2.f812h.setText(this.f798a);
                AbstractC1105d abstractC1105d3 = this.f802e;
                if (abstractC1105d3.f817m == 0) {
                    abstractC1105d3.f812h.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC1108g(2, Integer.valueOf(this.f802e.f816l), this.f802e.f812h, 1));
                }
            }
            this.f802e.f812h.setOnClickListener(this.f799b);
        }
        if (this.f800c == null) {
            return;
        }
        this.f802e.f813i.setVisibility(0);
        this.f802e.f813i.setText(this.f800c);
        this.f802e.f813i.setOnClickListener(this.f801d);
        AbstractC1105d abstractC1105d4 = this.f802e;
        if (abstractC1105d4.f817m == 0) {
            abstractC1105d4.f813i.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC1108g(2, Integer.valueOf(this.f802e.f816l), this.f802e.f813i, 1));
        }
        this.f802e.f813i.requestFocus();
    }
}
