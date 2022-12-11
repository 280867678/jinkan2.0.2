package me.tvspark;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: me.tvspark.gi */
/* loaded from: classes4.dex */
public final class C2149gi extends AbstractC2823yg {
    public int Wwwwwwwwwwwwwww;
    public float Wwwwwwwwwwwwwwww;
    public String Wwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwww;
    public int Wwwwwwwwwwwwwwwwwww;
    public boolean Wwwwwwwwwwwwwwwwwwww;
    public final C2078el Wwwwwwwwwwwwwwwwwwwww = new C2078el();

    public C2149gi(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = TypefaceCompatApi28Impl.DEFAULT_FAMILY;
        boolean z = false;
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.Wwwwwwwwwwwwwwwwwww = bArr[24];
            this.Wwwwwwwwwwwwwwwwww = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.Wwwwwwwwwwwwwwwww = "Serif".equals(C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(bArr, 43, bArr.length - 43)) ? "serif" : str;
            this.Wwwwwwwwwwwwwww = bArr[25] * 20;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.Wwwwwwwwwwwwwwwwwwww = z;
            if (z) {
                float f = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.Wwwwwwwwwwwwwww;
                this.Wwwwwwwwwwwwwwww = f;
                this.Wwwwwwwwwwwwwwww = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(f, 0.0f, 0.95f);
                return;
            }
        } else {
            this.Wwwwwwwwwwwwwwwwwww = 0;
            this.Wwwwwwwwwwwwwwwwww = -1;
            this.Wwwwwwwwwwwwwwwww = str;
            this.Wwwwwwwwwwwwwwwwwwww = false;
        }
        this.Wwwwwwwwwwwwwwww = 0.85f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        StyleSpan styleSpan;
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (!z2) {
                if (z3) {
                    styleSpan = new StyleSpan(2);
                }
                if ((i & 4) == 0) {
                    z = false;
                }
                if (z) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
                }
                if (z || z2 || z3) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
                return;
            }
            styleSpan = z3 ? new StyleSpan(3) : new StyleSpan(1);
            spannableStringBuilder.setSpan(styleSpan, i3, i4, i6);
            if ((i & 4) == 0) {
            }
            if (z) {
            }
            if (z) {
            }
        }
    }

    public static void Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) throws SubtitleDecoderException {
        if (z) {
            return;
        }
        throw new SubtitleDecoderException("Unexpected subtitle format.");
    }

    @Override // me.tvspark.AbstractC2823yg
    public AbstractC1909ah Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        Charset charset;
        String Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
        C2078el c2078el = this.Wwwwwwwwwwwwwwwwwwwww;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = bArr;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = i;
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = 0;
        int i2 = 1;
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 2);
        int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
        if (Wwwwwwwwwwwwwwwww == 0) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = "";
        } else {
            if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 2) {
                byte[] bArr2 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                int i3 = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                char c = (char) ((bArr2[i3 + 1] & 255) | ((bArr2[i3] & 255) << 8));
                if (c == 65279 || c == 65534) {
                    charset = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww, charset);
                }
            }
            charset = C2160gt.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwww, charset);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.isEmpty()) {
            return C2186hi.Wwwwwwwwwwwwwwwwwwwwwww;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, this.Wwwwwwwwwwwwwwwwwww, 0, 0, spannableStringBuilder.length(), ItemTouchHelper.ACTION_MODE_DRAG_MASK);
        int i4 = this.Wwwwwwwwwwwwwwwwww;
        int length = spannableStringBuilder.length();
        if (i4 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i4 >>> 8) | ((i4 & 255) << 24)), 0, length, 16711713);
        }
        String str = this.Wwwwwwwwwwwwwwwww;
        int length2 = spannableStringBuilder.length();
        if (str != TypefaceCompatApi28Impl.DEFAULT_FAMILY) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length2, 16711713);
        }
        float f = this.Wwwwwwwwwwwwwwww;
        while (this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 8) {
            C2078el c2078el2 = this.Wwwwwwwwwwwwwwwwwwwww;
            int i5 = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww;
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1937013100) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 2);
                int Wwwwwwwwwwwwwwwww2 = this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww();
                int i6 = 0;
                while (i6 < Wwwwwwwwwwwwwwwww2) {
                    C2078el c2078el3 = this.Wwwwwwwwwwwwwwwwwwwww;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 12);
                    int Wwwwwwwwwwwwwwwww3 = c2078el3.Wwwwwwwwwwwwwwwww();
                    int Wwwwwwwwwwwwwwwww4 = c2078el3.Wwwwwwwwwwwwwwwww();
                    c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(2);
                    int Wwwwwwwwwwwwwwwwwwwwww = c2078el3.Wwwwwwwwwwwwwwwwwwwwww();
                    c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(i2);
                    int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = c2078el3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    int i7 = i6;
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(spannableStringBuilder, Wwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwww, Wwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwww4, 0);
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 != this.Wwwwwwwwwwwwwwwwww) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 >>> 8) | ((Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 & 255) << 24)), Wwwwwwwwwwwwwwwww3, Wwwwwwwwwwwwwwwww4, 33);
                    }
                    i6 = i7 + 1;
                    i2 = 1;
                }
            } else if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 == 1952608120 && this.Wwwwwwwwwwwwwwwwwwww) {
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() >= 2);
                f = C2374ml.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwww() / this.Wwwwwwwwwwwwwww, 0.0f, 0.95f);
            }
            this.Wwwwwwwwwwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i5 + Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww);
            i2 = 1;
        }
        return new C2186hi(new C2786xg(spannableStringBuilder, null, null, f, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, -16777216, Integer.MIN_VALUE, null));
    }
}
