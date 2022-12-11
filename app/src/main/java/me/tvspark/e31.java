package me.tvspark;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class e31 extends CharsetProber {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[7];
    public CharsetProber[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public e31() {
        CharsetProber[] charsetProberArr = new CharsetProber[7];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr;
        charsetProberArr[0] = new i31();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] = new g31();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] = new x21();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] = new b31();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[4] = new y21();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[5] = new w21();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[6] = new z21();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int i = 0;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= charsetProberArr.length) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = -1;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
                return;
            }
            charsetProberArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww++;
            i++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        CharsetProber.ProbingState probingState = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i = 0;
        float f = 0.0f;
        while (true) {
            CharsetProber[] charsetProberArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= charsetProberArr.length) {
                return f;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i]) {
                float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                if (f < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
                    f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                }
            }
            i++;
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == -1) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
            }
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        CharsetProber.ProbingState probingState;
        byte[] bArr2 = new byte[i2];
        int i3 = i2 + i;
        boolean z = true;
        int i4 = 0;
        while (i < i3) {
            if ((bArr[i] & 128) != 0) {
                bArr2[i4] = bArr[i];
                i4++;
                z = true;
            } else if (z) {
                bArr2[i4] = bArr[i];
                i4++;
                z = false;
            }
            i++;
        }
        int i5 = 0;
        while (true) {
            CharsetProber[] charsetProberArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i5 >= charsetProberArr.length) {
                break;
            }
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5]) {
                CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, i4);
                probingState = CharsetProber.ProbingState.FOUND_IT;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == probingState) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                    break;
                }
                probingState = CharsetProber.ProbingState.NOT_ME;
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == probingState) {
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5] = false;
                    int i6 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i6;
                    if (i6 <= 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
            i5++;
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
