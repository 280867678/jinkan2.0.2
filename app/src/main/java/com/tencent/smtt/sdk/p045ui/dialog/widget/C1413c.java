package com.tencent.smtt.sdk.p045ui.dialog.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.widget.c */
/* loaded from: classes4.dex */
public class C1413c extends Drawable {

    /* renamed from: a */
    public float f2322a;

    /* renamed from: b */
    public float f2323b;

    /* renamed from: c */
    public float f2324c;

    /* renamed from: d */
    public float f2325d;

    /* renamed from: e */
    public Path f2326e;

    /* renamed from: f */
    public Paint f2327f;

    /* renamed from: g */
    public RectF f2328g = new RectF();

    public C1413c(int i, float f, float f2, float f3, float f4) {
        this.f2322a = f;
        this.f2323b = f2;
        this.f2325d = f3;
        this.f2324c = f4;
        Paint paint = new Paint();
        this.f2327f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2327f.setAntiAlias(true);
        this.f2327f.setColor(i);
    }

    /* renamed from: a */
    public void m2307a(int i, int i2) {
        RectF rectF = this.f2328g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i;
        rectF.bottom = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2326e == null) {
            this.f2326e = new Path();
        }
        this.f2326e.reset();
        Path path = this.f2326e;
        RectF rectF = this.f2328g;
        float f = this.f2322a;
        float f2 = this.f2323b;
        float f3 = this.f2325d;
        float f4 = this.f2324c;
        path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CCW);
        this.f2326e.close();
        canvas.drawPath(this.f2326e, this.f2327f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2327f.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2327f.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
