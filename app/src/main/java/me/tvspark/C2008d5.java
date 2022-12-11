package me.tvspark;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: me.tvspark.d5 */
/* loaded from: classes4.dex */
public final class C2008d5 {
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @RequiresApi(19)
    /* renamed from: me.tvspark.d5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final AudioTimestamp Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AudioTimestamp();
        public final AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioTrack audioTrack) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = audioTrack;
        }
    }

    public C2008d5(AudioTrack audioTrack) {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 19) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(3);
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        long j = 10000;
        if (i == 0) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1L;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = System.nanoTime() / 1000;
        } else if (i != 1) {
            if (i == 2 || i == 3) {
                j = 10000000;
            } else if (i != 4) {
                throw new IllegalStateException();
            } else {
                j = 500000;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }
}
