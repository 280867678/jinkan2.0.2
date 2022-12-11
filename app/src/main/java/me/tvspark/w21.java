package me.tvspark;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class w21 extends CharsetProber {
    public static final v41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new j41();
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public k41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public m31 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new m31();
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[2];

    public w21() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return v21.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState probingState;
        int i3 = i2 + i;
        for (int i4 = i; i4 < i3; i4++) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[i4]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                probingState = CharsetProber.ProbingState.NOT_ME;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                probingState = CharsetProber.ProbingState.FOUND_IT;
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i4 == i) {
                        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        bArr2[1] = bArr[i];
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, i5);
                    } else {
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i4 - 1, i5);
                    }
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = bArr[i3 - 1];
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.DETECTING && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0.95f) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.FOUND_IT;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
