package org.apache.commons.lang3.text;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.TokenParser;

/* loaded from: classes4.dex */
public abstract class StrMatcher {
    public static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    public static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    public static final StrMatcher SPACE_MATCHER = new CharMatcher(TokenParser.f4579SP);
    public static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    public static final StrMatcher TRIM_MATCHER = new TrimMatcher();
    public static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher(ExtendedMessageFormat.QUOTE);
    public static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher('\"');
    public static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    public static final StrMatcher NONE_MATCHER = new NoMatcher();

    /* loaded from: classes4.dex */
    public static final class CharMatcher extends StrMatcher {

        /* renamed from: ch */
        public final char f4556ch;

        public CharMatcher(char c) {
            this.f4556ch = c;
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return this.f4556ch == cArr[i] ? 1 : 0;
        }
    }

    /* loaded from: classes4.dex */
    public static final class CharSetMatcher extends StrMatcher {
        public final char[] chars;

        public CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return Arrays.binarySearch(this.chars, cArr[i]) >= 0 ? 1 : 0;
        }
    }

    /* loaded from: classes4.dex */
    public static final class NoMatcher extends StrMatcher {
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public static final class StringMatcher extends StrMatcher {
        public final char[] chars;

        public StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            int length = this.chars.length;
            if (i + length > i3) {
                return 0;
            }
            int i4 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i4 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i4] != cArr[i]) {
                    return 0;
                }
                i4++;
                i++;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class TrimMatcher extends StrMatcher {
        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i, int i2, int i3) {
            return cArr[i] <= ' ' ? 1 : 0;
        }
    }

    public static StrMatcher charMatcher(char c) {
        return new CharMatcher(c);
    }

    public static StrMatcher charSetMatcher(String str) {
        return StringUtils.isEmpty(str) ? NONE_MATCHER : str.length() == 1 ? new CharMatcher(str.charAt(0)) : new CharSetMatcher(str.toCharArray());
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        return (cArr == null || cArr.length == 0) ? NONE_MATCHER : cArr.length == 1 ? new CharMatcher(cArr[0]) : new CharSetMatcher(cArr);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        return StringUtils.isEmpty(str) ? NONE_MATCHER : new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i) {
        return isMatch(cArr, i, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i, int i2, int i3);
}
