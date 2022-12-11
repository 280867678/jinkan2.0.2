package me.tvspark;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.stub.StubApp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.tvspark.AbstractC1896a4;
import me.tvspark.AbstractC1971c5;
import me.tvspark.C2245j3;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* renamed from: me.tvspark.l5 */
/* loaded from: classes4.dex */
public class C2321l5 extends MediaCodecRenderer implements AbstractC1913al {
    public final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww IIl;
    public final Context IIll;
    @Nullable
    public AbstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww O00;
    public boolean O000;
    public boolean O0000;
    public long O00000;
    @Nullable
    public C2245j3 O000000;
    public boolean O0000000;
    public boolean O00000000;
    public int O000000000;
    public final AudioSink O0000000000;

    /* renamed from: me.tvspark.l5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AudioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        }
    }

    public C2321l5(Context context, AbstractC2143gc abstractC2143gc, boolean z, @Nullable Handler handler, @Nullable AbstractC1971c5 abstractC1971c5, AudioSink audioSink) {
        super(1, abstractC2143gc, z, 44100.0f);
        this.IIll = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.O0000000000 = audioSink;
        this.IIl = new AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(handler, abstractC1971c5);
        audioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(null));
    }

    public final void Kkkkkkkkkkkkkkkkkkkkkk() {
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != Long.MIN_VALUE) {
            if (!this.O000) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Math.max(this.O00000, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            }
            this.O00000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.O000 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwww() throws ExoPlaybackException {
        try {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } catch (AudioSink.WriteException e) {
            C2245j3 c2245j3 = this.Kkkkkkkkkkkkkkkkkkkkkkkk;
            if (c2245j3 == null) {
                c2245j3 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            }
            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, c2245j3);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwww() {
        this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwww() {
        Kkkkkkkkkkkkkkkkkkkkkk();
        this.O0000000000.pause();
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwww() {
        this.O0000000000.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwww() {
        try {
            super.Wwwwwwwwwwwwwwwwww();
        } finally {
            this.O0000000000.reset();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        try {
            this.O0000000000.flush();
            try {
                super.Wwwwwwwwwwwwwwwwwww();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.Wwwwwwwwwwwwwwwwwww();
                throw th;
            } finally {
            }
        }
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.AbstractC1896a4
    @Nullable
    public AbstractC1913al Wwwwwwwwwwwwwwwwwwwwww() {
        return this;
    }

    @Override // me.tvspark.AbstractC1913al
    public long Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwww == 2) {
            Kkkkkkkkkkkkkkkkkkkkkk();
        }
        return this.O00000;
    }

    @Override // me.tvspark.AbstractC1913al
    public C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) {
        if (!this.O0000 || c2738w5.isDecodeOnly()) {
            return;
        }
        if (Math.abs(c2738w5.Wwwwwwwwwwwwwwwwwwwww - this.O00000) > 500000) {
            this.O00000 = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
        }
        this.O0000 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() || super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        return this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, C2245j3 c2245j3, C2245j3[] c2245j3Arr) {
        int i = -1;
        for (C2245j3 c2245j32 : c2245j3Arr) {
            int i2 = c2245j32.Kkkkkkkkkkkkkkkkkkkkkkk;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return f * i;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, C2069ec c2069ec, C2245j3 c2245j3, C2245j3 c2245j32) {
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j32) > this.O000000000) {
            return 0;
        }
        if (c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, c2245j32, true)) {
            return 3;
        }
        return C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Object) c2245j3.Wwwwwwwwwwwww, (Object) c2245j32.Wwwwwwwwwwwww) && c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk == c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkk && c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk == c2245j32.Kkkkkkkkkkkkkkkkkkkkkkk && c2245j3.Kkkkkkkkkkkkkkkkkkkkkk == c2245j32.Kkkkkkkkkkkkkkkkkkkkkk && c2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32) && !"audio/opus".equals(c2245j3.Wwwwwwwwwwwww) ? 1 : 0;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, C2245j3 c2245j3) {
        int i;
        if (!"OMX.google.raw.decoder".equals(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || (i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) >= 24 || (i == 23 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.IIll))) {
            return c2245j3.Wwwwwwwwwwww;
        }
        return -1;
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.C2773x3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Float) obj).floatValue());
        } else if (i == 3) {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2848z4) obj);
        } else if (i == 5) {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((C2099f5) obj);
        } else {
            switch (i) {
                case 101:
                    this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Boolean) obj).booleanValue());
                    return;
                case 102:
                    this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((Integer) obj).intValue());
                    return;
                case 103:
                    this.O00 = (AbstractC1896a4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) obj;
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) throws ExoPlaybackException {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, z);
        this.O0000000000.flush();
        this.O00000 = j;
        this.O0000 = true;
        this.O000 = true;
    }

    @Override // me.tvspark.AbstractC1913al
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3) {
        this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2658u3);
    }

    @Override // me.tvspark.AbstractC1896a4, me.tvspark.AbstractC1970c4
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, AbstractC1978cc abstractC1978cc, C2245j3 c2245j3, @Nullable MediaCrypto mediaCrypto, float f) {
        C2245j3[] Wwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwww();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j3);
        boolean z = false;
        if (Wwwwwwwwwwwwwwwwwwww.length != 1) {
            for (C2245j3 c2245j32 : Wwwwwwwwwwwwwwwwwwww) {
                if (c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3, c2245j32, false)) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Math.max(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, c2245j32));
                }
            }
        }
        this.O000000000 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.O00000000 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 24 && "OMX.SEC.aac.dec".equals(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && "samsung".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("zeroflte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("herolte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("heroqlte"));
        this.O0000000 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && "OMX.SEC.mp3.dec".equals(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && "samsung".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("baffin") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("grand") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("fortuna") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("gprimelte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("j2y18lte") || C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("ms01"));
        String str = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = this.O000000000;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("channel-count", c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk);
        mediaFormat.setInteger("sample-rate", c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, c2245j3.Wwwwwwwwwww);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, "max-input-size", i);
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (!(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 23 && ("ZTE B2017G".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "AXON 7 mini".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)))) {
                    mediaFormat.setFloat("operating-rate", f);
                }
            }
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 28 && "audio/ac4".equals(c2245j3.Wwwwwwwwwwwww)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24) {
            AudioSink audioSink = this.O0000000000;
            int i2 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
            int i3 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/raw";
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = i2;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = i3;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww = 4;
            if (audioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        abstractC1978cc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat, null, mediaCrypto, 0);
        if ("audio/raw".equals(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"audio/raw".equals(c2245j3.Wwwwwwwwwwwww)) {
            z = true;
        }
        if (!z) {
            c2245j3 = null;
        }
        this.O000000 = c2245j3;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3, boolean z) throws MediaCodecUtil.DecoderQueryException {
        C2069ec Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        String str = c2245j3.Wwwwwwwwwwwww;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) && (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("audio/raw", false, false)) != null) {
            return Collections.singletonList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, z, false), c2245j3);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
            arrayList.addAll(abstractC2143gc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("audio/eac3", z, false));
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = arrayList;
        }
        return Collections.unmodifiableList(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Illl && this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(final String str, final long j, final long j2) {
        final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.IIl;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.p4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, j, j2);
                }
            });
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z, boolean z2) throws ExoPlaybackException {
        final C2698v5 c2698v5 = new C2698v5();
        this.IIlllllll = c2698v5;
        final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.IIl;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.r4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2698v5);
                }
            });
        }
        C2007d4 c2007d4 = this.Wwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2007d4);
        int i = c2007d4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i != 0) {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
        } else {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3) throws ExoPlaybackException {
        super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3);
        final AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.IIl;
        final C2245j3 c2245j3 = c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Handler handler = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (handler != null) {
            handler.post(new Runnable() { // from class: me.tvspark.o4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC1971c5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0083 A[LOOP:0: B:16:0x007f->B:18:0x0083, LOOP_END] */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        int i2;
        int i3;
        C2245j3 c2245j32 = this.O000000;
        int[] iArr = null;
        if (c2245j32 == null) {
            if (this.Kkkkkkkkkkkkkkkkk == null) {
                c2245j32 = c2245j3;
            } else {
                if (!"audio/raw".equals(c2245j3.Wwwwwwwwwwwww)) {
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                        i = mediaFormat.getInteger("pcm-encoding");
                    } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                        i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(mediaFormat.getInteger("v-bits-per-sample"));
                    } else if (!"audio/raw".equals(c2245j3.Wwwwwwwwwwwww)) {
                        i = 2;
                    }
                    C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/raw";
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww = i;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkkk;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkk;
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = mediaFormat.getInteger("channel-count");
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = mediaFormat.getInteger("sample-rate");
                    c2245j32 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    if (this.O00000000 && c2245j32.Kkkkkkkkkkkkkkkkkkkkkkkk == 6 && (i2 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk) < 6) {
                        iArr = new int[i2];
                        for (i3 = 0; i3 < c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk; i3++) {
                            iArr[i3] = i3;
                        }
                    }
                }
                i = c2245j3.Kkkkkkkkkkkkkkkkkkkkkk;
                C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/raw";
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwww = i;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkkk;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwww = c2245j3.Kkkkkkkkkkkkkkkkkkkk;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwww = mediaFormat.getInteger("channel-count");
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwww = mediaFormat.getInteger("sample-rate");
                c2245j32 = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.O00000000) {
                    iArr = new int[i2];
                    while (i3 < c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk) {
                    }
                }
            }
        }
        try {
            this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, c2245j3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r6 != (-9223372036854775807L)) goto L12;
     */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, @Nullable MediaCodec mediaCodec, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, C2245j3 c2245j3) throws ExoPlaybackException {
        long j4;
        if (byteBuffer != null) {
            if (mediaCodec != null && this.O0000000 && j3 == 0 && (i2 & 4) != 0) {
                j4 = this.Illllll;
            }
            j4 = j3;
            if (this.O000000 != null && (i2 & 2) != 0) {
                if (mediaCodec == null) {
                    throw null;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                return true;
            } else if (z) {
                if (mediaCodec != null) {
                    mediaCodec.releaseOutputBuffer(i, false);
                }
                this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
                this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                return true;
            } else {
                try {
                    if (!this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, j4, i3)) {
                        return false;
                    }
                    if (mediaCodec != null) {
                        mediaCodec.releaseOutputBuffer(i, false);
                    }
                    this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww += i3;
                    return true;
                } catch (AudioSink.InitializationException | AudioSink.WriteException e) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, c2245j3);
                }
            }
        }
        throw null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3) throws MediaCodecUtil.DecoderQueryException {
        if (!C1950bl.Wwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3.Wwwwwwwwwwwww)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
        }
        int i = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? 32 : 0;
        boolean z = c2245j3.Kkkkkkkkkkkkkkkkkk != null;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = MediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        int i2 = 8;
        int i3 = 4;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3) && (!z || MediaCodecUtil.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("audio/raw", false, false) != null)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4, 8, i);
        }
        if ("audio/raw".equals(c2245j3.Wwwwwwwwwwwww) && !this.O0000000000.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        AudioSink audioSink = this.O0000000000;
        int i4 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkkk;
        int i5 = c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk;
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/raw";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = i4;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = i5;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwww = 2;
        if (!audioSink.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww())) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2143gc, c2245j3, false);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.isEmpty()) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
        }
        C2069ec c2069ec = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.get(0);
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 && c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
            i2 = 16;
        }
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
            i3 = 3;
        }
        return C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i2, i);
    }
}
