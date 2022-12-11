package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* renamed from: me.tvspark.u5 */
/* loaded from: classes4.dex */
public interface AbstractC2660u5<I, O, E extends DecoderException> {
    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    I mo4971Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException;

    @Nullable
    /* renamed from: Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    O mo4972Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws DecoderException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(I i) throws DecoderException;

    void flush();

    void release();
}
