package com.tencent.smtt.sdk.p045ui.dialog.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.smtt.sdk.p045ui.dialog.C1405c;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.widget.RoundImageView */
/* loaded from: classes4.dex */
public class RoundImageView extends ImageView {

    /* renamed from: a */
    public Paint f2294a;

    /* renamed from: b */
    public Xfermode f2295b;

    /* renamed from: c */
    public Bitmap f2296c;

    /* renamed from: d */
    public float[] f2297d;

    /* renamed from: e */
    public RectF f2298e;

    /* renamed from: f */
    public int f2299f;

    /* renamed from: g */
    public WeakReference<Bitmap> f2300g;

    /* renamed from: h */
    public float f2301h;

    /* renamed from: i */
    public Path f2302i;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2295b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f2299f = Color.parseColor("#eaeaea");
        Paint paint = new Paint();
        this.f2294a = paint;
        paint.setAntiAlias(true);
        this.f2302i = new Path();
        this.f2297d = new float[8];
        this.f2298e = new RectF();
        this.f2301h = C1405c.m2338a(context, 16.46f);
        int i = 0;
        while (true) {
            float[] fArr = this.f2297d;
            if (i < fArr.length) {
                fArr[i] = this.f2301h;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private Bitmap m2314a() {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f2301h, this.f2301h, paint);
            return bitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    /* renamed from: a */
    private void m2313a(int i, int i2) {
        this.f2302i.reset();
        this.f2294a.setStrokeWidth(i);
        this.f2294a.setColor(i2);
        this.f2294a.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    private void m2312a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        m2313a(i, i2);
        this.f2302i.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.f2302i, this.f2294a);
    }

    @Override // android.view.View
    public void invalidate() {
        this.f2300g = null;
        Bitmap bitmap = this.f2296c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f2296c = null;
        }
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        WeakReference<Bitmap> weakReference = this.f2300g;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f = intrinsicWidth;
                float f2 = intrinsicHeight;
                float max = Math.max((getWidth() * 1.0f) / f, (getHeight() * 1.0f) / f2);
                drawable.setBounds(0, 0, (int) (f * max), (int) (max * f2));
                drawable.draw(canvas2);
                Bitmap bitmap2 = this.f2296c;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    this.f2296c = m2314a();
                }
                this.f2294a.reset();
                this.f2294a.setFilterBitmap(false);
                this.f2294a.setXfermode(this.f2295b);
                Bitmap bitmap3 = this.f2296c;
                if (bitmap3 != null) {
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, this.f2294a);
                }
                this.f2294a.setXfermode(null);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                this.f2300g = new WeakReference<>(createBitmap);
            }
        } else {
            this.f2294a.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f2294a);
        }
        m2312a(canvas, 1, this.f2299f, this.f2298e, this.f2297d);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2298e.set(0.5f, 0.5f, i - 0.5f, i2 - 0.5f);
    }
}
