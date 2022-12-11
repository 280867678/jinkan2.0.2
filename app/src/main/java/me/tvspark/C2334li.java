package me.tvspark;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;
import me.tvspark.C2786xg;

/* renamed from: me.tvspark.li */
/* loaded from: classes4.dex */
public final class C2334li extends AbstractC2823yg {
    public final C2078el Wwwwwwwwwwwwwwwwwwwww = new C2078el();

    public C2334li() {
        super("Mp4WebvttDecoder");
    }

    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        C2786xg Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        ArrayList arrayList = new ArrayList();
        while (this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() > 0) {
            if (this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1987343459) {
                C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwww;
                int i2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 8;
                CharSequence charSequence = null;
                C2786xg.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = null;
                while (i2 > 0) {
                    if (i2 < 8) {
                        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
                    }
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int i3 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 - 8;
                    String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, i3);
                    c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i3);
                    i2 = (i2 - 8) - i3;
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 1937011815) {
                        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2482pi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
                    } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 == 1885436268) {
                        charSequence = C2482pi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((String) null, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.trim(), Collections.emptyList());
                    }
                }
                if (charSequence == null) {
                    charSequence = "";
                }
                if (wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww != null) {
                    wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = charSequence;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                } else {
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = C2482pi.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(charSequence);
                }
                arrayList.add(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            } else {
                this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 8);
            }
        }
        return new C2371mi(arrayList);
    }
}
