package org.apache.commons.lang3;

/* loaded from: classes4.dex */
public class CharUtils {
    public static final String[] CHAR_STRING_ARRAY = new String[128];

    /* renamed from: CR */
    public static final char f4550CR = '\r';

    /* renamed from: LF */
    public static final char f4551LF = '\n';

    static {
        char c = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c < strArr.length) {
                strArr[c] = String.valueOf(c);
                c = (char) (c + 1);
            } else {
                return;
            }
        }
    }

    public static boolean isAscii(char c) {
        return c < 128;
    }

    public static boolean isAsciiAlpha(char c) {
        return isAsciiAlphaUpper(c) || isAsciiAlphaLower(c);
    }

    public static boolean isAsciiAlphaLower(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c) {
        return isAsciiAlpha(c) || isAsciiNumeric(c);
    }

    public static boolean isAsciiControl(char c) {
        return c < ' ' || c == 127;
    }

    public static boolean isAsciiNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isAsciiPrintable(char c) {
        return c >= ' ' && c < 127;
    }

    public static char toChar(Character ch) {
        if (ch != null) {
            return ch.charValue();
        }
        throw new IllegalArgumentException("The Character must not be null");
    }

    public static char toChar(Character ch, char c) {
        return ch == null ? c : ch.charValue();
    }

    public static char toChar(String str) {
        if (!StringUtils.isEmpty(str)) {
            return str.charAt(0);
        }
        throw new IllegalArgumentException("The String must not be empty");
    }

    public static char toChar(String str, char c) {
        return StringUtils.isEmpty(str) ? c : str.charAt(0);
    }

    @Deprecated
    public static Character toCharacterObject(char c) {
        return Character.valueOf(c);
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static int toIntValue(char c) {
        if (isAsciiNumeric(c)) {
            return c - '0';
        }
        throw new IllegalArgumentException("The character " + c + " is not in the range '0' - '9'");
    }

    public static int toIntValue(char c, int i) {
        return !isAsciiNumeric(c) ? i : c - '0';
    }

    public static int toIntValue(Character ch) {
        if (ch != null) {
            return toIntValue(ch.charValue());
        }
        throw new IllegalArgumentException("The character must not be null");
    }

    public static int toIntValue(Character ch, int i) {
        return ch == null ? i : toIntValue(ch.charValue(), i);
    }

    public static String toString(char c) {
        return c < 128 ? CHAR_STRING_ARRAY[c] : new String(new char[]{c});
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static String unicodeEscaped(char c) {
        StringBuilder sb;
        String str;
        if (c < 16) {
            sb = new StringBuilder();
            str = "\\u000";
        } else if (c < 256) {
            sb = new StringBuilder();
            str = "\\u00";
        } else if (c < 4096) {
            sb = new StringBuilder();
            str = "\\u0";
        } else {
            sb = new StringBuilder();
            str = "\\u";
        }
        sb.append(str);
        sb.append(Integer.toHexString(c));
        return sb.toString();
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }
}
