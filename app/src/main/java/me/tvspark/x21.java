package me.tvspark;

import java.util.Arrays;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class x21 extends CharsetProber {
    public static final v41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new l41();
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public k41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public j31 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new j31();
    public o31 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new o31();
    public byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new byte[2];

    public x21() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        Arrays.fill(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, (byte) 0);
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return Math.max(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return v21.Wwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        boolean z;
        CharsetProber.ProbingState probingState;
        int i3 = i2 + i;
        int i4 = i;
        while (true) {
            z = false;
            if (i4 >= i3) {
                break;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[i4]);
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                probingState = CharsetProber.ProbingState.NOT_ME;
                break;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                probingState = CharsetProber.ProbingState.FOUND_IT;
                break;
            } else {
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 0) {
                    int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    if (i4 == i) {
                        byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        bArr2[1] = bArr[i];
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, i5);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, i5);
                    } else {
                        int i6 = i4 - 1;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i6, i5);
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, i6, i5);
                    }
                }
                i4++;
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0] = bArr[i3 - 1];
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.DETECTING) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww > 100) {
                z = true;
            }
            if (z && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0.95f) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.FOUND_IT;
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
