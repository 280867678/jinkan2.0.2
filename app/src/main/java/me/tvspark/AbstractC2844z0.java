package me.tvspark;

import androidx.annotation.NonNull;

@Deprecated
/* renamed from: me.tvspark.z0 */
/* loaded from: classes4.dex */
public abstract class AbstractC2844z0<Z> extends AbstractC2618t0<Z> {
    public final int Wwwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;
    public final int Wwwwwwwwwwwwwwwwwwwwww = Integer.MIN_VALUE;

    @Override // me.tvspark.AbstractC1930b1
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
        if (C2582s1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww)) {
            abstractC1893a1.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww);
            return;
        }
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.Wwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(" and height: ");
        throw new IllegalArgumentException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwww, ", either provide dimensions in the constructor or call override()"));
    }

    @Override // me.tvspark.AbstractC1930b1
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@NonNull AbstractC1893a1 abstractC1893a1) {
    }
}
