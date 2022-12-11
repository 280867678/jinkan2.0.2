package me.tvspark;

import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class a31 extends CharsetProber {
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public k41[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final p41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new p41();
    public static final q41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new q41();
    public static final r41 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new r41();
    public static final s41 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new s41();

    public a31() {
        k41[] k41VarArr = new k41[4];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k41VarArr;
        k41VarArr[0] = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] = new k41(Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
        int i = 0;
        while (true) {
            k41[] k41VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i < k41VarArr.length) {
                k41VarArr[i].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
                i++;
            } else {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = k41VarArr.length;
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                return;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return 0.99f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3 && this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.DETECTING) {
            for (int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1; i4 >= 0; i4--) {
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr[i]);
                if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 1) {
                    int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
                    if (i5 <= 0) {
                        CharsetProber.ProbingState probingState = CharsetProber.ProbingState.NOT_ME;
                        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState;
                        return probingState;
                    } else if (i4 != i5) {
                        k41[] k41VarArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        k41 k41Var = k41VarArr[i5];
                        k41VarArr[i5] = k41VarArr[i4];
                        k41VarArr[i4] = k41Var;
                    }
                } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
                    CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.FOUND_IT;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = probingState2;
                    this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i4].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    return probingState2;
                }
            }
            i++;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
