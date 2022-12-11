package me.tvspark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class Zzzzz implements Illlllllllllllllllllll<Drawable> {
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Illlllllllllllllllllll<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public Zzzzz(Illlllllllllllllllllll<Bitmap> illlllllllllllllllllll, boolean z) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = illlllllllllllllllllll;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    @Override // me.tvspark.Illlllllllllllllllllll
    @NonNull
    public AbstractC1886O0<Drawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Context context, @NonNull AbstractC1886O0<Drawable> abstractC1886O0, int i, int i2) {
        OO0 oo0 = Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context).Wwwwwwwwwwwwwwwwwwwwwwww;
        Drawable drawable = abstractC1886O0.get();
        AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Zzzzzz.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(oo0, drawable, i, i2);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            AbstractC1886O0<Bitmap> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i, i2);
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                return Ccccccccc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(context.getResources(), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.recycle();
            return abstractC1886O0;
        } else if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return abstractC1886O0;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull MessageDigest messageDigest) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(messageDigest);
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public boolean equals(Object obj) {
        if (obj instanceof Zzzzz) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(((Zzzzz) obj).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        return false;
    }

    @Override // me.tvspark.Illlllllllllllllllllllllllll
    public int hashCode() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode();
    }
}
