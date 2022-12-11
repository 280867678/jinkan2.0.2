package org.apache.commons.lang3;

import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c : str.toCharArray()) {
                if (charSet.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i = 0;
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                i++;
            }
        }
        return i;
    }

    public static boolean deepEmpty(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (StringUtils.isNotEmpty(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    public static String modify(String str, String[] strArr, boolean z) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charSet.contains(charArray[i]) == z) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = TokenParser.f4579SP;
        for (int i = 0; i < length; i++) {
            char c2 = charArray[i];
            if (c2 != c || i == 0 || !charSet.contains(c2)) {
                sb.append(c2);
                c = c2;
            }
        }
        return sb.toString();
    }
}
