package me.tvspark;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import me.tvspark.C2533qq;

/* renamed from: me.tvspark.oq */
/* loaded from: classes4.dex */
public class C2453oq {
    public final C2533qq[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2533qq[4];
    public final Matrix[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix[4];
    public final Matrix[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Matrix[4];
    public final PointF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new PointF();
    public final Path Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public final Path Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public final C2533qq Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2533qq();
    public final float[] Wwwwwwwwwwwwwwwwwwwwwwwwwww = new float[2];
    public final float[] Wwwwwwwwwwwwwwwwwwwwwwwwww = new float[2];
    public final Path Wwwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public final Path Wwwwwwwwwwwwwwwwwwwwwwww = new Path();
    public boolean Wwwwwwwwwwwwwwwwwwwwwww = true;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: me.tvspark.oq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    /* renamed from: me.tvspark.oq$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final C2453oq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2453oq();
    }

    public C2453oq() {
        for (int i = 0; i < 4; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = new C2533qq();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = new Matrix();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = new Matrix();
        }
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq, float f, RectF rectF, @NonNull Path path) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq, f, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq, float f, RectF rectF, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @NonNull Path path) {
        float[] fArr;
        float centerX;
        float f2;
        C2268jq c2268jq;
        C2533qq c2533qq;
        Matrix matrix;
        Path path2;
        AbstractC2157gq abstractC2157gq;
        C2194hq c2194hq;
        float f3;
        float f4;
        path.rewind();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.rewind();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.rewind();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.addRect(rectF, Path.Direction.CW);
        char c = 0;
        int i = 0;
        while (i < 4) {
            if (i == 1) {
                abstractC2157gq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i == 2) {
                abstractC2157gq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i != 3) {
                abstractC2157gq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                abstractC2157gq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            if (i == 1) {
                c2194hq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i == 2) {
                c2194hq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i != 3) {
                c2194hq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                c2194hq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            C2533qq c2533qq2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
            if (c2194hq != null) {
                c2194hq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2533qq2, 90.0f, f, abstractC2157gq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF));
                int i2 = i + 1;
                float f5 = i2 * 90;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].reset();
                PointF pointF = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == 1) {
                    f3 = rectF.right;
                } else if (i != 2) {
                    f3 = i != 3 ? rectF.right : rectF.left;
                    f4 = rectF.top;
                    pointF.set(f3, f4);
                    Matrix matrix2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                    PointF pointF2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    matrix2.setTranslate(pointF2.x, pointF2.y);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].preRotate(f5);
                    float[] fArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    C2533qq[] c2533qqArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    fArr2[0] = c2533qqArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    fArr2[1] = c2533qqArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].mapPoints(fArr2);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].reset();
                    Matrix matrix3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                    float[] fArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                    matrix3.setTranslate(fArr3[0], fArr3[1]);
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].preRotate(f5);
                    i = i2;
                } else {
                    f3 = rectF.left;
                }
                f4 = rectF.bottom;
                pointF.set(f3, f4);
                Matrix matrix22 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                PointF pointF22 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                matrix22.setTranslate(pointF22.x, pointF22.y);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].preRotate(f5);
                float[] fArr22 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2533qq[] c2533qqArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                fArr22[0] = c2533qqArr2[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                fArr22[1] = c2533qqArr2[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].mapPoints(fArr22);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].reset();
                Matrix matrix32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i];
                float[] fArr32 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                matrix32.setTranslate(fArr32[0], fArr32[1]);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].preRotate(f5);
                i = i2;
            } else {
                throw null;
            }
        }
        int i3 = 0;
        while (i3 < 4) {
            float[] fArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2533qq[] c2533qqArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr4[c] = c2533qqArr3[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr4[1] = c2533qqArr3[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3].mapPoints(fArr4);
            float[] fArr5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i3 == 0) {
                path.moveTo(fArr5[c], fArr5[1]);
            } else {
                path.lineTo(fArr5[c], fArr5[1]);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3], path);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C2533qq c2533qq3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                Matrix matrix4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                MaterialShapeDrawable.this.Wwwwwwwwwwwwwwwwwwwww.set(i3, c2533qq3.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr = MaterialShapeDrawable.this.Wwwwwwwwwwwwwwwwwwwwwww;
                c2533qq3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2533qq3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr[i3] = new C2490pq(c2533qq3, new ArrayList(c2533qq3.Wwwwwwwwwwwwwwwwwwwwwwwwwww), new Matrix(matrix4));
            }
            int i4 = i3 + 1;
            int i5 = i4 % 4;
            float[] fArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2533qq[] c2533qqArr4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr6[c] = c2533qqArr4[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr6[1] = c2533qqArr4[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3].mapPoints(fArr6);
            float[] fArr7 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            C2533qq[] c2533qqArr5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr7[c] = c2533qqArr5[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr7[1] = c2533qqArr5[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5].mapPoints(fArr7);
            float f6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[c];
            float[] fArr8 = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            float max = Math.max(((float) Math.hypot(f6 - fArr8[c], fArr[1] - fArr8[1])) - 0.001f, 0.0f);
            float[] fArr9 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2533qq[] c2533qqArr6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr9[c] = c2533qqArr6[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            fArr9[1] = c2533qqArr6[i3].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3].mapPoints(fArr9);
            if (i3 == 1 || i3 == 3) {
                centerX = rectF.centerX();
                f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[c];
            } else {
                centerX = rectF.centerY();
                f2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww[1];
            }
            float abs = Math.abs(centerX - f2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0.0f, 0.0f);
            if (i3 == 1) {
                c2268jq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwww;
            } else if (i3 == 2) {
                c2268jq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwww;
            } else if (i3 != 3) {
                c2268jq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwww;
            } else {
                c2268jq = c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            c2268jq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(max, abs, f, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwww.reset();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3], this.Wwwwwwwwwwwwwwwwwwwwwwwww);
            if (!this.Wwwwwwwwwwwwwwwwwwwwwww || (!c2268jq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i3) && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwww, i5))) {
                c2533qq = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                matrix = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                path2 = path;
            } else {
                Path path3 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                path3.op(path3, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, Path.Op.DIFFERENCE);
                float[] fArr10 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2533qq c2533qq4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                fArr10[c] = c2533qq4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                fArr10[1] = c2533qq4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3].mapPoints(fArr10);
                Path path4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                float[] fArr11 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
                path4.moveTo(fArr11[c], fArr11[1]);
                c2533qq = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                matrix = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                path2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            c2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(matrix, path2);
            if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                C2533qq c2533qq5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Matrix matrix5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i3];
                MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (MaterialShapeDrawable.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                MaterialShapeDrawable.this.Wwwwwwwwwwwwwwwwwwwww.set(i3 + 4, c2533qq5.Wwwwwwwwwwwwwwwwwwwwwwwwww);
                C2533qq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[] wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2 = MaterialShapeDrawable.this.Wwwwwwwwwwwwwwwwwwwwww;
                c2533qq5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2533qq5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwArr2[i3] = new C2490pq(c2533qq5, new ArrayList(c2533qq5.Wwwwwwwwwwwwwwwwwwwwwwwwwww), new Matrix(matrix5));
            }
            i3 = i4;
            c = 0;
        }
        path.close();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.close();
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            path.op(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Path.Op.UNION);
        }
    }

    @RequiresApi(19)
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Path path, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwww.reset();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i], this.Wwwwwwwwwwwwwwwwwwwwwwww);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.Wwwwwwwwwwwwwwwwwwwwwwww.computeBounds(rectF, true);
        path.op(this.Wwwwwwwwwwwwwwwwwwwwwwww, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
