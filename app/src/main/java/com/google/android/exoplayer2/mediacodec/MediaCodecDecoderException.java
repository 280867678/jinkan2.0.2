package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.DecoderException;
import me.tvspark.C2069ec;
import me.tvspark.C2374ml;

/* loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {
    @Nullable
    public final C2069ec codecInfo;
    @Nullable
    public final String diagnosticInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaCodecDecoderException(Throwable th, @Nullable C2069ec c2069ec) {
        super(r1.length() != 0 ? "Decoder failed: ".concat(r1) : new String("Decoder failed: "), th);
        String str = null;
        String valueOf = String.valueOf(c2069ec == null ? null : c2069ec.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.codecInfo = c2069ec;
        this.diagnosticInfo = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 21 ? getDiagnosticInfoV21(th) : str;
    }

    @Nullable
    @RequiresApi(21)
    public static String getDiagnosticInfoV21(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
