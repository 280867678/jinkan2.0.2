package me.tvspark;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;

/* renamed from: me.tvspark.zl */
/* loaded from: classes4.dex */
public final class C2865zl {
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    @Nullable
    public final List<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2865zl(@Nullable List<byte[]> list, int i) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
    }

    public static C2865zl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws ParserException {
        try {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(21);
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 3;
            int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i2 = 0;
            for (int i3 = 0; i3 < Wwwwwwwwwwwwwwwwwwwwww2; i3++) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
                for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwww; i4++) {
                    int Wwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwww();
                    i2 += Wwwwwwwwwwwwwwwww2 + 4;
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww2);
                }
            }
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < Wwwwwwwwwwwwwwwwwwwwww2; i6++) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
                int Wwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwww();
                for (int i7 = 0; i7 < Wwwwwwwwwwwwwwwww3; i7++) {
                    int Wwwwwwwwwwwwwwwww4 = c2078el.Wwwwwwwwwwwwwwwww();
                    System.arraycopy(C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, bArr, i5, C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length);
                    int length = i5 + C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length;
                    System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, length, Wwwwwwwwwwwwwwwww4);
                    i5 = length + Wwwwwwwwwwwwwwwww4;
                    c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww4);
                }
            }
            return new C2865zl(i2 == 0 ? null : Collections.singletonList(bArr), Wwwwwwwwwwwwwwwwwwwwww + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing HEVC config", e);
        }
    }
}
