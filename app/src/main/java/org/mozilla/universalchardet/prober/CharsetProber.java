package org.mozilla.universalchardet.prober;

/* loaded from: classes5.dex */
public abstract class CharsetProber {

    /* loaded from: classes5.dex */
    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    public abstract void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    public abstract ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2);

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b) {
        int i = b & 255;
        return i < 65 || (i > 90 && i < 97) || i > 122;
    }
}
