package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;
import me.tvspark.C1987cl;

/* renamed from: me.tvspark.vl */
/* loaded from: classes4.dex */
public final class C2717vl {
    public final float Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final List<byte[]> Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2717vl(List<byte[]> list, int i, int i2, int i3, float f) {
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = list;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = f;
    }

    public static C2717vl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws ParserException {
        int i;
        int i2;
        float f;
        try {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
            int Wwwwwwwwwwwwwwwwwwwwww = (c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 3) + 1;
            if (Wwwwwwwwwwwwwwwwwwwwww == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int Wwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwww() & 31;
            for (int i3 = 0; i3 < Wwwwwwwwwwwwwwwwwwwwww2; i3++) {
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el));
            }
            int Wwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            for (int i4 = 0; i4 < Wwwwwwwwwwwwwwwwwwwwww3; i4++) {
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el));
            }
            if (Wwwwwwwwwwwwwwwwwwwwww2 > 0) {
                C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((byte[]) arrayList.get(0), Wwwwwwwwwwwwwwwwwwwwww, ((byte[]) arrayList.get(0)).length);
                int i5 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i6 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                f = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new C2717vl(arrayList, Wwwwwwwwwwwwwwwwwwwwww, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParserException("Error parsing AVC config", e);
        }
    }

    public static byte[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww);
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr2 = C2601sk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        byte[] bArr3 = new byte[bArr2.length + Wwwwwwwwwwwwwwwww];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, C2601sk.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.length, Wwwwwwwwwwwwwwwww);
        return bArr3;
    }
}
