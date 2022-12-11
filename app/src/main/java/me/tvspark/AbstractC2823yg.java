package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.yg */
/* loaded from: classes4.dex */
public abstract class AbstractC2823yg extends AbstractC2812y5<C2037dh, AbstractC2074eh, SubtitleDecoderException> implements AbstractC1946bh {
    public AbstractC2823yg(String str) {
        super(new C2037dh[2], new AbstractC2074eh[2]);
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
        for (C2738w5 c2738w5 : this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            c2738w5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1024);
        }
    }

    @Override // me.tvspark.AbstractC2812y5
    @Nullable
    public SubtitleDecoderException Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2037dh c2037dh, AbstractC2074eh abstractC2074eh, boolean z) {
        C2037dh c2037dh2 = c2037dh;
        AbstractC2074eh abstractC2074eh2 = abstractC2074eh;
        try {
            ByteBuffer byteBuffer = c2037dh2.Wwwwwwwwwwwwwwwwwwwwwww;
            Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
            abstractC2074eh2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2037dh2.Wwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.array(), byteBuffer.limit(), z), c2037dh2.Wwwwwwwwwwwwwwwww);
            abstractC2074eh2.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    public abstract AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException;

    @Override // me.tvspark.AbstractC1946bh
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(long j) {
    }
}
