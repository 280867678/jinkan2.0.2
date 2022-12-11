package me.tvspark;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: me.tvspark.w7 */
/* loaded from: classes4.dex */
public interface AbstractC2740w7 {

    /* renamed from: me.tvspark.w7$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, byte[] bArr, int i2, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && Arrays.equals(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) + (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 31)) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z) throws IOException;

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2752wj abstractC2752wj, int i, boolean z, int i2) throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, int i, int i2, int i3, @Nullable Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i, int i2);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);
}
