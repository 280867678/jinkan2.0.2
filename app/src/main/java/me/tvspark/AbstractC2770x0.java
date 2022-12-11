package me.tvspark;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.x0 */
/* loaded from: classes4.dex */
public abstract class AbstractC2770x0<Z> extends AbstractC1967c1<ImageView, Z> {
    @Nullable
    public Animatable Wwwwwwwwwwwwwwwwwwww;

    public AbstractC2770x0(ImageView imageView) {
        super(imageView);
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        this.Wwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Animatable animatable = this.Wwwwwwwwwwwwwwwwwwww;
        if (animatable != null) {
            animatable.stop();
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2770x0<Z>) null);
        ((ImageView) this.Wwwwwwwwwwwwwwwwwwwwwww).setImageDrawable(drawable);
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2770x0<Z>) null);
        ((ImageView) this.Wwwwwwwwwwwwwwwwwwwwwww).setImageDrawable(drawable);
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2770x0<Z>) null);
        ((ImageView) this.Wwwwwwwwwwwwwwwwwwwwwww).setImageDrawable(drawable);
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Z z);

    @Override // me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull Z z, @Nullable AbstractC2058e1<? super Z> abstractC2058e1) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2770x0<Z>) z);
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC2692v
    public void onStart() {
        Animatable animatable = this.Wwwwwwwwwwwwwwwwwwww;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // me.tvspark.AbstractC2618t0, me.tvspark.AbstractC2692v
    public void onStop() {
        Animatable animatable = this.Wwwwwwwwwwwwwwwwwwww;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Z z) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((AbstractC2770x0<Z>) z);
        if (!(z instanceof Animatable)) {
            this.Wwwwwwwwwwwwwwwwwwww = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.Wwwwwwwwwwwwwwwwwwww = animatable;
        animatable.start();
    }
}
