package me.tvspark;

import androidx.annotation.Nullable;
import java.io.IOException;
import me.tvspark.AbstractC2625t7;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ba */
/* loaded from: classes4.dex */
public abstract class AbstractC1939ba {
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2853z9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2249j7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AbstractC2740w7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2779x9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2779x9();

    /* renamed from: me.tvspark.ba$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2853z9 {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }

        @Override // me.tvspark.AbstractC2853z9
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2212i7 abstractC2212i7) {
            return -1L;
        }

        @Override // me.tvspark.AbstractC2853z9
        public AbstractC2625t7 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new AbstractC2625t7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-9223372036854775807L, 0L);
        }

        @Override // me.tvspark.AbstractC2853z9
        public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        }
    }

    /* renamed from: me.tvspark.ba$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public AbstractC2853z9 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (this.Wwwwwwwwwwwwwwwwwwwwwwwwww * j) / StopWatch.NANO_2_MILLIS;
    }

    public abstract long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el);

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        int i;
        if (z) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws IOException;
}
