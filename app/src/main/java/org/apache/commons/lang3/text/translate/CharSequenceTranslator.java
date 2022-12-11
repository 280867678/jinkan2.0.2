package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class CharSequenceTranslator {
    public static String hex(int i) {
        return Integer.toHexString(i).toUpperCase(Locale.ENGLISH);
    }

    public abstract int translate(CharSequence charSequence, int i, Writer writer) throws IOException;

    public final String translate(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(charSequence.length() * 2);
            translate(charSequence, stringWriter);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final void translate(CharSequence charSequence, Writer writer) throws IOException {
        if (writer != null) {
            if (charSequence == null) {
                return;
            }
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int translate = translate(charSequence, i, writer);
                if (translate == 0) {
                    char[] chars = Character.toChars(Character.codePointAt(charSequence, i));
                    writer.write(chars);
                    i += chars.length;
                } else {
                    for (int i2 = 0; i2 < translate; i2++) {
                        i += Character.charCount(Character.codePointAt(charSequence, i));
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("The Writer must not be null");
    }

    public final CharSequenceTranslator with(CharSequenceTranslator... charSequenceTranslatorArr) {
        CharSequenceTranslator[] charSequenceTranslatorArr2 = new CharSequenceTranslator[charSequenceTranslatorArr.length + 1];
        charSequenceTranslatorArr2[0] = this;
        System.arraycopy(charSequenceTranslatorArr, 0, charSequenceTranslatorArr2, 1, charSequenceTranslatorArr.length);
        return new AggregateTranslator(charSequenceTranslatorArr2);
    }
}
