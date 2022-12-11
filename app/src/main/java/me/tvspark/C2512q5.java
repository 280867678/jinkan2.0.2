package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* renamed from: me.tvspark.q5 */
/* loaded from: classes4.dex */
public final class C2512q5 implements AudioProcessor {
    public boolean Wwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwww;
    public long Wwwwwwwwwwwwwwwwwwwww;
    public ShortBuffer Wwwwwwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public C2469p5 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;

    public C2512q5() {
        AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ByteBuffer byteBuffer = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwww = byteBuffer.asShortBuffer();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i;
        C2469p5 c2469p5 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2469p5 != null) {
            int i2 = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww;
            float f = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f2 = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            float f3 = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww * f2;
            int i3 = c2469p5.Wwwwwwwwwwwwwwwwwwwwww + ((int) ((((i2 / (f / f2)) + c2469p5.Wwwwwwwwwwwwwwwwwwww) / f3) + 0.5f));
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwww = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwww, i2, (c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwww * 2) + i2);
            int i4 = 0;
            while (true) {
                i = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwww * 2;
                int i5 = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 >= i * i5) {
                    break;
                }
                c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwww[(i5 * i2) + i4] = 0;
                i4++;
            }
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww = i + c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww;
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (c2469p5.Wwwwwwwwwwwwwwwwwwwwww > i3) {
                c2469p5.Wwwwwwwwwwwwwwwwwwwwww = i3;
            }
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
            c2469p5.Wwwwwwwwwwwwwwwww = 0;
            c2469p5.Wwwwwwwwwwwwwwwwwwww = 0;
        }
        this.Wwwwwwwwwwwwwwwwwww = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i == -1) {
                i = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = new AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        C2469p5 c2469p5;
        return this.Wwwwwwwwwwwwwwwwwww && ((c2469p5 = this.Wwwwwwwwwwwwwwwwwwwwwwwww) == null || (c2469p5.Wwwwwwwwwwwwwwwwwwwwww * c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * 2 == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2;
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwww) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwww = new C2469p5(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                C2469p5 c2469p5 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
                if (c2469p5 != null) {
                    c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwwww = 0;
                    c2469p5.Wwwwwwwwwwwww = 0;
                }
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != -1 && (Math.abs(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1.0f) >= 0.01f || Math.abs(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1.0f) >= 0.01f || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 1.0f;
        AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        ByteBuffer byteBuffer = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwww = byteBuffer.asShortBuffer();
        this.Wwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwwww = 0L;
        this.Wwwwwwwwwwwwwwwwwww = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer) {
        C2469p5 c2469p5 = this.Wwwwwwwwwwwwwwwwwwwwwwwww;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2469p5);
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.Wwwwwwwwwwwwwwwwwwwww += remaining;
            int remaining2 = asShortBuffer.remaining();
            int i = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = remaining2 / i;
            short[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwww, c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww, i2);
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            asShortBuffer.get(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww * c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, ((i * i2) * 2) / 2);
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwww += i2;
            c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int i3 = c2469p5.Wwwwwwwwwwwwwwwwwwwwww * c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 2;
        if (i3 > 0) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwww.capacity() < i3) {
                ByteBuffer order = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                this.Wwwwwwwwwwwwwwwwwwwwwwww = order;
                this.Wwwwwwwwwwwwwwwwwwwwwww = order.asShortBuffer();
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwww.clear();
                this.Wwwwwwwwwwwwwwwwwwwwwww.clear();
            }
            ShortBuffer shortBuffer = this.Wwwwwwwwwwwwwwwwwwwwwww;
            int min = Math.min(shortBuffer.remaining() / c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2469p5.Wwwwwwwwwwwwwwwwwwwwww);
            shortBuffer.put(c2469p5.Wwwwwwwwwwwwwwwwwwwwwww, 0, c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * min);
            int i4 = c2469p5.Wwwwwwwwwwwwwwwwwwwwww - min;
            c2469p5.Wwwwwwwwwwwwwwwwwwwwww = i4;
            short[] sArr = c2469p5.Wwwwwwwwwwwwwwwwwwwwwww;
            int i5 = c2469p5.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            System.arraycopy(sArr, min * i5, sArr, 0, i4 * i5);
            this.Wwwwwwwwwwwwwwwwwwww += i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwww.limit(i3);
            this.Wwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwww;
        }
    }
}
