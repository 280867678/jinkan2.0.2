package me.tvspark;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;

/* renamed from: me.tvspark.ze */
/* loaded from: classes4.dex */
public interface AbstractC2858ze {

    /* renamed from: me.tvspark.ze$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2858ze abstractC2858ze, AbstractC2209i4 abstractC2209i4);
    }

    /* renamed from: me.tvspark.ze$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i, int i2, long j, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(obj) ? this : new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }

        public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.class != obj.getClass()) {
                return false;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public int hashCode() {
            return ((((((((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.hashCode() + 527) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 31) + ((int) this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) * 31) + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, int i, int i2, long j) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Object obj, long j, int i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = obj;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        }
    }

    @Nullable
    AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    C2356m3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    AbstractC2784xe mo4966Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, AbstractC2637tj abstractC2637tj, long j);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, AbstractC1944bf abstractC1944bf);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Handler handler, AbstractC2396n6 abstractC2396n6);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1944bf abstractC1944bf);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2784xe abstractC2784xe);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, @Nullable AbstractC2410nk abstractC2410nk);
}
