package me.tvspark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.mj */
/* loaded from: classes4.dex */
public final class C2372mj {
    public Rect Kkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public int Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public StaticLayout Www;
    public StaticLayout Wwww;
    public int Wwwww;
    public int Wwwwww;
    public int Wwwwwww;
    public int Wwwwwwww;
    public float Wwwwwwwww;
    public float Wwwwwwwwww;
    public float Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public int Wwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Bitmap Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Layout.Alignment Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public CharSequence Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final TextPaint Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2372mj(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = round;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = round;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = round;
        TextPaint textPaint = new TextPaint();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = textPaint;
        textPaint.setAntiAlias(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setSubpixelText(true);
        Paint paint = new Paint();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
        paint.setAntiAlias(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = paint2;
        paint2.setAntiAlias(true);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.setFilterBitmap(true);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas, boolean z) {
        if (z) {
            StaticLayout staticLayout = this.Wwww;
            StaticLayout staticLayout2 = this.Www;
            if (staticLayout == null || staticLayout2 == null) {
                return;
            }
            int save = canvas.save();
            canvas.translate(this.Kkkkkkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            if (Color.alpha(this.Wwwwwwwwwwwwww) > 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwww);
                canvas.drawRect(-this.Kkkkkkkkkkkkkkkkkkkkkkkk, 0.0f, staticLayout.getWidth() + this.Kkkkkkkkkkkkkkkkkkkkkkkk, staticLayout.getHeight(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            int i = this.Wwwwwwwwwwww;
            boolean z2 = true;
            if (i == 1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStrokeJoin(Paint.Join.ROUND);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStrokeWidth(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStyle(Paint.Style.FILL_AND_STROKE);
                staticLayout2.draw(canvas);
            } else if (i == 2) {
                TextPaint textPaint = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float f = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                textPaint.setShadowLayer(f, f2, f2, this.Wwwwwwwwwwwww);
            } else if (i == 3 || i == 4) {
                if (this.Wwwwwwwwwwww != 3) {
                    z2 = false;
                }
                int i2 = -1;
                int i3 = z2 ? -1 : this.Wwwwwwwwwwwww;
                if (z2) {
                    i2 = this.Wwwwwwwwwwwww;
                }
                float f3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 2.0f;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStyle(Paint.Style.FILL);
                float f4 = -f3;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setShadowLayer(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f4, f4, i3);
                staticLayout2.draw(canvas);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setShadowLayer(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, f3, f3, i2);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setStyle(Paint.Style.FILL);
            staticLayout.draw(canvas);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            canvas.restoreToCount(save);
            return;
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww);
        canvas.drawBitmap(this.Wwwwwwwwwwwwwwwwwwwwwwww, (Rect) null, this.Kkkkkkkkkkkkkkkkkkkkkkk, this.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
