package me.tvspark;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* renamed from: me.tvspark.qr */
/* loaded from: classes4.dex */
public class C2534qr extends MaterialShapeDrawable {
    public int Kkkkkkkkkkkkkkkkkkkkkk;
    @NonNull
    public final RectF Kkkkkkkkkkkkkkkkkkkkkkk;
    @NonNull
    public final Paint Kkkkkkkkkkkkkkkkkkkkkkkk;

    public C2534qr() {
        this(null);
    }

    public C2534qr(@Nullable C2416nq c2416nq) {
        super(c2416nq == null ? new C2416nq() : c2416nq);
        Paint paint = new Paint(1);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk.setColor(-1);
        this.Kkkkkkkkkkkkkkkkkkkkkkkk.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.Kkkkkkkkkkkkkkkkkkkkkkk = new RectF();
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4) {
        RectF rectF = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.Kkkkkkkkkkkkkkkkkkkkkkk.set(f, f2, f3, f4);
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
            }
        } else {
            this.Kkkkkkkkkkkkkkkkkkkkkk = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        }
        super.draw(canvas);
        canvas.drawRect(this.Kkkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkkkkk);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.Kkkkkkkkkkkkkkkkkkkkkk);
        }
    }
}
