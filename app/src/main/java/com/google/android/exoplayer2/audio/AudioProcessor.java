package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.tvspark.C2374ml;

/* loaded from: classes3.dex */
public interface AudioProcessor {
    public static final ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* loaded from: classes3.dex */
    public static final class UnhandledAudioFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public UnhandledAudioFormatException(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            super(r1.toString());
            String valueOf = String.valueOf(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            StringBuilder sb = new StringBuilder(valueOf.length() + 18);
            sb.append("Unhandled format: ");
            sb.append(valueOf);
        }
    }

    /* loaded from: classes3.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public static final Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1, -1, -1);
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2, int i3) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3) ? C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3, i2) : -1;
        }

        public String toString() {
            int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            StringBuilder sb = new StringBuilder(83);
            sb.append("AudioFormat[sampleRate=");
            sb.append(i);
            sb.append(", channelCount=");
            sb.append(i2);
            sb.append(", encoding=");
            sb.append(i3);
            sb.append(']');
            return sb.toString();
        }
    }

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    ByteBuffer Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) throws UnhandledAudioFormatException;

    void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(ByteBuffer byteBuffer);

    boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    void flush();

    boolean isActive();

    void reset();
}
