package me.tvspark;

import java.util.Arrays;
import java.util.Random;

/* renamed from: me.tvspark.jf */
/* loaded from: classes4.dex */
public interface AbstractC2257jf {

    /* renamed from: me.tvspark.jf$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AbstractC2257jf {
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final Random Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, Random random) {
            this(r0, random);
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int nextInt = random.nextInt(i3);
                iArr[i2] = iArr[nextInt];
                iArr[nextInt] = i2;
                i2 = i3;
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int[] iArr, Random random) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = random;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[iArr[i]] = i;
            }
        }

        @Override // me.tvspark.AbstractC2257jf
        public AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0, new Random(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextLong()));
        }

        @Override // me.tvspark.AbstractC2257jf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // me.tvspark.AbstractC2257jf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] + 1;
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // me.tvspark.AbstractC2257jf
        public AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                iArr[i3] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextInt(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + 1);
                int i4 = i3 + 1;
                int nextInt = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextInt(i4);
                iArr2[i3] = iArr2[nextInt];
                iArr2[nextInt] = i3 + i;
                i3 = i4;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + i2];
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length + i2; i7++) {
                if (i5 >= i2 || i6 != iArr[i5]) {
                    int i8 = i6 + 1;
                    iArr3[i7] = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i6];
                    if (iArr3[i7] >= i) {
                        iArr3[i7] = iArr3[i7] + i2;
                    }
                    i6 = i8;
                } else {
                    iArr3[i7] = iArr2[i5];
                    i5++;
                }
            }
            return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr3, new Random(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextLong()));
        }

        @Override // me.tvspark.AbstractC2257jf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            int[] iArr = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // me.tvspark.AbstractC2257jf
        public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i) {
            int i2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i] - 1;
            if (i2 >= 0) {
                return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[i2];
            }
            return -1;
        }

        @Override // me.tvspark.AbstractC2257jf
        public AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                if (i4 < iArr2.length) {
                    if (iArr2[i4] < i || iArr2[i4] >= i2) {
                        int i6 = i4 - i5;
                        int[] iArr3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        iArr[i6] = iArr3[i4] >= i ? iArr3[i4] - i3 : iArr3[i4];
                    } else {
                        i5++;
                    }
                    i4++;
                } else {
                    return new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(iArr, new Random(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.nextLong()));
                }
            }
        }

        @Override // me.tvspark.AbstractC2257jf
        public int getLength() {
            return this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
        }
    }

    AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();

    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i);

    AbstractC2257jf Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, int i2);

    int getLength();
}
