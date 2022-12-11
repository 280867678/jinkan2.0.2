package me.tvspark;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class d31 extends CharsetProber {
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[4];
    public byte Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 0, 1, 7, 1, 1, 1, 1, 1, 1, 5, 1, 5, 0, 5, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 7, 0, 7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 6, 6, 6, 6, 6, 1, 6, 6, 6, 6, 6, 7, 7, 7};
    public static final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 3, 3, 1, 1, 3, 3, 0, 3, 3, 3, 1, 2, 1, 2, 0, 3, 3, 3, 3, 3, 3, 3, 0, 3, 1, 3, 1, 1, 1, 3, 0, 3, 1, 3, 1, 1, 3, 3};

    public d31() {
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.DETECTING;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (byte) 1;
        int i = 0;
        while (true) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i < iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        int[] iArr;
        float f;
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i >= iArr.length) {
                break;
            }
            i2 += iArr[i];
            i++;
        }
        float f2 = 0.0f;
        if (i2 <= 0) {
            f = 0.0f;
        } else {
            float f3 = i2;
            f = ((iArr[3] * 1.0f) / f3) - ((iArr[1] * 20.0f) / f3);
        }
        if (f >= 0.0f) {
            f2 = f;
        }
        return f2 * 0.5f;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        return v21.Wwwwwwwwwwwwwwwww;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = 0;
        int i5 = i;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i >= i3) {
                break;
            }
            byte b = bArr[i];
            if (b == 62) {
                z = false;
            } else if (b == 60) {
                z = true;
            }
            if ((b & 128) != 0) {
                z2 = false;
            }
            if (z2 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(b)) {
                if (i > i5 && !z) {
                    allocate.put(bArr, i5, i - i5);
                    allocate.put((byte) 32);
                }
                i5 = i + 1;
            }
            i++;
        }
        if (!z && i > i5) {
            allocate.put(bArr, i5, i - i5);
        }
        byte[] array = allocate.array();
        int position = allocate.position();
        while (true) {
            if (i4 >= position) {
                break;
            }
            byte b2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[array[i4] & 255];
            byte b3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww * 8) + b2];
            if (b3 == 0) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = CharsetProber.ProbingState.NOT_ME;
                break;
            }
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            iArr[b3] = iArr[b3] + 1;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = b2;
            i4++;
        }
        return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }
}
