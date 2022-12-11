package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.f5 */
/* loaded from: classes4.dex */
public final class C2099f5 {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2099f5(int i, float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2099f5.class != obj.getClass()) {
            return false;
        }
        C2099f5 c2099f5 = (C2099f5) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2099f5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Float.compare(c2099f5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ((527 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31);
    }
}
