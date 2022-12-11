package me.tvspark.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes4.dex */
public class RoundImageView extends AppCompatImageView {
    public final RectF Wwwwwwwwwwwwwwwwwwwwwwww = new RectF();
    public float Wwwwwwwwwwwwwwwwwwwwwww = 6.0f;
    public final Paint Wwwwwwwwwwwwwwwwwwwwww = new Paint();
    public final Paint Wwwwwwwwwwwwwwwwwwwww = new Paint();

    public RoundImageView(Context context) {
        super(context);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww.setAntiAlias(true);
        this.Wwwwwwwwwwwwwwwwwwwwww.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.Wwwwwwwwwwwwwwwwwwwww.setAntiAlias(true);
        this.Wwwwwwwwwwwwwwwwwwwww.setColor(-1);
        this.Wwwwwwwwwwwwwwwwwwwwwww *= getResources().getDisplayMetrics().density;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.saveLayer(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, 31);
        RectF rectF = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        float f = this.Wwwwwwwwwwwwwwwwwwwwwww;
        canvas.drawRoundRect(rectF, f, f, this.Wwwwwwwwwwwwwwwwwwwww);
        canvas.saveLayer(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, 31);
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setRectAdius(float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwww = f;
        invalidate();
    }
}
