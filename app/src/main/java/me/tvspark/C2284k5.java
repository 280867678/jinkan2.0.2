package me.tvspark;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.k5 */
/* loaded from: classes4.dex */
public final class C2284k5 extends AbstractC2136g5 {
    public static final int Wwwwwwwwwwwwwwwwwwwwwwwwww = Float.floatToIntBits(Float.NaN);

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i * 4.656612875245797E-10d));
        if (floatToIntBits == Wwwwwwwwwwwwwwwwwwwwwwwwww) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // me.tvspark.AbstractC2136g5
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i)) {
            return i != 4 ? new AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4) : AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i2 == 536870912) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i / 3) * 4);
            while (position < limit) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                position += 3;
            }
        } else if (i2 != 805306368) {
            throw new IllegalStateException();
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            while (position < limit) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
    }
}
