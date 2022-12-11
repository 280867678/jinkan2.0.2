package me.tvspark;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: me.tvspark.z4 */
/* loaded from: classes4.dex */
public final class C2848z4 {
    public static final C2848z4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2848z4(0, 0, 1, 1, null);
    @Nullable
    public AudioAttributes Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public /* synthetic */ C2848z4(int i, int i2, int i3, int i4, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
    }

    @RequiresApi(21)
    public AudioAttributes Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setFlags(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww).setUsage(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 29) {
                usage.setAllowedCapturePolicy(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = usage.build();
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2848z4.class != obj.getClass()) {
            return false;
        }
        C2848z4 c2848z4 = (C2848z4) obj;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == c2848z4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public int hashCode() {
        return ((((((527 + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
