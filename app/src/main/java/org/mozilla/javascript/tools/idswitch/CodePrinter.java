package org.mozilla.javascript.tools.idswitch;

import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.message.TokenParser;

/* loaded from: classes5.dex */
public class CodePrinter {
    public static final int LITERAL_CHAR_MAX_SIZE = 6;
    public int offset;
    public String lineTerminator = System.lineSeparator();
    public int indentStep = 4;
    public int indentTabSize = 8;
    public char[] buffer = new char[4096];

    private int add_area(int i) {
        int ensure_area = ensure_area(i);
        this.offset = i + ensure_area;
        return ensure_area;
    }

    public static char digit_to_hex_letter(int i) {
        return (char) (i < 10 ? i + 48 : i + 55);
    }

    private int ensure_area(int i) {
        int i2 = this.offset;
        int i3 = i + i2;
        char[] cArr = this.buffer;
        if (i3 > cArr.length) {
            int length = cArr.length * 2;
            if (i3 <= length) {
                i3 = length;
            }
            char[] cArr2 = new char[i3];
            System.arraycopy(this.buffer, 0, cArr2, 0, i2);
            this.buffer = cArr2;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int put_string_literal_char(int i, int i2, boolean z) {
        if (i2 == 12) {
            i2 = 102;
        } else if (i2 != 13) {
            if (i2 != 34) {
                if (i2 != 39) {
                    switch (i2) {
                        case 8:
                            i2 = 98;
                            break;
                        case 9:
                            i2 = 116;
                            break;
                        case 10:
                            i2 = 110;
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = !z;
                }
            }
            if (!z) {
                char[] cArr = this.buffer;
                cArr[i] = '\\';
                cArr[i + 1] = (char) i2;
                return i + 2;
            } else if (32 <= i2 && i2 <= 126) {
                this.buffer[i] = (char) i2;
                return i + 1;
            } else {
                char[] cArr2 = this.buffer;
                cArr2[i] = '\\';
                cArr2[i + 1] = 'u';
                cArr2[i + 2] = digit_to_hex_letter((i2 >> 12) & 15);
                this.buffer[i + 3] = digit_to_hex_letter((i2 >> 8) & 15);
                this.buffer[i + 4] = digit_to_hex_letter((i2 >> 4) & 15);
                this.buffer[i + 5] = digit_to_hex_letter(i2 & 15);
                return i + 6;
            }
        } else {
            i2 = 114;
        }
        z = true;
        if (!z) {
        }
    }

    public void clear() {
        this.offset = 0;
    }

    public void erase(int i, int i2) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.offset - i2);
        this.offset -= i2 - i;
    }

    public int getIndentStep() {
        return this.indentStep;
    }

    public int getIndentTabSize() {
        return this.indentTabSize;
    }

    public int getLastChar() {
        int i = this.offset;
        if (i == 0) {
            return -1;
        }
        return this.buffer[i - 1];
    }

    public String getLineTerminator() {
        return this.lineTerminator;
    }

    public int getOffset() {
        return this.offset;
    }

    public void indent(int i) {
        int i2;
        int i3 = this.indentStep * i;
        int i4 = this.indentTabSize;
        if (i4 <= 0) {
            i2 = 0;
        } else {
            int i5 = i3 / i4;
            i3 = (i3 % i4) + i5;
            i2 = i5;
        }
        int add_area = add_area(i3);
        int i6 = i2 + add_area;
        int i7 = i3 + add_area;
        while (add_area != i6) {
            this.buffer[add_area] = '\t';
            add_area++;
        }
        while (add_area != i7) {
            this.buffer[add_area] = TokenParser.f4579SP;
            add_area++;
        }
    }

    public void line(int i, String str) {
        indent(i);
        m19p(str);
        m22nl();
    }

    /* renamed from: nl */
    public void m22nl() {
        m19p(getLineTerminator());
    }

    /* renamed from: p */
    public void m21p(char c) {
        this.buffer[add_area(1)] = c;
    }

    /* renamed from: p */
    public void m20p(int i) {
        m19p(Integer.toString(i));
    }

    /* renamed from: p */
    public void m19p(String str) {
        int length = str.length();
        str.getChars(0, length, this.buffer, add_area(length));
    }

    /* renamed from: p */
    public final void m18p(char[] cArr) {
        m17p(cArr, 0, cArr.length);
    }

    /* renamed from: p */
    public void m17p(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        System.arraycopy(cArr, i, this.buffer, add_area(i3), i3);
    }

    public void qchar(int i) {
        int ensure_area = ensure_area(8);
        this.buffer[ensure_area] = ExtendedMessageFormat.QUOTE;
        int put_string_literal_char = put_string_literal_char(ensure_area + 1, i, false);
        this.buffer[put_string_literal_char] = ExtendedMessageFormat.QUOTE;
        this.offset = put_string_literal_char + 1;
    }

    public void qstring(String str) {
        int length = str.length();
        int ensure_area = ensure_area((length * 6) + 2);
        this.buffer[ensure_area] = '\"';
        int i = ensure_area + 1;
        for (int i2 = 0; i2 != length; i2++) {
            i = put_string_literal_char(i, str.charAt(i2), true);
        }
        this.buffer[i] = '\"';
        this.offset = i + 1;
    }

    public void setIndentStep(int i) {
        this.indentStep = i;
    }

    public void setIndentTabSize(int i) {
        this.indentTabSize = i;
    }

    public void setLineTerminator(String str) {
        this.lineTerminator = str;
    }

    public String toString() {
        return new String(this.buffer, 0, this.offset);
    }
}
