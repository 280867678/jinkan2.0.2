package me.tvspark;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes4.dex */
public abstract class Mmmmmmm<T extends Drawable> implements AbstractC1886O0<T>, O00000 {
    public final T Wwwwwwwwwwwwwwwwwwwwwwww;

    public Mmmmmmm(T t) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(t, "Argument must not be null");
        this.Wwwwwwwwwwwwwwwwwwwwwwww = t;
    }

    @Override // me.tvspark.O00000
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        Bitmap Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        T t = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        if (t instanceof BitmapDrawable) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof GifDrawable)) {
            return;
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ((GifDrawable) t).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.prepareToDraw();
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Object get() {
        Drawable.ConstantState constantState = this.Wwwwwwwwwwwwwwwwwwwwwwww.getConstantState();
        return constantState == null ? this.Wwwwwwwwwwwwwwwwwwwwwwww : constantState.newDrawable();
    }
}
