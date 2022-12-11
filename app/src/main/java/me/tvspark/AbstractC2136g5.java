package me.tvspark;

import androidx.annotation.CallSuper;
import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: me.tvspark.g5 */
/* loaded from: classes4.dex */
public abstract class AbstractC2136g5 implements AudioProcessor {
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public AbstractC2136g5() {
        ByteBuffer byteBuffer = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public abstract AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws AudioProcessor.UnhandledAudioFormatException {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        return isActive() ? this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww : AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.capacity() < i) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.clear();
        }
        ByteBuffer byteBuffer = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = byteBuffer;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    @CallSuper
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwww && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void flush() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww != AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public final void reset() {
        flush();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = AudioProcessor.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }
}
