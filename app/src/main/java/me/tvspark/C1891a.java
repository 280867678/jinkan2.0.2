package me.tvspark;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import me.tvspark.C1965c;

/* renamed from: me.tvspark.a */
/* loaded from: classes4.dex */
public class C1891a extends Mmmmmmm<GifDrawable> implements O00000 {
    public C1891a(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<GifDrawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return GifDrawable.class;
    }

    @Override // me.tvspark.Mmmmmmm, me.tvspark.O00000
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ((GifDrawable) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().prepareToDraw();
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        C1965c c1965c = ((GifDrawable) this.Wwwwwwwwwwwwwwwwwwwwwwww).Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww() + c1965c.Wwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1886O0
    public void recycle() {
        ((GifDrawable) this.Wwwwwwwwwwwwwwwwwwwwwwww).stop();
        GifDrawable gifDrawable = (GifDrawable) this.Wwwwwwwwwwwwwwwwwwwwwwww;
        gifDrawable.Wwwwwwwwwwwwwwwwwwwww = true;
        C1965c c1965c = gifDrawable.Wwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        Bitmap bitmap = c1965c.Wwwwwwwwwwwwwwwwwwwwww;
        if (bitmap != null) {
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bitmap);
            c1965c.Wwwwwwwwwwwwwwwwwwwwww = null;
        }
        c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c1965c.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c1965c.Wwwwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != null) {
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            c1965c.Wwwwwwwwwwwwwwwwwwwwwww = null;
        }
        C1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c1965c.Wwwwwwwwwwwwwwwwwwwww;
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != null) {
            c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            c1965c.Wwwwwwwwwwwwwwwwwwwww = null;
        }
        c1965c.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        c1965c.Wwwwwwwwwwwwwwwwwwwwwwww = true;
    }
}
