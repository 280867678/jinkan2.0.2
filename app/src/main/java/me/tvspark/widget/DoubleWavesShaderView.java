package me.tvspark.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import me.tvspark.R$styleable;
import white.whale.R;

/* loaded from: classes4.dex */
public class DoubleWavesShaderView extends View {
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwww;
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwww;

    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public ObjectAnimator Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Matrix Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix();
        public BitmapShader Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Paint Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, Bitmap bitmap, int i, int i2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bitmap;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new BitmapShader(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = paint;
            paint.setShader(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setAntiAlias(true);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            new WeakReference(view);
            if (i2 != 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setColorFilter(new LightingColorFilter(50331647, i2));
            }
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ObjectAnimator objectAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            ObjectAnimator objectAnimator = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "wavePos", 0, 1920);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ofInt;
            ofInt.setInterpolator(new LinearInterpolator());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setDuration(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setRepeatMode(1);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setRepeatCount(-1);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
        }

        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setTranslate(0, 0.0f);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setLocalMatrix(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.drawRect(0.0f, 0.0f, 1920.0f, canvas.getHeight(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    public DoubleWavesShaderView(Context context) {
        super(context);
        if (isInEditMode()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, null);
    }

    public DoubleWavesShaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet);
    }

    public DoubleWavesShaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, attributeSet);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DoubleWavesView);
        int color = obtainStyledAttributes.getColor(4, 0);
        int color2 = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pic_wave_tt);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Bitmap.createBitmap(decodeResource, 0, 0, 1920, (int) TbsListener.ErrorCode.TPATCH_VERSION_FAILED), 20000, color2);
        this.Wwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this, Bitmap.createBitmap(decodeResource, 0, (int) TbsListener.ErrorCode.TPATCH_VERSION_FAILED, 1920, (int) TbsListener.ErrorCode.TPATCH_VERSION_FAILED), 40000, color);
        decodeResource.recycle();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (isInEditMode()) {
            return;
        }
        if (i == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
