package me.tvspark;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(23)
/* renamed from: me.tvspark.zb */
/* loaded from: classes4.dex */
public class C2855zb implements AbstractC2106fc {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2675uk Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AtomicReference<RuntimeException> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public Handler Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final HandlerThread Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final MediaCodec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww> Wwwwwwwwwwwwwwwwwwwwwwwwwww = new ArrayDeque<>();
    public static final Object Wwwwwwwwwwwwwwwwwwwwwwwwww = new Object();

    /* renamed from: me.tvspark.zb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final MediaCodec.CryptoInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new MediaCodec.CryptoInfo();
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    /* renamed from: me.tvspark.zb$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww extends Handler {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C2855zb c2855zb = C2855zb.this;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
            if (c2855zb != null) {
                int i = message.what;
                if (i == 0) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj;
                    try {
                        c2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueInputBuffer(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    } catch (RuntimeException e) {
                        c2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(e);
                    }
                } else if (i == 1) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) message.obj;
                    c2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                } else if (i != 2) {
                    c2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(new IllegalStateException(String.valueOf(message.what)));
                } else {
                    c2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                    return;
                }
                C2855zb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                return;
            }
            throw null;
        }
    }

    public C2855zb(MediaCodec mediaCodec, int i) {
        String str;
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
        boolean z = true;
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
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        C2675uk c2675uk = new C2675uk();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mediaCodec;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = handlerThread;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2675uk;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AtomicReference<>();
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("samsung") && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.contains("motorola")) {
            z = false;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
    }

    public static Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            return Wwwwwwwwwwwwwwwwwwwwwwwwwww.removeFirst();
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwww.add(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
    }

    @Nullable
    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        RuntimeException andSet = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getAndSet(null);
        if (andSet == null) {
            return;
        }
        throw andSet;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                synchronized (Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
                }
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.set(e);
        }
    }

    @Override // me.tvspark.AbstractC2106fc
    public void flush() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            try {
                Handler handler = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
                handler.removeCallbacksAndMessages(null);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                handler.obtainMessage(2).sendToTarget();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // me.tvspark.AbstractC2106fc
    public void shutdown() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            flush();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.quit();
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
    }

    @Override // me.tvspark.AbstractC2106fc
    public void start() {
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.start();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.getLooper());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        }
    }

    @Override // me.tvspark.AbstractC2106fc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3, long j, int i4) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4;
        Handler handler = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler);
        handler.obtainMessage(0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).sendToTarget();
    }

    @Override // me.tvspark.AbstractC2106fc
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, C2623t5 c2623t5, long j, int i3) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        MediaCodec.CryptoInfo cryptoInfo = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        cryptoInfo.numSubSamples = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        cryptoInfo.numBytesOfClearData = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cryptoInfo.numBytesOfEncryptedData);
        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cryptoInfo.key);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        cryptoInfo.key = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, cryptoInfo.iv);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        cryptoInfo.iv = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        cryptoInfo.mode = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwww, c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwww));
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.obtainMessage(1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2).sendToTarget();
    }
}
