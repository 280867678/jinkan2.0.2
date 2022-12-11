package com.tencent.bugly.beta.p041ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.bugly.beta.global.C1089a;
import com.tencent.bugly.beta.global.C1093e;
import com.tencent.bugly.beta.global.View$OnTouchListenerC1091c;
import com.tencent.bugly.proguard.C1199X;
import me.tvspark.outline;

/* renamed from: com.tencent.bugly.beta.ui.g */
/* loaded from: classes3.dex */
public class ViewTreeObserver$OnPreDrawListenerC1108g implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a */
    public final int f830a;

    /* renamed from: b */
    public final Object[] f831b;

    /* renamed from: c */
    public long f832c;

    /* renamed from: d */
    public StringBuilder f833d = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("loading");

    public ViewTreeObserver$OnPreDrawListenerC1108g(int i, Object... objArr) {
        this.f830a = i;
        this.f831b = objArr;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        int i;
        int i2;
        try {
            int i3 = this.f830a;
            if (i3 == 1) {
                C1115l c1115l = (C1115l) this.f831b[0];
                TextView textView = (TextView) this.f831b[1];
                Bitmap bitmap = (Bitmap) this.f831b[2];
                int intValue = ((Integer) this.f831b[3]).intValue();
                int measuredWidth = textView.getMeasuredWidth();
                int i4 = (int) (measuredWidth * 0.42857142857142855d);
                textView.setHeight(i4);
                if (c1115l.f854w == null) {
                    c1115l.f854w = intValue == 2 ? C1089a.m3621a(bitmap, measuredWidth, i4, C1089a.m3625a(C1093e.f737b.f789v, 6.0f)) : C1089a.m3621a(bitmap, measuredWidth, i4, C1089a.m3625a(C1093e.f737b.f789v, 0.0f));
                    if (c1115l.f854w != null) {
                        textView.setText("");
                        textView.setBackgroundDrawable(c1115l.f854w);
                        textView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f832c <= 300) {
                    return true;
                }
                this.f832c = currentTimeMillis;
                if (this.f833d.length() > 9) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("loading");
                    this.f833d = sb;
                } else {
                    this.f833d.append(".");
                }
                textView.setText(this.f833d.toString());
                return true;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                ViewGroup viewGroup = (ViewGroup) this.f831b[0];
                if (viewGroup.getMeasuredHeight() > C1089a.m3625a((Context) this.f831b[1], 158.0f)) {
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    layoutParams.height = C1089a.m3625a((Context) this.f831b[1], 200.0f);
                    viewGroup.setLayoutParams(layoutParams);
                }
                return true;
            } else if (((Integer) this.f831b[2]).intValue() <= 0) {
                return true;
            } else {
                int intValue2 = ((Integer) this.f831b[0]).intValue();
                TextView textView2 = (TextView) this.f831b[1];
                int measuredWidth2 = textView2.getMeasuredWidth();
                int measuredHeight = textView2.getMeasuredHeight();
                int i5 = (int) (C1093e.f737b.f742E.widthPixels * C1093e.f737b.f742E.heightPixels * 0.4f);
                if (measuredWidth2 == 0 || measuredHeight == 0 || measuredWidth2 * measuredHeight > i5) {
                    return true;
                }
                this.f831b[2] = 0;
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                if (intValue2 == 2) {
                    i = 8;
                    i2 = 7;
                } else {
                    i = 0;
                    i2 = 0;
                }
                paint.setColor(-3355444);
                Bitmap createBitmap = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                float f = measuredWidth2;
                float f2 = measuredHeight;
                RectF rectF = new RectF(0.0f, 0.0f, f, f2);
                float f3 = i;
                canvas.drawRoundRect(rectF, f3, f3, paint);
                paint.setColor(-1);
                float f4 = i2;
                canvas.drawRoundRect(new RectF(2.0f, 2.0f, f - 2.0f, f2 - 2.0f), f4, f4, paint);
                paint.setColor(-3355444);
                Bitmap createBitmap2 = Bitmap.createBitmap(measuredWidth2, measuredHeight, Bitmap.Config.ARGB_8888);
                new Canvas(createBitmap2).drawRoundRect(rectF, f3, f3, paint);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(createBitmap2);
                textView2.setBackgroundDrawable(bitmapDrawable);
                textView2.setOnTouchListener(new View$OnTouchListenerC1091c(1, bitmapDrawable2, bitmapDrawable));
                return true;
            }
        } catch (Exception e) {
            if (!C1199X.m3083a(e)) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
