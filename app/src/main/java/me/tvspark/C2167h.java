package me.tvspark;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.h */
/* loaded from: classes4.dex */
public class C2167h implements AbstractC2278k<Bitmap, BitmapDrawable> {
    public final Resources Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2167h(@NonNull Resources resources) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(resources, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = resources;
    }

    @Override // me.tvspark.AbstractC2278k
    @Nullable
    public AbstractC1886O0<BitmapDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1886O0<Bitmap> abstractC1886O0, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        return Ccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, abstractC1886O0);
    }
}
