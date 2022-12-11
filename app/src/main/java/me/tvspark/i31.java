package me.tvspark;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class i31 extends CharsetProber {
    public static final v41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new w41();
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
    public k41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);

    public i31() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        float f = 0.99f;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww < 6) {
            for (int i = 0; i < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww; i++) {
                f *= 0.5f;
            }
            return 1.0f - f;
        }
        return 0.99f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return v21.Wwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState probingState;
        int i3 = i2 + i;
        while (i < i3) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[i]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                probingState = CharsetProber.ProbingState.NOT_ME;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                probingState = CharsetProber.ProbingState.FOUND_IT;
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 2) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
                }
                i++;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
            break;
        }
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.DETECTING && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0.95f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
