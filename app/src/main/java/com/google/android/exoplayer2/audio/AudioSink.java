package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import me.tvspark.C2099f5;
import me.tvspark.C2245j3;
import me.tvspark.C2658u3;
import me.tvspark.C2848z4;
import me.tvspark.outline;

/* loaded from: classes3.dex */
public interface AudioSink {

    /* loaded from: classes3.dex */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(String str) {
            super(str);
        }

        public ConfigurationException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes3.dex */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public InitializationException(int i, int i2, int i3, int i4) {
            super(r0.toString());
            StringBuilder sb = new StringBuilder(82);
            sb.append("AudioTrack init failed: ");
            sb.append(i);
            sb.append(", Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(")");
            this.audioTrackState = i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i) {
            super(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(36, "AudioTrack write failed: ", i));
            this.errorCode = i;
        }
    }

    /* loaded from: classes3.dex */
    public interface Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() throws WriteException;

    C2658u3 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);

    long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(float f);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2099f5 c2099f5);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3, int i, @Nullable int[] iArr) throws ConfigurationException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2658u3 c2658u3);

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2848z4 c2848z4);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer, long j, int i) throws InitializationException, WriteException;

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2245j3 c2245j3);

    void flush();

    void pause();

    void play();

    void reset();
}
