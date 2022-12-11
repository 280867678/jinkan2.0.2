package com.tencent.smtt.sdk.p045ui.dialog.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

/* renamed from: com.tencent.smtt.sdk.ui.dialog.widget.a */
/* loaded from: classes4.dex */
public class C1411a extends View {

    /* renamed from: a */
    public int f2303a;

    /* renamed from: b */
    public int f2304b;

    /* renamed from: c */
    public Paint f2305c;

    /* renamed from: d */
    public Paint f2306d;

    /* renamed from: e */
    public Path f2307e;

    /* renamed from: f */
    public Path f2308f;

    /* renamed from: g */
    public RectF f2309g;

    /* renamed from: h */
    public float[] f2310h;

    /* renamed from: i */
    public float f2311i;

    /* renamed from: j */
    public float f2312j;

    public C1411a(Context context, float f, float f2, float f3) {
        super(context, null, 0);
        m2309a(context, f, f2, f3);
    }

    /* renamed from: a */
    private int m2311a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode != Integer.MIN_VALUE) {
            return 100;
        }
        return Math.min(100, size);
    }

    /* renamed from: a */
    public static int m2310a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private void m2309a(Context context, float f, float f2, float f3) {
        this.f2311i = f2;
        this.f2312j = f3;
        int parseColor = Color.parseColor("#989DB4");
        this.f2305c = new Paint();
        Paint paint = new Paint();
        this.f2306d = paint;
        paint.setColor(-1);
        this.f2306d.setStyle(Paint.Style.FILL);
        this.f2306d.setAntiAlias(true);
        this.f2305c.setColor(parseColor);
        this.f2305c.setStyle(Paint.Style.STROKE);
        this.f2305c.setAntiAlias(true);
        this.f2305c.setStrokeWidth(m2310a(context, 6.0f));
        this.f2305c.setStrokeJoin(Paint.Join.ROUND);
        this.f2309g = new RectF();
        this.f2310h = new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, 0.0f);
        canvas.rotate(0.0f);
        if (this.f2308f == null) {
            this.f2308f = new Path();
        }
        this.f2308f.reset();
        this.f2308f.addRoundRect(this.f2309g, this.f2310h, Path.Direction.CCW);
        this.f2308f.close();
        canvas.drawPath(this.f2308f, this.f2306d);
        canvas.translate(this.f2303a / 2.0f, (this.f2312j / 2.0f) + (this.f2304b / 2.0f));
        if (this.f2307e == null) {
            this.f2307e = new Path();
        }
        this.f2307e.reset();
        this.f2307e.moveTo(0.0f, 0.0f);
        this.f2307e.lineTo((-this.f2311i) / 2.0f, (-this.f2312j) / 2.0f);
        this.f2307e.close();
        canvas.drawPath(this.f2307e, this.f2305c);
        this.f2307e.reset();
        this.f2307e.moveTo(0.0f, 0.0f);
        this.f2307e.lineTo(this.f2311i / 2.0f, (-this.f2312j) / 2.0f);
        this.f2307e.close();
        canvas.drawPath(this.f2307e, this.f2305c);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m2311a(i), m2311a(i2));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2303a = i;
        this.f2304b = i2;
        RectF rectF = this.f2309g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = i;
        rectF.bottom = i2;
    }
}
