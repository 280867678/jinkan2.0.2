package me.tvspark;

import android.media.MediaCodec;

/* renamed from: me.tvspark.ic */
/* loaded from: classes4.dex */
public class C2217ic implements AbstractC2106fc {
    public final MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2217ic(MediaCodec mediaCodec) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mediaCodec;
    }

    @Override // me.tvspark.AbstractC2106fc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, long j, int i4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // me.tvspark.AbstractC2106fc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, C2623t5 c2623t5, long j, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueSecureInputBuffer(i, i2, c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwww, j, i3);
    }

    @Override // me.tvspark.AbstractC2106fc
    public void flush() {
    }

    @Override // me.tvspark.AbstractC2106fc
    public void shutdown() {
    }

    @Override // me.tvspark.AbstractC2106fc
    public void start() {
    }
}
