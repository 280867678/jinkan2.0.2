package me.tvspark;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

@RequiresApi(21)
/* renamed from: me.tvspark.dc */
/* loaded from: classes4.dex */
public final class C2032dc extends MediaCodec.Callback {
    @Nullable
    public IllegalStateException Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2790xk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2790xk();
    public final C2790xk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2790xk();
    public final ArrayDeque<MediaCodec.BufferInfo> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
    public final ArrayDeque<MediaFormat> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();

    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec.BufferInfo bufferInfo) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
            return -1;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 0) {
            MediaCodec.BufferInfo remove = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove();
            bufferInfo.set(remove.offset, remove.size, remove.presentationTimeUs, remove.flags);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.remove();
        }
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = codecException;
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        MediaFormat mediaFormat = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (mediaFormat != null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(mediaFormat);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(bufferInfo);
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-2);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.add(mediaFormat);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() ? null : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLast();
        C2790xk c2790xk = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2790xk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        c2790xk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        c2790xk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        C2790xk c2790xk2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2790xk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        c2790xk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        c2790xk2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }
}
