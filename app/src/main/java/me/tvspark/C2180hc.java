package me.tvspark;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;

/* renamed from: me.tvspark.hc */
/* loaded from: classes4.dex */
public final class C2180hc implements AbstractC1978cc {
    public final MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2180hc(MediaCodec mediaCodec) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mediaCodec;
    }

    @Override // me.tvspark.AbstractC1978cc
    public MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1978cc
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dequeueInputBuffer(0L);
    }

    @Override // me.tvspark.AbstractC1978cc
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec.BufferInfo bufferInfo) {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.dequeueOutputBuffer(bufferInfo, 0L);
    }

    @Override // me.tvspark.AbstractC1978cc
    public MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getOutputFormat();
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, long j, int i4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, C2623t5 c2623t5, long j, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueSecureInputBuffer(i, i2, c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwww, j, i3);
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.configure(mediaFormat, surface, mediaCrypto, i);
    }

    @Override // me.tvspark.AbstractC1978cc
    public void flush() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flush();
    }

    @Override // me.tvspark.AbstractC1978cc
    public void shutdown() {
    }

    @Override // me.tvspark.AbstractC1978cc
    public void start() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
    }
}
