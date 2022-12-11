package me.tvspark;

import com.google.android.exoplayer2.ExoPlaybackException;

/* renamed from: me.tvspark.aj */
/* loaded from: classes4.dex */
public abstract class AbstractC1911aj extends AbstractC2113fj {

    /* renamed from: me.tvspark.aj$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public final int[][][] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final C2368mf[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(String[] strArr, int[] iArr, C2368mf[] c2368mfArr, int[] iArr2, int[][][] iArr3, C2368mf c2368mf) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2368mfArr;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr3;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr2;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = iArr.length;
        }
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(AbstractC1970c4[] abstractC1970c4Arr, C2331lf c2331lf, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = abstractC1970c4Arr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < abstractC1970c4Arr.length; i2++) {
            AbstractC1970c4 abstractC1970c4 = abstractC1970c4Arr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < c2331lf.Wwwwwwwwwwwwwwwwwwwwwwww; i4++) {
                i3 = Math.max(i3, C1933b4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(abstractC1970c4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2331lf.Wwwwwwwwwwwwwwwwwwwwwww[i4])));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }
}
