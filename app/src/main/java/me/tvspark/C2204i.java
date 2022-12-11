package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* renamed from: me.tvspark.i */
/* loaded from: classes4.dex */
public final class C2204i implements AbstractC2278k<Drawable, byte[]> {
    public final AbstractC2278k<GifDrawable, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2278k<Bitmap, byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final OO0 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2204i(@NonNull OO0 oo0, @NonNull AbstractC2278k<Bitmap, byte[]> abstractC2278k, @NonNull AbstractC2278k<GifDrawable, byte[]> abstractC2278k2) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = oo0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2278k;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2278k2;
    }

    @Override // me.tvspark.AbstractC2278k
    @Nullable
    public AbstractC1886O0<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1886O0<Drawable> abstractC1886O0, @NonNull Illllllllllllllllllllllll illllllllllllllllllllllll) {
        Drawable drawable = abstractC1886O0.get();
        if (drawable instanceof BitmapDrawable) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Xxxx.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((BitmapDrawable) drawable).getBitmap(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), illllllllllllllllllllllll);
        }
        if (!(drawable instanceof GifDrawable)) {
            return null;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1886O0, illllllllllllllllllllllll);
    }
}
