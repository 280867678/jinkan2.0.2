package me.tvspark;

/* renamed from: me.tvspark.m7 */
/* loaded from: classes4.dex */
public final class C2360m7 {

    /* renamed from: me.tvspark.m7$Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww */
    /* loaded from: classes4.dex */
    public static final class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww {
        public long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return c2078el.Wwwwwwwwwwwwwwwwwwwwww() + 1;
            case 7:
                return c2078el.Wwwwwwwwwwwwwwwww() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
        if (r7 == r18.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
        if ((r17.Wwwwwwwwwwwwwwwwwwwwww() * 1000) == r3) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ae, code lost:
        if (r4 == r3) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, C2434o7 c2434o7, int i, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        boolean z;
        int i2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        long Wwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwww();
        long j = Wwwwwwwwwwwwwwwwwwwww >>> 16;
        if (j != i) {
            return false;
        }
        boolean z2 = (j & 1) == 1;
        int i3 = (int) ((Wwwwwwwwwwwwwwwwwwwww >> 12) & 15);
        int i4 = (int) ((Wwwwwwwwwwwwwwwwwwwww >> 8) & 15);
        int i5 = (int) (15 & (Wwwwwwwwwwwwwwwwwwwww >> 4));
        int i6 = (int) ((Wwwwwwwwwwwwwwwwwwwww >> 1) & 7);
        boolean z3 = (Wwwwwwwwwwwwwwwwwwwww & 1) == 1;
        if (!(i5 > 7 ? !(i5 > 10 || c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww != 2) : i5 == c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwww - 1)) {
            return false;
        }
        if (!(i6 == 0 || i6 == c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwww) || z3 || !Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, c2434o7, z2, wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return false;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, i3);
        if (!(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 != -1 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 <= c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww)) {
            return false;
        }
        int i7 = c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (i4 != 0) {
            if (i4 > 11) {
                if (i4 != 12) {
                    if (i4 <= 14) {
                        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                        if (i4 == 14) {
                            Wwwwwwwwwwwwwwwww *= 10;
                        }
                    }
                    z = false;
                }
            }
            if (z) {
                return false;
            }
            return c2078el.Wwwwwwwwwwwwwwwwwwwwww() == C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i2, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 1, 0);
        }
        z = true;
        if (z) {
        }
    }

    public static boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, C2434o7 c2434o7, boolean z, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
        try {
            long Wwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwww();
            if (!z) {
                Wwwwwwwwwwwwwwww *= c2434o7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwww;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
