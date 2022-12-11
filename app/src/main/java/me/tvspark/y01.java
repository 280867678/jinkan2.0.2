package me.tvspark;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class y01 extends x01 {
    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
        int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int length = iArr.length;
        int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (length == i2) {
            int i3 = i2 + 1;
            if (i3 < 0 || i3 > 2147483639) {
                throw new OutOfMemoryError();
            }
            int length2 = iArr.length == 0 ? 4 : iArr.length;
            while (length2 < i3) {
                length2 *= 2;
                if (length2 < 0 || length2 > 2147483639) {
                    length2 = 2147483639;
                }
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Arrays.copyOf(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, length2);
        }
        int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i4 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        iArr2[i4] = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i4 + 1;
    }
}
