package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public abstract class Xxx implements Illlllllllllllllllllll<Bitmap> {
    public abstract Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull OO0 oo0, @NonNull Bitmap bitmap, int i, int i2);

    @Override // me.tvspark.Illlllllllllllllllllll
    @NonNull
    public final AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull AbstractC1886O0<Bitmap> abstractC1886O0, int i, int i2) {
        if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2)) {
            OO0 oo0 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwww;
            Bitmap bitmap = abstractC1886O0.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, bitmap, i, i2);
            return bitmap.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) ? abstractC1886O0 : Xxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, oo0);
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Cannot apply transformation on width: ", i, " or height: ", i2, " less than or equal to zero and not Target.SIZE_ORIGINAL"));
    }
}
