package me.tvspark;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.cc */
/* loaded from: classes4.dex */
public interface AbstractC1978cc {
    MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec.BufferInfo bufferInfo);

    MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, long j, int i4);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, C2623t5 c2623t5, long j, int i3);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i);

    void flush();

    void shutdown();

    void start();
}
