package me.tvspark;

/* loaded from: classes4.dex */
public class k51 {
    public k51 Wwwwwwwwwwwwwwwwwwwwwwww;
    public e51 Wwwwwwwwwwwwwwwwwwwwwwwww;
    public k51 Wwwwwwwwwwwwwwwwwwwwwwwwww;
    public g51 Wwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public k51 Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        g51 g51Var = this.Wwwwwwwwwwwwwwwwwwwwwwwwwww;
        return g51Var == null ? this : g51Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[6];
        }
        int i3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
        }
        int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i5 = i4 + 1;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5;
        iArr3[i4] = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i5 + 1;
        iArr3[i5] = i2;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(me.tvspark.k51 r9, long r10, int r12) {
        /*
            r8 = this;
            r0 = r8
        L1:
            if (r0 == 0) goto La2
            me.tvspark.k51 r1 = r0.Wwwwwwwwwwwwwwwwwwwwwwww
            r2 = 0
            r0.Wwwwwwwwwwwwwwwwwwwwwwww = r2
            r2 = 0
            r3 = 1
            if (r9 == 0) goto L52
            int r4 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L13
            goto L68
        L13:
            r4 = r4 | 2048(0x800, float:2.87E-42)
            r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r4
            r5 = r4 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L86
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L3a
            int r4 = r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L26
            goto L3a
        L26:
            r4 = 0
        L27:
            int[] r5 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            int r6 = r5.length
            if (r4 >= r6) goto L3a
            r5 = r5[r4]
            int[] r6 = r9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r6 = r6[r4]
            r5 = r5 & r6
            if (r5 == 0) goto L37
            r2 = 1
            goto L3a
        L37:
            int r4 = r4 + 1
            goto L27
        L3a:
            if (r2 != 0) goto L86
            me.tvspark.e51 r2 = new me.tvspark.e51
            r2.<init>()
            int r3 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r3
            me.tvspark.e51 r3 = r9.Wwwwwwwwwwwwwwwwwwwwwwwww
            me.tvspark.k51 r3 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r3
            me.tvspark.e51 r3 = r0.Wwwwwwwwwwwwwwwwwwwwwwwww
            r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r3
            r0.Wwwwwwwwwwwwwwwwwwwwwwwww = r2
            goto L86
        L52:
            int r4 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r4 = r4 & 1024(0x400, float:1.435E-42)
            r5 = 32
            if (r4 == 0) goto L66
            int[] r4 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            long r6 = r10 >>> r5
            int r7 = (int) r6
            r4 = r4[r7]
            int r6 = (int) r10
            r4 = r4 & r6
            if (r4 == 0) goto L66
            r2 = 1
        L66:
            if (r2 == 0) goto L6a
        L68:
            r0 = r1
            goto L1
        L6a:
            int r2 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r4 = r2 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L7b
            r2 = r2 | 1024(0x400, float:1.435E-42)
            r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r2
            int r2 = r12 / 32
            int r2 = r2 + r3
            int[] r2 = new int[r2]
            r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r2
        L7b:
            int[] r2 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            long r3 = r10 >>> r5
            int r4 = (int) r3
            r3 = r2[r4]
            int r5 = (int) r10
            r3 = r3 | r5
            r2[r4] = r3
        L86:
            me.tvspark.e51 r2 = r0.Wwwwwwwwwwwwwwwwwwwwwwwww
        L88:
            if (r2 == 0) goto L68
            int r3 = r0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            r3 = r3 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L96
            me.tvspark.e51 r3 = r0.Wwwwwwwwwwwwwwwwwwwwwwwww
            me.tvspark.e51 r3 = r3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            if (r2 == r3) goto L9f
        L96:
            me.tvspark.k51 r3 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            me.tvspark.k51 r4 = r3.Wwwwwwwwwwwwwwwwwwwwwwww
            if (r4 != 0) goto L9f
            r3.Wwwwwwwwwwwwwwwwwwwwwwww = r1
            r1 = r3
        L9f:
            me.tvspark.e51 r2 = r2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww
            goto L88
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.tvspark.k51.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(me.tvspark.k51, long, int):void");
    }

    public void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(z41 z41Var, int i, boolean z) {
        if ((this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww & 2) != 0) {
            if (z) {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i);
            } else {
                z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - i);
            }
        } else if (z) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((-1) - i, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
        } else {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i, z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            z41Var.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(-1);
        }
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, byte[] bArr) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww |= 2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        int i2 = 0;
        boolean z = false;
        while (i2 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i3 = i2 + 1;
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i4 >= 0) {
                int i7 = i - i4;
                if (i7 < -32768 || i7 > 32767) {
                    int i8 = i6 - 1;
                    int i9 = bArr[i8] & 255;
                    if (i9 <= 168) {
                        bArr[i8] = (byte) (i9 + 49);
                    } else {
                        bArr[i8] = (byte) (i9 + 20);
                    }
                    z = true;
                }
                bArr[i6] = (byte) (i7 >>> 8);
                bArr[i6 + 1] = (byte) i7;
            } else {
                int i10 = i4 + i + 1;
                int i11 = i6 + 1;
                bArr[i6] = (byte) (i10 >>> 24);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (i10 >>> 16);
                bArr[i12] = (byte) (i10 >>> 8);
                bArr[i12 + 1] = (byte) i10;
            }
            i2 = i5;
        }
        return z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("L");
        stringBuffer.append(System.identityHashCode(this));
        return stringBuffer.toString();
    }
}
