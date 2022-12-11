package me.tvspark;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: me.tvspark.hp */
/* loaded from: classes4.dex */
public class C2193hp {
    public static final ThreadLocal<Matrix> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ThreadLocal<>();
    public static final ThreadLocal<RectF> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ThreadLocal<>();

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        if (matrix == null) {
            matrix = new Matrix();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(matrix);
        } else {
            matrix.reset();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewGroup, view, matrix);
        RectF rectF = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get();
        if (rectF == null) {
            rectF = new RectF();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ViewParent viewParent, @NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(viewParent, view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
