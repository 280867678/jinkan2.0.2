package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.AbstractC1978cc;
import me.tvspark.AbstractC2143gc;
import me.tvspark.AbstractC2183hf;
import me.tvspark.AbstractC2587s6;
import me.tvspark.AbstractC2846z2;
import me.tvspark.C1895a3;
import me.tvspark.C1904ac;
import me.tvspark.C1941bc;
import me.tvspark.C1987cl;
import me.tvspark.C2069ec;
import me.tvspark.C2180hc;
import me.tvspark.C2245j3;
import me.tvspark.C2282k3;
import me.tvspark.C2300kl;
import me.tvspark.C2358m5;
import me.tvspark.C2359m6;
import me.tvspark.C2374ml;
import me.tvspark.C2623t5;
import me.tvspark.C2661u6;
import me.tvspark.C2698v5;
import me.tvspark.C2738w5;
import me.tvspark.C2818yb;
import me.tvspark.C2827yk;
import me.tvspark.Illllllllllllllllllllllllllll;
import me.tvspark.outline;
import org.apache.commons.lang3.time.StopWatch;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;
import org.mozilla.javascript.regexp.NativeRegExp;

/* loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends AbstractC2846z2 {
    public static final byte[] IIlll = {0, 0, 1, 103, 66, ExifInterface.MARKER_SOF0, 11, ExifInterface.MARKER_SOS, 37, -112, 0, 0, 1, 104, ExifInterface.MARKER_SOF14, 15, NativeRegExp.REOP_UCFLAT1i, 32, 0, 0, 1, 101, -120, -124, 13, ExifInterface.MARKER_SOF14, 113, 24, -96, 0, NativeRegExp.REOP_MINIMALOPT, -65, NativeRegExp.REOP_OPT, NativeRegExp.REOP_ENDCHILD, ExifInterface.MARKER_SOF3, 39, 93, 120};
    public int IIllll;
    public long IIlllll;
    public long IIllllll;
    public C2698v5 IIlllllll;
    @Nullable
    public ExoPlaybackException IIllllllll;
    public int IIlllllllll;

    /* renamed from: Il */
    public boolean f555Il;
    public boolean Ill;
    public boolean Illl;
    public boolean Illll;
    public long Illlll;
    public long Illllll;
    public boolean Illlllll;
    public boolean Illllllll;
    public boolean Illlllllll;
    public int Illllllllll;
    public int Illlllllllll;
    public int Illllllllllll;
    public boolean Illlllllllllll;
    public boolean Illllllllllllll;
    public boolean Illlllllllllllll;
    public boolean Illllllllllllllll;
    public boolean Illlllllllllllllll;
    @Nullable
    public ByteBuffer Illllllllllllllllll;
    public int Illlllllllllllllllll;
    public int Illllllllllllllllllll;
    public long Illlllllllllllllllllll;
    public ByteBuffer[] Illllllllllllllllllllll;
    public ByteBuffer[] Illlllllllllllllllllllll;
    @Nullable
    public C1941bc Illllllllllllllllllllllll;
    public boolean Illlllllllllllllllllllllll;
    public boolean Illllllllllllllllllllllllll;
    public boolean Illlllllllllllllllllllllllll;
    public boolean Illllllllllllllllllllllllllll;

    /* renamed from: Kk */
    public boolean f556Kk;
    public boolean Kkk;
    public boolean Kkkk;
    public boolean Kkkkk;
    public boolean Kkkkkk;
    public boolean Kkkkkkk;
    public int Kkkkkkkk;
    @Nullable
    public C2069ec Kkkkkkkkk;
    @Nullable
    public DecoderInitializationException Kkkkkkkkkk;
    @Nullable
    public ArrayDeque<C2069ec> Kkkkkkkkkkk;
    public float Kkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkk;
    @Nullable
    public MediaFormat Kkkkkkkkkkkkkk;
    @Nullable
    public C2245j3 Kkkkkkkkkkkkkkk;
    @Nullable
    public AbstractC1978cc Kkkkkkkkkkkkkkkk;
    @Nullable
    public MediaCodec Kkkkkkkkkkkkkkkkk;
    public float Kkkkkkkkkkkkkkkkkk;
    public long Kkkkkkkkkkkkkkkkkkk;
    public boolean Kkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public MediaCrypto Kkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public DrmSession Kkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public DrmSession Kkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public C2245j3 Kkkkkkkkkkkkkkkkkkkkkkkk;
    @Nullable
    public C2245j3 Kkkkkkkkkkkkkkkkkkkkkkkkk;
    public final long[] Kkkkkkkkkkkkkkkkkkkkkkkkkk;
    public final long[] Www;
    public final long[] Wwww;
    public final MediaCodec.BufferInfo Wwwww;
    public final ArrayList<Long> Wwwwww;
    public final C2300kl<C2245j3> Wwwwwww;
    public final C1904ac Wwwwwwww;
    public final C2738w5 Wwwwwwwww;
    public final C2738w5 Wwwwwwwwww;
    public final float Wwwwwwwwwww;
    public final boolean Wwwwwwwwwwww;
    public final AbstractC2143gc Wwwwwwwwwwwww;

    /* loaded from: classes3.dex */
    public static class DecoderInitializationException extends Exception {
        public static final int CUSTOM_ERROR_CODE_BASE = -50000;
        public static final int DECODER_QUERY_ERROR = -49998;
        public static final int NO_SUITABLE_DECODER_ERROR = -49999;
        @Nullable
        public final C2069ec codecInfo;
        @Nullable
        public final String diagnosticInfo;
        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z, @Nullable C2069ec c2069ec, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = c2069ec;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DecoderInitializationException(C2245j3 c2245j3, @Nullable Throwable th, boolean z, int i) {
            this(r2.toString(), th, c2245j3.Wwwwwwwwwwwww, z, null, buildCustomDiagnosticInfo(i), null);
            String valueOf = String.valueOf(c2245j3);
            StringBuilder sb = new StringBuilder(valueOf.length() + 36);
            sb.append("Decoder init failed: [");
            sb.append(i);
            sb.append("], ");
            sb.append(valueOf);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DecoderInitializationException(C2245j3 c2245j3, @Nullable Throwable th, boolean z, C2069ec c2069ec) {
            this(r2.toString(), th, c2245j3.Wwwwwwwwwwwww, z, c2069ec, C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? getDiagnosticInfoV21(th) : null, null);
            String str = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            String valueOf = String.valueOf(c2245j3);
            StringBuilder sb = new StringBuilder(valueOf.length() + outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, 23));
            sb.append("Decoder init failed: ");
            sb.append(str);
            sb.append(", ");
            sb.append(valueOf);
        }

        public static String buildCustomDiagnosticInfo(int i) {
            String str = i < 0 ? "neg_" : "";
            int abs = Math.abs(i);
            StringBuilder sb = new StringBuilder(str.length() + 71);
            sb.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb.append(str);
            sb.append(abs);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        @RequiresApi(21)
        public static String getDiagnosticInfoV21(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    public MediaCodecRenderer(int i, AbstractC2143gc abstractC2143gc, boolean z, float f) {
        super(i);
        if (abstractC2143gc != null) {
            this.Wwwwwwwwwwwww = abstractC2143gc;
            this.Wwwwwwwwwwww = z;
            this.Wwwwwwwwwww = f;
            this.Wwwwwwwwww = new C2738w5(0);
            this.Wwwwwwwww = new C2738w5(0);
            this.Wwwwwww = new C2300kl<>();
            this.Wwwwww = new ArrayList<>();
            this.Wwwww = new MediaCodec.BufferInfo();
            this.Kkkkkkkkkkkkkkkkkk = 1.0f;
            this.IIlllllllll = 0;
            this.Kkkkkkkkkkkkkkkkkkk = -9223372036854775807L;
            this.Wwww = new long[10];
            this.Www = new long[10];
            this.Kkkkkkkkkkkkkkkkkkkkkkkkkk = new long[10];
            this.IIllllll = -9223372036854775807L;
            this.IIlllll = -9223372036854775807L;
            this.Wwwwwwww = new C1904ac();
            Kkkkkkkkkkkkkkkkkkkkkkkkkk();
            return;
        }
        throw null;
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        Class<? extends AbstractC2587s6> cls = c2245j3.Kkkkkkkkkkkkkkkkkk;
        return cls == null || C2661u6.class.equals(cls);
    }

    @RequiresApi(23)
    public final void Kkkkkkkkkkkkkkkkkkkkkkk() throws ExoPlaybackException {
        C2661u6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            Wwwww();
            Wwwwwwww();
        } else if (C1895a3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.equals(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            Wwwww();
            Wwwwwwww();
        } else if (Wwwwwwwwwww()) {
        } else {
            try {
                this.Kkkkkkkkkkkkkkkkkkkkk.setMediaDrmSession(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk);
                this.Illlllllllll = 0;
                this.Illllllllll = 0;
            } catch (MediaCryptoException e) {
                throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
            }
        }
    }

    public final void Kkkkkkkkkkkkkkkkkkkkkkkk() throws ExoPlaybackException {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23) {
            return;
        }
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwww());
        float f = this.Kkkkkkkkkkkk;
        if (f == Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1.0f) {
            Wwwwwwwwwwwwww();
        } else if (f == -1.0f && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= this.Wwwwwwwwwww) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Kkkkkkkkkkkkkkkkk.setParameters(bundle);
            this.Kkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    public final void Kkkkkkkkkkkkkkkkkkkkkkkkk() {
        this.Illllllllllllllllllll = -1;
        this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @CallSuper
    public void Kkkkkkkkkkkkkkkkkkkkkkkkkk() {
        Www();
        this.IIllllllll = null;
        this.Illllllllllllllllllllllll = null;
        this.Kkkkkkkkkkk = null;
        this.Kkkkkkkkk = null;
        this.Kkkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkkk = null;
        this.Kkkkkkkkkkkkk = false;
        this.Illlllll = false;
        this.Kkkkkkkkkkkk = -1.0f;
        this.Kkkkkkkk = 0;
        this.Kkkkkkk = false;
        this.Kkkkkk = false;
        this.Kkkkk = false;
        this.Kkkk = false;
        this.Kkk = false;
        this.f556Kk = false;
        this.Illllllllllllllllllllllllllll = false;
        this.Illlllllllllllllllllllllll = false;
        this.Illlllllllllll = false;
        this.Illllllllllll = 0;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
            this.Illlllllllllllllllllllll = null;
            this.Illllllllllllllllllllll = null;
        }
        this.Kkkkkkkkkkkkkkkkkkkk = false;
    }

    @CallSuper
    public void Www() {
        Kkkkkkkkkkkkkkkkkkkkkkkkk();
        this.Illlllllllllllllllll = -1;
        this.Illllllllllllllllll = null;
        this.Illlllllllllllllllllll = -9223372036854775807L;
        this.Illllllll = false;
        this.Illlllllll = false;
        this.Illlllllllllllllllllllllllll = false;
        this.Illllllllllllllllllllllllll = false;
        this.Illlllllllllllllll = false;
        this.Illllllllllllllll = false;
        this.Wwwwww.clear();
        this.Illllll = -9223372036854775807L;
        this.Illlll = -9223372036854775807L;
        C1941bc c1941bc = this.Illllllllllllllllllllllll;
        if (c1941bc != null) {
            c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
            c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0L;
            c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        }
        this.Illlllllllll = 0;
        this.Illllllllll = 0;
        this.Illllllllllll = this.Illlllllllllll ? 1 : 0;
    }

    public void Wwww() throws ExoPlaybackException {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.drm.DrmSession, android.media.MediaCrypto] */
    public void Wwwww() {
        try {
            if (this.Kkkkkkkkkkkkkkkk != null) {
                this.Kkkkkkkkkkkkkkkk.shutdown();
            }
            if (this.Kkkkkkkkkkkkkkkkk != null) {
                this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                this.Kkkkkkkkkkkkkkkkk.release();
            }
            this.Kkkkkkkkkkkkkkkkk = null;
            this.Kkkkkkkkkkkkkkkk = null;
            try {
                if (this.Kkkkkkkkkkkkkkkkkkkkk != null) {
                    this.Kkkkkkkkkkkkkkkkkkkkk.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.Kkkkkkkkkkkkkkkkk = null;
            this.Kkkkkkkkkkkkkkkk = null;
            try {
                if (this.Kkkkkkkkkkkkkkkkkkkkk != null) {
                    this.Kkkkkkkkkkkkkkkkkkkkk.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @TargetApi(23)
    public final void Wwwwww() throws ExoPlaybackException {
        int i = this.Illllllllll;
        if (i == 1) {
            Wwwwwwwwwww();
        } else if (i == 2) {
            Kkkkkkkkkkkkkkkkkkkkkkk();
        } else if (i != 3) {
            this.Illl = true;
            Wwww();
        } else {
            Wwwww();
            Wwwwwwww();
        }
    }

    public abstract void Wwwwwww();

    public final void Wwwwwwww() throws ExoPlaybackException {
        C2245j3 c2245j3;
        if (this.Kkkkkkkkkkkkkkkkk != null || this.Illlllllllllllll || (c2245j3 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk) == null) {
            return;
        }
        if (this.Kkkkkkkkkkkkkkkkkkkkkk == null && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3)) {
            C2245j3 c2245j32 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            Wwwwwwwwwwwwwww();
            String str = c2245j32.Wwwwwwwwwwwww;
            if ("audio/mp4a-latm".equals(str) || DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(str) || "audio/opus".equals(str)) {
                C1904ac c1904ac = this.Wwwwwwww;
                if (c1904ac != null) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                    c1904ac.Wwwwwwwwwwwww = 32;
                } else {
                    throw null;
                }
            } else {
                C1904ac c1904ac2 = this.Wwwwwwww;
                if (c1904ac2 == null) {
                    throw null;
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
                c1904ac2.Wwwwwwwwwwwww = 1;
            }
            this.Illlllllllllllll = true;
            return;
        }
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk);
        String str2 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwww;
        DrmSession drmSession = this.Kkkkkkkkkkkkkkkkkkkkkkk;
        if (drmSession != null) {
            if (this.Kkkkkkkkkkkkkkkkkkkkk == null) {
                C2661u6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drmSession);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        this.Kkkkkkkkkkkkkkkkkkkkk = mediaCrypto;
                        this.Kkkkkkkkkkkkkkkkkkkk = !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww && mediaCrypto.requiresSecureDecoderComponent(str2);
                    } catch (MediaCryptoException e) {
                        throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                    }
                } else if (this.Kkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == null) {
                    return;
                }
            }
            if (C2661u6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                int state = this.Kkkkkkkkkkkkkkkkkkkkkkk.getState();
                if (state == 1) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkk);
        } catch (DecoderInitializationException e2) {
            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        }
    }

    public boolean Wwwwwwwww() {
        return false;
    }

    public boolean Wwwwwwwwww() {
        if (this.Kkkkkkkkkkkkkkkkk == null) {
            return false;
        }
        if (this.Illllllllll == 3 || this.Kkkkk || ((this.Kkkk && !this.Illlllll) || (this.Kkk && this.Illllllll))) {
            Wwwww();
            return true;
        }
        try {
            this.Kkkkkkkkkkkkkkkk.flush();
            return false;
        } finally {
            Www();
        }
    }

    public final boolean Wwwwwwwwwww() throws ExoPlaybackException {
        boolean Wwwwwwwwww = Wwwwwwwwww();
        if (Wwwwwwwwww) {
            Wwwwwwww();
        }
        return Wwwwwwwwww;
    }

    public final boolean Wwwwwwwwwwww() throws ExoPlaybackException {
        if (this.Kkkkkkkkkkkkkkkkk == null || this.Illlllllllll == 2 || this.Illll) {
            return false;
        }
        if (this.Illllllllllllllllllll < 0) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Illllllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0) {
                return false;
            }
            this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? this.Kkkkkkkkkkkkkkkkk.getInputBuffer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) : this.Illlllllllllllllllllllll[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww];
            this.Wwwwwwwwww.clear();
        }
        if (this.Illlllllllll == 1) {
            if (!this.Illlllllllllllllllllllllll) {
                this.Illllllll = true;
                this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllll, 0, 0, 0L, 4);
                Kkkkkkkkkkkkkkkkkkkkkkkkk();
            }
            this.Illlllllllll = 2;
            return false;
        } else if (this.Illlllllllllllllllllllllllll) {
            this.Illlllllllllllllllllllllllll = false;
            this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.put(IIlll);
            this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllll, 0, IIlll.length, 0L, 0);
            Kkkkkkkkkkkkkkkkkkkkkkkkk();
            this.Illlllllll = true;
            return true;
        } else {
            if (this.Illllllllllll == 1) {
                for (int i = 0; i < this.Kkkkkkkkkkkkkkk.Wwwwwwwwwww.size(); i++) {
                    this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.put(this.Kkkkkkkkkkkkkkk.Wwwwwwwwwww.get(i));
                }
                this.Illllllllllll = 2;
            }
            int position = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.position();
            C2282k3 Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwww, false);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                this.Illlll = this.Illllll;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -3) {
                return false;
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
                if (this.Illllllllllll == 2) {
                    this.Wwwwwwwwww.clear();
                    this.Illllllllllll = 1;
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww);
                return true;
            } else if (this.Wwwwwwwwww.isEndOfStream()) {
                if (this.Illllllllllll == 2) {
                    this.Wwwwwwwwww.clear();
                    this.Illllllllllll = 1;
                }
                this.Illll = true;
                if (!this.Illlllllll) {
                    Wwwwww();
                    return false;
                }
                try {
                    if (!this.Illlllllllllllllllllllllll) {
                        this.Illllllll = true;
                        this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllll, 0, 0, 0L, 4);
                        Kkkkkkkkkkkkkkkkkkkkkkkkk();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                }
            } else if (!this.Illlllllll && !this.Wwwwwwwwww.isKeyFrame()) {
                this.Wwwwwwwwww.clear();
                if (this.Illllllllllll == 2) {
                    this.Illllllllllll = 1;
                }
                return true;
            } else {
                boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2623t5 c2623t5 = this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww;
                    if (c2623t5 == null) {
                        throw null;
                    }
                    if (position != 0) {
                        if (c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
                            int[] iArr = new int[1];
                            c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
                            c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwww.numBytesOfClearData = iArr;
                        }
                        int[] iArr2 = c2623t5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr2[0] = iArr2[0] + position;
                    }
                }
                if (this.Kkkkkk && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww);
                    if (this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.position() == 0) {
                        return true;
                    }
                    this.Kkkkkk = false;
                }
                C2738w5 c2738w5 = this.Wwwwwwwwww;
                long j = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
                C1941bc c1941bc = this.Illllllllllllllllllllllll;
                if (c1941bc != null) {
                    C2245j3 c2245j3 = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                    if (!c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        ByteBuffer byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwwwwww;
                        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                        int i2 = 0;
                        for (int i3 = 0; i3 < 4; i3++) {
                            i2 = (i2 << 8) | (byteBuffer.get(i3) & 255);
                        }
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2358m5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -1) {
                            c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
                            j = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
                        } else {
                            long j2 = c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            if (j2 == 0) {
                                long j3 = c2738w5.Wwwwwwwwwwwwwwwwwwwww;
                                c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j3;
                                c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 529;
                                j = j3;
                            } else {
                                c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = j2 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                                j = c1941bc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww + ((StopWatch.NANO_2_MILLIS * j2) / c2245j3.Kkkkkkkkkkkkkkkkkkkkkkk);
                            }
                        }
                    }
                }
                long j4 = j;
                if (this.Wwwwwwwwww.isDecodeOnly()) {
                    this.Wwwwww.add(Long.valueOf(j4));
                }
                if (this.Ill) {
                    this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j4, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                    this.Ill = false;
                }
                C1941bc c1941bc2 = this.Illllllllllllllllllllllll;
                long j5 = this.Illllll;
                this.Illllll = c1941bc2 != null ? Math.max(j5, this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwww) : Math.max(j5, j4);
                this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.Wwwwwwwwww.hasSupplementalData()) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
                }
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwww);
                try {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllll, 0, this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww, j4, 0);
                    } else {
                        this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Illllllllllllllllllll, 0, this.Wwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwww.limit(), j4, 0);
                    }
                    Kkkkkkkkkkkkkkkkkkkkkkkkk();
                    this.Illlllllll = true;
                    this.Illllllllllll = 0;
                    this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e2, this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
                }
            }
        }
    }

    public final void Wwwwwwwwwwwww() throws ExoPlaybackException {
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23) {
            Wwwwwwwwwwwwww();
        } else if (!this.Illlllllll) {
            Kkkkkkkkkkkkkkkkkkkkkkk();
        } else {
            this.Illlllllllll = 1;
            this.Illllllllll = 2;
        }
    }

    public final void Wwwwwwwwwwwwww() throws ExoPlaybackException {
        if (this.Illlllllll) {
            this.Illlllllllll = 1;
            this.Illllllllll = 3;
            return;
        }
        Wwwww();
        Wwwwwwww();
    }

    public final void Wwwwwwwwwwwwwww() {
        this.Illllllllllllll = false;
        this.Wwwwwwww.clear();
        this.Illlllllllllllll = false;
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwww() {
        try {
            Wwwwwwwwwwwwwww();
            Wwwww();
        } finally {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((DrmSession) null);
        }
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwww() {
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = null;
        this.IIllllll = -9223372036854775807L;
        this.IIlllll = -9223372036854775807L;
        this.IIllll = 0;
        if (this.Kkkkkkkkkkkkkkkkkkkkkk == null && this.Kkkkkkkkkkkkkkkkkkkkkkk == null) {
            Wwwwwwwwww();
        } else {
            Wwwwwwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.AbstractC1970c4
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 8;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) throws ExoPlaybackException {
        boolean z;
        C2245j3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null && this.Kkkkkkkkkkkkk) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
            this.Kkkkkkkkkkkkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.Kkkkkkkkkkkkk && this.Kkkkkkkkkkkkkkkkkkkkkkkk != null)) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkk);
            this.Kkkkkkkkkkkkk = false;
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable DrmSession drmSession) {
        C2359m6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkk, drmSession);
        this.Kkkkkkkkkkkkkkkkkkkkkk = drmSession;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        return this.Kkkkkkkkkkkkkkkkkkk == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.Kkkkkkkkkkkkkkkkkkk;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) throws ExoPlaybackException {
        boolean z;
        boolean z2;
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        boolean z3;
        if (!(this.Illlllllllllllllllll >= 0)) {
            if (!this.f556Kk || !this.Illllllll) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww);
            } else {
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww);
                } catch (IllegalStateException unused) {
                    Wwwwww();
                    if (this.Illl) {
                        Wwwww();
                    }
                    return false;
                }
            }
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < 0) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -2) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == -3) {
                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
                            this.Illllllllllllllllllllll = this.Kkkkkkkkkkkkkkkkk.getOutputBuffers();
                        }
                        return true;
                    }
                    if (this.Illlllllllllllllllllllllll && (this.Illll || this.Illlllllllll == 2)) {
                        Wwwwww();
                    }
                    return false;
                }
                this.Illlllll = true;
                MediaFormat Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Kkkkkkkkkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (this.Kkkkkkkk != 0 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getInteger("width") == 32 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.getInteger("height") == 32) {
                    this.Illllllllllllllllllllllllll = true;
                } else {
                    if (this.Illllllllllllllllllllllllllll) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.setInteger("channel-count", 1);
                    }
                    this.Kkkkkkkkkkkkkk = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    this.Kkkkkkkkkkkkk = true;
                }
                return true;
            } else if (this.Illllllllllllllllllllllllll) {
                this.Illllllllllllllllllllllllll = false;
                this.Kkkkkkkkkkkkkkkkk.releaseOutputBuffer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, false);
                return true;
            } else {
                MediaCodec.BufferInfo bufferInfo = this.Wwwww;
                if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                    Wwwwww();
                    return false;
                }
                this.Illlllllllllllllllll = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
                ByteBuffer outputBuffer = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? this.Kkkkkkkkkkkkkkkkk.getOutputBuffer(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) : this.Illllllllllllllllllllll[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2];
                this.Illllllllllllllllll = outputBuffer;
                if (outputBuffer != null) {
                    outputBuffer.position(this.Wwwww.offset);
                    ByteBuffer byteBuffer = this.Illllllllllllllllll;
                    MediaCodec.BufferInfo bufferInfo2 = this.Wwwww;
                    byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                }
                long j3 = this.Wwwww.presentationTimeUs;
                int size = this.Wwwwww.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z3 = false;
                        break;
                    } else if (this.Wwwwww.get(i).longValue() == j3) {
                        this.Wwwwww.remove(i);
                        z3 = true;
                        break;
                    } else {
                        i++;
                    }
                }
                this.Illlllllllllllllll = z3;
                this.Illllllllllllllll = this.Illlll == this.Wwwww.presentationTimeUs;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww.presentationTimeUs);
            }
        }
        if (!this.f556Kk || !this.Illllllll) {
            z = true;
            z2 = false;
            MediaCodec mediaCodec = this.Kkkkkkkkkkkkkkkkk;
            ByteBuffer byteBuffer2 = this.Illllllllllllllllll;
            int i2 = this.Illlllllllllllllllll;
            MediaCodec.BufferInfo bufferInfo3 = this.Wwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, mediaCodec, byteBuffer2, i2, bufferInfo3.flags, 1, bufferInfo3.presentationTimeUs, this.Illlllllllllllllll, this.Illllllllllllllll, this.Kkkkkkkkkkkkkkkkkkkkkkkk);
        } else {
            try {
                z2 = false;
                z = true;
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, this.Kkkkkkkkkkkkkkkkk, this.Illllllllllllllllll, this.Illlllllllllllllllll, this.Wwwww.flags, 1, this.Wwwww.presentationTimeUs, this.Illlllllllllllllll, this.Illllllllllllllll, this.Kkkkkkkkkkkkkkkkkkkkkkkk);
                } catch (IllegalStateException unused2) {
                    Wwwwww();
                    if (this.Illl) {
                        Wwwww();
                    }
                    return z2;
                }
            } catch (IllegalStateException unused3) {
                z2 = false;
            }
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwww.presentationTimeUs);
            boolean z4 = (this.Wwwww.flags & 4) != 0;
            this.Illlllllllllllllllll = -1;
            this.Illllllllllllllllll = null;
            if (!z4) {
                return z;
            }
            Wwwwww();
        }
        return z2;
    }

    @CallSuper
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
        while (true) {
            int i = this.IIllll;
            if (i == 0 || j < this.Kkkkkkkkkkkkkkkkkkkkkkkkkk[0]) {
                return;
            }
            long[] jArr = this.Wwww;
            this.IIllllll = jArr[0];
            this.IIlllll = this.Www[0];
            int i2 = i - 1;
            this.IIllll = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.Www;
            System.arraycopy(jArr2, 1, jArr2, 0, this.IIllll);
            long[] jArr3 = this.Kkkkkkkkkkkkkkkkkkkkkkkkkk;
            System.arraycopy(jArr3, 1, jArr3, 0, this.IIllll);
            Wwwwwww();
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(@Nullable DrmSession drmSession) {
        C2359m6.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkkkkkkk, drmSession);
        this.Kkkkkkkkkkkkkkkkkkkkkkk = drmSession;
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) throws ExoPlaybackException;

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e9, code lost:
        if ((r6.limit() + r7.position()) >= 3072000) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) throws ExoPlaybackException {
        C1904ac c1904ac;
        MediaCodecRenderer mediaCodecRenderer;
        boolean z;
        boolean z2;
        C1904ac c1904ac2 = this.Wwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!this.Illl);
        if (c1904ac2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            c1904ac = c1904ac2;
            mediaCodecRenderer = this;
        } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2, null, c1904ac2.Wwwwwwwwwwwwwwwwwwwwwww, this.Illlllllllllllllllll, 0, c1904ac2.Wwwwwwwwwwwwww, c1904ac2.Wwwwwwwwwwwwwww, c1904ac2.isDecodeOnly(), c1904ac2.isEndOfStream(), this.Kkkkkkkkkkkkkkkkkkkkkkkk)) {
            return false;
        } else {
            mediaCodecRenderer = this;
            c1904ac = c1904ac2;
            mediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c1904ac2.Wwwwwwwwwwwwwwwwwwwww);
        }
        if (c1904ac.isEndOfStream()) {
            mediaCodecRenderer.Illl = true;
            return false;
        }
        c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (mediaCodecRenderer.Illllllllllllll) {
            if (!c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                return true;
            }
            Wwwwwwwwwwwwwww();
            mediaCodecRenderer.Illllllllllllll = false;
            Wwwwwwww();
            if (!mediaCodecRenderer.Illlllllllllllll) {
                return false;
            }
        }
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!mediaCodecRenderer.Illll);
        C2282k3 Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww();
        while (true) {
            if (c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() || c1904ac.isEndOfStream()) {
                break;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = mediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww, c1904ac.Wwwwwwwwwwwwwwwww, false);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
                z = true;
                break;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -4) {
                C2738w5 c2738w5 = c1904ac.Wwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwww() && !c1904ac.isEndOfStream());
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(!c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && !c2738w5.hasSupplementalData());
                if (!c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                    if (c2738w5.isDecodeOnly() == c1904ac.isDecodeOnly()) {
                        ByteBuffer byteBuffer = c2738w5.Wwwwwwwwwwwwwwwwwwwwwww;
                        if (byteBuffer != null && (r7 = c1904ac.Wwwwwwwwwwwwwwwwwwwwwww) != null) {
                        }
                    }
                    z2 = false;
                    if (z2) {
                        c1904ac.Wwwwwwwwwwwwwwww = true;
                    } else {
                        c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2738w5);
                    }
                }
                z2 = true;
                if (z2) {
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -3) {
                throw new IllegalStateException();
            }
        }
        z = false;
        if (!c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() && mediaCodecRenderer.Ill) {
            C2245j3 c2245j3 = mediaCodecRenderer.Kkkkkkkkkkkkkkkkkkkkkkkkk;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
            C2245j3 c2245j32 = c2245j3;
            mediaCodecRenderer.Kkkkkkkkkkkkkkkkkkkkkkkk = c2245j32;
            mediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j32, (MediaFormat) null);
            mediaCodecRenderer.Ill = false;
        }
        if (z) {
            mediaCodecRenderer.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww);
        }
        if (c1904ac.isEndOfStream()) {
            mediaCodecRenderer.Illll = true;
        }
        if (c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            return false;
        }
        c1904ac.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        c1904ac.Wwwwwwwwwwwwwwwwwwwwwww.order(ByteOrder.nativeOrder());
        return true;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) {
        return false;
    }

    public abstract float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f, C2245j3 c2245j3, C2245j3[] c2245j3Arr);

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec mediaCodec, C2069ec c2069ec, C2245j3 c2245j3, C2245j3 c2245j32);

    public abstract int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3) throws MediaCodecUtil.DecoderQueryException;

    @Override // me.tvspark.AbstractC1970c4
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3) throws ExoPlaybackException {
        try {
            return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, c2245j3);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, c2245j3);
        }
    }

    public MediaCodecDecoderException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Throwable th, @Nullable C2069ec c2069ec) {
        return new MediaCodecDecoderException(th, c2069ec);
    }

    public abstract List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC2143gc abstractC2143gc, C2245j3 c2245j3, boolean z) throws MediaCodecUtil.DecoderQueryException;

    @Nullable
    public final C2661u6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(DrmSession drmSession) throws ExoPlaybackException {
        AbstractC2587s6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = drmSession.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null || (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww instanceof C2661u6)) {
            return (C2661u6) Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        String valueOf = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        StringBuilder sb = new StringBuilder(valueOf.length() + 42);
        sb.append("Expecting FrameworkMediaCrypto but found: ");
        sb.append(valueOf);
        throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new IllegalArgumentException(sb.toString()), this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, boolean z) throws ExoPlaybackException {
        this.Illll = false;
        this.Illl = false;
        this.f555Il = false;
        if (this.Illlllllllllllll) {
            this.Wwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        } else {
            Wwwwwwwwwww();
        }
        if (this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            this.Ill = true;
        }
        this.Wwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        int i = this.IIllll;
        if (i != 0) {
            this.IIlllll = this.Www[i - 1];
            this.IIllllll = this.Wwww[i - 1];
            this.IIllll = 0;
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str, long j, long j2);

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, MediaCrypto mediaCrypto) throws Exception {
        AbstractC1978cc abstractC1978cc;
        MediaCodec mediaCodec;
        AbstractC1978cc c2180hc;
        AbstractC1978cc abstractC1978cc2;
        String str = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 23 ? -1.0f : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkkk, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, Wwwwwwwwwwwwwwwwwwww());
        float f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= this.Wwwwwwwwwww ? -1.0f : Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String valueOf = String.valueOf(str);
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                if (this.IIlllllllll == 2 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
                    int i = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    c2180hc = new C2818yb(mediaCodec, false, i, new HandlerThread(C2818yb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)));
                } else if (this.IIlllllllll == 4 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23) {
                    int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwww;
                    c2180hc = new C2818yb(mediaCodec, true, i2, new HandlerThread(C2818yb.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2)));
                } else {
                    c2180hc = new C2180hc(mediaCodec);
                }
                AbstractC1978cc abstractC1978cc3 = c2180hc;
                try {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("configureCodec");
                } catch (Exception e) {
                    e = e;
                    abstractC1978cc2 = abstractC1978cc3;
                }
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2069ec, abstractC1978cc3, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, mediaCrypto, f);
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("startCodec");
                    abstractC1978cc3.start();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
                        this.Illlllllllllllllllllllll = mediaCodec.getInputBuffers();
                        this.Illllllllllllllllllllll = mediaCodec.getOutputBuffers();
                    }
                    this.Kkkkkkkkkkkkkkkkk = mediaCodec;
                    this.Kkkkkkkkkkkkkkkk = abstractC1978cc3;
                    this.Kkkkkkkkk = c2069ec;
                    this.Kkkkkkkkkkkk = f;
                    this.Kkkkkkkkkkkkkkk = this.Kkkkkkkkkkkkkkkkkkkkkkkkk;
                    this.Kkkkkkkk = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 25 || !"OMX.Exynos.avc.dec.secure".equals(str) || (!C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-T585") && !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-A510") && !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-A520") && !C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-J700"))) ? (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24 || (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) || (!"flounder".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"flounder_lte".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"grouper".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && !"tilapia".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww))) ? 0 : 1 : 2;
                    this.Kkkkkkk = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
                    this.Kkkkkk = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 && this.Kkkkkkkkkkkkkkk.Wwwwwwwwwww.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
                    int i3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Kkkkk = i3 < 18 || (i3 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 19 && C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
                    this.Kkkk = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 29 && "c2.android.aac.decoder".equals(str);
                    this.Kkk = (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 19 && (("hb2000".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) || "stvm8".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
                    this.f556Kk = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 21 && "OMX.google.aac.decoder".equals(str);
                    this.Illllllllllllllllllllllllllll = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 18 && this.Kkkkkkkkkkkkkkk.Kkkkkkkkkkkkkkkkkkkkkkkk == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
                    String str2 = c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    this.Illlllllllllllllllllllllll = ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 25 && "OMX.rk.video_decoder.avc".equals(str2)) || ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 17 && "OMX.allwinner.video.decoder.avc".equals(str2)) || ((C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str2) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str2))) || ("Amazon".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && "AFTS".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) && c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww)))) || Wwwwwwwww();
                    if ("c2.android.mp3.decoder".equals(c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        this.Illllllllllllllllllllllll = new C1941bc();
                    }
                    if (this.Wwwwwwwwwwwwwwwwwwww == 2) {
                        this.Illlllllllllllllllllll = SystemClock.elapsedRealtime() + 1000;
                    }
                    this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                } catch (Exception e2) {
                    e = e2;
                    abstractC1978cc2 = abstractC1978cc3;
                    abstractC1978cc = abstractC1978cc2;
                    if (abstractC1978cc != null) {
                        abstractC1978cc.shutdown();
                    }
                    if (mediaCodec != null) {
                        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21) {
                            this.Illlllllllllllllllllllll = null;
                            this.Illllllllllllllllllllll = null;
                        }
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                abstractC1978cc = null;
            }
        } catch (Exception e4) {
            e = e4;
            abstractC1978cc = null;
            mediaCodec = null;
        }
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec, AbstractC1978cc abstractC1978cc, C2245j3 c2245j3, @Nullable MediaCrypto mediaCrypto, float f);

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2738w5 c2738w5) throws ExoPlaybackException {
    }

    @Override // me.tvspark.AbstractC2846z2
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3[] c2245j3Arr, long j, long j2) throws ExoPlaybackException {
        boolean z = true;
        if (this.IIlllll == -9223372036854775807L) {
            if (this.IIllllll != -9223372036854775807L) {
                z = false;
            }
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z);
            this.IIllllll = j;
            this.IIlllll = j2;
            return;
        }
        int i = this.IIllll;
        long[] jArr = this.Www;
        if (i == jArr.length) {
            long j3 = jArr[i - 1];
        } else {
            this.IIllll = i + 1;
        }
        long[] jArr2 = this.Wwww;
        int i2 = this.IIllll;
        jArr2[i2 - 1] = j;
        this.Www[i2 - 1] = j2;
        this.Kkkkkkkkkkkkkkkkkkkkkkkkkk[i2 - 1] = this.Illllll;
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Illl;
    }

    public abstract boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2, @Nullable MediaCodec mediaCodec, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, C2245j3 c2245j3) throws ExoPlaybackException;

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2069ec c2069ec) {
        return true;
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) throws ExoPlaybackException {
        C2282k3 Wwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwww.clear();
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwww, z);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -5) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwww);
            return true;
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -4 || !this.Wwwwwwwww.isEndOfStream()) {
            return false;
        } else {
            this.Illll = true;
            Wwwwww();
            return false;
        }
    }

    @Override // me.tvspark.AbstractC1896a4
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk != null) {
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwww;
            } else {
                AbstractC2183hf abstractC2183hf = this.Wwwwwwwwwwwwwwwwwww;
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf);
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = abstractC2183hf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
            if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                if (!(this.Illlllllllllllllllll >= 0) && (this.Illlllllllllllllllllll == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.Illlllllllllllllllllll)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        if (this.Kkkkkkkkkkk == null) {
            try {
                List<C2069ec> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, z);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty() && z) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwww, this.Kkkkkkkkkkkkkkkkkkkkkkkkk, false);
                    if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                        String str = this.Kkkkkkkkkkkkkkkkkkkkkkkkk.Wwwwwwwwwwwww;
                        String valueOf = String.valueOf(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                        String.valueOf(str).length();
                        valueOf.length();
                    }
                }
                ArrayDeque<C2069ec> arrayDeque = new ArrayDeque<>();
                this.Kkkkkkkkkkk = arrayDeque;
                if (this.Wwwwwwwwwwww) {
                    arrayDeque.addAll(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                } else if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
                    this.Kkkkkkkkkkk.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.get(0));
                }
                this.Kkkkkkkkkk = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, e, z, (int) DecoderInitializationException.DECODER_QUERY_ERROR);
            }
        }
        if (!this.Kkkkkkkkkkk.isEmpty()) {
            while (this.Kkkkkkkkkkkkkkkkk == null) {
                C2069ec peekFirst = this.Kkkkkkkkkkk.peekFirst();
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peekFirst)) {
                    return;
                }
                try {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(peekFirst, mediaCrypto);
                } catch (Exception e2) {
                    String valueOf2 = String.valueOf(peekFirst);
                    StringBuilder sb = new StringBuilder(valueOf2.length() + 30);
                    sb.append("Failed to initialize decoder: ");
                    sb.append(valueOf2);
                    C2827yk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(sb.toString(), e2);
                    this.Kkkkkkkkkkk.removeFirst();
                    DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, e2, z, peekFirst);
                    DecoderInitializationException decoderInitializationException2 = this.Kkkkkkkkkk;
                    if (decoderInitializationException2 == null) {
                        this.Kkkkkkkkkk = decoderInitializationException;
                    } else {
                        this.Kkkkkkkkkk = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                    }
                    if (this.Kkkkkkkkkkk.isEmpty()) {
                        throw this.Kkkkkkkkkk;
                    }
                }
            }
            this.Kkkkkkkkkkk = null;
            return;
        }
        throw new DecoderInitializationException(this.Kkkkkkkkkkkkkkkkkkkkkkkkk, (Throwable) null, z, (int) DecoderInitializationException.NO_SUITABLE_DECODER_ERROR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r6 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b9, code lost:
        if (r1.Wwwwwww == r2.Wwwwwww) goto L70;
     */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2282k3 c2282k3) throws ExoPlaybackException {
        boolean requiresSecureDecoderComponent;
        boolean z = true;
        this.Ill = true;
        C2245j3 c2245j3 = c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2245j3);
        C2245j3 c2245j32 = c2245j3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2282k3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Kkkkkkkkkkkkkkkkkkkkkkkkk = c2245j32;
        if (this.Illlllllllllllll) {
            this.Illllllllllllll = true;
        } else if (this.Kkkkkkkkkkkkkkkkk == null) {
            this.Kkkkkkkkkkk = null;
            Wwwwwwww();
        } else {
            if ((this.Kkkkkkkkkkkkkkkkkkkkkk != null || this.Kkkkkkkkkkkkkkkkkkkkkkk == null) && (this.Kkkkkkkkkkkkkkkkkkkkkk == null || this.Kkkkkkkkkkkkkkkkkkkkkkk != null)) {
                DrmSession drmSession = this.Kkkkkkkkkkkkkkkkkkkkkk;
                if (drmSession != this.Kkkkkkkkkkkkkkkkkkkkkkk && !this.Kkkkkkkkk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    C2661u6 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(drmSession);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                            requiresSecureDecoderComponent = false;
                        } else {
                            try {
                                MediaCrypto mediaCrypto = new MediaCrypto(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                                try {
                                    requiresSecureDecoderComponent = mediaCrypto.requiresSecureDecoderComponent(c2245j32.Wwwwwwwwwwwww);
                                } finally {
                                    mediaCrypto.release();
                                }
                            } catch (MediaCryptoException unused) {
                            }
                        }
                    }
                    requiresSecureDecoderComponent = true;
                }
                if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 23 || this.Kkkkkkkkkkkkkkkkkkkkkk == this.Kkkkkkkkkkkkkkkkkkkkkkk) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Kkkkkkkkkkkkkkkkk, this.Kkkkkkkkk, this.Kkkkkkkkkkkkkkk, c2245j32);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 0) {
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1) {
                            this.Kkkkkkkkkkkkkkk = c2245j32;
                            Kkkkkkkkkkkkkkkkkkkkkkkk();
                            if (this.Kkkkkkkkkkkkkkkkkkkkkk == this.Kkkkkkkkkkkkkkkkkkkkkkk) {
                                if (!this.Illlllllll) {
                                    return;
                                }
                                this.Illlllllllll = 1;
                                this.Illllllllll = 1;
                                return;
                            }
                        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 2) {
                            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != 3) {
                                throw new IllegalStateException();
                            }
                            this.Kkkkkkkkkkkkkkk = c2245j32;
                            Kkkkkkkkkkkkkkkkkkkkkkkk();
                            if (this.Kkkkkkkkkkkkkkkkkkkkkk == this.Kkkkkkkkkkkkkkkkkkkkkkk) {
                                return;
                            }
                        } else if (!this.Kkkkkkk) {
                            this.Illlllllllllll = true;
                            this.Illllllllllll = 1;
                            int i = this.Kkkkkkkk;
                            if (i != 2) {
                                if (i == 1) {
                                    int i2 = c2245j32.Wwwwwwww;
                                    C2245j3 c2245j33 = this.Kkkkkkkkkkkkkkk;
                                    if (i2 == c2245j33.Wwwwwwww) {
                                    }
                                }
                                z = false;
                            }
                            this.Illlllllllllllllllllllllllll = z;
                            this.Kkkkkkkkkkkkkkk = c2245j32;
                            Kkkkkkkkkkkkkkkkkkkkkkkk();
                            if (this.Kkkkkkkkkkkkkkkkkkkkkk == this.Kkkkkkkkkkkkkkkkkkkkkkk) {
                                return;
                            }
                        }
                        Wwwwwwwwwwwww();
                        return;
                    }
                    Wwwwwwwwwwwwww();
                    return;
                }
            }
            Wwwwwwwwwwwwww();
        }
    }

    @Override // me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j, long j2) throws ExoPlaybackException {
        boolean z = false;
        if (this.f555Il) {
            this.f555Il = false;
            Wwwwww();
        }
        ExoPlaybackException exoPlaybackException = this.IIllllllll;
        if (exoPlaybackException != null) {
            this.IIllllllll = null;
            throw exoPlaybackException;
        }
        boolean z2 = true;
        try {
            if (this.Illl) {
                Wwww();
            } else if (this.Kkkkkkkkkkkkkkkkkkkkkkkkk == null && !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true)) {
            } else {
                Wwwwwwww();
                if (this.Illlllllllllllll) {
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("bypassRender");
                    while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2)) {
                    }
                } else if (this.Kkkkkkkkkkkkkkkkk == null) {
                    C2698v5 c2698v5 = this.IIlllllll;
                    int i = c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    AbstractC2183hf abstractC2183hf = this.Wwwwwwwwwwwwwwwwwww;
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC2183hf);
                    c2698v5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i + abstractC2183hf.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j - this.Wwwwwwwwwwwwwwwww);
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false);
                    this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("drainAndFeed");
                    while (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, j2) && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elapsedRealtime)) {
                    }
                    while (Wwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(elapsedRealtime)) {
                    }
                }
                Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                this.IIlllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            }
        } catch (IllegalStateException e) {
            if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 21 || !(e instanceof MediaCodec.CodecException)) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                if (stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                throw e;
            }
            throw Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(e, this.Kkkkkkkkk), this.Kkkkkkkkkkkkkkkkkkkkkkkkk);
        }
    }

    @Override // me.tvspark.AbstractC2846z2, me.tvspark.AbstractC1896a4
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f) throws ExoPlaybackException {
        this.Kkkkkkkkkkkkkkkkkk = f;
        if (this.Kkkkkkkkkkkkkkkkk == null || this.Illllllllll == 3 || this.Wwwwwwwwwwwwwwwwwwww == 0) {
            return;
        }
        Kkkkkkkkkkkkkkkkkkkkkkkk();
    }
}
