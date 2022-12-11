package me.tvspark;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.e5 */
/* loaded from: classes4.dex */
public final class C2062e5 {
    public long Www;
    public long Wwww;
    public boolean Wwwww;
    public long Wwwwww;
    public long Wwwwwww;
    public long Wwwwwwww;
    public long Wwwwwwwww;
    public long Wwwwwwwwww;
    public long Wwwwwwwwwww;
    public int Wwwwwwwwwwww;
    public int Wwwwwwwwwwwww;
    public long Wwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwww;
    @Nullable
    public Method Wwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2008d5 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public AudioTrack Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final long[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* renamed from: me.tvspark.e5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3, long j4);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, long j3, long j4);
    }

    public C2062e5(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 18) {
                try {
                    this.Wwwwwwwwwwwwwwwwwwwww = AudioTrack.class.getMethod("getLatency", null);
                } catch (NoSuchMethodException unused) {
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new long[10];
            return;
        }
        throw null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwww = 0L;
        this.Www = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
        return audioTrack.getPlayState() == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        boolean z;
        if (j <= Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
                AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
                if (audioTrack.getPlayState() == 2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 0) {
                    z = true;
                    if (z) {
                        return false;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return true;
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        AudioTrack audioTrack = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(audioTrack);
        AudioTrack audioTrack2 = audioTrack;
        if (this.Wwwwwwwwwww != -9223372036854775807L) {
            return Math.min(this.Wwwwwwww, this.Wwwwwwwww + ((((SystemClock.elapsedRealtime() * 1000) - this.Wwwwwwwwwww) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) / StopWatch.NANO_2_MILLIS));
        }
        int playState = audioTrack2.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & audioTrack2.getPlaybackHeadPosition();
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.Wwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwww;
            }
            playbackHeadPosition += this.Wwwwwwwwwwwwww;
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 29) {
            if (playbackHeadPosition == 0 && this.Wwwwwwwwwwwwwwww > 0 && playState == 3) {
                if (this.Wwwwwwwwww == -9223372036854775807L) {
                    this.Wwwwwwwwww = SystemClock.elapsedRealtime();
                }
                return this.Wwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwww = -9223372036854775807L;
        }
        if (this.Wwwwwwwwwwwwwwww > playbackHeadPosition) {
            this.Wwwwwwwwwwwwwww++;
        }
        this.Wwwwwwwwwwwwwwww = playbackHeadPosition;
        return playbackHeadPosition + (this.Wwwwwwwwwwwwwww << 32);
    }

    public final long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return (j * StopWatch.NANO_2_MILLIS) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((me.tvspark.C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 && (r5 == 5 || r5 == 6)) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioTrack audioTrack, boolean z, int i, int i2, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = audioTrack;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2008d5(audioTrack);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = audioTrack.getSampleRate();
        boolean z2 = true;
        if (z) {
        }
        z2 = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z2;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww ? Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3 / i2) : -9223372036854775807L;
        this.Wwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwww = -9223372036854775807L;
        this.Wwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    }
}
