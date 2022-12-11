package me.tvspark;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

@RequiresApi(23)
/* renamed from: me.tvspark.yb */
/* loaded from: classes4.dex */
public final class C2818yb extends MediaCodec.Callback implements AbstractC1978cc {
    @Nullable
    @GuardedBy("lock")
    public IllegalStateException Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2106fc Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @GuardedBy("lock")
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HandlerThread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final Object Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Object();
    @GuardedBy("lock")
    public final C2032dc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2032dc();

    @VisibleForTesting
    public C2818yb(MediaCodec mediaCodec, boolean z, int i, HandlerThread handlerThread) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mediaCodec;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handlerThread;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = z ? new C2855zb(mediaCodec, i) : new C2217ic(mediaCodec);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    public static String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        String str;
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i == 1) {
            str = "Audio";
        } else if (i == 2) {
            str = "Video";
        } else {
            sb.append("Unknown(");
            sb.append(i);
            str = ")";
        }
        sb.append(str);
        return sb.toString();
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 3) {
                long j = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i <= 0) {
                    if (i < 0) {
                        e = new IllegalStateException();
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                        try {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
                        } catch (IllegalStateException e) {
                            e = e;
                        } catch (Exception e2) {
                            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = new IllegalStateException(e2);
                        }
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwww = e;
                }
            }
        }
    }

    @GuardedBy("lock")
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        IllegalStateException illegalStateException = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (illegalStateException == null) {
            C2032dc c2032dc = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            IllegalStateException illegalStateException2 = c2032dc.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            c2032dc.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (illegalStateException2 != null) {
                throw illegalStateException2;
            }
            return;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        throw illegalStateException;
    }

    @Override // me.tvspark.AbstractC1978cc
    public MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC1978cc
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            boolean z = false;
            int i = -1;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                return -1;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            C2032dc c2032dc = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (c2032dc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                z = true;
            }
            if (!z) {
                i = c2032dc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return i;
        }
    }

    @Override // me.tvspark.AbstractC1978cc
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0) {
                return -1;
            }
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bufferInfo);
        }
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, long j, int i4) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, i3, j, i4);
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, C2623t5 c2623t5, long j, int i3) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, i2, c2623t5, j, i3);
    }

    @Override // me.tvspark.AbstractC1978cc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
        Handler handler = new Handler(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLooper());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handler;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.setCallback(this, handler);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.configure(mediaFormat, surface, mediaCrypto, i);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 1;
    }

    @Override // me.tvspark.AbstractC1978cc
    public void flush() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.flush();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flush();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            Handler handler = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
            handler.post(new Runnable() { // from class: me.tvspark.xb
                @Override // java.lang.Runnable
                public final void run() {
                    C2818yb.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
            });
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onOutputBufferAvailable(mediaCodec, i, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    @Override // me.tvspark.AbstractC1978cc
    public void shutdown() {
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.shutdown();
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.quit();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 3;
        }
    }

    @Override // me.tvspark.AbstractC1978cc
    public void start() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww.start();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 2;
    }

    @Override // me.tvspark.AbstractC1978cc
    public MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        MediaFormat mediaFormat;
        synchronized (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            mediaFormat = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }
}
