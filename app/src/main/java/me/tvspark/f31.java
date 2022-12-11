package me.tvspark;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class f31 extends CharsetProber {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new boolean[13];
    public CharsetProber[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = new h41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwwwwwww = new a41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwwwwww = new c41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwwwww = new e41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwwww = new z31();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwwww = new y31();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwwww = new d41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwwww = new i41();
    public static final f41 Wwwwwwwwwwwwwwwwwwwww = new b41();
    public static final f41 Wwwwwwwwwwwwwwwwwwww = new g41();
    public static final f41 Wwwwwwwwwwwwwwwwwww = new x31();

    public f31() {
        CharsetProber[] charsetProberArr = new CharsetProber[13];
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr;
        charsetProberArr[0] = new h31(Wwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[1] = new h31(Wwwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[2] = new h31(Wwwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[3] = new h31(Wwwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[4] = new h31(Wwwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[5] = new h31(Wwwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[6] = new h31(Wwwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[7] = new h31(Wwwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[8] = new h31(Wwwwwwwwwwwwwwwwwwwww);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[9] = new h31(Wwwwwwwwwwwwwwwwwwww);
        c31 c31Var = new c31();
        CharsetProber[] charsetProberArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        charsetProberArr2[10] = c31Var;
        charsetProberArr2[11] = new h31(Wwwwwwwwwwwwwwwwwww, false, c31Var);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[12] = new h31(Wwwwwwwwwwwwwwwwwww, true, c31Var);
        CharsetProber[] charsetProberArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        CharsetProber charsetProber = charsetProberArr3[11];
        CharsetProber charsetProber2 = charsetProberArr3[12];
        c31Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProber;
        c31Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProber2;
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
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (!((b & 128) == 0)) {
                z = true;
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b)) {
                if (!z || i <= i4) {
                    i4 = i + 1;
                } else {
                    allocate.put(bArr, i4, i - i4);
                    allocate.put((byte) 32);
                    i4 = i + 1;
                    z = false;
                }
            }
            i++;
        }
        if (z && i > i4) {
            allocate.put(bArr, i4, i - i4);
        }
        if (allocate.position() != 0) {
            int i5 = 0;
            while (true) {
                CharsetProber[] charsetProberArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i5 >= charsetProberArr.length) {
                    break;
                }
                if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i5]) {
                    CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charsetProberArr[i5].Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(allocate.array(), 0, allocate.position());
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
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
