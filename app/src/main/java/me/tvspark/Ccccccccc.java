package me.tvspark;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Ccccccccc implements AbstractC1886O0<BitmapDrawable>, O00000 {
    public final AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwww;
    public final Resources Wwwwwwwwwwwwwwwwwwwwwwww;

    public Ccccccccc(@NonNull Resources resources, @NonNull AbstractC1886O0<Bitmap> abstractC1886O0) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = resources;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwww = abstractC1886O0;
    }

    @Nullable
    public static AbstractC1886O0<BitmapDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Resources resources, @Nullable AbstractC1886O0<Bitmap> abstractC1886O0) {
        if (abstractC1886O0 == null) {
            return null;
        }
        return new Ccccccccc(resources, abstractC1886O0);
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<BitmapDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return BitmapDrawable.class;
    }

    @Override // me.tvspark.O00000
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AbstractC1886O0<Bitmap> abstractC1886O0 = this.Wwwwwwwwwwwwwwwwwwwwwww;
        if (abstractC1886O0 instanceof O00000) {
            ((O00000) abstractC1886O0).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public BitmapDrawable get() {
        return new BitmapDrawable(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww.get());
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        return this.Wwwwwwwwwwwwwwwwwwwwwww.getSize();
    }

    @Override // me.tvspark.AbstractC1886O0
    public void recycle() {
        this.Wwwwwwwwwwwwwwwwwwwwwww.recycle();
    }
}
