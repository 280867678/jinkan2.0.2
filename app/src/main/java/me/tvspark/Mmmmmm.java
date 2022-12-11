package me.tvspark;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public final class Mmmmmm extends Mmmmmmm<Drawable> {
    public Mmmmmm(Drawable drawable) {
        super(drawable);
    }

    @Override // me.tvspark.AbstractC1886O0
    @NonNull
    public Class<Drawable> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwww.getClass();
    }

    @Override // me.tvspark.AbstractC1886O0
    public int getSize() {
        return Math.max(1, this.Wwwwwwwwwwwwwwwwwwwwwwww.getIntrinsicHeight() * this.Wwwwwwwwwwwwwwwwwwwwwwww.getIntrinsicWidth() * 4);
    }

    @Override // me.tvspark.AbstractC1886O0
    public void recycle() {
    }
}
