package org.apache.commons.lang3.text.translate;

import me.tvspark.outline;

/* loaded from: classes4.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    public static JavaUnicodeEscaper above(int i) {
        return outsideOf(0, i);
    }

    public static JavaUnicodeEscaper below(int i) {
        return outsideOf(i, Integer.MAX_VALUE);
    }

    public static JavaUnicodeEscaper between(int i, int i2) {
        return new JavaUnicodeEscaper(i, i2, true);
    }

    public static JavaUnicodeEscaper outsideOf(int i, int i2) {
        return new JavaUnicodeEscaper(i, i2, false);
    }

    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    public String toUtf16Escape(int i) {
        char[] chars = Character.toChars(i);
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("\\u");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CharSequenceTranslator.hex(chars[0]));
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append("\\u");
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(CharSequenceTranslator.hex(chars[1]));
        return Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
    }
}
