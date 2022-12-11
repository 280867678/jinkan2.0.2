package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.UncheckedIOException;
import org.jsoup.helper.Validate;

/* loaded from: classes5.dex */
public final class CharacterReader {
    public static final char EOF = 65535;
    public static final int maxBufferLen = 32768;
    public static final int maxStringCacheLen = 12;
    public static final int minReadAheadLen = 1024;
    public static final int readAheadLimit = 24576;
    public static final int stringCacheSize = 512;
    public int bufLength;
    public int bufMark;
    public int bufPos;
    public int bufSplitPoint;
    public char[] charBuf;
    public boolean readFully;
    public Reader reader;
    public int readerPos;
    public String[] stringCache;

    public CharacterReader(Reader reader) {
        this(reader, 32768);
    }

    public CharacterReader(Reader reader, int i) {
        this.bufMark = -1;
        this.stringCache = new String[512];
        Validate.notNull(reader);
        Validate.isTrue(reader.markSupported());
        this.reader = reader;
        this.charBuf = new char[i > 32768 ? 32768 : i];
        bufferUp();
    }

    public CharacterReader(String str) {
        this(new StringReader(str), str.length());
    }

    private void bufferUp() {
        int i;
        int i2;
        boolean z;
        if (this.readFully || (i = this.bufPos) < this.bufSplitPoint) {
            return;
        }
        int i3 = this.bufMark;
        if (i3 != -1) {
            i2 = i - i3;
            i = i3;
        } else {
            i2 = 0;
        }
        try {
            long j = i;
            long skip = this.reader.skip(j);
            this.reader.mark(32768);
            int i4 = 0;
            while (true) {
                z = true;
                if (i4 > 1024) {
                    break;
                }
                int read = this.reader.read(this.charBuf, i4, this.charBuf.length - i4);
                if (read == -1) {
                    this.readFully = true;
                }
                if (read <= 0) {
                    break;
                }
                i4 += read;
            }
            this.reader.reset();
            if (i4 <= 0) {
                return;
            }
            if (skip != j) {
                z = false;
            }
            Validate.isTrue(z);
            this.bufLength = i4;
            this.readerPos += i;
            this.bufPos = i2;
            if (this.bufMark != -1) {
                this.bufMark = 0;
            }
            int i5 = this.bufLength;
            int i6 = readAheadLimit;
            if (i5 <= 24576) {
                i6 = this.bufLength;
            }
            this.bufSplitPoint = i6;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static String cacheString(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 < 1) {
            return "";
        }
        int i3 = i2 * 31;
        int i4 = 0;
        int i5 = i;
        while (i4 < i2) {
            i3 = (i3 * 31) + cArr[i5];
            i4++;
            i5++;
        }
        int i6 = i3 & 511;
        String str = strArr[i6];
        if (str == null) {
            String str2 = new String(cArr, i, i2);
            strArr[i6] = str2;
            return str2;
        } else if (rangeEquals(cArr, i, i2, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i, i2);
            strArr[i6] = str3;
            return str3;
        }
    }

    private boolean isEmptyNoBufferUp() {
        return this.bufPos >= this.bufLength;
    }

    public static boolean rangeEquals(char[] cArr, int i, int i2, String str) {
        if (i2 == str.length()) {
            int i3 = 0;
            while (true) {
                int i4 = i2 - 1;
                if (i2 == 0) {
                    return true;
                }
                int i5 = i + 1;
                int i6 = i3 + 1;
                if (cArr[i] != str.charAt(i3)) {
                    return false;
                }
                i = i5;
                i2 = i4;
                i3 = i6;
            }
        } else {
            return false;
        }
    }

    public void advance() {
        this.bufPos++;
    }

    public void close() {
        Reader reader = this.reader;
        if (reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.reader = null;
            this.charBuf = null;
            this.stringCache = null;
            throw th;
        }
        this.reader = null;
        this.charBuf = null;
        this.stringCache = null;
    }

    public char consume() {
        bufferUp();
        char c = isEmptyNoBufferUp() ? (char) 65535 : this.charBuf[this.bufPos];
        this.bufPos++;
        return c;
    }

    public String consumeData() {
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c = cArr[i3];
            if (c == 0 || c == '&' || c == '<') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    public String consumeDigitSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (c = this.charBuf[i2]) < '0' || c > '9') {
                break;
            }
            this.bufPos = i2 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    public String consumeHexSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c = this.charBuf[i2]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    public String consumeLetterSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c = this.charBuf[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.bufPos++;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    public String consumeLetterThenDigitSequence() {
        char c;
        bufferUp();
        int i = this.bufPos;
        while (true) {
            int i2 = this.bufPos;
            if (i2 >= this.bufLength || (((c = this.charBuf[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.bufPos++;
        }
        while (!isEmptyNoBufferUp()) {
            char[] cArr = this.charBuf;
            int i3 = this.bufPos;
            char c2 = cArr[i3];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.bufPos = i3 + 1;
        }
        return cacheString(this.charBuf, this.stringCache, i, this.bufPos - i);
    }

    public String consumeRawData() {
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c = cArr[i3];
            if (c == 0 || c == '<') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    public String consumeTagName() {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr = this.charBuf;
        int i3 = i;
        while (i3 < i2) {
            char c = cArr[i3];
            if (c == 0 || c == ' ' || c == '/' || c == '<' || c == '>' || c == '\t' || c == '\n' || c == '\f' || c == '\r') {
                break;
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    public String consumeTo(char c) {
        int nextIndexOf = nextIndexOf(c);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        }
        return consumeToEnd();
    }

    public String consumeTo(String str) {
        int nextIndexOf = nextIndexOf(str);
        if (nextIndexOf != -1) {
            String cacheString = cacheString(this.charBuf, this.stringCache, this.bufPos, nextIndexOf);
            this.bufPos += nextIndexOf;
            return cacheString;
        } else if (this.bufLength - this.bufPos < str.length()) {
            return consumeToEnd();
        } else {
            int length = (this.bufLength - str.length()) + 1;
            char[] cArr = this.charBuf;
            String[] strArr = this.stringCache;
            int i = this.bufPos;
            String cacheString2 = cacheString(cArr, strArr, i, length - i);
            this.bufPos = length;
            return cacheString2;
        }
    }

    public String consumeToAny(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i3 = i;
        loop0: while (i3 < i2) {
            for (char c : cArr) {
                if (cArr2[i3] == c) {
                    break loop0;
                }
            }
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    public String consumeToAnySorted(char... cArr) {
        bufferUp();
        int i = this.bufPos;
        int i2 = this.bufLength;
        char[] cArr2 = this.charBuf;
        int i3 = i;
        while (i3 < i2 && Arrays.binarySearch(cArr, cArr2[i3]) < 0) {
            i3++;
        }
        this.bufPos = i3;
        return i3 > i ? cacheString(this.charBuf, this.stringCache, i, i3 - i) : "";
    }

    public String consumeToEnd() {
        bufferUp();
        char[] cArr = this.charBuf;
        String[] strArr = this.stringCache;
        int i = this.bufPos;
        String cacheString = cacheString(cArr, strArr, i, this.bufLength - i);
        this.bufPos = this.bufLength;
        return cacheString;
    }

    public boolean containsIgnoreCase(String str) {
        return nextIndexOf(str.toLowerCase(Locale.ENGLISH)) > -1 || nextIndexOf(str.toUpperCase(Locale.ENGLISH)) > -1;
    }

    public char current() {
        bufferUp();
        if (isEmptyNoBufferUp()) {
            return (char) 65535;
        }
        return this.charBuf[this.bufPos];
    }

    public boolean isEmpty() {
        bufferUp();
        return this.bufPos >= this.bufLength;
    }

    public void mark() {
        if (this.bufLength - this.bufPos < 1024) {
            this.bufSplitPoint = 0;
        }
        bufferUp();
        this.bufMark = this.bufPos;
    }

    public boolean matchConsume(String str) {
        bufferUp();
        if (matches(str)) {
            this.bufPos = str.length() + this.bufPos;
            return true;
        }
        return false;
    }

    public boolean matchConsumeIgnoreCase(String str) {
        if (matchesIgnoreCase(str)) {
            this.bufPos = str.length() + this.bufPos;
            return true;
        }
        return false;
    }

    public boolean matches(char c) {
        return !isEmpty() && this.charBuf[this.bufPos] == c;
    }

    public boolean matches(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.charBuf[this.bufPos + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAny(char... cArr) {
        if (isEmpty()) {
            return false;
        }
        bufferUp();
        char c = this.charBuf[this.bufPos];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public boolean matchesAnySorted(char[] cArr) {
        bufferUp();
        return !isEmpty() && Arrays.binarySearch(cArr, this.charBuf[this.bufPos]) >= 0;
    }

    public boolean matchesDigit() {
        char c;
        return !isEmpty() && (c = this.charBuf[this.bufPos]) >= '0' && c <= '9';
    }

    public boolean matchesIgnoreCase(String str) {
        bufferUp();
        int length = str.length();
        if (length > this.bufLength - this.bufPos) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.charBuf[this.bufPos + i])) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesLetter() {
        if (isEmpty()) {
            return false;
        }
        char c = this.charBuf[this.bufPos];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    public int nextIndexOf(char c) {
        bufferUp();
        for (int i = this.bufPos; i < this.bufLength; i++) {
            if (c == this.charBuf[i]) {
                return i - this.bufPos;
            }
        }
        return -1;
    }

    public int nextIndexOf(CharSequence charSequence) {
        bufferUp();
        char charAt = charSequence.charAt(0);
        int i = this.bufPos;
        while (i < this.bufLength) {
            if (charAt != this.charBuf[i]) {
                do {
                    i++;
                    if (i >= this.bufLength) {
                        break;
                    }
                } while (charAt != this.charBuf[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            int i3 = this.bufLength;
            if (i < i3 && length <= i3) {
                int i4 = i2;
                for (int i5 = 1; i4 < length && charSequence.charAt(i5) == this.charBuf[i4]; i5++) {
                    i4++;
                }
                if (i4 == length) {
                    return i - this.bufPos;
                }
            }
            i = i2;
        }
        return -1;
    }

    public int pos() {
        return this.readerPos + this.bufPos;
    }

    public boolean rangeEquals(int i, int i2, String str) {
        return rangeEquals(this.charBuf, i, i2, str);
    }

    public void rewindToMark() {
        int i = this.bufMark;
        if (i != -1) {
            this.bufPos = i;
            unmark();
            return;
        }
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    public String toString() {
        if (this.bufLength - this.bufPos < 0) {
            return "";
        }
        char[] cArr = this.charBuf;
        int i = this.bufPos;
        return new String(cArr, i, this.bufLength - i);
    }

    public void unconsume() {
        int i = this.bufPos;
        if (i >= 1) {
            this.bufPos = i - 1;
            return;
        }
        throw new UncheckedIOException(new IOException("No buffer left to unconsume"));
    }

    public void unmark() {
        this.bufMark = -1;
    }
}
