package me.tvspark;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* renamed from: me.tvspark.sc */
/* loaded from: classes4.dex */
public final class C2593sc extends AbstractC2519qc {
    @Override // me.tvspark.AbstractC2519qc
    @Nullable
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            C2041dl c2041dl = new C2041dl(byteBuffer.array(), byteBuffer.limit());
            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12)) - 4;
            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(44);
            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12));
            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
            ArrayList arrayList = new ArrayList();
            while (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(48);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
                int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
                String str = null;
                String str2 = null;
                while (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2) {
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 2) {
                        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(16);
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 != 3) {
                        }
                        while (c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3) {
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                            Charset charset = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                            byte[] bArr = new byte[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5];
                            c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww5);
                            str = new String(bArr, charset);
                            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6 = c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
                            for (int i = 0; i < Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww6; i++) {
                                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8));
                            }
                        }
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 21) {
                        Charset charset2 = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                        byte[] bArr2 = new byte[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
                        c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr2, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
                        str2 = new String(bArr2, charset2);
                    }
                    c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 * 8);
                }
                c2041dl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 * 8);
                if (str != null && str2 != null) {
                    arrayList.add(new C2556rc(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, str2.length() != 0 ? str.concat(str2) : new String(str)));
                }
            }
            if (!arrayList.isEmpty()) {
                return new C2254jc(arrayList);
            }
        }
        return null;
    }
}
