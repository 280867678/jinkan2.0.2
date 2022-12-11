package me.tvspark;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class c31 extends CharsetProber {
    public byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
    public CharsetProber Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;

    public c31() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte b) {
        int i = b & 255;
        return i == 234 || i == 237 || i == 239 || i == 243 || i == 245;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (byte) 32;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (byte) 32;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == CharsetProber.ProbingState.NOT_ME) {
            CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == probingState) {
                return probingState;
            }
        }
        return CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 0.0f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i >= 5) {
            return v21.Wwwwwwwwwwwwwww;
        }
        if (i <= -5) {
            return v21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0.01f) {
            return v21.Wwwwwwwwwwwwwww;
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= -0.01f && i >= 0) {
            return v21.Wwwwwwwwwwwwwww;
        }
        return v21.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == probingState) {
            return probingState;
        }
        int i3 = i2 + i;
        while (i < i3) {
            byte b = bArr[i];
            byte b2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (b == 32) {
                if (b2 != 32) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    } else {
                        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 255;
                        if (!(i4 == 235 || i4 == 238 || i4 == 240 || i4 == 244)) {
                        }
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    }
                }
            } else if (b2 == 32) {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
                    if (b == 32) {
                    }
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b;
            i++;
        }
        return CharsetProber.ProbingState.DETECTING;
    }
}
