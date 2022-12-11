package me.tvspark;

import androidx.annotation.Nullable;

/* renamed from: me.tvspark.u3 */
/* loaded from: classes4.dex */
public final class C2658u3 {
    public static final C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2658u3(1.0f, 1.0f);
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2658u3(float f, float f2) {
        boolean z = true;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f > 0.0f);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f2 <= 0.0f ? false : z);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Math.round(f * 1000.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2658u3.class != obj.getClass()) {
            return false;
        }
        C2658u3 c2658u3 = (C2658u3) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2658u3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + ((Float.floatToRawIntBits(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + 527) * 31);
    }

    public String toString() {
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww), Float.valueOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
    }
}
