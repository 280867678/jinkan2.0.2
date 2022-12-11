package com.tencent.bugly.beta.p041ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.View$OnTouchListenerC1091c;
import com.tencent.bugly.beta.utils.C1125e;

/* renamed from: com.tencent.bugly.beta.ui.d */
/* loaded from: classes3.dex */
public abstract class AbstractC1105d extends AbstractC1106e {

    /* renamed from: b */
    public Context f806b;

    /* renamed from: c */
    public View f807c;

    /* renamed from: d */
    public FrameLayout f808d;

    /* renamed from: e */
    public LinearLayout f809e;

    /* renamed from: f */
    public ImageView f810f;

    /* renamed from: g */
    public TextView f811g;

    /* renamed from: h */
    public TextView f812h;

    /* renamed from: i */
    public TextView f813i;

    /* renamed from: j */
    public LinearLayout f814j;

    /* renamed from: k */
    public ResBean f815k;

    /* renamed from: l */
    public int f816l;

    /* renamed from: m */
    public int f817m;

    @Override // com.tencent.bugly.beta.p041ui.AbstractC1106e
    /* renamed from: a */
    public void mo3595a() {
        if (this.f807c == null) {
            super.mo3595a();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        C1125e.m3490a(new RunnableC1103b(this, alphaAnimation));
        alphaAnimation.setAnimationListener(new animationAnimation$AnimationListenerC1104c(this));
    }

    /* renamed from: a */
    public void m3596a(String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2) {
        C1125e.m3490a(new RunnableC1102a(this, str, onClickListener, str2, onClickListener2));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f806b = getActivity();
        this.f815k = ResBean.f725a;
        int i = this.f817m;
        if (i == 0) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f806b);
            this.f807c = relativeLayout;
            relativeLayout.setGravity(17);
            this.f807c.setBackgroundColor(Color.argb(100, 0, 0, 0));
            this.f808d = new FrameLayout(this.f806b);
            this.f808d.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            LinearLayout linearLayout = new LinearLayout(this.f806b);
            this.f809e = linearLayout;
            linearLayout.setBackgroundColor(-1);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.f809e.setGravity(17);
            this.f809e.setLayoutParams(layoutParams);
            this.f809e.setMinimumWidth(C1089a.m3625a(this.f806b, 280.0f));
            this.f809e.setOrientation(1);
            if (this.f816l == 2) {
                float m3625a = C1089a.m3625a(this.f806b, 6.0f);
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{m3625a, m3625a, m3625a, m3625a, m3625a, m3625a, m3625a, m3625a}, null, null));
                shapeDrawable.getPaint().setColor(-1);
                shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
                this.f809e.setBackgroundDrawable(shapeDrawable);
            }
            TextView textView = new TextView(this.f806b);
            this.f811g = textView;
            textView.setGravity(16);
            this.f811g.setSingleLine();
            TextView textView2 = this.f811g;
            this.f815k.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            this.f811g.setTextSize(18.0f);
            this.f811g.setLayoutParams(layoutParams);
            this.f811g.setOnClickListener(null);
            this.f811g.setEllipsize(TextUtils.TruncateAt.END);
            int m3625a2 = C1089a.m3625a(this.f806b, 16.0f);
            this.f811g.setPadding(m3625a2, 0, m3625a2, 0);
            this.f811g.setTypeface(null, 1);
            this.f811g.setHeight(C1089a.m3625a(this.f806b, 42.0f));
            this.f811g.setTag(Beta.TAG_TITLE);
            TextView textView3 = new TextView(this.f806b);
            textView3.setBackgroundColor(-3355444);
            textView3.setHeight(1);
            ScrollView scrollView = new ScrollView(this.f806b);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, 0, 0, C1089a.m3625a(this.f806b, 52.0f));
            scrollView.setLayoutParams(layoutParams2);
            scrollView.setFillViewport(true);
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.setHorizontalScrollBarEnabled(false);
            this.f814j = new LinearLayout(this.f806b);
            this.f814j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.f814j.setOrientation(1);
            this.f814j.setPadding(m3625a2, C1089a.m3625a(this.f806b, 10.0f), m3625a2, 0);
            LinearLayout linearLayout2 = new LinearLayout(this.f806b);
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setGravity(17);
            linearLayout2.setOrientation(0);
            int i2 = m3625a2 / 2;
            linearLayout2.setPadding(i2, m3625a2, i2, m3625a2);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            linearLayout2.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams4.setMargins(i2, 0, i2, 0);
            TextView textView4 = new TextView(this.f806b);
            this.f812h = textView4;
            textView4.setSingleLine();
            this.f812h.setGravity(17);
            this.f812h.setTag(Beta.TAG_CANCEL_BUTTON);
            new RelativeLayout.LayoutParams(-2, -2);
            int m3625a3 = C1089a.m3625a(this.f806b, 30.0f);
            if (this.f816l == 2) {
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(m3625a3, m3625a3);
                layoutParams5.gravity = 53;
                this.f812h.setLayoutParams(layoutParams5);
                this.f812h.setTextSize((float) (m3625a3 * 0.3d));
            } else {
                this.f812h.setLayoutParams(layoutParams4);
                this.f812h.setTextSize(16);
                TextView textView5 = this.f812h;
                this.f815k.getClass();
                textView5.setTextColor(Color.parseColor("#757575"));
                this.f812h.setPadding(C1089a.m3625a(this.f806b, 10.0f), C1089a.m3625a(this.f806b, 5.0f), C1089a.m3625a(this.f806b, 10.0f), C1089a.m3625a(this.f806b, 5.0f));
            }
            TextView textView6 = new TextView(this.f806b);
            this.f813i = textView6;
            textView6.setLayoutParams(layoutParams4);
            this.f813i.setGravity(17);
            this.f813i.setTextSize(16);
            TextView textView7 = this.f813i;
            this.f815k.getClass();
            textView7.setTextColor(Color.parseColor("#273238"));
            this.f813i.setSingleLine();
            this.f813i.setPadding(C1089a.m3625a(this.f806b, 10.0f), C1089a.m3625a(this.f806b, 5.0f), C1089a.m3625a(this.f806b, 10.0f), C1089a.m3625a(this.f806b, 5.0f));
            this.f813i.setTypeface(null, 1);
            this.f813i.setTag(Beta.TAG_CONFIRM_BUTTON);
            int m3625a4 = C1089a.m3625a(this.f806b, 40.0f);
            scrollView.addView(this.f814j);
            if (this.f816l == 2) {
                FrameLayout frameLayout = new FrameLayout(this.f806b);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                int i3 = m3625a3 / 2;
                int i4 = i3 - 5;
                this.f808d.setPadding(i3, i4, i4, i3);
                frameLayout.addView(this.f808d);
                frameLayout.addView(this.f812h);
                ((RelativeLayout) this.f807c).addView(frameLayout);
            } else {
                this.f807c.setPadding(m3625a4, m3625a4, m3625a4, m3625a4);
                ((RelativeLayout) this.f807c).addView(this.f808d);
                linearLayout2.addView(this.f812h);
            }
            this.f809e.addView(this.f811g);
            this.f809e.addView(textView3);
            this.f809e.addView(scrollView);
            this.f808d.addView(this.f809e);
            linearLayout2.addView(this.f813i);
            this.f808d.addView(linearLayout2);
            if (this.f816l == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                Bitmap createBitmap = Bitmap.createBitmap(m3625a3, m3625a3, Bitmap.Config.ARGB_8888);
                int i5 = m3625a3 / 2;
                Canvas canvas = new Canvas(createBitmap);
                paint.setColor(-3355444);
                float f = i5;
                canvas.drawCircle(f, f, f, paint);
                canvas.rotate(45.0f, f, f);
                paint.setColor(-7829368);
                int m3625a5 = C1089a.m3625a(this.f806b, 0.8f);
                float f2 = f * 0.4f;
                float f3 = i5 - m3625a5;
                float f4 = f * 1.6f;
                float f5 = i5 + m3625a5;
                canvas.drawRect(f2, f3, f4, f5, paint);
                canvas.drawRect(f3, f2, f5, f4, paint);
                canvas.rotate(-45.0f);
                Bitmap createBitmap2 = Bitmap.createBitmap(m3625a3, m3625a3, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                paint.setColor(-7829368);
                canvas2.drawCircle(f, f, f, paint);
                canvas2.rotate(45.0f, f, f);
                paint.setColor(-3355444);
                canvas2.drawRect(f2, f3, f4, f5, paint);
                canvas2.drawRect(f3, f2, f5, f4, paint);
                canvas2.rotate(-45.0f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                this.f812h.setBackgroundDrawable(bitmapDrawable);
                this.f812h.setOnTouchListener(new View$OnTouchListenerC1091c(1, bitmapDrawable2, bitmapDrawable));
            }
            this.f807c.setOnClickListener(null);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            this.f807c.startAnimation(alphaAnimation);
        } else {
            View inflate = layoutInflater.inflate(i, (ViewGroup) null);
            this.f807c = inflate;
            this.f810f = (ImageView) inflate.findViewWithTag(Beta.TAG_IMG_BANNER);
            this.f811g = (TextView) this.f807c.findViewWithTag(Beta.TAG_TITLE);
            this.f812h = (TextView) this.f807c.findViewWithTag(Beta.TAG_CANCEL_BUTTON);
            this.f813i = (TextView) this.f807c.findViewWithTag(Beta.TAG_CONFIRM_BUTTON);
        }
        this.f812h.setVisibility(8);
        this.f813i.setVisibility(8);
        this.f812h.setFocusable(true);
        this.f813i.setFocusable(true);
        this.f813i.requestFocus();
        return this.f807c;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f806b = null;
        this.f807c = null;
        this.f808d = null;
        this.f809e = null;
        this.f811g = null;
        this.f810f = null;
        this.f812h = null;
        this.f813i = null;
        this.f814j = null;
    }
}
