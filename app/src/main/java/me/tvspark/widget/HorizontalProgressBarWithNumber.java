package me.tvspark.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import me.tvspark.R$styleable;

/* loaded from: classes4.dex */
public class HorizontalProgressBarWithNumber extends ProgressBar {
    public boolean Wwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public Paint Wwwwwwwwwwwwwwwwwwwwwwww;

    public HorizontalProgressBarWithNumber(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressBarWithNumber(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwww = new Paint();
        this.Wwwwwwwwwwwwwwwwwwwwwww = -261935;
        this.Wwwwwwwwwwwwwwwwwwwwww = (int) TypedValue.applyDimension(2, 10, getResources().getDisplayMetrics());
        this.Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
        this.Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        this.Wwwwwwwwwwwwwwwwwww = -261935;
        this.Wwwwwwwwwwwwwwwwww = -2894118;
        this.Wwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        this.Wwwwwwwwwwwwwww = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.HorizontalProgressBarWithNumber);
        this.Wwwwwwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getColor(2, -261935);
        this.Wwwwwwwwwwwwwwwwwwwwww = (int) obtainStyledAttributes.getDimension(4, this.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwww = obtainStyledAttributes.getColor(1, this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwww = obtainStyledAttributes.getColor(7, -2894118);
        this.Wwwwwwwwwwwwwwwwwwww = (int) obtainStyledAttributes.getDimension(0, this.Wwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwww = (int) obtainStyledAttributes.getDimension(6, this.Wwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwww = (int) obtainStyledAttributes.getDimension(3, this.Wwwwwwwwwwwwwwwwwwwww);
        if (obtainStyledAttributes.getInt(5, 0) != 0) {
            this.Wwwwwwwwwwwwwww = false;
        }
        obtainStyledAttributes.recycle();
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setTextSize(this.Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getHeight() / 2);
        boolean z = false;
        float progress = (int) (this.Wwwwwwwwwwwwwwww * ((getProgress() * 1.0f) / getMax()));
        String str = getProgress() + "%";
        float measureText = this.Wwwwwwwwwwwwwwwwwwwwwwww.measureText(str);
        float descent = (this.Wwwwwwwwwwwwwwwwwwwwwwww.descent() + this.Wwwwwwwwwwwwwwwwwwwwwwww.ascent()) / 2.0f;
        if (progress + measureText > this.Wwwwwwwwwwwwwwww) {
            progress = this.Wwwwwwwwwwwwwwww - measureText;
            z = true;
        }
        float f = progress - (this.Wwwwwwwwwwwwwwwwwwwww / 2);
        if (f > 0.0f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setStrokeWidth(this.Wwwwwwwwwwwwwwwwwwww);
            canvas.drawLine(0.0f, 0.0f, f, 0.0f, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (this.Wwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwwwwwwwwww);
            canvas.drawText(str, progress, -descent, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        if (!z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setColor(this.Wwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwww.setStrokeWidth(this.Wwwwwwwwwwwwwwwww);
            canvas.drawLine(progress + (this.Wwwwwwwwwwwwwwwwwwwww / 2) + measureText, 0.0f, this.Wwwwwwwwwwwwwwww, 0.0f, this.Wwwwwwwwwwwwwwwwwwwwwwww);
        }
        canvas.restore();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            int max = (int) (Math.max(Math.max(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww), Math.abs(this.Wwwwwwwwwwwwwwwwwwwwwwww.descent() - this.Wwwwwwwwwwwwwwwwwwwwwwww.ascent())) + getPaddingBottom() + getPaddingTop());
            size2 = mode == Integer.MIN_VALUE ? Math.min(max, size2) : max;
        }
        setMeasuredDimension(size, size2);
        this.Wwwwwwwwwwwwwwww = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
    }
}
