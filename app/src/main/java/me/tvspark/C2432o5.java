package me.tvspark;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import org.apache.commons.lang3.time.StopWatch;

/* renamed from: me.tvspark.o5 */
/* loaded from: classes4.dex */
public final class C2432o5 extends AbstractC2136g5 {
    public long Wwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwwww = 150000;
    public final long Wwwwwwwwwwwwwwwwwwwwwwwww = 20000;
    public final short Wwwwwwwwwwwwwwwwwwwwwwww = 1024;

    public C2432o5() {
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true);
        byte[] bArr = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwww = bArr;
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwww = 0;
        byte[] bArr = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = bArr;
        this.Wwwwwwwwwwwwwwwwwwww = bArr;
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwww;
        if (i > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww, i);
        }
        if (!this.Wwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwww += this.Wwwwwwwwwwwwwwwww / this.Wwwwwwwwwwwwwwwwwwwwwww;
        }
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwww) {
            AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwww = i;
            int i2 = ((int) ((this.Wwwwwwwwwwwwwwwwwwwwwwwwww * wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / StopWatch.NANO_2_MILLIS)) * i;
            if (this.Wwwwwwwwwwwwwwwwwwwww.length != i2) {
                this.Wwwwwwwwwwwwwwwwwwwww = new byte[i2];
            }
            int i3 = ((int) ((this.Wwwwwwwwwwwwwwwwwwwwwwwww * this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) / StopWatch.NANO_2_MILLIS)) * this.Wwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwww = i3;
            if (this.Wwwwwwwwwwwwwwwwwwww.length != i3) {
                this.Wwwwwwwwwwwwwwwwwwww = new byte[i3];
            }
        }
        this.Wwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwww = false;
    }

    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                int i = this.Wwwwwwwwwwwwwwwwwwwwwww;
                return (position / i) * i;
            }
        }
        return byteBuffer.limit();
    }

    @Override // me.tvspark.AbstractC2136g5
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            return this.Wwwwwwwwwwwwwwwwwwwwww ? wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww : AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww.hasRemaining()) {
            int i = this.Wwwwwwwwwwwwwwwwwww;
            if (i == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.Wwwwwwwwwwwwwwwwwwwww.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.getShort(limit2)) > this.Wwwwwwwwwwwwwwwwwwwwwwww) {
                        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwww;
                        position = ((limit2 / i2) * i2) + i2;
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.Wwwwwwwwwwwwwwwwwww = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.Wwwwwwwwwwwwwwww = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i == 1) {
                int limit3 = byteBuffer.limit();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                int position2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - byteBuffer.position();
                byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwww;
                int length = bArr.length;
                int i3 = this.Wwwwwwwwwwwwwwwwww;
                int i4 = length - i3;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= limit3 || position2 >= i4) {
                    int min = Math.min(position2, i4);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww, min);
                    int i5 = this.Wwwwwwwwwwwwwwwwww + min;
                    this.Wwwwwwwwwwwwwwwwww = i5;
                    byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwww;
                    if (i5 == bArr2.length) {
                        if (this.Wwwwwwwwwwwwwwww) {
                            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, this.Wwwwwwwwwwwwwwwww);
                            this.Wwwwwwwwwwwwwww += (this.Wwwwwwwwwwwwwwwwww - (this.Wwwwwwwwwwwwwwwww * 2)) / this.Wwwwwwwwwwwwwwwwwwwwwww;
                        } else {
                            this.Wwwwwwwwwwwwwww += (i5 - this.Wwwwwwwwwwwwwwwww) / this.Wwwwwwwwwwwwwwwwwwwwwww;
                        }
                        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, this.Wwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwww);
                        this.Wwwwwwwwwwwwwwwwww = 0;
                        this.Wwwwwwwwwwwwwwwwwww = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i3);
                    this.Wwwwwwwwwwwwwwwwww = 0;
                    this.Wwwwwwwwwwwwwwwwwww = 0;
                }
            } else if (i == 2) {
                int limit4 = byteBuffer.limit();
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer);
                byteBuffer.limit(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                this.Wwwwwwwwwwwwwww += byteBuffer.remaining() / this.Wwwwwwwwwwwwwwwwwwwwwww;
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byteBuffer, this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 < limit4) {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwww);
                    this.Wwwwwwwwwwwwwwwwwww = 0;
                    byteBuffer.limit(limit4);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.Wwwwwwwwwwwwwwwww);
        int i2 = this.Wwwwwwwwwwwwwwwww - min;
        System.arraycopy(bArr, i - i2, this.Wwwwwwwwwwwwwwwwwwww, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.Wwwwwwwwwwwwwwwwwwww, i2, min);
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i) {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.Wwwwwwwwwwwwwwww = true;
        }
    }

    @Override // me.tvspark.AbstractC2136g5, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.Wwwwwwwwwwwwwwwwwwwwww;
    }
}
