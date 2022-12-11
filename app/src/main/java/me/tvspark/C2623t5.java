package me.tvspark;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* renamed from: me.tvspark.t5 */
/* loaded from: classes4.dex */
public final class C2623t5 {
    @Nullable
    public final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwww;
    public final MediaCodec.CryptoInfo Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    @RequiresApi(24)
    /* renamed from: me.tvspark.t5$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final MediaCodec.CryptoInfo.Pattern Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new MediaCodec.CryptoInfo.Pattern(0, 0);
        public final MediaCodec.CryptoInfo Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(MediaCodec.CryptoInfo cryptoInfo, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = cryptoInfo;
        }
    }

    public C2623t5() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = cryptoInfo;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 24 ? new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(cryptoInfo, null) : null;
    }
}
