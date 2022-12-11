package me.tvspark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class Kkkkkkkkkkkkkkkkkkkkkkkkkk extends Drawable {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -16777216;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;

    public Kkkkkkkkkkkkkkkkkkkkkkkkkk(Context context) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (int) ((2.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        Paint paint = new Paint();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setColor(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        Paint paint;
        Canvas canvas2;
        float f2;
        float f3;
        float f4;
        float f5;
        canvas.drawColor(0);
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 0) {
            RectF rectF = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f6 = rectF.bottom;
            if (i < f6) {
                int i2 = (int) ((f6 - i) / 2.0f);
                int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i3 != 0) {
                    if (i3 == 1) {
                        f4 = rectF.left;
                        float f7 = i2;
                        f5 = rectF.top + f7;
                        f = rectF.right;
                        f6 -= f7;
                    } else if (i3 != 2) {
                        return;
                    } else {
                        f4 = rectF.left;
                        f5 = rectF.top + (i2 * 2);
                        f = rectF.right;
                    }
                    canvas2 = canvas;
                    f2 = f4;
                    f3 = f5;
                    paint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                } else {
                    float f8 = rectF.left;
                    float f9 = rectF.top;
                    f = rectF.right;
                    f6 -= i2 * 2;
                    paint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    canvas2 = canvas;
                    f2 = f8;
                    f3 = f9;
                }
                canvas2.drawRect(f2, f3, f, f6, paint);
                return;
            }
        }
        canvas.drawRect(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColorFilter(colorFilter);
    }
}
