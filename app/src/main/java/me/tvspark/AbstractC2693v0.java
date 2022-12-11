package me.tvspark;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.v0 */
/* loaded from: classes4.dex */
public abstract class AbstractC2693v0<T> implements AbstractC1930b1<T> {
    @Nullable
    public AbstractC2464p0 Wwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2693v0() {
        if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
            this.Wwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
            return;
        }
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ", Integer.MIN_VALUE, " and height: ", Integer.MIN_VALUE));
    }

    @Override // me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
    }

    @Override // me.tvspark.AbstractC1930b1
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
        abstractC1893a1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable Drawable drawable) {
    }

    @Override // me.tvspark.AbstractC1930b1
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
    }

    @Override // me.tvspark.AbstractC1930b1
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable AbstractC2464p0 abstractC2464p0) {
        this.Wwwwwwwwwwwwwwwwwwwwww = abstractC2464p0;
    }

    @Override // me.tvspark.AbstractC1930b1
    @Nullable
    public final AbstractC2464p0 getRequest() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2692v
    public void onDestroy() {
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStart() {
    }

    @Override // me.tvspark.AbstractC2692v
    public void onStop() {
    }
}
