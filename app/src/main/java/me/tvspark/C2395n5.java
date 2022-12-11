package me.tvspark;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.n5 */
/* loaded from: classes4.dex */
public final class C2395n5 extends AbstractC2136g5 {
    @Override // me.tvspark.AbstractC2136g5
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4) {
            return i != 2 ? new AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2) : AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0 A[LOOP:4: B:33:0x00b0->B:34:0x00b2, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:12:0x0037, B:34:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 268435456) {
                    if (i3 == 536870912) {
                        i2 /= 3;
                    } else if (i3 != 805306368) {
                        throw new IllegalStateException();
                    }
                }
                ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i == 3) {
                    while (position < limit) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put((byte) 0);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put((byte) ((byteBuffer.get(position) & 255) - 128));
                        position++;
                    }
                } else if (i == 4) {
                    while (position < limit) {
                        short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = (short) (C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer.getFloat(position), -1.0f, 1.0f) * 32767.0f);
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put((byte) (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 & 255));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put((byte) ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >> 8) & 255));
                        position += 4;
                    }
                } else if (i == 268435456) {
                    while (position < limit) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position + 1));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position));
                        position += 2;
                    }
                } else if (i == 536870912) {
                    while (position < limit) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position + 1));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position + 2));
                        position += 3;
                    }
                } else if (i != 805306368) {
                    throw new IllegalStateException();
                } else {
                    while (position < limit) {
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position + 2));
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer.get(position + 3));
                        position += 4;
                    }
                }
                byteBuffer.position(byteBuffer.limit());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
            }
            i2 /= 2;
            ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
            i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == 3) {
            }
            byteBuffer.position(byteBuffer.limit());
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.flip();
        }
        i2 *= 2;
        ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
        i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i == 3) {
        }
        byteBuffer.position(byteBuffer.limit());
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww32.flip();
    }
}
