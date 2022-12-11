package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;
import me.tvspark.C2773x3;

/* renamed from: me.tvspark.a4 */
/* loaded from: classes4.dex */
public interface AbstractC1896a4 extends C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {

    /* renamed from: me.tvspark.a4$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j);
    }

    @Nullable
    AbstractC1913al Wwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwww();

    long Wwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwww() throws IOException;

    @Nullable
    AbstractC2183hf Wwwwwwwwwwwwwwwwwwwwwwwwww();

    AbstractC1970c4 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) throws ExoPlaybackException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ExoPlaybackException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) throws ExoPlaybackException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2007d4 c2007d4, C2245j3[] c2245j3Arr, AbstractC2183hf abstractC2183hf, long j, boolean z, boolean z2, long j2, long j3) throws ExoPlaybackException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, AbstractC2183hf abstractC2183hf, long j, long j2) throws ExoPlaybackException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void disable();

    String getName();

    int getState();

    int getTrackType();

    void reset();

    void start() throws ExoPlaybackException;

    void stop();
}
