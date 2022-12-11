package me.tvspark;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.just.agentweb.WebIndicator;
import java.util.Collections;
import me.tvspark.C2245j3;
import me.tvspark.C2737w4;
import org.fourthline.cling.support.model.dlna.DLNAProfiles;

/* renamed from: me.tvspark.i8 */
/* loaded from: classes4.dex */
public final class C2213i8 extends TagPayloadReader {
    public static final int[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {5512, 11025, 22050, 44100};
    public int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;

    public C2213i8(AbstractC2740w7 abstractC2740w7) {
        super(abstractC2740w7);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el, long j) throws ParserException {
        if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 2) {
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, 0, null);
            return true;
        }
        int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwwwwwwww != 0 || this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            if (this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 10 && Wwwwwwwwwwwwwwwwwwwwww != 1) {
                return false;
            }
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(j, 1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2, 0, null);
            return true;
        }
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        byte[] bArr = new byte[Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3];
        System.arraycopy(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww, bArr, 0, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3);
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww += Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3;
        C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4 = C2737w4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr);
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = "audio/mp4a-latm";
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww4.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwww = Collections.singletonList(bArr);
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) throws TagPayloadReader.UnsupportedFormatException {
        C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        int i;
        if (!this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww) {
            int Wwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwww();
            int i2 = (Wwwwwwwwwwwwwwwwwwwwww >> 4) & 15;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i2;
            if (i2 == 2) {
                i = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww[(Wwwwwwwwwwwwwwwwwwwwww >> 2) & 3];
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = 1;
            } else if (i2 == 7 || i2 == 8) {
                String str = this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww == 7 ? "audio/g711-alaw" : "audio/g711-mlaw";
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = new C2245j3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwww = str;
                wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwww = 1;
                i = WebIndicator.MAX_UNIFORM_SPEED_DURATION;
            } else {
                if (i2 != 10) {
                    throw new TagPayloadReader.UnsupportedFormatException(outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(39, "Audio format not supported: ", this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww));
                }
                this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            }
            wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwww = i;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
            this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = true;
        } else {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(1);
        }
        return true;
    }
}
