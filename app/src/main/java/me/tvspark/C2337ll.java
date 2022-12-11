package me.tvspark;

import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.ll */
/* loaded from: classes4.dex */
public final class C2337ll {
    public volatile long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -9223372036854775807L;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2337ll(long j) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
            long j2 = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 90000) / StopWatch.NANO_2_MILLIS;
            long j3 = (4294967296L + j2) / 8589934592L;
            long j4 = ((j3 - 1) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - j2) < Math.abs(j - j2)) {
                j = j4;
            }
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((j * StopWatch.NANO_2_MILLIS) / 90000);
    }

    public synchronized void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws InterruptedException {
        while (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -9223372036854775807L) {
            wait();
        }
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return -9223372036854775807L;
    }

    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -9223372036854775807L) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        } else {
            long j2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (j2 != Long.MAX_VALUE) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2 - j;
            }
            synchronized (this) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                notifyAll();
            }
        }
        return j + this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
