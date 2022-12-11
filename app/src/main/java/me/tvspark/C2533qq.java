package me.tvspark;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: me.tvspark.qq */
/* loaded from: classes4.dex */
public class C2533qq {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Deprecated
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();
    public final List<Wwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayList();

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Matrix Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix();

        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, C1992cq c1992cq, int i, Canvas canvas);
    }

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static abstract class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Matrix Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix();

        public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, Path path);
    }

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        @Override // me.tvspark.C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            path.transform(matrix);
        }
    }

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        @Deprecated
        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f4;
        }

        @Override // me.tvspark.C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            matrix.invert(matrix2);
            path.transform(matrix2);
            Wwwwwwwwwwwwwwwwwwwwwwwwwww.set(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            path.arcTo(Wwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, false);
            path.transform(matrix);
        }
    }

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        @Override // me.tvspark.C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, @NonNull C1992cq c1992cq, int i, @NonNull Canvas canvas) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f2 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            RectF rectF = new RectF(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            boolean z = f2 < 0.0f;
            Path path = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (z) {
                int[] iArr = C1992cq.Wwwwwwwwwwwwwwwwwwwwwwww;
                iArr[0] = 0;
                iArr[1] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[2] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[3] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -i;
                rectF.inset(f3, f3);
                int[] iArr2 = C1992cq.Wwwwwwwwwwwwwwwwwwwwwwww;
                iArr2[0] = 0;
                iArr2[1] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr2[2] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr2[3] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            float width = rectF.width() / 2.0f;
            if (width <= 0.0f) {
                return;
            }
            float f4 = 1.0f - (i / width);
            float[] fArr = C1992cq.Wwwwwwwwwwwwwwwwwwwwwww;
            fArr[1] = f4;
            fArr[2] = ((1.0f - f4) / 2.0f) + f4;
            c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, C1992cq.Wwwwwwwwwwwwwwwwwwwwwwww, C1992cq.Wwwwwwwwwwwwwwwwwwwwwww, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            canvas.drawArc(rectF, f, f2, true, c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            canvas.restore();
        }
    }

    public C2533qq() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.0f);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, 270.0f, 0.0f);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4, float f5, float f6) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, f3, f4);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = f5;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f6;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        float f8 = z ? (180.0f + f7) % 360.0f : f7;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f5);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f8;
        double d = f7;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((f + f3) * 0.5f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((f2 + f4) * 0.5f);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, Path path) {
        int size = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.size();
        for (int i = 0; i < size; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.get(i).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matrix, path);
        }
    }

    /* renamed from: me.tvspark.qq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Wwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, float f, float f2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        }

        @Override // me.tvspark.C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Matrix matrix, @NonNull C1992cq c1992cq, int i, @NonNull Canvas canvas) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            matrix2.preRotate(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            if (c1992cq != null) {
                rectF.bottom += i;
                rectF.offset(0.0f, -i);
                int[] iArr = C1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[0] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[1] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                iArr[2] = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Paint paint = c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float f = rectF.left;
                paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, C1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwww, C1992cq.Wwwwwwwwwwwwwwwwwwwwwwwww, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix2);
                canvas.drawRect(rectF, c1992cq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                canvas.restore();
                return;
            }
            throw null;
        }

        public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            return (float) Math.toDegrees(Math.atan((wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)));
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) {
        float f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float f5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f4, f5, f4, f5);
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 270.0f);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + 270.0f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3, float f4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = (f3 + f4) % 360.0f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }
}
