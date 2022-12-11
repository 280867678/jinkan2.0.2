package org.jsoup.parser;

import me.tvspark.outline;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;

/* loaded from: classes5.dex */
public class TokenQueue {
    public static final char ESC = '\\';
    public int pos = 0;
    public String queue;

    public TokenQueue(String str) {
        Validate.notNull(str);
        this.queue = str;
    }

    private int remainingLength() {
        return this.queue.length() - this.pos;
    }

    public static String unescape(String str) {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\' || (c != 0 && c == '\\')) {
                borrowBuilder.append(c2);
            }
            i++;
            c = c2;
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public void addFirst(Character ch) {
        addFirst(ch.toString());
    }

    public void addFirst(String str) {
        StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str);
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.append(this.queue.substring(this.pos));
        this.queue = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.toString();
        this.pos = 0;
    }

    public void advance() {
        if (!isEmpty()) {
            this.pos++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[EDGE_INSN: B:14:0x0048->B:15:0x0048 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String chompBalanced(char c, char c2) {
        char c3 = 0;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (!isEmpty()) {
            char consume = consume();
            if (c3 == 0 || c3 != '\\') {
                if (consume == '\'' && consume != c && !z) {
                    z2 = !z2;
                } else if (consume == '\"' && consume != c && !z2) {
                    z = !z;
                }
                if (!z2 && !z) {
                    if (consume == c) {
                        i++;
                        if (i2 == -1) {
                            i2 = this.pos;
                        }
                    } else if (consume == c2) {
                        i--;
                    }
                }
                if (i <= 0) {
                    break;
                }
            }
            if (i > 0 && c3 != 0) {
                i3 = this.pos;
            }
            c3 = consume;
            continue;
            if (i <= 0) {
            }
        }
        String substring = i3 >= 0 ? this.queue.substring(i2, i3) : "";
        if (i > 0) {
            Validate.fail("Did not find balanced marker at '" + substring + "'");
        }
        return substring;
    }

    public String chompTo(String str) {
        String consumeTo = consumeTo(str);
        matchChomp(str);
        return consumeTo;
    }

    public String chompToIgnoreCase(String str) {
        String consumeToIgnoreCase = consumeToIgnoreCase(str);
        matchChomp(str);
        return consumeToIgnoreCase;
    }

    public char consume() {
        String str = this.queue;
        int i = this.pos;
        this.pos = i + 1;
        return str.charAt(i);
    }

    public void consume(String str) {
        if (matches(str)) {
            int length = str.length();
            if (length > remainingLength()) {
                throw new IllegalStateException("Queue not long enough to consume sequence");
            }
            this.pos += length;
            return;
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public String consumeAttributeKey() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_', ':'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeCssIdentifier() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny('-', '_'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeElementSelector() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny("*|", "|", "_", "-"))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeTagName() {
        int i = this.pos;
        while (!isEmpty() && (matchesWord() || matchesAny(':', '_', '-'))) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeTo(String str) {
        int indexOf = this.queue.indexOf(str, this.pos);
        if (indexOf != -1) {
            String substring = this.queue.substring(this.pos, indexOf);
            this.pos = substring.length() + this.pos;
            return substring;
        }
        return remainder();
    }

    public String consumeToAny(String... strArr) {
        int i = this.pos;
        while (!isEmpty() && !matchesAny(strArr)) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public String consumeToIgnoreCase(String str) {
        int i;
        int i2;
        int i3 = this.pos;
        String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!isEmpty() && !matches(str)) {
            if (equals) {
                int indexOf = this.queue.indexOf(substring, this.pos);
                int i4 = this.pos;
                int i5 = indexOf - i4;
                if (i5 == 0) {
                    i2 = i4 + 1;
                } else if (i5 < 0) {
                    i = this.queue.length();
                } else {
                    i2 = i4 + i5;
                }
                this.pos = i2;
            } else {
                i = this.pos + 1;
            }
            this.pos = i;
        }
        return this.queue.substring(i3, this.pos);
    }

    public boolean consumeWhitespace() {
        boolean z = false;
        while (matchesWhitespace()) {
            this.pos++;
            z = true;
        }
        return z;
    }

    public String consumeWord() {
        int i = this.pos;
        while (matchesWord()) {
            this.pos++;
        }
        return this.queue.substring(i, this.pos);
    }

    public boolean isEmpty() {
        return remainingLength() == 0;
    }

    public boolean matchChomp(String str) {
        if (matches(str)) {
            this.pos = str.length() + this.pos;
            return true;
        }
        return false;
    }

    public boolean matches(String str) {
        return this.queue.regionMatches(true, this.pos, str, 0, str.length());
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        for (char c : cArr) {
            if (this.queue.charAt(this.pos) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesAny(String... strArr) {
        for (String str : strArr) {
            if (matches(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesCS(String str) {
        return this.queue.startsWith(str, this.pos);
    }

    public boolean matchesStartTag() {
        return remainingLength() >= 2 && this.queue.charAt(this.pos) == '<' && Character.isLetter(this.queue.charAt(this.pos + 1));
    }

    public boolean matchesWhitespace() {
        return !isEmpty() && StringUtil.isWhitespace(this.queue.charAt(this.pos));
    }

    public boolean matchesWord() {
        return !isEmpty() && Character.isLetterOrDigit(this.queue.charAt(this.pos));
    }

    public char peek() {
        if (isEmpty()) {
            return (char) 0;
        }
        return this.queue.charAt(this.pos);
    }

    public String remainder() {
        String str = this.queue;
        String substring = str.substring(this.pos, str.length());
        this.pos = this.queue.length();
        return substring;
    }

    public String toString() {
        return this.queue.substring(this.pos);
    }
}
