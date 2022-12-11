package me.tvspark;

import androidx.annotation.Nullable;
import me.tvspark.AbstractC2740w7;

/* renamed from: me.tvspark.q9 */
/* loaded from: classes4.dex */
public final class C2516q9 {
    @Nullable
    public final byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r6.equals("cenc") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2516q9(boolean z, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        char c = 0;
        int i4 = 1;
        Illllllllllllllllllllllllllll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((i == 0) ^ (bArr2 == null));
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = z;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = str;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3046671:
                    if (str.equals("cbcs")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3049879:
                    break;
                case 3049895:
                    if (str.equals("cens")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0 && c != 1) {
                if (c == 2 || c == 3) {
                    i4 = 2;
                } else {
                    str.length();
                }
            }
        }
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new AbstractC2740w7.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i4, bArr, i2, i3);
    }
}
