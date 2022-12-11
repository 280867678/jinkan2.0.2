package me.tvspark;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* renamed from: me.tvspark.r5 */
/* loaded from: classes4.dex */
public final class C2549r5 extends AbstractC2136g5 {
    public long Wwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwww;
    public byte[] Wwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwww;

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwww > 0) {
                this.Wwwwwwwwwwwwwwwwwwww += i / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
        }
    }

    @Override // me.tvspark.AbstractC2136g5
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwww) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = false;
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwww = new byte[i * i2];
            this.Wwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwww * i2;
        }
        this.Wwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // me.tvspark.AbstractC2136g5
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = true;
            return (this.Wwwwwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwww == 0) ? AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // me.tvspark.AbstractC2136g5, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        if (super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && (i = this.Wwwwwwwwwwwwwwwwwwwww) > 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i).put(this.Wwwwwwwwwwwwwwwwwwwwww, 0, this.Wwwwwwwwwwwwwwwwwwwww).flip();
            this.Wwwwwwwwwwwwwwwwwwwww = 0;
        }
        return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwww += min / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwww -= min;
        byteBuffer.position(position + min);
        if (this.Wwwwwwwwwwwwwwwwwwwwwww > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.Wwwwwwwwwwwwwwwwwwwww + i2) - this.Wwwwwwwwwwwwwwwwwwwwww.length;
        ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length, 0, this.Wwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(this.Wwwwwwwwwwwwwwwwwwwwww, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(length - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, i2);
        byteBuffer.limit(byteBuffer.position() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwww - Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        this.Wwwwwwwwwwwwwwwwwwwww = i4;
        byte[] bArr = this.Wwwwwwwwwwwwwwwwwwwwww;
        System.arraycopy(bArr, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, bArr, 0, i4);
        byteBuffer.get(this.Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwww, i3);
        this.Wwwwwwwwwwwwwwwwwwwww += i3;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.flip();
    }

    @Override // me.tvspark.AbstractC2136g5, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return super.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && this.Wwwwwwwwwwwwwwwwwwwww == 0;
    }
}
