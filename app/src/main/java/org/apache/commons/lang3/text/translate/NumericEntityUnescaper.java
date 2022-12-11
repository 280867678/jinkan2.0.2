package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;

/* loaded from: classes4.dex */
public class NumericEntityUnescaper extends CharSequenceTranslator {
    public final EnumSet<OPTION> options;

    /* loaded from: classes4.dex */
    public enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon
    }

    public NumericEntityUnescaper(OPTION... optionArr) {
        this.options = EnumSet.copyOf((Collection) (optionArr.length > 0 ? Arrays.asList(optionArr) : Arrays.asList(OPTION.semiColonRequired)));
    }

    public boolean isSet(OPTION option) {
        EnumSet<OPTION> enumSet = this.options;
        if (enumSet == null) {
            return false;
        }
        return enumSet.contains(option);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        if (r8.charAt(r3) != ';') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        r0 = 1;
     */
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
        int i2;
        int length = charSequence.length();
        if (charSequence.charAt(i) == '&' && i < length - 2 && charSequence.charAt(i + 1) == '#') {
            int i3 = i + 2;
            char charAt = charSequence.charAt(i3);
            if (charAt == 'x' || charAt == 'X') {
                i3++;
                if (i3 == length) {
                    return 0;
                }
                i2 = 1;
            } else {
                i2 = 0;
            }
            int i4 = i3;
            while (i4 < length && ((charSequence.charAt(i4) >= '0' && charSequence.charAt(i4) <= '9') || ((charSequence.charAt(i4) >= 'a' && charSequence.charAt(i4) <= 'f') || (charSequence.charAt(i4) >= 'A' && charSequence.charAt(i4) <= 'F')))) {
                i4++;
            }
            int i5 = 0;
            if (i5 == 0) {
                if (isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                int parseInt = i2 != 0 ? Integer.parseInt(charSequence.subSequence(i3, i4).toString(), 16) : Integer.parseInt(charSequence.subSequence(i3, i4).toString(), 10);
                char c = parseInt;
                if (parseInt > 65535) {
                    char[] chars = Character.toChars(parseInt);
                    writer.write(chars[0]);
                    c = chars[1];
                }
                writer.write(c);
                return ((i4 + 2) - i3) + i2 + i5;
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }
}
