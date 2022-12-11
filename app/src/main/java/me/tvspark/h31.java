package me.tvspark;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class h31 extends CharsetProber {
    public CharsetProber Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public short Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public f41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public h31(f41 f41Var) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f41Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = false;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[4];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    public h31(f41 f41Var, boolean z, CharsetProber charsetProber) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f41Var;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwww = charsetProber;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[4];
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (short) 255;
        for (int i = 0; i < 4; i++) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = 0;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i > 0) {
            float f = ((((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] * 1.0f) / i) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) * this.Wwwwwwwwwwwwwwwwwwwwwwwwwww) / this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (f < 1.0f) {
                return f;
            }
            return 0.99f;
        }
        return 0.01f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        CharsetProber charsetProber = this.Wwwwwwwwwwwwwwwwwwwwwwwwww;
        if (charsetProber == null) {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        }
        return charsetProber.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState probingState;
        int i3 = i2 + i;
        while (i < i3) {
            short s = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[bArr[i] & 255];
            if (s < 250) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            }
            if (s < 64) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwww++;
                short s2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (s2 < 64) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                    if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byte b = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(s2 * 64) + s];
                        iArr[b] = iArr[b] + 1;
                    } else {
                        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byte b2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(s * 64) + s2];
                        iArr2[b2] = iArr2[b2] + 1;
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = s;
            i++;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.DETECTING && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 1024) {
            float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 0.95f) {
                probingState = CharsetProber.ProbingState.FOUND_IT;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 0.05f) {
                probingState = CharsetProber.ProbingState.NOT_ME;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
