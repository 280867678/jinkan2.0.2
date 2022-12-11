package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;

/* renamed from: me.tvspark.w3 */
/* loaded from: classes4.dex */
public interface AbstractC2736w3 {

    /* renamed from: me.tvspark.w3$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2209i4 abstractC2209i4, int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable C2356m3 c2356m3, int i);

        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, int i);

        @Deprecated
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(C2658u3 c2658u3);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        @Deprecated
        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        @Deprecated
        void onSeekProcessed();

        @Deprecated
        void onTimelineChanged(AbstractC2209i4 abstractC2209i4, @Nullable Object obj, int i);

        void onTracksChanged(C2368mf c2368mf, C2039dj c2039dj);
    }

    AbstractC2209i4 Wwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwww();

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwww();

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, long j);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    long getCurrentPosition();

    long getDuration();
}
