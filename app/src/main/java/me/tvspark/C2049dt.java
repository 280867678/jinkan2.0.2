package me.tvspark;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.tvspark.C2416nq;

/* renamed from: me.tvspark.dt */
/* loaded from: classes4.dex */
public class C2049dt {
    public static final RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new RectF();

    /* renamed from: me.tvspark.dt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas);
    }

    /* renamed from: me.tvspark.dt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final /* synthetic */ RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RectF rectF, RectF rectF2, float f, float f2, float f3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rectF;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rectF2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f3;
        }

        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2157gq abstractC2157gq, @NonNull AbstractC2157gq abstractC2157gq2) {
            return new C2083eq(C2049dt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2157gq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), abstractC2157gq2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
    }

    /* renamed from: me.tvspark.dt$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final /* synthetic */ RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(RectF rectF) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = rectF;
        }

        @Override // me.tvspark.C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
        @NonNull
        public AbstractC2157gq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC2157gq abstractC2157gq) {
            return abstractC2157gq instanceof C2342lq ? abstractC2157gq : new C2342lq(abstractC2157gq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.height());
        }
    }

    public static RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, @IdRes int i) {
        View findViewById = view.findViewById(i);
        return findViewById != null ? findViewById : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(view, i);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, float f3) {
        return outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2, f, f3, f);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f3, @FloatRange(from = 0.0d, m4213to = 1.0d) float f4, @FloatRange(from = 0.0d, m4213to = 1.0d) float f5) {
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, f3, f4, f5, false);
    }

    public static float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, float f2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f3, @FloatRange(from = 0.0d, m4213to = 1.0d) float f4, @FloatRange(from = 0.0d) float f5, boolean z) {
        return (!z || (f5 >= 0.0f && f5 <= 1.0f)) ? f5 < f3 ? f : f5 > f4 ? f2 : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, (f5 - f3) / (f4 - f3)) : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, f2, f5);
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f, @FloatRange(from = 0.0d, m4213to = 1.0d) float f2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f3) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, (f3 - f) / (f2 - f));
    }

    public static RectF Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static Shader Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@ColorInt int i) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP);
    }

    public static View Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(View view, @IdRes int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resourceName, " is not a valid ancestor"));
    }

    @NonNull
    public static <T> T Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    public static C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq, RectF rectF) {
        return c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF));
    }

    public static C2416nq Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2416nq c2416nq, C2416nq c2416nq2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f, @FloatRange(from = 0.0d, m4213to = 1.0d) float f2, @FloatRange(from = 0.0d, m4213to = 1.0d) float f3) {
        if (f3 < f) {
            return c2416nq;
        }
        if (f3 > f2) {
            return c2416nq2;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF, rectF2, f, f2, f3);
        C2416nq c2416nq3 = (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > 0.0f ? 1 : (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == 0.0f ? 0 : -1)) != 0 || (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > 0.0f ? 1 : (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == 0.0f ? 0 : -1)) != 0 || (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > 0.0f ? 1 : (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == 0.0f ? 0 : -1)) != 0 || (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) > 0.0f ? 1 : (c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(rectF) == 0.0f ? 0 : -1)) != 0 ? c2416nq : c2416nq2;
        if (c2416nq3 != null) {
            C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq3);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2416nq2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2416nq2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwww, c2416nq2.Wwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2416nq.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2416nq2.Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        throw null;
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Canvas canvas, Rect rect, float f, float f2, float f3, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (i <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(rect);
            canvas.saveLayerAlpha(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i);
        }
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(canvas);
        canvas.restoreToCount(save);
    }
}
