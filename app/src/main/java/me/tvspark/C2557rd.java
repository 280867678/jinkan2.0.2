package me.tvspark;

import java.nio.ByteBuffer;
import me.tvspark.C2254jc;

/* renamed from: me.tvspark.rd */
/* loaded from: classes4.dex */
public final class C2557rd extends AbstractC2519qc {
    public C2337ll Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el();
    public final C2041dl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2041dl();

    @Override // me.tvspark.AbstractC2519qc
    public C2254jc Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2402nc c2402nc, ByteBuffer byteBuffer) {
        C2337ll c2337ll = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        if (c2337ll == null || c2402nc.Wwwwwwwwwwwwwwwww != c2337ll.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()) {
            C2337ll c2337ll2 = new C2337ll(c2402nc.Wwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2337ll2;
            c2337ll2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2402nc.Wwwwwwwwwwwwwwwwwwwww - c2402nc.Wwwwwwwwwwwwwwwww);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(array, limit);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(array, limit);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(39);
        long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(1) << 32) | this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(32);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(20);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(12);
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
        C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(14);
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 0) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2631td();
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 255) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2477pd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 4) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2668ud.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 5) {
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2594sd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 6) {
            C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2337ll c2337ll3 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            long Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2706vd.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2706vd(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4, c2337ll3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4));
        }
        return wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == null ? new C2254jc(new C2254jc.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww[0]) : new C2254jc(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    }
}
