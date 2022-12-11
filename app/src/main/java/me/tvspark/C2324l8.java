package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import me.tvspark.C2245j3;

/* renamed from: me.tvspark.l8 */
/* loaded from: classes4.dex */
public final class C2324l8 extends TagPayloadReader {
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(C1987cl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
    public final C2078el Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2078el(4);

    public C2324l8(AbstractC2740w7 abstractC2740w7) {
        super(abstractC2740w7);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) throws ParserException {
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        byte[] bArr = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i2 = i + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
        int i3 = i2 + 1;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3;
        int i4 = (((bArr[i] & 255) << 24) >> 8) | ((bArr[i2] & 255) << 8);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i3 + 1;
        long j2 = (((bArr[i3] & 255) | i4) * 1000) + j;
        if (Wwwwwwwwwwwwwwwwwwwwww == 0 && !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            C2078el c2078el2 = new C2078el(new byte[c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()]);
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            C2717vl Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2717vl.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "video/avc";
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return false;
        } else if (Wwwwwwwwwwwwwwwwwwwwww != 1 || !this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            return false;
        } else {
            int i5 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww == 1 ? 1 : 0;
            if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww && i5 == 0) {
                return false;
            }
            byte[] bArr2 = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i6 = 4 - this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int i7 = 0;
            while (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
                c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i6, this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                int Wwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwww();
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(0);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 4);
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwww);
                i7 = i7 + 4 + Wwwwwwwwwwwwwwwwwww;
            }
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j2, i5, i7, 0, null);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws TagPayloadReader.UnsupportedFormatException {
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        int i = (Wwwwwwwwwwwwwwwwwwwwww >> 4) & 15;
        int i2 = Wwwwwwwwwwwwwwwwwwwwww & 15;
        if (i2 == 7) {
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
            return i != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(39, "Video format not supported: ", i2));
    }
}
