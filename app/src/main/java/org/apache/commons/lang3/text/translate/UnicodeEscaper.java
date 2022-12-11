package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import me.tvspark.outline;

/* loaded from: classes4.dex */
public class UnicodeEscaper extends CodePointTranslator {
    public final int above;
    public final int below;
    public final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public UnicodeEscaper(int i, int i2, boolean z) {
        this.below = i;
        this.above = i2;
        this.between = z;
    }

    public static UnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    public static UnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i, int i2) {
        return new UnicodeEscaper(i, i2, true);
    }

    public static UnicodeEscaper outsideOf(int i, int i2) {
        return new UnicodeEscaper(i, i2, false);
    }

    public String toUtf16Escape(int i) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\u");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CharSequenceTranslator.hex(i));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i, Writer writer) throws IOException {
        StringBuilder sb;
        String str;
        String sb2;
        if (this.between) {
            if (i < this.below || i > this.above) {
                return false;
            }
        } else if (i >= this.below && i <= this.above) {
            return false;
        }
        if (i > 65535) {
            sb2 = toUtf16Escape(i);
        } else {
            if (i > 4095) {
                sb = new StringBuilder();
                str = "\\u";
            } else if (i > 255) {
                sb = new StringBuilder();
                str = "\\u0";
            } else if (i > 15) {
                sb = new StringBuilder();
                str = "\\u00";
            } else {
                sb = new StringBuilder();
                str = "\\u000";
            }
            sb.append(str);
            sb.append(CharSequenceTranslator.hex(i));
            sb2 = sb.toString();
        }
        writer.write(sb2);
        return true;
    }
}
