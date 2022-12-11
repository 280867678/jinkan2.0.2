package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.h5 */
/* loaded from: classes4.dex */
public final class C2173h5 extends AbstractC2136g5 {
    @Nullable
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2136g5
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (iArr == null) {
            return AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        }
        boolean z = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != iArr.length;
        int i = 0;
        while (i < iArr.length) {
            int i2 = iArr[i];
            if (i2 >= wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            }
            z |= i2 != i;
            i++;
        }
        return z ? new AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, iArr.length, 2) : AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr);
        int[] iArr2 = iArr;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((limit - position) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        while (position < limit) {
            for (int i : iArr2) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        byteBuffer.position(limit);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
    }
}
